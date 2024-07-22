package task;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/pr")
public class PrimeServlet extends GenericServlet{
	@Override
  public void service(ServletRequest req,ServletResponse res)throws
  ServletException,IOException{
	  int v1 = Integer.parseInt(req.getParameter("v1"));
	  boolean v2=isPrime(v1);
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  pw.println("Prime="+v2+"<br>");
	  RequestDispatcher rd = req.getRequestDispatcher("input.html");
	  rd.include(req, res); 
	}

	public static boolean isPrime(int n) {
		int c=0;
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) c++;
		}
		if(c==0) return true;
		else return false;
		
	}
}
