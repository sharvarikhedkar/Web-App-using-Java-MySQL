

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
 * Servlet implementation class Appoint_backend
 */
@WebServlet("/Appoint_backend")
public class Appoint_backend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Appoint_backend() {
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
		String cat=request.getParameter("cat");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		out.print("<h2 align='left'>Available Doctors :</h2>");
		
		try {
			int flag=0;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/patient","root","root");
			PreparedStatement ps=con.prepareStatement("select * from doctor");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			String i=rs.getString(7);
			String j=rs.getString(2);
			if(i.equals(cat)){
				flag++;
				out.print("<h4 align='left'>"+flag+". "+j+"	");
				out.print("<input type='submit' value='Select'><br></h4>");
				
			}
				
			}
			
			
		if(flag==0){
			out.print("No doctor available");
		}
		}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
