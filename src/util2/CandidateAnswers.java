/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util2;

import Beans.Answers;
import Beans.Question;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zoran.milicevic
 */
public class CandidateAnswers {
    private Question question;
    private List<Answers> answers;
    private static List<CandidateAnswers> list;
    
    static{
        list=new ArrayList<>();
    }

    public CandidateAnswers(Question question, List<Answers> answers) {
        this.question = question;
        this.answers = answers;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    public static List<CandidateAnswers> getList() {
        return list;
    }

    public static void setList(List<CandidateAnswers> list) {
        CandidateAnswers.list = list;
    }
    
    
  
    public void insert(CandidateAnswers ca){
        list.add(ca);
    }
    
    //not sure!!!
    public void remove(CandidateAnswers ca){
        list.remove(ca);
    }
    
   
}
