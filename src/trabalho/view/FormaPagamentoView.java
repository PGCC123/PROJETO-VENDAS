package trabalho.view;

import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import trabalho.controller.VendaPagtoController;
import trabalho.dao.PagamentoDao;
import trabalho.model.PagamentoModel;
import trabalho.model.VendaModel;
import trabalho.model.VendaPagtoModel;

public class FormaPagamentoView extends javax.swing.JFrame {

    public FormaPagamentoView() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.populaJCombobox();      
    }

    public final void populaJCombobox() throws SQLException {
        PagamentoDao pagamentodao = new PagamentoDao();

        for (PagamentoModel pagamento : pagamentodao.populaCombo()) {
            mostrar(pagamento);

        }
    }

    public void limpar() {
        edtVDP_CODIGO.setText("0");
        edtVDA_CODIGO.setText("0");
    }

    public void mostrar(PagamentoModel pagamento)  {
        comboFPG_NOME.addItem(pagamento.getFPG_NOME()); // pegando o valor dinamicamente do banco de dados.
        comboFPG_NOME.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
          
                    if (comboFPG_NOME.getSelectedItem().equals((pagamento.getFPG_NOME()))) {
                        edtFPG_CODIGO.setText(String.valueOf(pagamento.getFPG_CODIGO()));
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
        lblFPG_TITULO = new javax.swing.JLabel();
        comboFPG_NOME = new javax.swing.JComboBox<>();
        lblFPG_CODIGO = new javax.swing.JLabel();
        edtFPG_CODIGO = new javax.swing.JTextField();
        btnCONFIRMAR = new javax.swing.JButton();
        btnCANCELAR = new javax.swing.JButton();
        edtVDP_CODIGO = new javax.swing.JTextField();
        edtVDA_CODIGO = new javax.swing.JTextField();
        lblFPG_CODIGO1 = new javax.swing.JLabel();
        edtVDP_VALOR = new javax.swing.JTextField();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sales System");
        setBackground(new java.awt.Color(153, 153, 153));
        setResizable(false);

        lblFPG_TITULO.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblFPG_TITULO.setText("ESCOLHA SUA FORMA DE PAGAMENTO");

        comboFPG_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboFPG_NOME.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar" }));

        lblFPG_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFPG_CODIGO.setText("Código");

        edtFPG_CODIGO.setEditable(false);
        edtFPG_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnCONFIRMAR.setText("Confirmar");
        btnCONFIRMAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCONFIRMARActionPerformed(evt);
            }
        });

        btnCANCELAR.setText("Cancelar");
        btnCANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCANCELARActionPerformed(evt);
            }
        });

        edtVDP_CODIGO.setEditable(false);
        edtVDP_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtVDP_CODIGO.setEnabled(false);

        edtVDA_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFPG_CODIGO1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFPG_CODIGO1.setText("Valor ");

        edtVDP_VALOR.setEditable(false);
        edtVDP_VALOR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        edtVDP_VALOR.setForeground(new java.awt.Color(102, 211, 130));
        edtVDP_VALOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtVDP_VALORActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnCONFIRMAR, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(lblFPG_TITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtVDA_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFPG_CODIGO)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(edtFPG_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(edtVDP_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFPG_CODIGO1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(edtVDP_VALOR, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(comboFPG_NOME, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFPG_TITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboFPG_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFPG_CODIGO)
                    .addComponent(edtFPG_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtVDP_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFPG_CODIGO1)
                    .addComponent(edtVDP_VALOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edtVDA_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCONFIRMAR, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCANCELARActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCANCELARActionPerformed

    private void btnCONFIRMARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCONFIRMARActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Confirmar o pagamento?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                VendaPagtoModel objvendapagto = new VendaPagtoModel();
                VendaModel objvenda = new VendaModel();
                PagamentoModel objpagamento = new PagamentoModel();

                objvendapagto.setVDP_CODIGO(Integer.parseInt(edtVDP_CODIGO.getText()));
                objvenda.setVDA_CODIGO(Integer.parseInt(edtVDA_CODIGO.getText()));
                objpagamento.setFPG_CODIGO(Integer.parseInt(edtFPG_CODIGO.getText()));

                objvendapagto.setVDA_MODEL(objvenda);
                objvendapagto.setFPG_MODEL(objpagamento);

                VendaPagtoController vendapgatocontroller = new VendaPagtoController();
                vendapgatocontroller.adicionar(objvendapagto);
                JOptionPane.showMessageDialog(null, "Pagamento efetuado com sucesso!");

                this.dispose();
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblFPG_CODIGO;
    private javax.swing.JLabel lblFPG_CODIGO1;
    private javax.swing.JLabel lblFPG_TITULO;
    // End of variables declaration//GEN-END:variables
}
