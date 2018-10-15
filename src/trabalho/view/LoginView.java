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
import trabalho.model.UsuarioModel;

public class LoginView extends javax.swing.JFrame {
    
    private final char senha;

    public LoginView() {
        initComponents();
        senha = passUSU_SENHA.getEchoChar();
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
        chkUSU_MOSTRA = new javax.swing.JCheckBox();
        iconMOSTRA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Cadastro");
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        labelLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelLogin.setText("Login");

        textUSU_LOGIN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelSenha.setText("Senha");

        passUSU_SENHA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        chkUSU_MOSTRA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkUSU_MOSTRA.setText("Mostrar Senha");
        chkUSU_MOSTRA.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        chkUSU_MOSTRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUSU_MOSTRAActionPerformed(evt);
            }
        });

        iconMOSTRA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/exibirSenha.png"))); // NOI18N

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
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(buttonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(iconMOSTRA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkUSU_MOSTRA))
                            .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textUSU_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passUSU_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelAjuda)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(iconTela, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passUSU_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkUSU_MOSTRA)
                    .addComponent(iconMOSTRA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(labelAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(445, 523));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEntrarActionPerformed

        LoginDao executar = new LoginDao();
        UsuarioModel usuario = new UsuarioModel();

      /*  try {
            if (usuario.getUSU_ATIVO().equals("ATIVO") == true) {
                if (executar.checkLogin(textUSU_LOGIN.getText(), passUSU_SENHA.getText())) {

                    this.dispose();
                    PrincipalView principalview = new PrincipalView();
                    principalview.setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(null, "Usúario ou senha incorreta, tente novamente!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "efrethr");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Por motivos deconhecidos não foi possivel logar" + ex.getMessage());
        } */

        try {
            if (executar.checkLogin(textUSU_LOGIN.getText(), passUSU_SENHA.getText())) {
                    
                this.dispose();
                PrincipalView principalview = new PrincipalView();
                principalview.setVisible(true);

            } else {

                JOptionPane.showMessageDialog(null, "Usúario ou senha incorreta, tente novamente!", "Aviso", JOptionPane.ERROR_MESSAGE);
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

    private void chkUSU_MOSTRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUSU_MOSTRAActionPerformed
      if (chkUSU_MOSTRA.isSelected()) {
          passUSU_SENHA.setEchoChar('\u0000'); // tem como funcionalidade remover a mascara da senha e mostrar a senha.
          iconMOSTRA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/ocultarSenha.png")));
      } else {
          passUSU_SENHA.setEchoChar(senha);
          iconMOSTRA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/exibirSenha.png")));
      }
    }//GEN-LAST:event_chkUSU_MOSTRAActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JButton buttonEntrar;
    private javax.swing.JCheckBox chkUSU_MOSTRA;
    private javax.swing.JLabel iconLogin;
    private javax.swing.JLabel iconMOSTRA;
    private javax.swing.JLabel iconSenha;
    private javax.swing.JLabel iconTela;
    private javax.swing.JLabel labelAjuda;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JPasswordField passUSU_SENHA;
    private javax.swing.JTextField textUSU_LOGIN;
    // End of variables declaration//GEN-END:variables
}
