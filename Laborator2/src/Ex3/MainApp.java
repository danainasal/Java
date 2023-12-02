package Ex3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sirul initial este: ");
        String sir = scanner.nextLine();
        System.out.print("Sirul care trebuie introdus: ");
        String subsir = scanner.nextLine();
        System.out.print("Pozitia la care trebuie introdus este: ");
        int index = scanner.nextInt();

        System.out.println();

        String sir_nou = new String();
        for(int i = 0; i < sir.length(); i++)
        {
            sir_nou += sir.charAt(i);
            if(i == index)
                sir_nou += subsir;
        }
        System.out.println("Noul sir este: " +sir_nou);

        StringBuilder str = new StringBuilder(sir_nou);

        System.out.print("De la ce pozitie se va sterge: ");
        int x = scanner.nextInt();
        System.out.print("Cate caractere are subsirul: ");
        int y = scanner.nextInt();

        int z = x + y;

        StringBuilder afterRemoval = str.delete(x, z);

        System.out.println("Sirul dupa stergere este: " +afterRemoval);

    }
}