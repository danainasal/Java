package Ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static int countWords(String str)
    {

        // Check if the string is null
        // or empty then return zero
        if (str == null || str.isEmpty())
            return 0;

        // Splitting the string around
        // matches of the given regular
        // expression
        String[] words = str.split("\\s+");

        // Return number of words
        // in the given string
        return words.length;
    }

    static int isVowel(char chars)
    {
        if (chars == 'a' || chars == 'e' || chars == 'i'
                || chars == 'o' || chars == 'u') {
            return 1;
        }
        else {
            return 0;
        }
    }


    static int vowelno(String str, int l)
    {
        if (l == 1) {
            return isVowel(str.charAt(l - 1));
        }

        return vowelno(str, l - 1)
                + isVowel(str.charAt(l - 1));
    }

    public static void main(String[] args) throws IOException {
        String nume_fis = "cantec_in.txt";
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));

        ArrayList<String> versuri = new ArrayList<String>();

        for(String linie; (linie = flux_in.readLine())!=null;)
        {
            versuri.add(linie);
        }
        System.out.println(versuri);
        PrintStream flux_out = new PrintStream("cantec_out.txt");

        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ce grupare de litere cautati: ");
        String grup = scanner.nextLine();
        for(int i = 0; i < versuri.size(); i++)
        {
            str = versuri.get(i).toLowerCase();
            Random rand = new Random();
            float n = rand.nextFloat(1);
            System.out.println("Nr random " +n);

            if(n < 0.1)
            {
                versuri.set(i, versuri.get(i).toUpperCase());
                grup = grup.toUpperCase();
            }

            flux_out.print(versuri.get(i) +"  " +countWords(versuri.get(i)) +"  " +vowelno(str, str.length()));
            if (versuri.get(i).endsWith(grup))
                flux_out.println("  *");
            else
                flux_out.println();
        }
    }
}