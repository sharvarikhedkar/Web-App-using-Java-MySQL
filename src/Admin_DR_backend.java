

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
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
 * Servlet implementation class Admin_DR_backend
 */
@WebServlet("/Admin_DR_backend")
public class Admin_DR_backend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_DR_backend() {
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
		String name=request.getParameter("dname");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		long mob=Integer.parseInt(request.getParameter("num"));
		String spc=request.getParameter("spc");
		String pass=request.getParameter("pass");
		PrintWriter out=response.getWriter();
		try{
			int id=0;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/patient","root","root");
			PreparedStatement ps=con.prepareStatement("select max(id) from doctor");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				id=rs.getInt(1);
				id++;
				PreparedStatement p=con.prepareStatement("insert into doctor values(?,?,?,?,?,?,?,?)");
				p.setInt(1,id);
				p.setString(2,name);
				p.setString(3,dob);
				p.setString(4,gender);
				p.setString(5,email);
				p.setLong(6,mob);
				p.setString(7,spc);
				p.setString(8,pass);
				int i=p.executeUpdate();
				if(i>0){
					out.print("Doctor Registration Successful");
					}
				else{
					out.print("Error occurred...");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
