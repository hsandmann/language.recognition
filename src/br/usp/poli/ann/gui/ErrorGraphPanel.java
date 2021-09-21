/*     */ package br.usp.poli.ann.gui;
/*     */ 
/*     */ import br.usp.poli.ann.ErrorController;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import javax.swing.JPanel;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.axis.NumberAxis;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.chart.plot.XYPlot;
/*     */ import org.jfree.data.xy.XYDataset;
/*     */ import org.jfree.data.xy.YIntervalSeries;
/*     */ import org.jfree.data.xy.YIntervalSeriesCollection;
/*     */ import org.jfree.ui.RectangleInsets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ErrorGraphPanel
/*     */   extends JPanel
/*     */   implements ErrorController
/*     */ {
/*  53 */   private YIntervalSeries mse = null;
/*  54 */   private YIntervalSeriesCollection dataset = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ErrorGraphPanel() {
/*  62 */     ChartPanel chartPanel = new ChartPanel(createChart());
/*  63 */     setLayout(new BorderLayout());
/*  64 */     add((Component)chartPanel, "Center");
/*     */   }
/*     */   
/*     */   public void addValue(double x, double y, double yMin, double yMax) {
/*  68 */     this.mse.add(x, y, yMin, yMax);
/*     */   }
/*     */   
/*     */   public void reset() {
/*  72 */     while (this.mse != null && this.mse.getItemCount() > 0) {
/*  73 */       this.mse.remove(new Double(this.mse.getX(0).doubleValue()));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JFreeChart createChart() {
/*  86 */     this.dataset = new YIntervalSeriesCollection();
/*  87 */     this.mse = new YIntervalSeries("Erro médio quadrado");
/*  88 */     this.dataset.addSeries(this.mse);
/*     */ 
/*     */     
/*  91 */     JFreeChart chart = ChartFactory.createXYLineChart(
/*  92 */         "Erro médio quadrado da rede", 
/*  93 */         "Número de interações", 
/*  94 */         "Erro médio quadrado (MSE)", 
/*  95 */         (XYDataset)this.dataset, 
/*  96 */         PlotOrientation.VERTICAL, 
/*  97 */         false, 
/*  98 */         true, 
/*  99 */         false);
/*     */ 
/*     */     
/* 102 */     chart.setBackgroundPaint(Color.white);
/*     */ 
/*     */     
/* 105 */     XYPlot plot = (XYPlot)chart.getPlot();
/* 106 */     plot.setBackgroundPaint(Color.lightGray);
/* 107 */     plot.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
/* 108 */     plot.setDomainGridlinePaint(Color.white);
/* 109 */     plot.setRangeGridlinePaint(Color.white);
/* 110 */     plot.setDomainCrosshairVisible(true);
/* 111 */     plot.setRangeCrosshairVisible(true);
/*     */ 
/*     */     
/* 114 */     NumberAxis yAxis = (NumberAxis)plot.getRangeAxis();
/* 115 */     yAxis.setAutoRangeIncludesZero(true);
/* 116 */     yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
/*     */     
/* 118 */     return chart;
/*     */   }
/*     */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/ann/gui/ErrorGraphPanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */