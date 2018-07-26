/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Question;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    //  s.close();
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
    
    public static List<Question> getQuestionsByCandidateId(int candidateId){
    
        List<Question> questionList = null;
        Session s = Hibernate.HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = s.beginTransaction();

            String queryString = "Select q FROM Question as q JOIN q.idTechnology as t WHERE t.id IN (SELECT ct.idTechnology FROM CandidateTechnology ct WHERE ct.idCandidate = :idCandidateParam)";
            
            
            Query query = s.createQuery(queryString);
            query.setInteger("idCandidateParam", candidateId);
            questionList = query.list();

            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            s.close();
        }
        if(questionList == null || questionList.isEmpty()){
            return null;
        }

        return questionList;
        
    }
}
