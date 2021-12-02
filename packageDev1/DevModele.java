package packageDev1;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Utilities;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.util.ArrayList;

public class DevModele extends JFrame{
    Dictionnaire dictioImport; //Dictionnary imported by user
    Dictionnaire motsImport; //Text imported by user
    DevAffichage monAffichage;
    String absolutePath;
    String word;

    ArrayList<MotIncorrect> motsIncorrects;

    public DevModele(DevAffichage test)
    {
        monAffichage = test;
        motsIncorrects = new ArrayList<MotIncorrect>();
    }

    //highlight particular word in textarea
    public void redHightligher(ArrayList<MotIncorrect> motsIncorrects, String text)
    {
        try
        {
            int carretStart = 0;
            int carretEnd = 0;
            Highlighter.HighlightPainter redPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.red);
            for (int i = 0; i < motsIncorrects.size(); i++)
            {
                carretStart = motsImport.arrayTab.get(motsIncorrects.get(i).index);
                carretEnd = carretStart + motsImport.arToStr.get(motsIncorrects.get(i).index).length();
                monAffichage.tArea.getHighlighter().addHighlight(carretStart, carretEnd, redPainter);
            }
        }
        catch (Exception e)
        {
            System.out.print("PLACEHOLDER4");
        }

    }

    public void wordClicked(int offset)
    {
        try
        {
            System.out.println( monAffichage.tArea.modelToView( offset ) );
            int start = Utilities.getWordStart(monAffichage.tArea,offset);
            int end = Utilities.getWordEnd(monAffichage.tArea, offset);
            word = monAffichage.tArea.getDocument().getText(start, end-start);



            System.out.println( "Selected word: " + word);
            int rowStart = Utilities.getRowStart(monAffichage.tArea, offset);
            int rowEnd = Utilities.getRowEnd(monAffichage.tArea, offset);
            System.out.println( "Row start offset: " + rowStart );
            System.out.println( "Row end   offset: " + rowEnd );
            monAffichage.tArea.select(rowStart, rowEnd);

            // recommander des mots

            recommander(word);

        }
        catch (Exception e2) {}
    }

    public void changeWord(String replacer)
    {
        motsImport.replaceWord(replacer, word);
        motsImport.toArrays();
        monAffichage.tArea.setText(motsImport.arrLiToStr());
        corrigerText(monAffichage.tArea.getText());
    }

    public void saveFile()
    {
        try{
            FileWriter filewriter = new FileWriter(absolutePath);
            BufferedWriter writer = new BufferedWriter(filewriter);
            for (int i = 0; i<motsImport.arToStr.size(); i++)
            {
                System.out.print(motsImport.arToStr.get(i));
                writer.write(motsImport.arToStr.get(i) + "\n");
            }
            writer.close();
        }
        catch (IOException e)
        {
            System.out.print("PLACEHOLDEr");
        }

    }

    //for the
    public void ouvrirFichier(String type)
    {
        try
        {
            JFileChooser filePicker = new JFileChooser();
            filePicker.showOpenDialog(null);
            absolutePath = filePicker.getSelectedFile().getAbsolutePath();
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
                //ArrayList<MotIncorrect> motsIncorrects = dictioImport.checkIfIn(motsImport.arToStr);
                //redHightligher(motsIncorrects);
            }
            
        }

        catch(Exception e)
        {
            System.err.print("PLACEHOLDER1");
        }
    }

    public void corrigerText(String text){
        //update mots
        String[] tempArr = monAffichage.tArea.getText().split("\n");
        motsImport.arToStr.clear();
        motsImport.hashtable.clear();
        motsImport.arrayTab.clear();
        for (int i = 0; i<tempArr.length; i++)
        {
            motsImport.arToStr.add(tempArr[i]);
            motsImport.hashtable.put(i, tempArr[i]);
        }
        monAffichage.tArea.setText(motsImport.arrLiToStr());
        motsImport.toArrays();
        motsImport.carretInd();
        
        
        
        // corriger text
        System.out.println("Corriger text: " + text);
        Parser parser = new Parser();
        ArrayList<String> parsedTextArr = parser.parse(text);

        for (String mot : parsedTextArr){
            System.out.print(mot + " , ");
        }

        motsIncorrects = dictioImport.checkIfIn(parsedTextArr);
        redHightligher(motsIncorrects, text);
    }

    public void recommander(String mot){
        for (MotIncorrect motIncorrect : motsIncorrects){
            if (motIncorrect.mot.equals(mot)){
                monAffichage.afficherMenuRecommandation(motIncorrect.recommendations);
            }
        }
        // do nothing
    }


}
