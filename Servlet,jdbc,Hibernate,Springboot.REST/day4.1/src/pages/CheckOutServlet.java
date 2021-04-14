package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/check_out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set cont type
		response.setContentType("text/html");
		//get PW
		try(PrintWriter pw=response.getWriter())
		{
			//get cookies from the req header 
			Cookie[] cookies=request.getCookies();
			if(cookies != null)
			{
				for(Cookie c : cookies)
				{
					if(c.getName().equals("clnt_details"))
					{
						pw.print("<h5> Customer Details from Check out page : "+c.getValue()+"</h5>");
						//to request clnt browser to delete the cookie
						c.setMaxAge(0);
						//add the cookie to resp header AGAIN , to be sent to clnt
						response.addCookie(c);
						break;
					}
				}
			}
			else 
				pw.print("<h5>No Cookies : session tracking failed!!!!</h5>");
			pw.print("<h5> You have logged out....</h5>");
			//add visit again link
			pw.print("<h5> <a href='index.html'>Visit Again</a></h5>");
		}
	}

}
