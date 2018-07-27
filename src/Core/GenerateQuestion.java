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
import java.util.Set;

/**
 *
 * @author zoran.milicevic
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
    
    private static Random rand = new Random();
    
    
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
    private static void setupList(int candidateId, int questionsPerCategory, int numberOfQuestions, HashMap<Integer, ArrayList<Question>> categories) throws Exception{
        
        if(list == null){
            list = new ArrayList<>();
        } else {
            list.clear();
        }
        
        List<Question> questionList = new ArrayList<>();
        ArrayList tempQuestionList = null;
        for(Map.Entry<Integer, ArrayList<Question>> entry : categories.entrySet()) {
            System.out.println(entry.getKey());
            
            int techIdKey = entry.getKey();
            tempQuestionList = entry.getValue();
            
            if(questionsPerCategory  > tempQuestionList.size()){
                throw new Exception("EXCEPTION: Not enough questions");
            } else {
                for(int i = 0; i < questionsPerCategory; i++){
//                    saddfsdf
                    tempQuestionList = categories.get(techIdKey);
                    questionList = insertQuestionIntoList(categories, tempQuestionList, questionList);
                }
            }
        }
        Integer i = 0;
        while(list.size() < numberOfQuestions){
            Set<Integer> keys = categories.keySet();
            tempQuestionList = categories.get(keys.toArray()[i]);
            questionList = insertQuestionIntoList(categories, tempQuestionList, questionList);
            i++;
        }
    }    
    
    public static void getQuestions(int candidateId, int numberOfQuestions) throws Exception{
        List<Question> questionList = QuestionDAO.getQuestionsByCandidateId(candidateId);
        if(questionList == null){
            throw new Exception("EXCEPTION: List of questions from database is null. Try making sure the candidateId is good and that you have stuff in your base");
        }
        
        HashMap<Integer, ArrayList<Question>> categories = (HashMap<Integer, ArrayList<Question>>) splitCategories(questionList);
        System.out.println("category count" + categories.size());
        int questionsPerCategory = numberOfQuestions/categories.size();
        System.out.println("questionspercategory" + questionsPerCategory);
        setupList(candidateId, questionsPerCategory, numberOfQuestions, categories);
    }
    
    private static ArrayList<Question> insertQuestionIntoList(HashMap<Integer, ArrayList<Question>> categories, ArrayList tempQuestionList, List<Question> questionList){
        int randomInt;
        Question randomQuestion;
        do{
            randomInt = rand.nextInt(tempQuestionList.size());
            randomQuestion = (Question) tempQuestionList.get(randomInt);
        }while(questionList.contains(randomQuestion));

        questionList.add(randomQuestion);

        ArrayList<Answers> answers = (ArrayList<Answers>) AnswersDAO.getByQuestionId(randomQuestion.getId());
        list.add(new TestQuestion(randomQuestion, answers));
        return (ArrayList<Question>) questionList;
    }
}
