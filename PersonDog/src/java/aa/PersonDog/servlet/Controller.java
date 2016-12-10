/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.PersonDog.servlet;

import aa.PersonDog.dao.DogDAO;
import aa.PersonDog.dao.UUserDAO;
import aa.PersonDog.facade.DogFacade;
import aa.PersonDog.facade.PersonFacade;
import aa.PersonDog.model.Dog;
import aa.PersonDog.model.Role;
import aa.PersonDog.model.UUser;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import aa.PersonDog.services.DefaultData;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author aanciaes
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    static final Logger LOGGER = Logger.getLogger(Controller.class);

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

        // Retrieve the current session, or create a new session if no session exists.
        HttpSession session = request.getSession(true);

        // For dispatching the next Page
        String nextPage = "";
        String todo = request.getParameter("todo");

        if (null == todo) {
            // First access - redirect to order.jsp
            nextPage = "/index.jsp";
        } else {
            switch (todo) {
                case "insertDefaultData": {
                    DefaultData df = new DefaultData();
                    df.InsertDefaultUsers(3);
                    df.InsertDefaultPersons(6);
                    df.InsertDefaultDogs(7);
                    df.InsertDefaultPersonsWithDogs(5);

                    nextPage = "/ActionComplete.jsp";
                    break;
                }
                case "insertUser": {
                    UUserDAO uDAO = new UUserDAO();
                    UUser usr = new UUser();
                    usr.setId(1000);
                    usr.setName("Antonio");
                    usr.setPassword("antonio pwd");
                    usr.setEmail("antonio@antonio.com");
                    usr.setRole(Role.ADMIN);
                    uDAO.add(usr);
                    nextPage = "/error.jsp";
                    break;

                }
                case "listAllPersons": {
                    PersonFacade personFacade = new PersonFacade();

                    List l = personFacade.listAllPersons();

                    if (l == null) {
                        nextPage = "/error.jsp";
                    } else {
                        request.setAttribute("queryResults", l);
                        nextPage = "/ListPersons.jsp";
                    }
                    break;
                }
                case "queryPersonByExample": {
                    String n = request.getParameter("person_name");
                    String a = request.getParameter("person_age");

                    int ag = 0;
                    if (a != null && !a.isEmpty()) {
                        ag = Integer.parseInt(a);
                    }

                    PersonFacade personFacade = new PersonFacade();

                    List l = personFacade.queryPersonByExample(n, ag);

                    if (l == null) {
                        nextPage = "/error.jsp";
                    } else {
                        request.setAttribute("queryResults", l);
                        nextPage = "/ListPersons.jsp";
                    }
                    break;
                }

                case "listAllDogs": {
                    DogFacade dogFacade = new DogFacade();

                    List l = dogFacade.listAllDogs();

                    if (l == null) {
                        nextPage = "/error.jsp";
                    } else {
                        request.setAttribute("queryResults", l);
                        nextPage = "/ListDogs.jsp";
                    }
                    break;
                }                
                case "queryDogsByExample": {
                    String n = request.getParameter("dog_name");
                    String a = request.getParameter("dog_age");

                    int ag = 0;
                    if (a != null && !a.isEmpty()) {
                        ag = Integer.parseInt(a);
                    }

                    DogFacade dogFacade = new DogFacade();

                    List l = dogFacade.queryDogsByExample(n, ag);

                    if (l == null) {
                        nextPage = "/error.jsp";
                    } else {
                        request.setAttribute("queryResults", l);
                        nextPage = "/ListDogs.jsp";
                    }
                    break;
                }
                        
                default:
                    break;
            }
        }

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(nextPage);
        requestDispatcher.forward(request, response);

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
