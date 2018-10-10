package trabalho.principal;

import java.sql.SQLException;
import trabalho.conexao.Conexao;
import trabalho.view.ClienteView;
import trabalho.view.FormaPagamentoView;
import trabalho.view.LoginView;
import trabalho.view.VendaView;

public class MVC_DAO {

    Conexao objconexao;
    LoginView loginview;
    FormaPagamentoView formapagtoview;
    VendaView vendaview;
    ClienteView clienteview;

    public MVC_DAO() throws SQLException {
        objconexao = new Conexao();
        
        loginview = new LoginView();
        loginview.setVisible(true);
           //vendaview = new VendaView();
           //vendaview.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        MVC_DAO mvc_dao = new MVC_DAO();
    }
}
