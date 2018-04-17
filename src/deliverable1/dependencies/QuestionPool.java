/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable1.dependencies;

/**
 *
 * @author alexm
 */

import java.util.ArrayList;
import java.util.Set;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class QuestionPool {
        static final String FILEPATH = "C:\\Users\\alexm\\Desktop\\LogInMockUps\\src\\deliverable1\\dependencies\\rawPool.txt";
        File f;
        Scanner scanner;
	ArrayList<String> dictionary = new ArrayList<String>();
        ArrayList<String> deleted = new ArrayList<String>();
	
        public QuestionPool() {
            populatePool();
        }
        
        public void populatePool() {
            int i = 1;
            String currLine;
            
            try{
                f = new File(FILEPATH);
                scanner = new Scanner(f);
          
                while(scanner.hasNext()) {
                    dictionary.add(scanner.nextLine());
                    i++;
                }
            } catch(IOException e) {}
        }
        
	public void addQuestion(String questionNumber, String question) {
		dictionary.add(question);
	}
	
	public void deleteQuestion(String question) {
                System.err.println("in deleteQuestion");
                dictionary.remove(question);
            

	}
        
        public ArrayList<String> getDeletedQuestions() {
            return deleted;
        }
	
	public String getQuestion(int questionNumber) {
            if(questionNumber < dictionary.size() && questionNumber >= 0) {
		String question = dictionary.get(questionNumber);
		return question;
            }
            return "-1";
	}
        
	public ArrayList<String> getAllQuestions() {
		return dictionary;
	}	
}