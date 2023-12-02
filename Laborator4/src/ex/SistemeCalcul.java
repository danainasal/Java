package ex;

public class SistemeCalcul extends Echipament {
    private String tip_mon;

    private float vit_proc;
    private int c_hdd;
    private oS OS;
    public SistemeCalcul(String denumire, int nr_inv, float pret, String zona_mag, Status status, String tip_mon, float vit_proc, int c_hdd, oS oS) {
        super(denumire, nr_inv, pret, zona_mag, status);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        OS = oS;
    }
    @Override
    public String toString() {
        return super.toString()+"SistemCalcul [tip_mon=" + tip_mon + ", vit_proc=" + vit_proc + ", c_hdd=" + c_hdd + ", OS=" + OS + "]";
    }
}

enum oS {instalWin, instalLinux, windows, linux};
