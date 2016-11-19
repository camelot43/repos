/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.PersonDog.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        logger.info("PersonDog Hibernate Configuration created successfully");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        logger.info("PersonDog ServiceRegistry created successfully");
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(serviceRegistry);
        logger.info("PersonDog SessionFactory created successfully");

        sce.getServletContext().setAttribute("SessionFactory", sessionFactory);
        logger.info("PersonDog Hibernate SessionFactory Configured successfully");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        SessionFactory sessionFactory = (SessionFactory) sce.getServletContext().getAttribute("SessionFactory");
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            logger.info("PersonDog Closing sessionFactory");
            sessionFactory.close();
        }
        logger.info("PersonDog Released Hibernate sessionFactory resource");
    }
}
