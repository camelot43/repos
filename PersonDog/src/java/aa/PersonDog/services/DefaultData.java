/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.PersonDog.services;

import aa.PersonDog.dao.DogDAO;
import aa.PersonDog.dao.PersonDAO;
import aa.PersonDog.dao.UUserDAO;
import aa.PersonDog.model.Dog;
import aa.PersonDog.model.Person;
import aa.PersonDog.model.Role;
import aa.PersonDog.model.UUser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aanciaes
 */
public class DefaultData {
    
    
    public boolean InsertDefaultUsers( int tot ) {
        boolean retval = true;
        int i;
        
        UUserDAO uDAO = new UUserDAO();
        
        UUser usr = new UUser();
        
        for (i=0 ; i < tot ; i++) {
            usr.setId(1000+i);
            String name = "USR_aan_"+Integer.toString(i);
            usr.setName(name);
            String pwd = name+" PWD";
            usr.setPassword(pwd);
            String mail = name+"@aa.aa";
            usr.setEmail(mail);
            usr.setRole(Role.ADMIN);
            
            uDAO.add(usr); 
        }
        
        return retval;
    }
    
    public boolean InsertDefaultPersons( int tot ) {
        boolean retval = true;
        int i;
        
        PersonDAO pDAO = new PersonDAO();
        
        Person per = new Person();
        
        for (i=0 ; i < tot ; i++) {
            per.setId(2000+i);
            String name = "PERSON_Default_"+Integer.toString(i);
            per.setName(name);
            per.setAge(i);
           
            pDAO.add(per); 
        }
        
        return retval;      
    }
    
    
    public boolean InsertDefaultPersonsWithDogs( int tot ) {
        boolean retval = true;
        int i;
        
        PersonDAO pDAO = new PersonDAO();
        DogDAO dDAO = new DogDAO();
        
        Person per = new Person();
        
        for (i=0 ; i < tot ; i++) {
            per.setId(2000+i);
            String name = "PER_Antonio_"+Integer.toString(i);
            per.setName(name);
            per.setAge(i);
            
            Dog d = new Dog();
            d.setId(4000+i);
            String dogname = "Boby_of_"+name+Integer.toString(i);
            d.setName(dogname);
            dDAO.add(d); 
            
            List<Dog> dLst = new ArrayList<Dog>();            
            dLst.add(d);
            
            per.setDogs(dLst);
           
            pDAO.add(per); 
        }
        
        return retval;      
    }
    
    public boolean InsertDefaultDogs(int tot) {
        boolean retval = true;
        int i;
        
        DogDAO dDAO = new DogDAO();
        
        Dog d = new Dog();
        
        for (i=0 ; i < tot ; i++) {
            d.setId(3000+i);
            String name = "DOG_DEfault_"+Integer.toString(i);
            d.setName(name);

            dDAO.add(d); 
        }
        
        return retval;      
    }
                        

    
}
