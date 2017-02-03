////////////////////////////////////////////////
// URSS-Telemetry-Manager
// Chris Dalke
////////////////////////////////////////////////
// Module: BatteryPane
////////////////////////////////////////////////

package UI.Elements;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BatteryPane extends JPanel {
   public BatteryPane() {
      TitledBorder title = BorderFactory.createTitledBorder("Battery Monitor");
      setBorder(title);
      
      add(new BatteryCanvas());
   }
   
   private class BatteryCanvas extends JComponent {
      Image batteryImage;
      
      public BatteryCanvas(){
         setOpaque(true);
         setBackground(Color.black);
         setPreferredSize(new Dimension(140,0));
      }
   
      public void paintComponent(Graphics g)
      {
         super.paintComponent(g);
         g.setColor(Color.blue);
         for (int x = 0; x < getWidth(); x++){
            for (int y = 0; y < getHeight(); y++){
               if ((x+y) % 11 == 0){
                  g.drawRect(x,y,1,1);
               }
            }
         }
         
         
      }
   }
   
}

////////////////////////////////////////////////
// End of code
////////////////////////////////////////////////