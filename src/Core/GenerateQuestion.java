/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Beans.Candidate;
import util2.TestQuestion;
import java.util.List;

/**
 *
 * @author zoran.milicevic
 */

//dusan
public class GenerateQuestion {
    
    private static List<TestQuestion> list;
    
    public static void getQuestions(int id_candidate, int number){

    }

    public static List<TestQuestion> getList() {
        return list;
    }

    public static void setList(List<TestQuestion> list) {
        GenerateQuestion.list = list;
    }
    
    
}
