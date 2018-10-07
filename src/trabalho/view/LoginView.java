/**
 *Conteúdo: Tela de Login
 *Autor: Patrick Carpezani
 *Data: 16/07/2018
 */
package trabalho.view;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import trabalho.conexao.Conexao;
import trabalho.dao.LoginDao;

public class LoginView extends javax.swing.JFrame {

    public LoginView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelLogin = new javax.swing.JLabel();
        textUSU_LOGIN = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        passUSU_SENHA = new javax.swing.JPasswordField();
        buttonEntrar = new javax.swing.JButton();
        buttonCadastrar = new javax.swing.JButton();
        labelAjuda = new javax.swing.JLabel();
        iconTela = new javax.swing.JLabel();
        iconSenha = new javax.swing.JLabel();
        iconLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Cadastro");
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        labelLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelLogin.setText("Login");

        textUSU_LOGIN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textUSU_LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUSU_LOGINActionPerformed(evt);
            }
        });

        labelSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelSenha.setText("Senha");

        passUSU_SENHA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passUSU_SENHA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passUSU_SENHAActionPerformed(evt);
            }
        });

        buttonEntrar.setText("Entrar");
        buttonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEntrarActionPerformed(evt);
            }
        });

        buttonCadastrar.setText("Cadastrar");
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });

        labelAjuda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelAjuda.setText("Ajuda");
        labelAjuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAjudaMouseClicked(evt);
            }
        });

        iconTela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconeTela.png"))); // NOI18N

        iconSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconeChave.png"))); // NOI18N

        iconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/iconeFisico_1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(iconSenha, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textUSU_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passUSU_SENHA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(buttonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(buttonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(iconTela, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelAjuda)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(iconTela, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textUSU_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passUSU_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(labelAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(461, 499));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textUSU_LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUSU_LOGINActionPerformed

    }//GEN-LAST:event_textUSU_LOGINActionPerformed

    private void passUSU_SENHAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passUSU_SENHAActionPerformed

    }//GEN-LAST:event_passUSU_SENHAActionPerformed

    private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEntrarActionPerformed

        LoginDao executar = new LoginDao();

        try {
            if (executar.checkLogin(textUSU_LOGIN.getText(), passUSU_SENHA.getText())) {

                dispose();
                // JOptionPane.showMessageDialog(null, "Bem-Vindo ao Sales System!");
                PrincipalView principalview = new PrincipalView();
                principalview.setVisible(true);

            } else {

                JOptionPane.showMessageDialog(null, "Usúario ou senha incorreta, tente novamente!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Por motivos deconhecidos não foi possivel logar" + ex.getMessage());
        }
    }//GEN-LAST:event_buttonEntrarActionPerformed

    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarActionPerformed
        Conexao objconexao;
        objconexao = new Conexao();

        UsuarioView usuarioview;
        usuarioview = new UsuarioView();
        usuarioview.setVisible(true);

    }//GEN-LAST:event_buttonCadastrarActionPerformed

    private void labelAjudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAjudaMouseClicked

        JOptionPane.showMessageDialog(null, "Para logar insira seu e-mail e sua senha corporativa.", "Menssagem", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_labelAjudaMouseClicked

  /*  public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    } */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JButton buttonEntrar;
    private javax.swing.JLabel iconLogin;
    private javax.swing.JLabel iconSenha;
    private javax.swing.JLabel iconTela;
    private javax.swing.JLabel labelAjuda;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JPasswordField passUSU_SENHA;
    private javax.swing.JTextField textUSU_LOGIN;
    // End of variables declaration//GEN-END:variables
}
