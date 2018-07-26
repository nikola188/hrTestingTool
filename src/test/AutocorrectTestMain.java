/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Beans.Answers;
import Core.Autocorrect;
import DAO.AnswersDAO;
import DAO.QuestionDAO;
import java.util.ArrayList;
import java.util.List;
import util2.CandidateAnswers;
import util2.ResultUtil;

/**
 *
 * @author sasa.milenkovic
 */
public class AutocorrectTestMain {
    
    
    public static void main(String[] args){
    
        List<CandidateAnswers> caList = new ArrayList<CandidateAnswers>();
        List<Answers> answersList1 = new ArrayList<Answers>();
        answersList1.add(AnswersDAO.get(1));
        answersList1.add(AnswersDAO.get(2));
        List<Answers> answersList2 = new ArrayList<Answers>();
        answersList2.add(AnswersDAO.get(5));
        List<Answers> answersList3 = new ArrayList<Answers>();
        answersList3.add(AnswersDAO.get(15));
        answersList3.add(AnswersDAO.get(16));
        List<Answers> answersList4 = new ArrayList<Answers>();
        answersList4.add(AnswersDAO.get(19));
        answersList4.add(AnswersDAO.get(20));
        caList.add(new CandidateAnswers(QuestionDAO.get(1), answersList1));
        caList.add(new CandidateAnswers(QuestionDAO.get(2), answersList2));
        caList.add(new CandidateAnswers(QuestionDAO.get(6), answersList3));
        caList.add(new CandidateAnswers(QuestionDAO.get(7), answersList4));
        
        List<ResultUtil> expResult = new ArrayList<ResultUtil>();
        ResultUtil resultUtil1 = new ResultUtil("Java", 4);
        ResultUtil resultUtil2 = new ResultUtil("Angular", 8);
        expResult.add(resultUtil1);
        expResult.add(resultUtil2);
        List<ResultUtil> result = Autocorrect.autocorrect(caList);
       // TestCase.assertEquals(result,expResult);
       for (CandidateAnswers answers: caList) {
            
            System.out.println(answers.getQuestion());
            
        }
        for (ResultUtil resultUtil : result) {
            
            System.out.println(resultUtil.getTechnology() + ": " + resultUtil.getResult());
            
        }
    
    }
    
}
