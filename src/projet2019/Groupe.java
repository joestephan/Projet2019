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

public class Groupe extends JPanel {

    private JPanel IGPanel, AIPanel, GroupsPanel, ButtonsPanel, leftPanel, rightPanel, rpanel;
    private JLabel label1, label2, label3, label11, label12, label13, label14;
    private JTextField nomCours, numGroup, nbAuditeurs;
    public static JTextArea AIText, GText;
    private JComboBox Cours;

    private ButtonGroup bg;
    private JRadioButton Fr, An, FA;
    private JButton button1, button2;

    ArrayList<objetGroupe> listEtud = new ArrayList();

    public Groupe() {

        setPreferredSize(new Dimension(800, 500));
        setLayout(new FlowLayout());

        JLabel labelSpace = new JLabel("                                   ");
        JLabel labelSpace2 = new JLabel("     ");
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        //panels
        leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout());
        leftPanel.setPreferredSize(new Dimension(342, 500));
        rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout());
        rightPanel.setPreferredSize(new Dimension(300, 100));
        IGPanel = new JPanel();
        IGPanel.setLayout(gbl);
        IGPanel.setPreferredSize(new Dimension(342, 140));
        AIPanel = new JPanel();
        AIPanel.setLayout(new FlowLayout());
        AIPanel.setPreferredSize(new Dimension(342, 270));

        ButtonsPanel = new JPanel();
        ButtonsPanel.setLayout(gbl);
        ButtonsPanel.setPreferredSize(new Dimension(95, 500));

        //labels
        label1 = new JLabel("Infos Groups");
        label2 = new JLabel("Auditeurs Inscrits");
        label3 = new JLabel("          Groupes");

        //label du panel IGPanel
        label11 = new JLabel("Cours ");
        label12 = new JLabel("No. Groupe ");
        label13 = new JLabel("Langues ");
        label14 = new JLabel("Nombres Auditeurs ");

        //les combobox
        Cours = new JComboBox<>();

        //les textFields du panel IAPanel
        nomCours = new JTextField(8);
        numGroup = new JTextField(3);
        nbAuditeurs = new JTextField(3);

        //les radioButtons du IAPanel
        Fr = new JRadioButton("Francais ");
        Fr.setSelected(true);
        An = new JRadioButton("Anglais ");
        FA = new JRadioButton("F/A ");

        //ButtonGroup
        bg = new ButtonGroup();
        bg.add(Fr);
        bg.add(An);
        bg.add(FA);

        //les buttons
        button1 = new JButton("Ajouter");
        button1.addActionListener(new nouveauListener());
        button1.setPreferredSize(new Dimension(109, 50));
        button2 = new JButton("Supprimer");
        button2.addActionListener(new enregistrerListener());
        button2.setPreferredSize(new Dimension(109, 50));

        //textArea
        AIText = new JTextArea(30, 40);
        AIText.setEditable(false);

        GText = new JTextArea(15, 20);
        GText.setEditable(false);

        leftPanel.add(label1);

        //ippanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(label11, gbc);

        IGPanel.add(label11);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(Cours, gbc);
        IGPanel.add(Cours);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.anchor = GridBagConstraints.LINE_START;
        gbl.setConstraints(label12, gbc);

        IGPanel.add(label12);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(nomCours, gbc);
        IGPanel.add(nomCours);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 3, 5, 3);
        gbc.anchor = GridBagConstraints.LINE_START;
        gbl.setConstraints(numGroup, gbc);

        IGPanel.add(numGroup);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.anchor = GridBagConstraints.LINE_START;
        gbl.setConstraints(label13, gbc);
        IGPanel.add(label13);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 3, 5, 3);
        gbl.setConstraints(Fr, gbc);

        IGPanel.add(Fr);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 3, 5, 3);

        gbl.setConstraints(An, gbc);
        IGPanel.add(An);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbc.insets = new Insets(5, 3, 5, 3);
        gbl.setConstraints(FA, gbc);

        IGPanel.add(FA);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.anchor = GridBagConstraints.LINE_START;
        gbl.setConstraints(label14, gbc);
        IGPanel.add(label14);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(nbAuditeurs, gbc);
        IGPanel.add(nbAuditeurs);
        IGPanel.setBackground(Color.gray);

        leftPanel.add(IGPanel);

        leftPanel.add(label2);
        AIPanel.add(AIText);
        leftPanel.add(AIPanel);
        //adding to buttonsPAnel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(button1, gbc);
        gbc.anchor = GridBagConstraints.LINE_START;
        ButtonsPanel.add(button1);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbl.setConstraints(button2, gbc);
        gbc.anchor = GridBagConstraints.LINE_START;
        ButtonsPanel.add(button2);

        rightPanel.add(label3);
        rightPanel.add(GText);

        //adding to rightPanel
        //adding left panel and rightPanel to main panel
        add(leftPanel);
        add(ButtonsPanel);
        add(rightPanel);
        add(labelSpace);
    }

    public class nouveauListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            nomCours.setText("");
            numGroup.setText("");
            nbAuditeurs.setText("");
            AIText.setText("");
            GText.setText("");
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
