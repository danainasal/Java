package ex;

public class Echipament {
    private String denumire;
    private int nr_inv;
    private float pret;
    private String zona_mag;
    private Status status;
    public Echipament(String denumire, int nr_inv, float pret, String zona_mag,
                      Status status) {
        super();
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.status = status;
    }
    @Override
    public String toString() {
        return "\nEchipament [denumire=" + denumire + ", nr_inv=" + nr_inv + ", pret=" + pret + ", zona_mag=" + zona_mag + ", status="+ status + "]";
    }
    public String getDenumire() {
        return denumire;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
enum Status {achizitionat, expus, vandut};






