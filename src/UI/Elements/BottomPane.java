////////////////////////////////////////////////
// URSS-Telemetry-Manager
// Chris Dalke
////////////////////////////////////////////////
// Module: BottomPane
////////////////////////////////////////////////

package UI.Elements;

import javax.swing.*;
import java.awt.*;

public class BottomPane extends JPanel {
   
   BoatSchematic boatSchematic;
   Log log;
   
   public BottomPane() {
      setLayout(new BorderLayout());
   
      boatSchematic = new BoatSchematic();
      add(boatSchematic,BorderLayout.NORTH);
      
      log = new Log();
      add(log,BorderLayout.SOUTH);
   }
   
}

////////////////////////////////////////////////
// End of code
////////////////////////////////////////////////