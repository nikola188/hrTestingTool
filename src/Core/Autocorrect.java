/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Beans.Result;
import util2.CandidateAnswers;
import java.util.List;
import util2.ResultUtil;

/**
 *
 * @author sasa.milenkovic
 */
import Beans.*;
import Hibernate.*;
import util2.*;
import Commons.*;
import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class Autocorrect {
    
    public static List<ResultUtil> autocorrect(List<CandidateAnswers> caList){
        
        //find the preferred technologies for the candidate
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
     
        Query query = session.getNamedQuery("Candidate.findById").setParameter("id", Common.id_user);
        Query tQuery = null;
        List<Technology> techList  = new ArrayList<Technology>();
        Candidate c = (Candidate) query.uniqueResult();
        Collection<CandidateTechnology> ctList = new ArrayList<CandidateTechnology>();
        
        if(c!=null){
        
              ctList = c.getCandidateTechnologyCollection();
              
              if(ctList!=null){
              
                 for(CandidateTechnology ct : ctList)
              
                    tQuery = session.getNamedQuery("Technology.findById").setParameter("id", ct.getIdTechnology());
                    techList.add((Technology) tQuery.uniqueResult());
              
                 }
              
        }
          
        //Get all answers for each question in candidate answers list
        Question q = null;
        List<Answers> answers = new ArrayList<Answers>();
        
        if(caList!= null){
              
            for(CandidateAnswers ca : caList){
              
              answers = ca.getAnswers();
              q = ca.getQuestion();
              
              
           
            }
            
            
        }
        

        CandidateAnswers.setList(null);
        return null;
    }
}
