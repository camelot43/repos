/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa.PersonDog.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import aa.PersonDog.model.UUser;
import org.hibernate.SessionFactory;



public class UUserDAO  extends AbstractDao {

    public UUserDAO() {
        super();
    }
    
    public void add(UUser user) throws DataAccessLayerException {
        super.save(user);
    }

    public void delete(int userid) throws DataAccessLayerException { 
        UUser u = new UUser();
        u.setId(userid);
        
        super.delete(u);
    }

    public void update(UUser user) throws DataAccessLayerException {
        super.saveOrUpdate(user);
    }

    public List findAll() throws DataAccessLayerException{
        return super.findAll(UUser.class);
    }

    public UUser find(Long id) throws DataAccessLayerException {
        return (UUser) super.find(UUser.class, id);
    }
}




/**
 *
 * @author aanciaes
 
public class UUserDAO {
    
    private SessionFactory sessionFactory;

    public UUserDAO ( SessionFactory factory ) {
          sessionFactory = factory;
    }
    
    public void addUser(UUser user) {
        Transaction trns = null;
        Session session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void deleteUser(int userid) {
        Transaction trns = null;
        Session session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            UUser user = (UUser) session.load(UUser.class, new Integer(userid));
            session.delete(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void updateUser(UUser user) {
        Transaction trns = null;
        Session session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public List<UUser> getAllUsers() {
        List<UUser> users = new ArrayList<UUser>();
        Transaction trns = null;
        Session session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from UUser").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }

    public UUser getUserById(int userid) {
        UUser user = null;
        Transaction trns = null;
        Session session = sessionFactory.openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from UUser where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", userid);
            user = (UUser) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return user;
    }
}
*/