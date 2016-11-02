package aa.WebLoginTest;

// SSL configuration for tomcat https://www.mkyong.com/tomcat/how-to-configure-tomcat-to-support-ssl-or-https/

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.util.Base64;

/**
 * Servlet implementation class DumpHeadersServlet
 * 
 * http://www.avajava.com/tutorials/lessons/how-do-i-use-form-authentication-with-tomcat.html?page=2
 * 
 */
@WebServlet("/DumpHeadersServlet")
public class DumpHeadersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DumpHeadersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// Use ResourceBundle to keep localized string in
		// "LocalStrings_xx.properties"
		ResourceBundle rb = null;
		// ResourceBundle rb = ResourceBundle.getBundle("LocalStrings", request.getLocale());

		htmlPageStart(out, rb);
		
		headersDump(out, request);
		
		infoDump(out, request, rb);
		
		out.println("<br/><hr/>");
		out.println("<a href=\"querybook.html\">Click here to Query</a>");
		out.println("<br/><hr/>");
		out.println("<a href=\"logout.jsp\">Click here to log out</a>");
		
		htmlPageEnd(out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void headersDump(PrintWriter out, HttpServletRequest request) {

		out.println("This is the DumpHeadersServlet Servlet!");
		out.println("Welcome '" + request.getRemoteUser() + "'");
		out.println("<br/><hr/>");

		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			out.print("<br/>Header Name: <em>" + headerName);
			String headerValue = request.getHeader(headerName);
			out.print("</em>, Header Value: <em>" + headerValue);
			out.println("</em>");
		}

		out.println("<hr/>");
		String authHeader = request.getHeader("authorization");
		if ((authHeader != null)) {
			String encodedValue = authHeader.split(" ")[1];
			out.println("Base64-encoded Authorization Value: <em>" + encodedValue);
			String decodedValue = Base64.base64Decode(encodedValue);
			out.println("</em><br/>Base64-decoded Authorization Value: <em>" + decodedValue);
			out.println("</em>");
		}
	}

	private void htmlPageStart(PrintWriter out, ResourceBundle rb) {
		out.println("<!DOCTYPE html"); // HTML 5
		out.println("<html><head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
//		String title = rb.getString("requestinfo.title");
		String title = "Page Title";
		out.println("<head><title>" + title + "</title></head>");
		out.println("<body>");
	}
	
	
	private void htmlPageEnd(PrintWriter out) {
	     out.println("</body></html>");
	}
	
	private void infoDump(PrintWriter out, HttpServletRequest request, ResourceBundle rb) {
	    out.println("<table>");
	    // out.println("<tr><td>" + rb.getString("requestinfo.label.protocol") + "</td>");
	    out.println("<tr><td>" + "protocol" + "</td>");
	    out.println("<td>" + request.getProtocol() + "</td></tr>");
	    // out.println("<tr><td>" + rb.getString("requestinfo.label.method") + "</td>");
	    out.println("<tr><td>" + "method" + "</td>");
	    out.println("<td>" + request.getMethod() + "</td></tr>");
	    out.println("</td></tr><tr><td>");
	    // out.println("<tr><td>" + rb.getString("requestinfo.label.requesturi") + "</td>");
	    out.println("<tr><td>" + "requesturi" + "</td>");
	    out.println("<td>" + HtmlFilter.filter(request.getRequestURI()) + "</td></tr>");
	    // out.println("<tr><td>" + rb.getString("requestinfo.label.pathinfo") + "</td>");
	    out.println("<tr><td>" + "pathinfo" + "</td>");
	    out.println("<td>" + HtmlFilter.filter(request.getPathInfo()) + "</td></tr>");
	    out.println("<tr><td>Path Translated:</td>");
	    out.println("<td>" + request.getPathTranslated() + "</td></tr>");
	    // out.println("<tr><td>" + rb.getString("requestinfo.label.remoteaddr") + "</td>");
	    out.println("<tr><td>" + "remoteaddr" + "</td>");
	    out.println("<td>" + request.getRemoteAddr() + "</td></tr>");

	    // SSL (HTTPS) Cipher suites
	    String cipherSuite =  (String)request.getAttribute("javax.servlet.request.cipher_suite");
	    if (cipherSuite != null) {
	       out.println("<tr><td>SSLCipherSuite:</td>");
	       out.println("<td>" + cipherSuite + "</td></tr>");
	    }
	     out.println("</table>");
	}
	

}
