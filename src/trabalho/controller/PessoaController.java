package trabalho.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalho.dao.PessoaDao;

import trabalho.model.PessoaModel;

public class PessoaController {

    private List<PessoaModel> listapessoa;

    public ArrayList<PessoaModel> consultar(String filtro) throws SQLException {
        listapessoa = new PessoaDao().consultar(filtro);
        return (ArrayList<PessoaModel>) listapessoa;
    }

    public void excluir(PessoaModel pessoa) throws SQLException {
        PessoaDao dao = new PessoaDao();
        dao.excluir(pessoa);
    }

    public void adicionar(PessoaModel pessoa) throws SQLException {
        PessoaDao dao = new PessoaDao();
       dao.excluir(pessoa);
    }

    public void alterar(PessoaModel pessoa) throws SQLException {
        PessoaDao dao = new PessoaDao();
        dao.alterar(pessoa);
       
    }

    public void gravar(String operacao, PessoaModel pessoa) throws SQLException {
        if (operacao.equals("incluir")) {
            adicionar(pessoa);
        } else if (operacao.equals("alterar")) {
           alterar(pessoa);
        }
    }
}
