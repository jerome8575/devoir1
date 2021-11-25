package packageDev1;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DevAffichage extends JFrame{
    JTextArea tArea = new JTextArea();
    public void doTheStuff()
    {
        DevAffichage mainFrame = new DevAffichage();
        JPanel mainPanel = new JPanel();
        //mainFrame.add(mainPanel);
        mainFrame.setBackground(Color.red);
        mainFrame.setSize(400, 400);

        //link the other parts
        DevModele mainModel = new DevModele(mainFrame);
        DevControle mainControl = new DevControle(mainFrame, mainModel);



        JMenu menuF = new JMenu("Fichier");
        JMenuItem menuFimpo = new JMenuItem("Importer Fichier");
        menuFimpo.addActionListener(mainControl);
        JMenuItem menuFsave  = new JMenuItem("Sauvergarder Fichier");
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

        mainFrame.setJMenuBar(menuBar);


        //create the text area

        tArea.setRows(20);
        tArea.setColumns(20);
        mainPanel.add(tArea);




        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
        //testzone
    }


    public static void main(String[] args)
    {
        DevAffichage testAffi = new DevAffichage();
        testAffi.doTheStuff();



    }


}

