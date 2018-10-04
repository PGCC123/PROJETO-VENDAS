package trabalho.principal;

import trabalho.conexao.Conexao;
import trabalho.view.LoginView;

public class MVC_DAO {

    Conexao objconexao;
    LoginView loginview;

    public MVC_DAO() {
        objconexao = new Conexao();

        loginview = new LoginView();
        loginview.setVisible(true);
    }

    public static void main(String[] args) {
        MVC_DAO mvc_dao = new MVC_DAO();
    }
}
