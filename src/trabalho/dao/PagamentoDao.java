package trabalho.dao;

import trabalho.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.model.PagamentoModel;

public class PagamentoDao {

    private Connection conexao = null;

    /**
     * @autor: Patrick carpezani
     * @funcionalidade:método construtor que faz referencencia a classe de
     * conexã, chmando o objeto.
     * @exception: tem com exception do tipo SQL.
     * @data: 14/09/2018
     */
    public PagamentoDao() throws SQLException {
        this.conexao = Conexao.getConexao();
    }

    /**
     * @autor: Patrick carpezani
     * @funcionalidade:método do tipo publico sem retorno que tem como
     * funcionalidade realizar a inserção dos dados no SGBD.
     * @exception: tem com exception do tipo SQL.
     * @data: 14/09/2018
     */
    public void adicionar(PagamentoModel pagamento) throws SQLException {
        String sql = "INSERT INTO FORMAPAGTO (FPG_NOME, FPG_ATIVO)  VALUES (?, ?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, pagamento.getFPG_NOME());
        stm.setString(2, pagamento.getFPG_ATIVO());
        stm.execute();
        stm.close();
    }

    /**
     * @autor: Patrick carpezani
     * @funcionalidade:método do tipo publico sem retorno que tem como
     * funcionalidade realizar atualizão dos dados no SGBD.
     * @exception: tem com exception do tipo SQL.
     * @data: 14/09/2018
     */
    public void alterar(PagamentoModel pagamento) throws SQLException {
        String sql = "UPDATE FORMAPAGTO SET FPG_NOME = ?, FPG_ATIVO = ?  WHERE FPG_CODIGO = ?"; // modificar quando o atributo ativo estiver pegando.
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, pagamento.getFPG_NOME());
        stm.setString(2, pagamento.getFPG_ATIVO());
        stm.setInt(3, pagamento.getFPG_CODIGO());
        stm.execute();
        stm.close();
    }

    /**
     * @autor: Patrick carpezani
     * @funcionalidade:método do tipo publico sem retorno que tem como
     * funcionalidade realizar exclusão dos dados no SGBD.
     * @exception: tem com exception do tipo SQL.
     * @data: 14/09/2018
     */
    public void excluir(PagamentoModel pagamento) throws SQLException {
        String sql = "DELETE FROM FORMAPAGTO WHERE FPG_CODIGO = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, pagamento.getFPG_CODIGO());
        stm.execute();
        stm.close();
    }

    /**
     * @autor: Patrick carpezani
     * @funcionalidade:método do tipo publico com retorno de array com
     * funcionalidade de realizar uma consulta no SGBD.
     * @exception: tem com exception do tipo SQL.
     * @data: 14/09/2018
     */
    public ArrayList<PagamentoModel> consultar(String condicao) throws SQLException {
        ArrayList<PagamentoModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT * FROM FORMAPAGTO";
        if (!condicao.equals("")) {
            sql += " where " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();

        while (rs.next()) {
            PagamentoModel objusu = new PagamentoModel();
            objusu.setFPG_CODIGO(rs.getInt("FPG_CODIGO"));
            objusu.setFPG_NOME(rs.getString("FPG_NOME"));
            objusu.setFPG_ATIVO(rs.getString("FPG_ATIVO"));
            lista.add(objusu);
        }
        rs.close();
        stm.close();
        return lista;
    }
}
