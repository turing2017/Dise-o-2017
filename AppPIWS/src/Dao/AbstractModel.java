/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.HibernateUtil;
import java.io.*;
import org.hibernate.*;
import java.util.*;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author mviss
 */
public abstract class AbstractModel<T> {
    
    private Class<T> entity;
    private SessionFactory sessionFactory = HibernateUtil.getSession().getSessionFactory();
    
    public AbstractModel(Class<T> t){
        this.entity = t;
    }
    
    @SuppressWarnings("unchecked") 
    public List<T> findAll(){
        List<T> result = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            result = session.createQuery("from "+entity.getName())
                    .list();
            transaction.commit();
        }catch(Exception e){
            result = null;
            if(transaction!=null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public T find(Object id){
        T result = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            result =(T) session.get(entity, (Serializable) id);
            transaction.commit();
        }catch(Exception e){
            result = null;
            if(transaction!=null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    }
    
    public void create(T entity){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }catch(Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
    }
    
    public void update(T entity){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }catch(Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
    }
    
    public void delete(T entity){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        }catch(Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
    }
}
