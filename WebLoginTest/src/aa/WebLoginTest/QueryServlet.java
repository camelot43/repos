package aa.WebLoginTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import javax.naming.*;

import java.sql.*;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DataSource pool; // Database connection pool

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Init");
		try {
			// Create a JNDI Initial context to be able to lookup the DataSource
			InitialContext ctx = new InitialContext();
			// Lookup the DataSource, which will be backed by a pool
			// that the application server provides.
			pool = (DataSource) ctx.lookup("java:comp/env/jdbc/ebookshop");
			if (pool == null)
				throw new ServletException("Unknown DataSource 'jdbc/ebookshop'");
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Set the MIME type for the response message
		response.setContentType("text/html");
		// Get a output writer to write the response message into the network
		// socket
		PrintWriter out = response.getWriter();

		String[] authors = request.getParameterValues("author"); // Returns an
																	// array
		if (authors == null) {
			out.println("<h2>Please go back and select an author</h2>");
			return; // Exit doGet()
		}

		Connection conn = null;
		Statement stmt = null;
		try {
	         // Get a connection from the pool
	         conn = pool.getConnection();
			

			// Step 2: Create a "Statement" object inside the "Connection"
			stmt = conn.createStatement();

			// Step 3: Execute a SQL SELECT query
			// String sqlStr = "SELECT * FROM books WHERE author = " + "'" +
			// request.getParameter("author") + "'"
			// + " AND qty > 0 ORDER BY author ASC, title ASC";

			// Step 3: Execute a SQL SELECT query

			String sqlStr = "SELECT * FROM books WHERE author IN (";
			sqlStr += "'" + authors[0] + "'"; // First author
			for (int i = 1; i < authors.length; ++i) {
				sqlStr += ", '" + authors[i] + "'"; // Subsequent authors need a
													// leading commas
			}
			sqlStr += ") AND price < " + request.getParameter("price") + " AND qty > 0 ORDER BY author ASC, title ASC";

			// Print an HTML page as output of query
			out.println("<html><head><title>Query Results</title></head><body>");
			out.println("<h2>Thank you for your query.</h2>");
			out.println("<p>You query is: " + sqlStr + "</p>"); // Echo for
																// debugging
			ResultSet rset = stmt.executeQuery(sqlStr); // Send the query to the
														// server

			// Step 4: Process the query result
			int count = 0;
			while (rset.next()) {
				// Print a paragraph <p>...</p> for each row
				out.println("<p>" + rset.getString("author") + ", " + rset.getString("title") + ", $"
						+ rset.getDouble("price") + "</p>");
				++count;
			}
			out.println("<p>==== " + count + " records found ====</p>");
			out.println("</body></html>");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			out.close();
			try {
				// Step 5: Close the Statement and Connection
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
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
