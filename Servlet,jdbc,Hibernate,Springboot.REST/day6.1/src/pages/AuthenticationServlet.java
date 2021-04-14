package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.jws.soap.InitParam;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDaoImpl;
import pojos.Customer;

/**
 * Servlet implementation class AuthenticationServlet
 */

public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDaoImpl customerDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public AuthenticationServlet() {
		System.out.println("in ctor of " + getClass().getName() + " " + getServletConfig());// null
	}

	public void init() throws ServletException {
		// create dao instance
		try {
			// get servlet specific init params from ServletConfig
			ServletConfig config = getServletConfig();
			customerDao = new CustomerDaoImpl(config.getInitParameter("drvr"), 
					config.getInitParameter("url"),
					config.getInitParameter("user"), config.getInitParameter("pwd"));
		} catch (Exception e) {
			// re throw the exc to the caller (WC) : to inform failure of init
			throw new ServletException("err in init : " + getClass().getName(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			customerDao.cleanUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace(); : sufficient!
			throw new RuntimeException("err in destroy : " + getClass().getName(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-post : " + getClass().getName());
		// set cont type
		response.setContentType("text/html");
		// get writer : PW
		try (PrintWriter pw = response.getWriter()) {
			// read request data : em , password from clnt 's request
			// API of ServletRequest : public String getParameter(String name)
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			System.out.println("in do-post " + email + " " + password);
			// invoke dao's method for authentication
			Customer customer = customerDao.authenticateUser(email, password);
			if (customer == null) {
				// failed login : send a mesg n retry link
				pw.print("<h5>Invalid Login , Please <a href='login.html'>Retry</a></h5>");

			} else {
				response.setStatus(HttpServletResponse.SC_CREATED);// 201
				// how to save validated clnt details under request scope ?
				request.setAttribute("user_details", customer);
				// success
				pw.print("<h5>Successful  Login mesg from Auth servlet </h5>");
				pw.flush(); // un comment this
//				pw.print("<h5> Customer Details : "+customer+"</h5>");
				// Use Server Pull : forward to navigate the clnt to the category page , in the
				// SAME request
				// managed by WC , in server space
				// API of ServletRequest
				// public RequestDispatcher getRequestDispatcher(String path);
				// 1
				RequestDispatcher rd = getServletContext().getRequestDispatcher("category");
				System.out.println("RD : " + rd.getClass().getName());// impl class name
				// 2 : RD's method
				// public void forward(ServletRequest rq,ServletResponse rs)
				// WC clears/discard/empties resp buffer
				rd.include(request, response);// IllegalStateException : can't forward after committing the resp
				System.out.println("came back in do-post : " + getClass().getName());
				pw.print("contents after include....");

			}

		} catch (Exception e) {
			throw new ServletException("err in do-post : " + getClass().getName(), e);
		}
	}

}
