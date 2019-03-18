package Library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection con=Login.getConnection();
		PrintWriter pw = response.getWriter();
		pw.print("<h3>Welcome to EmployeeIMS </h3>");
		
		
		String newpassword=request.getParameter("newpassw").trim();
		String confirmpassword=request.getParameter("passw").trim();
		String username = request.getParameter("username").trim();
		System.out.println(username);
	//if(Login.validate(username,newpassword,confirmpassword, con)) {
		
		if(username==""||confirmpassword==""||newpassword=="")
		{
			//RequestDispatcher rd = request.getRequestDispatcher("NewFile.html");
			//rd.include(request,response);
			pw.print("All fields are mandatory");
		
		}
		
	else if(newpassword.equals(confirmpassword))
				{
					
					RequestDispatcher rd = request.getRequestDispatcher("LoginPage.html");
					rd.forward(request,response);
				
					
				}
				
	
		else
		{
			
			//RequestDispatcher rd = request.getRequestDispatcher("NewFile.html");
			//rd.include(request,response);	
			pw.print("<b>You have entered wrong usernmae and password</b>");
			
		}
		
	
		
}


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
