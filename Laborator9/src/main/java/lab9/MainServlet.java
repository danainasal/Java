package lab9;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Set<Persoana> persoane=new HashSet<>();
 
   
    public MainServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  if ("Adaugare".equals(request.getParameter("adaugare"))) {
		        response.getWriter().append("<html><body>"
		                + "<form method='post' action='" + request.getContextPath() + "/MainServlet'>"
		                + "Nume si prenume: <input type='text' name='nume'><br>"
		                + "Data nasterii (YYYY-MM-DD): <input type='date' name='dataNasterii'><br>"
		                + "Adresa: <input type='text' name='adresa'><br>"
		                + "Telefon: <input type='text' name='telefon'><br>"
		                + "<input type='submit' name='adaugare' value='Adaugare'>"
		                + "</form>");

		        response.getWriter().append("<form method='post' action='" + request.getContextPath() + "/MainServlet'>"
		                + "<input type='hidden' name='adaugare' value='Adaugare'>"
		                + "<input type='submit' name='vizualizare' value='Vizualizare'>"
		                + "</form>");
		    } else {
		        response.getWriter().append("<html><body>"
		                + "<form method='post' action='" + request.getContextPath() + "/MainServlet'>"
		                + "Nume si prenume: <input type='text' name='nume'><br>"
		                + "Data nasterii (YYYY-MM-DD): <input type='date' name='dataNasterii'><br>"
		                + "Adresa: <input type='text' name='adresa'><br>"
		                + "Telefon: <input type='text' name='telefon'><br>"
		                + "<input type='submit' name='adaugare' value='Adaugare'>"
		                + "</form>");
		    }
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nume=request.getParameter("nume");
		String datanasteriiParam=request.getParameter("dataNasterii");
		if(datanasteriiParam!=null)
		{
			LocalDate datanasterii=LocalDate.parse(datanasteriiParam);
		
		String adresa=request.getParameter("adresa");
		String telefon=request.getParameter("telefon");
		Persoana pers=new Persoana(nume,datanasterii,adresa,telefon);
		persoane.add(pers);
		}
		if ("Adaugare".equals(request.getParameter("adaugare"))) {
			response.getWriter().append("<html><body><table border='1'>"
                    + "<tr><th>Nume si prenume</th><th>Data Nasterii</th><th>Adresa</th><th>Telefon</th></tr>");

            for (Persoana persoana : persoane) {
                response.getWriter().append("<tr><td>" + persoana.getNume() + "</td>"
                        + "<td>" + persoana.getDatanasterii() + "</td>"
                        + "<td>" + persoana.getAdresa() + "</td>"
                        + "<td>" + persoana.getTelefon() + "</td></tr>");
            }

            response.getWriter().append("</table>");

       
            response.getWriter().append("<form method='post' action='" + request.getContextPath() + "/MainServlet'>"
                    + "<input type='hidden' name='vizualizare' value='Vizualizare'>"
                    + "Luna de nastere: <input type='text' name='luna'><br>"
                    + "<input type='submit' value='Vizualizare'>"
                    + "</form></body></html>");
		}

		if ("Vizualizare".equals(request.getParameter("vizualizare"))) {
		    String lunaselectata = request.getParameter("luna");
		    response.getWriter().append("<html><body><table border='1'>"
		            + "<tr><th>Nume</th><th>Data Nasterii</th><th>Adresa</th><th>Telefon</th></tr>");

		    boolean gasitPersoane = false;

		    for (Persoana persoana : persoane) {
		    	if (persoana.getDatanasterii().getMonthValue() == Integer.parseInt(lunaselectata)) {
		            response.getWriter().append("<tr><td>" + persoana.getNume() + "</td>"
		                    + "<td>" + persoana.getDatanasterii() + "</td>"
		                    + "<td>" + persoana.getAdresa() + "</td>"
		                    + "<td>" + persoana.getTelefon() + "</td></tr>");
		            gasitPersoane = true;
		        }
		    }

		    if (!gasitPersoane) {
		        response.getWriter().append("<tr><td colspan='4'>Nu exista persoane cu luna de nastere selectata</td></tr>");
		    }

		    response.getWriter().append("</table></body></html>");

	}
	}
}

