/*    */ package br.usp.poli.math;
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
/*    */ public class Sigmoid
/*    */   extends Function
/*    */ {
/*    */   public String getName() {
/* 40 */     return "Sigmóide";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double dF(double y) {
/* 47 */     return y * (1.0D - y);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double f(double x) {
/* 54 */     return 1.0D / (1.0D + Math.exp(-x));
/*    */   }
/*    */   
/*    */   public double domainMax() {
/* 58 */     return 1.0D;
/*    */   }
/*    */   
/*    */   public double domainMin() {
/* 62 */     return 0.0D;
/*    */   }
/*    */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/math/Sigmoid.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */