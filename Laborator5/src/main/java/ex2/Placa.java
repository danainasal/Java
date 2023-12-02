package ex2;

import java.util.Arrays;
import java.util.List;
enum Orientare { LUNGIME, LATIME, ORICARE }
public class Placa {
        private String descriere;
        private int lungime;
        private int latime;
        private Orientare orientare;
        private boolean[] canturi;
        private int nr_bucati;

        @Override
        public String toString()
        {
            return "Placa{" + " descriere = '" + descriere + '\'' + ", lungime = " + lungime + ", latime = " + latime + ", orientare = " + orientare + ", canturi = " + Arrays.toString(canturi) + ", nr_bucati = " + nr_bucati + '}';
        }
        public Placa() {}
        public Placa(String descriere, int lungime, int latime, Orientare orientare, boolean[] canturi, int nr_bucati)
        {
            this.descriere = descriere;
            this.lungime = lungime;
            this.latime = latime;
            this.orientare = orientare;
            this.canturi = canturi;
            this.nr_bucati = nr_bucati;
        }

        public String getDescriere()
        {
            return descriere;
        }

        public int getLungime()
        {
            return lungime;
        }

        public int getLatime()
        {
            return latime;
        }

        public Orientare getOrientare()
        {
            return orientare;
        }

        public boolean[] getCanturi()
        {
            return canturi;
        }

        public int getNr_bucati()
        {
            return nr_bucati;
        }
    }

