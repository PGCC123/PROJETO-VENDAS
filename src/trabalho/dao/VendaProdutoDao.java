package trabalho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.conexao.Conexao;
import trabalho.model.ProdutoModel;
import trabalho.model.VendaModel;
import trabalho.model.VendaProdutoModel;

public class VendaProdutoDao {

    private Connection conexao = null;

    public VendaProdutoDao() throws SQLException {
        this.conexao = Conexao.getConexao();
    }

    public void adicionar(VendaProdutoModel vendapro) throws SQLException {
        String sql = "INSERT INTO VENDA_PRODUTO (VDA_CODIGO, PRO_CODIGO, VEP_QTDE, VEP_PRECO, VEP_DESCONTO) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, vendapro.getVDA_MODEL().getVDA_CODIGO());
        stm.setInt(2, vendapro.getPRO_MODEL().getPRO_CODIGO());
        stm.setDouble(3, vendapro.getVEP_QTDE());
        stm.setDouble(4, vendapro.getVEP_PRECO());
        stm.setDouble(5, vendapro.getVEP_DESCONTO());
      //  stm.setDouble(6, vendapro.getVEP_TOTAL());
        stm.execute();
        stm.close();
    }

    public void alterar(VendaProdutoModel vendapro) throws SQLException {
        String sql = "UPDATE VENDA_PRODUTO SET VDA_CODIGO = ?, PRO_CODIGO = ?, VEP_QTDE = ?, VEP_PRECO = ?, VEP_DESCONTO = ?, VEP_TOTAL = ? WHERE VEP_CODIGO = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, vendapro.getVDA_MODEL().getVDA_CODIGO());
        stm.setInt(2, vendapro.getPRO_MODEL().getPRO_CODIGO());
        stm.setDouble(3, vendapro.getVEP_QTDE());
        stm.setDouble(4, vendapro.getVEP_PRECO());
        stm.setDouble(5, vendapro.getVEP_DESCONTO());
        stm.setDouble(6, vendapro.getVEP_TOTAL());
        stm.setInt(7, vendapro.getVEP_CODIGO());
        stm.execute();
        stm.close();
    }

    public void excluir(VendaProdutoModel vendapro) throws SQLException {
        String sql = "DELETE FROM VENDA_PRODUTO WHERE VEP_CODIGO = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, vendapro.getVEP_CODIGO());
        stm.execute();
        stm.close();
    }

    public ArrayList<VendaProdutoModel> consultar(String condicao) throws SQLException {
        ArrayList<VendaProdutoModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT VP.*, VDA.*, P.pro_nome, P.pro_preco FROM VENDA_PRODUTO VP "
                + "JOIN VENDA VDA ON (VP.vda_codigo = VDA.vda_codigo)"
                + "JOIN PRODUTO P on (VP.pro_codigo = P.pro_codigo)";
        if (!condicao.equals("")) {
            sql += " WHERE " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();

        while (rs.next()) {
            VendaProdutoModel objvendapro = new VendaProdutoModel();
            VendaModel objvenda = new VendaModel();
            ProdutoModel objproduto = new ProdutoModel();

            objvendapro.setVEP_CODIGO(rs.getInt("VEP_CODIGO"));
            objvendapro.setVEP_QTDE(rs.getInt("VEP_QTDE"));
            objvendapro.setVEP_PRECO(rs.getDouble("VEP_PRECO"));
            objvendapro.setVEP_DESCONTO(rs.getDouble("VEP_DESCONTO"));
            objvendapro.setVEP_TOTAL(rs.getDouble("VEP_TOTAL"));

            objvenda.setVDA_CODIGO(rs.getInt("VDA_CODIGO"));
            objproduto.setPRO_CODIGO(rs.getInt("PRO_CODIGO"));
            objproduto.setPRO_NOME(rs.getString("PRO_NOME"));
            objproduto.setPRO_PRECO(rs.getDouble("PRO_PRECO"));

            objvendapro.setVDA_MODEL(objvenda);
            objvendapro.setPRO_MODEL(objproduto);
            lista.add(objvendapro);
        }
        rs.close();
        stm.close();
        return lista;
    }

    public ArrayList<VendaProdutoModel> consultarItensVenda(String condicao) throws SQLException {
        ArrayList<VendaProdutoModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT VP.*, VDA.*, P.PRO_NOME, P.PRO_PRECO \n"
                + "FROM SISTEMA.VENDA_PRODUTO VP\n"
                + "INNER JOIN SISTEMA.VENDA VDA \n"
                + "ON VP.VDA_CODIGO = VDA.VDA_CODIGO\n"
                + "INNER JOIN SISTEMA.PRODUTO P \n"
                + "ON VP.PRO_CODIGO = P.PRO_CODIGO";
        if (!condicao.equals("")) {
            sql += " WHERE " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();

        while (rs.next()) {

            VendaProdutoModel vendaprodutomodel = new VendaProdutoModel();
            // VendaModel venda = new VendaModel();
            ProdutoModel produtomodel = new ProdutoModel();

            produtomodel.setPRO_CODIGO(rs.getInt("PRO_CODIGO"));
            produtomodel.setPRO_NOME(rs.getString("PRO_NOME"));

            vendaprodutomodel.setVEP_QTDE(rs.getInt("VEP_QTDE"));
            vendaprodutomodel.setVEP_PRECO(rs.getFloat("VEP_PRECO"));
            vendaprodutomodel.setVEP_DESCONTO(rs.getFloat("VEP_DESCONTO"));
            vendaprodutomodel.setVEP_TOTAL(rs.getFloat("VEP_TOTAL"));

            //venda.setVda_codigo(rs.getInt("vda_codigo"));
            //vendaProduto.setVenda(venda);
            vendaprodutomodel.setPRO_MODEL(produtomodel);
            lista.add(vendaprodutomodel);
        }
        rs.close();
        stm.close();
        return lista;
    }

    public ArrayList<VendaProdutoModel> consultarSubTotal(String condicao) throws SQLException {
        ArrayList<VendaProdutoModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT SUM(VEP_TOTAL) "
                + "FROM VENDA_PRODUTO";

        if (!condicao.equals("")) {
            sql += " WHERE " + condicao + "GROUP BY VDA_CODIGO";
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();

        while (rs.next()) {

            VendaProdutoModel vendaprodutomodel = new VendaProdutoModel();
            vendaprodutomodel.setVEP_TOTAL(rs.getDouble("SUM(VEP_TOTAL)"));
            //venda.setVda_codigo(rs.getInt("vda_codigo"));
            // vendaProduto.setVenda(venda);
            lista.add(vendaprodutomodel);
        }

        rs.close();
        stm.close();
        return lista;
    }
}
