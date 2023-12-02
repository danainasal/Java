package Ex1;

public class Parabola {
    private int a, b, c;
    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }

    public float[] vrfParabola() {
        float xVf = (float) (-b / (2.0 * a));
        float yVf = (float) ((-b + 4.0 * a * c) / (4.0 * a));
        return new float[] {xVf, yVf};
    }

    public static float[] mijloc(Parabola p1, Parabola p2) {
        float[] vrf1 = p1.vrfParabola();
        float[] vrf2 = p2.vrfParabola();
        float xMj = (float) ((vrf1[0] + vrf2[0]) / 2.0);
        float yMj = (float) ((vrf1[1] + vrf2[1]) / 2.0);
        return new float[] {xMj, yMj};
    }

    public static float lungime(Parabola p1, Parabola p2) {
        float[] vrf1 = p1.vrfParabola();
        float[] vrf2 = p2.vrfParabola();
        return (float) Math.hypot(vrf2[0] - vrf1[0], vrf2[1] - vrf1[1]);
    }

}

