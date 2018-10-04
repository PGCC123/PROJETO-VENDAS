package trabalho.view;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import trabalho.controller.PessoaController;
import trabalho.model.PessoaModel;

public class PessoaView extends IMenu {

    private String operacao;
    private String colunas[] = {"CÓDIGO", "NOME", "FÍSICA", "CPF/CNPJ", "ENDERECO", "NÚMERO", "BAIRRO", "CIDADE", "UF", "CELULAR", "ATIVO"};
    // esse objeto será vinculado com a tabela
    // selecione o objeto tabela, PESque em PROPRIEDADES e encontre MODEL
    // no combo "Definir Propriedades" escolha "Código Personalizado"
    // digite o objeto DefaultTableModel, neste exemplo é tabela(criado logo abaixo)
    private ArrayList<PessoaModel> lista;
    private PessoaTableModel tabela;

    private String getOperacao() {
        return operacao;
    }

    private void setOperacao(String operacao) {
        Boolean ativar = (operacao.equals("") ? false : true);
        // operacao=""(consulta), operacao="incluir"(inclusão), operacao="alterar"(alteração)
        this.operacao = operacao;
        btnGRAVAR.setEnabled(ativar);
    }

    public PessoaView() {
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
        lblPES_CODIGO = new javax.swing.JLabel();
        lblPES_NOME = new javax.swing.JLabel();
        edtPES_CODIGO = new javax.swing.JTextField();
        edtPES_NOME = new javax.swing.JTextField();
        lblPES_ATIVO = new javax.swing.JLabel();
        comboPES_ATIVO = new javax.swing.JComboBox<>();
        lblPES_CADASTRO = new javax.swing.JLabel();
        edtPES_CPFCNPJ = new javax.swing.JFormattedTextField();
        lblPES_FISICA = new javax.swing.JLabel();
        comboPES_FISICA = new javax.swing.JComboBox<>();
        lblPES_CPFCNPJ = new javax.swing.JLabel();
        textPES_CADASTRO = new javax.swing.JFormattedTextField();
        lblPES_RGIE = new javax.swing.JLabel();
        textPES_RGIE = new javax.swing.JFormattedTextField();
        lblPES_FANTASIA = new javax.swing.JLabel();
        edtPES_FANTASIA = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblPES_ENDERECO = new javax.swing.JLabel();
        edtPES_ENDERECO = new javax.swing.JTextField();
        lblPES_NUMERO = new javax.swing.JLabel();
        edtPES_NUMERO = new javax.swing.JTextField();
        lblPES_COMPLEMENTO = new javax.swing.JLabel();
        edtPES_COMPLEMENTO = new javax.swing.JTextField();
        lblPES_BAIRRO = new javax.swing.JLabel();
        edtPES_BAIRRO = new javax.swing.JTextField();
        lblPES_CIDADE = new javax.swing.JLabel();
        edtPES_CIDADE = new javax.swing.JTextField();
        lblPES_UF = new javax.swing.JLabel();
        comboPES_UF = new javax.swing.JComboBox<>();
        lblPES_CEP = new javax.swing.JLabel();
        textPES_CEP = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        lblPES_FONE1 = new javax.swing.JLabel();
        lblPES_FONE2 = new javax.swing.JLabel();
        textPES_FONE1 = new javax.swing.JFormattedTextField();
        textPES_FONE2 = new javax.swing.JFormattedTextField();
        lblPES_CELULAR = new javax.swing.JLabel();
        textPES_CELULAR = new javax.swing.JFormattedTextField();
        lblPES_EMAIL = new javax.swing.JLabel();
        edtPES_EMAIL = new javax.swing.JTextField();
        lblPES_SITE = new javax.swing.JLabel();
        edtPES_SITE = new javax.swing.JTextField();
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
        btnSAIR.setText("Sair");
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
        lblTitulo.setText("Cadastro de Clientes");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(560, 90, 260, 29);

        lblPES_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_CODIGO.setText("Código");

        lblPES_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_NOME.setText("Nome");

        edtPES_CODIGO.setEditable(false);
        edtPES_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtPES_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPES_NOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPES_NOMEActionPerformed(evt);
            }
        });

        lblPES_ATIVO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_ATIVO.setText("Ativo? ");

        comboPES_ATIVO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboPES_ATIVO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATIVO", "INATIVO" }));

        lblPES_CADASTRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_CADASTRO.setText("Cadastro");

        try {
            edtPES_CPFCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblPES_FISICA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_FISICA.setText("Física?");

        comboPES_FISICA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboPES_FISICA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIM", "NÃO" }));

        lblPES_CPFCNPJ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_CPFCNPJ.setText("CPF/CNPJ");

        try {
            textPES_CADASTRO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblPES_RGIE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_RGIE.setText("RG/IE");

        try {
            textPES_RGIE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblPES_FANTASIA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_FANTASIA.setText("Fantasia");

        edtPES_FANTASIA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPES_FANTASIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPES_FANTASIAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDADOSLayout = new javax.swing.GroupLayout(painelDADOS);
        painelDADOS.setLayout(painelDADOSLayout);
        painelDADOSLayout.setHorizontalGroup(
            painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDADOSLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPES_NOME, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPES_CODIGO, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPES_FANTASIA, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPES_CPFCNPJ, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPES_RGIE, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelDADOSLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtPES_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtPES_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(edtPES_FANTASIA, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textPES_RGIE, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtPES_CPFCNPJ, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPES_FISICA)
                    .addComponent(lblPES_ATIVO)
                    .addComponent(lblPES_CADASTRO))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDADOSLayout.createSequentialGroup()
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboPES_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPES_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(290, 290, 290))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addComponent(textPES_CADASTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
        );
        painelDADOSLayout.setVerticalGroup(
            painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDADOSLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtPES_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPES_CODIGO)
                    .addComponent(lblPES_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPES_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtPES_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPES_NOME)
                    .addComponent(lblPES_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPES_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPES_FANTASIA)
                    .addComponent(edtPES_FANTASIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPES_CADASTRO)
                    .addComponent(textPES_CADASTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPES_CPFCNPJ)
                    .addComponent(edtPES_CPFCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPES_RGIE)
                    .addComponent(textPES_RGIE, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados Pessoais", painelDADOS);

        lblPES_ENDERECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_ENDERECO.setText("Endereço");

        edtPES_ENDERECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPES_ENDERECO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPES_ENDERECOActionPerformed(evt);
            }
        });

        lblPES_NUMERO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_NUMERO.setText("N°");

        edtPES_NUMERO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPES_NUMERO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPES_NUMEROActionPerformed(evt);
            }
        });

        lblPES_COMPLEMENTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_COMPLEMENTO.setText("Complemento");

        edtPES_COMPLEMENTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPES_COMPLEMENTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPES_COMPLEMENTOActionPerformed(evt);
            }
        });

        lblPES_BAIRRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_BAIRRO.setText("Bairro");

        edtPES_BAIRRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPES_BAIRRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPES_BAIRROActionPerformed(evt);
            }
        });

        lblPES_CIDADE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_CIDADE.setText("Cidade");

        edtPES_CIDADE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPES_CIDADE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPES_CIDADEActionPerformed(evt);
            }
        });

        lblPES_UF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_UF.setText("UF");

        comboPES_UF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboPES_UF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SP", "RJ", "ES", " " }));

        lblPES_CEP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_CEP.setText("CEP");

        try {
            textPES_CEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblPES_ENDERECO)
                        .addGap(18, 18, 18)
                        .addComponent(edtPES_ENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPES_NUMERO)
                        .addGap(10, 10, 10)
                        .addComponent(edtPES_NUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPES_BAIRRO)
                            .addComponent(lblPES_COMPLEMENTO)
                            .addComponent(lblPES_CIDADE)
                            .addComponent(lblPES_CEP))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(edtPES_CIDADE, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(edtPES_COMPLEMENTO, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(textPES_CEP))
                                .addGap(18, 18, 18)
                                .addComponent(lblPES_UF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboPES_UF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edtPES_BAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(451, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPES_ENDERECO)
                    .addComponent(edtPES_ENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPES_NUMERO)
                    .addComponent(edtPES_NUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtPES_BAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPES_BAIRRO))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPES_COMPLEMENTO)
                    .addComponent(edtPES_COMPLEMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPES_CIDADE)
                    .addComponent(edtPES_CIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPES_UF)
                    .addComponent(comboPES_UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPES_CEP)
                    .addComponent(textPES_CEP, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Endereço", jPanel1);

        lblPES_FONE1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_FONE1.setText("Telefone 1");

        lblPES_FONE2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_FONE2.setText("Telefone 2");

        try {
            textPES_FONE1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            textPES_FONE2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblPES_CELULAR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_CELULAR.setText("Celular");

        try {
            textPES_CELULAR.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) 9####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblPES_EMAIL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_EMAIL.setText("E-mail");

        edtPES_EMAIL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPES_EMAIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPES_EMAILActionPerformed(evt);
            }
        });

        lblPES_SITE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPES_SITE.setText("Site");

        edtPES_SITE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPES_SITE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPES_SITEActionPerformed(evt);
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
                        .addComponent(lblPES_FONE1)
                        .addGap(18, 18, 18)
                        .addComponent(textPES_FONE1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPES_CELULAR)
                            .addComponent(lblPES_FONE2)
                            .addComponent(lblPES_EMAIL)
                            .addComponent(lblPES_SITE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textPES_FONE2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPES_CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtPES_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtPES_SITE, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(493, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPES_FONE1)
                    .addComponent(textPES_FONE1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPES_FONE2)
                    .addComponent(textPES_FONE2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPES_CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPES_CELULAR))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPES_EMAIL)
                    .addComponent(edtPES_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPES_SITE)
                    .addComponent(edtPES_SITE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Consulta", painelCONSULTA);

        getContentPane().add(jTabbedPane2);
        jTabbedPane2.setBounds(20, 380, 1260, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpar() {
        edtPES_CODIGO.setText("0");
        edtPES_NOME.setText("");
        edtPES_FANTASIA.setText("");
        edtPES_CPFCNPJ.setText("");
        textPES_RGIE.setText("");
        textPES_CADASTRO.setText("");
        edtPES_ENDERECO.setText("");
        edtPES_NUMERO.setText("");
        edtPES_COMPLEMENTO.setText("");
        edtPES_BAIRRO.setText("");
        edtPES_CIDADE.setText("");
        textPES_CEP.setText("");
        textPES_FONE1.setText("");
        textPES_FONE2.setText("");
        textPES_CELULAR.setText("");
        edtPES_SITE.setText("");
        edtPES_EMAIL.setText("");

    }

    private void mostrar(PessoaModel pessoa) {
        edtPES_CODIGO.setText(String.valueOf(pessoa.getPES_CODIGO()));
        edtPES_NOME.setText(pessoa.getPES_NOME());
        edtPES_FANTASIA.setText(pessoa.getPES_FANTASIA());
        comboPES_FISICA.setSelectedItem(pessoa.getPES_FISICA());
        edtPES_CPFCNPJ.setText(pessoa.getPES_CPFCNPJ());
        textPES_RGIE.setText(pessoa.getPES_RGIE());
        textPES_CADASTRO.setText(pessoa.getPES_CADASTRO());
        edtPES_ENDERECO.setText(pessoa.getPES_ENDERECO());
        edtPES_NUMERO.setText(pessoa.getPES_NUMERO());
        edtPES_COMPLEMENTO.setText(pessoa.getPES_COMPLEMENTO());
        edtPES_BAIRRO.setText(pessoa.getPES_BAIRRO());
        edtPES_CIDADE.setText(pessoa.getPES_CIDADE());
        comboPES_UF.setSelectedItem(pessoa.getPES_UF());
        textPES_CEP.setText(pessoa.getPES_CEP());
        textPES_FONE1.setText(pessoa.getPES_FONE1());
        textPES_FONE2.setText(pessoa.getPES_FONE2());
        textPES_CELULAR.setText(pessoa.getPES_CELULAR());
        edtPES_EMAIL.setText(pessoa.getPES_EMAIL());
        edtPES_SITE.setText(pessoa.getPES_SITE());
        comboPES_ATIVO.setSelectedItem(pessoa.getPES_ATIVO());
    }

    private String filtroConsulta() {
        String condicao = "";
        if (!edtCONS_ID1.getText().trim().equals("")) {
            condicao += "(PES_CODIGO >= " + edtCONS_ID1.getText() + ")";
        }
        if (!edtCONS_ID2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(PES_CODIGO <= " + edtCONS_ID2.getText() + ")";
        }
        if (!edtCONS_NOME.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(PES_NOME LIKE ('%" + edtCONS_NOME.getText() + "%'))";
        }
        if (!edtCONS_LOGIN.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(PES_LOGIN LIKE ('%" + edtCONS_LOGIN.getText() + "%'))";
        }
        return condicao;
    }

    private void consultar() {
        try {
            String condicao = filtroConsulta();
            PessoaController pessoa = new PessoaController();
            lista = null;
            lista = pessoa.consultar(condicao);
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não Existem PESentes Cadastrados!");
            } else {
                tabela = new PessoaTableModel(lista, colunas);
                tblConsulta.setModel(tabela);
                tblConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta do Usuário \n" + ex.getMessage());
        }
    }

    private void btnPRIMEIROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRIMEIROActionPerformed
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não Existem PESentes Cadastrados!");
        }
        int primeiro = 0;
        mostrarRegistro(primeiro);
    }//GEN-LAST:event_btnPRIMEIROActionPerformed

    private void btnINCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINCLUIRActionPerformed
        limpar();
        setOperacao("incluir");
        edtPES_NOME.setFocusable(true);
        
    }//GEN-LAST:event_btnINCLUIRActionPerformed

    private void btnGRAVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAVARActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste PESente?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                PessoaModel objpessoa = new PessoaModel();
                objpessoa.setPES_CODIGO(Integer.parseInt(edtPES_CODIGO.getText()));
                objpessoa.setPES_NOME(edtPES_NOME.getText());
                objpessoa.setPES_FANTASIA(edtPES_FANTASIA.getText());
                objpessoa.setPES_CPFCNPJ(edtPES_CPFCNPJ.getText());
                objpessoa.setPES_RGIE(textPES_RGIE.getText());
                objpessoa.setPES_FISICA(comboPES_FISICA.getSelectedItem().toString());
                objpessoa.setPES_CADASTRO(textPES_CADASTRO.getText());
                objpessoa.setPES_ENDERECO(edtPES_ENDERECO.getText());
                objpessoa.setPES_NUMERO(edtPES_NUMERO.getText());
                objpessoa.setPES_COMPLEMENTO(edtPES_COMPLEMENTO.getText());
                objpessoa.setPES_BAIRRO(edtPES_BAIRRO.getText());
                objpessoa.setPES_CIDADE(edtPES_CIDADE.getText());
                objpessoa.setPES_UF(comboPES_UF.getSelectedItem().toString());
                objpessoa.setPES_CEP(textPES_CEP.getText());
                objpessoa.setPES_FONE1(textPES_FONE1.getText());
                objpessoa.setPES_FONE2(textPES_FONE2.getText());
                objpessoa.setPES_CELULAR(textPES_CELULAR.getText());
                objpessoa.setPES_SITE(edtPES_SITE.getText());
                objpessoa.setPES_EMAIL(edtPES_EMAIL.getText());
                objpessoa.setPES_ATIVO(comboPES_ATIVO.getSelectedItem().toString());

                PessoaController pessoacontroller = new PessoaController();
                pessoacontroller.gravar(getOperacao(), objpessoa);

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
        int sair = JOptionPane.showConfirmDialog(null, "Deseja realizar logoff?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_NO_OPTION) {
            
            dispose();
            LoginView loginview = new LoginView();
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
                objpessoa.setPES_CODIGO(Integer.parseInt(edtPES_CODIGO.getText()));
                objpessoa.setPES_NOME(edtPES_NOME.getText());
                objpessoa.setPES_FANTASIA(edtPES_FANTASIA.getText());
                objpessoa.setPES_CPFCNPJ(edtPES_CPFCNPJ.getText());
                objpessoa.setPES_RGIE(textPES_RGIE.getText());
                objpessoa.setPES_FISICA(comboPES_FISICA.getSelectedItem().toString());
                objpessoa.setPES_CADASTRO(textPES_CADASTRO.getText());
                objpessoa.setPES_ENDERECO(edtPES_ENDERECO.getText());
                objpessoa.setPES_NUMERO(edtPES_NUMERO.getText());
                objpessoa.setPES_COMPLEMENTO(edtPES_COMPLEMENTO.getText());
                objpessoa.setPES_BAIRRO(edtPES_BAIRRO.getText());
                objpessoa.setPES_CIDADE(edtPES_CIDADE.getText());
                objpessoa.setPES_UF(comboPES_UF.getSelectedItem().toString());
                objpessoa.setPES_CEP(textPES_CEP.getText());
                objpessoa.setPES_FONE1(textPES_FONE1.getText());
                objpessoa.setPES_FONE2(textPES_FONE2.getText());
                objpessoa.setPES_CELULAR(textPES_CELULAR.getText());
                objpessoa.setPES_SITE(edtPES_SITE.getText());
                objpessoa.setPES_EMAIL(edtPES_EMAIL.getText());
                objpessoa.setPES_ATIVO(comboPES_ATIVO.getSelectedItem().toString());

                PessoaController pessoacontroller = new PessoaController();
                pessoacontroller.excluir(objpessoa);

                JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso");
                consultar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnEXCLUIRActionPerformed

    private void edtPES_NOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPES_NOMEActionPerformed

    }//GEN-LAST:event_edtPES_NOMEActionPerformed

    private void edtPES_FANTASIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPES_FANTASIAActionPerformed

    }//GEN-LAST:event_edtPES_FANTASIAActionPerformed

    private void edtPES_ENDERECOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPES_ENDERECOActionPerformed

    }//GEN-LAST:event_edtPES_ENDERECOActionPerformed

    private void edtPES_NUMEROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPES_NUMEROActionPerformed

    }//GEN-LAST:event_edtPES_NUMEROActionPerformed

    private void edtPES_COMPLEMENTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPES_COMPLEMENTOActionPerformed

    }//GEN-LAST:event_edtPES_COMPLEMENTOActionPerformed

    private void edtPES_BAIRROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPES_BAIRROActionPerformed

    }//GEN-LAST:event_edtPES_BAIRROActionPerformed

    private void edtPES_CIDADEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPES_CIDADEActionPerformed

    }//GEN-LAST:event_edtPES_CIDADEActionPerformed

    private void edtPES_EMAILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPES_EMAILActionPerformed

    }//GEN-LAST:event_edtPES_EMAILActionPerformed

    private void edtPES_SITEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPES_SITEActionPerformed
    
    }//GEN-LAST:event_edtPES_SITEActionPerformed

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
    private javax.swing.JComboBox<String> comboPES_ATIVO;
    private javax.swing.JComboBox<String> comboPES_FISICA;
    private javax.swing.JComboBox<String> comboPES_UF;
    private javax.swing.JTextField edtCONS_ID1;
    private javax.swing.JTextField edtCONS_ID2;
    private javax.swing.JTextField edtCONS_LOGIN;
    private javax.swing.JTextField edtCONS_NOME;
    private javax.swing.JTextField edtPES_BAIRRO;
    private javax.swing.JTextField edtPES_CIDADE;
    private javax.swing.JTextField edtPES_CODIGO;
    private javax.swing.JTextField edtPES_COMPLEMENTO;
    private javax.swing.JFormattedTextField edtPES_CPFCNPJ;
    private javax.swing.JTextField edtPES_EMAIL;
    private javax.swing.JTextField edtPES_ENDERECO;
    private javax.swing.JTextField edtPES_FANTASIA;
    private javax.swing.JTextField edtPES_NOME;
    private javax.swing.JTextField edtPES_NUMERO;
    private javax.swing.JTextField edtPES_SITE;
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
    private javax.swing.JLabel lblCONS_LOGIN;
    private javax.swing.JLabel lblCONS_NOME;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JLabel lblPES_ATIVO;
    private javax.swing.JLabel lblPES_BAIRRO;
    private javax.swing.JLabel lblPES_CADASTRO;
    private javax.swing.JLabel lblPES_CELULAR;
    private javax.swing.JLabel lblPES_CEP;
    private javax.swing.JLabel lblPES_CIDADE;
    private javax.swing.JLabel lblPES_CODIGO;
    private javax.swing.JLabel lblPES_COMPLEMENTO;
    private javax.swing.JLabel lblPES_CPFCNPJ;
    private javax.swing.JLabel lblPES_EMAIL;
    private javax.swing.JLabel lblPES_ENDERECO;
    private javax.swing.JLabel lblPES_FANTASIA;
    private javax.swing.JLabel lblPES_FISICA;
    private javax.swing.JLabel lblPES_FONE1;
    private javax.swing.JLabel lblPES_FONE2;
    private javax.swing.JLabel lblPES_NOME;
    private javax.swing.JLabel lblPES_NUMERO;
    private javax.swing.JLabel lblPES_RGIE;
    private javax.swing.JLabel lblPES_SITE;
    private javax.swing.JLabel lblPES_UF;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelCONSULTA;
    private javax.swing.JPanel painelDADOS;
    private javax.swing.JTable tblConsulta;
    private javax.swing.JFormattedTextField textPES_CADASTRO;
    private javax.swing.JFormattedTextField textPES_CELULAR;
    private javax.swing.JFormattedTextField textPES_CEP;
    private javax.swing.JFormattedTextField textPES_FONE1;
    private javax.swing.JFormattedTextField textPES_FONE2;
    private javax.swing.JFormattedTextField textPES_RGIE;
    // End of variables declaration//GEN-END:variables
}
