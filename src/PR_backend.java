

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
 * Servlet implementation class PR_backend
 */
@WebServlet("/PR_backend")
public class PR_backend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PR_backend() {
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

		String name=request.getParameter("nname");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		int mob=Integer.parseInt(request.getParameter("num"));
		String pass=request.getParameter("pass");
		PrintWriter out=response.getWriter();
		//out.print("retrieved successfully");
		try
		{
			int id=0;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/patient","root","root");
			PreparedStatement ps=con.prepareStatement("select max(id) from patient");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				id=rs.getInt(1);
				id++;
				PreparedStatement p=con.prepareStatement("insert into patient values(?,?,?,?,?,?,?)");
				p.setInt(1,id);
				p.setString(2,name);
				p.setString(3,dob);
				p.setString(4,gender);
				p.setString(5,email);
				p.setInt(6,mob);
				p.setString(7,pass);
				int i=p.executeUpdate();
				if(i>0){
					out.print("<h2 align='center'>Registration successful/h3>");
					out.print("<h4 align='center'><a href='Patient_Login.html'>LOGIN</a></h4>");
					}
				else{
					out.print("Error occurred...");
				//	out.print("<form action='Patient_Login.html' method='post'>");
				}
			
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
