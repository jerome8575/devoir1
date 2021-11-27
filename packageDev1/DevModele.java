package packageDev1;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Path;

public class DevModele extends JFrame{
    Dictionnaire dictioImport;
    //Dictionnary imported by user
    Dictionnaire motsImport; //Text imported by user

    DevAffichage monAffichage;



    public DevModele(DevAffichage test)
    {
        monAffichage = test;
    }

    public void redHightligher()
    {
        try
        {
            Highlighter.HighlightPainter redPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.red);
            monAffichage.tArea.getHighlighter().addHighlight(0, 10, redPainter);
            System.out.print(monAffichage.tArea.getCaretPosition());
        }
        catch (Exception e)
        {
            System.out.print("PLACEHOLDER");
        }
    }



    //for the
    public void ouvrirFichier(String type)
    {
        try
        {
            JFileChooser filePicker = new JFileChooser();
            filePicker.showOpenDialog(null);
            String absolutePath = filePicker.getSelectedFile().getAbsolutePath();
            String fileName = filePicker.getSelectedFile().getName();
            if (type.equals("importDictio"))
            {
                dictioImport = new Dictionnaire(absolutePath, fileName);
                dictioImport.toArrays();
                monAffichage.labelDictio.setText(dictioImport.nomFichier);
            }


            else if (type.equals("importMots"))
            {
                motsImport = new Dictionnaire(absolutePath, fileName);
                motsImport.toArrays();
                monAffichage.tArea.setText(motsImport.arrLiToStr());
                monAffichage.labelMots.setText(motsImport.nomFichier);
            }

        }

        catch(Exception e)
        {
            System.err.print("PLACEHOLDER1");
        }
    }

}
