package trabalho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.conexao.Conexao;
import trabalho.model.PagamentoModel;
import trabalho.model.VendaModel;
import trabalho.model.VendaPagtoModel;

public class VendaPagtoDao {

    private Connection conexao = null;

    public VendaPagtoDao() throws SQLException {
        this.conexao = Conexao.getConexao();
    }

    public void adicionar(VendaPagtoModel vendapagto) throws SQLException {
     ///   VendaDao vendadao = new VendaDao();
       // vendadao.adicionar(vendapagto.getVDA_MODEL());

        //int vda_codigo = vendadao.ultimaVenda();

        String sql = "INSERT INTO VENDA_PAGTO (VDA_CODIGO, FPG_CODIGO, VDP_VALOR) VALUES (?, ?, ?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
      //  stm.setInt(1, vda_codigo);
        stm.setInt(1, vendapagto.getVDA_MODEL().getVDA_CODIGO());
        stm.setInt(2, vendapagto.getFPG_MODEL().getFPG_CODIGO());
        stm.setDouble(3, vendapagto.getVDP_VALOR());
        stm.execute();
        stm.close();
    }

    public void alterar(VendaPagtoModel vendapagto) throws SQLException {
        String sql = "UPDATE VENDA_PAGTO SET VDA_CODIGO = ?, FPG_CODIGO = ?, VDP_VALOR = ? WHERE VDP_CODIGO = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, vendapagto.getVDA_MODEL().getVDA_CODIGO());
        stm.setInt(2, vendapagto.getFPG_MODEL().getFPG_CODIGO());
        stm.setDouble(3, vendapagto.getVDP_VALOR());
        stm.setDouble(4, vendapagto.getVDP_CODIGO());
        stm.execute();
        stm.close();
    }

    public void excluir(VendaPagtoModel vendapagto) throws SQLException {
        String sql = "DELETE FROM VENDA_PAGTO WHERE VDP_CODIGO = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, vendapagto.getVDP_CODIGO());
        stm.execute();
        stm.close();
    }

    public ArrayList<VendaPagtoModel> consultar(String condicao) throws SQLException {
        ArrayList<VendaPagtoModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT * FROM VENDA_PGTO";

        if (!condicao.equals("")) {
            sql += " WHERE " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();

        while (rs.next()) {
            VendaPagtoModel objvendapgto = new VendaPagtoModel();
            VendaModel objvenda = new VendaModel();
            PagamentoModel objpagamento = new PagamentoModel();

            objvendapgto.setVDP_CODIGO(rs.getInt("VDP_CODIGO"));
            objvendapgto.setVDP_VALOR(rs.getDouble("VDP_VALOR"));

            objvenda.setVDA_CODIGO(rs.getInt("VDA_CODIGO"));

            objpagamento.setFPG_CODIGO(rs.getInt("FPG_CODIGO"));

            objvendapgto.setVDA_MODEL(objvenda);
            objvendapgto.setFPG_MODEL(objpagamento);
            lista.add(objvendapgto);
        }
        rs.close();
        stm.close();
        return lista;
    }
}
