package aa.WebLoginTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// import org.apache.tomcat.util.buf.Base64; org.apache.tomcat.util.codec.binary.BaseNCodec
// import org.apache.tomcat.util.codec.binary.*;

import org.apache.tomcat.util.buf.*;

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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
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
		

		out.println("<br/><hr/>");
		out.println("<a href=\"querybook.html\">Click here to Query</a>");
		out.println("<br/><hr/>");
		out.println("<a href=\"logout.jsp\">Click here to log out</a>");
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

}
