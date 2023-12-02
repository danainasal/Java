package ex1;

public class PerecheNumere {
    private int numar1, numar2;

    public PerecheNumere(){};

    public PerecheNumere( int numar1,  int numar2) {
        this.numar1 = numar1;
        this.numar2 = numar2;
    };

    public boolean isFibonaci () {
        int a = 0, b = 1, c;
        c = a + b;
        if((numar1 == a && numar2 == b) || (numar1 == b && numar2 == c))
            return true;
        while(c <= numar2)
        {
            a = b;
            b = c;
            c = a + b;
            if (numar1 == b && numar2 == c)
                return true;
        }
        return false;

    };

    public int cmmmc () {
        int a, b;
        a = this.numar1;
        b = this.numar2;

        while(b!=0) {
            int temp=a%b;
            a=b;
            b=temp;
        }
    int cm=a;
        return (numar1*numar2)/cm;
    }

    public boolean isSumaCifreEgala() {
        int n1 = this.numar1, n2 = this.numar2;
        int s1 = 0, s2 = 0;

        while (n1 > 0) {
            s1 = s1 + n1 % 10;
            n1 = n1 / 10;
        };

        while (n2 > 0 ) {
            s2 = s2 + n2 % 10;
            n2 = n2 / 10;
        }

        if(s1 == s2) {
            return true;
        } else {
            return false;
        }

    }

    public int egal(int nr)
    {
        int cont = 0;
        while (nr > 0)
        {
            if(nr % 2 == 0)
                cont++;
            nr = nr / 10;
        }
        return cont;
    }
    public boolean isAcelasiNumarDeCifrePare () {

        if(egal(numar1) == egal(numar2)) {
            return true;
        } else {
            return false;
        }
    }


    public  int getNumar1() {
        return numar1;
    }

    public void setNumar1( int numar1) {
        this.numar1 = numar1;
    }

    public  int getNumar2() {
        return numar2;
    }

    public void setNumar2( int numar2) {
        this.numar2 = numar2;
    }

    @Override
    public String toString() {
        return  this.numar1 + " : " + this.numar2;
    }
}
