package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns ={"/test1","/test2"},loadOnStartup=1)
public class HellowServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void init()
	{
		System.out.println("in init"+Thread.currentThread());
	}
	@Override
	public void destroy()
	{
		System.out.println("in destroy"+Thread.currentThread());
	}
	@Override 
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException ,IOException
	{
		System.out.println("in do-Get"+Thread.currentThread());
	//set response content type
		response.setContentType("text/html");
		//get char oriented , bufferd o/p stream , to send response from server ---> clnt
	   try(PrintWriter pw=response.getWriter())
	   {
		pw.print("<h4>Servlet deplyed via annotation @ "+new Date()+"</h4>");   
	   }
	}
}
