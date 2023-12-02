package Ex3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a= ");
        int a=scanner.nextInt();
        int contor=0;
        for(int i=2;i<a;i++) {
            if (a % i == 0) {
                contor++;
                System.out.println("Divizorii sunt: " + i);
            }
        }
        if(contor==0)
            System.out.println("Numar prim ");
    }
}


