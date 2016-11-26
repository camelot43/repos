/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.PersonDog.listener;

import aa.PersonDog.dao.HibernateFactory;
import java.io.File;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.PropertyConfigurator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.jboss.logging.Logger;


/**
 * Web application lifecycle listener.
 *
 * @author aanciaes
 */
public class AppContextFactoryListener implements ServletContextListener {

    public final Logger logger = Logger.getLogger(AppContextFactoryListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // Log4j initialization
        ServletContext context = sce.getServletContext();
        String log4jConfigFile = context.getInitParameter("log4j-config-location");
        String fullPath = context.getRealPath("") + File.separator + log4jConfigFile;
         
        PropertyConfigurator.configure(fullPath);
        
        // Hibernate initialization
        HibernateFactory hf = new HibernateFactory();
        SessionFactory sessionFactory = hf.buildIfNeeded();
        
        sce.getServletContext().setAttribute("HibernateFactory", hf);
        logger.info("PersonDog Hibernate SessionFactory Configured successfully");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
        HibernateFactory hf = (HibernateFactory) sce.getServletContext().getAttribute("HibernateFactory");
        
        if (hf != null ) {
            logger.info("PersonDog Closing Hibernate Factory");
            hf.closeFactory();
        }
        logger.info("Released Hibernate sessionFactory resource");
    }
}
