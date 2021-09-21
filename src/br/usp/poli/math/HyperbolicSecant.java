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
/*    */ public class HyperbolicSecant
/*    */   extends Function
/*    */ {
/*    */   public double dF(double y) {
/* 40 */     return -f(y) * (new HyperbolicTangent()).f(y);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double domainMax() {
/* 47 */     return 1.0D;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double domainMin() {
/* 54 */     return 0.0D;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double f(double x) {
/* 61 */     return 2.0D / (Math.exp(x) + Math.exp(-x));
/*    */   }
/*    */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/math/HyperbolicSecant.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */