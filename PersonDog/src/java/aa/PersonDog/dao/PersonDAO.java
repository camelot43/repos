/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.PersonDog.dao;

import aa.PersonDog.model.Person;
import java.util.List;

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


}
