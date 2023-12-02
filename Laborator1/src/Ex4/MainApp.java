package Ex4;

import java.util.Random;

public class MainApp {
    public static void main(String[] args){
        Random random=new Random();
        int a=random.nextInt(30);
        int b=random.nextInt(30);
        System.out.println("Numarul a: "+a);
        System.out.println("Numarul b: "+b);

        while(b!=0) {
            int cont = b;
            b=a%b;
            a=cont;
        }
        System.out.println("Cmmdc : "+a);
    }
}
