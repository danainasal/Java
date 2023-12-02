package ex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.*;

public class MainApp {

   public static void main(String[] args) throws IOException {
      try (BufferedReader flux_in = new BufferedReader(new InputStreamReader(new FileInputStream("electronice.txt")))) {
         List<Echipament> lista = new ArrayList<>();
         String linie;
         while ((linie = flux_in.readLine()) != null) {
            String[] parts = linie.split(";");
            if (linie.contains("imprimanta")) {
               Imprimanta a = new Imprimanta(parts[0],
                       Integer.parseInt(parts[1]),
                       Float.parseFloat(parts[2]),
                       parts[3],
                       Status.valueOf(parts[4]),
                       Integer.parseInt(parts[6]),
                       parts[7],
                       Integer.parseInt(parts[8]),
                       Mod_Scriere.valueOf(parts[9]));
               lista.add(a);
            } else if (linie.contains("copiator")) {
               Copiator c = new Copiator(parts[0],
                       Integer.parseInt(parts[1]),
                       Float.parseFloat(parts[2]),
                       parts[3],
                       Status.valueOf(parts[4]),
                       Integer.parseInt(parts[6]),
                       FormatCopiere.valueOf(parts[7]));
               lista.add(c);
            } else if (linie.contains("sistem de calcul")) {
               SistemeCalcul s = new SistemeCalcul(parts[0],
                       Integer.parseInt(parts[1]),
                       Float.parseFloat(parts[2]),
                       parts[3],
                       Status.valueOf(parts[4]),
                       parts[6],
                       Float.parseFloat(parts[7]),
                       Integer.parseInt(parts[8]),
                       oS.valueOf(parts[9]));
               lista.add(s);
            }
         }
         System.out.print(" Afişarea imprimantelor");
         Iterator<Echipament> imprimante = lista.iterator();
         while (imprimante.hasNext()) {
            Echipament e = imprimante.next();
            String classEchipament = e.getClass().getName();
            if (classEchipament == "Main.Imprimanta") {
               System.out.print(e);
            }
         }
         System.out.print("\n Afişarea copiatoarelor ");
         Iterator<Echipament> copiatoare = lista.iterator();
         while (copiatoare.hasNext()) {
            Echipament e = copiatoare.next();
            String classEchipament = e.getClass().getName();
            if (classEchipament == "Main.Copiator") {
               System.out.print(e);
            }
         }
         System.out.print("\n Afişarea sistemelor de calcul ");
         Iterator<Echipament> sistemcalcul = lista.iterator();
         while (sistemcalcul.hasNext()) {
            Echipament e = sistemcalcul.next();
            String classEchipament = e.getClass().getName();
            if (classEchipament == "Main.SistemCalcul") {
               System.out.print(e);
            }
         }
         System.out.println("\n Modificarea stării în care se află un echipament ");
         BufferedReader flux_in_denumireEchipament = new BufferedReader(new InputStreamReader(System.in));
         String denumireEchipament = flux_in_denumireEchipament.readLine();
         Iterator<Echipament> echipamente = lista.iterator();
         while (echipamente.hasNext()) {
            Echipament e = echipamente.next();
            if (e.getDenumire().compareTo(denumireEchipament) == 0) {
               System.out.println("Dati noua stare a imprimantei: ");
               BufferedReader flux_in_stareEchipament = new BufferedReader(new InputStreamReader(System.in));
               String stareEchipament = flux_in_stareEchipament.readLine();
               e.setStatus(Status.valueOf(stareEchipament));
            }
         }

         System.out.println("\n Setarea unui anumit mod de scriere pentru o imprimantă ");
         System.out.println("Dati denumirea imprimantei: ");
         BufferedReader flux_in_denumireImprimanta = new BufferedReader(new InputStreamReader(System.in));
         String denumireImprimanta = flux_in_denumireImprimanta.readLine();
         Iterator<Echipament> denumireImprimante = lista.iterator();
         while (denumireImprimante.hasNext()) {
            Echipament e = denumireImprimante.next();
            if (e.getDenumire().compareTo(denumireImprimanta) == 0 && e.getClass().getName() == "Main.Imprimanta") {
               Imprimanta i = (Imprimanta) e;
               System.out.println("Dati modul de scriere al imprimantei: ");
               BufferedReader flux_in_scriereImprimanta = new BufferedReader(new InputStreamReader(System.in));
               String scriereImprimanta = flux_in_scriereImprimanta.readLine();
               i.setMod_scriere(Mod_Scriere.valueOf(scriereImprimanta));
            }
         }
         System.out.println("\n Afisare echipamente vandute");
         Iterator<Echipament> echipamenteVandute = lista.iterator();
         while (echipamenteVandute.hasNext()) {
            Echipament e = echipamenteVandute.next();
            if (e.getStatus() == Status.valueOf("vandut")) {
               System.out.print(e);
            }
         }
         System.out.println("\n Afisare: ");
         System.out.print(lista);
      }
   }
}
