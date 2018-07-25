/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Question;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author zoran.milicevic
 */
public class QuestionDAO {
     public static boolean insert(Question q){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(q);
        s.getTransaction().commit();
        s.close();
        return true;
    }
    
    public static Question get(int id){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Question ct = (Question) s.get(Question.class, id);
        s.getTransaction().commit();
        s.close();
        return ct;
    }
    
    public static List<Question> get(){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q= s.createQuery("from Question");
        List<Question> list=q.list();
        s.getTransaction().commit();
        s.close();
        return list;
    }
    
    public static boolean update(Question q){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(q);
        s.getTransaction().commit();
        s.close();
        return true;
    }
    
    public static boolean delete(Question q){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(q);
        s.getTransaction().commit();
        s.close();
        return true;
    } 
}
