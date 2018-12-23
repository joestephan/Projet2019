package projet2019;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.ParseException;
import java.util.*;
import javax.swing.*;

public class Projet2019 extends JFrame {

    private JPanel topPanel, bottomPanel, boxPanel, buttonsPanel, anneePanel, specialitePanel;
    private JLabel label1, label2;
    private JButton button1, button2, button3;
    public static JComboBox<String> annee;
    public static JComboBox<Specialite> specialite;
    JTabbedPane tp;

    public Projet2019() {

        setPreferredSize(new Dimension(800, 650));    //dimension de la page
        setTitle("Systeme de Gestion Université");     //titre
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //ferme a partir du croix rouge
        setLayout(new BorderLayout());
        setResizable(false);

        //tabbed pane
        tp = new JTabbedPane();

        //les panels
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        boxPanel = new JPanel();
        buttonsPanel = new JPanel();
        anneePanel = new JPanel();
        specialitePanel = new JPanel();

        //les labels
        label1 = new JLabel("Année Universitaire  :");
        label2 = new JLabel("Spécialité :");

        //les bouttons
        button1 = new JButton("Changer");
        button1.setPreferredSize(new Dimension(120, 40));
        button2 = new JButton("Enregistrer");
        button2.setPreferredSize(new Dimension(120, 40));
        button3 = new JButton("Quitter");
        button3.setPreferredSize(new Dimension(120, 40));

        //les combobox
        annee = new JComboBox<>();
        annee.setModel(new DefaultComboBoxModel(AnneeUniversitaire.anneeUniv().toArray()));
        specialite = new JComboBox<>();
        specialite.setModel(new DefaultComboBoxModel(Specialite.titreSpecialite().toArray()));

        //panel layouts
        topPanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new FlowLayout());
        boxPanel.setLayout(new BorderLayout());
        anneePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        specialitePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        //panel sizes
        topPanel.setPreferredSize(new Dimension(800, 100));
        bottomPanel.setPreferredSize(new Dimension(800, 700));
        boxPanel.setPreferredSize(new Dimension(400, 100));
        anneePanel.setPreferredSize(new Dimension(400, 40));
        specialitePanel.setPreferredSize(new Dimension(400, 40));
        buttonsPanel.setPreferredSize(new Dimension(400, 100));

        //ajouter topPanel au frame
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel);

        //ajouter boxPanel au topPanel
        topPanel.add(boxPanel, BorderLayout.WEST);

        //ajoute label et box au anneePanel
        anneePanel.add(label1);
        anneePanel.add(annee);

        //ajouter anneePanel au boxPanel
        boxPanel.add(anneePanel, BorderLayout.NORTH);

        //ajoute label et box au specialitePanel
        specialitePanel.add(label2);
        specialitePanel.add(specialite);

        //ajouter specialitePanel au box panel
        boxPanel.add(specialitePanel, BorderLayout.CENTER);

        //ajouter buttonsPanel to TopPanel
        topPanel.add(buttonsPanel, BorderLayout.CENTER);

        //ajouter les bouttons au buttonsPanel 
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);

        //ajouter les tabs
        tp.addTab("   Etudiant   ", new Etudiant());
        tp.addTab("   Enseignant   ", new Enseignant());
        tp.addTab("   Cours   ", new Cours());
        tp.addTab("   Groupes   ", new Groupe());
        tp.addTab("   Inscription   ", new Inscription());
        tp.addTab("   Contrat   ", new JPanel());
        tp.addTab("   Horaires   ", new Horaires());
        tp.addTab("   Resultats   ", new JPanel());
        tp.addTab("   Divers   ", new JPanel());

        //ajouter tabbedpane to bottomPanel
        bottomPanel.add(tp);

        //rendre le frame visible
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Projet2019();
    }
}
