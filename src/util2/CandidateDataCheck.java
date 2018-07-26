
package util2;



/**
 *
 * @author nikola.panajotovic
 * @author nikola.bijelic
 */
public class CandidateDataCheck {
   
    public static boolean everythingFine(String candidateId, String numberOfQusetions, String testDuration){
        try {
            int id = Integer.parseInt(candidateId);
            int numQuestions = Integer.parseInt(numberOfQusetions);
            int duration = Integer.parseInt(testDuration);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
