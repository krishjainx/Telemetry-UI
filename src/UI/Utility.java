////////////////////////////////////////////////
// URSS-Telemetry-Manager
// Chris Dalke
////////////////////////////////////////////////
// Module: Utility
////////////////////////////////////////////////

package UI;

import java.awt.*;

public class Utility {
   
   
   public static void centerWindow(Window frame) {
      Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
      int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
      frame.setLocation(x, y);
   }
   
}

////////////////////////////////////////////////
// End of code
////////////////////////////////////////////////