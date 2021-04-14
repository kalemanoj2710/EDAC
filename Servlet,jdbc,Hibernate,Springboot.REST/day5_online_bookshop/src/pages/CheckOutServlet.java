package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDaoImpl;
import pojos.Book;
import pojos.Customer;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/check_out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set cont type
		response.setContentType("text/html");
		//get PW
		try(PrintWriter pw=response.getWriter())
		{
		//get HS from WC 
			HttpSession hs=request.getSession();
			System.out.println("from check out page session is new " + hs.isNew());// false
			System.out.println("session id " + hs.getId());// same session id
	
			//get clnt details from session scope
			Customer c=(Customer)hs.getAttribute("user_details");
			if(c != null)
			{
				pw.print("<h5> Hello ,  " + c.getName()+"</h5>");
				//get cart from HttpSession
				ArrayList<Integer> cart=(ArrayList<Integer>)hs.getAttribute("shopping_cart");
				pw.print("<h4>Cart Contents</h4>");
				//get book dao instance from HS
				BookDaoImpl bookDao=(BookDaoImpl)hs.getAttribute("book_dao");
				//invoke dao's method to get actual book details , for the book ids  present in the cart 
				double totalPrice=0;
				for(int i : cart)
				{
					Book b=bookDao.getBookDetailsById(i);
					pw.print("<h5>"+b+"</h5>");
					totalPrice += b.getPrice();				
				}
				pw.print("<h5>Cart Total Value"+totalPrice+"</h5>");
				
			}
			else 
				pw.print("<h5>No Cookies : session tracking failed!!!!</h5>");
			//invalidate Http Session
			hs.invalidate();
			pw.print("<h5> You have logged out....</h5>");
			//add visit again link
			pw.print("<h5> <a href='index.html'>Visit Again</a></h5>");
		} catch (Exception e) {
			throw new ServletException("err in do-get :"+getClass().getName(), e);
		}
	}

}
