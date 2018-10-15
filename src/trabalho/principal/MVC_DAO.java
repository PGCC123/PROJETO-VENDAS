package trabalho.principal;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import trabalho.conexao.Conexao;
import trabalho.view.ClienteView;
import trabalho.view.FormaPagamentoView;
import trabalho.view.FornecedorView;
import trabalho.view.LoginView;
import trabalho.view.VendaView;

public class MVC_DAO {

    Conexao objconexao;
    LoginView loginview;
    FormaPagamentoView formapagtoview;
    VendaView vendaview;
    ClienteView clienteview;
    FornecedorView fornecedorview;

    public MVC_DAO() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            objconexao = new Conexao();

            loginview = new LoginView();
            loginview.setVisible(true);
            //fornecedorview = new FornecedorView();
            //fornecedorview.setVisible(true);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException erro) {
            JOptionPane.showMessageDialog(null, "Por motivos inesperados não foi possível abrir o sistema\n"
                    + erro.getMessage(), "Menssagem", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        MVC_DAO mvc_dao = new MVC_DAO();
    }
}
