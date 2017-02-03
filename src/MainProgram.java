////////////////////////////////////////////////
// URSS-Telemetry-Manager
// Chris Dalke
////////////////////////////////////////////////
// Module: MainProgram
////////////////////////////////////////////////

import UI.MainInterfaceController;

import javax.swing.*;

public class MainProgram {
   
   //Main entry point for the Telemetry UI
   public static void main(String[] args) {
      
      //Set up Darcula custom Look and Feel
      try {
         /*
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName());
            if ("Darcula".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
         */
         UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
      } catch (Exception e) {
      }
      
   
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new MainInterfaceController();
         }
      });
      
   }
   
   public static void quit(){
      System.exit(0);
   }
   
   
   
}

////////////////////////////////////////////////
// End of code
////////////////////////////////////////////////