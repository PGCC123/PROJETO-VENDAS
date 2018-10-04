package trabalho.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalho.dao.ClienteDao;
import trabalho.dao.FornecedorDao;
import trabalho.model.ClienteModel;
import trabalho.model.FornecedorModel;

public class FornecedorController {

    private List<FornecedorModel> listafornecedor;

    public ArrayList<FornecedorModel> consultar(String filtro) throws SQLException {
        listafornecedor = new FornecedorDao().consultar(filtro);
        return (ArrayList<FornecedorModel>) listafornecedor;
    }

    public void excluir(FornecedorModel fornecedor) throws SQLException {
        FornecedorDao dao = new FornecedorDao();
        dao.excluir(fornecedor);
    }

    public void adicionar(FornecedorModel fornecedor) throws SQLException {
        FornecedorDao dao = new FornecedorDao();
        dao.adicionar(fornecedor);
    }

    public void alterar(FornecedorModel fornecedor) throws SQLException {
        FornecedorDao dao = new FornecedorDao();
        dao.alterar(fornecedor);
    }

    public void gravar(String operacao, FornecedorModel fornecedor) throws SQLException {
        boolean retorno = true;
        if (operacao.equals("incluir")) {
            adicionar(fornecedor);
        } else if (operacao.equals("alterar")) {
            alterar(fornecedor);
        }
    }
}