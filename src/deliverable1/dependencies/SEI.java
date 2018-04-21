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
        this.SEI.add("Please provide comments / constructive feedback for the course as a whole.");
        this.SEI.add("Please provide comments / constructive feedback for the instructor.");
        this.SEI.add("I expect to pass this class.");
        this.SEI.add("I spent an appopriate amount of time outside of class preparing for exams.");
        this.SEI.add("Pre-requisites for this class prepared me for the class.");
        this.SEI.add("I am confident in my abilities to apply what I learned in this class to real world problems.");
        this.SEI.add("To validate your reponses please select 'Disagree'");
    }

    //store question pool questions here. 
    public void addQuestion(String q) {
        this.SEI.add(q);
        System.err.println(SEI);
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
    
    
