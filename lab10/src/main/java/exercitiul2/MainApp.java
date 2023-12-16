package exercitiul2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("db.xml");
        DatabaseOperations databaseOperations = (DatabaseOperations) context.getBean("operatiiJDBC");
        int optiune;
        do{
            printMenu();
            System.out.println("Optiunea este:");
        }


    }

    private static void printMenu()
    {
        System.out.println("1. Adaugare");
        System.out.println("2. Stergere");
        System.out.println("3. Cautare");
        System.out.println("4. Afisare tot");
        System.out.println("5. Afisare nr masini cu anumita marca");
        System.out.println("6. Afisare nr masini cu sub 100000 km");
        System.out.println("7. Afisare mai noi de 5 ani");
    }


}
