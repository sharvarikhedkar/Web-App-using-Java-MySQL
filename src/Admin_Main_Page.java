

import java.awt.Desktop.Action;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin_Main_Page
 */
@WebServlet("/Admin_Main_Page")
public class Admin_Main_Page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Main_Page() {
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
		out.print("<h2 align='center'>WELCOME ADMIN..!!</h2>");
		out.print("<h3 align='center'>Select Your Interest</h3>");
		out.print("<h4 align='center'><form action='Admin_Doctor_DB' method='post'>");
		out.print("<input type='submit' value='Doctors Database'>");
		out.print("</h4></form>");
		
		out.print("<h4 align='center'><form action='Admin_Add_Doctor.html'>");
		out.print("<input type='submit' value='Add Doctor'>");
		out.print("</h4></form>");
		
		out.print("<h4 align='center'><form action='Admin_Patient_DB' method='post'>");
		out.print("<input type='submit' value='Patients Database'>");
		out.print("</h4></form>");
	}

}
