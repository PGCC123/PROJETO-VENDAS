package trabalho.view;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import trabalho.conexao.Conexao;
import trabalho.controller.FornecedorController;
import trabalho.controller.PessoaController;
import trabalho.model.FornecedorModel;
import trabalho.model.PessoaModel;

public class FornecedorView extends IMenu {

    private String operacao;
    private String colunas[] = {"CÓDIGO", "NOME", "CNPJ", "INCRIÇÃO ESTADUAL", "ATIVO", "FÍSICA"};
    // esse objeto será vinculado com a tabela
    // selecione o objeto tabela, clique em PROPRIEDADES e encontre MODEL
    // no combo "Definir Propriedades" escolha "Código Personalizado"
    // digite o objeto DefaultTableModel, neste exemplo é tabela(criado logo abaixo)
    private ArrayList<FornecedorModel> lista;
    private FornecedorTableModel tabela;

    private String getOperacao() {
        return operacao;
    }

    private void setOperacao(String operacao) {
        Boolean ativar = (operacao.equals("") ? false : true);
        // operacao=""(consulta), operacao="incluir"(inclusão), operacao="alterar"(alteração)
        this.operacao = operacao;
        btnGRAVAR.setEnabled(ativar);
        //edtFOR_NOME.setEnabled(ativar); // implementação teste.
        edtPES_CODIGO.setVisible(false); // tem como funcionalidade deixar o campo invisivel para questão de design

    }

    public FornecedorView() {
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
        lblFOR_CODIGO = new javax.swing.JLabel();
        lblFOR_NOME = new javax.swing.JLabel();
        edtPES_CODIGO = new javax.swing.JTextField();
        edtFOR_NOME = new javax.swing.JTextField();
        lblFOR_ATIVO = new javax.swing.JLabel();
        comboFOR_ATIVO = new javax.swing.JComboBox<>();
        lblFOR_CADASTRO = new javax.swing.JLabel();
        edtFOR_CNPJ = new javax.swing.JFormattedTextField();
        lblFOR_FISICA = new javax.swing.JLabel();
        comboFOR_FISICA = new javax.swing.JComboBox<>();
        lblFOR_CNPJ = new javax.swing.JLabel();
        edtFOR_CADASTRO = new javax.swing.JFormattedTextField();
        lblCLI_IE = new javax.swing.JLabel();
        edtFOR_IE = new javax.swing.JFormattedTextField();
        lblFOR_FANTASIA = new javax.swing.JLabel();
        edtFOR_FANTASIA = new javax.swing.JTextField();
        edtFOR_CODIGO = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblFOR_ENDERECO = new javax.swing.JLabel();
        edtFOR_ENDERECO = new javax.swing.JTextField();
        lblFOR_NUMERO = new javax.swing.JLabel();
        edtFOR_NUMERO = new javax.swing.JTextField();
        lblFOR_COMPLEMENTO = new javax.swing.JLabel();
        edtFOR_COMPLEMENTO = new javax.swing.JTextField();
        lblFOR_BAIRRO = new javax.swing.JLabel();
        edtFOR_BAIRRO = new javax.swing.JTextField();
        lblFOR_CIDADE = new javax.swing.JLabel();
        edtFOR_CIDADE = new javax.swing.JTextField();
        lblFORI_UF = new javax.swing.JLabel();
        comboFOR_UF = new javax.swing.JComboBox<>();
        lblFOR_CEP = new javax.swing.JLabel();
        edtFOR_CEP = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        lblFORI_FONE1 = new javax.swing.JLabel();
        lblFOR_FONE2 = new javax.swing.JLabel();
        edtFOR_FONE1 = new javax.swing.JFormattedTextField();
        edtFOR_FONE2 = new javax.swing.JFormattedTextField();
        lblFOR_CELULAR = new javax.swing.JLabel();
        edtFOR_CELULAR = new javax.swing.JFormattedTextField();
        lblFOR_EMAIL = new javax.swing.JLabel();
        edtFOR_EMAIL = new javax.swing.JTextField();
        lblFOR_SITE = new javax.swing.JLabel();
        edtFOR_SITE = new javax.swing.JTextField();
        lblFOR_CONTATO = new javax.swing.JLabel();
        edtFOR_CONTATO = new javax.swing.JTextField();
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
        lblCONS_LOGIN = new javax.swing.JLabel();
        edtCONS_LOGIN = new javax.swing.JTextField();
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
        jToolBar1.setBounds(0, 0, 1300, 71);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setText("CADASTRO DE FORNECEDOR");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(550, 90, 360, 29);

        lblFOR_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_CODIGO.setText("Código");

        lblFOR_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_NOME.setText("Nome");

        edtPES_CODIGO.setEditable(false);
        edtPES_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtFOR_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_NOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtFOR_NOMEActionPerformed(evt);
            }
        });

        lblFOR_ATIVO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_ATIVO.setText("Ativo? ");

        comboFOR_ATIVO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboFOR_ATIVO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATIVO", "INATIVO" }));

        lblFOR_CADASTRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_CADASTRO.setText("Cadastro");

        try {
            edtFOR_CNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtFOR_CNPJ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFOR_FISICA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_FISICA.setText("Física?");

        comboFOR_FISICA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboFOR_FISICA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NÃO" }));

        lblFOR_CNPJ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_CNPJ.setText("CNPJ");

        try {
            edtFOR_CADASTRO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtFOR_CADASTRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCLI_IE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_IE.setText("Inscrição Estadual");

        try {
            edtFOR_IE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtFOR_IE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFOR_FANTASIA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_FANTASIA.setText("Fantasia");

        edtFOR_FANTASIA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_FANTASIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtFOR_FANTASIAActionPerformed(evt);
            }
        });

        edtFOR_CODIGO.setEditable(false);
        edtFOR_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout painelDADOSLayout = new javax.swing.GroupLayout(painelDADOS);
        painelDADOS.setLayout(painelDADOSLayout);
        painelDADOSLayout.setHorizontalGroup(
            painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDADOSLayout.createSequentialGroup()
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFOR_NOME)
                                    .addComponent(lblFOR_CODIGO)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDADOSLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblFOR_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCLI_IE)))
                        .addGap(18, 18, 18)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtFOR_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtFOR_FANTASIA, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtFOR_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtFOR_IE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addComponent(edtFOR_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(edtPES_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(lblFOR_FANTASIA)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFOR_ATIVO, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFOR_FISICA, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFOR_CADASTRO, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboFOR_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtFOR_CADASTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFOR_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(201, 201, 201))
        );
        painelDADOSLayout.setVerticalGroup(
            painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDADOSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFOR_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboFOR_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFOR_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboFOR_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtFOR_CADASTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFOR_CADASTRO)))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFOR_CODIGO)
                            .addComponent(edtPES_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtFOR_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFOR_NOME)
                            .addComponent(edtFOR_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtFOR_FANTASIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFOR_FANTASIA))
                        .addGap(23, 23, 23)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtFOR_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFOR_CNPJ))
                        .addGap(22, 22, 22)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCLI_IE)
                            .addComponent(edtFOR_IE, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jTabbedPane1.addTab("Dados Pessoais", painelDADOS);

        lblFOR_ENDERECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_ENDERECO.setText("Endereço");

        edtFOR_ENDERECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_ENDERECO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtFOR_ENDERECOActionPerformed(evt);
            }
        });

        lblFOR_NUMERO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_NUMERO.setText("N°");

        edtFOR_NUMERO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_NUMERO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtFOR_NUMEROActionPerformed(evt);
            }
        });

        lblFOR_COMPLEMENTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_COMPLEMENTO.setText("Complemento");

        edtFOR_COMPLEMENTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_COMPLEMENTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtFOR_COMPLEMENTOActionPerformed(evt);
            }
        });

        lblFOR_BAIRRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_BAIRRO.setText("Bairro");

        edtFOR_BAIRRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_BAIRRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtFOR_BAIRROActionPerformed(evt);
            }
        });

        lblFOR_CIDADE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_CIDADE.setText("Cidade");

        edtFOR_CIDADE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_CIDADE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtFOR_CIDADEActionPerformed(evt);
            }
        });

        lblFORI_UF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFORI_UF.setText("UF");

        comboFOR_UF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboFOR_UF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        lblFOR_CEP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_CEP.setText("CEP");

        try {
            edtFOR_CEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtFOR_CEP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblFOR_ENDERECO)
                        .addGap(18, 18, 18)
                        .addComponent(edtFOR_ENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblFOR_NUMERO)
                        .addGap(10, 10, 10)
                        .addComponent(edtFOR_NUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFOR_BAIRRO)
                            .addComponent(lblFOR_COMPLEMENTO)
                            .addComponent(lblFOR_CIDADE)
                            .addComponent(lblFOR_CEP))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(edtFOR_CIDADE, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(edtFOR_COMPLEMENTO, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(edtFOR_CEP))
                                .addGap(18, 18, 18)
                                .addComponent(lblFORI_UF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboFOR_UF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edtFOR_BAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(451, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFOR_ENDERECO)
                    .addComponent(edtFOR_ENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFOR_NUMERO)
                    .addComponent(edtFOR_NUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtFOR_BAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFOR_BAIRRO))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFOR_COMPLEMENTO)
                    .addComponent(edtFOR_COMPLEMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFOR_CIDADE)
                    .addComponent(edtFOR_CIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFORI_UF)
                    .addComponent(comboFOR_UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFOR_CEP)
                    .addComponent(edtFOR_CEP, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Endereço", jPanel1);

        lblFORI_FONE1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFORI_FONE1.setText("Telefone 1");

        lblFOR_FONE2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_FONE2.setText("Telefone 2");

        try {
            edtFOR_FONE1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtFOR_FONE1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            edtFOR_FONE2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtFOR_FONE2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFOR_CELULAR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_CELULAR.setText("Celular");

        try {
            edtFOR_CELULAR.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) 9####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtFOR_CELULAR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFOR_EMAIL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_EMAIL.setText("E-mail");

        edtFOR_EMAIL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_EMAIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtFOR_EMAILActionPerformed(evt);
            }
        });

        lblFOR_SITE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_SITE.setText("Site");

        edtFOR_SITE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_SITE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtFOR_SITEActionPerformed(evt);
            }
        });

        lblFOR_CONTATO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_CONTATO.setText("Contato");

        edtFOR_CONTATO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_CONTATO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtFOR_CONTATOActionPerformed(evt);
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
                        .addComponent(lblFORI_FONE1)
                        .addGap(18, 18, 18)
                        .addComponent(edtFOR_FONE1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197)
                        .addComponent(lblFOR_CONTATO)
                        .addGap(18, 18, 18)
                        .addComponent(edtFOR_CONTATO, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFOR_CELULAR)
                            .addComponent(lblFOR_FONE2)
                            .addComponent(lblFOR_EMAIL)
                            .addComponent(lblFOR_SITE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtFOR_FONE2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtFOR_CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtFOR_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtFOR_SITE, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFORI_FONE1)
                    .addComponent(edtFOR_FONE1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFOR_CONTATO)
                    .addComponent(edtFOR_CONTATO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFOR_FONE2)
                    .addComponent(edtFOR_FONE2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtFOR_CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFOR_CELULAR))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFOR_EMAIL)
                    .addComponent(edtFOR_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFOR_SITE)
                    .addComponent(edtFOR_SITE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
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

        lblCONS_LOGIN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCONS_LOGIN.setText("Login");

        edtCONS_LOGIN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

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
                        .addGap(18, 18, 18)
                        .addComponent(lblCONS_LOGIN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCONS_LOGIN, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)))
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
                    .addComponent(edtCONS_ID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtCONS_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCONS_LOGIN))
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
         edtFOR_CODIGO.setText("0");
        edtPES_CODIGO.setText("0");
        edtFOR_NOME.setText("");
        edtFOR_FANTASIA.setText("");
        edtFOR_CNPJ.setText("");
        edtFOR_IE.setText("");
        edtFOR_CADASTRO.setText("");
        edtFOR_ENDERECO.setText("");
        edtFOR_NUMERO.setText("");
        edtFOR_COMPLEMENTO.setText("");
        edtFOR_BAIRRO.setText("");
        edtFOR_CIDADE.setText("");
        edtFOR_CEP.setText("");
        edtFOR_FONE1.setText("");
        edtFOR_FONE2.setText("");
        edtFOR_CELULAR.setText("");
        edtFOR_EMAIL.setText("");
        edtFOR_SITE.setText("");
        edtFOR_CONTATO.setText("");
   }

    private void mostrar(FornecedorModel fornecedor) {
        edtFOR_CODIGO.setText(String.valueOf(fornecedor.getFOR_CODIGO()));
        edtPES_CODIGO.setText(String.valueOf(fornecedor.getPES_MODEL().getPES_CODIGO()));
        edtFOR_NOME.setText(fornecedor.getPES_MODEL().getPES_NOME());
        edtFOR_FANTASIA.setText(fornecedor.getPES_MODEL().getPES_FANTASIA());
        comboFOR_FISICA.setSelectedItem(fornecedor.getPES_MODEL().getPES_FISICA());
        edtFOR_CNPJ.setText(fornecedor.getPES_MODEL().getPES_CPFCNPJ());
        edtFOR_IE.setText(fornecedor.getPES_MODEL().getPES_RGIE());
        edtFOR_CADASTRO.setText(fornecedor.getPES_MODEL().getPES_CADASTRO());
        edtFOR_ENDERECO.setText(fornecedor.getPES_MODEL().getPES_ENDERECO());
        edtFOR_NUMERO.setText(fornecedor.getPES_MODEL().getPES_NUMERO());
        edtFOR_COMPLEMENTO.setText(fornecedor.getPES_MODEL().getPES_COMPLEMENTO());
        edtFOR_BAIRRO.setText(fornecedor.getPES_MODEL().getPES_BAIRRO());
        edtFOR_CIDADE.setText(fornecedor.getPES_MODEL().getPES_CIDADE());
        comboFOR_UF.setSelectedItem(fornecedor.getPES_MODEL().getPES_UF());
        edtFOR_CEP.setText(fornecedor.getPES_MODEL().getPES_CEP());
        edtFOR_FONE1.setText(fornecedor.getPES_MODEL().getPES_FONE1());
        edtFOR_FONE2.setText(fornecedor.getPES_MODEL().getPES_FONE2());
        edtFOR_CELULAR.setText(fornecedor.getPES_MODEL().getPES_CELULAR());
        edtFOR_SITE.setText(fornecedor.getPES_MODEL().getPES_SITE());
        edtFOR_EMAIL.setText(fornecedor.getPES_MODEL().getPES_EMAIL());
        edtFOR_CONTATO.setText(fornecedor.getFOR_CONTATO());
        comboFOR_ATIVO.setSelectedItem(fornecedor.getPES_MODEL().getPES_ATIVO());

        //funcionalidade do metodo: é um evento que ao selecionar uma opção no JComboBox de PES_FISICA
        //ele deixará o campo ativo ou inativo, util para cadatro de cliente e fornecedor.
      /*  comboFOR_FISICA.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evento) {

                if (comboFOR_FISICA.getSelectedItem().toString().equals("SIM")) {

                    edtFOR_FANTASIA.setEnabled(false);
                    edtFOR_SITE.setEnabled(false);
                        try {                       
                        edtFOR_CNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
                         
                    } catch (java.text.ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Erro " + ex.getMessage());
                    }
                } else if (comboFOR_FISICA.getSelectedItem().toString().equals("NÃO")) {

                    edtFOR_FANTASIA.setEnabled(true);
                    edtFOR_SITE.setEnabled(true);
                    
                    try {                       
                        edtFOR_CNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
                         
                    } catch (java.text.ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Erro " + ex.getMessage());
                    }
                }
            }
        }); */
    }

    private String filtroConsulta() {
        String condicao = "";
        if (!edtCONS_ID1.getText().trim().equals("")) {
            condicao += "(FOR_CODIGO >= " + edtCONS_ID1.getText() + ")";
        }
        if (!edtCONS_ID2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(FOR_CODIGO <= " + edtCONS_ID2.getText() + ")";
        }
        if (!edtCONS_NOME.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(FOR_NOME LIKE ('%" + edtCONS_NOME.getText() + "%'))";
        }
        if (!edtCONS_LOGIN.getText().trim().equals("")) { // não existe metodo de buscar por login
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(CLI_LOGIN LIKE ('%" + edtCONS_LOGIN.getText() + "%'))";
        }
        return condicao;
    }

    private void consultar() {
        try {
            String condicao = filtroConsulta();
            FornecedorController fornecedor = new FornecedorController();
            lista = null;
            lista = fornecedor.consultar(condicao);
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não Existem Fornecedores Cadastrados!");
            } else {
                tabela = new FornecedorTableModel(lista, colunas);
                tblConsulta.setModel(tabela);
                tblConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta do Fornecedor \n" + ex.getMessage());
        }
    }

    private void btnPRIMEIROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRIMEIROActionPerformed
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não Existem Fornecedores Cadastrados!");
        }
        int primeiro = 0;
        mostrarRegistro(primeiro);
    }//GEN-LAST:event_btnPRIMEIROActionPerformed

    private void btnINCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINCLUIRActionPerformed
        limpar();
        setOperacao("incluir");
        edtFOR_NOME.setFocusable(true);
    }//GEN-LAST:event_btnINCLUIRActionPerformed

    private void btnGRAVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAVARActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste Fornecedor?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                
                FornecedorModel objfornecedor = new FornecedorModel();
                PessoaModel objpessoa = new PessoaModel();
                
                objpessoa.setPES_CODIGO(Integer.parseInt(edtPES_CODIGO.getText()));
                objpessoa.setPES_NOME(edtFOR_NOME.getText());
                objpessoa.setPES_FANTASIA(edtFOR_FANTASIA.getText());
                objpessoa.setPES_FISICA(comboFOR_FISICA.getSelectedItem().toString());
                objpessoa.setPES_CPFCNPJ(edtFOR_CNPJ.getText());
                objpessoa.setPES_RGIE(edtFOR_IE.getText());
                objpessoa.setPES_CADASTRO(edtFOR_CADASTRO.getText());
                objpessoa.setPES_ENDERECO(edtFOR_ENDERECO.getText());
                objpessoa.setPES_NUMERO(edtFOR_NUMERO.getText());
                objpessoa.setPES_COMPLEMENTO(edtFOR_COMPLEMENTO.getText());
                objpessoa.setPES_BAIRRO(edtFOR_BAIRRO.getText());
                objpessoa.setPES_CIDADE(edtFOR_CIDADE.getText());
                objpessoa.setPES_UF(comboFOR_UF.getSelectedItem().toString());
                objpessoa.setPES_CEP(edtFOR_CEP.getText());
                objpessoa.setPES_FONE1(edtFOR_FONE1.getText());
                objpessoa.setPES_FONE2(edtFOR_FONE2.getText());
                objpessoa.setPES_CELULAR(edtFOR_CELULAR.getText());
                objpessoa.setPES_SITE(edtFOR_SITE.getText());
                objpessoa.setPES_EMAIL(edtFOR_EMAIL.getText());
                objpessoa.setPES_ATIVO(comboFOR_ATIVO.getSelectedItem().toString());
                objfornecedor.setPES_MODEL(objpessoa);
                
                objfornecedor.setFOR_CODIGO(Integer.parseInt(edtFOR_CODIGO.getText()));
                objfornecedor.setFOR_CONTATO(edtFOR_CONTATO.getText());
                
                FornecedorController fornecedorcontroller = new FornecedorController();
                fornecedorcontroller.gravar(getOperacao(), objfornecedor);
                
                PessoaController pessoacontroller = new PessoaController();
                pessoacontroller.gravar(operacao, objpessoa);
                

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
        edtCONS_LOGIN.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXCLUIRActionPerformed
        setOperacao("");
        if (JOptionPane.showConfirmDialog(null, "Confirma Exclusão deste Registro?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                PessoaModel objpessoa = new PessoaModel(); 
                objpessoa.setPES_CODIGO(Integer.parseInt(edtFOR_CODIGO.getText()));
                objpessoa.setPES_NOME(edtFOR_NOME.getText());
                objpessoa.setPES_FANTASIA(edtFOR_FANTASIA.getText());
                objpessoa.setPES_FISICA(comboFOR_FISICA.getSelectedItem().toString());
                objpessoa.setPES_CPFCNPJ(edtFOR_CNPJ.getText());
                objpessoa.setPES_RGIE(edtFOR_IE.getText());
                objpessoa.setPES_CADASTRO(edtFOR_CADASTRO.getText());
                objpessoa.setPES_ENDERECO(edtFOR_ENDERECO.getText());
                objpessoa.setPES_NUMERO(edtFOR_NUMERO.getText());
                objpessoa.setPES_COMPLEMENTO(edtFOR_COMPLEMENTO.getText());
                objpessoa.setPES_BAIRRO(edtFOR_BAIRRO.getText());
                objpessoa.setPES_CIDADE(edtFOR_CIDADE.getText());
                objpessoa.setPES_UF(comboFOR_UF.getSelectedItem().toString());
                objpessoa.setPES_CEP(edtFOR_CEP.getText());
                objpessoa.setPES_FONE1(edtFOR_FONE1.getText());
                objpessoa.setPES_FONE2(edtFOR_FONE2.getText());
                objpessoa.setPES_CELULAR(edtFOR_CELULAR.getText());
                objpessoa.setPES_EMAIL(edtFOR_EMAIL.getText());
                objpessoa.setPES_SITE(edtFOR_SITE.getText());
                objpessoa.setPES_ATIVO(comboFOR_ATIVO.getSelectedItem().toString());
                
                 FornecedorModel objfornecedor = new FornecedorModel();
                 objfornecedor.setFOR_CODIGO(Integer.parseInt(edtFOR_CODIGO.getText()));
                 objfornecedor.setFOR_CONTATO(edtFOR_CONTATO.getText());
                 objfornecedor.setPES_MODEL(objpessoa);
                
                
                FornecedorController fornecedorcontroller = new FornecedorController();
                fornecedorcontroller.excluir(objfornecedor);

                JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso");
                consultar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnEXCLUIRActionPerformed

    private void edtFOR_NOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtFOR_NOMEActionPerformed

    }//GEN-LAST:event_edtFOR_NOMEActionPerformed

    private void edtFOR_ENDERECOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtFOR_ENDERECOActionPerformed

    }//GEN-LAST:event_edtFOR_ENDERECOActionPerformed

    private void edtFOR_NUMEROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtFOR_NUMEROActionPerformed

    }//GEN-LAST:event_edtFOR_NUMEROActionPerformed

    private void edtFOR_COMPLEMENTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtFOR_COMPLEMENTOActionPerformed

    }//GEN-LAST:event_edtFOR_COMPLEMENTOActionPerformed

    private void edtFOR_BAIRROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtFOR_BAIRROActionPerformed

    }//GEN-LAST:event_edtFOR_BAIRROActionPerformed

    private void edtFOR_CIDADEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtFOR_CIDADEActionPerformed
  
    }//GEN-LAST:event_edtFOR_CIDADEActionPerformed

    private void edtFOR_EMAILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtFOR_EMAILActionPerformed

    }//GEN-LAST:event_edtFOR_EMAILActionPerformed

    private void edtFOR_FANTASIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtFOR_FANTASIAActionPerformed
     
    }//GEN-LAST:event_edtFOR_FANTASIAActionPerformed

    private void edtFOR_SITEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtFOR_SITEActionPerformed

    }//GEN-LAST:event_edtFOR_SITEActionPerformed

    private void edtFOR_CONTATOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtFOR_CONTATOActionPerformed
   
    }//GEN-LAST:event_edtFOR_CONTATOActionPerformed

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
    private javax.swing.JComboBox<String> comboFOR_ATIVO;
    private javax.swing.JComboBox<String> comboFOR_FISICA;
    private javax.swing.JComboBox<String> comboFOR_UF;
    private javax.swing.JTextField edtCONS_ID1;
    private javax.swing.JTextField edtCONS_ID2;
    private javax.swing.JTextField edtCONS_LOGIN;
    private javax.swing.JTextField edtCONS_NOME;
    private javax.swing.JTextField edtFOR_BAIRRO;
    private javax.swing.JFormattedTextField edtFOR_CADASTRO;
    private javax.swing.JFormattedTextField edtFOR_CELULAR;
    private javax.swing.JFormattedTextField edtFOR_CEP;
    private javax.swing.JTextField edtFOR_CIDADE;
    private javax.swing.JFormattedTextField edtFOR_CNPJ;
    private javax.swing.JTextField edtFOR_CODIGO;
    private javax.swing.JTextField edtFOR_COMPLEMENTO;
    private javax.swing.JTextField edtFOR_CONTATO;
    private javax.swing.JTextField edtFOR_EMAIL;
    private javax.swing.JTextField edtFOR_ENDERECO;
    private javax.swing.JTextField edtFOR_FANTASIA;
    private javax.swing.JFormattedTextField edtFOR_FONE1;
    private javax.swing.JFormattedTextField edtFOR_FONE2;
    private javax.swing.JFormattedTextField edtFOR_IE;
    private javax.swing.JTextField edtFOR_NOME;
    private javax.swing.JTextField edtFOR_NUMERO;
    private javax.swing.JTextField edtFOR_SITE;
    private javax.swing.JTextField edtPES_CODIGO;
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
    private javax.swing.JLabel lblCLI_IE;
    private javax.swing.JLabel lblCONS_ID;
    private javax.swing.JLabel lblCONS_LOGIN;
    private javax.swing.JLabel lblCONS_NOME;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JLabel lblFORI_FONE1;
    private javax.swing.JLabel lblFORI_UF;
    private javax.swing.JLabel lblFOR_ATIVO;
    private javax.swing.JLabel lblFOR_BAIRRO;
    private javax.swing.JLabel lblFOR_CADASTRO;
    private javax.swing.JLabel lblFOR_CELULAR;
    private javax.swing.JLabel lblFOR_CEP;
    private javax.swing.JLabel lblFOR_CIDADE;
    private javax.swing.JLabel lblFOR_CNPJ;
    private javax.swing.JLabel lblFOR_CODIGO;
    private javax.swing.JLabel lblFOR_COMPLEMENTO;
    private javax.swing.JLabel lblFOR_CONTATO;
    private javax.swing.JLabel lblFOR_EMAIL;
    private javax.swing.JLabel lblFOR_ENDERECO;
    private javax.swing.JLabel lblFOR_FANTASIA;
    private javax.swing.JLabel lblFOR_FISICA;
    private javax.swing.JLabel lblFOR_FONE2;
    private javax.swing.JLabel lblFOR_NOME;
    private javax.swing.JLabel lblFOR_NUMERO;
    private javax.swing.JLabel lblFOR_SITE;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelCONSULTA;
    private javax.swing.JPanel painelDADOS;
    private javax.swing.JTable tblConsulta;
    // End of variables declaration//GEN-END:variables
}
