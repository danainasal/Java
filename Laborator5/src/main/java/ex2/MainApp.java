package ex2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MainApp {
    public static List<Mobilier> citire()
    {
        try
        {
            File file = new File("mobilier.json");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file, new TypeReference<List<Mobilier>>() {});
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void afisareMobilier(List<Mobilier> mobilierList)
    {
        for (Mobilier mobilier : mobilierList)
        {
            System.out.println("Nume piesă: " + mobilier.getNume());
            System.out.println("Plăci de pal:");
            for (Placa placa : mobilier.getPlaci())
            {
                System.out.println(placa);
            }
            System.out.println();
        }
    }

    public static List<Placa> caracteristicilePiesei(List<Mobilier> mobilierList, String numePiesa)
    {
        List<Placa> caracteristici = new ArrayList<>();
        for (Mobilier mobilier : mobilierList)
        {
            if (mobilier.getNume().equalsIgnoreCase(numePiesa))
            {
                caracteristici = mobilier.getPlaci();
                break;
            }
        }
        return caracteristici;
    }

    public static int numarColiPal(List<Mobilier> mobilierList, String numePiesa)
    {
        int numarColiNecesare = 0;
        for (Mobilier mobilier : mobilierList)
        {
            if (mobilier.getNume().equalsIgnoreCase(numePiesa))
            {
                for (Placa placa : mobilier.getPlaci())
                {
                    int ariePlaca = placa.getLungime() * placa.getLatime();
                    int arieColi = 2800 * 2070;
                    int bucNecesare = (ariePlaca + arieColi - 1) / arieColi;
                    numarColiNecesare += bucNecesare * placa.getNr_bucati();
                }
                break;
            }
        }
        return numarColiNecesare;
    }

    public static void main(String[] args)
    {
        List<Mobilier> mobilierList = citire();

        if (mobilierList != null)
        {
            afisareMobilier(mobilierList);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Introduceți numele piesei de mobilier.json: ");
            String numePiesaDeMobilier = scanner.nextLine();

            List<Placa> caracteristici = caracteristicilePiesei(mobilierList, numePiesaDeMobilier);
            if (!caracteristici.isEmpty())
            {
                System.out.println("Caracteristicile plăcilor pentru " + numePiesaDeMobilier + ":");
                for (Placa placa : caracteristici)
                {
                    System.out.println(placa);
                }
            }
            else
            {
                System.out.println("Piesa de mobilier.json nu a fost găsită.");
            }

            int numarColi = numarColiPal(mobilierList, numePiesaDeMobilier);
            if (numarColi > 0)
            {
                System.out.println("Numărul estimativ de coli de pal necesare pentru " + numePiesaDeMobilier + ": " + numarColi);
            }
            else
            {
                System.out.println("Piesa de mobilier.json nu a fost găsită sau nu sunt plăci de pal asociate.");
            }
        }
    }
}
