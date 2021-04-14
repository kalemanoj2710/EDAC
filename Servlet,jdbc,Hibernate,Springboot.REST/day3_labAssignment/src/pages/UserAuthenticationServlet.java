package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VoterDaoImpl;
import pojo.Voter;

/**
 * Servlet implementation class UserAuthenticationServlet
 */
@WebServlet(value="/validate",loadOnStartup=1)
public class UserAuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	VoterDaoImpl voterDao;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// create Dao instance
		try {
			 voterDao = new VoterDaoImpl();
		} catch (Exception e) {
			throw new ServletException("Error in init(Voter) "+getClass().getName(),e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	try {
		voterDao.cleanup();
	} catch (SQLException e) {
		
		e.printStackTrace();
		throw new RuntimeException("err in destry(Voter) :"+getClass().getCanonicalName(),e);
	}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set content type
		response.setContentType("text/html");
		//get writer
		try(PrintWriter pw=response.getWriter() ){
			//read req data from client we gave name for para email and pass as em and pass resp in login.html
			String email=request.getParameter("em");
			String password =request.getParameter("pass");
			System.out.println("in do-post"+email+" "+password);
			Voter voter=voterDao.validateUser(email, password);
			if(voter==null)
			{
				pw.print("<h5>Invalid Credentials (email or pass or both), Please <a href='login.html'>Retry</a></h5>");
			}
			else
			{

				pw.print("<h3>Succesful Login</h3>");
				pw.print("<h5>Coustomer Details"+voter+"</h5>");
			
				pw.print(voter);
			}	
			
			
			
		}catch(Exception e1) {
			throw new ServletException("Error in do-post :"+getClass().getName(),e1);
		}
		doGet(request, response);
	}

}
