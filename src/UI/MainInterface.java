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
   DataPane dataPane;
   CommandPane commandPane;
   IndicatorPane indicatorPane;
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
      
      commandPane = new CommandPane();
      indicatorPane = new IndicatorPane();
      bottomPane = new BottomPane();
      dataPane = new DataPane();
      
      add(indicatorPane,BorderLayout.NORTH);
      add(dataPane,BorderLayout.CENTER);
      add(commandPane,BorderLayout.EAST);
      add(bottomPane,BorderLayout.SOUTH);
   
   
   }
   
}

////////////////////////////////////////////////
// End of code
////////////////////////////////////////////////