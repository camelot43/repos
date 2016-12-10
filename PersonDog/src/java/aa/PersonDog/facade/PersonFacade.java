/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.PersonDog.facade;

import aa.PersonDog.dao.PersonDAO;
import aa.PersonDog.model.Person;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author aanciaes
 */
public class PersonFacade {

    static final Logger LOGGER = Logger.getLogger(PersonFacade.class);
    
    public PersonFacade() {
    }
    
    public List listAllPersons() {
        PersonDAO pDao = new PersonDAO();
        List l = null;
        l = pDao.findAll();

        if (l == null ) {
            LOGGER.info("Result list is null");
        } else if ( l.isEmpty()) {
            LOGGER.info("Result list is Empty");
        }else {
            Iterator iter = l.iterator();

            while (iter.hasNext()) {
                Person p = (Person) iter.next();
                LOGGER.info(p.toString());
            }
        }
        return l;
    }    

    
    public List queryPersonByExample(String name, int age) {
        PersonDAO pDao = new PersonDAO();
        Person p = new Person();

        p.setName(name);
        p.setAge(age);

        List l = null;
        l = pDao.queryByExample(p);

        if (l == null ) {
            LOGGER.info("Result list is null");
        } else if (l.isEmpty()) {
            LOGGER.info("Result list is Empty");
        } else {            
        
            Iterator iter = l.iterator();

            while (iter.hasNext()) {
                Person pp = (Person) iter.next();
                LOGGER.info(pp.toString());
            }
        }
        return l;
    }
    
}
