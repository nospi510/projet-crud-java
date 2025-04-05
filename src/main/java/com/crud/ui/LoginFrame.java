package com.crud.ui;

import javax.swing.*;

public class LoginFrame extends JFrame {
    private JTextField userField;
    private JPasswordField passField;

    public LoginFrame() {
        setTitle("Connexion");
        setSize(300, 150);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("Utilisateur :");
        userLabel.setBounds(10, 10, 80, 25);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(100, 10, 160, 25);
        add(userField);

        JLabel passLabel = new JLabel("Mot de passe :");
        passLabel.setBounds(10, 40, 80, 25);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(100, 40, 160, 25);
        add(passField);

        JButton loginButton = new JButton("Connexion");
        loginButton.setBounds(100, 80, 160, 25);
        loginButton.addActionListener(e -> seConnecter());
        add(loginButton);
    }

    private void seConnecter() {
        String user = userField.getText();
        String pass = new String(passField.getPassword());

        if (user.equals("admin") && pass.equals("admin")) {
            dispose();
            new EtudiantFrame().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Identifiants incorrects !");
        }
    }
}
