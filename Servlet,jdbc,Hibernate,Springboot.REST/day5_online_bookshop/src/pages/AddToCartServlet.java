package pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/add_to_cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get HS from WC
		HttpSession hs = request.getSession();
		//get cart from HS
		ArrayList<Integer> cart=(ArrayList<Integer>)hs.getAttribute("shopping_cart");
		if(cart != null)
		{
			//get selected book ids from the request , parse --> populate the cart
			String[] ids=request.getParameterValues("bid");
			for(String s : ids)
				cart.add(Integer.parseInt(s));
		}
		System.out.println("cart contents "+cart);
		//redirect clnt to category page in the NEXT request
		response.sendRedirect("category");
		

	}

}
