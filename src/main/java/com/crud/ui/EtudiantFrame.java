package com.crud.ui;

import com.crud.dao.EtudiantDAO;
import com.crud.model.Etudiant;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EtudiantFrame extends JFrame {
    private JTextField idField = new JTextField();
    private JTextField nomField = new JTextField();
    private JTextField prenomField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextArea zoneAffichage = new JTextArea();
    private EtudiantDAO dao = new EtudiantDAO();

    public EtudiantFrame() {
        setTitle("Gestion des Étudiants");
        setSize(500, 500);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("ID (pour Modifier/Supprimer) :")); add(idField);
        add(new JLabel("Nom :")); add(nomField);
        add(new JLabel("Prénom :")); add(prenomField);
        add(new JLabel("Email :")); add(emailField);

        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(e -> ajouter());
        add(btnAjouter);

        JButton btnLister = new JButton("Lister");
        btnLister.addActionListener(e -> afficherListe());
        add(btnLister);

        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.addActionListener(e -> supprimer());
        add(btnSupprimer);

        JButton btnModifier = new JButton("Modifier");
        btnModifier.addActionListener(e -> modifier());
        add(btnModifier);

        zoneAffichage.setEditable(false);
        add(new JScrollPane(zoneAffichage));
    }

    private void ajouter() {
        Etudiant e = new Etudiant(nomField.getText(), prenomField.getText(), emailField.getText());
        dao.ajouter(e);
        JOptionPane.showMessageDialog(this, "Étudiant ajouté !");
    }

    private void afficherListe() {
        List<Etudiant> etudiants = dao.lister();
        zoneAffichage.setText("");
        for (Etudiant e : etudiants) {
            zoneAffichage.append(e.getId() + " | " + e.getNom() + " " + e.getPrenom() + " - " + e.getEmail() + "\n");
        }
    }

    private void supprimer() {
        int id = Integer.parseInt(idField.getText());
        dao.supprimer(id);
        JOptionPane.showMessageDialog(this, "Étudiant supprimé !");
    }

    private void modifier() {
        int id = Integer.parseInt(idField.getText());
        Etudiant e = new Etudiant(id, nomField.getText(), prenomField.getText(), emailField.getText());
        dao.modifier(e);
        JOptionPane.showMessageDialog(this, "Étudiant modifié !");
    }
}
