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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type
		response.setContentType("text/html");
		// get writer : PW
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5>Successful  Login from Catgeory Page.... </h5>");
			// get HS from WC (rets : existing HS object)
			HttpSession hs = request.getSession();
			System.out.println("from category page session is new " + hs.isNew());// false
			System.out.println("session id " + hs.getId());// same session id
			// get validated clnt details from session scope
			Customer customer = (Customer) hs.getAttribute("user_details");
			if (customer != null)
				pw.print("<h5> Customer Details from Session " + customer+"</h5>");
			else
				pw.print("<h5> No Cookies : Session Tracking fails!!!!!!!</h5>");
			// add a check out link
			pw.print("<h5> <a href='check_out'>Check Out</a></h5>");

		}
	}

}
