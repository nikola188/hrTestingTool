/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Result;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author zoran.milicevic
 */
public class ResultDAO {
    public static boolean insert(Result r){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(r);
        s.getTransaction().commit();
        s.close();
        return true;
    }
    
    public static Result get(int id){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Result r = (Result) s.get(Result.class, id);
        s.getTransaction().commit();
        s.close();
        return r;
    }
    
    public static List<Result> get(){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q= s.createQuery("from Result");
        List<Result> list=q.list();
        s.getTransaction().commit();
        s.close();
        return list;
    }
    
    public static boolean update(Result r){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(r);
        s.getTransaction().commit();
        s.close();
        return true;
    }
    
    public static boolean delete(Result r){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(r);
        s.getTransaction().commit();
        s.close();
        return true;
    } 

    public static List<Result> getByCandidateId(int candidateId){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("from Result WHERE idCandidate = :candidateIdParam");
        q.setInteger("candidateIdParam", candidateId);
        List<Result> list=q.list();
        s.getTransaction().commit();
        s.close();
        return list;
    }
    
    public static boolean deleteByCandidateId(int candidateId){
        
        List<Result> list = getByCandidateId(candidateId);
        boolean success = true;
        for(Result result : list){
            if(!delete(result)){
                success = false;
            };
        }
        return success;
    }
}
