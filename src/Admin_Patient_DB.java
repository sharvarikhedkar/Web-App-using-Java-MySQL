

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
 * Servlet implementation class Admin_Patient_DB
 */
@WebServlet("/Admin_Patient_DB")
public class Admin_Patient_DB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Patient_DB() {
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
			out.print("<h2 align='center'>Patient's Database</h2>");
			out.print("<table><tr><th>ID</th><th>Patient's Name</th><th>DOB</th><th>Gender</th><th>Email_ID</th><th>Mobile_No.</th></tr>");
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient","root","root");
				PreparedStatement ps=con.prepareStatement("select * from patient");
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
					out.print("</td></tr>");
				}
				
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}

}
