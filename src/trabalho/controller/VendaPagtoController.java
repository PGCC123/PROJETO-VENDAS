
package trabalho.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalho.dao.VendaPagtoDao;
import trabalho.model.VendaPagtoModel;

public class VendaPagtoController {
    private List<VendaPagtoModel> listapagto;
    
    public ArrayList<VendaPagtoModel> consultar(String filtro) throws SQLException {
        listapagto = new VendaPagtoDao().consultar(filtro);
        return (ArrayList<VendaPagtoModel>) listapagto;
    }
    
    public void excluir(VendaPagtoModel vendapagto) throws SQLException{
        VendaPagtoDao dao = new VendaPagtoDao();
        dao.excluir(vendapagto);
    }
    
    public void adicionar(VendaPagtoModel vendapagto) throws SQLException{
        VendaPagtoDao dao = new VendaPagtoDao();
        dao.adicionar(vendapagto);
    }
    
    public void alterar(VendaPagtoModel vendapagto) throws SQLException{
        VendaPagtoDao dao = new VendaPagtoDao();
        dao.alterar(vendapagto);
    }
    
    public void gravar(String operacao, VendaPagtoModel vendapagto) throws SQLException{
        boolean retorno = true;
        if (operacao.equals("incluir")) {
            adicionar(vendapagto);
        } else if (operacao.equals("alterar")) {
            alterar(vendapagto);
        }
    }
}
