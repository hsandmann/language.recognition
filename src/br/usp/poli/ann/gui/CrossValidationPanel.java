/*    */ package br.usp.poli.ann.gui;
/*    */ 
/*    */ import br.usp.poli.ann.LanguageRecognitionController;
/*    */ import java.awt.BorderLayout;
/*    */ import java.text.DecimalFormat;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.DefaultTableModel;
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
/*    */ public class CrossValidationPanel
/*    */   extends JPanel
/*    */ {
/*    */   private JTable tblValidation;
/* 46 */   private DecimalFormat formatter = new DecimalFormat("#0.00");
/*    */   
/*    */   public CrossValidationPanel() {
/* 49 */     setLayout(new BorderLayout());
/* 50 */     this.tblValidation = new JTable();
/* 51 */     JScrollPane scrollPane = new JScrollPane();
/* 52 */     scrollPane.setViewportView(this.tblValidation);
/* 53 */     add(scrollPane, "Center");
/*    */   }
/*    */   
/*    */   public void setCrossValidation(LanguageRecognitionController.CrossValidation map) {
/* 57 */     String[] classNames = map.getClassNames();
/* 58 */     Object[][] content = new Object[classNames.length][classNames.length + 2];
/*    */     
/* 60 */     String[] header = new String[classNames.length + 2];
/* 61 */     header[0] = "";
/* 62 */     header[classNames.length + 1] = "Desconhecido";
/* 63 */     for (int i = 0; i < classNames.length; i++) {
/* 64 */       header[i + 1] = classNames[i];
/* 65 */       content[i][0] = classNames[i];
/* 66 */       for (int j = 0; j < classNames.length; j++) {
/* 67 */         content[i][j + 1] = this.formatter.format(map.getResult(classNames[i], classNames[j]) * 100.0D);
/*    */       }
/* 69 */       content[i][classNames.length + 1] = this.formatter.format(map.getResult(classNames[i], null) * 100.0D);
/*    */     } 
/*    */     
/* 72 */     this.tblValidation.setModel(
/* 73 */         new DefaultTableModel(this, 
/* 74 */           content, 
/* 75 */           (Object[])header)
/*    */         {
/*    */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 78 */             return false;
/*    */           }
/*    */           
/*    */           final CrossValidationPanel this$0;
/*    */         });
/*    */   }
/*    */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/ann/gui/CrossValidationPanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */