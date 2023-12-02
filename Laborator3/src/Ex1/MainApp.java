package Ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws IOException {
        List<Parabola> parabole = new ArrayList<>();
        String nume_fis = "in.txt";
        try (BufferedReader flux_in = new BufferedReader(new FileReader(nume_fis))) {
            String linie;
            while ((linie = flux_in.readLine()) != null) {
                String[] coef = linie.split(" ");
                if (coef.length == 3) {
                    int a = Integer.parseInt(coef[0]);
                    int b = Integer.parseInt(coef[1]);
                    int c = Integer.parseInt(coef[2]);
                    Parabola parabola = new Parabola(a, b, c);
                    parabole.add(parabola);
                }
            }
        }
        for (Parabola parabola : parabole) {
            System.out.println(parabola);
            float[] vertex = parabola.vrfParabola();
            System.out.println("Vârful parabolei: (" + vertex[0] + ", " + vertex[1] + ")");
        }

        if (parabole.size() >= 2) {
            Parabola p1 = parabole.get(0);
            Parabola p2 = parabole.get(1);
            float[] mij = Parabola.mijloc(p1, p2);
            System.out.println("Mijlocul: (" + mij[0] + ", " + mij[1] + ")");
            float lungimeS = Parabola.lungime(p1, p2);
            System.out.println("Lungimea: " + lungimeS);
        }
    }
}
