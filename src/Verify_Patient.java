

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
 * Servlet implementation class Verify_Patient
 */
@WebServlet("/Verify_Patient")
public class Verify_Patient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verify_Patient() {
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
		int flag=0;
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String pass= request.getParameter("pass");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/patient","root","root");
			PreparedStatement ps=con.prepareStatement("select * from patient");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			String i= rs.getString(5);
			String j=rs.getString(7);
			
				if(uname.equals(i) && pass.equals(j))	
				{
					flag=1;
					request.getRequestDispatcher("Patient_Appointment").forward(request, response);				
				}
				
			}
			if(flag==0){
				out.print("Invalid credentials");
			}
			
		}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}
		
	


