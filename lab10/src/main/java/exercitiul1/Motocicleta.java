package exercitiul1;

public class Motocicleta extends Vehicul
{
    public Motocicleta() {}

    public Motocicleta(final String marca, final float pret, final float vitezaMaxima)
    {
        super(marca, pret);
        this.vitezaMaxima = vitezaMaxima;
    }

    public float getVitezaMaxima() {
        return vitezaMaxima;
    }

    public void setVitezaMaxima(float vitezaMaxima_) {
        this.vitezaMaxima = vitezaMaxima_;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Viteza maxima: " + vitezaMaxima + "\n";
    }

    private float vitezaMaxima;
}
