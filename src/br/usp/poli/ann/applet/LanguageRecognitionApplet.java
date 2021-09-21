/*    */ package br.usp.poli.ann.applet;
/*    */ 
/*    */ import br.usp.poli.ann.LanguageRecognitionController;
/*    */ import br.usp.poli.ann.gui.LanguageRecognitionPanel;
/*    */ import java.applet.Applet;
/*    */ import java.awt.Component;
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
/*    */ public class LanguageRecognitionApplet
/*    */   extends Applet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public void init() {
/* 56 */     setSize(700, 540);
/* 57 */     LanguageRecognitionController controller = new LanguageRecognitionController();
/*    */     try {
/* 59 */       add((Component)new LanguageRecognitionPanel(controller));
/* 60 */     } catch (Exception e) {
/* 61 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/ann/applet/LanguageRecognitionApplet.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */