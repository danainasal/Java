package ex;

public class Copiator extends Echipament {
    public void setFormatCopiere(FormatCopiere formatCopiere) {
        this.formatCopiere = formatCopiere;
    }
    private int p_ton;
    private FormatCopiere formatCopiere;
    public Copiator(String denumire, int nr_inv, float pret, String zona_mag, Status status, int p_ton, FormatCopiere formatCopiere) {
        super(denumire, nr_inv, pret, zona_mag, status);
        this.p_ton = p_ton;
        this.formatCopiere = formatCopiere;
    }
    @Override
    public String toString() {
        return super.toString()+"Copiator "+ ", p_ton=" + p_ton + ", formatCopiere=" + formatCopiere + "]";
    }
}

enum FormatCopiere {
    A3,
    A4
};
