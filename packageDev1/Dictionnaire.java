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
    ArrayList<String> arToStr = new ArrayList<String>();
    ArrayList<Integer> arrayTab = new ArrayList<Integer>();
    String nomFichier;

    //Create a constructor for the class
    public Dictionnaire(String filePath, String fileName)
    {
        nomFichier = fileName;
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

    //creates an int array that stores the carret
    //position of the first letter of the word
    //in the textarea
    public void carretInd()
    {
        try
        {
            int compteur = 0;
            arrayTab.add(0);
            for (int i = 0; i < arToStr.size()-1; i++)
            {
                //+1 because carret takes word length + 1 possibles places
                compteur = compteur + arToStr.get(i).toString().length() + 1;
                arrayTab.add(compteur);
            }
            System.out.print(arrayTab.toString());
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.err.print("PLACEHOLDER2");
        }
    }

    //checks if list of words are in dictionnary
    //returns arraylist of the indexes of the words
    //absent from the dictionnary
    public ArrayList<Integer> checkIfIn(ArrayList<String> arToStr)
    {
        ArrayList<Integer> indexFautes = new ArrayList<Integer>();
        for (int i = 0; i < arToStr.size(); i++)
        {
            if (hashtable.containsKey(arToStr.get(i))==false)
            {
                indexFautes.add(i);
            }
        }
        System.out.print(indexFautes.toString());
        return indexFautes;
    }

    //converts the file contents
    //to an arraylist and a hashtable
    public void toArrays()
    {
        String word;
        try
        {
            word = ourInput.readLine();
            while (word != null)
            {
                arToStr.add(word);
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

    //convert to string for the textarea
    public String arrLiToStr()
    {
        String bruh = "";
        for (int i = 0; i < arToStr.size(); i++)
        {
            bruh = bruh + arToStr.get(i) + "\n";
        }
        return bruh;
    }

}
