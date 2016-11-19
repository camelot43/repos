/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.PersonDog.servlet;

import aa.PersonDog.model.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

/**
 *
 * @author aanciaes
 */
@WebServlet(name = "GetPersonByID", urlPatterns = {"/GetPersonByID"})
public class GetPersonByID extends HttpServlet {

    public final Logger logger = Logger.getLogger(GetPersonByID.class);

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

        int empId = Integer.parseInt(request.getParameter("empId"));
        logger.info("Request Param empId=" + empId);

        SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Person emp = (Person) session.get(Person.class, empId);
        tx.commit();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        if (emp != null) {
            out.print("<html><body><h2>Employee Details</h2>");
            out.print("<table border=\"1\" cellspacing=10 cellpadding=5>");
            out.print("<th>ID</th>");
            out.print("<th>Name</th>");
            out.print("<th>Age</th>");

            out.print("<tr>");
            out.print("<td>" + empId + "</td>");
            out.print("<td>" + emp.getName() + "</td>");
            out.print("<td>" + emp.getAge()+ "</td>");
            out.print("</tr>");
            out.print("</table></body><br/>");

            out.print("</html>");
        } else {
            out.print("<html><body><h2>No Employee Found with ID=" + empId + "</h2></body></html>");
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
