package lab9;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public test1() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String url= "jdbc:mysql://localhost:3306/sys";
		Statement statement=null;
		ResultSet rs=null;
		String sql="select *from excursii";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url,"root","root");
		statement=connection.createStatement();
		if(request.getParameter("btnAdauga")==null&& request.getParameter("btnModifica")==null &&request.getParameter("btnSterge")==null)
			
		rs=statement.executeQuery(sql);
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Excursii</title></head><body>");
		out.println("<form method='get'>");
		out.println("<table align='center' width='50%' cellspacing='5'>");
		out.println("<tr><td align='right'>Id_persoana</td><td><input type='text'" 
		+" name='txtId_persoana' size='10'></td></tr>");
		out.println("<tr><td align='right'>ID</td><td><input type='text'"
				+ " name='txtid'></td></tr>");
				out.println("<tr><td align='right'>Destinatia</td><td><input type='text'"
				+ " name='txtdestinatia' size='5' maxlength='15'></td></tr>");
				out.println("<tr><td align='right'>Anul</td><td><input type='text'"
						+ " name='txtanul' size='5' maxlength='10'></td></tr>");
				out.println("<tr><td colspan='2' align='center'><input type='submit'"
				+ " name='btnAdauga' value='Adauga' style='width: 110px; height: 25px;'>");
				out.println("<input type='submit' name='btnModifica' value='Modifica'"
				+ " style='width: 110px; height: 25px;'>");
				out.println("<input type='submit' name='btnSterge' value='Sterge'"
				+ " style='width: 110px; height: 25px;'></td></tr>");
				out.println("</table></form>");
				out.println("<table align='center' width='50%' border='1'>");
				out.println("<tr><th>Id_persoana</th><th>Id</th><th>Destinatia</th><th>Anul</th></tr>");

				if(request.getParameter("btnAdauga")!=null)
				{
					int id_persoana=Integer.parseInt(request.getParameter("txtId_persoana"));
					int id=Integer.parseInt(request.getParameter("txtid"));
					String destinatia=request.getParameter("txtdestinatia");
					Time anul=Time.valueOf(request.getParameter("txtanul"));
					String sql1="Insert into excursii values (?,?,?,?)";
					try {
					PreparedStatement ps=connection.prepareStatement(sql1);
					ps.setInt(1,id_persoana);
					ps.setInt(2, id);
					ps.setString(3, destinatia);
					ps.setTime(4, anul);
					ps.executeUpdate();
					rs.getStatement().executeQuery(sql);
					
					
				}
					catch(SQLException e)
					{
						System.out.println(sql1+"/n"+e);
					}
				}
				while(rs.next())
					out.println("<tr><td>"+rs.getInt("Id_persoana")+"</td><td>"+ rs.getInt("id")
					+ "</td><td>"+rs.getString(3)+"</td><td>"+ rs.getTime("anul")+"</td><tr>");
					out.println("</table></body></html>");
					rs.close();
					statement.close();
					connection.close();
			
		}
		
			
		catch (Exception ex) {
							
			System.out.println(ex);
						} 
	
	}
}
	

