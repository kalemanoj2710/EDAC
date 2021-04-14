package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException{
		System.out.println("in init" + Thread.currentThread());

	}
	@Override
	public void destroy(){
		System.out.println("in destroy" + Thread.currentThread());

	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException
			{
		System.out.println("in do-get" + Thread.currentThread());

		//set resp content type
		response.setContentType("text/html");
		//get char oriented buffered output stream to send the response from server to client
		try(PrintWriter pw=response.getWriter()){
			pw.print("<h4>Servlet deployed via annotation @"+new Date()+"</h4>");
		}
			}

}
