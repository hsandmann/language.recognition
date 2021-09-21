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
/*     */ public class MLPProcess
/*     */   implements Runnable
/*     */ {
/*     */   public static final int NOT_TRAINED = 0;
/*     */   public static final int TRAINNNIG = 1;
/*     */   public static final int TRAINED = 2;
/*     */   public static final int STOPED_TRAINNNIG = 3;
/*  43 */   public volatile int status = 0;
/*     */   
/*  45 */   private volatile MLP mlp = null;
/*     */   
/*  47 */   private double meanSquareErrorMax = 0.0D;
/*  48 */   private int iterationNumberMax = 0;
/*  49 */   private volatile double eta = 0.7D;
/*  50 */   private double[][][] data = null;
/*     */   
/*  52 */   private volatile int iteration = 0;
/*  53 */   private volatile double mse = 0.0D;
/*     */   
/*  55 */   private ErrorController errorController = null;
/*     */   
/*     */   public MLPProcess(Function f, int nInput, int nHidden, int nOutput) {
/*  58 */     this.mlp = new MLP(f, nInput, nHidden, nOutput);
/*  59 */     this.status = 0;
/*     */   }
/*     */   
/*     */   public void setErrorController(ErrorController errorController) {
/*  63 */     this.errorController = errorController;
/*     */   }
/*     */   
/*     */   public double[] classifier(double[] x) throws Exception {
/*  67 */     if (this.status == 1) {
/*  68 */       throw new RuntimeException("Não é possível classificar durante o treinamento.");
/*     */     }
/*  70 */     this.mlp.setInput(x);
/*  71 */     this.mlp.fowardPropagation();
/*  72 */     return this.mlp.getOutput();
/*     */   }
/*     */   
/*     */   public void reset() {
/*  76 */     this.status = 0;
/*     */   }
/*     */   
/*     */   public void setIterationNumberMax(int value) {
/*  80 */     this.iterationNumberMax = value;
/*     */   }
/*     */   
/*     */   public void setMeanSquaredErrorMax(double value) {
/*  84 */     this.meanSquareErrorMax = value;
/*     */   }
/*     */   
/*     */   public int getIterationNumberMax() {
/*  88 */     return this.iterationNumberMax;
/*     */   }
/*     */   
/*     */   public double getMeanSquaredErrorMax() {
/*  92 */     return this.meanSquareErrorMax;
/*     */   }
/*     */   
/*     */   public void setData(double[][][] data) {
/*  96 */     this.data = data;
/*     */   }
/*     */   
/*     */   public int getIteration() {
/* 100 */     return this.iteration;
/*     */   }
/*     */   
/*     */   public double getMSE() {
/* 104 */     return this.mse;
/*     */   }
/*     */   
/*     */   public void setEta(double eta) {
/* 108 */     this.eta = eta;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 116 */     this.mlp.setEta(this.eta);
/*     */     
/* 118 */     for (this.status = 1; this.status == 1; this.iteration++) {
/*     */       
/* 120 */       int[] sort = new int[this.data.length];
/*     */       
/* 122 */       for (int i = 1; this.status == 1 && i <= this.data.length; ) {
/*     */         while (true) {
/* 124 */           int pos = (int)((this.data.length + 1) * Math.random() - 1.0D);
/* 125 */           if (sort[pos] == 0) {
/* 126 */             sort[pos] = i;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */         i++;
/*     */       } 
/* 132 */       double[] errorSample = new double[this.data.length];
/* 133 */       double sError = 0.0D;
/*     */       
/* 135 */       for (int j = 0; this.status == 1 && j < sort.length; j++) {
/*     */         
/* 137 */         int pos = sort[j] - 1;
/* 138 */         this.mlp.setSample(this.data[pos][0], this.data[pos][1]);
/* 139 */         this.mlp.fowardPropagation();
/* 140 */         this.mlp.backProgagation();
/* 141 */         double lmse = this.mlp.getMeanSquaredError();
/* 142 */         errorSample[pos] = lmse;
/* 143 */         sError += lmse;
/*     */       } 
/*     */ 
/*     */       
/* 147 */       double var = 0.0D;
/* 148 */       if (this.status == 1) {
/* 149 */         this.mse = sError / this.data.length;
/* 150 */         for (int k = 0; k < this.data.length; k++) {
/* 151 */           var += Math.abs(errorSample[k] - this.mse);
/*     */         }
/* 153 */         var /= this.data.length;
/*     */       } 
/*     */       
/* 156 */       if (this.errorController != null) {
/* 157 */         double fator = var / 2.0D;
/* 158 */         this.errorController.addValue(this.iteration, this.mse, this.mse + fator, this.mse + fator);
/*     */       } 
/*     */       
/* 161 */       if (this.mse <= this.meanSquareErrorMax || (
/* 162 */         this.iterationNumberMax > 0 && this.iteration >= this.iterationNumberMax)) {
/* 163 */         this.status = 2;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void stop() {
/* 170 */     this.status = 3;
/*     */   }
/*     */   
/*     */   public int getStatus() {
/* 174 */     return this.status;
/*     */   }
/*     */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/ann/MLPProcess.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */