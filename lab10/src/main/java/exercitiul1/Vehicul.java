package exercitiul1;

public class Vehicul
{
    public Vehicul() {}

    public Vehicul( String marca, float pret)
    {
        this.marca = marca;
        this.pret = pret;
    }

    public float getPret() {
        return pret;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + "\n" +
                "Pret: " + pret + "\n";
    }

    private String marca;
    private float pret;
}
