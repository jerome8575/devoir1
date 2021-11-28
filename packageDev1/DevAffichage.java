package packageDev1;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DevAffichage extends JFrame{
    DevModele mainModel;
    DevControle mainControl;
    JPanel mainPanel = new JPanel();
    JTextArea tArea = new JTextArea();
    JTextArea cArea = new JTextArea();
    JButton corrButt = new JButton("Corriger");
    JLabel labelDictio = new JLabel("Dictionnaire");
    JLabel labelMots = new JLabel("Fichier Mots");


    public void doTheStuff()
    {
        this.setSize(700, 700);

        JMenu menuF = new JMenu("Mots");
        JMenuItem menuFimpo = new JMenuItem("Importer Mots");
        menuFimpo.addActionListener(mainControl);
        JMenuItem menuFsave  = new JMenuItem("Sauvegarder Changements");
        menuF.add(menuFimpo);
        menuF.add(menuFsave);

        JMenu menuD = new JMenu("Dictionnaire");
        JMenuItem menuDimp = new JMenuItem("Importer Dictionnaire");
        menuDimp.addActionListener(mainControl);
        JMenuItem menuDtest = new JMenuItem("Test");
        menuD.add(menuDimp);
        menuD.add(menuDtest);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menuF);
        menuBar.add(menuD);

       this.setJMenuBar(menuBar);

        //create the text area for the user's words
        tArea.setRows(20);
        tArea.setColumns(15);
        tArea.addMouseListener(mainControl);

        //create the text are for the correction
        cArea.setRows(5);
        cArea.setColumns(15);
        cArea.addMouseListener(mainControl);

        //create the button for the correction
        corrButt.addActionListener(mainControl);


        //create and add objects to the panel
        mainPanel.setBackground(Color.black);
        mainPanel.add(labelDictio);
        mainPanel.add(labelMots);
        mainPanel.add(tArea);
        mainPanel.add(corrButt);
        mainPanel.add(cArea);
        this.add(mainPanel);
        this.setVisible(true);
        //testzone
    }



    public static void main(String[] args)
    {
        //make stuff, link stuff
        DevAffichage testAffi = new DevAffichage();
        testAffi.mainModel = new DevModele(testAffi);
        testAffi.mainControl = new DevControle(testAffi, testAffi.mainModel);
        testAffi.doTheStuff();
    }


}

