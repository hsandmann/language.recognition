/*    */ package br.usp.poli.ann;
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
/*    */ public class LanguageRecognitionUtil
/*    */ {
/*    */   public static final int SIZE = 26;
/*    */   
/*    */   public static double[] countCharFrequency(String text) {
/* 39 */     double[] map = new double[26];
/* 40 */     int n = 0; int i;
/* 41 */     for (i = 0; i < text.length(); i++) {
/* 42 */       char c = text.charAt(i);
/* 43 */       if (c >= 'A' && c <= 'Z') {
/* 44 */         map[c - 65] = map[c - 65] + 1.0D;
/* 45 */         n++;
/* 46 */       } else if (c >= 'a' && c <= 'z') {
/* 47 */         map[c - 97] = map[c - 97] + 1.0D;
/* 48 */         n++;
/*    */       } 
/*    */     } 
/* 51 */     for (i = 0; i < map.length; i++) {
/* 52 */       map[i] = map[i] / n;
/*    */     }
/* 54 */     return map;
/*    */   }
/*    */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/ann/LanguageRecognitionUtil.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */