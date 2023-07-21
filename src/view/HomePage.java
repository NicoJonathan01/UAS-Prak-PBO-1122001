package view;

import model.User;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DatabaseController;

import java.awt.Font;

public class HomePage extends JFrame{
    private User user;

    public HomePage(User user){
        this.user = user;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(10, 15, 40, 0));

        JPanel headerPanel = new JPanel();
        //headerPanel.setSize(800, 70);

        JLabel title = new JLabel("Welcome " + user.getName());
        title.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(title);

        JPanel inputPanel = new JPanel();
        //inputPanel.setSize(800, 730);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));

        JLabel labelTodo = new JLabel();
        user.setTodoList(DatabaseController.getTodoList(user.getId()));
        labelTodo.setText(user.getTodoList().toString());

        inputPanel.add(labelTodo);

        contentPanel.add(headerPanel);
        contentPanel.add(inputPanel);
        this.add(contentPanel);
        this.setVisible(true);
    }
}
