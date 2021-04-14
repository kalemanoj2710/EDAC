package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Customer;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-post : "+getClass().getName());
		// set cont type
		response.setContentType("text/html");
		// get writer : PW
		PrintWriter pw = response.getWriter();
			pw.print("<h5>Successful  Login from Catgeory Page.... </h5>");
			// get validated clnt details from request scope
			Customer customer = (Customer) request.getAttribute("user_details");
			if (customer != null)
				pw.print("<h5> Customer Details from request  " + customer+"</h5>");
			else
				pw.print("<h5> Request Dispatching  failed!!!!!!!</h5>");

		
	}

}
