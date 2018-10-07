package trabalho.dao;

import trabalho.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.model.ClienteModel;
import trabalho.model.PessoaModel;

public class ClienteDao {

    private Connection conexao = null;

    public ClienteDao() throws SQLException {
        this.conexao = Conexao.getConexao();
    }

    public void adicionar(ClienteModel cliente) throws SQLException {
        PessoaDao pessoadao = new PessoaDao();
        pessoadao.adicionar(cliente.getPessoamodel());

        int pes_codigo = pessoadao.ultimaPessoa();

        String sql = "INSERT INTO CLIENTE (PES_CODIGO,  CLI_LIMITECRED)  "
                + " VALUES (?,?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, pes_codigo);
        stm.setDouble(2, cliente.getCLI_LIMITECRED());
        stm.execute();
        stm.close();
    }
    

    public void alterar(ClienteModel cliente) throws SQLException {
        PessoaDao pessoadao = new PessoaDao();
        pessoadao.alterar(cliente.getPessoamodel());
        String sql = "UPDATE CLIENTE SET CLI_LIMITECRED = ?  WHERE CLI_CODIGO = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setDouble(1, cliente.getCLI_LIMITECRED());
        stm.setInt(2, cliente.getCLI_CODIGO());   
        stm.execute();
        stm.close();
    }

    public void excluir(ClienteModel cliente) throws SQLException {
        String sql = "DELETE FROM CLIENTE WHERE CLI_CODIGO = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, cliente.getCLI_CODIGO());
        stm.execute();
        PessoaDao pessoadao = new PessoaDao();
        pessoadao.excluir(cliente.getPessoamodel());
        stm.execute();
        stm.close();
    }

    public ArrayList<ClienteModel> consultar(String condicao) throws SQLException {
        ArrayList<ClienteModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT PES.*, CLI.* FROM CLIENTE CLI INNER JOIN PESSOA PES ON  CLI.PES_CODIGO = PES.PES_CODIGO";
        if (!condicao.equals("")) {
            sql += " where " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();

        while (rs.next()) {

            ClienteModel objcli = new ClienteModel();
            PessoaModel objpes = new PessoaModel();

            objpes.setPES_CODIGO(rs.getInt("PES_CODIGO"));
            objpes.setPES_NOME(rs.getString("PES_NOME"));
            objpes.setPES_FISICA(rs.getString("PES_FISICA"));
            objpes.setPES_CPFCNPJ(rs.getString("PES_CPFCNPJ"));
            objpes.setPES_RGIE(rs.getString("PES_RGIE"));
            objpes.setPES_CADASTRO(rs.getString("PES_CADASTRO"));
            objpes.setPES_ENDERECO(rs.getString("PES_ENDERECO"));
            objpes.setPES_NUMERO(rs.getString("PES_NUMERO"));
            objpes.setPES_COMPLEMENTO(rs.getString("PES_COMPLEMENTO"));
            objpes.setPES_BAIRRO(rs.getString("PES_BAIRRO"));
            objpes.setPES_CIDADE(rs.getString("PES_CIDADE"));
            objpes.setPES_UF(rs.getString("PES_UF"));
            objpes.setPES_CEP(rs.getString("PES_CEP"));
            objpes.setPES_FONE1(rs.getString("PES_FONE1"));
            objpes.setPES_FONE2(rs.getString("PES_FONE2"));
            objpes.setPES_CELULAR(rs.getString("PES_CELULAR"));
            objpes.setPES_EMAIL(rs.getString("PES_EMAIL"));
            objpes.setPES_ATIVO(rs.getString("PES_ATIVO"));

            objcli.setCLI_CODIGO(rs.getInt("CLI_CODIGO"));
            objcli.setCLI_LIMITECRED(rs.getDouble("CLI_LIMITECRED"));
            objcli.setPessoamodel(objpes);
            lista.add(objcli);

        }

        rs.close();
        stm.close();
        return lista;
    }
}
