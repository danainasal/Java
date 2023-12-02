package ex;

enum Mod_Scriere {
    AlbNegru,
    color
};
public class Imprimanta extends Echipament {
    private int ppm;
    private String rezolutie;
    private int p_car;
    private Mod_Scriere mod_scriere;
    public Imprimanta(String denumire, int nr_inv, float pret, String zona_mag, Status status, int ppm, String rezolutie, int p_car, Mod_Scriere mod_scriere) {
        super(denumire, nr_inv, pret, zona_mag, status);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.mod_scriere = mod_scriere;
    }
    @Override
    public String toString() {
        return super.toString()+"Imprimanta [ppm=" + ppm + ", rezolutie=" + rezolutie + ", p_car=" + p_car + ", mod_scriere=" + mod_scriere + "]";
    }

    public void setMod_scriere(Mod_Scriere mod_scriere) {
        this.mod_scriere = mod_scriere;
    }
}

