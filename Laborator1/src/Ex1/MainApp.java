package Ex1;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("L= ");
        int L=scanner.nextInt();
        System.out.println("Lungimea "+L);
        System.out.print("l= ");
        int l=scanner.nextInt();
        System.out.println("Latimea "+l);
        System.out.println("--------- ");
        System.out.println("Perimetru "+2*(L+l));
        System.out.println("Arie "+(L*l));
        scanner.close();
    }
}
