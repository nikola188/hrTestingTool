/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util2;
import java.util.*;

/**
 *
 * @author zoran.milicevic
 * 
 * 
 */
public class ResultUtil {
    
    private String technology;
    private int result;
    private Map<String, Integer> resultsMap;
    
    public ResultUtil(String technology){
    
       this.technology = technology;
       resultsMap = new HashMap<String,Integer>();
    }
    
    public ResultUtil(String technology, int result) {
        this.technology = technology;
        this.result = result;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
    
    public void setResultsMap(String tech, int result){
        
        resultsMap.put(tech, result);
    
    }
    
    public boolean existResult(String tech){
           
        boolean exist = resultsMap.containsKey(tech);
        
        if(exist)
              return true;
        else return false;
            
    }
 
}
