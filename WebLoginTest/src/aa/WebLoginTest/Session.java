package aa.WebLoginTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session
 */
@WebServlet("/protected/Session")

public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set the response message's MIME type
		response.setContentType("text/html;charset=UTF-8");
		// Allocate a output writer to write the response message into the
		// network socket
		PrintWriter out = response.getWriter();

		// Write the response message, in an HTML page
		try {
			out.println("<!DOCTYPE html"); // HTML 5
			out.println("<html><head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			String title = "sessions.title";
			out.println("<head><title>" + title + "</title></head>");
			out.println("<body>");
			out.println("<h3>" + title + "</h3>");

			// Return the existing session if there is one. Otherwise, create a
			// new session
			HttpSession session = request.getSession();

			// Display session information
			out.println("sessions.id" + " " + session.getId() + "<br />");
			out.println("sessions.created" + " ");
			out.println(new Date(session.getCreationTime()) + "<br />");
			out.println("sessions.lastaccessed" + " ");
			out.println(new Date(session.getLastAccessedTime()) + "<br /><br />");

			// Set an attribute (name-value pair) if present in the request
			String attName = request.getParameter("attribute_name");
			if (attName != null)
				attName = attName.trim();
			String attValue = request.getParameter("attribute_value");
			if (attValue != null)
				attValue = attValue.trim();
			if (attName != null && !attName.equals("") && attValue != null && !attValue.equals("")) {
				// synchronized session object to prevent concurrent update
				synchronized (session) {
					session.setAttribute(attName, attValue);
				}
			}

			// Display the attributes (name-value pairs) stored in this session
			out.println("sessions.data" + "<br>");
			Enumeration names = session.getAttributeNames();
			while (names.hasMoreElements()) {
				String name = (String) names.nextElement();
				String value = session.getAttribute(name).toString();
				out.println(HtmlFilter.filter(name) + " = " + HtmlFilter.filter(value) + "<br>");
			}
			out.println("<br />");

			// Display a form to prompt user to create session attribute
			out.println("<form method='get'>");
			out.println("sessions.dataname");
			out.println("<input type='text' name='attribute_name'><br />");
			out.println("sessions.datavalue");
			out.println("<input type='text' name='attribute_value'><br />");
			out.println("<input type='submit' value='SEND'>");
			out.println("</form><br />");

			out.print("<a href='");
			// Encode URL by including the session ID (URL-rewriting)
			out.print(response.encodeURL(request.getRequestURI() + "?attribute_name=foo&attribute_value=bar"));
			out.println("'>Encode URL with session ID (URL re-writing)</a>");
			out.println("</body></html>");
		} finally {
			out.close(); // Always close the output writer
		}
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
