package Ex4;

import java.io.*;
import java.util.*;
import java.lang.*;

public class MainApp {
    public static int cifra(String cnp)
    {
        int[] vec = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int cifra = 0;
        for (int i = 0; i < 12; i++)
            cifra = cifra + vec[i] * Character.getNumericValue(cnp.charAt(i));
        if (cifra % 11 == 10)
            return 1;
        else
            return cifra % 11;
    }

    public static int verificare(String cnp)
    {
        int numere = 0;
        if (cnp.length() == 13)
        {
            for (int i = 0; i < 13; i++)
                if (Character.isDigit(cnp.charAt(i)))
                    numere++;
            if (numere == 13)
                if(cnp.charAt(0) == '1' || cnp.charAt(0) == '2' || cnp.charAt(0) == '5' || cnp.charAt(0) == '6')
                    if (Character.getNumericValue(cnp.charAt(12)) == cifra(cnp))
                        return 1;
        }
        System.out.println("CNP invalid!");
        System.out.print("CNP: ");
        return 0;
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Numr persoane: ");
        n = sc.nextInt();
        sc.nextLine();
        Vector<Persoana> pers = new Vector<Persoana>(n);

        String nume, cnp;

        for (int i = 0; i < n; i++)
        {
            System.out.print("Nume: ");
            nume = sc.nextLine();
            System.out.print("CNP: ");
            while (verificare(cnp = sc.nextLine()) == 0);
            pers.add(new Persoana(nume, cnp));
        }

        for (Persoana p: pers)
            System.out.println("Nume: " +p.getNume() +", CNP: " +p.getCnp() +", Varsta: " +p.getVarsta());
    }
}