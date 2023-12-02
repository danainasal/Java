package Ex;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

    public class Angajat {
        private String nume;
        private String postul;
        private LocalDate data_angajari;
        private float salariu;

        public Angajat()
        {

        }
        public Angajat(String nume, String postul, LocalDate data_angajari, float salariu) {
            this.nume = nume;
            this.postul = postul;
            this.data_angajari = data_angajari;
            this.salariu = salariu;
        }

        public String getNume() {
            return nume;
        }

        public void setNume(String nume) {
            this.nume = nume;
        }

        public String getPostul() {
            return postul;
        }

        public void setPostul(String postul) {
            this.postul = postul;
        }

        public LocalDate getData_angajari() {
            return data_angajari;
        }

        public void setData_angajatorii(LocalDate data_angajatorii) {
            this.data_angajari = data_angajatorii;
        }

        public float getSalariu() {
            return salariu;
        }

        public void setSalariu(float salariu) {
            this.salariu = salariu;
        }

        @Override
        public String toString() {
            return  this.nume+","+this.postul+", "+this.data_angajari+", "+this.salariu;
    }

}
