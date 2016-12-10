/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.PersonDog.facade;

import aa.PersonDog.dao.DogDAO;
import aa.PersonDog.model.Dog;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author aanciaes
 */
public class DogFacade {

    private static final Logger LOG = Logger.getLogger(DogFacade.class.getName());

    
    public DogFacade() {
    }

    public List listAllDogs() {
        DogDAO pDao = new DogDAO();
        List l = null;
        l = pDao.findAll();

        if (l == null ) {
            LOG.info("Result list is null");
        } else if ( l.isEmpty()) {
            LOG.info("Result list is Empty");
        }else {
            Iterator iter = l.iterator();

            while (iter.hasNext()) {
                Dog p = (Dog) iter.next();
                LOG.info(p.toString());
            }
        }
        return l;
    }    

    
    public List queryDogsByExample(String name, int age) {
        DogDAO dDao = new DogDAO();
        Dog d = new Dog();

        d.setName(name);
        d.setAge(age);

        List l = null;
        l = dDao.queryByExample(d);

        if (l == null ) {
            LOG.info("Result list is null");
        } else if (l.isEmpty()) {
            LOG.info("Result list is Empty");
        } else {            
        
            Iterator iter = l.iterator();

            while (iter.hasNext()) {
                Dog dd = (Dog) iter.next();
                LOG.info(dd.toString());
            }
        }
        return l;
    }

    
}
