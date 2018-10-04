package trabalho.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalho.dao.ProdutoDao;
import trabalho.model.ProdutoModel;

public class ProdutoController {

    private List<ProdutoModel> listaproduto;

    public ArrayList<ProdutoModel> consultar(String filtro) throws SQLException {
        listaproduto = new ProdutoDao().consultar(filtro);
        return (ArrayList<ProdutoModel>) listaproduto;
    }

    public void excluir(ProdutoModel produto) throws SQLException {
        ProdutoDao dao = new ProdutoDao();
        dao.excluir(produto);
    }

    public void adicionar(ProdutoModel produto) throws SQLException {
        ProdutoDao dao = new ProdutoDao();
        dao.adicionar(produto);
    }

    public void alterar(ProdutoModel produto) throws SQLException {
        ProdutoDao dao = new ProdutoDao();
        dao.alterar(produto);
    }

    public void gravar(String operacao, ProdutoModel produto) throws SQLException {
        boolean retorno = true;
        if (operacao.equals("incluir")) {
            adicionar(produto);
        } else if (operacao.equals("alterar")) {
            alterar(produto);
        }
    }
}
