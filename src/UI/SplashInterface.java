////////////////////////////////////////////////
// URSS-Telemetry-Manager
// Chris Dalke
////////////////////////////////////////////////
// Module: SplashInterface
////////////////////////////////////////////////

package UI;


import javax.swing.*;
import java.awt.*;

public class SplashInterface {
   private static JWindow splashWindow;
   
   private static SplashScreen splash;
   
   static void renderSplashFrame(Graphics2D g, int frame) {
      final String[] comps = {"foo", "bar", "baz"};
      g.setComposite(AlphaComposite.Clear);
      g.fillRect(120,140,200,40);
      g.setPaintMode();
      g.setColor(Color.BLACK);
      g.drawString("Loading "+comps[(frame/5)%3]+"...", 120, 150);
   }
   
   public static void showSplash() {
      
      /*
      splashWindow = new JWindow();
      splashWindow.setAlwaysOnTop(true);
      splashWindow.setPreferredSize(new Dimension(320,240));
      //splashWindow.getContentPane().add(new JLabel("", new ImageIcon("res/splash.png"), SwingConstants.CENTER));
      splashWindow.getContentPane().add(new JLabel("URSS Telemetry Manager", new ImageIcon("res/splash.png"), SwingConstants.CENTER));
      splashWindow.pack();
      Utility.centerWindow(splashWindow);
      splashWindow.setVisible(true);
      */
      splash = SplashScreen.getSplashScreen();
      if (splash == null) {
         System.out.println("SplashScreen.getSplashScreen() returned null");
         return;
      }
      Graphics2D g = splash.createGraphics();
      if (g == null) {
         System.out.println("g is null");
         return;
      }
      /*
      for(int i=0; i<100; i++) {
         renderSplashFrame(g, i);
         splash.update();
         try {
            Thread.sleep(90);
         }
         catch(InterruptedException e) {
         }
      }
      */
      //splash.close();

   }
   
   public static void hideSplash(){
      //splashWindow.setVisible(false);
      splash.close();
   }
   
}

////////////////////////////////////////////////
// End of code
////////////////////////////////////////////////