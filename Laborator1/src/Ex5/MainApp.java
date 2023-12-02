package Ex5;

import java.util.Random;

public class MainApp {
    public static void main(String[] args){
        Random random=new Random();
        int n=random.nextInt(21);
        System.out.println("Numar: "+n);

        if(n==1)
            System.out.println("Apartine sirului lui Fobonacci ");
        else {
            int a = 0,b = 1,c;
            int cont=0;
            do {
                c=a+b;
                a=b;
                b=c;
                if(n==c)
                {
                    cont=1;
                    System.out.println("Apartine sirului lui Fobonacci ");
                }
            }while(c<=n);

            if (cont == 0)
                System.out.println("Numarul nu apartine sirului lui Fobonacci ");
        }
    }
}


