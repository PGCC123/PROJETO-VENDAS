package trabalho.view;

import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import trabalho.controller.VendaPagtoController;
import trabalho.dao.PagamentoDao;
import trabalho.dao.VendaDao;
import trabalho.model.PagamentoModel;
import trabalho.model.VendaModel;
import trabalho.model.VendaPagtoModel;

public class FormaPagamentoView extends javax.swing.JFrame {

    private String operacao;

    private String getOperacao() {
        return operacao;
    }

    public FormaPagamentoView() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.populaJCombobox();

        edtVDP_CODIGO.setVisible(false);
        edtVDA_CODIGO.setVisible(false);
    }

    public final void populaJCombobox() throws SQLException {
        PagamentoDao pagamentodao = new PagamentoDao();

        for (PagamentoModel pagamento : pagamentodao.populaCombo()) {
            mostrar(pagamento);

        }
    }

    public void limpar() {
        edtVDP_CODIGO.setText("0");
        edtVDA_CODIGO.setText("");
    }

    public void mostrar(PagamentoModel pagamento) throws SQLException {
        comboFPG_NOME.addItem(pagamento.getFPG_NOME()); // pegando o valor dinamicamente do banco de dados.
        comboFPG_NOME.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (comboFPG_NOME.getSelectedItem().equals((pagamento.getFPG_NOME()))) {
                    edtFPG_CODIGO.setText(String.valueOf(pagamento.getFPG_CODIGO()));
                    VendaDao vendadao;
                    try {
                        vendadao = new VendaDao();
                        edtVDA_CODIGO.setText(String.valueOf(vendadao.ultimaVenda()));
                    } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null, "Não foi possivel adicionar o código da venda!" + erro.getMessage());
                    }
                } else if (comboFPG_NOME.getSelectedItem().equals("Selecionar")) {
                    edtFPG_CODIGO.setText(null);
                }
            }
        });
    }

    public void recebeSub(double recebe) {
        edtVDP_VALOR.setText(String.valueOf(recebe));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        lblFPG_TITULO = new javax.swing.JLabel();
        lblFPG_CODIGO = new javax.swing.JLabel();
        edtFPG_CODIGO = new javax.swing.JTextField();
        comboFPG_NOME = new javax.swing.JComboBox<>();
        edtVDP_VALOR = new javax.swing.JTextField();
        edtVDP_CODIGO = new javax.swing.JTextField();
        edtVDA_CODIGO = new javax.swing.JTextField();
        btnCANCELAR = new javax.swing.JButton();
        btnCONFIRMAR = new javax.swing.JButton();
        lblBandeiras = new javax.swing.JLabel();
        lblVDP_VALOR = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sales System");
        setBackground(new java.awt.Color(153, 153, 153));
        setResizable(false);

        lblFPG_TITULO.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblFPG_TITULO.setText("ESCOLHA SUA FORMA DE PAGAMENTO");

        lblFPG_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFPG_CODIGO.setText("Código");

        edtFPG_CODIGO.setEditable(false);
        edtFPG_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        comboFPG_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboFPG_NOME.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));

        edtVDP_VALOR.setEditable(false);
        edtVDP_VALOR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        edtVDP_VALOR.setForeground(new java.awt.Color(102, 211, 130));
        edtVDP_VALOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVDP_VALORActionPerformed(evt);
            }
        });

        edtVDP_CODIGO.setEditable(false);
        edtVDP_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtVDP_CODIGO.setEnabled(false);

        edtVDA_CODIGO.setEditable(false);
        edtVDA_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnCANCELAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconeCancelar.png"))); // NOI18N
        btnCANCELAR.setText("Cancelar");
        btnCANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCANCELARActionPerformed(evt);
            }
        });

        btnCONFIRMAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconeConfirmar.png"))); // NOI18N
        btnCONFIRMAR.setText("Confirmar");
        btnCONFIRMAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCONFIRMARActionPerformed(evt);
            }
        });

        lblBandeiras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconeBandeiras.png"))); // NOI18N

        lblVDP_VALOR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblVDP_VALOR.setText("Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblBandeiras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17)
                        .addComponent(btnCONFIRMAR, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFPG_CODIGO)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(edtFPG_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(edtVDP_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(edtVDA_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblVDP_VALOR)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(edtVDP_VALOR, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(comboFPG_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblFPG_TITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFPG_TITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboFPG_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtFPG_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFPG_CODIGO))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVDP_VALOR)
                            .addComponent(edtVDP_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtVDP_VALOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(edtVDA_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCONFIRMAR, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBandeiras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCANCELARActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCANCELARActionPerformed

    @SuppressWarnings("null")
    private void btnCONFIRMARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCONFIRMARActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Confirmar o pagamento?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                VendaPagtoModel objvendapagto = new VendaPagtoModel();
                VendaModel objvenda = new VendaModel();
                PagamentoModel objpagamento = new PagamentoModel();

                objvendapagto.setVDP_CODIGO(Integer.parseInt(edtVDP_CODIGO.getText()));
                objvendapagto.setVDP_VALOR(Double.parseDouble(edtVDP_VALOR.getText()));
                objvenda.setVDA_CODIGO(Integer.parseInt(edtVDA_CODIGO.getText()));
                objpagamento.setFPG_CODIGO(Integer.parseInt(edtFPG_CODIGO.getText()));

                objvendapagto.setVDA_MODEL(objvenda);
                objvendapagto.setFPG_MODEL(objpagamento);

                VendaPagtoController vendapgatocontroller = new VendaPagtoController();
                vendapgatocontroller.adicionar(objvendapagto);

                JOptionPane.showMessageDialog(null, "Pagamento efetuado com sucesso!");

                this.dispose();
                
               /* edtFPG_CODIGO.setText("");
                comboFPG_NOME.setSelectedItem("Selecionar");
                edtVDP_CODIGO.setText("");
                edtVDA_CODIGO.setText("");
                edtVDP_VALOR.setText("");*/

            } catch (HeadlessException | NumberFormatException | SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao efetuar o pagamento" + erro.getMessage());
            }
        }
    }//GEN-LAST:event_btnCONFIRMARActionPerformed

    private void edtVDP_VALORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtVDP_VALORActionPerformed

    }//GEN-LAST:event_edtVDP_VALORActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCANCELAR;
    private javax.swing.JButton btnCONFIRMAR;
    private javax.swing.JComboBox<String> comboFPG_NOME;
    private javax.swing.JTextField edtFPG_CODIGO;
    private javax.swing.JTextField edtVDA_CODIGO;
    private javax.swing.JTextField edtVDP_CODIGO;
    private javax.swing.JTextField edtVDP_VALOR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JLabel lblBandeiras;
    private javax.swing.JLabel lblFPG_CODIGO;
    private javax.swing.JLabel lblFPG_TITULO;
    private javax.swing.JLabel lblVDP_VALOR;
    // End of variables declaration//GEN-END:variables
}
