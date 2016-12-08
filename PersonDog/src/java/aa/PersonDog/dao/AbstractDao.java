/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

http://www.java2s.com/Code/Java/Hibernate/GenericDaoCreate.htm

 */
package aa.PersonDog.dao;


import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

public abstract class AbstractDao implements Serializable {

    private Session session;
    private Transaction tx = null;

    
    public AbstractDao() {
        HibernateFactory.buildIfNeeded();
    }

    protected void save(Object obj) {
        try {
            startOperation();
            session.save(obj);
            commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
    }

    protected void update(Object obj) {
        try {
            startOperation();
            session.update(obj);
            commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
    }

    protected void saveOrUpdate(Object obj) {
        try {
            startOperation();
            session.saveOrUpdate(obj);
            commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
    }

    protected void delete(Object obj) {
        try {
            startOperation();
            session.delete(obj);
            commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
    }

    protected Object find(Class clazz, Long id) {
        Object obj = null;
        try {
            startOperation();
            obj = session.load(clazz, id);
            commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return obj;
    }

    protected List queryByExample(Object obj) {
        
        List objects = null;
 
        try {
            startOperation();

       // https://docs.jboss.org/hibernate/orm/3.3/reference/en/html/querycriteria.html  
       // http://blog.caelum.com.br/simplifique-suas-consultas-com-o-query-by-example-do-hibernate/
            
            Example ex = Example.create(obj)
                                .excludeZeroes()           //exclude zero valued properties
                                .ignoreCase()              //perform case insensitive string comparisons
                                .enableLike(MatchMode.ANYWHERE);              //use like for string comparisons
            Criteria criteria = session.createCriteria(obj.getClass()).add(ex);
            objects = criteria.list();
            
            commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return objects;
    }    
    
    
    protected List findAll(Class clazz) {
        List objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
            commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return objects;
    }

    protected Class findOneResult(String namedQuery, Map<String, Object> parameters) {
        
        return null;
        
    }
    
    protected void handleException(HibernateException e) throws DataAccessLayerException {
        HibernateFactory.rollback(tx);
        throw new DataAccessLayerException(e);
    }

    protected void startOperation() throws HibernateException {
        session = HibernateFactory.openSession();
        tx = session.beginTransaction();
    }
    
    protected void commit() throws HibernateException {
        if ( tx != null) {
            tx.commit();
            tx = null;
        }
    }
    
    protected void endOperation() throws HibernateException {
        HibernateFactory.close(session);
    }    
}
