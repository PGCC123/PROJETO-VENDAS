
/*Conteúdo: Menu
 *Autor: Carpezani
 *Data: 16/03/2018
 */
package trabalho.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import trabalho.conexao.Conexao;

public abstract class IMenu extends JFrame {

    public IMenu() {

        Menu();
    }

    private void Menu() {

        JMenu cadastro = new JMenu("Cadastros");
        JMenuItem cliente = new JMenuItem("Clientes");
        JMenuItem fornecedor = new JMenuItem("Fornecedores");
        JMenuItem formapagto = new JMenuItem("Formas de Pagamentos");
        JMenuItem produto = new JMenuItem("Produtos");
        //JMenuItem usuario = new JMenuItem("Usuários");

        cadastro.add(cliente);
        cliente.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Conexao objconexao;
                objconexao = new Conexao();

                dispose();
                ClienteView clienteview;
                clienteview = new ClienteView();
                cliente.setVisible(true);
            }
        });

        cadastro.add(fornecedor);
        fornecedor.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Conexao objconexao;
                objconexao = new Conexao();

                dispose();
                FornecedorView fornecedorview;
                fornecedorview = new FornecedorView();
                fornecedor.setVisible(true);

            }
        });

        cadastro.add(formapagto);
        formapagto.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Conexao objconexao;
                objconexao = new Conexao();

                dispose();
                PagamentoView pagamentoview;
                pagamentoview = new PagamentoView();
                formapagto.setVisible(true);
            }
        });

        cadastro.add(produto);
        produto.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Conexao objconexao;
                objconexao = new Conexao();

                dispose();
                ProdutoView produtoview;
                produtoview = new ProdutoView();
                produto.setVisible(true);

            }
        });

        /*  cadastro.add(usuario);
        usuario.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Conexao objconexao;
                objconexao = new Conexao();

                dispose();
                UsuarioView usuarioview;
                usuarioview = new UsuarioView();
                usuario.setVisible(true);

            }
        }); */
        JMenu movimento = new JMenu("Movimentos");
        JMenuItem venda = new JMenuItem("Vendas");

        movimento.add(venda);
        venda.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Conexao objconexao;
                objconexao = new Conexao();

                dispose();
                VendaView vendaview;
                vendaview = new VendaView();
                vendaview.setVisible(true);
            }
        });

        JMenu opcoes = new JMenu("Ajuda");
        JMenuItem sobre = new JMenuItem("Sobre");
        JMenuItem sair = new JMenuItem("Sair");
        opcoes.add(sobre);
        sobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(IMenu.this,
                        "Empresa: PLTEC LTDA"
                        + "\nContato: 0800 725 7979"
                        + "\nE-mail: contato@pltec.com.br");
            }
        }
        );

        opcoes.add(sair);
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sair = JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?", "Aviso", JOptionPane.YES_NO_OPTION);
                if (sair == JOptionPane.YES_NO_OPTION) {

                    System.exit(0);
                } else {

                }
            }
        }
        );

        JMenuBar barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        barraMenu.add(cadastro);
        barraMenu.add(movimento);
        barraMenu.add(opcoes);
        setJMenuBar(barraMenu);
    }
}
