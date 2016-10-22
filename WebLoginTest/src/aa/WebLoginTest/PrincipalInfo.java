package aa.WebLoginTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.apache.catalina.realm.GenericPrincipal;

/**
 * Servlet implementation class PrincipalInfo
 */
@WebServlet("/protected/PrincipalInfo")
public class PrincipalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrincipalInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		htmlPageStart(out, "Principal Info");

		out.println("<table>");
		out.println("<tr><td>" + "Principal" + "</td>");

		final Principal userPrincipal = request.getUserPrincipal();
		if (userPrincipal == null) {
			out.println("<td>No Principal, No user authenticated</td></tr>");
		} else {
			out.println("<td>" + userPrincipal.getName() + "</td></tr>");

			GenericPrincipal genericPrincipal = (GenericPrincipal) userPrincipal;
			final String[] roles = genericPrincipal.getRoles();
			if (roles != null) {
				for (int i = 0; i < roles.length; i++) {
					out.println("<tr><td>" + "Role" + "</td>");
					out.println("<td>" + roles[i] + "</td></tr>");
				}
			}
		}

		out.println("</table>");

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

	private void htmlPageStart(PrintWriter out, String title) {
		out.println("<!DOCTYPE html"); // HTML 5
		out.println("<html><head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		out.println("<head><title>" + title + "</title></head>");
		out.println("<body>");
	}

	private void htmlPageEnd(PrintWriter out) {
		out.println("</body></html>");
	}

}
