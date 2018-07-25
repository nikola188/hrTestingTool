/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util2;

/**
 *
 * @author zoran.milicevic
 */
public class ResultUtil {
    private String technology;
    private int result;

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
    
    
}
