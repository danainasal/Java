package exercitiul1;

public class Tir extends Vehicul
{
    public Tir() {}

    public Tir( String marca,  float pret,  float incarcaturaMaxima)
    {
        super(marca, pret);
        this.incarcaturaMaxima = incarcaturaMaxima;
    }

    public float getIncarcaturaMaxima() {
        return incarcaturaMaxima;
    }

    public void setIncarcaturaMaxima(float incarcaturaMaxima_) {
        this.incarcaturaMaxima = incarcaturaMaxima_;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Incarcatura maxima: " + incarcaturaMaxima + "\n";
    }

    private float incarcaturaMaxima;
}
