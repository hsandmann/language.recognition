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
/*    */ public class HyperbolicTangent
/*    */   extends Function
/*    */ {
/*    */   public String getName() {
/* 40 */     return "Tangente Hiperbólica";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double dF(double y) {
/* 48 */     return (new HyperbolicSecant()).f(y);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double f(double x) {
/* 55 */     return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
/*    */   }
/*    */   
/*    */   public double domainMax() {
/* 59 */     return 1.0D;
/*    */   }
/*    */   
/*    */   public double domainMin() {
/* 63 */     return -1.0D;
/*    */   }
/*    */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/math/HyperbolicTangent.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */