////////////////////////////////////////////////
// URSS-Telemetry-Manager
// Chris Dalke
////////////////////////////////////////////////
// Module: CommandPane
////////////////////////////////////////////////

package UI.Elements;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CommandPane extends JPanel {
   ThrottlePane throttlePane;
   SystemOptionsPane systemPane;
   
   public CommandPane() {
   
      //TitledBorder title = BorderFactory.createTitledBorder("Commands");
      //setBorder(title);
   
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
   
      throttlePane = new ThrottlePane();
      add(throttlePane);
      
      systemPane = new SystemOptionsPane();
      add(systemPane);
      
   }
   
   private class ThrottlePane extends JPanel {
      public ThrottlePane() {
   
         TitledBorder title = BorderFactory.createTitledBorder("Throttle");
         setBorder(title);
         
         JCheckBox throttleLimiter = new JCheckBox("Throttle Limit");
         JSpinner throttleLimitPicker = new JSpinner(new SpinnerNumberModel(100,0,100,1));
         
         add(throttleLimiter);
         add(throttleLimitPicker);
      }
   }
   
   private class SystemOptionsPane extends JPanel {
      public SystemOptionsPane() {
         GridLayout layout = new GridLayout(0,2);
         setLayout(layout);
   
         TitledBorder title = BorderFactory.createTitledBorder("System");
         setBorder(title);
         
         int i = 0;
         for (int x = 0; x <= 1; x++){
            for (int y = 0; y <= 4; y++){
               JButton button = new JButton("Button "+i++);
               add(button);
            }
         }
      }
   }
   
}

////////////////////////////////////////////////
// End of code
////////////////////////////////////////////////