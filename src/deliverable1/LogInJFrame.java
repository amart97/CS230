/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverable1;

import deliverable1.landingFrames.DeanFrame;
import deliverable1.landingFrames.StudentFrame;
import deliverable1.landingFrames.FacultyFrame;
import deliverable1.landingFrames.AdminFrame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author icani
 */
public class LogInJFrame extends javax.swing.JFrame {

    Socket socket;
    PrintWriter outWriter;
    ClientListener cl;
    ArrayList<JComponent> inputs = new ArrayList();
    Boolean valid;
    int qNum = 0;
    
    public LogInJFrame() {
        initComponents();
        valid = false;
        validityLabel.setVisible(false);
        
        try{
            socket = new Socket("localhost",32345);
            outWriter = new PrintWriter(socket.getOutputStream());
            cl = new ClientListener();
            cl.start();
        }catch(IOException e){
            //JOptionPane.showMessageDialog(jPanel1, "Error connecting to Server.");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblReset = new javax.swing.JLabel();
        loginUsername = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();
        validityLabel = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        loginPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsername.setText("Username");

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPassword.setText("Password");

        lblReset.setForeground(new java.awt.Color(51, 102, 255));
        lblReset.setText("Click Here to Reset Login Credentials");

        loginUsername.setName(""); // NOI18N

        submitBtn.setText("Login");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        validityLabel.setForeground(new java.awt.Color(255, 0, 0));
        validityLabel.setText("ERROR - PLEASE CHECK CREDENTIALS AND TRY AGAIN");
        validityLabel.setToolTipText("");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deliverable1/GroupMe_201842_10218.png"))); // NOI18N
        logo.setText("jLabel1");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReset)
                    .addComponent(lblUsername)
                    .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(loginUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(lblPassword)
                            .addComponent(loginPassword))
                        .addGap(94, 94, 94)
                        .addComponent(validityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(validityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(lblReset)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1697, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 509, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        valid = false;
        validityLabel.setVisible(false);
        
        if(loginUsername.getText() != null && loginPassword.getText() != null){
            outWriter.println("/login," + loginUsername.getText() + "," + loginPassword.getText());
            outWriter.flush();   
        }
        else validityLabel.setVisible(true);
    }//GEN-LAST:event_submitBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInJFrame().setVisible(true);
            }
        });
    }
    
    class ClientListener extends Thread{
        
        public void run(){
            try {
                System.out.println("Listener Started");
                BufferedReader inReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String inString;
                while((inString = inReader.readLine()) != null){
                    System.err.println("processing command: " + inString);
                    System.out.println(inString);
                    processCommand(inString);

                }   
            } 
            catch(IOException e){
                System.out.println("Error in Client Listener");
            }
        }
        
        private void processCommand(String inString){
            String[] stringarr = inString.split(",");
            if(stringarr[0].equals("/login")) {
                if(stringarr[1].equals("false")) {
                    valid = false;
                    validityLabel.setVisible(true);
                }
                else if(stringarr[2].equals("admin")) {
                    valid = true;
                    //SEND TO ADMIN SCREEN
                    loginPanel.setVisible(false);
                    new AdminFrame().setVisible(true);

                }
                else if(stringarr[2].equals("faculty")) {
                    valid = true;
                    //SEND TO FACULTY SCREEN
                    loginPanel.setVisible(false);
                    new FacultyFrame().setVisible(true);
                }
                else if(stringarr[2].equals("student")) {
                    valid = true;
                    //SEND TO STUDENT SCREEN
                    loginPanel.setVisible(false);
                    new StudentFrame().setVisible(true);
                }
                else if(stringarr[2].equals("dean")) {
                    valid = true;
                    loginPanel.setVisible(false);
                    new DeanFrame().setVisible(true);
                }
                else valid = false;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblReset;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField loginPassword;
    private javax.swing.JTextField loginUsername;
    private javax.swing.JLabel logo;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel validityLabel;
    // End of variables declaration//GEN-END:variables
}
