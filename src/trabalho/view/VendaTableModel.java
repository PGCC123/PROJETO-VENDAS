/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.view;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import trabalho.model.VendaModel;

public class VendaTableModel extends AbstractTableModel{
    private ArrayList<VendaModel> linhas;
    String[] colunas;

    public VendaTableModel(ArrayList<VendaModel> arrayvenda,String[] colunas) {
        this.colunas = colunas;
        linhas = arrayvenda;
    }

    //Retorna a quantidade de colunas do modelo, que no caso será fixa
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    //Retorna a quantidade de linhas atual do objeto, que no caso é o tamnho da lista
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    //Retorna o nome da coluna, recebendo seu índice
    @Override
    public String getColumnName(int indiceColuna) {
        return colunas[indiceColuna];
    }

    @Override
    public Object getValueAt(int row, int col) {
        VendaModel venda = (VendaModel) linhas.get(row);
        //PessoaModel pessoa = new PessoaModel() ;
        switch (col) {
            case 0:
              return venda.getVDA_CODIGO();
            case 1:
               return venda.getUSU_MODEL().getUSU_CODIGO();
            case 2:
                return venda.getCLI_MODEL().getCLI_CODIGO();
            case 3:
                return venda.getVDA_VALOR();
            case 4:
                return venda.getVDA_DESCONTO();
            case 5:
                return venda.getVDA_TOTAL();
            case 6:
               return venda.getVDA_OBS();
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de UsuarioModel
    public void addLista(ArrayList<VendaModel> venda) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhas.addAll(venda);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
}
