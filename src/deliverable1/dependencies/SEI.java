/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable1.dependencies;


import java.util.ArrayList;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author alexm
 */
public class SEI {
    ArrayList<String> SEI;
    
    public SEI() {
        this.SEI = new ArrayList<String>(); 
    }

    //store question pool questions here. 
    public void addQuestion(String q) {
        this.SEI.add(q);
    }
    
    public ArrayList<String> getSEI() {
        return this.SEI;
    }
    
    public String getSEIQuestion(int qNum) {
        if(qNum < this.SEI.size()) {
            return this.SEI.get(qNum);
        }
        
        return "-1";
    }
}
    
    
