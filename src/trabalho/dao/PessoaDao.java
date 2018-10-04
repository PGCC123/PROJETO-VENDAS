package trabalho.dao;

import trabalho.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import trabalho.model.PessoaModel;

public class PessoaDao {

    private Connection conexao = null;

    /**
     * @autor: Patrick carpezani
     * @funcionalidade:método construtor que faz referencencia a classe de
     * conexã, chmando o objeto.
     * @exception: tem com exception do tipo SQL.
     * @data: 14/09/2018
     */
    public PessoaDao() throws SQLException {
        this.conexao = Conexao.getConexao();
    }
    
    public int ultimaPessoa() throws SQLException {
        int maxId= 1;
        String sql = ("SELECT NVL(MAX(PES_CODIGO),1) FROM PESSOA");
        PreparedStatement stm = conexao.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        rs.next();
        maxId = rs.getInt(1);
        rs.close();
        stm.close();
        
        
        return maxId;
    }


    public void adicionar(PessoaModel pessoa) throws SQLException {
        String sql = "INSERT INTO PESSOA (PES_NOME, PES_FANTASIA, PES_FISICA, PES_CPFCNPJ, PES_RGIE, "
                + "PES_CADASTRO, PES_ENDERECO, PES_NUMERO,PES_COMPLEMENTO,PES_BAIRRO,"
                + "PES_CIDADE,PES_UF,PES_CEP,PES_FONE1,PES_FONE2,PES_CELULAR, PES_SITE, PES_EMAIL, PES_ATIVO)" //MODIFICAÇÃO ADIÇÃO DO ATRIBUTO ATIVO
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, pessoa.getPES_NOME());
        stm.setString(2, pessoa.getPES_FANTASIA());
        stm.setString(3, pessoa.getPES_FISICA());
        stm.setString(4, pessoa.getPES_CPFCNPJ());
        stm.setString(5, pessoa.getPES_RGIE());
        stm.setString(6, pessoa.getPES_CADASTRO());
        stm.setString(7, pessoa.getPES_ENDERECO());
        stm.setString(8, pessoa.getPES_NUMERO());
        stm.setString(9, pessoa.getPES_COMPLEMENTO());
        stm.setString(10, pessoa.getPES_BAIRRO());
        stm.setString(11, pessoa.getPES_CIDADE());
        stm.setString(12, pessoa.getPES_UF());
        stm.setString(13, pessoa.getPES_CEP());
        stm.setString(14, pessoa.getPES_FONE1());
        stm.setString(15, pessoa.getPES_FONE2());
        stm.setString(16, pessoa.getPES_CELULAR());
        stm.setString(17, pessoa.getPES_SITE());
        stm.setString(18, pessoa.getPES_EMAIL());
        stm.setString(19, pessoa.getPES_ATIVO());
        stm.execute();
        stm.close();
    
    }

    public void alterar(PessoaModel pessoa) throws SQLException {
        String sql = "UPDATE PESSOA "
                + "SET PES_NOME = ?, PES_FANTASIA = ?, PES_FISICA = ?, PES_CPFCNPJ = ?, PES_RGIE = ?, PES_CADASTRO = ?, PES_ENDERECO = ?, PES_NUMERO = ?,PES_COMPLEMENTO = ?,PES_BAIRRO = ?,PES_CIDADE = ?,PES_UF = ?,PES_CEP = ?,PES_FONE1 = ?,PES_FONE2 = ?,PES_CELULAR = ?, PES_SITE = ?, PES_EMAIL = ?, PES_ATIVO = ?  WHERE PES_CODIGO = ?"; // modificar quando o atributo ativo estiver pegando.
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setString(1, pessoa.getPES_NOME());
        stm.setString(2, pessoa.getPES_FANTASIA());
        stm.setString(3, pessoa.getPES_FISICA());
        stm.setString(4, pessoa.getPES_CPFCNPJ());
        stm.setString(5, pessoa.getPES_RGIE());
        stm.setString(6, pessoa.getPES_CADASTRO());
        stm.setString(7, pessoa.getPES_ENDERECO());
        stm.setString(8, pessoa.getPES_NUMERO());
        stm.setString(9, pessoa.getPES_COMPLEMENTO());
        stm.setString(10, pessoa.getPES_BAIRRO());
        stm.setString(11, pessoa.getPES_CIDADE());
        stm.setString(12, pessoa.getPES_UF());
        stm.setString(13, pessoa.getPES_CEP());
        stm.setString(14, pessoa.getPES_FONE1());
        stm.setString(15, pessoa.getPES_FONE2());
        stm.setString(16, pessoa.getPES_CELULAR());
        stm.setString(17, pessoa.getPES_SITE());
        stm.setString(18, pessoa.getPES_EMAIL());
        stm.setString(19, pessoa.getPES_ATIVO());
        stm.setInt(20, pessoa.getPES_CODIGO());
        stm.execute();
        stm.close();
    }

    public void excluir(PessoaModel pessoa) throws SQLException {
        String sql = "DELETE FROM PESSOA WHERE PES_CODIGO = ?";
        PreparedStatement stm = conexao.prepareStatement(sql);
        stm.setInt(1, pessoa.getPES_CODIGO());
        stm.execute();
        stm.close();
    }

    public ArrayList<PessoaModel> consultar(String condicao) throws SQLException {
        ArrayList<PessoaModel> lista = null;
        PreparedStatement stm;
        ResultSet rs;
        String sql = "SELECT * FROM PESSOA";
        if (!condicao.equals("")) {
            sql += " where " + condicao;
        }
        stm = conexao.prepareStatement(sql);
        rs = stm.executeQuery();
        lista = new ArrayList<>();

        while (rs.next()) {
            PessoaModel objpessoa = new PessoaModel();
            objpessoa.setPES_CODIGO(rs.getInt("PES_CODIGO"));
            objpessoa.setPES_NOME(rs.getString("PES_NOME"));
            objpessoa.setPES_FANTASIA(rs.getString("PES_FANTASIA"));
            objpessoa.setPES_FISICA(rs.getString("PES_FISICA"));
            objpessoa.setPES_CPFCNPJ(rs.getString("PES_CPFCNPJ"));
            objpessoa.setPES_RGIE(rs.getString("PES_RGIE"));
            objpessoa.setPES_CADASTRO(rs.getString("PES_CADASTRO"));
            objpessoa.setPES_ENDERECO(rs.getString("PES_ENDERECO"));
            objpessoa.setPES_NUMERO(rs.getString("PES_NUMERO"));
            objpessoa.setPES_COMPLEMENTO(rs.getString("PES_COMPLEMENTO"));
            objpessoa.setPES_BAIRRO(rs.getString("PES_BAIRRO"));
            objpessoa.setPES_CIDADE(rs.getString("PES_CIDADE"));
            objpessoa.setPES_UF(rs.getString("PES_UF"));
            objpessoa.setPES_CEP(rs.getString("PES_CEP"));
            objpessoa.setPES_FONE1(rs.getString("PES_FONE1"));
            objpessoa.setPES_FONE2(rs.getString("PES_FONE2"));
            objpessoa.setPES_CELULAR(rs.getString("PES_CELULAR"));
            objpessoa.setPES_SITE(rs.getString("PES_SITE"));
            objpessoa.setPES_EMAIL(rs.getString("PES_EMAIL"));
            objpessoa.setPES_ATIVO(rs.getString("PES_ATIVO"));
            lista.add(objpessoa);
        }
        rs.close();
        stm.close();
        return lista;
    }
}
