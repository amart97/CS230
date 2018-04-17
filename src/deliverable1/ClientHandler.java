/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable1;

/**
 *
 * @author alexm
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public class ClientHandler extends Thread{
    Server server;
    BufferedReader inReader;
    PrintWriter outWriter;
    
    public ClientHandler(Server s, Socket sock){
        server = s;
        System.out.println("Client started: " + sock.getInetAddress().toString());
        
        try{
            inReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            outWriter = new PrintWriter(sock.getOutputStream());
            
        }catch(IOException e){
            System.out.println("Exception in ClientHandler");
        }
        
    }
    public void run(){
        try{        
            String input;
            while((input = inReader.readLine()) != null){  
                //System.err.println("test" + input);
                processInput(input);
            }
        }catch(IOException e){
            System.out.println("Exception in ClientHandler:  Client likely Disconnected");
        }
         
    }
    
    private void processInput(String inputstring){
        System.err.println("CH Processing Command: " + inputstring);
        String[] stringarray;
        if(inputstring.startsWith("/addSEI") || inputstring.startsWith("/disableQ")) {
            System.err.println("Split on ;");
            stringarray = inputstring.split(";");
        }
        else stringarray = inputstring.split(",");
        
        if(stringarray[0].equals("/login")) {
            if(stringarray.length != 3) {
                outWriter.println("/login,false,false");
                outWriter.flush();
            }
            else {
                int result = server.checkCredentials(stringarray[1], stringarray[2]);
                switch (result) {
                    case 1:
                        outWriter.println("/login,true,admin");
                        outWriter.flush();
                        break;
                    case 2:
                        outWriter.println("/login,true,faculty");
                        outWriter.flush();
                        break;
                    case 3:
                        outWriter.println("/login,true,student");
                        outWriter.flush();
                        break;
                    case 4:
                        outWriter.println("/login,true,dean");
                        outWriter.flush();
                    default:
                        outWriter.println("/login,false,false");
                        outWriter.flush();
                        break;
                }
            }
        }
        else if(stringarray[0].equals("/addq")) {
            if(stringarray.length != 4) {
                outWriter.println("/addq,false");
                outWriter.flush();
            }
            else {
                server.qPool.addQuestion(stringarray[3], stringarray[1]); //adds to QPool
                server.sei.addQuestion(stringarray[1]); //adds to SEI 
                outWriter.println("/addq," + stringarray[3] + "," + stringarray[2] + "," + stringarray[1] + "," + "true");
                outWriter.flush();
            }
        }
        else if(stringarray[0].equals("/getq")) {
            ArrayList<String> str = server.qPool.getAllQuestions();
            String toSend = "/returnQList;";
            for(String s : str) {
                toSend += s + ";";
            }
            
            outWriter.println(toSend);
            outWriter.flush();
        }
        else if(stringarray[0].equals("/addSEI")) {
            for(int i = 1; i < stringarray.length; i++) {
                System.err.println("Adding to SEI");
                server.sei.addQuestion(stringarray[i]);
            }
            outWriter.println("/addSEI,success");
            outWriter.flush();
        }
        else if(stringarray[0].equals("/disableQ")) {
            System.err.println("In disable Q");
            for(int i = 1; i < stringarray.length; i++) {
                System.err.println("About to supposedly delete: " + stringarray[i]);
                server.qPool.deleteQuestion(stringarray[i]);
            }
            ArrayList<String>list = server.qPool.getAllQuestions();
            String out = "";
            for(String s : list) {
                out += s + ";";
            }
            System.err.println("out disable = " + out);
            outWriter.println("/disableQ;" + out);
            outWriter.flush();
        }
    }
}