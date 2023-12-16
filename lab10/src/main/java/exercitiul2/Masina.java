package exercitiul2;

public class Masina
{
    public Masina() {}

    public Masina(final String numarInmatriculare, final String marca, final int anFabricatie,
                  final String culoare, final int numarKilometri)
    {
        numarInmatriculare_ = numarInmatriculare;
        marca_ = marca;
        anFabricatie_ = anFabricatie;
        culoare_ = culoare;
        numarKilometri_ = numarKilometri;
    }

    public Masina(final int id, final String numarInmatriculare, final String marca, final int anFabricatie,
                  final String culoare, final int numarKilometri)
    {
        id_ = id;
        numarInmatriculare_ = numarInmatriculare;
        marca_ = marca;
        anFabricatie_ = anFabricatie;
        culoare_ = culoare;
        numarKilometri_ = numarKilometri;
    }

    @Override
    public String toString() {
        return "Numar inmatriculare: " + numarInmatriculare_ + "\n" +
                "Marca: " + marca_ + "\n" +
                "An fabricatie: " + anFabricatie_ + "\n" +
                "Culoare: " + culoare_ + "\n" +
                "Numar kilometrii: " + numarKilometri_ + "\n";
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public void setNumarInmatriculare_(String numarInmatriculare_) {
        this.numarInmatriculare_ = numarInmatriculare_;
    }

    public void setMarca_(String marca_) {
        this.marca_ = marca_;
    }

    public void setAnFabricatie_(int anFabricatie_) {
        this.anFabricatie_ = anFabricatie_;
    }

    public void setCuloare_(String culoare_) {
        this.culoare_ = culoare_;
    }

    public void setNumarKilometri_(int numarKilometri_) {
        this.numarKilometri_ = numarKilometri_;
    }

    public String getMarca_() {
        return marca_;
    }

    public int getAnFabricatie_() {
        return anFabricatie_;
    }

    public int getId_() {
        return id_;
    }

    public int getNumarKilometri_() {
        return numarKilometri_;
    }

    public String getCuloare_() {
        return culoare_;
    }

    public String getNumarInmatriculare_() {
        return numarInmatriculare_;
    }

    private int id_;
    private String numarInmatriculare_;
    private String marca_;
    private int anFabricatie_;
    private String culoare_;
    private int numarKilometri_;
}