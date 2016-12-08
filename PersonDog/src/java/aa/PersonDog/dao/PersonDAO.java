/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.PersonDog.dao;

import aa.PersonDog.model.Person;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author aanciaes
 */
public class PersonDAO extends AbstractDao {


    public PersonDAO() {
        super();
    }
    
    public void add(Person p) throws DataAccessLayerException {
        super.save(p);
    }

    public void delete(int personid) throws DataAccessLayerException { 
        Person p = new Person();
        p.setId(personid);
        
        super.delete(p);
    }

    public void update(Person p) throws DataAccessLayerException {
        super.saveOrUpdate(p);
    }

    public List findAll() throws DataAccessLayerException{
        return super.findAll(Person.class);
    }

    public List queryByExample(Person p) throws DataAccessLayerException{
        return super.queryByExample(p);
    }
    
    public Person find(Long id) throws DataAccessLayerException {
        return (Person) super.find(Person.class, id);
    }

    public Person findPersonWithAllDogs(int personId) {

        Session session = HibernateFactory.openSession();

        Person p = (Person) session.createCriteria(Person.class).add(Restrictions.idEq(personId)).uniqueResult();
        // this will force SQL to execute the query that will join with the user's profile and populate  
        //  the appropriate information into the user object.  
        Hibernate.initialize(p.getDogs());  
  
        return p;
    }
    
    public Person loadAllDogs(Person p) {

        Session session = HibernateFactory.openSession();
        //Transaction tx = session.beginTransaction();

        // this will force SQL to execute the query that will join with the user's profile and populate  
        //  the appropriate information into the user object.  
        Hibernate.initialize(p.getDogs());  
  
        //tx.commit();
        return p;
    }


}
