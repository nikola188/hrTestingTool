/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util2;

import Beans.Answers;
import Beans.Question;
import java.util.List;

/**
 *
 * @author zoran.milicevic
 */
public class TestQuestion {
    private Question question;
    private List<Answers> list;

    public TestQuestion(Question question, List<Answers> list) {
        this.question = question;
        this.list = list;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answers> getList() {
        return list;
    }

    public void setList(List<Answers> list) {
        this.list = list;
    }
    
    
    
}
