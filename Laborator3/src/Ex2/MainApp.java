package Ex2;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static List<Produs> produse = new ArrayList<>();
    private static double incasari = 0;

    public static void main(String[] args) throws IOException{
        String nume_fis = "produse.csv.txt";
        try (BufferedReader flux_in= new BufferedReader(new FileReader(nume_fis))) {
            String linie;
            while ((linie = flux_in.readLine()) != null) {
                String[] elemente = linie.split(",");
                String denumire = elemente[0];
                float pret = Float.parseFloat(elemente[1]);
                int cantitate = Integer.parseInt(elemente[2]);
                LocalDate dataExpirarii = LocalDate.parse(elemente[3]);

                Produs produs = new Produs(denumire, pret, cantitate, dataExpirarii);
                produse.add(produs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("\n");
            System.out.println("1. Afișare produse");
            System.out.println("2. Afișare produse expirate");
            System.out.println("3. Vânzare produs");
            System.out.println("4. Afișare produse cu preț minim");
            System.out.println("5. Salvare produse cu cantitate mică în fișier");
            System.out.println("6. Ieșire");
            System.out.print("Introduceti opt: ");
            int opt=scanner.nextInt();
            System.out.println("\n");
            switch (opt) {
                case 1:
                    for (Produs produs : produse) {
                        System.out.println(produs);
                    }
                    break;
                case 2:
                    LocalDate data = LocalDate.now();
                    for (Produs produs : produse) {
                        if (produs.getDataExpirarii().isBefore(data)) {
                            System.out.println(produs);
                        }
                    }
                    break;
                case 3:
                    vindeProdus();
                    break;
                case 4:
                    Minim();
                    break;
                case 5:
                    Mica();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opțiune gresita!");
            }
        }
    }
    public static void vindeProdus() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Introduceți denumirea produsului: ");
        String denumire = scanner.nextLine();
        System.out.print("Introduceți cantitatea vândută: ");
        int cantitateVanduta = scanner.nextInt();

        for (Produs produs : produse) {
            if (produs.getDenumire().equalsIgnoreCase(denumire)) {
                if (produs.getCantitate() >= cantitateVanduta) {
                    produs.setCantitate(produs.getCantitate() - cantitateVanduta);
                    incasari += cantitateVanduta * produs.getPret();
                    if (produs.getCantitate() == 0) {
                        produse.remove(produs);
                    }
                    System.out.println("Produsul a fost vândut.");
                } else {
                    System.out.println("Cantitate insuficientă pe stoc.");
                }
                return;
            }
        }
    }

    public static void Minim() {
        if (produse.isEmpty()) {
            System.out.println("Nu există produse în stoc.");
            return;
        }

        float pretMinim = Float.MAX_VALUE;
        for (Produs produs : produse) {
            if (produs.getPret() < pretMinim) {
                pretMinim = produs.getPret();
            }
        }

        System.out.println("Produse cu preț minim:");
        for (Produs produs : produse) {
            if (produs.getPret() == pretMinim) {
                System.out.println(produs);
            }
        }
    }

    public static void Mica() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Introduceți cantitatea minimă: ");
        int cantitate= scanner.nextInt();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("cantitate_mica.csv.txt"))) {
            for (Produs produs : produse) {
                if (produs.getCantitate() < cantitate) {
                    writer.write(produs.toString() + "\n");
                }
            }
            System.out.println("Produsele cu cantitate mai mică decât " + cantitate + " au fost salvate.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


