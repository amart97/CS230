/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable1;

import deliverable1.dependencies.QuestionPool;
import deliverable1.dependencies.SEI;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
/**
 *
 * @author Alexander
 */
public class Server extends Thread{
    Boolean running = true;
    ArrayList<ClientHandler> clientList = new ArrayList();
    ArrayList<String> responses = new ArrayList();
    QuestionPool qPool = new QuestionPool();
    SEI sei = new SEI();
    
    Server(){
        
    }
    public int checkCredentials(String uName, String pass) {
        System.out.println(uName + " " + pass);
        if(uName.equals("admin") && pass.equals("admin123")) {
            return 1;
        }
        else if(uName.equals("faculty") && pass.equals("faculty123")) {
            return 2;
        }
        else if(uName.equals("student") && pass.equals("student123")) {
            return 3;
        }
        else if(uName.equals("dean") && pass.equals("dean123")) {
            return 4;
        }
        else return -1; //default whoopsie case
    }
            
    @Override
    public void run(){
        System.out.println("Starting Server");

        try{
            ServerSocket ss = new ServerSocket(32345);
            while(running){
                Socket clientSocket = ss.accept();
                ClientHandler ch = new ClientHandler(this, clientSocket);
                ch.start();
                clientList.add(ch);
            }
        }catch(IOException e){
            System.out.println("Server Error");
        }
        
        System.out.println("Server Stopped");
    }
    
    public static void main(String [] args){
        new Server().start();
    }
}

