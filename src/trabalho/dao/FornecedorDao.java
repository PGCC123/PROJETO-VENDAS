package trabalho.dao;

import trabalho.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalho.model.FornecedorModel;
import trabalho.model.PessoaModel;

public class FornecedorDao {

    private Connection conexao = null;

    public FornecedorDao() throws SQLException {
        this.conexao = Conexao.getConexao();
    }

    public void adicionar(FornecedorModel fornecedor) throws SQLException {
        PessoaDao pessoadao = new PessoaDao();
        pessoadao.adicionar(fornecedor.getPES_MODEL());

        int pes_codigo = pessoadao.ultimaPessoa();

        String sql = "INSERT INTO FORNECEDOR (PES_CODIGO,  FOR_CONTATO)  "
                + " VALUES (?,?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, pes_codigo);
        stm.setString(2, fornecedor.getFOR_CONTATO());
        stm.execute();
        stm.close();
    }

    public void alterar(FornecedorModel fornecedor) throws SQLException {
        String sql = "UPDATE FORNECEDOR  SET FOR_CONTATO = ? WHERE FOR_CODIGO = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, fornecedor.getFOR_CONTATO());
        stm.setInt(2, fornecedor.getFOR_CODIGO());
        stm.execute();
        PessoaDao pessoadao = new PessoaDao();
        pessoadao.alterar(fornecedor.getPES_MODEL());
        stm.execute();
        stm.close();
    }

    public void excluir(FornecedorModel fornecedor) throws SQLException {
        String sql = "DELETE FROM FORNECEDOR WHERE FOR_CODIGO = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, fornecedor.getFOR_CODIGO());
        stm.execute();
        PessoaDao pessoadao = new PessoaDao();
        pessoadao.excluir(fornecedor.getPES_MODEL());
        stm.execute();
        stm.close();
    }

    public ArrayList<FornecedorModel> consultar(String condicao) throws SQLException {
        ArrayList<FornecedorModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT PESSOA.*, FORNECEDOR.* FROM SISTEMA.PESSOA INNER JOIN SISTEMA.FORNECEDOR ON FORNECEDOR.PES_CODIGO = PESSOA.PES_CODIGO";
        if (!condicao.equals("")) {
            sql += " where " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();

        while (rs.next()) {

            FornecedorModel objfor = new FornecedorModel();

            PessoaModel objpes = new PessoaModel();
            
            objpes.setPES_CODIGO(rs.getInt("PES_CODIGO"));
            objpes.setPES_NOME(rs.getString("PES_NOME"));
            objpes.setPES_FANTASIA(rs.getString("PES_FANTASIA"));
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
            objpes.setPES_SITE(rs.getString("PES_SITE"));
            objpes.setPES_EMAIL(rs.getString("PES_EMAIL"));
            objpes.setPES_ATIVO(rs.getString("PES_ATIVO"));

            objfor.setFOR_CODIGO(rs.getInt("FOR_CODIGO"));
            objfor.setFOR_CONTATO(rs.getString("FOR_CONTATO"));
            objfor.setPES_MODEL(objpes);
            lista.add(objfor);

        }

        rs.close();
        stm.close();
        return lista;
    }
}
