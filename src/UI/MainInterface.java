////////////////////////////////////////////////
// URSS-Telemetry-Manager
// Chris Dalke
////////////////////////////////////////////////
// Module: MainInterface
////////////////////////////////////////////////

package UI;

import UI.Elements.*;

import javax.swing.*;
import java.awt.*;

public class MainInterface extends javax.swing.JFrame {
   
   JMenuBar menuBar;
   BatteryPane batteryPane;
   CommandPane commandPane;
   IndicatorPane indicatorPane;
   GraphPane graphPane;
   BottomPane bottomPane;
   
   
   public MainInterface() {
      initComponents();
   }
   
   public void initComponents(){
      setPreferredSize(new Dimension(1024,768));
      setTitle("URSS Telemetry Manager");
      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      pack();
      //setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
   
      Utility.centerWindow(this);
      
      menuBar = new JMenuBar();
      JMenu fileMenu = new JMenu("File");
      JMenu helpMenu = new JMenu("Help");
      
      menuBar.add(fileMenu);
      menuBar.add(helpMenu);
      
      JMenuItem fileExit = new JMenuItem("Exit");
      fileMenu.add(fileExit);
      
      JMenuItem helpAbout = new JMenuItem("About");
      helpMenu.add(helpAbout);
      
      setJMenuBar(menuBar);
   
      setLayout(new BorderLayout());
      
      
      batteryPane = new BatteryPane();
      commandPane = new CommandPane();
      indicatorPane = new IndicatorPane();
      graphPane = new GraphPane();
      bottomPane = new BottomPane();
      
      add(indicatorPane,BorderLayout.NORTH);
      add(graphPane,BorderLayout.CENTER);
      add(batteryPane,BorderLayout.EAST);
      add(commandPane,BorderLayout.WEST);
      add(bottomPane,BorderLayout.SOUTH);
   
   
   }
   
}

////////////////////////////////////////////////
// End of code
////////////////////////////////////////////////