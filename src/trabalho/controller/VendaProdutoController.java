
package trabalho.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalho.dao.VendaProdutoDao;
import trabalho.model.VendaProdutoModel;

public class VendaProdutoController {
    private List<VendaProdutoModel> listaVendaProduto;
    
    public ArrayList<VendaProdutoModel> consultar(String filtro) throws SQLException {
        listaVendaProduto = new VendaProdutoDao().consultar(filtro);
        return (ArrayList<VendaProdutoModel>) listaVendaProduto;
    }
    public ArrayList<VendaProdutoModel> consultarItensVenda(String filtro) throws SQLException {
        listaVendaProduto = new VendaProdutoDao().consultarItensVenda(filtro);
        return (ArrayList<VendaProdutoModel>) listaVendaProduto;
    }
    
    public ArrayList<VendaProdutoModel> consultarSubTotal(String filtro) throws SQLException {
        listaVendaProduto = new VendaProdutoDao().consultarSubTotal(filtro);
        return (ArrayList<VendaProdutoModel>) listaVendaProduto;
    }
    
    public void excluir(VendaProdutoModel vendaProduto) throws SQLException{
        VendaProdutoDao dao = new VendaProdutoDao();
        dao.excluir(vendaProduto);
    }
    
    public void adicionar(VendaProdutoModel vendaProduto) throws SQLException{
        VendaProdutoDao dao = new VendaProdutoDao();
        dao.adicionar(vendaProduto);
    }
    
    public void alterar(VendaProdutoModel vendaProduto) throws SQLException{
        VendaProdutoDao dao = new VendaProdutoDao();
        dao.alterar(vendaProduto);
    }
    
    public void gravar(String operacao, VendaProdutoModel vendaProduto) throws SQLException{
        boolean retorno = true;
        if (operacao.equals("incluir")) {
            adicionar(vendaProduto);
        } else if (operacao.equals("alterar")) {
            alterar(vendaProduto);
        }
    }
}
