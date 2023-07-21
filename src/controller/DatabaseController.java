/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.User;
import model.Todo;
/**
 *
 * @author hanschristian
 */
public class DatabaseController {

    static DatabaseHandler conn = new DatabaseHandler();

    public static ArrayList<Todo> getTodoList(int userID){
        ArrayList<Todo> todoList = new ArrayList<>();
        try {
            conn.connect();
            String query = "SELECT * FROM todo WHERE userId='" + userID + "'";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setTitle(rs.getString("title"));
                todo.setNote(rs.getString("note"));
                todo.setUser(getUserByID(userID));

                todoList.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (todoList);
    }

    public static User getUserByID(int id) {
        conn.connect();
        String query = "SELECT * FROM users WHERE id='" + id + "'";
        User user = null;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(new Date(rs.getDate("birthday").getTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);
    }

    // SELECT WHERE
    public static User getUser(String email, String password) {
        conn.connect();
        String query = "SELECT * FROM users WHERE email='" + email + "' AND password='" + password + "'";
        User user = null;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(new Date(rs.getDate("birthday").getTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);
    }
    
    // INSERT
    public static boolean insertNewUser(User user) {
        conn.connect();
        String query = "INSERT INTO users (name, email, password, gender, birthday, photo) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getGender());
            stmt.setDate(5, new java.sql.Date(user.getBirthday().getTime()));
            stmt.setString(6, user.getPhoto());

            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

}
