package packageDev1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;


public class Dictionnaire
{
    //declare references
    Hashtable hashtable = new Hashtable<>();
    File ourFile;
    FileReader ourFR;
    BufferedReader ourInput;
    String[] arToStr;

    //Create a constructor for the class
    public Dictionnaire(String filePath)
    {
        try
        {
            ourFile = new File(filePath);
            ourFR = new FileReader(ourFile);
            
            ourInput = new BufferedReader(ourFR, 100);
        }
        catch (FileNotFoundException e)
        {
            System.out.print("Votre fichier n'existe pas.");
        }
    }

    public void toHashtable()
    {
        String word;
        try
        {
            word = ourInput.readLine();
            while (word != null)
            {

                hashtable.put(word, word);
                word = ourInput.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.print("PLACEHOLDER");
        }

        catch  (IOException e)
        {
            System.err.print("PLACEHOLDER");
        }
    }

    public void printHash()
    {
        System.out.println(hashtable);
    }

    public Hashtable returnHash()
    {
        return hashtable;
    }

    public String printString()
    {
        for (int i = 0; i < hashtable.size(); i++)
        {
            arToStr += hashtable.get(i).toString();
        }
        System.out.print(arToStr);
        return arToStr;
    }
}
