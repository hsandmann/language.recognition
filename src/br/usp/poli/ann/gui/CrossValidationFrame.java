/*    */ package br.usp.poli.ann.gui;
/*    */ 
/*    */ import br.usp.poli.ann.LanguageRecognitionController;
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
/*    */ public class CrossValidationFrame
/*    */   extends JFrame
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 41 */   private CrossValidationPanel panel = null;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CrossValidationFrame() {
/* 48 */     setSize(300, 200);
/* 49 */     this.panel = new CrossValidationPanel();
/* 50 */     setContentPane(this.panel);
/* 51 */     setTitle("Mapa de validação cruzada");
/*    */   }
/*    */   
/*    */   public void setCrossValidation(LanguageRecognitionController.CrossValidation map) {
/* 55 */     this.panel.setCrossValidation(map);
/*    */   }
/*    */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/ann/gui/CrossValidationFrame.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */