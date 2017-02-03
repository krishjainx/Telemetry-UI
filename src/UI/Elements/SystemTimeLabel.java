////////////////////////////////////////////////
// URSS-Telemetry-Manager
// Chris Dalke
////////////////////////////////////////////////
// Module: SystemTimeLabel
////////////////////////////////////////////////

package UI.Elements;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemTimeLabel extends JLabel implements ActionListener {
   SimpleDateFormat sdf;
   
   public SystemTimeLabel() {
      setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
      
      setForeground(Color.green);
      setBackground(Color.black);
      setOpaque(true);
      sdf = new SimpleDateFormat("hh:mm:ss a");
      setFont(new Font("sans-serif", Font.PLAIN, 24));
      setHorizontalAlignment(SwingConstants.LEFT);
      
      Timer t = new Timer(1000, this);
      t.start();
   }
   
   public void actionPerformed(ActionEvent ae) {
      Date d = new Date();
      setText(sdf.format(d));
     // System.out.println("Updating system timer label to "+sdf.format(d));
   }
}

////////////////////////////////////////////////
// End of code
////////////////////////////////////////////////