package trabalho.view;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import trabalho.conexao.Conexao;
import trabalho.controller.ProdutoController;
import trabalho.model.ProdutoModel;

public class ProdutoView extends IMenu {

    private String operacao;
    private String colunas[] = {"CÓDIGO", "NOME", "ESTOQUE", "UNIDADE", "PREÇO", "CUSTO", "ATACADO", "MIN", "MAX", "EMBALAGEM", "PESO", "CADASTRO", "OBS", "ATIVO"};
    // esse objeto será vinculado com a tabela
    // selecione o objeto tabela, clique em PROPRIEDADES e encontre MODEL
    // no combo "Definir Propriedades" escolha "Código Personalizado"
    // digite o objeto DefaultTableModel, neste exemplo é tabela(criado logo abaixo)
    private ArrayList<ProdutoModel> lista;
    private ProdutoTableModel tabela;

    private String getOperacao() {
        return operacao;
    }

    private void setOperacao(String operacao) {
        Boolean ativar = (operacao.equals("") ? false : true);
        // operacao=""(consulta), operacao="incluir"(inclusão), operacao="alterar"(alteração)
        this.operacao = operacao;
        btnGRAVAR.setEnabled(ativar);
    }

    public ProdutoView() {
        this.setPreferredSize(new Dimension(1300, 700));
        initComponents();
        setOperacao(""); // inicializa o form no modo CONSULTA
        setLocationRelativeTo(null);
        consultar();
        // adiciona evento para qdo navegar no JTable, atualizar os dados nos JTextField´s
        tblConsulta.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                int selecionado = tblConsulta.getSelectedRow();
                if (selecionado >= 0) {
                    mostrar(lista.get(selecionado));
                }
            }
        });
        setVisible(true);
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnPRIMEIRO = new javax.swing.JButton();
        btnANTERIOR = new javax.swing.JButton();
        btnPROXIMO = new javax.swing.JButton();
        btnULTIMO = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnINCLUIR = new javax.swing.JButton();
        btnALTERAR = new javax.swing.JButton();
        btnEXCLUIR = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnGRAVAR = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnSAIR = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelDADOS = new javax.swing.JPanel();
        lblPRO_CODIGO = new javax.swing.JLabel();
        lblPRO_NOME = new javax.swing.JLabel();
        edtPRO_CODIGO = new javax.swing.JTextField();
        edtPRO_NOME = new javax.swing.JTextField();
        lblPRO_ATIVO = new javax.swing.JLabel();
        comboPRO_ATIVO = new javax.swing.JComboBox<>();
        lblPRO_CADASTRO = new javax.swing.JLabel();
        textPRO_CADASTRO = new javax.swing.JFormattedTextField();
        lblPRO_PRECO = new javax.swing.JLabel();
        edtPRO_PRECO = new javax.swing.JTextField();
        lblPRO_CUSTO = new javax.swing.JLabel();
        edtPRO_ATACADO = new javax.swing.JTextField();
        lblPRO_ATACADO = new javax.swing.JLabel();
        edtPRO_CUSTO = new javax.swing.JTextField();
        lblPRO_MIN = new javax.swing.JLabel();
        edtPRO_MIN = new javax.swing.JTextField();
        lblPRO_MAX = new javax.swing.JLabel();
        edtPRO_MAX = new javax.swing.JTextField();
        lblPRO_OBS = new javax.swing.JLabel();
        edtPRO_OBS = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblPRO_ESTOQUE = new javax.swing.JLabel();
        edtPRO_ESTOQUE = new javax.swing.JTextField();
        lblPRO_UNIDADE = new javax.swing.JLabel();
        edtPRO_UNIDADE = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblPRO_EMBALAGEM = new javax.swing.JLabel();
        edtPRO_EMBALAGEM = new javax.swing.JTextField();
        lblPRO_PESO = new javax.swing.JLabel();
        edtPRO_PESO = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        painelCONSULTA = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblCONS_ID = new javax.swing.JLabel();
        edtCONS_ID1 = new javax.swing.JTextField();
        lblCodigo2 = new javax.swing.JLabel();
        edtCONS_ID2 = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        lblCONS_NOME = new javax.swing.JLabel();
        edtCONS_NOME = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema Vendas");
        setFocusable(false);
        setResizable(false);
        getContentPane().setLayout(null);

        jToolBar1.setRollover(true);

        btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/primeiro.png"))); // NOI18N
        btnPRIMEIRO.setText("Primeiro");
        btnPRIMEIRO.setFocusable(false);
        btnPRIMEIRO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPRIMEIRO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPRIMEIRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPRIMEIROActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPRIMEIRO);

        btnANTERIOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/anterior.png"))); // NOI18N
        btnANTERIOR.setText("Anterior");
        btnANTERIOR.setFocusable(false);
        btnANTERIOR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnANTERIOR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnANTERIOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnANTERIORActionPerformed(evt);
            }
        });
        jToolBar1.add(btnANTERIOR);

        btnPROXIMO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/proximo.png"))); // NOI18N
        btnPROXIMO.setText("Próximo");
        btnPROXIMO.setFocusable(false);
        btnPROXIMO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPROXIMO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPROXIMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPROXIMOActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPROXIMO);

        btnULTIMO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/ultimo.png"))); // NOI18N
        btnULTIMO.setText("Último");
        btnULTIMO.setFocusable(false);
        btnULTIMO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnULTIMO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnULTIMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnULTIMOActionPerformed(evt);
            }
        });
        jToolBar1.add(btnULTIMO);

        jSeparator1.setSeparatorSize(new java.awt.Dimension(30, 30));
        jToolBar1.add(jSeparator1);

        btnINCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/novo.png"))); // NOI18N
        btnINCLUIR.setText("Novo");
        btnINCLUIR.setFocusable(false);
        btnINCLUIR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnINCLUIR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnINCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINCLUIRActionPerformed(evt);
            }
        });
        jToolBar1.add(btnINCLUIR);

        btnALTERAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/alterar.png"))); // NOI18N
        btnALTERAR.setText("Alterar");
        btnALTERAR.setFocusable(false);
        btnALTERAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnALTERAR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnALTERAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALTERARActionPerformed(evt);
            }
        });
        jToolBar1.add(btnALTERAR);

        btnEXCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/excluir.png"))); // NOI18N
        btnEXCLUIR.setText("Excluir");
        btnEXCLUIR.setFocusable(false);
        btnEXCLUIR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEXCLUIR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEXCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXCLUIRActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEXCLUIR);

        jSeparator2.setSeparatorSize(new java.awt.Dimension(30, 30));
        jToolBar1.add(jSeparator2);

        btnGRAVAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/gravar.png"))); // NOI18N
        btnGRAVAR.setText("Gravar");
        btnGRAVAR.setFocusable(false);
        btnGRAVAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGRAVAR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGRAVAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGRAVARActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGRAVAR);

        jSeparator3.setSeparatorSize(new java.awt.Dimension(30, 30));
        jToolBar1.add(jSeparator3);

        btnSAIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/sair.png"))); // NOI18N
        btnSAIR.setText("Log off");
        btnSAIR.setFocusable(false);
        btnSAIR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSAIR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSAIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSAIRActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSAIR);

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(0, 0, 1300, 80);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("CADASTRO DE PRODUTOS");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(550, 90, 330, 29);

        lblPRO_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_CODIGO.setText("Código");

        lblPRO_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_NOME.setText("Nome");

        edtPRO_CODIGO.setEditable(false);
        edtPRO_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtPRO_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_NOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_NOMEActionPerformed(evt);
            }
        });

        lblPRO_ATIVO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_ATIVO.setText("Ativo? ");

        comboPRO_ATIVO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboPRO_ATIVO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATIVO", "INATIVO" }));

        lblPRO_CADASTRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_CADASTRO.setText("Cadastro");

        try {
            textPRO_CADASTRO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textPRO_CADASTRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblPRO_PRECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_PRECO.setText("Preço");

        edtPRO_PRECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_PRECO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_PRECOActionPerformed(evt);
            }
        });

        lblPRO_CUSTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_CUSTO.setText("Custo");

        edtPRO_ATACADO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_ATACADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_ATACADOActionPerformed(evt);
            }
        });

        lblPRO_ATACADO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_ATACADO.setText("Atacado");

        edtPRO_CUSTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_CUSTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_CUSTOActionPerformed(evt);
            }
        });

        lblPRO_MIN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_MIN.setText("Min");

        edtPRO_MIN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_MIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_MINActionPerformed(evt);
            }
        });

        lblPRO_MAX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_MAX.setText("Max");

        edtPRO_MAX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_MAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_MAXActionPerformed(evt);
            }
        });

        lblPRO_OBS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_OBS.setText("Obs");

        edtPRO_OBS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_OBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_OBSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDADOSLayout = new javax.swing.GroupLayout(painelDADOS);
        painelDADOS.setLayout(painelDADOSLayout);
        painelDADOSLayout.setHorizontalGroup(
            painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDADOSLayout.createSequentialGroup()
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPRO_NOME)
                                    .addComponent(lblPRO_CODIGO))
                                .addGap(18, 18, 18)
                                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelDADOSLayout.createSequentialGroup()
                                        .addComponent(edtPRO_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(edtPRO_NOME)))
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPRO_CUSTO, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPRO_PRECO, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edtPRO_CUSTO, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .addComponent(edtPRO_PRECO)))))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblPRO_ATACADO)
                        .addGap(18, 18, 18)
                        .addComponent(edtPRO_ATACADO)))
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblPRO_MIN)
                                .addGap(18, 18, 18)
                                .addComponent(edtPRO_MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPRO_MAX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtPRO_MAX, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addComponent(lblPRO_OBS)
                                .addGap(18, 18, 18)
                                .addComponent(edtPRO_OBS))))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPRO_ATIVO)
                            .addComponent(lblPRO_CADASTRO))
                        .addGap(18, 18, 18)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textPRO_CADASTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPRO_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(298, 298, 298))
        );
        painelDADOSLayout.setVerticalGroup(
            painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDADOSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtPRO_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPRO_CODIGO))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtPRO_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPRO_NOME))
                        .addGap(18, 18, 18)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtPRO_PRECO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPRO_PRECO))
                        .addGap(19, 19, 19)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPRO_CUSTO)
                            .addComponent(edtPRO_CUSTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPRO_CADASTRO)
                            .addComponent(textPRO_CADASTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtPRO_ATACADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPRO_ATACADO)
                            .addComponent(lblPRO_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPRO_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPRO_OBS)
                            .addComponent(edtPRO_OBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPRO_MIN)
                            .addComponent(lblPRO_MAX)
                            .addComponent(edtPRO_MAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtPRO_MIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Dados do Produto", painelDADOS);

        lblPRO_ESTOQUE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_ESTOQUE.setText("Estoque");

        edtPRO_ESTOQUE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_ESTOQUE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_ESTOQUEActionPerformed(evt);
            }
        });

        lblPRO_UNIDADE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_UNIDADE.setText("Unidade");

        edtPRO_UNIDADE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_UNIDADE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_UNIDADEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPRO_UNIDADE)
                    .addComponent(lblPRO_ESTOQUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edtPRO_ESTOQUE, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(edtPRO_UNIDADE))
                .addContainerGap(629, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPRO_ESTOQUE)
                    .addComponent(edtPRO_ESTOQUE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPRO_UNIDADE)
                    .addComponent(edtPRO_UNIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Estoque", jPanel1);

        lblPRO_EMBALAGEM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_EMBALAGEM.setText("Embalagem");

        edtPRO_EMBALAGEM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_EMBALAGEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_EMBALAGEMActionPerformed(evt);
            }
        });

        lblPRO_PESO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_PESO.setText("Peso");

        edtPRO_PESO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_PESO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_PESOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPRO_PESO)
                    .addComponent(lblPRO_EMBALAGEM))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edtPRO_EMBALAGEM, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(edtPRO_PESO))
                .addContainerGap(608, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPRO_EMBALAGEM)
                    .addComponent(edtPRO_EMBALAGEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPRO_PESO)
                    .addComponent(edtPRO_PESO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Embalagem", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 110, 910, 260);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCONS_ID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCONS_ID.setText("ID");

        edtCONS_ID1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblCodigo2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCodigo2.setText("à");

        edtCONS_ID2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnConsulta.setText("Consulta");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpa");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        lblCONS_NOME.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCONS_NOME.setText("Nome");

        edtCONS_NOME.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblCONS_NOME)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCONS_NOME))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(lblCONS_ID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCONS_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCodigo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtCONS_ID2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20)
                .addComponent(btnConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCONS_ID)
                    .addComponent(edtCONS_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo2)
                    .addComponent(edtCONS_ID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtCONS_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCONS_NOME))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsulta)
                    .addComponent(btnLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblConsulta);

        javax.swing.GroupLayout painelCONSULTALayout = new javax.swing.GroupLayout(painelCONSULTA);
        painelCONSULTA.setLayout(painelCONSULTALayout);
        painelCONSULTALayout.setHorizontalGroup(
            painelCONSULTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCONSULTALayout.createSequentialGroup()
                .addGroup(painelCONSULTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelCONSULTALayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1235, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelCONSULTALayout.setVerticalGroup(
            painelCONSULTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCONSULTALayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Consulta", painelCONSULTA);

        getContentPane().add(jTabbedPane2);
        jTabbedPane2.setBounds(20, 380, 1260, 250);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpar() {
        edtPRO_CODIGO.setText("0");
        edtPRO_NOME.setText("");
        edtPRO_ESTOQUE.setText("");
        edtPRO_UNIDADE.setText("");
        edtPRO_PRECO.setText("");
        edtPRO_CUSTO.setText("");
        edtPRO_ATACADO.setText("");
        edtPRO_MIN.setText("");
        edtPRO_MAX.setText("");
        edtPRO_EMBALAGEM.setText("");
        edtPRO_PESO.setText("");
        textPRO_CADASTRO.setText("");
        edtPRO_OBS.setText("");

    }

    private void mostrar(ProdutoModel produto) {
        edtPRO_CODIGO.setText(String.valueOf(produto.getPRO_CODIGO()));
        edtPRO_NOME.setText(produto.getPRO_NOME());
        edtPRO_ESTOQUE.setText(String.valueOf(produto.getPRO_ESTOQUE()));
        edtPRO_UNIDADE.setText(String.valueOf(produto.getPRO_UNIDADE()));
        edtPRO_PRECO.setText(String.valueOf(produto.getPRO_PRECO()));
        edtPRO_CUSTO.setText(String.valueOf(produto.getPRO_CUSTO()));
        edtPRO_ATACADO.setText(String.valueOf(produto.getPRO_ATACADO()));
        edtPRO_MIN.setText(String.valueOf(produto.getPRO_MIN()));
        edtPRO_MAX.setText(String.valueOf(produto.getPRO_MAX()));
        edtPRO_EMBALAGEM.setText(String.valueOf(produto.getPRO_EMBALAGEM()));
        edtPRO_PESO.setText(String.valueOf(produto.getPRO_PESO()));
        textPRO_CADASTRO.setText(produto.getPRO_CADASTRO());
        edtPRO_OBS.setText(produto.getPRO_OBS());
        comboPRO_ATIVO.setSelectedItem(produto.getPRO_ATIVO());
    }

    private String filtroConsulta() {
        String condicao = "";
        if (!edtCONS_ID1.getText().trim().equals("")) {
            condicao += "(PRO_CODIGO >= " + edtCONS_ID1.getText() + ")";
        }
        if (!edtCONS_ID2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(PRO_CODIGO <= " + edtCONS_ID2.getText() + ")";
        }
        if (!edtCONS_NOME.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(PRO_NOME LIKE ('%" + edtCONS_NOME.getText() + "%'))";
        }

        return condicao;
    }

    private void consultar() {
        try {
            String condicao = filtroConsulta();
            ProdutoController produto = new ProdutoController();
            lista = null;
            lista = produto.consultar(condicao);
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não Existem Clientes Cadastrados!");
            } else {
                tabela = new ProdutoTableModel(lista, colunas);
                tblConsulta.setModel(tabela);
                tblConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta do Usuário \n" + ex.getMessage());
        }
    }

    private void btnPRIMEIROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRIMEIROActionPerformed
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não Existem Clientes Cadastrados!");
        }
        int primeiro = 0;
        mostrarRegistro(primeiro);
    }//GEN-LAST:event_btnPRIMEIROActionPerformed

    private void btnINCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINCLUIRActionPerformed
        limpar();
        setOperacao("incluir");
        edtPRO_NOME.setFocusable(true);
        /*edtCLI_CODIGO.setText("0");
        edtCLI_NOME.setFocusable(true);
        textCLI_CPF.setFocusable(true);
        textCLI_RG.setFocusable(true);
        textCLI_CADASTRO.setFocusable(true);
        edtCLI_ENDERECO.setFocusable(true);
        edtCLI_NUMERO.setFocusable(true);
        edtCLI_COMPLEMENTO.setFocusable(true);
        edtCLI_BAIRRO.setFocusable(true);
        edtCLI_CIDADE.setFocusable(true);
        textCLI_CEP.setFocusable(true);
        textCLI_FONE1.setFocusable(true);
        textCLI_FONE2.setFocusable(true);
        textCLI_CELULAR.setFocusable(true);
        edtCLI_EMAIL.setFocusable(true);
        edtCLI_LIMITECRED.setFocusable(true);*/
    }//GEN-LAST:event_btnINCLUIRActionPerformed

    private void btnGRAVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAVARActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste Cliente?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                ProdutoModel objproduto = new ProdutoModel();
                objproduto.setPRO_CODIGO(Integer.parseInt(edtPRO_CODIGO.getText()));
                objproduto.setPRO_NOME(edtPRO_NOME.getText());
                objproduto.setPRO_ESTOQUE(Integer.parseInt(edtPRO_ESTOQUE.getText()));
                objproduto.setPRO_UNIDADE(Integer.parseInt(edtPRO_UNIDADE.getText()));
                objproduto.setPRO_PRECO(Double.parseDouble(edtPRO_PRECO.getText()));
                objproduto.setPRO_CUSTO(Double.parseDouble(edtPRO_CUSTO.getText()));
                objproduto.setPRO_ATACADO(Double.parseDouble(edtPRO_ATACADO.getText()));
                objproduto.setPRO_MIN(Double.parseDouble(edtPRO_MIN.getText()));
                objproduto.setPRO_MAX(Double.parseDouble(edtPRO_MAX.getText()));
                objproduto.setPRO_EMBALAGEM(Double.parseDouble(edtPRO_EMBALAGEM.getText()));
                objproduto.setPRO_PESO(Double.parseDouble(edtPRO_PESO.getText()));
                objproduto.setPRO_CADASTRO(textPRO_CADASTRO.getText());
                objproduto.setPRO_OBS(edtPRO_OBS.getText());
                objproduto.setPRO_ATIVO(comboPRO_ATIVO.getSelectedItem().toString());

                ProdutoController produtocontroller = new ProdutoController();
                produtocontroller.gravar(getOperacao(), objproduto);

                JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso");
                consultar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Gravação \n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnGRAVARActionPerformed

    private void btnALTERARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALTERARActionPerformed
        setOperacao("alterar");
    }//GEN-LAST:event_btnALTERARActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        consultar();
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnSAIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSAIRActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Deseja realizar log off?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_NO_OPTION) {

            Conexao objconexao;
            objconexao = new Conexao();

            dispose();
            LoginView loginview;
            loginview = new LoginView();

            loginview.setVisible(true);
        } else {

        }
    }//GEN-LAST:event_btnSAIRActionPerformed

    private void btnANTERIORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnANTERIORActionPerformed
        int selecionado = tblConsulta.getSelectedRow() - 1;
        mostrarRegistro(selecionado);
    }//GEN-LAST:event_btnANTERIORActionPerformed

    private void mostrarRegistro(int registro) {
        if (registro >= 0 && registro < lista.size()) {
            // exibe os dados do registro na aba Dados
            mostrar(lista.get(registro));

            // posicionar o registro selecionado na tabela (JTable)
            tblConsulta.changeSelection(registro, 0, false, false);
        }
    }

    private void btnPROXIMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPROXIMOActionPerformed
        int selecionado = tblConsulta.getSelectedRow() + 1;
        mostrarRegistro(selecionado);
    }//GEN-LAST:event_btnPROXIMOActionPerformed

    private void btnULTIMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnULTIMOActionPerformed
        int ultimo = lista.size() - 1;
        mostrarRegistro(ultimo);
    }//GEN-LAST:event_btnULTIMOActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        edtCONS_ID1.setText("");
        edtCONS_ID2.setText("");
        edtCONS_NOME.setText("");
      
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXCLUIRActionPerformed
        setOperacao("");
        if (JOptionPane.showConfirmDialog(null, "Confirma Exclusão deste Registro?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                ProdutoModel objproduto = new ProdutoModel();
                objproduto.setPRO_CODIGO(Integer.parseInt(edtPRO_CODIGO.getText()));
                objproduto.setPRO_NOME(edtPRO_NOME.getText());
                objproduto.setPRO_ESTOQUE(Integer.parseInt(edtPRO_ESTOQUE.getText()));
                objproduto.setPRO_UNIDADE(Integer.parseInt(edtPRO_UNIDADE.getText()));
                objproduto.setPRO_PRECO(Double.parseDouble(edtPRO_PRECO.getText()));
                objproduto.setPRO_CUSTO(Double.parseDouble(edtPRO_CUSTO.getText()));
                objproduto.setPRO_ATACADO(Double.parseDouble(edtPRO_ATACADO.getText()));
                objproduto.setPRO_MIN(Double.parseDouble(edtPRO_MIN.getText()));
                objproduto.setPRO_MAX(Double.parseDouble(edtPRO_MAX.getText()));
                objproduto.setPRO_EMBALAGEM(Double.parseDouble(edtPRO_EMBALAGEM.getText()));
                objproduto.setPRO_PESO(Double.parseDouble(edtPRO_PESO.getText()));
                objproduto.setPRO_CADASTRO(textPRO_CADASTRO.getText());
                objproduto.setPRO_OBS(edtPRO_OBS.getText());
                objproduto.setPRO_ATIVO(comboPRO_ATIVO.getSelectedItem().toString());

                ProdutoController produtocontroller = new ProdutoController();
                produtocontroller.excluir(objproduto);

                JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso");
                consultar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnEXCLUIRActionPerformed

    private void edtPRO_NOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_NOMEActionPerformed

    }//GEN-LAST:event_edtPRO_NOMEActionPerformed

    private void edtPRO_PRECOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_PRECOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPRO_PRECOActionPerformed

    private void edtPRO_ATACADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_ATACADOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPRO_ATACADOActionPerformed

    private void edtPRO_CUSTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_CUSTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPRO_CUSTOActionPerformed

    private void edtPRO_MINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_MINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPRO_MINActionPerformed

    private void edtPRO_MAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_MAXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPRO_MAXActionPerformed

    private void edtPRO_ESTOQUEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_ESTOQUEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPRO_ESTOQUEActionPerformed

    private void edtPRO_UNIDADEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_UNIDADEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPRO_UNIDADEActionPerformed

    private void edtPRO_EMBALAGEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_EMBALAGEMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPRO_EMBALAGEMActionPerformed

    private void edtPRO_PESOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_PESOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPRO_PESOActionPerformed

    private void edtPRO_OBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_OBSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPRO_OBSActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnALTERAR;
    private javax.swing.JButton btnANTERIOR;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnEXCLUIR;
    private javax.swing.JButton btnGRAVAR;
    private javax.swing.JButton btnINCLUIR;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPRIMEIRO;
    private javax.swing.JButton btnPROXIMO;
    private javax.swing.JButton btnSAIR;
    private javax.swing.JButton btnULTIMO;
    private javax.swing.JComboBox<String> comboPRO_ATIVO;
    private javax.swing.JTextField edtCONS_ID1;
    private javax.swing.JTextField edtCONS_ID2;
    private javax.swing.JTextField edtCONS_NOME;
    private javax.swing.JTextField edtPRO_ATACADO;
    private javax.swing.JTextField edtPRO_CODIGO;
    private javax.swing.JTextField edtPRO_CUSTO;
    private javax.swing.JTextField edtPRO_EMBALAGEM;
    private javax.swing.JTextField edtPRO_ESTOQUE;
    private javax.swing.JTextField edtPRO_MAX;
    private javax.swing.JTextField edtPRO_MIN;
    private javax.swing.JTextField edtPRO_NOME;
    private javax.swing.JTextField edtPRO_OBS;
    private javax.swing.JTextField edtPRO_PESO;
    private javax.swing.JTextField edtPRO_PRECO;
    private javax.swing.JTextField edtPRO_UNIDADE;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblCONS_ID;
    private javax.swing.JLabel lblCONS_NOME;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JLabel lblPRO_ATACADO;
    private javax.swing.JLabel lblPRO_ATIVO;
    private javax.swing.JLabel lblPRO_CADASTRO;
    private javax.swing.JLabel lblPRO_CODIGO;
    private javax.swing.JLabel lblPRO_CUSTO;
    private javax.swing.JLabel lblPRO_EMBALAGEM;
    private javax.swing.JLabel lblPRO_ESTOQUE;
    private javax.swing.JLabel lblPRO_MAX;
    private javax.swing.JLabel lblPRO_MIN;
    private javax.swing.JLabel lblPRO_NOME;
    private javax.swing.JLabel lblPRO_OBS;
    private javax.swing.JLabel lblPRO_PESO;
    private javax.swing.JLabel lblPRO_PRECO;
    private javax.swing.JLabel lblPRO_UNIDADE;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelCONSULTA;
    private javax.swing.JPanel painelDADOS;
    private javax.swing.JTable tblConsulta;
    private javax.swing.JFormattedTextField textPRO_CADASTRO;
    // End of variables declaration//GEN-END:variables
}
