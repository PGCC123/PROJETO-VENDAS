package trabalho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import trabalho.conexao.Conexao;
import trabalho.model.ClienteModel;
import trabalho.model.PessoaModel;
import trabalho.model.UsuarioModel;
import trabalho.model.VendaModel;

public class VendaDao {

    private Connection conexao = null;

    public VendaDao() throws SQLException {
        this.conexao = Conexao.getConexao();
    }

    public int ultimaVenda() throws SQLException {
        int maxId = 1;
        try {
            String sql = ("SELECT MAX(VDA_CODIGO) AS MAX_CODIGO FROM VENDA");
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet rs;
            rs = stm.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt("MAX_CODIGO");
                stm.close();
            }
            return maxId;
        } catch (Exception erro) {
            return 1;
        }
    }

    public void adicionar(VendaModel venda) throws SQLException {
        String sql = "INSERT INTO VENDA (USU_CODIGO, CLI_CODIGO, VDA_DATA) VALUES (?, ?,?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, venda.getUSU_MODEL().getUSU_CODIGO());
        stm.setInt(2, venda.getCLI_MODEL().getCLI_CODIGO());
        stm.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
       // stm.setDouble(4, venda.getVDA_VALOR());
        ////stm.setDouble(5, venda.getVDA_DESCONTO());
       // stm.setDouble(6, venda.getVDA_TOTAL());
        stm.execute();
        stm.close();
    }

    public void alterar(VendaModel venda) throws SQLException {
        String sql = "UPDATE VENDA SET USU_CODIGO = ?, CLI_CODIGO = ?, VDA_DATA = ?, VDA_VALOR = ?, VDA_DESCONTO = ?, VDA_TOTAL = ?, VDA_OBS = ? WHERE VDA_CODIGO = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, venda.getUSU_MODEL().getUSU_CODIGO());
        stm.setInt(2, venda.getCLI_MODEL().getCLI_CODIGO());
        stm.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        stm.setDouble(4, venda.getVDA_VALOR());
        stm.setDouble(5, venda.getVDA_DESCONTO());
        stm.setDouble(6, venda.getVDA_TOTAL());
        stm.setString(7, venda.getVDA_OBS());
        stm.setInt(8, venda.getVDA_CODIGO());
        stm.execute();
        stm.close();
}

public void excluir(VendaModel venda) throws SQLException {
        String sql = "DELETE FROM VENDA WHERE VDA_CODIGO = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, venda.getVDA_CODIGO());
        stm.execute();
        stm.close();
    }
    
    public ArrayList<VendaModel> consultar(String condicao) throws SQLException {
        ArrayList<VendaModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT VEN.*, CLI.*, PES.PES_NOME FROM VENDA VEN INNER JOIN CLIENTE CLI ON CLI.CLI_CODIGO = VEN.CLI_CODIGO INNER JOIN PESSOA PES ON PES.PES_CODIGO = CLI.PES_CODIGO INNER JOIN USUARIO USU ON USU.USU_CODIGO = VEN.USU_CODIGO";
        if (!condicao.equals("")) {
            sql += " where " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();

        while (rs.next()) {
            VendaModel objvenda = new VendaModel();
            UsuarioModel objusuario = new UsuarioModel();
            ClienteModel objcliente = new ClienteModel();
            PessoaModel objpessoa = new PessoaModel();
            
            objvenda.setVDA_CODIGO(rs.getInt("VDA_CODIGO"));
            objvenda.setVDA_VALOR(rs.getDouble("VDA_VALOR"));
            objvenda.setVDA_DESCONTO(rs.getDouble("VDA_DESCONTO"));
            objvenda.setVDA_TOTAL(rs.getDouble("VDA_TOTAL"));
            objvenda.setVDA_OBS(rs.getString("VDA_OBS"));
            
            objusuario.setUSU_CODIGO(rs.getInt("USU_CODIGO"));
            objpessoa.setPES_NOME(rs.getString("PES_NOME"));
            
            objcliente.setCLI_CODIGO(rs.getInt("CLI_CODIGO"));
            objcliente.setCLI_LIMITECRED(rs.getDouble("CLI_LIMITECRED"));
            
            objvenda.setCLI_MODEL(objcliente);
            objvenda.setUSU_MODEL(objusuario);
            objvenda.getCLI_MODEL().setPessoamodel(objpessoa);
            lista.add(objvenda);
        }
        rs.close();
        stm.close();
        return lista;
    }

}
