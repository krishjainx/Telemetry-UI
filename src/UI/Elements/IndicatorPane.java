////////////////////////////////////////////////
// URSS-Telemetry-Manager
// Chris Dalke
////////////////////////////////////////////////
// Module: IndicatorPane
////////////////////////////////////////////////

package UI.Elements;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class IndicatorPane extends JPanel {
   SystemTimeLabel systemTimeLabel;
   
   public IndicatorPane(){
      TitledBorder title = BorderFactory.createTitledBorder("Indicator Panel");
      setBorder(title);
      
      systemTimeLabel = new SystemTimeLabel();
      add(systemTimeLabel);
      
   }
}

////////////////////////////////////////////////
// End of code
////////////////////////////////////////////////