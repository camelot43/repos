/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.eBookShop.servlets;

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
 *
 * @author aanciaes
 */
@WebServlet(name = "queryBooks", urlPatterns = {"/queryBooks"})
public class queryBooks extends HttpServlet {

    DataSource pool; // Database connection pool

    @Override
    public void init() throws ServletException {
        System.out.println("Init");
        try {
            // Create a JNDI Initial context to be able to lookup the DataSource
            InitialContext ctx = new InitialContext();
            // Lookup the DataSource, which will be backed by a pool
            // that the application server provides.
            pool = (DataSource) ctx.lookup("java:comp/env/jdbc/ebookshop");
            if (pool == null) {
                throw new ServletException("Unknown DataSource 'jdbc/ebookshop'");
            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet queryBooks</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet queryBooks at " + request.getContextPath() + "</h1>");

            String author = request.getParameter("author");
            String book = request.getParameter("book");
            
            if ( author.isEmpty() && book.isEmpty() ){
                out.println("<h2>Please go back and select a book and or an author</h2>");
                return;
            }
            
            Connection conn = null;
            Statement stmt = null;
            try {
                // Get a connection from the pool
                conn = pool.getConnection();

                // Step 2: Create a "Statement" object inside the "Connection"
                stmt = conn.createStatement();


                String sqlStr = "SELECT * FROM books WHERE ";
                
                if ( !book.isEmpty() ) {
                    sqlStr += "title like '%" + book + "%'";
                    if (!author.isEmpty())
                        sqlStr += " AND ";
                }
                
                if ( !author.isEmpty() ) {
                    sqlStr += "author like '%" + author + "%'";
                }
                
                sqlStr += " ORDER BY author ASC, title ASC";

                System.out.println(sqlStr);
                
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
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
