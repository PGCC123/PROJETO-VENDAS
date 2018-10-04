package trabalho.controller;

import trabalho.dao.PagamentoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalho.model.PagamentoModel;


public class PagamentoController {
 
  private List<PagamentoModel> listapagamento;

    public ArrayList<PagamentoModel> consultar(String filtro) throws SQLException {
        listapagamento = new PagamentoDao().consultar(filtro);
        return (ArrayList<PagamentoModel>) listapagamento;
    }

    public void excluir(PagamentoModel pagamento) throws SQLException {
        PagamentoDao dao = new PagamentoDao();
        dao.excluir(pagamento);
    }

    public void adicionar(PagamentoModel pagamento) throws SQLException {
        PagamentoDao dao = new PagamentoDao();
        dao.adicionar(pagamento);
    }

    public void alterar(PagamentoModel pagamento) throws SQLException {
        PagamentoDao dao = new PagamentoDao();
        dao.alterar(pagamento);
    }

    public void gravar(String operacao, PagamentoModel pagamento) throws SQLException {
        boolean retorno = true;
        if (operacao.equals("incluir")) {
            adicionar(pagamento);
        } else if (operacao.equals("alterar")) {
            alterar(pagamento);
        }
    }
}
