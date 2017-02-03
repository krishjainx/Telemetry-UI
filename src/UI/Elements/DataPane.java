////////////////////////////////////////////////
// URSS-Telemetry-Manager
// Chris Dalke
////////////////////////////////////////////////
// Module: CommandPane
////////////////////////////////////////////////

package UI.Elements;

import javax.swing.*;
import java.awt.*;

public class DataPane extends JPanel {
   GraphPane graphPane;
   BatteryPane batteryPane;
   BoatSchematic boatPane;
   
   public DataPane() {
   
      /*
      TitledBorder title = BorderFactory.createTitledBorder("Data");
      setBorder(title);
      */
   
      setLayout(new BorderLayout());
      
      batteryPane = new BatteryPane();
      graphPane = new GraphPane();
      boatPane = new BoatSchematic();
   
      JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, graphPane, boatPane);
      JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane1, batteryPane);
      //splitPane1.setDividerLocation(50.0);
      //splitPane2.setDividerLocation(50.0);
      
      add(splitPane2,BorderLayout.CENTER);
   }
   
}

////////////////////////////////////////////////
// End of code
////////////////////////////////////////////////