package Ex2;

import java.time.LocalDate;

public class Produs {
        private String denumire;
        private float pret;
        private int cantitate;
        private LocalDate dataExpirarii;

        public Produs(String denumire, float pret, int cantitate, LocalDate dataExpirarii) {
            this.denumire = denumire;
            this.pret = pret;
            this.cantitate = cantitate;
            this.dataExpirarii = dataExpirarii;
        }

        public String getDenumire() {
            return denumire;
        }

        public float getPret() {
            return pret;
        }

        public int getCantitate() {
            return cantitate;
        }

        public LocalDate getDataExpirarii() {
            return dataExpirarii;
        }


        public void setCantitate(int cantitate) {
            this.cantitate = cantitate;
        }

        @Override
        public String toString() {
            return denumire + ", " + pret + ", " + cantitate + ", " + dataExpirarii;
        }

}
