/*    */ package br.usp.poli.ann.gui;
/*    */ 
/*    */ import br.usp.poli.ann.LanguageRecognitionController;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.SwingUtilities;
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
/*    */ public class LanguageRecognition
/*    */   extends JFrame
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public static void main(String[] args) {
/* 47 */     JFrame.setDefaultLookAndFeelDecorated(true);
/* 48 */     SwingUtilities.invokeLater(new Runnable() {
/*    */           public void run() {
/* 50 */             LanguageRecognition thisClass = new LanguageRecognition();
/* 51 */             thisClass.setDefaultCloseOperation(3);
/* 52 */             thisClass.setVisible(true);
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LanguageRecognition() {
/*    */     try {
/* 63 */       initialize();
/* 64 */     } catch (Exception e) {
/* 65 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void initialize() throws Exception {
/* 75 */     setSize(700, 560);
/* 76 */     setTitle("Reconhecimento de Idioma");
/* 77 */     add(new LanguageRecognitionPanel(new LanguageRecognitionController()));
/* 78 */     pack();
/*    */   }
/*    */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/ann/gui/LanguageRecognition.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */