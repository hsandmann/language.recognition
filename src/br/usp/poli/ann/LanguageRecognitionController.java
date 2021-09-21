/*     */ package br.usp.poli.ann;
/*     */ 
/*     */ import br.usp.poli.math.Function;
/*     */ import br.usp.poli.math.HyperbolicTangent;
/*     */ import br.usp.poli.math.Sigmoid;
/*     */ import java.rmi.RemoteException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ public class LanguageRecognitionController
/*     */ {
/*  45 */   private ClassGroup classGroup = null;
/*  46 */   private Collection functions = null;
/*  47 */   private Function selectedFunction = null;
/*  48 */   private MLPProcess mlpProcess = null;
/*     */   
/*  50 */   private double eta = 0.7D;
/*     */   
/*  52 */   private int neuronNumbers = 0;
/*     */   private boolean isInitialized = false;
/*     */   
/*     */   public LanguageRecognitionController() {
/*  56 */     this.classGroup = new ClassGroup(this);
/*  57 */     this.functions = new ArrayList();
/*  58 */     this.functions.add(new Sigmoid());
/*  59 */     this.functions.add(new HyperbolicTangent());
/*  60 */     this.isInitialized = false;
/*     */   }
/*     */   
/*     */   public void reset() {
/*  64 */     this.isInitialized = false;
/*     */   }
/*     */   
/*     */   public int getStatus() {
/*  68 */     return this.mlpProcess.getStatus();
/*     */   }
/*     */   
/*     */   public int getCurrentInteration() {
/*  72 */     if (this.mlpProcess == null) {
/*  73 */       return 0;
/*     */     }
/*  75 */     return this.mlpProcess.getIteration();
/*     */   }
/*     */   
/*     */   public double getCurrentMSE() {
/*  79 */     if (this.mlpProcess == null) {
/*  80 */       return 0.0D;
/*     */     }
/*  82 */     return this.mlpProcess.getMSE();
/*     */   }
/*     */   
/*     */   public void addClass(String className) {
/*  86 */     this.classGroup.add(new Classe(this, className));
/*  87 */     this.isInitialized = false;
/*     */   }
/*     */   
/*     */   public boolean containsClass(String className) {
/*  91 */     return this.classGroup.contains(className);
/*     */   }
/*     */   
/*     */   public void removeClass(String className) {
/*  95 */     this.classGroup.remove(className);
/*  96 */     this.isInitialized = false;
/*     */   }
/*     */   
/*     */   public String[] getClassNames() {
/* 100 */     return this.classGroup.getClassNames();
/*     */   }
/*     */   
/*     */   public int getTrainSampleNumber(String className) {
/* 104 */     return this.classGroup.get(className).sizeTrainSamples();
/*     */   }
/*     */   
/*     */   public int getValidateSampleNumber(String className) {
/* 108 */     return this.classGroup.get(className).sizeValidateSamples();
/*     */   }
/*     */   
/*     */   public String[] getFunctionNames() {
/* 112 */     String[] names = new String[this.functions.size()];
/* 113 */     Iterator it = this.functions.iterator();
/* 114 */     for (int i = 0; it.hasNext(); i++) {
/* 115 */       Function function = it.next();
/* 116 */       names[i] = function.getName();
/*     */     } 
/* 118 */     return names;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFunction(String functionName) throws Exception {
/* 123 */     this.selectedFunction = null;
/*     */     
/* 125 */     Iterator it = this.functions.iterator();
/* 126 */     while (this.selectedFunction == null && it.hasNext()) {
/* 127 */       Function function = it.next();
/* 128 */       if (function.getName().equals(functionName)) {
/* 129 */         this.selectedFunction = function;
/*     */       }
/*     */     } 
/*     */     
/* 133 */     if (this.selectedFunction == null) {
/* 134 */       throw new RemoteException("Função " + functionName + " não encontrada.");
/*     */     }
/* 136 */     this.isInitialized = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setNeuronNumbers(int number) {
/* 141 */     this.neuronNumbers = number;
/* 142 */     this.isInitialized = false;
/*     */   }
/*     */   
/*     */   public void setEta(double eta) {
/* 146 */     this.eta = eta;
/*     */   }
/*     */   
/*     */   public void setIterationNumberMax(int value) {
/* 150 */     this.mlpProcess.setIterationNumberMax(value);
/*     */   }
/*     */   
/*     */   public void setMeanSquaredErrorMax(double value) {
/* 154 */     this.mlpProcess.setMeanSquaredErrorMax(value);
/*     */   }
/*     */   
/*     */   public void addTrainSample(String className, String text) throws Exception {
/* 158 */     if (text == null || text.length() == 0) {
/* 159 */       throw new RuntimeException("Texto não definido.");
/*     */     }
/*     */     
/* 162 */     if (!this.classGroup.contains(className)) {
/* 163 */       throw new RuntimeException("Idioma " + className + " não definido.");
/*     */     }
/*     */     
/* 166 */     Classe c = this.classGroup.get(className);
/* 167 */     c.addTrainSample(text);
/* 168 */     if (this.isInitialized) {
/* 169 */       this.mlpProcess.reset();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addValidateSample(String className, String text) throws Exception {
/* 174 */     if (text == null || text.length() == 0) {
/* 175 */       throw new RuntimeException("Texto não definido.");
/*     */     }
/*     */     
/* 178 */     if (!this.classGroup.contains(className)) {
/* 179 */       throw new RuntimeException("Idioma " + className + " não definido.");
/*     */     }
/*     */     
/* 182 */     Classe c = this.classGroup.get(className);
/* 183 */     c.addValidateSample(text);
/* 184 */     if (this.isInitialized) {
/* 185 */       this.mlpProcess.reset();
/*     */     }
/*     */   }
/*     */   
/*     */   public void startTrain() {
/* 190 */     if (this.isInitialized && this.mlpProcess.getStatus() != 1) {
/* 191 */       double[][][] data = prepareData();
/* 192 */       this.mlpProcess.setEta(this.eta);
/* 193 */       this.mlpProcess.setData(data);
/* 194 */       (new Thread(this.mlpProcess)).start();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void stopTrain() {
/* 199 */     if (this.isInitialized) {
/* 200 */       this.mlpProcess.stop();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private double[][][] prepareData() {
/* 206 */     this.classGroup.initialize(this.selectedFunction);
/*     */     
/* 208 */     double[][][] data = new double[this.classGroup.totalTrainSamples()][][];
/*     */     
/* 210 */     double vMin = this.selectedFunction.domainMin();
/* 211 */     double vMax = this.selectedFunction.domainMax();
/* 212 */     double domain = Math.abs(vMax - vMin);
/*     */     
/* 214 */     int d = 0;
/* 215 */     String[] classNames = this.classGroup.getClassNames();
/* 216 */     for (int i = 0; i < classNames.length; i++) {
/* 217 */       Classe c = this.classGroup.get(classNames[i]);
/* 218 */       double[] y = c.getLabel();
/*     */       
/* 220 */       Collection samples = c.getTrainSamples();
/* 221 */       for (Iterator it = samples.iterator(); it.hasNext(); d++) {
/* 222 */         String text = it.next();
/* 223 */         double[] x = LanguageRecognitionUtil.countCharFrequency(text);
/* 224 */         for (int j = 0; j < x.length; j++) {
/* 225 */           x[j] = x[j] * domain + vMin;
/*     */         }
/* 227 */         double[][] sample = { x, y };
/* 228 */         data[d] = sample;
/*     */       } 
/*     */     } 
/*     */     
/* 232 */     return data;
/*     */   }
/*     */ 
/*     */   
/*     */   public CrossValidation validate() throws Exception {
/* 237 */     if (!this.isInitialized) {
/* 238 */       throw new RuntimeException("Rede não inicializada.");
/*     */     }
/*     */     
/* 241 */     String[] classNames = this.classGroup.getClassNames();
/* 242 */     CrossValidation validation = new CrossValidation(this, classNames);
/* 243 */     for (int i = 0; i < classNames.length; i++) {
/* 244 */       Classe c = this.classGroup.get(classNames[i]);
/* 245 */       Collection samples = c.getValidateSamples();
/* 246 */       Iterator it = samples.iterator();
/* 247 */       while (it.hasNext()) {
/* 248 */         String sample = it.next();
/* 249 */         String className = classifier(sample);
/* 250 */         validation.count(classNames[i], className);
/*     */       } 
/*     */     } 
/*     */     
/* 254 */     return validation;
/*     */   }
/*     */   
/*     */   public String classifier(String text) throws Exception {
/* 258 */     if (text == null || text.length() == 0) {
/* 259 */       throw new RuntimeException("Texto de teste não definido.");
/*     */     }
/* 261 */     if (!this.isInitialized) {
/* 262 */       throw new RuntimeException("Rede não inicializada.");
/*     */     }
/* 264 */     double[] x = LanguageRecognitionUtil.countCharFrequency(text);
/* 265 */     double[] y = this.mlpProcess.classifier(x);
/* 266 */     Classe c = this.classGroup.get(signal(y));
/* 267 */     if (c == null) {
/* 268 */       return null;
/*     */     }
/* 270 */     return c.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public void initialize() throws Exception {
/* 275 */     if (this.classGroup.size() == 0) {
/* 276 */       throw new RuntimeException("Idiomas não definidos.");
/*     */     }
/*     */     
/* 279 */     if (this.neuronNumbers <= 0) {
/* 280 */       throw new RuntimeException("Número de neurônios ocultos não definido.");
/*     */     }
/*     */     
/* 283 */     if (this.selectedFunction == null) {
/* 284 */       throw new RuntimeException("Função de ativação não definida.");
/*     */     }
/*     */     
/* 287 */     this.mlpProcess = new MLPProcess(this.selectedFunction, 26, this.neuronNumbers, this.classGroup.size());
/* 288 */     this.isInitialized = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] getTrainHistogram(String className) {
/* 293 */     Classe c = this.classGroup.get(className);
/* 294 */     Iterator it = c.getTrainSamples().iterator();
/* 295 */     double[] h = new double[26];
/* 296 */     while (it.hasNext()) {
/* 297 */       double[] s = LanguageRecognitionUtil.countCharFrequency(it.next());
/* 298 */       for (int j = 0; j < s.length; j++) {
/* 299 */         h[j] = h[j] + s[j];
/*     */       }
/*     */     } 
/* 302 */     for (int i = 0; i < h.length; i++) {
/* 303 */       h[i] = h[i] / c.getTrainSamples().size();
/*     */     }
/* 305 */     return h;
/*     */   }
/*     */   
/*     */   public double[] getValidateHistogram(String className) {
/* 309 */     Classe c = this.classGroup.get(className);
/* 310 */     Iterator it = c.getValidateSamples().iterator();
/* 311 */     double[] h = new double[26];
/* 312 */     while (it.hasNext()) {
/* 313 */       double[] s = LanguageRecognitionUtil.countCharFrequency(it.next());
/* 314 */       for (int j = 0; j < s.length; j++) {
/* 315 */         h[j] = h[j] + s[j];
/*     */       }
/*     */     } 
/* 318 */     for (int i = 0; i < h.length; i++) {
/* 319 */       h[i] = h[i] / c.getTrainSamples().size();
/*     */     }
/* 321 */     return h;
/*     */   }
/*     */   
/*     */   public void setErrorController(ErrorController errorController) {
/* 325 */     if (this.isInitialized) {
/* 326 */       this.mlpProcess.setErrorController(errorController);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isInitialized() {
/* 331 */     return this.isInitialized;
/*     */   }
/*     */   
/*     */   private class Classe { private String name;
/*     */     private double[] label;
/*     */     private Collection trainSamples;
/*     */     private Collection validateSamples;
/*     */     final LanguageRecognitionController this$0;
/*     */     
/*     */     public Classe(LanguageRecognitionController this$0, String name) {
/* 341 */       this.this$0 = this$0; this.name = null; this.label = null; this.trainSamples = null; this.validateSamples = null;
/* 342 */       this.name = name;
/* 343 */       this.trainSamples = new ArrayList();
/* 344 */       this.validateSamples = new ArrayList();
/*     */     }
/*     */     
/*     */     public String getName() {
/* 348 */       return this.name;
/*     */     }
/*     */     
/*     */     public void setLabel(double[] label) {
/* 352 */       this.label = label;
/*     */     }
/*     */     
/*     */     public double[] getLabel() {
/* 356 */       return this.label;
/*     */     }
/*     */     
/*     */     public void addTrainSample(String sample) {
/* 360 */       this.trainSamples.add(sample);
/*     */     }
/*     */     
/*     */     public void addValidateSample(String sample) {
/* 364 */       this.validateSamples.add(sample);
/*     */     }
/*     */     
/*     */     public int sizeTrainSamples() {
/* 368 */       return this.trainSamples.size();
/*     */     }
/*     */     
/*     */     public int sizeValidateSamples() {
/* 372 */       return this.validateSamples.size();
/*     */     }
/*     */     
/*     */     public Collection getTrainSamples() {
/* 376 */       return this.trainSamples;
/*     */     }
/*     */     
/*     */     public Collection getValidateSamples() {
/* 380 */       return this.validateSamples;
/*     */     }
/*     */     
/*     */     public boolean equals(Object obj) {
/* 384 */       return ((Classe)obj).getName().equals(getName());
/*     */     }
/*     */     
/*     */     public boolean compare(double[] l) {
/* 388 */       boolean equal = (this.label != null && l != null && this.label.length == l.length);
/* 389 */       for (int i = 0; equal && i < this.label.length; i++) {
/* 390 */         equal = (this.label[i] == l[i]);
/*     */       }
/* 392 */       return equal;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 396 */       String s = "Classe " + this.name + " com " + sizeTrainSamples() + " amostras de treinamento.";
/* 397 */       return s;
/*     */     } }
/*     */ 
/*     */   
/*     */   private class ClassGroup {
/*     */     private Collection classes;
/*     */     private boolean isInitialized;
/*     */     final LanguageRecognitionController this$0;
/*     */     
/*     */     public ClassGroup(LanguageRecognitionController this$0) {
/* 407 */       this.this$0 = this$0; this.classes = null; this.isInitialized = false;
/* 408 */       this.classes = new ArrayList();
/*     */     }
/*     */     
/*     */     public void initialize(Function function) {
/* 412 */       Iterator it = this.classes.iterator();
/* 413 */       double min = function.domainMin();
/* 414 */       double max = function.domainMax();
/* 415 */       int d = this.classes.size();
/* 416 */       for (int i = 0; it.hasNext(); i++) {
/* 417 */         LanguageRecognitionController.Classe c = it.next();
/* 418 */         double[] label = new double[d];
/* 419 */         for (int j = 0; j < d; j++) {
/* 420 */           label[j] = (i == j) ? max : min;
/*     */         }
/* 422 */         c.setLabel(label);
/*     */       } 
/* 424 */       this.isInitialized = true;
/*     */     }
/*     */     
/*     */     public boolean isInitialized() {
/* 428 */       return this.isInitialized;
/*     */     }
/*     */     
/*     */     public void add(LanguageRecognitionController.Classe clazz) {
/* 432 */       this.classes.add(clazz);
/* 433 */       this.isInitialized = false;
/*     */     }
/*     */     
/*     */     public LanguageRecognitionController.Classe get(String className) {
/* 437 */       LanguageRecognitionController.Classe y = null;
/* 438 */       for (Iterator it = this.classes.iterator(); y == null && it.hasNext(); ) {
/* 439 */         LanguageRecognitionController.Classe c = it.next();
/* 440 */         if (c.getName().equals(className)) {
/* 441 */           y = c;
/*     */         }
/*     */       } 
/* 444 */       return y;
/*     */     }
/*     */     
/*     */     public LanguageRecognitionController.Classe get(double[] label) throws Exception {
/* 448 */       if (!this.isInitialized) {
/* 449 */         throw new RemoteException("Grupo de classes não inicializado.");
/*     */       }
/* 451 */       LanguageRecognitionController.Classe y = null;
/* 452 */       for (Iterator it = this.classes.iterator(); y == null && it.hasNext(); ) {
/* 453 */         LanguageRecognitionController.Classe c = it.next();
/* 454 */         if (c.compare(label)) {
/* 455 */           y = c;
/*     */         }
/*     */       } 
/* 458 */       return y;
/*     */     }
/*     */     
/*     */     public void remove(String className) {
/* 462 */       this.classes.remove(new LanguageRecognitionController.Classe(this.this$0, className));
/* 463 */       this.isInitialized = false;
/*     */     }
/*     */     
/*     */     public boolean contains(String className) {
/* 467 */       Iterator it = this.classes.iterator();
/* 468 */       boolean contain = false;
/* 469 */       while (!contain && it.hasNext()) {
/* 470 */         contain = ((LanguageRecognitionController.Classe)it.next()).getName().equals(className);
/*     */       }
/* 472 */       return contain;
/*     */     }
/*     */     
/*     */     public int size() {
/* 476 */       return this.classes.size();
/*     */     }
/*     */     
/*     */     public String[] getClassNames() {
/* 480 */       String[] names = new String[this.classes.size()];
/* 481 */       Iterator it = this.classes.iterator();
/* 482 */       for (int i = 0; it.hasNext(); i++) {
/* 483 */         names[i] = ((LanguageRecognitionController.Classe)it.next()).getName();
/*     */       }
/* 485 */       return names;
/*     */     }
/*     */     
/*     */     public int totalTrainSamples() {
/* 489 */       int total = 0;
/* 490 */       Iterator it = this.classes.iterator();
/* 491 */       for (int i = 0; it.hasNext(); i++) {
/* 492 */         total += ((LanguageRecognitionController.Classe)it.next()).sizeTrainSamples();
/*     */       }
/* 494 */       return total;
/*     */     }
/*     */   }
/*     */   
/*     */   public class CrossValidation {
/*     */     private String[] classNames;
/*     */     private double[][] map;
/*     */     final LanguageRecognitionController this$0;
/*     */     
/*     */     public CrossValidation(LanguageRecognitionController this$0, String[] classNames) {
/* 504 */       this.this$0 = this$0; this.classNames = null; this.map = null;
/* 505 */       int size = classNames.length;
/* 506 */       this.classNames = classNames;
/* 507 */       this.map = new double[size][size + 1];
/*     */     }
/*     */     
/*     */     public String[] getClassNames() {
/* 511 */       return this.classNames;
/*     */     }
/*     */     
/*     */     public void count(String classTarget, String className) {
/* 515 */       int c = (className == null) ? (this.classNames.length - 1) : index(className);
/* 516 */       int t = index(classTarget);
/* 517 */       this.map[t][c] = this.map[t][c] + 1.0D;
/*     */     }
/*     */     
/*     */     public int index(String classTarget) {
/* 521 */       for (int i = 0; i < this.classNames.length; i++) {
/* 522 */         if (this.classNames[i].equals(classTarget)) {
/* 523 */           return i;
/*     */         }
/*     */       } 
/* 526 */       return -1;
/*     */     }
/*     */     
/*     */     public double getResult(String classTarget, String classReference) {
/* 530 */       int t = index(classTarget);
/* 531 */       int r = (classReference == null) ? ((this.map[t]).length - 1) : index(classReference);
/* 532 */       double s = 0.0D;
/*     */       
/* 534 */       for (int i = 0; i < this.classNames.length; i++) {
/* 535 */         s += this.map[t][i];
/*     */       }
/* 537 */       return this.map[t][r] / s;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private double[] signal(double[] x) {
/* 543 */     double[] y = new double[x.length];
/* 544 */     double min = this.selectedFunction.domainMin();
/* 545 */     double max = this.selectedFunction.domainMax();
/* 546 */     double mean = min + (Math.abs(min) + Math.abs(max)) / 2.0D;
/* 547 */     for (int i = 0; i < y.length; i++) {
/* 548 */       y[i] = (x[i] > mean) ? max : min;
/*     */     }
/* 550 */     return y;
/*     */   }
/*     */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/ann/LanguageRecognitionController.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */