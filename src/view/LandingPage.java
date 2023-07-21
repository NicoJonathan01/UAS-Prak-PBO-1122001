package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;

public class LandingPage extends JFrame{
    public LandingPage(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(10, 15, 40, 0));

        JPanel headerPanel = new JPanel();
        headerPanel.setSize(800, 70);

        JLabel title = new JLabel("Landing Page");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(title);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        ActionListener loginListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginScreen();
            }
        };
        loginButton.addActionListener(loginListener);

        ActionListener registerListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterScreen();
            }
        };
        registerButton.addActionListener(registerListener);

        inputPanel.add(loginButton);
        inputPanel.add(registerButton);

        contentPanel.add(headerPanel);
        contentPanel.add(inputPanel);
        this.add(contentPanel);
        this.setVisible(true);
    }
}
