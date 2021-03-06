package trabalho.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import trabalho.conexao.Conexao;
import trabalho.controller.ClienteController;
import trabalho.controller.PessoaController;
import trabalho.model.ClienteModel;
import trabalho.model.PessoaModel;
import trabalho.model.UsuarioModel;

public class ClienteView extends IMenu {

    private String operacao;
    private String colunas[] = {"CÓDIGO", "NOME", "CPF", "RG", "LIMITE DE CRÉDITO", "ATIVO", "FÍSICA"};
    // esse objeto será vinculado com a tabela
    // selecione o objeto tabela, clique em PROPRIEDADES e encontre MODEL
    // no combo "Definir Propriedades" escolha "Código Personalizado"
    // digite o objeto DefaultTableModel, neste exemplo é tabela(criado logo abaixo)
    private ArrayList<ClienteModel> lista;
    private ClienteTableModel tabela;

    private String getOperacao() {
        return operacao;
    }

    private void setOperacao(String operacao) {
        Boolean ativar = (operacao.equals("") ? false : true);
        // operacao=""(consulta), operacao="incluir"(inclusão), operacao="alterar"(alteração)
        this.operacao = operacao;
        btnGRAVAR.setEnabled(ativar);
        edtPES_CODIGO.setVisible(false); // tem como funcionalidade deixar o campo invisivel em questão de design.

    }

    public ClienteView() {
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelDADOS = new javax.swing.JPanel();
        lblCLI_CODIGO = new javax.swing.JLabel();
        lblCLI_NOME = new javax.swing.JLabel();
        edtCLI_CODIGO = new javax.swing.JTextField();
        edtCLI_CADASTRO = new javax.swing.JTextField();
        lblUSU_ATIVO = new javax.swing.JLabel();
        comboCLI_ATIVO = new javax.swing.JComboBox<>();
        lblUSU_CADASTRO = new javax.swing.JLabel();
        lblCLI_FISICA = new javax.swing.JLabel();
        comboCLI_FISICA = new javax.swing.JComboBox<>();
        lblCLI_CPF = new javax.swing.JLabel();
        lblCLI_RG = new javax.swing.JLabel();
        lblCLI_LIMITECRED = new javax.swing.JLabel();
        edtCLI_LIMITECRED = new javax.swing.JTextField();
        edtPES_CODIGO = new javax.swing.JTextField();
        lblVALIDACAO_NOME = new javax.swing.JLabel();
        lblVALIDACAO_CPF = new javax.swing.JLabel();
        lblVALIDACAO_RG = new javax.swing.JLabel();
        lblVALIDACAO_CADASTRO = new javax.swing.JLabel();
        lblVALIDACAO_LIMITECRED = new javax.swing.JLabel();
        edtCLI_CPF = new javax.swing.JTextField();
        edtCLI_NOME = new javax.swing.JTextField();
        edtCLI_RG = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblCLI_ENDERECO = new javax.swing.JLabel();
        edtCLI_ENDERECO = new javax.swing.JTextField();
        lblCLI_NUMERO = new javax.swing.JLabel();
        edtCLI_NUMERO = new javax.swing.JTextField();
        lblCLI_COMPLEMENTO = new javax.swing.JLabel();
        edtCLI_COMPLEMENTO = new javax.swing.JTextField();
        lblCLI_BAIRRO = new javax.swing.JLabel();
        edtCLI_BAIRRO = new javax.swing.JTextField();
        lblCLI_CIDADE = new javax.swing.JLabel();
        edtCLI_CIDADE = new javax.swing.JTextField();
        lblCLI_UF = new javax.swing.JLabel();
        comboCLI_UF = new javax.swing.JComboBox<>();
        lblCLI_CEP = new javax.swing.JLabel();
        edtCLI_CEP = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblCLI_FONE1 = new javax.swing.JLabel();
        lblCLI_FONE2 = new javax.swing.JLabel();
        lblCLI_CELULAR = new javax.swing.JLabel();
        lblCLI_EMAIL = new javax.swing.JLabel();
        edtCLI_EMAIL = new javax.swing.JTextField();
        lblVALIDACAO_TELEFONE1 = new javax.swing.JLabel();
        lblVALIDACAO_CELULAR = new javax.swing.JLabel();
        edtCLI_FONE1 = new javax.swing.JTextField();
        edtCLI_FONE2 = new javax.swing.JTextField();
        edtCLI_CELULAR = new javax.swing.JTextField();
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
        lblTitulo = new javax.swing.JLabel();
        lblDATA = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblHORA = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
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
        jToolBar1.setBounds(0, 0, 1300, 71);

        lblCLI_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_CODIGO.setText("Código");

        lblCLI_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_NOME.setText("Nome");

        edtCLI_CODIGO.setEditable(false);
        edtCLI_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtCLI_CADASTRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCLI_CADASTRO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCLI_CADASTROKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCLI_CADASTROKeyTyped(evt);
            }
        });

        lblUSU_ATIVO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_ATIVO.setText("Ativo? ");

        comboCLI_ATIVO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboCLI_ATIVO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATIVO", "INATIVO" }));

        lblUSU_CADASTRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_CADASTRO.setText("Data");

        lblCLI_FISICA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_FISICA.setText("Física?");

        comboCLI_FISICA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboCLI_FISICA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIM" }));

        lblCLI_CPF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_CPF.setText("CPF");

        lblCLI_RG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_RG.setText("RG");

        lblCLI_LIMITECRED.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_LIMITECRED.setText("Limite de Crédito ");

        edtCLI_LIMITECRED.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtPES_CODIGO.setEditable(false);
        edtPES_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblVALIDACAO_NOME.setText("*");

        lblVALIDACAO_CPF.setText("*");

        lblVALIDACAO_RG.setText("*");

        lblVALIDACAO_CADASTRO.setText("*");

        lblVALIDACAO_LIMITECRED.setText("*");

        edtCLI_CPF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCLI_CPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCLI_CPFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCLI_CPFKeyTyped(evt);
            }
        });

        edtCLI_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtCLI_RG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCLI_RG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCLI_RGKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCLI_RGKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout painelDADOSLayout = new javax.swing.GroupLayout(painelDADOS);
        painelDADOS.setLayout(painelDADOSLayout);
        painelDADOSLayout.setHorizontalGroup(
            painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDADOSLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUSU_CADASTRO)
                    .addComponent(lblCLI_RG)
                    .addComponent(lblCLI_CPF)
                    .addComponent(lblCLI_NOME)
                    .addComponent(lblCLI_CODIGO))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(edtCLI_CADASTRO)
                            .addComponent(edtCLI_RG, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVALIDACAO_RG)
                            .addComponent(lblVALIDACAO_CADASTRO)))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addComponent(edtCLI_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(edtPES_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addComponent(edtCLI_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblVALIDACAO_CPF))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addComponent(edtCLI_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblVALIDACAO_NOME)))
                .addGap(50, 50, 50)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCLI_FISICA)
                    .addComponent(lblCLI_LIMITECRED)
                    .addComponent(lblUSU_ATIVO))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboCLI_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addComponent(edtCLI_LIMITECRED, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblVALIDACAO_LIMITECRED))
                    .addComponent(comboCLI_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        painelDADOSLayout.setVerticalGroup(
            painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDADOSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtCLI_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCLI_CODIGO)
                    .addComponent(lblCLI_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCLI_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtPES_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_NOME)
                    .addComponent(lblUSU_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCLI_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVALIDACAO_NOME)
                    .addComponent(edtCLI_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_CPF)
                    .addComponent(lblCLI_LIMITECRED)
                    .addComponent(edtCLI_LIMITECRED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVALIDACAO_CPF)
                    .addComponent(lblVALIDACAO_LIMITECRED)
                    .addComponent(edtCLI_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVALIDACAO_RG)
                    .addComponent(lblCLI_RG)
                    .addComponent(edtCLI_RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVALIDACAO_CADASTRO)
                    .addComponent(lblUSU_CADASTRO)
                    .addComponent(edtCLI_CADASTRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados Pessoais", painelDADOS);

        lblCLI_ENDERECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_ENDERECO.setText("Endereço");

        edtCLI_ENDERECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCLI_NUMERO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_NUMERO.setText("N°");

        edtCLI_NUMERO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCLI_COMPLEMENTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_COMPLEMENTO.setText("Complemento");

        edtCLI_COMPLEMENTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCLI_BAIRRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_BAIRRO.setText("Bairro");

        edtCLI_BAIRRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCLI_CIDADE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_CIDADE.setText("Cidade");

        edtCLI_CIDADE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCLI_UF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_UF.setText("UF");

        comboCLI_UF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboCLI_UF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        lblCLI_CEP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_CEP.setText("CEP");

        edtCLI_CEP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCLI_CEP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCLI_CEPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCLI_CEPKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblCLI_ENDERECO)
                        .addGap(18, 18, 18)
                        .addComponent(edtCLI_ENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCLI_NUMERO)
                        .addGap(10, 10, 10)
                        .addComponent(edtCLI_NUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCLI_BAIRRO)
                            .addComponent(lblCLI_COMPLEMENTO)
                            .addComponent(lblCLI_CIDADE)
                            .addComponent(lblCLI_CEP))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(edtCLI_CIDADE, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(edtCLI_COMPLEMENTO, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(edtCLI_CEP, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(lblCLI_UF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboCLI_UF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edtCLI_BAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(451, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_ENDERECO)
                    .addComponent(edtCLI_ENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCLI_NUMERO)
                    .addComponent(edtCLI_NUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtCLI_BAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCLI_BAIRRO))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_COMPLEMENTO)
                    .addComponent(edtCLI_COMPLEMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_CIDADE)
                    .addComponent(edtCLI_CIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCLI_UF)
                    .addComponent(comboCLI_UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_CEP)
                    .addComponent(edtCLI_CEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Endereço", jPanel1);

        lblCLI_FONE1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_FONE1.setText("Telefone 1");

        lblCLI_FONE2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_FONE2.setText("Telefone 2");

        lblCLI_CELULAR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_CELULAR.setText("Celular");

        lblCLI_EMAIL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_EMAIL.setText("E-mail");

        edtCLI_EMAIL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblVALIDACAO_TELEFONE1.setText("*");

        lblVALIDACAO_CELULAR.setText("*");

        edtCLI_FONE1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCLI_FONE1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCLI_FONE1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCLI_FONE1KeyTyped(evt);
            }
        });

        edtCLI_FONE2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCLI_FONE2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCLI_FONE2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCLI_FONE2KeyTyped(evt);
            }
        });

        edtCLI_CELULAR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCLI_CELULAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCLI_CELULARKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCLI_CELULARKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCLI_FONE1)
                        .addGap(18, 18, 18)
                        .addComponent(edtCLI_FONE1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblVALIDACAO_TELEFONE1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCLI_CELULAR)
                            .addComponent(lblCLI_FONE2)
                            .addComponent(lblCLI_EMAIL))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(edtCLI_CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblVALIDACAO_CELULAR))
                            .addComponent(edtCLI_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtCLI_FONE2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(493, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_FONE1)
                    .addComponent(lblVALIDACAO_TELEFONE1)
                    .addComponent(edtCLI_FONE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_FONE2)
                    .addComponent(edtCLI_FONE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_CELULAR)
                    .addComponent(lblVALIDACAO_CELULAR)
                    .addComponent(edtCLI_CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_EMAIL)
                    .addComponent(edtCLI_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Contato", jPanel2);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("CADASTRO DE CLIENTES");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(550, 90, 299, 29);

        lblDATA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(lblDATA);
        lblDATA.setBounds(1190, 80, 100, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Data Atual:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1110, 80, 70, 30);

        lblHORA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(lblHORA);
        lblHORA.setBounds(1190, 120, 100, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Hora Atual:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1110, 120, 70, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpar() {
        edtCLI_CODIGO.setText("0");
        edtPES_CODIGO.setText("0");
        edtCLI_NOME.setText("");
        edtCLI_CPF.setText("");
        edtCLI_RG.setText("");
        edtCLI_CADASTRO.setText("");
        edtCLI_ENDERECO.setText("");
        edtCLI_NUMERO.setText("");
        edtCLI_COMPLEMENTO.setText("");
        edtCLI_BAIRRO.setText("");
        edtCLI_CIDADE.setText("");
        edtCLI_CEP.setText("");
        edtCLI_FONE1.setText("");
        edtCLI_FONE2.setText("");
        edtCLI_CELULAR.setText("");
        edtCLI_EMAIL.setText("");
        edtCLI_LIMITECRED.setText("");
    }

    private void mostrar(ClienteModel cliente) {

        edtCLI_CODIGO.setText(String.valueOf(cliente.getCLI_CODIGO()));
        edtPES_CODIGO.setText(String.valueOf(cliente.getPessoamodel().getPES_CODIGO()));
        edtCLI_NOME.setText(cliente.getPessoamodel().getPES_NOME());
        comboCLI_FISICA.setSelectedItem(cliente.getPessoamodel().getPES_FISICA());
        edtCLI_CPF.setText(cliente.getPessoamodel().getPES_CPFCNPJ());
        edtCLI_RG.setText(cliente.getPessoamodel().getPES_RGIE());
        edtCLI_CADASTRO.setText(cliente.getPessoamodel().getPES_CADASTRO());
        edtCLI_ENDERECO.setText(cliente.getPessoamodel().getPES_ENDERECO());
        edtCLI_NUMERO.setText(cliente.getPessoamodel().getPES_NUMERO());
        edtCLI_COMPLEMENTO.setText(cliente.getPessoamodel().getPES_COMPLEMENTO());
        edtCLI_BAIRRO.setText(cliente.getPessoamodel().getPES_BAIRRO());
        edtCLI_CIDADE.setText(cliente.getPessoamodel().getPES_CIDADE());
        comboCLI_UF.setSelectedItem(cliente.getPessoamodel().getPES_UF());
        edtCLI_CEP.setText(cliente.getPessoamodel().getPES_CEP());
        edtCLI_FONE1.setText(cliente.getPessoamodel().getPES_FONE1());
        edtCLI_FONE2.setText(cliente.getPessoamodel().getPES_FONE2());
        edtCLI_CELULAR.setText(cliente.getPessoamodel().getPES_CELULAR());
        edtCLI_EMAIL.setText(cliente.getPessoamodel().getPES_EMAIL());
        comboCLI_ATIVO.setSelectedItem(cliente.getPessoamodel().getPES_ATIVO());
        edtCLI_LIMITECRED.setText(String.valueOf(cliente.getCLI_LIMITECRED()));

        //funcionalidade do metodo: é um evento que ao selecionar uma opção no JComboBox de PES_FISICA
        //ele deixará o campo ativo ou inativo, util para cadatro de cliente e fornecedor.
        /*  comboCLI_FISICA.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evento) {

                if (comboCLI_FISICA.getSelectedItem().toString().equals("SIM")) {

                    edtPES_FANTASIA.setEnabled(false);
                    edtPES_SITE.setEnabled(false);
                        try {                       
                        textCLI_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
                         
                    } catch (java.text.ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Erro " + ex.getMessage());
                    }
                } else if (comboCLI_FISICA.getSelectedItem().toString().equals("NÃO")) {

                    edtPES_FANTASIA.setEnabled(true);
                    edtPES_SITE.setEnabled(true);
                    
                    try {                       
                        textCLI_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
                         
                    } catch (java.text.ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Erro " + ex.getMessage());
                    }
                }
            }
        }); */
    }

    private boolean validacao() {
        String erroMessage = "Campos com * devem ser preenchidos!";

        if (edtCLI_NOME.getText() == null || edtCLI_NOME.getText().length() == 0) {
            lblVALIDACAO_NOME.setForeground(Color.RED);
        } else {
            lblVALIDACAO_NOME.setForeground(Color.BLACK);
        }

        if (edtCLI_CPF.getText() == null || edtCLI_CPF.getText().length() == 0) {
            lblVALIDACAO_CPF.setForeground(Color.RED);
        } else {
            lblVALIDACAO_CPF.setForeground(Color.BLACK);
        }

        if (edtCLI_RG.getText() == null || edtCLI_RG.getText().length() == 0) {
            lblVALIDACAO_RG.setForeground(Color.RED);
        } else {
            lblVALIDACAO_RG.setForeground(Color.BLACK);
        }

        if (edtCLI_CADASTRO.getText() == null || edtCLI_CADASTRO.getText().length() == 0) {
            lblVALIDACAO_CADASTRO.setForeground(Color.RED);
        } else {
            lblVALIDACAO_CADASTRO.setForeground(Color.BLACK);
        }

        if (edtCLI_LIMITECRED.getText() == null || edtCLI_LIMITECRED.getText().length() == 0) {
            lblVALIDACAO_LIMITECRED.setForeground(Color.RED);
        } else {
            lblVALIDACAO_LIMITECRED.setForeground(Color.BLACK);
        }

        if (edtCLI_FONE1.getText() == null || edtCLI_FONE1.getText().length() == 0) {
            lblVALIDACAO_TELEFONE1.setForeground(Color.RED);
        } else {
            lblVALIDACAO_TELEFONE1.setForeground(Color.BLACK);
        }

        if (edtCLI_CELULAR.getText() == null || edtCLI_CELULAR.getText().length() == 0) {
            lblVALIDACAO_CELULAR.setForeground(Color.RED);
        } else {
            lblVALIDACAO_CELULAR.setForeground(Color.BLACK);
        }

        if (erroMessage.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private String filtroConsulta() {
        String condicao = "";
        if (!edtCONS_ID1.getText().trim().equals("")) {
            condicao += "(CLI_CODIGO >= " + edtCONS_ID1.getText() + ")";
        }
        if (!edtCONS_ID2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(CLI_CODIGO <= " + edtCONS_ID2.getText() + ")";
        }
        if (!edtCONS_NOME.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(PES_NOME LIKE ('%" + edtCONS_NOME.getText() + "%'))";
        }

        return condicao;
    }

    private void consultar() {
        try {
            String condicao = filtroConsulta();
            ClienteController cliente = new ClienteController();
            lista = null;
            lista = cliente.consultar(condicao);
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não Existem Clientes Cadastrados!");
            } else {
                tabela = new ClienteTableModel(lista, colunas);
                tblConsulta.setModel(tabela);
                tblConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta do Cliente \n" + ex.getMessage());
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
        edtCLI_CADASTRO.setFocusable(true);
    }//GEN-LAST:event_btnINCLUIRActionPerformed


    private void btnGRAVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAVARActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste Cliente?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {

                this.validacao();
                PessoaModel objpessoa = new PessoaModel();
                ClienteModel objcliente = new ClienteModel();

                objpessoa.setPES_CODIGO(Integer.parseInt(edtPES_CODIGO.getText()));
                objpessoa.setPES_NOME(edtCLI_NOME.getText());
                objpessoa.setPES_FISICA(comboCLI_FISICA.getSelectedItem().toString());
                objpessoa.setPES_CPFCNPJ(edtCLI_CPF.getText());
                objpessoa.setPES_RGIE(edtCLI_RG.getText());
                objpessoa.setPES_CADASTRO(edtCLI_CADASTRO.getText());
                objpessoa.setPES_ENDERECO(edtCLI_ENDERECO.getText());
                objpessoa.setPES_NUMERO(edtCLI_NUMERO.getText());
                objpessoa.setPES_COMPLEMENTO(edtCLI_COMPLEMENTO.getText());
                objpessoa.setPES_BAIRRO(edtCLI_BAIRRO.getText());
                objpessoa.setPES_CIDADE(edtCLI_CIDADE.getText());
                objpessoa.setPES_UF(comboCLI_UF.getSelectedItem().toString());
                objpessoa.setPES_CEP(edtCLI_CEP.getText());
                objpessoa.setPES_FONE1(edtCLI_FONE1.getText());
                objpessoa.setPES_FONE2(edtCLI_FONE2.getText());
                objpessoa.setPES_CELULAR(edtCLI_CELULAR.getText());
                objpessoa.setPES_EMAIL(edtCLI_EMAIL.getText());
                objpessoa.setPES_ATIVO(comboCLI_ATIVO.getSelectedItem().toString());

                objcliente.setPessoamodel(objpessoa);
                objcliente.setCLI_CODIGO(Integer.parseInt(edtCLI_CODIGO.getText()));
                objcliente.setCLI_LIMITECRED(Double.parseDouble(edtCLI_LIMITECRED.getText()));

                PessoaController pessoacontroller = new PessoaController();
                pessoacontroller.gravar(getOperacao(), objpessoa);

                ClienteController clientecontroller = new ClienteController();
                clientecontroller.gravar(getOperacao(), objcliente);

                JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso");
                consultar();
            } catch (HeadlessException | NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "Os campos com * devem ser preenchidos!\n\n "
                        + "Erro na Gravação \n"
                        + ex.getMessage());
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
                PessoaModel objpessoa = new PessoaModel();
                objpessoa.setPES_CODIGO(Integer.parseInt(edtCLI_CODIGO.getText())); // dar um aolhada 
                objpessoa.setPES_NOME(edtCLI_NOME.getText());
                objpessoa.setPES_FISICA(comboCLI_FISICA.getSelectedItem().toString());
                objpessoa.setPES_CPFCNPJ(edtCLI_CPF.getText());
                objpessoa.setPES_RGIE(edtCLI_RG.getText());
                objpessoa.setPES_CADASTRO(edtCLI_CADASTRO.getText());
                objpessoa.setPES_ENDERECO(edtCLI_ENDERECO.getText());
                objpessoa.setPES_NUMERO(edtCLI_NUMERO.getText());
                objpessoa.setPES_COMPLEMENTO(edtCLI_COMPLEMENTO.getText());
                objpessoa.setPES_BAIRRO(edtCLI_BAIRRO.getText());
                objpessoa.setPES_CIDADE(edtCLI_CIDADE.getText());
                objpessoa.setPES_UF(comboCLI_UF.getSelectedItem().toString());
                objpessoa.setPES_CEP(edtCLI_CEP.getText());
                objpessoa.setPES_FONE1(edtCLI_FONE1.getText());
                objpessoa.setPES_FONE2(edtCLI_FONE2.getText());
                objpessoa.setPES_CELULAR(edtCLI_CELULAR.getText());
                objpessoa.setPES_EMAIL(edtCLI_EMAIL.getText());
                objpessoa.setPES_ATIVO(comboCLI_ATIVO.getSelectedItem().toString());

                ClienteModel objcliente = new ClienteModel();
                objcliente.setCLI_CODIGO(Integer.parseInt(edtCLI_CODIGO.getText()));
                objcliente.setCLI_LIMITECRED(Double.parseDouble(edtCLI_LIMITECRED.getText()));
                objcliente.setPessoamodel(objpessoa);

                ClienteController clientecontroller = new ClienteController();
                clientecontroller.excluir(objcliente);

                JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso");
                consultar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnEXCLUIRActionPerformed

    private void edtCLI_CPFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_CPFKeyReleased
        String campo = edtCLI_CPF.getText();
        if (campo.length() == 11) {
            String cpf;
            cpf = String.valueOf("" + campo.charAt(0) + campo.charAt(1) + campo.charAt(2) + "." + campo.charAt(3) + campo.charAt(4) + campo.charAt(5) + "." + campo.charAt(6) + campo.charAt(7) + campo.charAt(8) + "-" + campo.charAt(9) + campo.charAt(10));
            edtCLI_CPF.setText(cpf);
        }
    }//GEN-LAST:event_edtCLI_CPFKeyReleased

    private void edtCLI_CPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_CPFKeyTyped
        int quantidade = 11;
        if (edtCLI_CPF.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtCLI_CPFKeyTyped

    private void edtCLI_CADASTROKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_CADASTROKeyReleased
        String campo = edtCLI_CADASTRO.getText();
        if (campo.length() == 8) {
            String cadastro;
            cadastro = String.valueOf("" + campo.charAt(0) + campo.charAt(1) + "/" + campo.charAt(2) + campo.charAt(3) + "/" + campo.charAt(4) + campo.charAt(5) + campo.charAt(6) + campo.charAt(7));
            edtCLI_CADASTRO.setText(cadastro);
        }
    }//GEN-LAST:event_edtCLI_CADASTROKeyReleased

    private void edtCLI_CADASTROKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_CADASTROKeyTyped
        int quantidade = 8;
        if (edtCLI_CADASTRO.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtCLI_CADASTROKeyTyped

    private void edtCLI_RGKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_RGKeyReleased
        String campo = edtCLI_RG.getText();
        if (campo.length() == 9) {
            String rg;
            rg = String.valueOf("" + campo.charAt(0) + campo.charAt(1) + "." + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + "." + campo.charAt(5) + campo.charAt(6) + campo.charAt(7) + "-" + campo.charAt(8));
            edtCLI_RG.setText(rg);
        }
    }//GEN-LAST:event_edtCLI_RGKeyReleased

    private void edtCLI_RGKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_RGKeyTyped
        int quantidade = 9;
        if (edtCLI_RG.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtCLI_RGKeyTyped

    private void edtCLI_CEPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_CEPKeyReleased
        String campo = edtCLI_CEP.getText();
        if (campo.length() == 8) {
            String cep;
            cep = String.valueOf("" + campo.charAt(0) + campo.charAt(1) + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + "-" + campo.charAt(5) + campo.charAt(6) + campo.charAt(7));
            edtCLI_CEP.setText(cep);
        }
    }//GEN-LAST:event_edtCLI_CEPKeyReleased

    private void edtCLI_CEPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_CEPKeyTyped
        int quantidade = 8;
        if (edtCLI_CEP.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtCLI_CEPKeyTyped

    private void edtCLI_FONE1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_FONE1KeyTyped
        int quantidade = 10;
        if (edtCLI_FONE1.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtCLI_FONE1KeyTyped

    private void edtCLI_FONE1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_FONE1KeyReleased
        String campo = edtCLI_FONE1.getText();
        if (campo.length() == 10) {
            String fone1;
            fone1 = String.valueOf("" + "(" + campo.charAt(0) + campo.charAt(1) + ") " + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + campo.charAt(5) + "-" + campo.charAt(6) + campo.charAt(7) + campo.charAt(8) + campo.charAt(9));
            edtCLI_FONE1.setText(fone1);
        }
    }//GEN-LAST:event_edtCLI_FONE1KeyReleased

    private void edtCLI_FONE2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_FONE2KeyReleased
        String campo = edtCLI_FONE2.getText();
        if (campo.length() == 10) {
            String fone2;
            fone2 = String.valueOf("" + "(" + campo.charAt(0) + campo.charAt(1) + ") " + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + campo.charAt(5) + "-" + campo.charAt(6) + campo.charAt(7) + campo.charAt(8) + campo.charAt(9));
            edtCLI_FONE2.setText(fone2);
        }
    }//GEN-LAST:event_edtCLI_FONE2KeyReleased

    private void edtCLI_FONE2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_FONE2KeyTyped
        int quantidade = 10;
        if (edtCLI_FONE2.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtCLI_FONE2KeyTyped

    private void edtCLI_CELULARKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_CELULARKeyReleased
        String campo = edtCLI_CELULAR.getText();
        if (campo.length() == 10) {
            String fone2;
            fone2 = String.valueOf("" + "(" + campo.charAt(0) + campo.charAt(1) + ") " + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + campo.charAt(5) + "-" + campo.charAt(6) + campo.charAt(7) + campo.charAt(8) + campo.charAt(9));
            edtCLI_CELULAR.setText(fone2);
        }
    }//GEN-LAST:event_edtCLI_CELULARKeyReleased

    private void edtCLI_CELULARKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_CELULARKeyTyped
        int quantidade = 10;
        if (edtCLI_CELULAR.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtCLI_CELULARKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //funcionalidade de mostrar a data atual.
        Calendar c1 = Calendar.getInstance(new Locale("pt-br"));
        lblDATA.setText(c1.get(Calendar.DAY_OF_MONTH)  + "/" +  c1.get(Calendar.MONTH) + "/" + c1.get(Calendar.YEAR));
        //funcionalidade de mostar a hora atual. 
        Timer time = new Timer(1000, new hora());
        time.start();
    }//GEN-LAST:event_formWindowOpened

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
    private javax.swing.JComboBox<String> comboCLI_ATIVO;
    private javax.swing.JComboBox<String> comboCLI_FISICA;
    private javax.swing.JComboBox<String> comboCLI_UF;
    private javax.swing.JTextField edtCLI_BAIRRO;
    private javax.swing.JTextField edtCLI_CADASTRO;
    private javax.swing.JTextField edtCLI_CELULAR;
    private javax.swing.JTextField edtCLI_CEP;
    private javax.swing.JTextField edtCLI_CIDADE;
    private javax.swing.JTextField edtCLI_CODIGO;
    private javax.swing.JTextField edtCLI_COMPLEMENTO;
    private javax.swing.JTextField edtCLI_CPF;
    private javax.swing.JTextField edtCLI_EMAIL;
    private javax.swing.JTextField edtCLI_ENDERECO;
    private javax.swing.JTextField edtCLI_FONE1;
    private javax.swing.JTextField edtCLI_FONE2;
    private javax.swing.JTextField edtCLI_LIMITECRED;
    private javax.swing.JTextField edtCLI_NOME;
    private javax.swing.JTextField edtCLI_NUMERO;
    private javax.swing.JTextField edtCLI_RG;
    private javax.swing.JTextField edtCONS_ID1;
    private javax.swing.JTextField edtCONS_ID2;
    private javax.swing.JTextField edtCONS_NOME;
    private javax.swing.JTextField edtPES_CODIGO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel lblCLI_BAIRRO;
    private javax.swing.JLabel lblCLI_CELULAR;
    private javax.swing.JLabel lblCLI_CEP;
    private javax.swing.JLabel lblCLI_CIDADE;
    private javax.swing.JLabel lblCLI_CODIGO;
    private javax.swing.JLabel lblCLI_COMPLEMENTO;
    private javax.swing.JLabel lblCLI_CPF;
    private javax.swing.JLabel lblCLI_EMAIL;
    private javax.swing.JLabel lblCLI_ENDERECO;
    private javax.swing.JLabel lblCLI_FISICA;
    private javax.swing.JLabel lblCLI_FONE1;
    private javax.swing.JLabel lblCLI_FONE2;
    private javax.swing.JLabel lblCLI_LIMITECRED;
    private javax.swing.JLabel lblCLI_NOME;
    private javax.swing.JLabel lblCLI_NUMERO;
    private javax.swing.JLabel lblCLI_RG;
    private javax.swing.JLabel lblCLI_UF;
    private javax.swing.JLabel lblCONS_ID;
    private javax.swing.JLabel lblCONS_NOME;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JLabel lblDATA;
    private javax.swing.JLabel lblHORA;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUSU_ATIVO;
    private javax.swing.JLabel lblUSU_CADASTRO;
    private javax.swing.JLabel lblVALIDACAO_CADASTRO;
    private javax.swing.JLabel lblVALIDACAO_CELULAR;
    private javax.swing.JLabel lblVALIDACAO_CPF;
    private javax.swing.JLabel lblVALIDACAO_LIMITECRED;
    private javax.swing.JLabel lblVALIDACAO_NOME;
    private javax.swing.JLabel lblVALIDACAO_RG;
    private javax.swing.JLabel lblVALIDACAO_TELEFONE1;
    private javax.swing.JPanel painelCONSULTA;
    private javax.swing.JPanel painelDADOS;
    private javax.swing.JTable tblConsulta;
    // End of variables declaration//GEN-END:variables

    //classe interna com funcionalidade de mostrar a hora atual.
    class hora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            Calendar now = Calendar.getInstance();
            lblHORA.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }
}
