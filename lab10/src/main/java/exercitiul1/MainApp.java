package exercitiul1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans_lab1.xml");
        Autoturism autoturismSetter=(Autoturism) context.getBean("autoturismSetter");
        Autoturism autoturismConstructor=(Autoturism) context.getBean("autoturismConstructor");
        Vehicul vehicul=(Vehicul) context.getBean("vehicul");
        Motocicleta motocicleta=(Motocicleta) context.getBean("motocicleta");
        System.out.println("Autoturism cu injectare folosind settere "+ autoturismSetter);
        System.out.println("Autoturism cu injectare folosind constructere "+ autoturismConstructor );
        System.out.println("Vehicul "+vehicul);
        System.out.println("Motocicleta "+motocicleta);
        ApplicationContext context1 = new ClassPathXmlApplicationContext("beans_lab2.xml");
        Tir tir=(Tir) context1.getBean("tir");
        System.out.println("Tir "+tir);
        ((ClassPathXmlApplicationContext)context).close();
        ((ClassPathXmlApplicationContext)context1).close();
    }
}
