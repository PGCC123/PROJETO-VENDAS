package trabalho.view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import trabalho.conexao.Conexao;
import trabalho.controller.ClienteController;
import trabalho.controller.ProdutoController;
import trabalho.controller.UsuarioController;
import trabalho.controller.VendaController;
import trabalho.controller.VendaProdutoController;
import trabalho.dao.VendaDao;
import trabalho.model.ClienteModel;
import trabalho.model.ProdutoModel;
import trabalho.model.UsuarioModel;
import trabalho.model.VendaModel;
import trabalho.model.VendaProdutoModel;

public class VendaView extends IMenu {

    private final String colunasCli[] = {"CÓDIGO", "NOME", "CPF", "LIMITE DE CRÉDITO", "ATIVO"};
    private final String colunasPro[] = {"CÓDIGO", "NOME", "ESTOQUE", "PREÇO", "ATIVO"};
    private final String colunasUsu[] = {"CÓDIGO", "NOME", "LOGIN", "ATIVO"};
    private final String colunasItens[] = {"CÓDIGO", "NOME", "QUANTIDADE", "PREÇO", "DESCONTO", "TOTAL"}; // MOSTRANDO DA TABELA TABLE VENDA PRDUTO.
    private int flag;
    private float pro_preco;
    private String operacao;

    private String getOperacao() {
        return operacao;
    }

    private void setOperacao(String operacao) {
        Boolean ativar = (operacao.equals("") ? false : true);
        // operacao=""(consulta), operacao="incluir"(inclusão), operacao="alterar"(alteração)
        this.operacao = operacao;
        btnGRAVAR.setEnabled(ativar);
    }
    // esse objeto será vinculado com a tabela
    // selecione o objeto tabela, clique em PROPRIEDADES e encontre MODEL
    // no combo "Definir Propriedades" escolha "Código Personalizado"
    // digite o objeto DefaultTableModel, neste exemplo é tabela(criado logo abaixo)
    private ArrayList<ClienteModel> listaCli;
    private ArrayList<ProdutoModel> listaPro;
    private ArrayList<ProdutoModel> listaProPreco;
    private ArrayList<UsuarioModel> listaUsu;
    private ArrayList<VendaModel> lista;
    private ArrayList<VendaProdutoModel> listaVendaProduto;
    private TableModelCli tabelacli;
    private TableModelPro tabelaPro;
    private TableModelUsu tabelaUsu;
    private VendaProdutoTableModel tabelaVendaProdutoModel;

    public VendaView() {
        this.setPreferredSize(new Dimension(1300, 700));
        initComponents();
        //setOperacao(""); // inicializa o form no modo CONSULTA
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }

    private String filtroConsultaCli() {
        String condicao = "";
        if (!edtCLI_CODIGO.getText().trim().equals("")) {
            condicao += "(CLI_CODIGO = " + edtCLI_CODIGO.getText() + ")";
        }
        return condicao;
    }

    private String filtroConsultaPro() {
        String condicao = "";
        if (!edtPRO_CODIGO.getText().trim().equals("")) {
            condicao += "(PRO_CODIGO = " + edtPRO_CODIGO.getText() + " )";
        }
        return condicao;
    }

    private String filtroConsultaUsu() {
        String condicao = "";
        if (!edtUSU_CODIGO.getText().trim().equals("")) {
            condicao += "(USU_CODIGO = " + edtUSU_CODIGO.getText() + " )";
        }
        return condicao;
    }

    private String filtroConsultaItensVenda() {
        String condicao = "";
        if (!edtVDA_CODIGO.getText().trim().equals("")) {
            condicao += "(VDA.VDA_CODIGO = " + edtVDA_CODIGO.getText() + ")";
        }
        return condicao;
    }

    private String filtroConsultaSubTotal() {
        String condicao = "";
        if (!edtVDA_CODIGO.getText().trim().equals("")) {
            condicao += "(VDA_CODIGO = " + edtVDA_CODIGO.getText() + ")";
        }
        return condicao;
    }

    private void limpar() {
        edtVDA_CODIGO.setText("0");
        edtCLI_NOME.setText("");
        edtUSU_NOME.setText("");
        edtPRO_NOME.setText("");
        edtCLI_CODIGO.setText("");
        edtUSU_CODIGO.setText("");
        edtPRO_CODIGO.setText("");
        edtPRO_QTDE.setText("");
        edtPRO_PRECO.setText("");
    }

    private void mostrar(VendaModel venda) {
        edtVDA_CODIGO.setText(String.valueOf(venda.getVDA_CODIGO()));
        edtCLI_NOME.setText(venda.getCLI_MODEL().getPessoamodel().getPES_NOME());
        edtUSU_NOME.setText((venda.getUSU_MODEL().getUSU_NOME()));
        //edtPRO_NOME.setText(vendapro.getPRO_MODEL().getPRO_NOME());
        //edtPRO_PRECO.setText(String.valueOf(vendapro.getPRO_MODEL().getPRO_PRECO()));
    }

    private void mostrarRegistro(int registro) {
        if (registro >= 0 && registro < lista.size()) {
            // exibe os dados do registro na aba Dados
            mostrar(lista.get(registro));

            // posicionar o registro selecionado na tabela (JTable)
            // tblConsulta.changeSelection(registro, 0, false, false);
        }
    }

    //botão "ok" dos produtos
    private void adcVendaPro() {
        if (JOptionPane.showConfirmDialog(null, "Adicionar esse produto na venda?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {

                VendaProdutoModel vendaprodutomodel = new VendaProdutoModel();
                VendaModel vendamodel = new VendaModel();
                ProdutoModel produtomodel = new ProdutoModel();

                vendamodel.setVDA_CODIGO(Integer.parseInt(edtVDA_CODIGO.getText()));
                produtomodel.setPRO_CODIGO(Integer.parseInt(edtPRO_CODIGO.getText()));
                vendaprodutomodel.setVEP_QTDE(Integer.parseInt(edtPRO_QTDE.getText()));
                vendaprodutomodel.setVEP_PRECO(Double.parseDouble(edtPRO_PRECO.getText()));
                vendaprodutomodel.setVEP_DESCONTO(Double.parseDouble(edtPRO_DESCONTO.getText()));
                ///vendaprodutomodel.setVEP_TOTAL(Double.parseDouble(edtVDA_VALOR.getText()));

                vendaprodutomodel.setVDA_MODEL(vendamodel);
                vendaprodutomodel.setPRO_MODEL(produtomodel);

                VendaProdutoController vendaprodutocontroller = new VendaProdutoController();
                vendaprodutocontroller.adicionar(vendaprodutomodel);

                JOptionPane.showMessageDialog(null, "Produto adicionado!");

                edtPRO_CODIGO.setText("");
                edtPRO_QTDE.setText("");
                edtPRO_PRECO.setText("");
                edtPRO_NOME.setText("");
                edtPRO_DESCONTO.setText("0");

            } catch (HeadlessException | NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao adicionar o produto. \n" + ex.getMessage());
            }
        }
    }

    public void subTotal() {
        try {
            String condicao = filtroConsultaSubTotal();
            VendaProdutoController vendaprodutocontroller = new VendaProdutoController();
            listaVendaProduto = null;
            listaVendaProduto = vendaprodutocontroller.consultarSubTotal(condicao);

            if (listaVendaProduto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não existem itens inseridos!");
            } else {
                edtVDA_TOTAL.setText(String.valueOf(listaVendaProduto.get(0).getVEP_TOTAL()));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta dos produtos!\n" + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        edtVDA_CODIGO = new javax.swing.JTextField();
        lblVDA_CODIGO = new javax.swing.JLabel();
        lblUSU_CODIGO = new javax.swing.JLabel();
        edtUSU_CODIGO = new javax.swing.JTextField();
        btnPESQUISA_USUARIO = new javax.swing.JButton();
        btnPESQUISA_CLIENTE = new javax.swing.JButton();
        edtCLI_CODIGO = new javax.swing.JTextField();
        lblPRO_CODIGO = new javax.swing.JLabel();
        btnPESQUISA_PRODUTO = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TABLE_CADASTRO = new javax.swing.JTable();
        edtPRO_CODIGO = new javax.swing.JTextField();
        edtUSU_NOME = new javax.swing.JTextField();
        edtPRO_NOME = new javax.swing.JTextField();
        edtCLI_NOME = new javax.swing.JTextField();
        lblPRO_QTD = new javax.swing.JLabel();
        edtPRO_QTDE = new javax.swing.JTextField();
        lblPRO_PRECO = new javax.swing.JLabel();
        edtPRO_PRECO = new javax.swing.JTextField();
        lblPRO_DESCONTO = new javax.swing.JLabel();
        edtPRO_DESCONTO = new javax.swing.JTextField();
        btnADICIONA_PRODUTO = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TABLE_ITEMVENDA = new javax.swing.JTable();
        lblTITULO = new javax.swing.JLabel();
        btnNOVA_VENDA = new javax.swing.JButton();
        btnCONFIRMA_CLIENTE_USUARIO = new javax.swing.JButton();
        edtVDA_VALOR = new javax.swing.JTextField();
        lblVDA_VALOR = new javax.swing.JLabel();
        edtVDA_DESCONTO = new javax.swing.JTextField();
        lblVDA_DESCONTO = new javax.swing.JLabel();
        lblVDA_TOTAL = new javax.swing.JLabel();
        edtVDA_TOTAL = new javax.swing.JTextField();
        separadorCENTRAL = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        TABLE_PRODUTO = new javax.swing.JTable();
        lblTitulo1 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        lblCLI_CODIGO.setText("Cód do Cliente");

        edtVDA_CODIGO.setEditable(false);
        edtVDA_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblVDA_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblVDA_CODIGO.setText("Código");

        lblUSU_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUSU_CODIGO.setText("Cód do Usuário");

        edtUSU_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtUSU_CODIGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtUSU_CODIGOActionPerformed(evt);
            }
        });

        btnPESQUISA_USUARIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconePesquisa.png"))); // NOI18N
        btnPESQUISA_USUARIO.setText("Busca");
        btnPESQUISA_USUARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPESQUISA_USUARIOActionPerformed(evt);
            }
        });

        btnPESQUISA_CLIENTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconePesquisa.png"))); // NOI18N
        btnPESQUISA_CLIENTE.setText("Busca");
        btnPESQUISA_CLIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPESQUISA_CLIENTEActionPerformed(evt);
            }
        });

        edtCLI_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCLI_CODIGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCLI_CODIGOActionPerformed(evt);
            }
        });

        lblPRO_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_CODIGO.setText("Cód do Produto");

        btnPESQUISA_PRODUTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconePesquisa.png"))); // NOI18N
        btnPESQUISA_PRODUTO.setText("Busca");
        btnPESQUISA_PRODUTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPESQUISA_PRODUTOActionPerformed(evt);
            }
        });

        TABLE_CADASTRO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TABLE_CADASTRO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLE_CADASTROMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TABLE_CADASTRO);

        edtPRO_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_CODIGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_CODIGOActionPerformed(evt);
            }
        });

        edtUSU_NOME.setEditable(false);
        edtUSU_NOME.setOpaque(false);
        edtUSU_NOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtUSU_NOMEActionPerformed(evt);
            }
        });

        edtPRO_NOME.setEditable(false);
        edtPRO_NOME.setForeground(new java.awt.Color(204, 0, 0));
        edtPRO_NOME.setOpaque(false);

        edtCLI_NOME.setEditable(false);
        edtCLI_NOME.setOpaque(false);

        lblPRO_QTD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_QTD.setText("Qtde");

        edtPRO_QTDE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_QTDE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_QTDEActionPerformed(evt);
            }
        });

        lblPRO_PRECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_PRECO.setText("Preço");

        edtPRO_PRECO.setEditable(false);
        edtPRO_PRECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_PRECO.setOpaque(false);
        edtPRO_PRECO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_PRECOActionPerformed(evt);
            }
        });

        lblPRO_DESCONTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_DESCONTO.setText("Desconto");

        edtPRO_DESCONTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPRO_DESCONTO.setText("0");
        edtPRO_DESCONTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPRO_DESCONTOActionPerformed(evt);
            }
        });

        btnADICIONA_PRODUTO.setText("OK");
        btnADICIONA_PRODUTO.setEnabled(false);
        btnADICIONA_PRODUTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADICIONA_PRODUTOActionPerformed(evt);
            }
        });

        TABLE_ITEMVENDA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TABLE_ITEMVENDA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLE_ITEMVENDAMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TABLE_ITEMVENDA);

        lblTITULO.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTITULO.setText("PRODUTOS DA VENDA");

        btnNOVA_VENDA.setText("Nova Venda");
        btnNOVA_VENDA.setEnabled(false);
        btnNOVA_VENDA.setFocusable(false);
        btnNOVA_VENDA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNOVA_VENDA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNOVA_VENDA.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnNOVA_VENDAStateChanged(evt);
            }
        });
        btnNOVA_VENDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNOVA_VENDAActionPerformed(evt);
            }
        });

        btnCONFIRMA_CLIENTE_USUARIO.setText("OK");
        btnCONFIRMA_CLIENTE_USUARIO.setFocusable(false);
        btnCONFIRMA_CLIENTE_USUARIO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCONFIRMA_CLIENTE_USUARIO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCONFIRMA_CLIENTE_USUARIO.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnCONFIRMA_CLIENTE_USUARIOStateChanged(evt);
            }
        });
        btnCONFIRMA_CLIENTE_USUARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCONFIRMA_CLIENTE_USUARIOActionPerformed(evt);
            }
        });

        edtVDA_VALOR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        edtVDA_VALOR.setForeground(new java.awt.Color(102, 211, 130));
        edtVDA_VALOR.setEnabled(false);
        edtVDA_VALOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVDA_VALORActionPerformed(evt);
            }
        });

        lblVDA_VALOR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblVDA_VALOR.setText("Valor");

        edtVDA_DESCONTO.setEnabled(false);
        edtVDA_DESCONTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVDA_DESCONTOActionPerformed(evt);
            }
        });

        lblVDA_DESCONTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblVDA_DESCONTO.setText("Desconto na Venda");

        lblVDA_TOTAL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblVDA_TOTAL.setText("SubTotal");

        edtVDA_TOTAL.setEditable(false);
        edtVDA_TOTAL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtVDA_TOTAL.setForeground(new java.awt.Color(102, 211, 130));
        edtVDA_TOTAL.setEnabled(false);
        edtVDA_TOTAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVDA_TOTALActionPerformed(evt);
            }
        });

        separadorCENTRAL.setOrientation(javax.swing.SwingConstants.VERTICAL);

        TABLE_PRODUTO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TABLE_PRODUTO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLE_PRODUTOMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(TABLE_PRODUTO);

        javax.swing.GroupLayout painelDADOSLayout = new javax.swing.GroupLayout(painelDADOS);
        painelDADOS.setLayout(painelDADOSLayout);
        painelDADOSLayout.setHorizontalGroup(
            painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDADOSLayout.createSequentialGroup()
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUSU_CODIGO, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCLI_CODIGO, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblVDA_CODIGO, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnNOVA_VENDA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edtVDA_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(edtCLI_CODIGO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(edtUSU_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(painelDADOSLayout.createSequentialGroup()
                                        .addComponent(edtUSU_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnPESQUISA_USUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(painelDADOSLayout.createSequentialGroup()
                                        .addComponent(edtCLI_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(btnPESQUISA_CLIENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(btnCONFIRMA_CLIENTE_USUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDADOSLayout.createSequentialGroup()
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lblPRO_CODIGO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtPRO_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDADOSLayout.createSequentialGroup()
                                .addComponent(lblPRO_PRECO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtPRO_PRECO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addComponent(lblPRO_QTD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtPRO_QTDE, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPRO_DESCONTO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtPRO_DESCONTO)
                                .addGap(18, 18, 18)
                                .addComponent(btnADICIONA_PRODUTO, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelDADOSLayout.createSequentialGroup()
                                .addComponent(edtPRO_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPESQUISA_PRODUTO, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane3))
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6)))
                .addGap(18, 18, 18)
                .addComponent(separadorCENTRAL, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDADOSLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDADOSLayout.createSequentialGroup()
                                .addComponent(lblVDA_DESCONTO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtVDA_DESCONTO, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblVDA_VALOR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtVDA_VALOR, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDADOSLayout.createSequentialGroup()
                                .addComponent(lblVDA_TOTAL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtVDA_TOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelDADOSLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelDADOSLayout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addComponent(lblTITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        painelDADOSLayout.setVerticalGroup(
            painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDADOSLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVDA_CODIGO)
                    .addComponent(edtVDA_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUSU_CODIGO)
                    .addComponent(edtUSU_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPESQUISA_USUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtUSU_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_CODIGO)
                    .addComponent(edtCLI_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtCLI_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPESQUISA_CLIENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCONFIRMA_CLIENTE_USUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNOVA_VENDA, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtPRO_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPESQUISA_PRODUTO, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtPRO_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPRO_CODIGO))
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtPRO_QTDE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPRO_QTD)
                    .addComponent(lblPRO_PRECO)
                    .addComponent(edtPRO_PRECO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPRO_DESCONTO)
                    .addComponent(edtPRO_DESCONTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnADICIONA_PRODUTO, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(333, 333, 333))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDADOSLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTITULO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtVDA_VALOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVDA_VALOR)
                    .addComponent(edtVDA_DESCONTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVDA_DESCONTO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDADOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtVDA_TOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVDA_TOTAL))
                .addGap(331, 331, 331))
            .addGroup(painelDADOSLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(separadorCENTRAL, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados da Venda", painelDADOS);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(30, 110, 1250, 520);

        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo1.setText("VENDA DE PRODUTOS");
        getContentPane().add(lblTitulo1);
        lblTitulo1.setBounds(550, 80, 280, 29);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPRIMEIROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRIMEIROActionPerformed
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existem vendas realizadas!");
        }
        int primeiro = 0;
        mostrarRegistro(primeiro);
    }//GEN-LAST:event_btnPRIMEIROActionPerformed

    private void btnANTERIORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnANTERIORActionPerformed
        //int selecionado = tblConsulta.getSelectedRow() - 1;
        // mostrarRegistro(selecionado);
    }//GEN-LAST:event_btnANTERIORActionPerformed

    private void btnPROXIMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPROXIMOActionPerformed
        // int selecionado = tblConsulta.getSelectedRow() + 1;
        //mostrarRegistro(selecionado);
    }//GEN-LAST:event_btnPROXIMOActionPerformed

    private void btnULTIMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnULTIMOActionPerformed
        // int ultimo = lista.size() - 1;
        // mostrarRegistro(ultimo);
    }//GEN-LAST:event_btnULTIMOActionPerformed

    private void btnINCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINCLUIRActionPerformed
        limpar();
        setOperacao("incluir");
        edtCLI_CODIGO.setFocusable(true);
        edtPRO_CODIGO.setFocusable(true);
        edtUSU_CODIGO.setFocusable(true);
        edtPRO_QTDE.setFocusable(true);
        edtPRO_PRECO.setFocusable(true);
    }//GEN-LAST:event_btnINCLUIRActionPerformed

    private void btnALTERARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALTERARActionPerformed
        setOperacao("alterar");
    }//GEN-LAST:event_btnALTERARActionPerformed

    private void btnEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXCLUIRActionPerformed
//        setOperacao("");
//        if (JOptionPane.showConfirmDialog(null, "Confirma Exclusão deste Registro ?",
//                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//            try {
//                VendaModel venda = new VendaModel();
//
//                venda.setPes_fantasia(edtUSU_COD.getText());
//                pessoa.setPes_fisica((chkCLI_FISICA.isSelected() ? 1 : 0));
//                pessoa.setPes_cpfcnpj(edtCLI_CPFCNPJ.getText());
//                pessoa.setPes_rgie(edtCLI_RG.getText());
//                pessoa.setPes_endereco(edtCLI_ENDERECO.getText());
//                pessoa.setPes_numero(edtCLI_NUMERO.getText());
//                pessoa.setPes_complemento(edtCLI_COMPLEMENTO.getText());
//                pessoa.setPes_bairro(edtCLI_BAIRRO.getText());
//                pessoa.setPes_cidade(edtCLI_CIDADE.getText());
//                pessoa.setPes_uf(edtCLI_CIDADE.getText());
//                pessoa.setPes_cep(edtCLI_CEP.getText());
//                pessoa.setPes_fone1(edtCLI_FONE1.getText());
//                pessoa.setPes_fone2(edtCLI_FONE2.getText());
//                pessoa.setPes_celular(edtCLI_CELULAR.getText());
//                pessoa.setPes_site(edtCLI_SITE.getText());
//                pessoa.setPes_email(edtCLI_EMAIL.getText());
//                pessoa.setPes_ativo((chkCLI_ATIVO.isSelected() ? 1 : 0));
//
//                ClienteModel cliente = new ClienteModel();
//
//                cliente.setCli_codigo(Integer.parseInt(edtVDA_ID.getText()));
//                cliente.setCli_limitecred(edtCLI_LIMITECRED.getText());
//                cliente.setPessoa(pessoa);
//
//                ClienteController clientecontroller = new ClienteController();
//                clientecontroller.excluir(cliente);
//
//                JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso");
//                consultar();
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
//            }
//        }
    }//GEN-LAST:event_btnEXCLUIRActionPerformed

    private void btnGRAVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAVARActionPerformed
//        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste Cliente ?",
//                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//            try {
//                PessoaModel pessoa = new PessoaModel();
//                pessoa.setPes_nome(edtCLI_NOME.getText());
//                pessoa.setPes_fantasia(edtUSU_COD.getText());
//                pessoa.setPes_fisica((chkCLI_FISICA.isSelected() ? 1 : 0));
//                pessoa.setPes_cpfcnpj(edtCLI_CPFCNPJ.getText());
//                pessoa.setPes_rgie(edtCLI_RG.getText());
//                pessoa.setPes_endereco(edtCLI_ENDERECO.getText());
//                pessoa.setPes_numero(edtCLI_NUMERO.getText());
//                pessoa.setPes_complemento(edtCLI_COMPLEMENTO.getText());
//                pessoa.setPes_bairro(edtCLI_BAIRRO.getText());
//                pessoa.setPes_cidade(edtCLI_CIDADE.getText());
//                pessoa.setPes_uf(edtCLI_UF.getText());
//                pessoa.setPes_cep(edtCLI_CEP.getText());
//                pessoa.setPes_fone1(edtCLI_FONE1.getText());
//                pessoa.setPes_fone2(edtCLI_FONE2.getText());
//                pessoa.setPes_celular(edtCLI_CELULAR.getText());
//                pessoa.setPes_site(edtCLI_SITE.getText());
//                pessoa.setPes_email(edtCLI_EMAIL.getText());
//                pessoa.setPes_ativo((chkCLI_ATIVO.isSelected() ? 1 : 0));
//
//                ClienteModel cliente = new ClienteModel();
//                cliente.setCli_codigo(Integer.parseInt(edtVDA_ID.getText()));
//                cliente.setCli_limitecred(edtCLI_LIMITECRED.getText());
//                cliente.setPessoa(pessoa);
//
//                ClienteController clientecontroller = new ClienteController();
//                clientecontroller.gravar(getOperacao(), cliente);
//
//                JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso");
//                consultar();
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, "Erro na Gravação \n" + ex.getMessage());
//            }
//        }
    }//GEN-LAST:event_btnGRAVARActionPerformed

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

    private void btnADICIONA_PRODUTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADICIONA_PRODUTOActionPerformed
        adcVendaPro();
        try {
            String condicao = filtroConsultaItensVenda();
            VendaProdutoController vendaprodutocontroller = new VendaProdutoController();
            listaVendaProduto = null;
            listaVendaProduto = vendaprodutocontroller.consultarItensVenda(condicao);
            if (listaVendaProduto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não existem itens inseridos!");
            } else {
                tabelaVendaProdutoModel = new VendaProdutoTableModel(listaVendaProduto, colunasItens);
                TABLE_ITEMVENDA.setModel(tabelaVendaProdutoModel);
                TABLE_ITEMVENDA.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta do produtos!\n" + ex.getMessage());
        }
        subTotal(); // mostra o valor no campo a baixo Valor.
    }//GEN-LAST:event_btnADICIONA_PRODUTOActionPerformed

    private void edtPRO_DESCONTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_DESCONTOActionPerformed

    }//GEN-LAST:event_edtPRO_DESCONTOActionPerformed

    private void edtPRO_PRECOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_PRECOActionPerformed

    }//GEN-LAST:event_edtPRO_PRECOActionPerformed

    private void edtPRO_QTDEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_QTDEActionPerformed

    }//GEN-LAST:event_edtPRO_QTDEActionPerformed

    private void edtPRO_CODIGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPRO_CODIGOActionPerformed

    }//GEN-LAST:event_edtPRO_CODIGOActionPerformed

    private void TABLE_CADASTROMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLE_CADASTROMouseClicked
        if (flag == 1) {
            String usuario_codigo = "" + TABLE_CADASTRO.getValueAt(TABLE_CADASTRO.getSelectedRow(), 0);
            String usuario_nome = "" + TABLE_CADASTRO.getValueAt(TABLE_CADASTRO.getSelectedRow(), 1);
            edtUSU_CODIGO.setText(usuario_codigo);
            edtUSU_NOME.setText(usuario_nome);
        } else if (flag == 2) {
            String cliente_codigo = "" + TABLE_CADASTRO.getValueAt(TABLE_CADASTRO.getSelectedRow(), 0);
            String cliente_nome = "" + TABLE_CADASTRO.getValueAt(TABLE_CADASTRO.getSelectedRow(), 1);
            edtCLI_CODIGO.setText(cliente_codigo);
            edtCLI_NOME.setText(cliente_nome);
        }
    }//GEN-LAST:event_TABLE_CADASTROMouseClicked

    private void btnPESQUISA_PRODUTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPESQUISA_PRODUTOActionPerformed
        flag = 3;
        try {
            String condicao = filtroConsultaPro();
            ProdutoController produtocontroller = new ProdutoController();
            listaPro = null;
            listaPro = produtocontroller.consultar(condicao);
            if (listaPro.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não existem produtos cadastratos!");
            } else {
                tabelaPro = new TableModelPro(listaPro, colunasPro);
                TABLE_PRODUTO.setModel(tabelaPro);
                TABLE_PRODUTO.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta dos produtos!\n" + ex.getMessage());
        }
    }//GEN-LAST:event_btnPESQUISA_PRODUTOActionPerformed

    private void edtCLI_CODIGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCLI_CODIGOActionPerformed

    }//GEN-LAST:event_edtCLI_CODIGOActionPerformed

    private void btnPESQUISA_CLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPESQUISA_CLIENTEActionPerformed
        flag = 2;
        try {
            String condicao = filtroConsultaCli();
            ClienteController clientecontroller = new ClienteController();
            listaCli = null;
            listaCli = clientecontroller.consultar(condicao);
            if (listaCli.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não existem clientes cadastrados!");
            } else {
                tabelacli = new TableModelCli(listaCli, colunasCli);
                TABLE_CADASTRO.setModel(tabelacli);
                TABLE_CADASTRO.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta do cliente!\n" + ex.getMessage());
        }

    }//GEN-LAST:event_btnPESQUISA_CLIENTEActionPerformed

    private void btnPESQUISA_USUARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPESQUISA_USUARIOActionPerformed
        flag = 1;
        try {
            String condicao = filtroConsultaUsu();
            UsuarioController usuariocontroller = new UsuarioController();
            listaUsu = null;
            listaUsu = usuariocontroller.consultar(condicao);
            if (listaUsu.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não existem usuários cadastrados!");
            } else {
                tabelaUsu = new TableModelUsu(listaUsu, colunasUsu);
                TABLE_CADASTRO.setModel(tabelaUsu);
                TABLE_CADASTRO.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar os usuários!\n" + ex.getMessage());
        }
    }//GEN-LAST:event_btnPESQUISA_USUARIOActionPerformed

    private void edtUSU_CODIGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtUSU_CODIGOActionPerformed

    }//GEN-LAST:event_edtUSU_CODIGOActionPerformed

    private void TABLE_ITEMVENDAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLE_ITEMVENDAMouseClicked

    }//GEN-LAST:event_TABLE_ITEMVENDAMouseClicked
    public boolean liberaVenda() {
        if (!(edtUSU_NOME.getText().equals(""))) {
            if (!(edtCLI_NOME.getText().equals(""))) {
                btnNOVA_VENDA.setEnabled(true);
                return true;
            }
        }
        return false;
    }

    private void btnNOVA_VENDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNOVA_VENDAActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Deseja abrir uma nova venda?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                VendaModel vendamodel = new VendaModel();
                ClienteModel clientemodel = new ClienteModel();
                UsuarioModel usuariomodel = new UsuarioModel();

                usuariomodel.setUSU_CODIGO(Integer.parseInt(edtUSU_CODIGO.getText()));
                clientemodel.setCLI_CODIGO(Integer.parseInt(edtCLI_CODIGO.getText()));
                ///vendamodel.setVDA_VALOR(Double.valueOf(edtVDA_VALOR.getText()));
                ///vendamodel.setVDA_DESCONTO(Double.valueOf(edtVDA_DESCONTO.getText()));
                ///vendamodel.setVDA_TOTAL(Double.valueOf(edtVDA_TOTAL.getText()));
                vendamodel.setUSU_MODEL(usuariomodel);
                vendamodel.setCLI_MODEL(clientemodel);

                VendaController vendacontroller = new VendaController();
                vendacontroller.adicionar(vendamodel);

                btnPESQUISA_USUARIO.setEnabled(false);
                btnPESQUISA_CLIENTE.setEnabled(false);
                edtUSU_CODIGO.setEditable(false);
                edtCLI_CODIGO.setEditable(false);
                edtUSU_NOME.setEditable(false);
                edtCLI_NOME.setEditable(false);
                btnNOVA_VENDA.setEnabled(false);
                btnCONFIRMA_CLIENTE_USUARIO.setEnabled(false);

            } catch (NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na gravação!\n" + ex.getMessage());
            }
            try {

                VendaDao vendadao = new VendaDao();
                edtVDA_CODIGO.setText(String.valueOf(vendadao.ultimaVenda()));

            } catch (SQLException ex) {

            }
        }

        btnADICIONA_PRODUTO.setEnabled(true);
    }//GEN-LAST:event_btnNOVA_VENDAActionPerformed

    private void btnNOVA_VENDAStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnNOVA_VENDAStateChanged

    }//GEN-LAST:event_btnNOVA_VENDAStateChanged

    private void edtUSU_NOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtUSU_NOMEActionPerformed

    }//GEN-LAST:event_edtUSU_NOMEActionPerformed

    private void btnCONFIRMA_CLIENTE_USUARIOStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnCONFIRMA_CLIENTE_USUARIOStateChanged

    }//GEN-LAST:event_btnCONFIRMA_CLIENTE_USUARIOStateChanged

    private void btnCONFIRMA_CLIENTE_USUARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCONFIRMA_CLIENTE_USUARIOActionPerformed
        if (liberaVenda() && JOptionPane.showConfirmDialog(null, "Dados validos, deseja continuar?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            liberaVenda();

        } else {
            btnNOVA_VENDA.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Dados não são válidos, por favor corrija!");
        }
    }//GEN-LAST:event_btnCONFIRMA_CLIENTE_USUARIOActionPerformed

    private void edtVDA_VALORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVDA_VALORActionPerformed

    }//GEN-LAST:event_edtVDA_VALORActionPerformed

    private void edtVDA_DESCONTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVDA_DESCONTOActionPerformed

    }//GEN-LAST:event_edtVDA_DESCONTOActionPerformed

    private void edtVDA_TOTALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVDA_TOTALActionPerformed

    }//GEN-LAST:event_edtVDA_TOTALActionPerformed

    private void TABLE_PRODUTOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLE_PRODUTOMouseClicked
        if (flag == 3) {
            String produto_codigo = "" + TABLE_PRODUTO.getValueAt(TABLE_PRODUTO.getSelectedRow(), 0);
            String produto_nome = "" + TABLE_PRODUTO.getValueAt(TABLE_PRODUTO.getSelectedRow(), 1);
            edtPRO_NOME.setText(produto_nome);
             edtPRO_CODIGO.setText(produto_codigo);
            ArrayList<ProdutoModel> listaProM = new ArrayList<>();
            try {
                String condicao = filtroConsultaPro();
                ProdutoController pro = new ProdutoController();
                listaProPreco = pro.consultar(condicao);
                pro_preco = (float) listaProPreco.get(0).getPRO_PRECO();
                edtPRO_PRECO.setText(String.valueOf(pro_preco));

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao pesquisar o preço!");
            }
            edtPRO_QTDE.setText("1");
        }
    }//GEN-LAST:event_TABLE_PRODUTOMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TABLE_CADASTRO;
    private javax.swing.JTable TABLE_ITEMVENDA;
    private javax.swing.JTable TABLE_PRODUTO;
    private javax.swing.JButton btnADICIONA_PRODUTO;
    private javax.swing.JButton btnALTERAR;
    private javax.swing.JButton btnANTERIOR;
    private javax.swing.JButton btnCONFIRMA_CLIENTE_USUARIO;
    private javax.swing.JButton btnEXCLUIR;
    private javax.swing.JButton btnGRAVAR;
    private javax.swing.JButton btnINCLUIR;
    private javax.swing.JButton btnNOVA_VENDA;
    private javax.swing.JButton btnPESQUISA_CLIENTE;
    private javax.swing.JButton btnPESQUISA_PRODUTO;
    private javax.swing.JButton btnPESQUISA_USUARIO;
    private javax.swing.JButton btnPRIMEIRO;
    private javax.swing.JButton btnPROXIMO;
    private javax.swing.JButton btnSAIR;
    private javax.swing.JButton btnULTIMO;
    private javax.swing.JTextField edtCLI_CODIGO;
    private javax.swing.JTextField edtCLI_NOME;
    private javax.swing.JTextField edtPRO_CODIGO;
    private javax.swing.JTextField edtPRO_DESCONTO;
    private javax.swing.JTextField edtPRO_NOME;
    private javax.swing.JTextField edtPRO_PRECO;
    private javax.swing.JTextField edtPRO_QTDE;
    private javax.swing.JTextField edtUSU_CODIGO;
    private javax.swing.JTextField edtUSU_NOME;
    private javax.swing.JTextField edtVDA_CODIGO;
    private javax.swing.JTextField edtVDA_DESCONTO;
    private javax.swing.JTextField edtVDA_TOTAL;
    private javax.swing.JTextField edtVDA_VALOR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblCLI_CODIGO;
    private javax.swing.JLabel lblPRO_CODIGO;
    private javax.swing.JLabel lblPRO_DESCONTO;
    private javax.swing.JLabel lblPRO_PRECO;
    private javax.swing.JLabel lblPRO_QTD;
    private javax.swing.JLabel lblTITULO;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblUSU_CODIGO;
    private javax.swing.JLabel lblVDA_CODIGO;
    private javax.swing.JLabel lblVDA_DESCONTO;
    private javax.swing.JLabel lblVDA_TOTAL;
    private javax.swing.JLabel lblVDA_VALOR;
    private javax.swing.JPanel painelDADOS;
    private javax.swing.JSeparator separadorCENTRAL;
    // End of variables declaration//GEN-END:variables

}
