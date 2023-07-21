package view;

import controller.DatabaseController;
import model.User;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame{
    public LoginScreen(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(10, 15, 40, 0));

        JPanel headerPanel = new JPanel();
        //headerPanel.setSize(800, 70);

        JLabel title = new JLabel("Login Menu");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(title);

        JPanel inputPanel = new JPanel();
        //inputPanel.setSize(800, 730);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
   
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(2, 1));

        JLabel labelEmail = new JLabel("Email: ");
        JLabel labelPassword = new JLabel("Password: ");

        leftPanel.add(labelEmail);
        leftPanel.add(labelPassword);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(2, 1));

        JTextField inputEmail = new JTextField();
        JPasswordField inputPassword = new JPasswordField();

        rightPanel.add(inputEmail);
        rightPanel.add(inputPassword);

        inputPanel.add(leftPanel);
        inputPanel.add(rightPanel);

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");

        ActionListener loginListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] passwordChars = inputPassword.getPassword();
                String password = new String(passwordChars);

                User user = DatabaseController.getUser(inputEmail.getText(), password);
                if(user != null){
                    new HomePage(user);
                }else{
                    JOptionPane.showMessageDialog(null, "Login Gagal");
                }
            }
        };
        loginButton.addActionListener(loginListener);

        JFrame frame = this;
        ActionListener backListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LandingPage();
                frame.dispose();
            }
        };
        backButton.addActionListener(backListener);

        footerPanel.add(loginButton);
        footerPanel.add(backButton);

        contentPanel.add(headerPanel);
        contentPanel.add(inputPanel);
        contentPanel.add(footerPanel);

        this.add(contentPanel);
        this.setVisible(true);
    }

    // public static void main(String[] args) {
    //     new LoginScreen();
    // }
}
