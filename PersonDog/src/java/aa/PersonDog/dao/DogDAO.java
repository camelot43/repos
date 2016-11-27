/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.PersonDog.dao;

import aa.PersonDog.model.Dog;
import java.util.List;

/**
 *
 * @author aanciaes
 */
public class DogDAO extends AbstractDao {


    public DogDAO() {
        super();
    }
    
    public void add(Dog d) throws DataAccessLayerException {
        super.save(d);
    }

    public void delete(int dogid) throws DataAccessLayerException { 
        Dog d = new Dog();
        d.setId(dogid);
        
        super.delete(d);
    }

    public void update(Dog d) throws DataAccessLayerException {
        super.saveOrUpdate(d);
    }

    public List findAll() throws DataAccessLayerException{
        return super.findAll(Dog.class);
    }

    public Dog find(Long id) throws DataAccessLayerException {
        return (Dog) super.find(Dog.class, id);
    }


    
}
