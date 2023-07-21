package view;

import controller.DatabaseController;
import model.User;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class RegisterScreen extends JFrame{

    private User user;
    private String filePathPhoto;

    public RegisterScreen(){
        this.user = new User();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(10, 15, 40, 0));

        JPanel headerPanel = new JPanel();
        headerPanel.setSize(800, 70);

        JLabel title = new JLabel("Login Menu");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(title);

        JPanel inputPanel = new JPanel();   
        inputPanel.setSize(800, 730);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
   
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(6, 1));

        JLabel labelEmail = new JLabel("Email: ");
        JLabel labelNama = new JLabel("Nama: ");
        JLabel labelPassword = new JLabel("Password: ");
        JLabel labelGender = new JLabel("Gender: ");
        JLabel labelBirthday = new JLabel("Birthday: ");
        JLabel labelPhoto = new JLabel("Photo: ");
        

        leftPanel.add(labelEmail);
        leftPanel.add(labelNama);
        leftPanel.add(labelPassword);
        leftPanel.add(labelGender);
        leftPanel.add(labelBirthday);
        leftPanel.add(labelPhoto);


        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(6, 1));

        JTextField inputEmail = new JTextField();
        JTextField inputNama = new JTextField();
        JPasswordField inputPassword = new JPasswordField();

        JPanel radioPanelGender = new JPanel();
        radioPanelGender.setLayout(new FlowLayout(FlowLayout.LEFT));

        JRadioButton male = new JRadioButton("MALE");
        JRadioButton female = new JRadioButton("FEMALE");


        ButtonGroup buttonGroupJK = new ButtonGroup();
        buttonGroupJK.add(male);
        buttonGroupJK.add(female);

        radioPanelGender.add(male);
        radioPanelGender.add(female);

        JDateChooser inputBirthday = new JDateChooser();
        inputBirthday.setCalendar(Calendar.getInstance());

        JButton choosePhoto = new JButton("Choose File");
        choosePhoto.setBounds(210, 505, 200, 30);
        choosePhoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
        
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    filePathPhoto = selectedFile.getPath().replace("\\", "\\\\");
                    System.out.println("Selected File: " + selectedFile.getPath());
                } else {
                    System.out.println("No file chosen.");
                }
            }
        });

        rightPanel.add(inputEmail);
        rightPanel.add(inputNama);
        rightPanel.add(inputPassword);
        rightPanel.add(radioPanelGender);
        rightPanel.add(inputBirthday);
        rightPanel.add(choosePhoto);

        inputPanel.add(leftPanel);
        inputPanel.add(rightPanel);

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");

        ActionListener registerListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setEmail(inputEmail.getText());
                user.setName(inputNama.getText());

                char[] passwordChars = inputPassword.getPassword();
                String password = new String(passwordChars);
                user.setPassword(password);

                int gender = -1;
                if (male.isSelected()) {
                    gender = 1;
                } else if (female.isSelected()) {
                    gender = 0;
                }

                user.setGender(gender);
                user.setBirthday(inputBirthday.getDate());
                user.setPhoto(filePathPhoto);

                boolean success = DatabaseController.insertNewUser(user);
                if(success){
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
                }else{
                    JOptionPane.showMessageDialog(null, "Data gagal disimpan!");
                }
            }
        };
        registerButton.addActionListener(registerListener);

        JFrame frame = this;
        ActionListener backListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LandingPage();
                frame.dispose();
            }
        };
        backButton.addActionListener(backListener);

        footerPanel.add(registerButton);
        footerPanel.add(backButton);

        contentPanel.add(headerPanel);
        contentPanel.add(inputPanel);
        contentPanel.add(footerPanel);

        this.add(contentPanel);
        this.setVisible(true);
    }

    // public static void main(String[] args) {
    //     new RegisterScreen();
    // }
}
