package Ex2;

import java.util.Scanner;
import java.io.*;

import static java.lang.Integer.parseInt;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        String nume_fis="in.txt";
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));
        int s=0;
        int i=0;
        int min=100;
        int max=0;
        float m;
        for(String line;(line=flux_in.readLine())!=null;)
        {
            s=s+parseInt(line);
            i++;
            if(parseInt(line)>max)
                max=parseInt(line);
            if(parseInt(line)<min)
                min=parseInt(line);
        }
        m=(float)s/i;
        System.out.println("Suma "+s);
        System.out.println("Media "+m);
        System.out.println("min "+min);
        System.out.println("max "+max);

        PrintStream flux_out=new PrintStream("out.txt");
        flux_out.println(s);
        flux_out.println(m);
        flux_out.println(min);
        flux_out.println(max);
    }
}