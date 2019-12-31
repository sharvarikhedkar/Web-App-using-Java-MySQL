

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin_Doctor_DB
 */
@WebServlet("/Admin_Doctor_DB")
public class Admin_Doctor_DB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Doctor_DB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.print("<h2 align='center'>Doctor's Database</h2>");
		out.print("<table><tr><th>ID</th><th>Doctor's Name</th><th>DOB</th><th>Gender</th><th>Email_ID</th><th>Mobile_No.</th><th>Specialist_In</th></tr>");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient","root","root");
			PreparedStatement ps=con.prepareStatement("select * from doctor");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				out.print("<tr><td>");
				out.print(rs.getInt(1));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(3));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(4));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(5));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(6));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(7));
				out.print("</td></tr>");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
