package packageDev1;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class DevModele extends JFrame{
    Dictionnaire dictioImport; //Dictionnary imported by user
    Dictionnaire motsImport; //Text imported by user
    DevAffichage monAffichage;

    public DevModele(DevAffichage test)
    {
        monAffichage = test;
    }

    //highlight particular word in textarea
    public void redHightligher(ArrayList<Integer> fautesInd)
    {
        try
        {
            int carretStart = 0;
            int carretEnd = 0;
            Highlighter.HighlightPainter redPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.red);
            for (int i = 0; i < fautesInd.size(); i++)
            {
                carretStart = motsImport.arrayTab.get(fautesInd.get(i));
                carretEnd = carretStart + motsImport.arToStr.get(fautesInd.get(i)).length();
                monAffichage.tArea.getHighlighter().addHighlight(carretStart, carretEnd, redPainter);
            }
        }
        catch (Exception e)
        {
            System.out.print("PLACEHOLDER4");
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
                motsImport.carretInd();
                ArrayList<Integer> fautesInd = dictioImport.checkIfIn(motsImport.arToStr);
                redHightligher(fautesInd);
            }
        }

        catch(Exception e)
        {
            System.err.print("PLACEHOLDER1");
        }
    }
}
