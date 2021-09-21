/*     */ package br.usp.poli.ann;
/*     */ 
/*     */ import br.usp.poli.math.Function;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MLP
/*     */ {
/*  38 */   private Function f = null;
/*     */   
/*  40 */   private double[][] L = null;
/*  41 */   private double[][] dL = null;
/*  42 */   private double[] Y = null;
/*  43 */   private double[] E = null;
/*  44 */   private double[][][] W = null;
/*     */   
/*  46 */   private double eta = 0.7D;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isLearning = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public MLP(Function activationFunction, int numberInput, int numberHidden, int numberOuput) {
/*  55 */     this.f = activationFunction;
/*     */     
/*  57 */     this.L = new double[3][];
/*  58 */     this.L[0] = new double[numberInput];
/*  59 */     this.L[1] = new double[numberHidden];
/*  60 */     this.L[2] = new double[numberOuput];
/*     */     
/*  62 */     this.dL = new double[3][];
/*  63 */     this.dL[0] = new double[numberInput];
/*  64 */     this.dL[1] = new double[numberHidden];
/*  65 */     this.dL[2] = new double[numberOuput];
/*     */     
/*  67 */     this.Y = new double[numberOuput];
/*     */     
/*  69 */     this.E = new double[numberOuput];
/*     */     
/*  71 */     this.W = new double[2][][];
/*  72 */     this.W[0] = new double[numberHidden][numberInput + 1];
/*  73 */     this.W[1] = new double[numberOuput][numberHidden + 1];
/*     */     
/*  75 */     reset();
/*     */   }
/*     */   
/*     */   public void setW(double[][][] w) {
/*  79 */     this.W = w;
/*     */   }
/*     */   
/*     */   public void reset() {
/*  83 */     double fator = Math.abs(this.f.domainMax()) + Math.abs(this.f.domainMin());
/*  84 */     for (int k = 0; k < this.W.length; k++) {
/*  85 */       for (int i = 0; i < (this.W[k]).length; i++) {
/*  86 */         for (int j = 0; j < (this.W[k][i]).length; j++) {
/*  87 */           this.W[k][i][j] = fator * Math.random() - fator / 2.0D;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fowardPropagation() {
/*  97 */     for (int l = 1; l < this.L.length; l++) {
/*  98 */       for (int j = 0; j < (this.L[l]).length; j++) {
/*  99 */         double s = 0.0D;
/* 100 */         int k = 0;
/* 101 */         for (; k < (this.L[l - 1]).length; k++) {
/* 102 */           s += this.L[l - 1][k] * this.W[l - 1][j][k];
/*     */         }
/* 104 */         s += this.W[l - 1][j][k];
/*     */         
/* 106 */         this.L[l][j] = this.f.f(s);
/* 107 */         this.dL[l][j] = this.f.dF(this.L[l][j]);
/*     */       } 
/*     */     } 
/* 110 */     if (!this.isLearning) {
/* 111 */       System.arraycopy(this.L[this.L.length - 1], 0, this.Y, 0, this.Y.length);
/*     */     }
/* 113 */     for (int i = 0; i < this.E.length; i++) {
/* 114 */       this.E[i] = this.Y[i] - this.L[2][i];
/*     */     }
/*     */   }
/*     */   
/*     */   public void backProgagation() {
/* 119 */     if (!this.isLearning) {
/* 120 */       throw new RuntimeException("Just a sample can be learn.");
/*     */     }
/*     */ 
/*     */     
/* 124 */     double[] deltaY = new double[(this.L[2]).length];
/* 125 */     for (int i = 0; i < deltaY.length; i++) {
/* 126 */       deltaY[i] = this.E[i] * this.dL[2][i];
/*     */     }
/*     */     
/* 129 */     double[] deltaH = new double[(this.L[1]).length];
/* 130 */     for (int j = 0; j < deltaH.length; j++) {
/* 131 */       double s = 0.0D;
/* 132 */       for (int n = 0; n < deltaY.length; n++) {
/* 133 */         s += this.W[1][n][j] * deltaY[n];
/*     */       }
/* 135 */       deltaH[j] = this.dL[1][j] * s;
/*     */     } 
/*     */ 
/*     */     
/* 139 */     double[][][] deltaW = (double[][][])null;
/* 140 */     deltaW = new double[2][][];
/* 141 */     deltaW[0] = new double[(this.W[0]).length][(this.W[0][0]).length];
/* 142 */     deltaW[1] = new double[(this.W[1]).length][(this.W[1][0]).length];
/*     */     
/*     */     int m;
/* 145 */     for (m = 0; m < (deltaW[1]).length; m++) {
/*     */       
/* 147 */       int n = 0;
/* 148 */       for (; n < (this.L[1]).length; n++) {
/* 149 */         deltaW[1][m][n] = this.eta * deltaY[m] * this.L[1][n];
/*     */       }
/*     */       
/* 152 */       deltaW[1][m][n] = this.eta * deltaY[m];
/*     */     } 
/*     */ 
/*     */     
/* 156 */     for (m = 0; m < (deltaW[0]).length; m++) {
/*     */       
/* 158 */       int n = 0;
/* 159 */       for (; n < (this.L[0]).length; n++) {
/* 160 */         deltaW[0][m][n] = this.eta * deltaH[m] * this.L[0][n];
/*     */       }
/* 162 */       deltaW[0][m][n] = this.eta * deltaH[m];
/*     */     } 
/*     */ 
/*     */     
/* 166 */     for (int k = 0; k < this.W.length; k++) {
/* 167 */       for (int n = 0; n < (this.W[k]).length; n++) {
/* 168 */         for (int i1 = 0; i1 < (this.W[k][n]).length; i1++) {
/* 169 */           this.W[k][n][i1] = this.W[k][n][i1] + deltaW[k][n][i1];
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected double f(double x) {
/* 176 */     return this.f.f(x);
/*     */   }
/*     */   
/*     */   protected double dF(double x) {
/* 180 */     return this.f.dF(x);
/*     */   }
/*     */   
/*     */   public double getMeanSquaredError() {
/* 184 */     double s = 0.0D;
/* 185 */     for (int i = 0; i < this.E.length; i++) {
/* 186 */       s += Math.pow(this.E[i], 2.0D);
/*     */     }
/* 188 */     return s / this.E.length;
/*     */   }
/*     */   
/*     */   public double getEta() {
/* 192 */     return this.eta;
/*     */   }
/*     */   
/*     */   public void setEta(double eta) {
/* 196 */     this.eta = eta;
/*     */   }
/*     */   
/*     */   public double[] getOutput() {
/* 200 */     double[] y = new double[(this.L[2]).length];
/* 201 */     System.arraycopy(this.L[2], 0, y, 0, (this.L[2]).length);
/* 202 */     return y;
/*     */   }
/*     */   
/*     */   public void setInput(double[] x) {
/* 206 */     System.arraycopy(x, 0, this.L[0], 0, x.length);
/* 207 */     this.isLearning = false;
/*     */   }
/*     */   
/*     */   public void setSample(double[] x, double[] y) {
/* 211 */     setInput(x);
/* 212 */     System.arraycopy(y, 0, this.Y, 0, y.length);
/* 213 */     this.isLearning = true;
/*     */   }
/*     */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/ann/MLP.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */