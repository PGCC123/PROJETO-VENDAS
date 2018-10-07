package trabalho.principal;

import java.sql.SQLException;
import trabalho.conexao.Conexao;
import trabalho.view.FormaPagamentoView;
import trabalho.view.LoginView;

public class MVC_DAO {

    Conexao objconexao;
    LoginView loginview;
    FormaPagamentoView formapagtoview;

    public MVC_DAO() throws SQLException {
        objconexao = new Conexao();

        //formapagtoview = new FormaPagamentoView();
        //formapagtoview.setVisible(true);
        loginview = new LoginView();
        loginview.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        MVC_DAO mvc_dao = new MVC_DAO();
    }
}
