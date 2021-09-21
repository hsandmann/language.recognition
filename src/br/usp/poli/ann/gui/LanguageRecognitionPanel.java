/*     */ package br.usp.poli.ann.gui;
/*     */ 
/*     */ import br.usp.poli.ann.ErrorController;
/*     */ import br.usp.poli.ann.LanguageRecognitionController;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.text.DecimalFormat;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.table.DefaultTableModel;
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
/*     */ public class LanguageRecognitionPanel
/*     */   extends JPanel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  45 */   private DecimalFormat formatter = new DecimalFormat("#0.0000");
/*     */   
/*  47 */   private LanguageRecognitionController controller = null;
/*     */   
/*     */   private boolean debugMode = false;
/*  50 */   private ErrorController errorController = null;
/*  51 */   private ErrorFrame errorFrame = null;
/*  52 */   private CrossValidationFrame validateFrame = null; private JButton btnClassesDetalhe; private JButton btnClassificar; private JButton btnEstadoDetalhe; private JButton btnIncluirTreino; private JButton btnIncluirValida; private JButton btnIncluirClasse; private JButton btnInicializar; private JButton btnLimpar; private JButton btnRemoverClasse; private JButton btnTreinar;
/*  53 */   private WordFrame classFrame = null; private JButton btnValidar; private JCheckBox chkMSEMaximo; private JCheckBox chkNumMaxInteracao; private JScrollPane jScrollPane1; private JScrollPane jScrollPane2; private JLabel lblAtualEMQ; private JLabel lblAtualInteracao; private JLabel lblEstado;
/*     */   private JLabel lblEta;
/*     */   
/*     */   public LanguageRecognitionPanel(LanguageRecognitionController controller) throws Exception {
/*  57 */     this.controller = controller;
/*  58 */     defaultValues();
/*     */     try {
/*  60 */       initComponents();
/*  61 */     } catch (Exception e) {
/*  62 */       showException(e);
/*     */     } 
/*  64 */     init();
/*     */   }
/*     */   private JLabel lblFuncaoAtivacao; private JLabel lblNumOcultos; private JPanel pnlArquitetura; private JPanel pnlClasse; private JPanel pnlEstado; private JPanel pnlParada; private JPanel pnlResultado; private JPanel pnlTreinamento; private JTable tblClasses; private JTextArea txtArea; private JTextField txtAtualEMQ; private JTextField txtAtualInteracao; private JLabel txtEstado; private JTextField txtEta;
/*     */   private JComboBox txtFuncaoAtivacao;
/*     */   private JTextField txtMSEMaximo;
/*     */   private JTextField txtNumMaxInteracao;
/*     */   private JTextField txtNumOcultos;
/*     */   private JLabel txtResultadoClassificacao;
/*     */   
/*     */   private void initComponents() {
/*  74 */     this.jScrollPane1 = new JScrollPane();
/*  75 */     this.txtArea = new JTextArea();
/*  76 */     this.pnlTreinamento = new JPanel();
/*  77 */     this.pnlClasse = new JPanel();
/*  78 */     this.btnIncluirClasse = new JButton();
/*  79 */     this.btnRemoverClasse = new JButton();
/*  80 */     this.jScrollPane2 = new JScrollPane();
/*  81 */     this.tblClasses = new JTable();
/*  82 */     this.btnIncluirTreino = new JButton();
/*  83 */     this.btnIncluirValida = new JButton();
/*  84 */     this.btnClassesDetalhe = new JButton();
/*  85 */     this.pnlParada = new JPanel();
/*  86 */     this.chkNumMaxInteracao = new JCheckBox();
/*  87 */     this.txtNumMaxInteracao = new JTextField();
/*  88 */     this.chkMSEMaximo = new JCheckBox();
/*  89 */     this.txtMSEMaximo = new JTextField();
/*  90 */     this.pnlArquitetura = new JPanel();
/*  91 */     this.lblFuncaoAtivacao = new JLabel();
/*  92 */     this.txtFuncaoAtivacao = new JComboBox();
/*  93 */     this.lblNumOcultos = new JLabel();
/*  94 */     this.txtNumOcultos = new JTextField();
/*  95 */     this.lblEta = new JLabel();
/*  96 */     this.txtEta = new JTextField();
/*  97 */     this.pnlEstado = new JPanel();
/*  98 */     this.lblAtualEMQ = new JLabel();
/*  99 */     this.txtAtualEMQ = new JTextField();
/* 100 */     this.lblAtualInteracao = new JLabel();
/* 101 */     this.txtAtualInteracao = new JTextField();
/* 102 */     this.lblEstado = new JLabel();
/* 103 */     this.txtEstado = new JLabel();
/* 104 */     this.btnEstadoDetalhe = new JButton();
/* 105 */     this.btnInicializar = new JButton();
/* 106 */     this.btnTreinar = new JButton();
/* 107 */     this.btnValidar = new JButton();
/* 108 */     this.btnClassificar = new JButton();
/* 109 */     this.btnLimpar = new JButton();
/* 110 */     this.pnlResultado = new JPanel();
/* 111 */     this.txtResultadoClassificacao = new JLabel();
/*     */     
/* 113 */     setBackground(new Color(255, 255, 255));
/* 114 */     this.jScrollPane1.setBackground(new Color(255, 255, 255));
/* 115 */     this.jScrollPane1.setBorder(BorderFactory.createTitledBorder("Texto"));
/* 116 */     this.txtArea.setColumns(20);
/* 117 */     this.txtArea.setLineWrap(true);
/* 118 */     this.txtArea.setRows(5);
/* 119 */     this.jScrollPane1.setViewportView(this.txtArea);
/*     */     
/* 121 */     this.pnlTreinamento.setBackground(new Color(255, 255, 255));
/* 122 */     this.pnlTreinamento.setBorder(BorderFactory.createTitledBorder("Treinamento"));
/* 123 */     this.pnlClasse.setBackground(new Color(255, 255, 255));
/* 124 */     this.pnlClasse.setBorder(BorderFactory.createTitledBorder("Classes"));
/* 125 */     this.btnIncluirClasse.setText("+");
/* 126 */     this.btnIncluirClasse.addActionListener(new ActionListener(this) { final LanguageRecognitionPanel this$0;
/*     */           public void actionPerformed(ActionEvent evt) {
/* 128 */             this.this$0.btnIncluirClasseActionPerformed(evt);
/*     */           } }
/*     */       );
/*     */     
/* 132 */     this.btnRemoverClasse.setText("-");
/* 133 */     this.btnRemoverClasse.addActionListener(new ActionListener(this) { final LanguageRecognitionPanel this$0;
/*     */           public void actionPerformed(ActionEvent evt) {
/* 135 */             this.this$0.btnRemoverClasseActionPerformed(evt);
/*     */           } }
/*     */       );
/*     */     
/* 139 */     this.tblClasses.setModel(new DefaultTableModel(this, 
/* 140 */           new Object[][] {
/*     */             
/*     */             {}
/* 143 */           }, (Object[])new String[0]) { final LanguageRecognitionPanel this$0;
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 146 */             return false;
/*     */           } }
/*     */       );
/* 149 */     this.jScrollPane2.setViewportView(this.tblClasses);
/*     */     
/* 151 */     this.btnIncluirTreino.setText("Incluir treino");
/* 152 */     this.btnIncluirTreino.addActionListener(new ActionListener(this) { final LanguageRecognitionPanel this$0;
/*     */           public void actionPerformed(ActionEvent evt) {
/* 154 */             this.this$0.btnIncluirTreinoActionPerformed(evt);
/*     */           } }
/*     */       );
/*     */     
/* 158 */     this.btnIncluirValida.setText("Incluir validação");
/* 159 */     this.btnIncluirValida.addActionListener(new ActionListener(this) { final LanguageRecognitionPanel this$0;
/*     */           public void actionPerformed(ActionEvent evt) {
/* 161 */             this.this$0.btnIncluirValidaActionPerformed(evt);
/*     */           } }
/*     */       );
/*     */     
/* 165 */     this.btnClassesDetalhe.setText("...");
/* 166 */     this.btnClassesDetalhe.addActionListener(new ActionListener(this) { final LanguageRecognitionPanel this$0;
/*     */           public void actionPerformed(ActionEvent evt) {
/* 168 */             this.this$0.btnClassesDetalheActionPerformed(evt);
/*     */           } }
/*     */       );
/*     */     
/* 172 */     GroupLayout pnlClasseLayout = new GroupLayout(this.pnlClasse);
/* 173 */     this.pnlClasse.setLayout(pnlClasseLayout);
/* 174 */     pnlClasseLayout.setHorizontalGroup(
/* 175 */         pnlClasseLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 176 */         .addGroup(GroupLayout.Alignment.TRAILING, 
/* 177 */           pnlClasseLayout.createSequentialGroup().addComponent(this.jScrollPane2, -1, 207, 32767)
/* 178 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 179 */           .addGroup(pnlClasseLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 180 */             .addComponent(this.btnRemoverClasse, GroupLayout.Alignment.TRAILING, 0, 0, 32767)
/* 181 */             .addComponent(this.btnIncluirClasse, GroupLayout.Alignment.TRAILING, -1, -1, 32767)))
/* 182 */         .addGroup(pnlClasseLayout.createSequentialGroup()
/* 183 */           .addComponent(this.btnIncluirTreino)
/* 184 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 185 */           .addComponent(this.btnIncluirValida)
/* 186 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 106, 32767)
/* 187 */           .addComponent(this.btnClassesDetalhe)));
/*     */     
/* 189 */     pnlClasseLayout.setVerticalGroup(
/* 190 */         pnlClasseLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 191 */         .addGroup(pnlClasseLayout.createSequentialGroup()
/* 192 */           .addGroup(pnlClasseLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 193 */             .addGroup(pnlClasseLayout.createSequentialGroup()
/* 194 */               .addComponent(this.btnIncluirClasse)
/* 195 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 196 */               .addComponent(this.btnRemoverClasse))
/* 197 */             .addComponent(this.jScrollPane2, -2, 101, -2))
/* 198 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 199 */           .addGroup(pnlClasseLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 200 */             .addComponent(this.btnClassesDetalhe)
/* 201 */             .addGroup(pnlClasseLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 202 */               .addComponent(this.btnIncluirTreino)
/* 203 */               .addComponent(this.btnIncluirValida)))
/* 204 */           .addContainerGap()));
/*     */ 
/*     */     
/* 207 */     this.pnlParada.setBackground(new Color(255, 255, 255));
/* 208 */     this.pnlParada.setBorder(BorderFactory.createTitledBorder("Critérios de parada"));
/* 209 */     this.chkNumMaxInteracao.setBackground(new Color(255, 255, 255));
/* 210 */     this.chkNumMaxInteracao.setText("Número de interações");
/* 211 */     this.chkNumMaxInteracao.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 212 */     this.chkNumMaxInteracao.setMargin(new Insets(0, 0, 0, 0));
/*     */     
/* 214 */     this.txtNumMaxInteracao.setText("1000");
/*     */     
/* 216 */     this.chkMSEMaximo.setBackground(new Color(255, 255, 255));
/* 217 */     this.chkMSEMaximo.setText("Erro médio quadrado");
/* 218 */     this.chkMSEMaximo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 219 */     this.chkMSEMaximo.setMargin(new Insets(0, 0, 0, 0));
/*     */     
/* 221 */     this.txtMSEMaximo.setText("0.05");
/*     */     
/* 223 */     GroupLayout pnlParadaLayout = new GroupLayout(this.pnlParada);
/* 224 */     this.pnlParada.setLayout(pnlParadaLayout);
/* 225 */     pnlParadaLayout.setHorizontalGroup(
/* 226 */         pnlParadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 227 */         .addGroup(pnlParadaLayout.createSequentialGroup()
/* 228 */           .addGroup(pnlParadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 229 */             .addGroup(pnlParadaLayout.createSequentialGroup()
/* 230 */               .addComponent(this.chkMSEMaximo)
/* 231 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 232 */               .addComponent(this.txtMSEMaximo, -2, 47, -2))
/* 233 */             .addGroup(pnlParadaLayout.createSequentialGroup()
/* 234 */               .addComponent(this.chkNumMaxInteracao)
/* 235 */               .addGap(6, 6, 6)
/* 236 */               .addComponent(this.txtNumMaxInteracao, -2, 49, -2)))
/* 237 */           .addContainerGap(76, 32767)));
/*     */     
/* 239 */     pnlParadaLayout.setVerticalGroup(
/* 240 */         pnlParadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 241 */         .addGroup(pnlParadaLayout.createSequentialGroup()
/* 242 */           .addGroup(pnlParadaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 243 */             .addComponent(this.chkMSEMaximo)
/* 244 */             .addComponent(this.txtMSEMaximo, -2, -1, -2))
/* 245 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 246 */           .addGroup(pnlParadaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 247 */             .addComponent(this.chkNumMaxInteracao)
/* 248 */             .addComponent(this.txtNumMaxInteracao, -2, -1, -2))));
/*     */ 
/*     */     
/* 251 */     this.pnlArquitetura.setBackground(new Color(255, 255, 255));
/* 252 */     this.pnlArquitetura.setBorder(BorderFactory.createTitledBorder("Arquitetura"));
/* 253 */     this.lblFuncaoAtivacao.setLabelFor(this.txtFuncaoAtivacao);
/* 254 */     this.lblFuncaoAtivacao.setText("Função de ativação");
/*     */     
/* 256 */     this.txtFuncaoAtivacao.setModel(new DefaultComboBoxModel(new String[] { "Tangente Hiperbólica", "Sigmóide" }));
/* 257 */     this.txtFuncaoAtivacao.addActionListener(new ActionListener(this) { final LanguageRecognitionPanel this$0;
/*     */           public void actionPerformed(ActionEvent evt) {
/* 259 */             this.this$0.txtFuncaoAtivacaoActionPerformed(evt);
/*     */           } }
/*     */       );
/*     */     
/* 263 */     this.lblNumOcultos.setLabelFor(this.txtNumOcultos);
/* 264 */     this.lblNumOcultos.setText("Número de neurônios ocultos");
/*     */     
/* 266 */     this.txtNumOcultos.setText("12");
/* 267 */     this.txtNumOcultos.addActionListener(new ActionListener(this) { final LanguageRecognitionPanel this$0;
/*     */           public void actionPerformed(ActionEvent evt) {
/* 269 */             this.this$0.txtNumOcultosActionPerformed(evt);
/*     */           } }
/*     */       );
/*     */     
/* 273 */     this.lblEta.setLabelFor(this.txtEta);
/* 274 */     this.lblEta.setText("Taxa de aprendizado (eta)");
/*     */     
/* 276 */     this.txtEta.setText("0.7");
/* 277 */     this.txtEta.addActionListener(new ActionListener(this) { final LanguageRecognitionPanel this$0;
/*     */           public void actionPerformed(ActionEvent evt) {
/* 279 */             this.this$0.txtEtaActionPerformed(evt);
/*     */           } }
/*     */       );
/*     */     
/* 283 */     GroupLayout pnlArquiteturaLayout = new GroupLayout(this.pnlArquitetura);
/* 284 */     this.pnlArquitetura.setLayout(pnlArquiteturaLayout);
/* 285 */     pnlArquiteturaLayout.setHorizontalGroup(
/* 286 */         pnlArquiteturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 287 */         .addGroup(pnlArquiteturaLayout.createSequentialGroup()
/* 288 */           .addComponent(this.lblFuncaoAtivacao)
/* 289 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 290 */           .addComponent(this.txtFuncaoAtivacao, 0, 156, 32767))
/* 291 */         .addGroup(pnlArquiteturaLayout.createSequentialGroup()
/* 292 */           .addGroup(pnlArquiteturaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 293 */             .addGroup(GroupLayout.Alignment.LEADING, 
/* 294 */               pnlArquiteturaLayout.createSequentialGroup().addComponent(this.lblEta)
/* 295 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 296 */               .addComponent(this.txtEta))
/* 297 */             .addGroup(GroupLayout.Alignment.LEADING, 
/* 298 */               pnlArquiteturaLayout.createSequentialGroup().addComponent(this.lblNumOcultos)
/* 299 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 300 */               .addComponent(this.txtNumOcultos, -2, 36, -2)))
/* 301 */           .addContainerGap(75, 32767)));
/*     */     
/* 303 */     pnlArquiteturaLayout.setVerticalGroup(
/* 304 */         pnlArquiteturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 305 */         .addGroup(pnlArquiteturaLayout.createSequentialGroup()
/* 306 */           .addGroup(pnlArquiteturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 307 */             .addComponent(this.lblFuncaoAtivacao)
/* 308 */             .addComponent(this.txtFuncaoAtivacao, -2, -1, -2))
/* 309 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 310 */           .addGroup(pnlArquiteturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 311 */             .addComponent(this.lblNumOcultos)
/* 312 */             .addComponent(this.txtNumOcultos, -2, -1, -2))
/* 313 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 314 */           .addGroup(pnlArquiteturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 315 */             .addComponent(this.lblEta)
/* 316 */             .addComponent(this.txtEta, -2, -1, -2))));
/*     */ 
/*     */     
/* 319 */     this.pnlEstado.setBackground(new Color(255, 255, 255));
/* 320 */     this.pnlEstado.setBorder(BorderFactory.createTitledBorder("Estado atual"));
/* 321 */     this.lblAtualEMQ.setLabelFor(this.txtAtualEMQ);
/* 322 */     this.lblAtualEMQ.setText("Erro médio quadrado");
/*     */     
/* 324 */     this.txtAtualEMQ.setEditable(false);
/* 325 */     this.txtAtualEMQ.setText("0.0");
/*     */     
/* 327 */     this.lblAtualInteracao.setLabelFor(this.txtAtualInteracao);
/* 328 */     this.lblAtualInteracao.setText("Número de interações");
/*     */     
/* 330 */     this.txtAtualInteracao.setEditable(false);
/* 331 */     this.txtAtualInteracao.setText("0");
/*     */     
/* 333 */     this.lblEstado.setLabelFor(this.txtEstado);
/* 334 */     this.lblEstado.setText("Estado da rede: ");
/*     */     
/* 336 */     this.txtEstado.setFont(new Font("Tahoma", 1, 11));
/* 337 */     this.txtEstado.setText("treinamento interrompido");
/*     */     
/* 339 */     this.btnEstadoDetalhe.setText("...");
/* 340 */     this.btnEstadoDetalhe.addActionListener(new ActionListener(this) { final LanguageRecognitionPanel this$0;
/*     */           public void actionPerformed(ActionEvent evt) {
/* 342 */             this.this$0.btnEstadoDetalheActionPerformed(evt);
/*     */           } }
/*     */       );
/*     */     
/* 346 */     GroupLayout pnlEstadoLayout = new GroupLayout(this.pnlEstado);
/* 347 */     this.pnlEstado.setLayout(pnlEstadoLayout);
/* 348 */     pnlEstadoLayout.setHorizontalGroup(
/* 349 */         pnlEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 350 */         .addGroup(pnlEstadoLayout.createSequentialGroup()
/* 351 */           .addGroup(pnlEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 352 */             .addGroup(pnlEstadoLayout.createSequentialGroup()
/* 353 */               .addComponent(this.lblAtualEMQ)
/* 354 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 355 */               .addComponent(this.txtAtualEMQ, -2, 49, -2))
/* 356 */             .addGroup(pnlEstadoLayout.createSequentialGroup()
/* 357 */               .addComponent(this.lblAtualInteracao)
/* 358 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 359 */               .addComponent(this.txtAtualInteracao, -2, 52, -2))
/* 360 */             .addGroup(pnlEstadoLayout.createSequentialGroup()
/* 361 */               .addComponent(this.lblEstado)
/* 362 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 363 */               .addComponent(this.txtEstado, -1, 158, 32767)))
/* 364 */           .addContainerGap())
/* 365 */         .addGroup(GroupLayout.Alignment.TRAILING, 
/* 366 */           pnlEstadoLayout.createSequentialGroup().addContainerGap(209, 32767)
/* 367 */           .addComponent(this.btnEstadoDetalhe)));
/*     */     
/* 369 */     pnlEstadoLayout.setVerticalGroup(
/* 370 */         pnlEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 371 */         .addGroup(pnlEstadoLayout.createSequentialGroup()
/* 372 */           .addGroup(pnlEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 373 */             .addComponent(this.lblAtualEMQ)
/* 374 */             .addComponent(this.txtAtualEMQ, -2, -1, -2))
/* 375 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 376 */           .addGroup(pnlEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 377 */             .addComponent(this.lblAtualInteracao)
/* 378 */             .addComponent(this.txtAtualInteracao, -2, -1, -2))
/* 379 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 380 */           .addGroup(pnlEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 381 */             .addComponent(this.lblEstado)
/* 382 */             .addComponent(this.txtEstado))
/* 383 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 384 */           .addComponent(this.btnEstadoDetalhe)));
/*     */ 
/*     */     
/* 387 */     this.btnInicializar.setText("Inicializar");
/* 388 */     this.btnInicializar.addActionListener(new ActionListener(this) { final LanguageRecognitionPanel this$0;
/*     */           public void actionPerformed(ActionEvent evt) {
/* 390 */             this.this$0.btnInicializarActionPerformed(evt);
/*     */           } }
/*     */       );
/*     */     
/* 394 */     this.btnTreinar.setText("Treinar");
/* 395 */     this.btnTreinar.addActionListener(new ActionListener(this) { final LanguageRecognitionPanel this$0;
/*     */           public void actionPerformed(ActionEvent evt) {
/* 397 */             this.this$0.btnTreinarActionPerformed(evt);
/*     */           } }
/*     */       );
/*     */     
/* 401 */     this.btnValidar.setText("Validar");
/* 402 */     this.btnValidar.addActionListener(new ActionListener(this) { final LanguageRecognitionPanel this$0;
/*     */           public void actionPerformed(ActionEvent evt) {
/* 404 */             this.this$0.btnValidarActionPerformed(evt);
/*     */           } }
/*     */       );
/*     */     
/* 408 */     GroupLayout pnlTreinamentoLayout = new GroupLayout(this.pnlTreinamento);
/* 409 */     this.pnlTreinamento.setLayout(pnlTreinamentoLayout);
/* 410 */     pnlTreinamentoLayout.setHorizontalGroup(
/* 411 */         pnlTreinamentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 412 */         .addGroup(pnlTreinamentoLayout.createSequentialGroup()
/* 413 */           .addComponent(this.btnInicializar)
/* 414 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 415 */           .addComponent(this.btnTreinar, -1, 88, 32767)
/* 416 */           .addGap(34, 34, 34)
/* 417 */           .addComponent(this.btnValidar))
/* 418 */         .addComponent(this.pnlClasse, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 419 */         .addComponent(this.pnlArquitetura, -1, -1, 32767)
/* 420 */         .addComponent(this.pnlEstado, -1, -1, 32767)
/* 421 */         .addComponent(this.pnlParada, -1, -1, 32767));
/*     */     
/* 423 */     pnlTreinamentoLayout.setVerticalGroup(
/* 424 */         pnlTreinamentoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 425 */         .addGroup(pnlTreinamentoLayout.createSequentialGroup()
/* 426 */           .addComponent(this.pnlClasse, -2, 160, -2)
/* 427 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 428 */           .addComponent(this.pnlParada, -2, -1, -2)
/* 429 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 430 */           .addComponent(this.pnlArquitetura, -2, -1, -2)
/* 431 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 432 */           .addComponent(this.pnlEstado, -2, -1, -2)
/* 433 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 434 */           .addGroup(pnlTreinamentoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 435 */             .addComponent(this.btnInicializar)
/* 436 */             .addComponent(this.btnValidar)
/* 437 */             .addComponent(this.btnTreinar))
/* 438 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 441 */     this.btnClassificar.setText("Classificar");
/* 442 */     this.btnClassificar.addActionListener(new ActionListener(this) { final LanguageRecognitionPanel this$0;
/*     */           public void actionPerformed(ActionEvent evt) {
/* 444 */             this.this$0.btnClassificarActionPerformed(evt);
/*     */           } }
/*     */       );
/*     */     
/* 448 */     this.btnLimpar.setText("Limpar");
/* 449 */     this.btnLimpar.addActionListener(new ActionListener(this) { final LanguageRecognitionPanel this$0;
/*     */           public void actionPerformed(ActionEvent evt) {
/* 451 */             this.this$0.btnLimparActionPerformed(evt);
/*     */           } }
/*     */       );
/*     */     
/* 455 */     this.pnlResultado.setBackground(new Color(255, 255, 255));
/* 456 */     this.pnlResultado.setBorder(BorderFactory.createTitledBorder("Idioma"));
/* 457 */     this.txtResultadoClassificacao.setText(" ");
/*     */     
/* 459 */     GroupLayout pnlResultadoLayout = new GroupLayout(this.pnlResultado);
/* 460 */     this.pnlResultado.setLayout(pnlResultadoLayout);
/* 461 */     pnlResultadoLayout.setHorizontalGroup(
/* 462 */         pnlResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 463 */         .addGroup(pnlResultadoLayout.createSequentialGroup()
/* 464 */           .addContainerGap()
/* 465 */           .addComponent(this.txtResultadoClassificacao, -1, 372, 32767)
/* 466 */           .addContainerGap()));
/*     */     
/* 468 */     pnlResultadoLayout.setVerticalGroup(
/* 469 */         pnlResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 470 */         .addGroup(pnlResultadoLayout.createSequentialGroup()
/* 471 */           .addComponent(this.txtResultadoClassificacao)
/* 472 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 475 */     GroupLayout layout = new GroupLayout(this);
/* 476 */     setLayout(layout);
/* 477 */     layout.setHorizontalGroup(
/* 478 */         layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 479 */         .addGroup(GroupLayout.Alignment.TRAILING, 
/* 480 */           layout.createSequentialGroup()
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 486 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.pnlResultado, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.btnLimpar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 264, 32767).addComponent(this.btnClassificar)).addGroup(GroupLayout.Alignment.LEADING, 
/* 487 */               layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 408, 32767)
/* 488 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
/* 489 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 490 */           .addComponent(this.pnlTreinamento, -2, -1, -2)));
/*     */     
/* 492 */     layout.setVerticalGroup(
/* 493 */         layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 494 */         .addGroup(GroupLayout.Alignment.TRAILING, 
/* 495 */           layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 454, -2)
/* 496 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 497 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 498 */             .addComponent(this.btnClassificar)
/* 499 */             .addComponent(this.btnLimpar))
/* 500 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 501 */           .addComponent(this.pnlResultado, 0, 54, 32767))
/* 502 */         .addComponent(this.pnlTreinamento, -1, 543, 32767));
/*     */   }
/*     */ 
/*     */   
/*     */   private void txtFuncaoAtivacaoActionPerformed(ActionEvent evt) {
/* 507 */     resetNet();
/*     */   }
/*     */   
/*     */   private void txtEtaActionPerformed(ActionEvent evt) {
/* 511 */     resetNet();
/*     */   }
/*     */   
/*     */   private void txtNumOcultosActionPerformed(ActionEvent evt) {
/* 515 */     resetNet();
/*     */   }
/*     */   
/*     */   private void btnClassesDetalheActionPerformed(ActionEvent evt) {
/* 519 */     showDetailClasses();
/*     */   }
/*     */   
/*     */   private void btnEstadoDetalheActionPerformed(ActionEvent evt) {
/* 523 */     showDetailStatus();
/*     */   }
/*     */   
/*     */   private void btnValidarActionPerformed(ActionEvent evt) {
/* 527 */     validateSamples();
/*     */   }
/*     */   
/*     */   private void btnLimparActionPerformed(ActionEvent evt) {
/* 531 */     clearText();
/*     */   }
/*     */   
/*     */   private void btnClassificarActionPerformed(ActionEvent evt) {
/* 535 */     classifier();
/*     */   }
/*     */   
/*     */   private void btnTreinarActionPerformed(ActionEvent evt) {
/* 539 */     train();
/*     */   }
/*     */   
/*     */   private void btnInicializarActionPerformed(ActionEvent evt) {
/* 543 */     initialize();
/*     */   }
/*     */   
/*     */   private void btnRemoverClasseActionPerformed(ActionEvent evt) {
/* 547 */     removeClass();
/*     */   }
/*     */   
/*     */   private void btnIncluirClasseActionPerformed(ActionEvent evt) {
/* 551 */     addClass();
/*     */   }
/*     */   
/*     */   private void btnIncluirTreinoActionPerformed(ActionEvent evt) {
/* 555 */     addTrainSample();
/*     */   }
/*     */   
/*     */   private void btnIncluirValidaActionPerformed(ActionEvent evt) {
/* 559 */     addValidateSample();
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void init() throws Exception {
/* 604 */     this.errorFrame = new ErrorFrame();
/* 605 */     this.classFrame = new WordFrame();
/* 606 */     this.validateFrame = new CrossValidationFrame();
/*     */     
/* 608 */     fillFunctions();
/* 609 */     fillClasses();
/* 610 */     statusCatch();
/*     */     
/* 612 */     this.errorController = new ErrorController(this) { final LanguageRecognitionPanel this$0;
/*     */         public void addValue(double x, double y, double yMin, double yMax) {
/* 614 */           this.this$0.errorFrame.addValue(x, y, yMin, yMax);
/* 615 */           this.this$0.txtAtualInteracao.setText(String.valueOf((int)x));
/* 616 */           this.this$0.txtAtualEMQ.setText(this.this$0.formatter.format(y));
/*     */         } }
/*     */       ;
/*     */   }
/*     */ 
/*     */   
/*     */   private void fillFunctions() throws Exception {
/* 623 */     this.txtFuncaoAtivacao.setModel(new DefaultComboBoxModel(this.controller.getFunctionNames()));
/*     */   }
/*     */ 
/*     */   
/*     */   private void fillClasses() throws Exception {
/* 628 */     String[] classNames = this.controller.getClassNames();
/* 629 */     Object[][] content = new Object[classNames.length][3];
/*     */     
/* 631 */     for (int i = 0; i < classNames.length; i++) {
/* 632 */       content[i][0] = classNames[i];
/* 633 */       content[i][1] = new Integer(this.controller.getTrainSampleNumber(classNames[i]));
/* 634 */       content[i][2] = new Integer(this.controller.getValidateSampleNumber(classNames[i]));
/*     */     } 
/*     */     
/* 637 */     this.tblClasses.setModel(
/* 638 */         new DefaultTableModel(this, 
/* 639 */           content, 
/* 640 */           (Object[])new String[] { "Idioma", "Treino", "Validação" }) { final LanguageRecognitionPanel this$0;
/*     */           
/*     */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 643 */             return false;
/*     */           } }
/*     */       );
/* 646 */     makeTrainHistogram();
/*     */   }
/*     */   
/*     */   private void resetNet() {
/* 650 */     this.controller.reset();
/*     */   }
/*     */   
/*     */   private void clearText() {
/* 654 */     this.txtArea.setText("");
/*     */   }
/*     */   
/*     */   private void initialize() {
/* 658 */     String functionName = (String)this.txtFuncaoAtivacao.getSelectedItem();
/* 659 */     String numNeuronios = this.txtNumOcultos.getText();
/* 660 */     String etaS = this.txtEta.getText();
/*     */     try {
/* 662 */       this.controller.setFunction(functionName);
/*     */       try {
/* 664 */         int num = Integer.parseInt(numNeuronios);
/* 665 */         this.controller.setNeuronNumbers(num);
/* 666 */       } catch (Exception e) {
/* 667 */         this.txtNumOcultos.setFocusable(true);
/* 668 */         throw new RuntimeException("Não foi possível definir o número de neurônios.", e);
/*     */       } 
/*     */       try {
/* 671 */         double eta = Double.parseDouble(etaS);
/* 672 */         this.controller.setEta(eta);
/* 673 */       } catch (Exception e) {
/* 674 */         this.txtEta.setFocusable(true);
/* 675 */         throw new RuntimeException("Não foi possível definir a taxa de aprendizagem.", e);
/*     */       } 
/* 677 */       this.controller.setErrorController(this.errorController);
/* 678 */       this.controller.initialize();
/* 679 */     } catch (Exception e) {
/* 680 */       showException(e);
/*     */     } 
/* 682 */     this.errorFrame.reset();
/* 683 */     this.txtAtualEMQ.setText("0.0");
/* 684 */     this.txtAtualInteracao.setText("0");
/*     */   }
/*     */   
/*     */   private void classifier() {
/*     */     try {
/* 689 */       String result = this.controller.classifier(this.txtArea.getText());
/* 690 */       if (result == null) {
/* 691 */         result = "Idioma não reconhecido.";
/*     */       }
/* 693 */       this.txtResultadoClassificacao.setText(result);
/* 694 */     } catch (Exception e) {
/* 695 */       showException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void train() {
/*     */     try {
/* 701 */       String etaS = this.txtEta.getText();
/*     */       try {
/* 703 */         double eta = Double.parseDouble(etaS);
/* 704 */         this.controller.setEta(eta);
/* 705 */       } catch (Exception e) {
/* 706 */         this.txtEta.setFocusable(true);
/* 707 */         throw new RuntimeException("Não foi possível definir a taxa de aprendizagem.", e);
/*     */       } 
/* 709 */       if (!this.controller.isInitialized()) {
/* 710 */         throw new RuntimeException("Rede não inicializada.");
/*     */       }
/* 712 */       switch (this.controller.getStatus()) {
/*     */         case 1:
/* 714 */           this.controller.stopTrain();
/*     */           return;
/*     */       } 
/* 717 */       if (this.chkNumMaxInteracao.isSelected()) {
/* 718 */         int it = Integer.parseInt(this.txtNumMaxInteracao.getText());
/* 719 */         this.controller.setIterationNumberMax(it);
/*     */       } else {
/* 721 */         this.controller.setIterationNumberMax(0);
/*     */       } 
/* 723 */       if (this.chkMSEMaximo.isSelected()) {
/* 724 */         double mse = Double.parseDouble(this.txtMSEMaximo.getText());
/* 725 */         this.controller.setMeanSquaredErrorMax(mse);
/*     */       } else {
/* 727 */         this.controller.setMeanSquaredErrorMax(0.0D);
/*     */       } 
/* 729 */       this.controller.setErrorController(this.errorController);
/* 730 */       this.controller.startTrain();
/*     */     
/*     */     }
/* 733 */     catch (Exception e) {
/* 734 */       showException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addClass() {
/* 739 */     String idioma = JOptionPane.showInputDialog(this, "Nome do novo idioma", "Incluir classe", 3);
/* 740 */     if (idioma != null && idioma.length() > 0) {
/*     */       try {
/* 742 */         if (this.controller.containsClass(idioma)) {
/* 743 */           throw new RuntimeException("Idioma já existente.");
/*     */         }
/* 745 */         this.controller.addClass(idioma);
/* 746 */         fillClasses();
/* 747 */       } catch (Exception e) {
/* 748 */         showException(e);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void removeClass() {
/* 754 */     if (this.tblClasses.getRowCount() == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 758 */     int selectedRow = this.tblClasses.getSelectedRow();
/*     */     try {
/* 760 */       if (selectedRow != -1) {
/* 761 */         String classe = (String)this.tblClasses.getValueAt(selectedRow, 0);
/* 762 */         this.controller.removeClass(classe);
/* 763 */         fillClasses();
/*     */       } else {
/* 765 */         throw new RuntimeException("Favor selecionar uma classe.");
/*     */       } 
/* 767 */     } catch (Exception e) {
/* 768 */       showException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addTrainSample() {
/* 773 */     String text = this.txtArea.getText();
/* 774 */     int selectedRow = this.tblClasses.getSelectedRow();
/*     */     try {
/* 776 */       if (text == null || text.length() == 0) {
/* 777 */         throw new RuntimeException("Texto não definido.");
/*     */       }
/*     */       
/* 780 */       if (selectedRow != -1) {
/* 781 */         String className = (String)this.tblClasses.getValueAt(selectedRow, 0);
/* 782 */         this.controller.addTrainSample(className, text);
/* 783 */         fillClasses();
/*     */       } else {
/* 785 */         throw new RuntimeException("Favor selecionar um idioma.");
/*     */       } 
/* 787 */     } catch (Exception e) {
/* 788 */       showException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addValidateSample() {
/* 793 */     String text = this.txtArea.getText();
/* 794 */     int selectedRow = this.tblClasses.getSelectedRow();
/*     */     try {
/* 796 */       if (text == null || text.length() == 0) {
/* 797 */         throw new RuntimeException("Texto não definido.");
/*     */       }
/*     */       
/* 800 */       if (selectedRow != -1) {
/* 801 */         String className = (String)this.tblClasses.getValueAt(selectedRow, 0);
/* 802 */         this.controller.addValidateSample(className, text);
/* 803 */         fillClasses();
/*     */       } else {
/* 805 */         throw new RuntimeException("Favor selecionar um idioma.");
/*     */       } 
/* 807 */     } catch (Exception e) {
/* 808 */       showException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void showDetailStatus() {
/* 813 */     this.errorFrame.setVisible(!this.errorFrame.isVisible());
/*     */   }
/*     */   
/*     */   private void showDetailClasses() {
/* 817 */     this.classFrame.setVisible(!this.classFrame.isVisible());
/*     */   }
/*     */ 
/*     */   
/*     */   private void statusCatch() {
/* 822 */     (new Thread(new Runnable(this)
/*     */         {
/*     */           final LanguageRecognitionPanel this$0;
/*     */           
/*     */           public void run() {
/*     */             while (true) {
/* 828 */               String status = "Não definido";
/* 829 */               String sTreinar = "Treinar";
/*     */               
/* 831 */               if (this.this$0.controller.isInitialized()) {
/* 832 */                 switch (this.this$0.controller.getStatus()) {
/*     */                   case 0:
/* 834 */                     status = "Não treinada";
/*     */                     break;
/*     */                   case 1:
/* 837 */                     status = "Em treinamento";
/* 838 */                     sTreinar = "Parar treinamento";
/*     */                     break;
/*     */                   case 2:
/* 841 */                     status = "Treinada";
/*     */                     break;
/*     */                   case 3:
/* 844 */                     status = "Treinamento interrompido";
/*     */                     break;
/*     */                 } 
/*     */ 
/*     */               
/*     */               } else {
/* 850 */                 status = "Não inicializada";
/*     */               } 
/*     */               
/* 853 */               this.this$0.txtEstado.setText(status);
/* 854 */               this.this$0.btnTreinar.setText(sTreinar);
/*     */               
/*     */               try {
/* 857 */                 Thread.sleep(5L);
/* 858 */               } catch (Exception exception) {}
/*     */ 
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 864 */         })).start();
/*     */   }
/*     */ 
/*     */   
/*     */   private void makeTrainHistogram() {
/* 869 */     String[] classNames = this.controller.getClassNames();
/* 870 */     this.classFrame.reset(classNames.length);
/* 871 */     for (int i = 0; i < classNames.length; i++) {
/* 872 */       double[] values = this.controller.getTrainHistogram(classNames[i]);
/* 873 */       this.classFrame.addValue(values, classNames[i]);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void validateSamples() {
/*     */     try {
/* 879 */       this.validateFrame.setVisible(true);
/* 880 */       this.validateFrame.setCrossValidation(this.controller.validate());
/* 881 */     } catch (Exception e) {
/* 882 */       showException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setDebugMode(boolean debug) {
/* 887 */     this.debugMode = debug;
/*     */   }
/*     */   
/*     */   private void showException(Exception e) {
/* 891 */     if (this.debugMode) {
/* 892 */       e.printStackTrace();
/*     */     }
/* 894 */     JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", 0);
/*     */   }
/*     */   
/*     */   private void defaultValues() {
/* 898 */     this.controller.addClass("Português");
/* 899 */     this.controller.addClass("Alemão");
/*     */ 
/*     */     
/*     */     try {
/* 903 */       this.controller.addTrainSample("Português", "Sugeriu-se a Rondeau que seu afastamento se dê em caráter temporário. Ficaria em suspenso a hipótese de retornar ao cargo caso fosse comprovada a sua inocência. Auxiliares de Lula receberam com alívio a disposição de Rondeau. Torcem para que a saída do ministro se materialize ainda nesta segunda-feira. Avaliam, porém, que o ideal seria um pedido de demissão convencional, sem previsão de volta.");
/* 904 */       this.controller.addTrainSample("Português", "Acusado pela Polícia Federal de receber propina de R$ 100 mil da Construtora Gautama, o ministro Silas Rondeau (Minas e Energia) foi aconselhado nesta segunda-feira (21) a afastar-se do cargo. O conselho partiu justamente de líderes do grupo que patrocinou a nomeação de Rondeau, o PMDB do Senado. Aos peemedebistas com os quais conversou, pelo telefone, o ministro deu indicações de que pode formalizar o pedido de desligamento do cargo.");
/* 905 */       this.controller.addTrainSample("Português", "Simultaneamente à articulação iniciada para convencer o ministro a deixar o governo, decidiu-se que lideranças do PMDB farão a defesa pública de Rondeau. Caso se confirme, o pedido de afastamento será vendido ao público não como uma evidência de culpa do ministro, mas como um gesto de desprendimento, inspirado no desejo de evitar constrangimentos ao governo Lula.");
/*     */       
/* 907 */       this.controller.addValidateSample("Português", "O coronel Eduardo dos Santos Raulino, comandante do Cindacta-1, admitiu hoje em depoimento à CPI do Apagão Aéreo do Senado a aproximação perigosa entre aeronaves próximo a Brasília, no início de maio. Segundo o coronel, em duas ocasiões os aviões passaram abaixo da distância de 300 metros entre si, recomendada pela Aeronáutica. Apesar de admitir a proximidade das aeronaves, o coronel disse que não houve riscos para os passageiros em nenhum momento.");
/* 908 */       this.controller.addValidateSample("Português", "Os documentos apresentados hoje pelo senador Renan Calheiros (PMDB-AL) para comprovar que ele pagou com seus próprios recursos pensão à jornalista Mônica Veloso, com quem tem uma filha, não esclarecem a origem do dinheiro que o senador teria utilizado para o pagamento realizado antes de dezembro de 2005. Os documentos mostram que, desde esse período, o senador utilizou recursos próprios para o pagamento da pensão.");
/*     */       
/* 910 */       this.controller.addTrainSample("Alemão", "Steinmeier würdigte während seiner Visite die Arbeit der Soldatinnen und Soldaten, die unter schwierigen und gefahrvollen Bedingungen „Herausragendes“ leisteten. In Afghanistan gebe es keine sicheren Zonen. „Der Terror droht überall, und absoluten Schutz vor Terrorangriffen gibt es nicht. Das mussten wir sehr schmerzlich erfahren.“");
/* 911 */       this.controller.addTrainSample("Alemão", "Bei dem Selbstmordanschlag auf eine Patrouille waren am Samstag auf einer Marktstraße in Kundus drei deutsche Soldaten ums Leben gekommen und fünf zum Teil schwer verletzt worden. Zudem starben fünf afghanische Zivilisten.");
/* 912 */       this.controller.addTrainSample("Alemão", "Steinmeier sprach in dem Stützpunkt mit Soldaten des deutschen Wiederaufbauteams (PRT), das in Kundus seit November 2003 tätig ist. Er sei gekommen, um nach dem schockierenden Anschlag von Samstag den Einsatz der Soldatinnen und Soldaten zu würdigen. „Ihre Arbeit verdient unsere ganze Anerkennung. Unser Land ist stolz auf seine Aufbauhelfer und Soldaten.“");
/*     */       
/* 914 */       this.controller.addValidateSample("Alemão", "Nach China erwägt nun auch Iran den Bau einer Transrapid-Strecke. Ein Münchner Ingenieurbüro hat den Auftrag für eine Machbarkeitsstudie erhalten. Der Schwebezug könnte Millionen Pilger aus Teheran ins mehr als 800 Kilometer entfernte Maschhad im Nordosten des Landes bringen. Wirtschaftssanktionen gegen Iran stehen dem Bau nicht im Wege.");
/* 915 */       this.controller.addValidateSample("Alemão", "Die international tätige Münchner Ingenieurfirma Regierungsbaumeister Schlegel GmbH prüft nach Angaben von Geschäftsführer Harald Späth, ob der Bau möglich ist. Die Firma habe einen offiziellen Auftrag erhalten, sagte Späth der Süddeutschen Zeitung. Dieser geht auf einen Besuch des damaligen bayerischen Wirtschaftsministers Otto Wiesheu im Mai 2004 in Teheran zurück.");
/* 916 */       this.controller.addValidateSample("Alemão", "Nach Darstellung des Ingenieurbüros hat die iranische Regierung 1,5 Milliarden Dollar als 'Anschubfinanzierung' für eine Transrapidstrecke zwischen Teheran und Maschhad bereitgestellt. Iran hoffe auf private Mitfinanziers, sagte Schlegel-Geschäftsführer Späth. Ziel sei es, zwölf bis 15 Millionen Pilger im Jahr vom Großraum Teheran nach Maschhad zu bringen. Bisher seien auf dieser Strecke Busse unterwegs, die zwei Tage brauchten.");
/* 917 */       this.controller.addValidateSample("Alemão", "Nach dem Ende der Demonstration kam es am Montagabend dann Kundgebung. Die Beamten setzten dabei Wasserwerfer ein. Am Abendeskalierte die Situation.");
/*     */     }
/* 919 */     catch (Exception e) {
/* 920 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/sandmann/Downloads/lang/langrecog.jar!/br/usp/poli/ann/gui/LanguageRecognitionPanel.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */