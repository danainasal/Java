package Ex1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws IOException {
        String nume_fis = "judete_in.txt";
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));
        int contor = 0;
        try {
            Path file = Paths.get("judete_in.txt");
            long count = Files.lines(file).count();
            contor = (int) count;
            //System.out.println("Linii totale: " + contor);
        } catch (Exception e) {
            e.getStackTrace();
        }
        String[] judete = new String[contor];
        int u = 0;
        for(String linie; (linie = flux_in.readLine())!=null;)
        {
            judete[u] = linie;
            u++;
        }
        Arrays.sort(judete);
        for(int i = 0; i < u; i++)
            System.out.println(i +". " +judete[i]);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Judetul pe care il cautati cautati: ");
        String nou_judet = scanner.nextLine();
        int poz = Arrays.binarySearch(judete,nou_judet);
        System.out.println(poz>=0?"Judetul este la pozitia " +poz :"Nu a fost gasit!");
    }
}
