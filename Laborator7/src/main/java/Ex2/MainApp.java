package Ex2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) throws IOException {


        Set<InstrumentMuzical> instrumente = new HashSet<>();
        instrumente.add(new Chitara("Fender", 1500, TipChitara.ELECTRICA, 6));
        instrumente.add(new Chitara("Yamaha", 1000, TipChitara.ACUSTICA, 12));
        instrumente.add(new Chitara("Cordoba", 800, TipChitara.CLASICA, 6));
        instrumente.add(new SetTobe("Roland", 2500, TipTobe.ELECTRONICE, 5, 3));
        instrumente.add(new SetTobe("Pearl", 1800, TipTobe.ACUSTICE, 4, 2));
        instrumente.add(new SetTobe("Mapex", 3500, TipTobe.ACUSTICE, 3, 1));

        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
        try {
            mapper.writeValue(new File("src/main/resources/instrumente.json"), instrumente);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectMapper mapp = new ObjectMapper();
            Set<InstrumentMuzical> instrumenteSet = mapp.readValue(new File("src/main/resources/instrumente.json"), Set.class);

        } catch (IOException e) {
            e.printStackTrace();
        }


        Set<InstrumentMuzical> instrumenteCitite = new HashSet<>();
        System.out.println("\n 4 \n");
        System.out.println("Implementarea utilizata pentru interfata Set: " + instrumenteCitite.getClass());


        System.out.println("\n 5 \n");
        Chitara chitaraExistenta = new Chitara("Fender", 1500, TipChitara.ELECTRICA, 6);
        if (!instrumente.add(chitaraExistenta)) {
            System.out.println("Instrumentul exista deja in colectie.");
        } else {
            System.out.println("Instrument adaugat cu succes.");
        }


        System.out.println("\n 6 \n");
        instrumente.removeIf(instrument -> instrument.getPret() > 3000);
        System.out.println("Instrumente sterse!");

        System.out.println("\n 7 \n");
        instrumente.stream()
                .filter(instrument -> instrument instanceof Chitara)
                .forEach(System.out::println);

        System.out.println("\n 8 \n");
        instrumente.stream()
                .filter(instrument -> instrument instanceof SetTobe)
                .forEach(t -> System.out.println(t));

        System.out.println("\n 9 \n");
        instrumente.stream()
                .filter(instrument -> instrument instanceof Chitara)
                .map(instrument -> (Chitara) instrument)
                .max((c1, c2) -> c1.getNr_corzi() - c2.getNr_corzi())
                .ifPresent(System.out::println);

        System.out.println("\n 10 \n");
        instrumente.stream()
                .filter(instrument -> instrument instanceof SetTobe)
                .map(instrument -> (SetTobe) instrument)
                .filter(t -> t.getTip_tobe() == TipTobe.ACUSTICE)
                .sorted((t1, t2) -> t1.getNr_tobe() - t2.getNr_tobe())
                .forEach(System.out::println);
    }
}