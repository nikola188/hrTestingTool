/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Technology;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author zoran.milicevic
 */
public class TechnologyDAO {
    public static boolean insert(Technology t){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(t);
        s.getTransaction().commit();
        s.close();
        return true;
    }
    
    public static Technology get(int id){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Technology t = (Technology) s.get(Technology.class, id);
        s.getTransaction().commit();
        s.close();
        return t;
    }
    
    public static List<Technology> get(){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q= s.createQuery("from Technology");
        List<Technology> list=q.list();
        s.getTransaction().commit();
        s.close();
        return list;
    }
    
    public static boolean update(Technology t){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(t);
        s.getTransaction().commit();
        s.close();
        return true;
    }
    
    public static boolean delete(Technology t){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(t);
        s.getTransaction().commit();
        s.close();
        return true;
    } 
    
    public static Technology getId(String technology){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q= s.createQuery("from Technology where text='" + technology + "'");
        List<Technology> list= q.list();
        s.getTransaction().commit();
        s.close();
        return list.get(0);
    }
}
