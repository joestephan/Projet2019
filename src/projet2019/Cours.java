/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet2019;

import com.alee.laf.text.WebTextField;
import java.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import javax.swing.*;
import java.util.Calendar;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cours extends JPanel {

    String sem1,sem2,annee1,annee2,annee3,annee4,annee5;
    private JPanel ICPanel, CoursPanel, ButtonsPanel, leftPanel, rightPanel;
    private JLabel label1, label2, label3, label11, label12, label13, label14, label15, label16, label17;
    private JTextField codeC, nomC, Credits, Heures, Frais;
    public static JTextArea text;
    private JComboBox anneeAcad, Semestre;
    private JButton button1, button2, button3;
    ArrayList<objetCours> listCours = new ArrayList();

    public Cours() {

        setPreferredSize(new Dimension(800, 500));
        setLayout(new FlowLayout());
        

        JLabel labelSpace = new JLabel("                  ");
        JLabel labelSpace2 = new JLabel("     ");
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        sem1 = "1";
        sem2="2";
        annee1="Premiere";
        annee2 = "Deuxieme";
        annee3 = "Troisieme";
        annee4 = "Quatrieme";
        annee5 = "Cinquieme";
        //panels
        leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout());
        leftPanel.setPreferredSize(new Dimension(342, 700));
        rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout());
        rightPanel.setPreferredSize(new Dimension(327, 700));
        ICPanel = new JPanel();
        ICPanel.setLayout(gbl);
        ICPanel.setPreferredSize(new Dimension(342, 250));

        CoursPanel = new JPanel();
        ButtonsPanel = new JPanel();
        ButtonsPanel.setLayout(new FlowLayout());
        ButtonsPanel.setPreferredSize(new Dimension(342, 80));

        //labels
        label1 = new JLabel("Infos Cours");

        label3 = new JLabel("Cours");

        //label du panel IPPanel
        label11 = new JLabel("Code Cours ");
        label12 = new JLabel("Nom Cours ");
        label13 = new JLabel("Annee Acad ");
        label14 = new JLabel("Semester ");
        label15 = new JLabel("Credits ");
        label16 = new JLabel("Heures ");
        label17 = new JLabel("Frais ");

        //les combobox
        anneeAcad = new JComboBox<>();
        anneeAcad.addItem(annee1);
        anneeAcad.addItem(annee2);
        anneeAcad.addItem(annee3);
        anneeAcad.addItem(annee4);
        anneeAcad.addItem(annee5);
        
        Semestre = new JComboBox<>();
        Semestre.addItem(sem1);
        Semestre.addItem(sem2);

        //les textFields du panel IPPanel
        codeC = new JTextField(10);
        nomC = new JTextField(20);
        Credits = new JTextField(8);
        Heures = new JTextField(8);
        Frais = new JTextField(10);

        //les buttons
        button1 = new JButton("Nouveau");
        button1.addActionListener(new nouveauListener());
        button1.setPreferredSize(new Dimension(109, 50));
        button2 = new JButton("Enregistrer");
        button2.addActionListener(new enregistrerListener());
        button2.setPreferredSize(new Dimension(109, 50));
        button3 = new JButton("Afficher");
        button3.addActionListener(new afficherListener());
        button3.setPreferredSize(new Dimension(109, 50));

        //textArea
        text = new JTextArea(20, 30);
        text.setEditable(false);

        leftPanel.add(label1);

        //icpanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(label11, gbc);
        gbc.anchor = GridBagConstraints.LINE_START;
        ICPanel.add(label11);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(codeC, gbc);
        ICPanel.add(codeC);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(label12, gbc);
        gbc.anchor = GridBagConstraints.LINE_START;
        ICPanel.add(label12);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(nomC, gbc);
        ICPanel.add(nomC);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(label13, gbc);
        gbc.anchor = GridBagConstraints.LINE_START;
        ICPanel.add(label13);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(anneeAcad, gbc);
        ICPanel.add(anneeAcad);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(label14, gbc);
        gbc.anchor = GridBagConstraints.LINE_START;
        ICPanel.add(label14);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(Semestre, gbc);
        ICPanel.add(Semestre);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(label15, gbc);
        gbc.anchor = GridBagConstraints.LINE_START;
        ICPanel.add(label15);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(Credits, gbc);
        ICPanel.add(Credits);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(label16, gbc);
        ICPanel.add(label16);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(Heures, gbc);
        ICPanel.add(Heures);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(label17, gbc);
        ICPanel.add(label17);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(Frais, gbc);
        ICPanel.add(Frais);

        ICPanel.setBackground(Color.gray);

        leftPanel.add(ICPanel);

        

        //adding to buttonsPAnel
        ButtonsPanel.add(button1);
        ButtonsPanel.add(button2);
        ButtonsPanel.add(button3);

        leftPanel.add(ButtonsPanel);

        //adding to rightPanel
        rightPanel.add(label3);
        rightPanel.add(text);

        //adding left panel and rightPanel to main panel
        add(leftPanel);
        add(labelSpace2);
        add(rightPanel);
        add(labelSpace);
    }

    public class nouveauListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            codeC.setText("");
            nomC.setText("");
            Credits.setText("");
            Heures.setText("");
            Frais.setText("");
        }

    }

    public class afficherListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           
        }

    }

    public class enregistrerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           


            

        }

    }
}
