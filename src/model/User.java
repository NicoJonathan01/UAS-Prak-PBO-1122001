package model;

import java.util.Date;
import java.util.ArrayList;

public class User implements GenderInterface{
    private int id;
    private String name;
    private String email;
    private String password;
    private int gender;
    private Date birthday;
    private String photo;
    private ArrayList<Todo> todoList;

    public User(){

    }
    
    public User(int id, String name, String email, String password, int gender, Date birthday, String photo, ArrayList<Todo> todoList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.photo = photo;
        this.todoList = todoList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date date) {
        this.birthday = date;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public ArrayList<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(ArrayList<Todo> todoList) {
        this.todoList = todoList;
    }

        
}
