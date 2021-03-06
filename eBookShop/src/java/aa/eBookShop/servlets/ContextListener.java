/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


http://www.codejava.net/coding/how-to-initialize-log4j-for-java-web-application

http://blog.idleworx.com/2010/01/setting-up-log4j-for-simple-java-web.html


 */
package aa.eBookShop.servlets;

import java.io.File;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
 
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author aanciaes
 */

@WebListener("application context listener")
public class ContextListener implements ServletContextListener {
 
    /**
     * Initialize log4j when the application is being started
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("aa.eBookShop.servlets.contextInitialized");
                // initialize log4j here
        ServletContext context = event.getServletContext();
        String log4jConfigFile = context.getInitParameter("log4j-config-location");
        String fullPath = context.getRealPath("") + File.separator + log4jConfigFile;
         
        PropertyConfigurator.configure(fullPath);
         
         
    }
     
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("aa.eBookShop.servlets.contextDestroyed");
    }  
}
