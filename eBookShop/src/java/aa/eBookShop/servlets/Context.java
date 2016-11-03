/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.eBookShop.servlets;

import aa.eBokkShop.utils.HtmlFilter;
import java.util.Enumeration;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.util.Base64;

/**
 *
 * @author aanciaes
 */
public class Context extends HttpServlet {

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
        

		htmlPageStart(out);
		
		headersDump(out, request);
		
		infoDump(out, request);
		
		htmlPageEnd(out);
            
            
            
            
        }
    }

    private void headersDump(PrintWriter out, HttpServletRequest request) {

		out.println("This is the Context Servlet!");
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

	private void htmlPageStart(PrintWriter out) {
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
	
	private void infoDump(PrintWriter out, HttpServletRequest request) {
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
