package trabalho.view;

import trabalho.conexao.Conexao;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class PrincipalView extends javax.swing.JFrame {

    public PrincipalView() {
        initComponents();
        this.setPreferredSize(new Dimension(848, 670));
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        separadorSuperior = new javax.swing.JSeparator();
        labelTtulo = new javax.swing.JLabel();
        imageVenda = new javax.swing.JLabel();
        labelVenda = new javax.swing.JLabel();
        labelBVendas = new javax.swing.JLabel();
        labelBFornecedor = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        labelBCliente = new javax.swing.JLabel();
        labelFornecedor = new javax.swing.JLabel();
        labelProduto = new javax.swing.JLabel();
        labelBProduto = new javax.swing.JLabel();
        labelBPagamento = new javax.swing.JLabel();
        labelPagamento = new javax.swing.JLabel();
        labelSair = new javax.swing.JLabel();
        labelBSair = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sales System");
        setResizable(false);

        labelTtulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTtulo.setText("BEM-VINDO SALES SYSTEM");

        imageVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconeSalesSystem.png"))); // NOI18N

        labelVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelVenda.setText("Vendas");

        labelBVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconeVenda.png"))); // NOI18N
        labelBVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirVenda(evt);
            }
        });

        labelBFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconeFornecedor.png"))); // NOI18N
        labelBFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirFornecedor(evt);
            }
        });

        labelCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCliente.setText("Clientes");

        labelBCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconeCliente.png"))); // NOI18N
        labelBCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirCliente(evt);
            }
        });

        labelFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelFornecedor.setText("Fornecedores");

        labelProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelProduto.setText("Produtos");

        labelBProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconeProduto.png"))); // NOI18N
        labelBProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirProduto(evt);
            }
        });

        labelBPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconePagamento.png"))); // NOI18N
        labelBPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirPagamento(evt);
            }
        });

        labelPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPagamento.setText("Pagamento");

        labelSair.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSair.setText("Log off");

        labelBSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/trabalho.imagens.png"))); // NOI18N
        labelBSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelBSair(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(labelTtulo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 121, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(labelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelBCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(labelBFornecedor)))
                                .addGap(66, 66, 66))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(labelProduto)))
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelBPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelPagamento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelBVendas, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(labelVenda)
                            .addComponent(labelBSair, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(labelSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(40, 40, 40)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separadorSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(labelTtulo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imageVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(separadorSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelBCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelBProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelBPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelBVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(labelBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSair, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirVenda(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirVenda
         Conexao objconexao;
        objconexao = new Conexao();

        dispose();
        VendaView vendaview;
        vendaview = new VendaView();
        vendaview.setVisible(true);
    }//GEN-LAST:event_abrirVenda

    private void abrirFornecedor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirFornecedor
        Conexao objconexao;
        objconexao = new Conexao();

        dispose();
        FornecedorView fornecedorview;
        fornecedorview = new FornecedorView();
        fornecedorview.setVisible(true);
    }//GEN-LAST:event_abrirFornecedor

    private void abrirCliente(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirCliente

        Conexao objconexao;
        objconexao = new Conexao();

        dispose();
        ClienteView clienteview;
        clienteview = new ClienteView();
        clienteview.setVisible(true);
    }//GEN-LAST:event_abrirCliente

    private void abrirProduto(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirProduto

        Conexao objconexao;
        objconexao = new Conexao();

        dispose();
        ProdutoView produtoview;
        produtoview = new ProdutoView();
        produtoview.setVisible(true);
    }//GEN-LAST:event_abrirProduto

    private void abrirPagamento(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirPagamento

        Conexao objconexao;
        objconexao = new Conexao();

        dispose();
        PagamentoView pagamentoview;
        pagamentoview = new PagamentoView();
        pagamentoview.setVisible(true);
    }//GEN-LAST:event_abrirPagamento

    private void labelBSair(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelBSair
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
    }//GEN-LAST:event_labelBSair

   /* public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    } */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel labelBCliente;
    private javax.swing.JLabel labelBFornecedor;
    private javax.swing.JLabel labelBPagamento;
    private javax.swing.JLabel labelBProduto;
    private javax.swing.JLabel labelBSair;
    private javax.swing.JLabel labelBVendas;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelFornecedor;
    private javax.swing.JLabel labelPagamento;
    private javax.swing.JLabel labelProduto;
    private javax.swing.JLabel labelSair;
    private javax.swing.JLabel labelTtulo;
    private javax.swing.JLabel labelVenda;
    private javax.swing.JSeparator separadorSuperior;
    // End of variables declaration//GEN-END:variables
}
