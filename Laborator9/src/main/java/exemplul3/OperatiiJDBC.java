package exemplul3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/OperatiiJDBC")
public class OperatiiJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public OperatiiJDBC() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
		String url= "jdbc:mysql://localhost:3306/sys";
		Statement statement=null;
		ResultSet rs=null;
		String sql="select *from persoane";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url,"root","root");
		statement=connection.createStatement();

		if(request.getParameter("btnAdauga")==null&& request.getParameter("btnModifica")==null &&request.getParameter("btnSterge")==null)
			
		 rs=statement.executeQuery(sql);
		
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Persoane</title></head><body>");
		out.println("<form method='get'>");
		out.println("<table align='center' width='50%' cellspacing='5'>");
		out.println("<tr><td align='right'>Id</td><td><input type='text'" 
		+" name='txtId' size='5'></td></tr>");
		out.println("<tr><td align='right'>Nume</td><td><input type='text'"
				+ " name='txtNume'></td></tr>");
				out.println("<tr><td align='right'>Varsta</td><td><input type='text'"
				+ " name='txtVarsta' size='5' maxlength='3'></td></tr>");
				out.println("<tr><td colspan='2' align='center'><input type='submit'"
				+ " name='btnAdauga' value='Adauga' style='width: 110px; height: 25px;'>");
				out.println("<input type='submit' name='btnModifica' value='Modifica'"
				+ " style='width: 110px; height: 25px;'>");
				out.println("<input type='submit' name='btnSterge' value='Sterge'"
				+ " style='width: 110px; height: 25px;'></td></tr>");
				out.println("</table></form>");
				out.println("<table align='center' width='50%' border='1'>");
				out.println("<tr><th>Id</th><th>Nume</th><th>Varsta</th></tr>");
		if(request.getParameter("btnAdauga")!=null)
		{
			int id=Integer.parseInt(request.getParameter("txtId"));
			String nume=request.getParameter("txtNume");
			int varsta=Integer.parseInt(request.getParameter("txtVarsta"));
			String comanda="insert into persoane values(?,?,?)";
			try {
			PreparedStatement ps=connection.prepareStatement(comanda);
			ps.setInt(1, id);
			ps.setString(2, nume);
			ps.setInt(3, varsta);
			ps.executeUpdate();
			ps.close();
			rs=statement.executeQuery("select *from persoane");
		}
			catch(SQLException e)
			{
				System.out.println(comanda+"/n"+e);
			}
		}
		if(request.getParameter("btnModifica")!=null)
		{
			int id1=Integer.parseInt(request.getParameter("txtId"));
			String nume1=request.getParameter("txtNume");
			int varsta1=Integer.parseInt(request.getParameter("txtVarsta"));
			String comanda1="update persoane set nume=?, varsta=? where id=?";
			try {
			PreparedStatement ps=connection.prepareStatement(comanda1);
			ps.setString(1, nume1);
			ps.setInt(2, varsta1);
			ps.setInt(3, id1);
			ps.executeUpdate();
			ps.close();
			rs=statement.executeQuery("select *from persoane");
		}catch(SQLException e)
			{
			System.out.println(comanda1+"/n"+e);
			}
		}

		if(request.getParameter("btnSterge")!=null)
		{
			int id2=Integer.parseInt(request.getParameter("txtId"));
			
			String comanda2="delete from persoane where id=?";
			try {
			PreparedStatement ps=connection.prepareStatement(comanda2);
			ps.setInt(1, id2);
			ps.executeUpdate();
			ps.close();
			rs=statement.executeQuery("select *from persoane");
		}
			catch(SQLException e)
			{
				System.out.println(comanda2+"/n"+e);
			}
		}
		while(rs.next())
			out.println("<tr><td>"+rs.getInt("Id")+"</td><td>"+ rs.getString("nume")
			+ "</td><td>"+rs.getInt(3)+"</td><tr>");
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
