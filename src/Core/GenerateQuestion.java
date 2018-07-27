package Core;

import Beans.Answers;
import Beans.Question;
import DAO.AnswersDAO;
import DAO.QuestionDAO;
import java.util.ArrayList;
import java.util.HashMap;
import util2.TestQuestion;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author dusan.cvijic
 */

//dusan
public class GenerateQuestion {
    
    private static List<TestQuestion> list;
    
    public static List<TestQuestion> getList() {
        return list;
    }
    
    public static void setList(List<TestQuestion> list) {
        GenerateQuestion.list = list;
    }
    
    
//    This method splits an array of questions into a map, where the key is the id of the category of the question
    private static Map<Integer, ArrayList<Question>> splitCategories(List<Question> questions){
        HashMap<Integer, ArrayList<Question>> listsByCategories = new HashMap<>();
        for(int i = 0; i < questions.size(); i++){
            Question q = questions.get(i);
            int technologyId = q.getIdTechnology().getId();
            if(!listsByCategories.containsKey(technologyId)){
                ArrayList<Question> list = new ArrayList<>();
                listsByCategories.put(technologyId, list);
            }
            listsByCategories.get(technologyId).add(q);
        }
        return listsByCategories;
    }
    
//    This method returns a list of random questions according to the technologies the candidate knows and the number of questions from the argument
    public static void getQuestions(int candidateId, int numberOfQuestions) throws Exception{
        if(list == null){
            list = new ArrayList<>();
        } else {
            list.clear();
        }
        Random rand = new Random();
     
        List<Question> questionList = QuestionDAO.getQuestionsByCandidateId(candidateId);
        
        if(questionList == null){
            throw new Exception("EXCEPTION: List of questions from database is null. Try making sure the candidateId is good and that you have stuff in your base");
        }
        HashMap<Integer, ArrayList<Question>> categories = (HashMap<Integer, ArrayList<Question>>) splitCategories(questionList);
        
        questionList.clear();
        
        for(Map.Entry<Integer, ArrayList<Question>> entry : categories.entrySet()) {
            System.out.println(entry.getKey());
            
            int techIdKey = entry.getKey();
            ArrayList tempList = entry.getValue();
            
            if(numberOfQuestions > tempList.size()){
                throw new Exception("EXCEPTION: Not enough questions");
            } else {
                for(int i = 0; i < numberOfQuestions; i++){
                    int randomInt;
                    Question randomQuestion;
                    do{
                        randomInt = rand.nextInt(categories.get(techIdKey).size());
                        randomQuestion = (Question) tempList.get(randomInt);
                    }while(questionList.contains(randomQuestion));
                    ArrayList<Answers> answers = (ArrayList<Answers>) AnswersDAO.getByQuestionId(randomQuestion.getId());
                    list.add(new TestQuestion(randomQuestion, answers));
                }
            }
        }
    }    
}
