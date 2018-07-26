/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Beans.Result;
import DAO.CandidateDAO;
import Beans.Candidate;
import util2.CandidateAnswers;
import util2.ResultUtil;
import util2.TestQuestion;
import java.util.List;

/**
 *
 * @author zoran.milicevic
 */


public class App {
    //uzelac
    public static boolean login(int id_candidate, int time, int number) throws Exception{
        Candidate candidate = CandidateDAO.get(id_candidate);
        if(candidate != null){
            GenerateQuestion.getQuestions(id_candidate, number);
        } else {
            return false;
        }    
        return true;
    }
    
    public static TestQuestion loadQuestion(int i){
        return GenerateQuestion.getList().get(i);
    }
    
    public static void answerQuestion(CandidateAnswers ca){
        //put the answer in CandidateAnswers.list
        //but you must check if it already is in the list if it does remove
	//added implementation
        List<CandidateAnswers> list= CandidateAnswers.getList();
        
        for(CandidateAnswers c: list){
            if(c.getQuestion().getId() == ca.getQuestion().getId()){
                list.remove(c); 
            }
        }
        list.add(ca);
        
    }
    
    public static List<ResultUtil> finishTest(){
        List<ResultUtil> list= Autocorrect.autocorrect(CandidateAnswers.getList());
        return list;
    }
    
}
