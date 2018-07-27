/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Beans.CandidateTechnology;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author zoran.milicevic
 */
public class CandidateTechnologyDAO {
     public static boolean insert(CandidateTechnology ct){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(ct);
        s.getTransaction().commit();
        s.close();
        return true;
    }
    
    public static CandidateTechnology get(int id){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        CandidateTechnology ct = (CandidateTechnology) s.get(CandidateTechnology.class, id);
        s.getTransaction().commit();
        s.close();
        return ct;
    }
    
    public static List<CandidateTechnology> get(){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q= s.createQuery("from CandidateTechnology");
        List<CandidateTechnology> list=q.list();
        s.getTransaction().commit();
        s.close();
        return list;
    }
    
    public static boolean update(CandidateTechnology ct){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(ct);
        s.getTransaction().commit();
        s.close();
        return true;
    }
    
    public static boolean delete(CandidateTechnology ct){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(ct);
        s.getTransaction().commit();
        s.close();
        return true;
    } 
    
    private static List<CandidateTechnology> getByCandidateId(int candidateId){
        Session s= Hibernate.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("from CandidateTechnology WHERE idCandidate = :candidateIdParam");
        q.setInteger("candidateIdParam", candidateId);
        List<CandidateTechnology> list = q.list();
        s.getTransaction().commit();
        s.close();
        return list;
    }
    
    public static boolean deleteByCandidateId(Integer candidateId) {
        List<CandidateTechnology> list = getByCandidateId(candidateId);
        boolean success = true;
        for(CandidateTechnology ct : list){
            if(!delete(ct)){
                success = false;
            };
        }
        return success;
    }
    
}
