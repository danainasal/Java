package ex2;
import java.util.List;
public class Mobilier {
    private String nume;
    private List<Placa> placi;

    public Mobilier() {}
    public Mobilier(String nume, List<Placa> placi)
    {
        this.nume = nume;
        this.placi = placi;
    }

    public String getNume() {
        return nume;
    }

    public List<Placa> getPlaci() {
        return placi;
    }
}
