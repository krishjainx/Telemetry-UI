////////////////////////////////////////////////
// URSS-Telemetry-Manager
// Chris Dalke
////////////////////////////////////////////////
// Module: Log
////////////////////////////////////////////////

package UI.Elements;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.PrintStream;

public class Log extends JPanel {
   JTextArea textArea;
   JScrollPane scrollPane;
   JTextArea commandArea;
   JButton executeCommandButton;
   JButton clearLogButton;
   
   public Log() {
   
      setLayout(new BorderLayout());
   
      textArea = new JTextArea();
      textArea.setBackground(Color.black);
      textArea.setForeground(Color.GREEN);
      scrollPane = new JScrollPane(textArea);
      TitledBorder title = BorderFactory.createTitledBorder("System Log");
      setBorder(title);
      textArea.setEditable(false);
      add(scrollPane, BorderLayout.CENTER);
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      scrollPane.setPreferredSize(new Dimension(0,200));
   
      PrintStream con=new PrintStream(new TextAreaOutputStream(textArea));
      System.setOut(con);
      System.setErr(con);
      
      JPanel logCommandPanel = new JPanel();
      logCommandPanel.setLayout(new BoxLayout(logCommandPanel, BoxLayout.PAGE_AXIS));
      add(logCommandPanel,BorderLayout.WEST);
      
      executeCommandButton = new JButton("Execute");
      clearLogButton = new JButton("Clear Log");
      logCommandPanel.add(clearLogButton);
      logCommandPanel.add(executeCommandButton);
      
   }
   
}

////////////////////////////////////////////////
// End of code
////////////////////////////////////////////////