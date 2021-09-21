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
/*    */ public class WordFrame
/*    */   extends JFrame
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 40 */   private WordGraphPanel wordPanel = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WordFrame() {
/* 47 */     initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void initialize() {
/* 56 */     this.wordPanel = new WordGraphPanel();
/* 57 */     setContentPane(this.wordPanel);
/* 58 */     setTitle("Histograma de letras por idioma (treino)");
/* 59 */     pack();
/*    */   }
/*    */   
/*    */   public void addValue(double[] values, String language) {
/* 63 */     this.wordPanel.addValue(values, language);
/*    */   }
/*    */   
/*    */   public void reset(int size) {
/* 67 */     this.wordPanel.reset(size);
/*    */   }
/*    */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/ann/gui/WordFrame.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */