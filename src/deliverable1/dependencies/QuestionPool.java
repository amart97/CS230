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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuestionPool {
        static final String FILEPATH = "C:\\Users\\alexm\\Desktop\\LogInMockUps\\src\\deliverable1\\dependencies\\rawPool.txt";
        FileReader fr;
        BufferedReader br;
	Map<String, String> dictionary = new HashMap<String, String>();
	
        public void populatePool() {
            int i = 1;
            String currLine;
            
            try{
                fr = new FileReader(FILEPATH);
                br = new BufferedReader(fr);
          
                while((currLine = br.readLine()) != null) {
                    dictionary.put(Integer.toString(i), currLine);
                    i++;
                }
            } catch(IOException e) {}
        }
        
	public void addQuestion(String questionNumber, String question) {
		dictionary.put(questionNumber, question);
	}
	
	public void deleteQuestion(String questionNumber) {
		dictionary.remove(questionNumber);
	}
	
	public String getQuestion(String questionNumber) {
		String question = dictionary.get(questionNumber);
		return question;
	}
	
	public String[] createSurvey(String[] questionNumbers, int surveySize) {
		String[] survey = new String[surveySize];
		for(int i = 0; i < surveySize; i++) {
			survey[i] = dictionary.get(questionNumbers[i]);
		}
		return survey;
	}
	
	public String[] getAllQuestionNumbers() {
		Set<String> set = dictionary.keySet();
		String[] questionNumbers = (String[]) set.toArray();
		return questionNumbers;
	}
	
	public String[] getAllQuestions() {
		String[] questionNumbers = getAllQuestionNumbers();
		String[] questions = new String[questionNumbers.length];
		for(int i = 0; i < questionNumbers.length; i++) {
			questions[i] = dictionary.get(questionNumbers[i]);
		}
		return questions;
	}	
}