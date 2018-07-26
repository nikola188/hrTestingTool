/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import util2.CandidateAnswers;
import java.util.List;
import util2.ResultUtil;

/**
 *
 * @author sasa.milenkovic
 */
import Beans.*;
import Commons.*;
import DAO.CandidateDAO;
import DAO.TechnologyDAO;
import java.util.*;


public class Autocorrect {
    
    private static List<ResultUtil> resultUtils;
    private static List<Technology> techList;
    private static Collection<CandidateTechnology> ctList;
    
    static{
        
        resultUtils = new ArrayList<ResultUtil>();
        techList = new ArrayList<Technology>();
        ctList = new ArrayList<CandidateTechnology>();
    }
    
    public static List<ResultUtil> autocorrect(List<CandidateAnswers> caList){
        
        Candidate c = CandidateDAO.get(Common.id_user);
        
        if(c!=null){
        
              ctList = c.getCandidateTechnologyCollection();
              
              if(ctList!=null){
                  
//                  Query tQuery = null;
              
                 for(CandidateTechnology ct : ctList){
                   
                      Technology tech = TechnologyDAO.get(ct.getIdTechnology().getId());
                      techList.add(tech);
                 }

              
        }
          
        //Get all answers for each question in candidate answers list
        
        
        if(caList!= null){
            
            List<Answers> answers;
              
            for(CandidateAnswers ca : caList){
              
              Question q = ca.getQuestion();
              answers = new ArrayList<>(ca.getAnswers());
              
              if(q!=null && !answers.isEmpty()){
                  
                 for(Answers a : answers){
              
                   if(a.getIsCorrect()== true){
                     
                     for(Technology tech : techList){
             
                       setResultUtils(tech);
             
                     }
                     
                     
                     for (ResultUtil resultUtil : resultUtils){
             
                         setResults(resultUtil, q);
                         
                     }
            
                   }
                     
                   
                   }
              
                }
                 
              }
            
            }
        }
        
     CandidateAnswers.setList(null);
     return resultUtils;
        
    }
    
      private static void setResultUtils(Technology tech){
    
       ResultUtil resultUtil = new ResultUtil(tech.getText());
       resultUtil.setResultsMap(tech.getText(), 0);
       resultUtils.add(resultUtil);
  
      }
    
     private static void setResults(ResultUtil resultUtil, Question q){
             
              Technology tech = q.getIdTechnology();
              String index = tech.getText();
         
             if(resultUtil.existResult(index)){
              
               resultUtil.setResult(q.getPoints());
               
             }
            
     }
             
}