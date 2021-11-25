package packageDev1;

import javax.swing.*;
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

    public void ouvrirFichier(String type)
    {
        try
        {
            JFileChooser filePicker = new JFileChooser();
            filePicker.showOpenDialog(null);
            String absolutePath = filePicker.getSelectedFile().getAbsolutePath();
            System.out.print("hey");
            if (type.equals("dictio"))
            {
                dictioImport = new Dictionnaire(absolutePath);
                dictioImport.toHashtable();
                System.out.print(dictioImport.test());
                monAffichage.tArea.setText(dictioImport.test());

            }

            else
            {
                dictioImport = new Dictionnaire(absolutePath);
                dictioImport.toHashtable();
                System.out.print(dictioImport.test());
                monAffichage.tArea.setText(dictioImport.test());

            }
        }
        catch(Exception e)
        {
            System.err.print("PLACEHOLDER1");
        }
    }

}
