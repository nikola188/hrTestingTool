/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Answers;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author zoran.milicevic
 */
public class AnswersDAO {
        public static boolean insert(Answers a){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(a);
        s.getTransaction().commit();
        s.close();
        return true;
    }
    
    public static Answers get(int id){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Answers a = (Answers) s.get(Answers.class, id);
        s.getTransaction().commit();
        s.close();
        return a;
    }
    
    public static List<Answers> get(){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q= s.createQuery("from Answers");
        List<Answers> list=q.list();
        s.getTransaction().commit();
        s.close();
        return list;
    }
    
    public static boolean update(Answers a){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(a);
        s.getTransaction().commit();
        s.close();
        return true;
    }
    
    public static boolean delete(Answers a){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(a);
        s.getTransaction().commit();
        s.close();
        return true;
    } 
}
