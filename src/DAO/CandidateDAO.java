/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.Session;
import Beans.Candidate;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author zoran.milicevic
 */
public class CandidateDAO {
    public static boolean insert(Candidate u){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(u);
        s.getTransaction().commit();
        s.close();
        return true;
    }
    
    public static Candidate get(int id){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Candidate u = (Candidate) s.get(Candidate.class, id);
        s.getTransaction().commit();
        s.close();
        return u;
    }
    
    public static List<Candidate> get(){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q= s.createQuery("from Candidate");
        List<Candidate> list=q.list();
        s.getTransaction().commit();
        s.close();
        return list;
    }
    
    public static boolean update(Candidate u){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(u);
        s.getTransaction().commit();
        s.close();
        return true;
    }
    
    public static boolean delete(Candidate u){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(u);
        s.getTransaction().commit();
        s.close();
        return true;
    } 
}
