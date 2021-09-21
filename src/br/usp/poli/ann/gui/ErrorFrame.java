/*    */ package br.usp.poli.ann.gui;
/*    */ 
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ErrorFrame
/*    */   extends JFrame
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 40 */   private ErrorGraphPanel errorGraphPanel = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ErrorFrame() {
/* 47 */     initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void initialize() {
/* 56 */     setSize(300, 200);
/* 57 */     this.errorGraphPanel = new ErrorGraphPanel();
/* 58 */     setContentPane(this.errorGraphPanel);
/* 59 */     setTitle("Error médio quadrado");
/* 60 */     pack();
/*    */   }
/*    */   
/*    */   public void addValue(double x, double y, double yMin, double yMax) {
/* 64 */     this.errorGraphPanel.addValue(x, y, yMin, yMax);
/*    */   }
/*    */   
/*    */   public void reset() {
/* 68 */     this.errorGraphPanel.reset();
/*    */   }
/*    */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/ann/gui/ErrorFrame.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */