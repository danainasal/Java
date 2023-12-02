package Ex;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.exit;

public class MainApp {
        public static void scriere(List<Angajat> lista) {
            try {
                ObjectMapper mapper=new ObjectMapper();
                mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                File file=new File("src/main/resources/angajati.json");
                mapper.writeValue(file,lista);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static List<Angajat> citire() {
            try {
                File file = new File("src/main/resources/angajati.json");
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                List<Angajat> angajati = mapper.readValue(file, new TypeReference<List<Angajat>>() {});
                return angajati;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        public static  void afisare(List<Angajat>lista)
        {
            for(var ang:lista)
                System.out.println(ang);
        }

    private static void afisareAngajatiFiltrati(List<Angajat> angajati, Predicate<Angajat> filtru) {
        angajati.stream()
                .filter(filtru)
                .forEach(System.out::println);
        System.out.println();
    }

        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            List<Angajat>angajati=citire();

            int optiune=0;
            do{
                System.out.println("\n");
                System.out.println("Alege optiunea :");
                System.out.println("1.afisare angajati");
                System.out.println("2.salariu peste 2500");
                System.out.println("3.lista angajati cerere");
                System.out.println("4.Angajati care nu au functii de conducerere");
                System.out.println("5.Extragerea nume angaja cu casp");
                System.out.println("6.salarii mai mici de  3000");
                System.out.println("7.afisarea dateleor primului angajat");
                System.out.println("8.statistici la angajati");
                System.out.println("Dati opt:");
                optiune=scanner.nextInt();
                switch (optiune) {
                    case 0: exit(0);
                        break;
                    case 1:
                        afisare(angajati);
                        break;
                    case 2: afisareAngajatiFiltrati(angajati, angajat -> angajat.getSalariu() > 2500);
                        break;
                    case 3:
                        int anCurent = LocalDate.now().getYear();
                        List<Angajat> angajatiConducere = angajati.stream()
                                .filter(angajat -> angajat.getData_angajari().getYear() == anCurent - 1)
                                .filter(angajat -> angajat.getData_angajari().getMonthValue() == 4)
                                .filter(angajat -> angajat.getPostul().toLowerCase().contains("sef") || angajat.getPostul().toLowerCase().contains("director"))
                                .collect(Collectors.toList());
                        afisare(angajatiConducere);
                        break;
                    case 4:
                        List<Angajat> angajatiFaraConducere = angajati.stream()
                                .filter(angajat -> !angajat.getPostul().toLowerCase().contains("director") && !angajat.getPostul().toLowerCase().contains("sef"))
                                .sorted(Comparator.comparingDouble(Angajat::getSalariu).reversed())
                                .collect(Collectors.toList());
                        afisare(angajatiFaraConducere);
                        break;
                    case 5:
                        List<String> numeAngajatiMajuscule = angajati.stream()
                                .map(angajat -> angajat.getNume().toUpperCase())
                                .collect(Collectors.toList());
                        System.out.println(numeAngajatiMajuscule);
                        break;
                    case 6:
                        System.out.println("Salariile mai mici de 3000 RON: ");
                        angajati.stream()
                                .map(Angajat::getSalariu)
                                .filter(salariu -> salariu < 3000)
                                .forEach(System.out::println);
                        break;
                    case 7:
                        Optional<Angajat> primulAngajat = angajati.stream()
                                .min(Comparator.comparing(Angajat::getData_angajari));
                        primulAngajat.ifPresentOrElse(
                                angajat -> System.out.println("Primul angajat al firmei: " + angajat),
                                () -> System.out.println("Nu există angajați în firmă.")
                        );
                        break;
                    case 8:
                        DoubleSummaryStatistics statisticiSalarii = angajati.stream().collect(Collectors.summarizingDouble(Angajat::getSalariu));
                        System.out.println("Statistici salarii:");
                        System.out.println("Salariul mediu: " + statisticiSalarii.getAverage());
                        System.out.println("Salariul minim: " + statisticiSalarii.getMin());
                        System.out.println("Salariul maxim: " + statisticiSalarii.getMax());
                        break;
                    case 9:
                        boolean existaIon = angajati.stream()
                                .anyMatch(angajat -> angajat.getNume().equalsIgnoreCase("Ion"));
                        System.out.println(existaIon ? "Firma are cel puțin un Ion angajat." : "Firma nu are niciun Ion angajat.");
                        break;
                    case 10:
                        long numarAngajatiVaraAnulPrecedent = angajati.stream()
                                .filter(angajat -> angajat.getData_angajari().getYear() == LocalDate.now().getYear() - 1)
                                .filter(angajat -> angajat.getData_angajari().getMonthValue() >= 6 && angajat.getData_angajari().getMonthValue() <= 8)
                                .count();
                        System.out.println(numarAngajatiVaraAnulPrecedent);
                        break;
                }
            }while(true);}
    }