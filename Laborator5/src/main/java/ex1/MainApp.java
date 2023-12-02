package ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainApp {
    public static void scriere(List<PerecheNumere> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("OUTPerecheNumere.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PerecheNumere> citire() {
        try {
            File file = new File("INPerecheNumere.json");
            ObjectMapper mapper = new ObjectMapper();
            List<PerecheNumere> persoane = mapper.readValue(file, new TypeReference<List<PerecheNumere>>() {
                    });
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<PerecheNumere> lista_perechi_numere = citire();

        //adaugare perechi de numere
        lista_perechi_numere.add(new PerecheNumere(3, 5));
        lista_perechi_numere.add(new PerecheNumere(101, 2));
        lista_perechi_numere.add(new PerecheNumere(1, 1));

        scriere(lista_perechi_numere);

    }
}
