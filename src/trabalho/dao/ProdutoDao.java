package trabalho.dao;

import trabalho.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import trabalho.model.ProdutoModel;

public class ProdutoDao {

    private Connection conexao = null;

    public ProdutoDao() throws SQLException {
        this.conexao = Conexao.getConexao();
    }

    public void adicionar(ProdutoModel produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (PRO_CODIGO, PRO_NOME, PRO_ESTOQUE, PRO_UNIDADE, PRO_PRECO, PRO_CUSTO, PRO_ATACADO, PRO_MIN, PRO_MAX, PRO_EMBALAGEM, PRO_PESO, PRO_CADASTRO, PRO_OBS, PRO_ATIVO)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, produto.getPRO_CODIGO());
        stm.setString(2, produto.getPRO_NOME());
        stm.setInt(3, produto.getPRO_ESTOQUE());
        stm.setInt(4, produto.getPRO_UNIDADE());
        stm.setDouble(5, produto.getPRO_PRECO());
        stm.setDouble(6, produto.getPRO_CUSTO());
        stm.setDouble(7, produto.getPRO_ATACADO());
        stm.setDouble(8, produto.getPRO_MIN());
        stm.setDouble(9, produto.getPRO_MAX());
        stm.setDouble(10, produto.getPRO_EMBALAGEM());
        stm.setDouble(11, produto.getPRO_PESO());
        stm.setString(12, produto.getPRO_CADASTRO()); stm.setDate(12, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        stm.setString(13, produto.getPRO_OBS());
        stm.setString(14, produto.getPRO_ATIVO());
        stm.execute();
        stm.close();
    }

    public void alterar(ProdutoModel produto) throws SQLException {
        String sql = "UPDATE PRODUTO SET PRO_NOME = ?, PRO_ESTOQUE = ?, "
                + "PRO_UNIDADE = ?, PRO_PRECO = ?, PRO_CUSTO = ?, PRO_ATACADO = ?, PRO_MIN = ?,  PRO_MAX = ?, PRO_EMBALAGEM = ?, PRO_PESO = ?, PRO_CADASTRO = ?, PRO_OBS = ?, PRO_ATIVO = ?  WHERE PRO_CODIGO = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, produto.getPRO_NOME());
        stm.setInt(2, produto.getPRO_ESTOQUE());
        stm.setInt(3, produto.getPRO_UNIDADE());
        stm.setDouble(4, produto.getPRO_PRECO());
        stm.setDouble(5, produto.getPRO_CUSTO());
        stm.setDouble(6, produto.getPRO_ATACADO());
        stm.setDouble(7, produto.getPRO_MIN());
        stm.setDouble(8, produto.getPRO_MAX());
        stm.setDouble(9, produto.getPRO_EMBALAGEM());
        stm.setDouble(10, produto.getPRO_PESO());
        stm.setString(11, produto.getPRO_CADASTRO());
        stm.setString(12, produto.getPRO_OBS());
        stm.setString(13, produto.getPRO_ATIVO());
        stm.setInt(14, produto.getPRO_CODIGO());

        stm.execute();
        stm.close();
    }

    public void excluir(ProdutoModel produto) throws SQLException {
        String sql = "DELETE FROM PRODUTO WHERE PRO_CODIGO = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, produto.getPRO_CODIGO());
        stm.execute();
        stm.close();
    }

    public ArrayList<ProdutoModel> consultar(String condicao) throws SQLException {
        ArrayList<ProdutoModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT * FROM PRODUTO";
        if (!condicao.equals("")) {
            sql += " where " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();

        while (rs.next()) {
            ProdutoModel objpro = new ProdutoModel();
            objpro.setPRO_CODIGO(rs.getInt("PRO_CODIGO"));
            objpro.setPRO_NOME(rs.getString("PRO_NOME"));
            objpro.setPRO_ESTOQUE(rs.getInt("PRO_ESTOQUE"));
            objpro.setPRO_UNIDADE(rs.getInt("PRO_UNIDADE"));
            objpro.setPRO_PRECO(rs.getDouble("PRO_PRECO"));
            objpro.setPRO_CUSTO(rs.getDouble("PRO_CUSTO"));
            objpro.setPRO_ATACADO(rs.getDouble("PRO_ATACADO"));
            objpro.setPRO_MIN(rs.getDouble("PRO_MIN"));
            objpro.setPRO_MAX(rs.getDouble("PRO_MAX"));
            objpro.setPRO_EMBALAGEM(rs.getDouble("PRO_EMBALAGEM"));
            objpro.setPRO_PESO(rs.getDouble("PRO_PESO"));
            objpro.setPRO_CADASTRO(rs.getString("PRO_CADASTRO"));
            objpro.setPRO_OBS(rs.getString("PRO_OBS"));
            objpro.setPRO_ATIVO(rs.getString("PRO_ATIVO"));
            lista.add(objpro);
        }
        rs.close();
        stm.close();
        return lista;
    }
}
