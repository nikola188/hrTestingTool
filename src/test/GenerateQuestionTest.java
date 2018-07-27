package test;

import Core.GenerateQuestion;
import Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util2.TestQuestion;

public class GenerateQuestionTest {
    
   private static SessionFactory factory;
   private static Session session;
   public static void main(String[] args) {
       try{
            System.out.println("Test start");
            factory = HibernateUtil.getSessionFactory();
            try {
                session = factory.openSession();
                System.out.println("Session is open");
            } catch (Throwable ex) {
                System.err.println("Failed to create sessionFactory object." + ex);
                throw new ExceptionInInitializerError(ex);
            }


            System.out.println("Testing database connection...");
            Query query = session.createQuery("from Technology");
            List<Beans.Technology> technologies = query.list();
            System.out.println(technologies.size());
            query = session.createQuery("from Question");
            List<Beans.Question> question = query.list();
            System.out.println(question.size());
            query = session.createQuery("from Candidate");
            List<Beans.Candidate> candidate = query.list();
            System.out.println(candidate.size());
            System.out.println("Most important tables tested!");

            System.out.println("Testing GenerateQuestion for candidateId 2 who knows 4 technologies");

            int candidateId = 2;
            int numberOfQuestions = 5;
            
            GenerateQuestion.getQuestions(candidateId, numberOfQuestions);
            List<TestQuestion> questions = GenerateQuestion.getList();
            
            System.out.println("list length:   " + questions.size());

            if(questions != null && !questions.isEmpty()){
                for(int i = 0; i < questions.size(); i++){
                    TestQuestion q = questions.get(i);
                    System.out.print(q.getQuestion().getId() + " ");
                    System.out.print(q.getQuestion().getIdTechnology() + " ");
                    System.out.print(q.getQuestion().getPoints() + " ");
                    System.out.print(q.getQuestion().getText() + " ");
                    System.out.println(q.getList().get(0).getText());
                    System.out.println("");
                }
            } else {
                System.out.println("No questions found.");
            }
            System.out.println("Test completed!");

        }catch(Exception ex){
           ex.printStackTrace();
        }
   }
    
}
