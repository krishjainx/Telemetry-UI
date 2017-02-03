////////////////////////////////////////////////
// URSS-Telemetry-Manager
// Chris Dalke
////////////////////////////////////////////////
// Module: GraphPane
////////////////////////////////////////////////

package UI.Elements;

import org.jfree.chart.*;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.panel.CrosshairOverlay;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Crosshair;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class GraphPane extends JPanel {
   public GraphPane() {
      TitledBorder title = BorderFactory.createTitledBorder("Graphs");
      setBorder(title);
      
      add(new GraphPanel());
   }
   
   private class GraphPanel extends JPanel implements ActionListener, ChartMouseListener {
      private TimeSeries series = new TimeSeries("Voltage Data");
      private double lastValue = 12.0D;
      private Crosshair xCrosshair;
      private Crosshair yCrosshair;
      ChartPanel chartPanel;
      
      public GraphPanel() {
         super(new BorderLayout());
         TimeSeriesCollection var1 = new TimeSeriesCollection(this.series);
         chartPanel = new ChartPanel(this.createChart(var1));
         add(chartPanel);
   
         chartPanel.addChartMouseListener(this);
         CrosshairOverlay crosshairOverlay = new CrosshairOverlay();
         this.xCrosshair = new Crosshair(0.0D / 0.0, Color.GRAY, new BasicStroke(0.0F));
         this.xCrosshair.setLabelVisible(true);
         this.yCrosshair = new Crosshair(0.0D / 0.0, Color.GRAY, new BasicStroke(0.0F));
         this.yCrosshair.setLabelVisible(true);
         crosshairOverlay.addDomainCrosshair(this.xCrosshair);
         crosshairOverlay.addRangeCrosshair(this.yCrosshair);
         chartPanel.addOverlay(crosshairOverlay);
   
         Timer t = new Timer(1000, this);
         t.start();
      }
      
      private JFreeChart createChart(XYDataset var1) {
         JFreeChart var2 = ChartFactory.createTimeSeriesChart(null, "Time", "Voltage", var1);
         var2.setAntiAlias(true);
         var2.setBackgroundPaint(null);
         setFontColor(var2,Color.white);
         
         XYPlot var3 = (XYPlot)var2.getPlot();
         ValueAxis var4 = var3.getDomainAxis();
         var4.setAutoRange(true);
         var4.setFixedAutoRange(60000.0D);
         var4 = var3.getRangeAxis();
         var4.setRange(0.0D, 36.0D);
         return var2;
      }
      
      public void actionPerformed(ActionEvent var1) {
         double var2 = 0.9D + 0.2D * Math.random();
         this.lastValue *= var2;
         Millisecond var4 = new Millisecond();
         System.out.println("Now = " + var4.toString());
         this.series.add(new Millisecond(), this.lastValue);
         
      }
      private void setFontColor(JFreeChart chart, Color fontColor) {
         //chart.getTitle().setPaint(fontColor);
         Plot plot = chart.getPlot();
         if (plot instanceof CategoryPlot) {
            setAxisFontColor(((CategoryPlot) plot).getDomainAxis(), fontColor);
            setAxisFontColor(((CategoryPlot) plot).getRangeAxis(), fontColor);
         } else if (plot instanceof XYPlot) {
            setAxisFontColor(((XYPlot) plot).getDomainAxis(), fontColor);
            setAxisFontColor(((XYPlot) plot).getRangeAxis(), fontColor);
         }
      }
   
      private void setAxisFontColor(Axis axis, Color fontColor) {
         if (!fontColor.equals(axis.getLabelPaint()))
            axis.setLabelPaint(fontColor);
         if (!fontColor.equals(axis.getTickLabelPaint()))
            axis.setTickLabelPaint(fontColor);
      }
   
      public void chartMouseClicked(ChartMouseEvent var1) {
      }
   
      public void chartMouseMoved(ChartMouseEvent var1) {
         Rectangle2D var2 = chartPanel.getScreenDataArea();
         JFreeChart var3 = var1.getChart();
         XYPlot var4 = (XYPlot)var3.getPlot();
         ValueAxis var5 = var4.getDomainAxis();
         double var6 = var5.java2DToValue((double)var1.getTrigger().getX(), var2, RectangleEdge.BOTTOM);
         if(!var5.getRange().contains(var6)) {
            var6 = 0.0D / 0.0;
         }
      
         double var8 = DatasetUtilities.findYValue(var4.getDataset(), 0, var6);
         this.xCrosshair.setValue(var6);
         this.yCrosshair.setValue(var8);
      }
   }
   
}

////////////////////////////////////////////////
// End of code
////////////////////////////////////////////////