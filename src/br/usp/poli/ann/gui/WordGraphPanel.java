/*     */ package br.usp.poli.ann.gui;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import javax.swing.JPanel;
/*     */ import org.jfree.chart.ChartFactory;
/*     */ import org.jfree.chart.ChartPanel;
/*     */ import org.jfree.chart.JFreeChart;
/*     */ import org.jfree.chart.axis.CategoryAxis;
/*     */ import org.jfree.chart.axis.CategoryLabelPositions;
/*     */ import org.jfree.chart.axis.NumberAxis;
/*     */ import org.jfree.chart.plot.CategoryPlot;
/*     */ import org.jfree.chart.plot.PlotOrientation;
/*     */ import org.jfree.chart.renderer.category.BarRenderer;
/*     */ import org.jfree.data.category.CategoryDataset;
/*     */ import org.jfree.data.category.DefaultCategoryDataset;
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
/*     */ 
/*     */ 
/*     */ public class WordGraphPanel
/*     */   extends JPanel
/*     */ {
/*  54 */   private DefaultCategoryDataset dataset = null;
/*     */   
/*     */   public WordGraphPanel() {
/*  57 */     this.dataset = new DefaultCategoryDataset();
/*  58 */     JFreeChart chart = createChart((CategoryDataset)this.dataset);
/*  59 */     ChartPanel chartPanel = new ChartPanel(chart, false);
/*  60 */     setLayout(new BorderLayout());
/*  61 */     add((Component)chartPanel, "Center");
/*     */   }
/*     */   
/*     */   public void addValue(double[] values, String language) {
/*  65 */     for (int i = 0; i < values.length; i++) {
/*  66 */       String word = String.valueOf((char)(65 + i));
/*  67 */       this.dataset.addValue(values[i], language, word);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void reset(int size) {
/*  72 */     while (this.dataset.getColumnCount() > 0) {
/*  73 */       this.dataset.removeColumn(0);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static JFreeChart createChart(CategoryDataset dataset) {
/*  80 */     JFreeChart chart = ChartFactory.createBarChart(
/*  81 */         "Histograma de Letras", 
/*  82 */         "Alfabeto (A-Z)", 
/*  83 */         "Freqüência", 
/*  84 */         dataset, 
/*  85 */         PlotOrientation.VERTICAL, 
/*  86 */         true, 
/*  87 */         true, 
/*  88 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     chart.setBackgroundPaint(Color.white);
/*     */ 
/*     */     
/*  97 */     CategoryPlot plot = (CategoryPlot)chart.getPlot();
/*  98 */     plot.setBackgroundPaint(Color.lightGray);
/*  99 */     plot.setDomainGridlinePaint(Color.white);
/* 100 */     plot.setDomainGridlinesVisible(true);
/* 101 */     plot.setRangeGridlinePaint(Color.white);
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
/* 112 */     NumberAxis rangeAxis = (NumberAxis)plot.getRangeAxis();
/* 113 */     rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
/*     */ 
/*     */     
/* 116 */     BarRenderer renderer = (BarRenderer)plot.getRenderer();
/* 117 */     renderer.setDrawBarOutline(false);
/*     */     
/* 119 */     CategoryAxis domainAxis = plot.getDomainAxis();
/* 120 */     domainAxis.setCategoryLabelPositions(
/* 121 */         CategoryLabelPositions.createUpRotationLabelPositions(
/* 122 */           0.5235987755982988D));
/*     */ 
/*     */     
/* 125 */     return chart;
/*     */   }
/*     */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/ann/gui/WordGraphPanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */