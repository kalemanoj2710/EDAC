package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SecondServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void init()
	{
		System.out.println("in init123"+Thread.currentThread());
	}
	@Override
	public void destroy()
	{
		System.out.println("in destroy123"+Thread.currentThread());
	}
	@Override 
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException ,IOException
	{
		System.out.println("in do-Get123"+Thread.currentThread());
	//set response content type
		response.setContentType("text/html");
		//get char oriented , bufferd o/p stream , to send response from server ---> clnt
	   try(PrintWriter pw=response.getWriter())
	   {
		pw.print("<h4>Servlet deplyed via xml @ "+LocalDateTime.now()+"</h4>");   
	   }
	}
}
