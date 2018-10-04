package trabalho.dao;

import trabalho.conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import trabalho.conexao.Conexao;

public class LoginDao {

    public boolean checkLogin(String USU_LOGIN, String USU_SENHA) throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE USU_LOGIN = ? AND USU_SENHA = ?");
            stmt.setString(1, USU_LOGIN);
            stmt.setString(2, USU_SENHA);
            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel logar " + ex.getMessage());
        } finally {

            //ConnectionFactory.closeConnection(con, stmt, rs);
            Conexao.fecharConexao();
        }
        return check;
    }
}
