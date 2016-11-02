package aa.WebLoginTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieExample
 */
@WebServlet("/protected/CookieExample")
public class CookieExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // Set the response message's MIME type
	      response.setContentType("text/html;charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	 
	      // Write the response message, in an HTML page
	      try {
	         out.println("<!DOCTYPE html");  // HTML 5
	         out.println("<html><head>");
	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         String title = "Cookies Title";
	         out.println("<head><title>" + title + "</title></head>");
	         out.println("<body>");
	         out.println("<h3>" + title + "</h3>");
	 
	         // Display the cookies returned by the client
	         Cookie[] cookies = request.getCookies();
	         if ((cookies != null) && (cookies.length > 0)) {
	            out.println("Cookies" + "<br />");
	            for (Cookie cookie : cookies) {
	               out.println("Cookie Name: " + HtmlFilter.filter(cookie.getName()) + "<br />");
	               out.println("Cookie Value: " + HtmlFilter.filter(cookie.getValue()) + "<br />");
	            }
	         } else {
	            out.println("No cookies" + "<br />");
	         }
	         out.println("<br />");
	 
	         // Create a new cookie if cookiename and cookievalue present in the request
	         String cookieName = request.getParameter("cookiename");
	         if (cookieName != null) cookieName = cookieName.trim();
	         String cookieValue = request.getParameter("cookievalue");
	         if (cookieValue != null) cookieValue = cookieValue.trim();
	         if (cookieName != null && !cookieName.equals("")
	               && cookieValue != null && !cookieValue.equals("")) {
	            Cookie cookie = new Cookie(cookieName, cookieValue);
	            response.addCookie(cookie);
	            out.println("cookies set" + "<br />");
	            out.print("cookies name" + "  "
	                      + HtmlFilter.filter(cookieName) + "<br />");
	            out.print("cookies Value" + "  "
	                      + HtmlFilter.filter(cookieValue));
	         }
	         out.println("<br /><br />");
	 
	         // Display a form to prompt the user to create a new cookie
	         out.println("cookies.make-cookie" + "<br />");
	         out.print("<form method='get'>");
	         out.print("cookies.name");
	         out.println("<input type='text' name='cookiename'><br />");
	         out.print("cookies.value");
	         out.println("<input type='text' name='cookievalue'><br />");
	         out.println("<input type='submit' value='SEND'>");
	         out.println("</form></body></html>");
	      } finally {
	         out.close();  // Always close the output writer
	      }
	   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
