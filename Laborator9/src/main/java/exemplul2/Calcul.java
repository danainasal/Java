package exemplul2;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Calcul")
public class Calcul extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Calcul() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nr1=request.getParameter("nr1");
		String nr2=request.getParameter("nr2");
		PrintWriter out=response.getWriter();
	
		out.println("<html><head><title>Rezultatul</title></head><body>" );
		if(nr1==null|| nr2==null)
		{
			out.println("Rulati intai fisierul NewFile.html</body></html>");
		}
		else
			try {
				int x=Integer.parseInt(nr1);
				int y=Integer.parseInt(nr2);
				int suma=x+y;
				out.println("Suma numerelor este "+suma+"</body></html>");
			}
		catch(Exception ex)
		{
			out.println("valori lipsa</body></html>");
		}
		
	}
}
