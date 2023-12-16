package exercitiul1;

public class Autoturism extends Vehicul
{
    public Autoturism() {}

    public Autoturism( String marca, float pret, float volumPortbagaj, float greutate)
    {
        super(marca, pret);
        this.volumPortbagaj = volumPortbagaj;
        this.greutate = greutate;
    }

    public float getVolumPortbagaj() {
        return volumPortbagaj;
    }

    public void setVolumPortbagaj(float volumPortbagaj_) {
        this.volumPortbagaj = volumPortbagaj_;
    }

    public float getGreutate() {
        return greutate;
    }

    public void setGreutate(float greutate_) {
        this.greutate = greutate_;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Volum portbagaj: " + volumPortbagaj + "\n" +
                "Greutate: " + greutate + "\n";
    }

    private float volumPortbagaj;
    private float greutate;
}
