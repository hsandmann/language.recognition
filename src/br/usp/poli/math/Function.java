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
/*    */ public abstract class Function
/*    */ {
/*    */   public String getName() {
/* 37 */     return getClass().getName();
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract double f(double paramDouble);
/*    */   
/*    */   public abstract double dF(double paramDouble);
/*    */   
/*    */   public boolean equals(Object obj) {
/* 46 */     return ((Function)obj).getName().equals(getName());
/*    */   }
/*    */   
/*    */   public abstract double domainMax();
/*    */   
/*    */   public abstract double domainMin();
/*    */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/math/Function.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */