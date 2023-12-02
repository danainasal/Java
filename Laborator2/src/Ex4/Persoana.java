package Ex4;

import java.time.LocalDate;
import java.time.Period;
public class Persoana {
    private String nume, cnp;

    Persoana(String nume, String cnp)
    {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume()
    {
        return nume;
    }

    public String getCnp()
    {
        return cnp;
    }

    public int getVarsta()
    {
        String an, luna, ziua, data;

        //an
        if(cnp.charAt(0) == '1' || cnp.charAt(0) == '2')
            an = "19";
        else
            an = "20";
        an = an + cnp.charAt(1) + cnp.charAt(2);

        //luna
        luna = "" + cnp.charAt(3) + cnp.charAt(4);

        //ziua
        ziua = "" + cnp.charAt(5) + cnp.charAt(6);

        data = an + "-" + luna + "-" + ziua;
        LocalDate dob = LocalDate.parse(data);
        LocalDate nowDate = LocalDate.now();

        return Period.between(dob, nowDate).getYears();
    }
}