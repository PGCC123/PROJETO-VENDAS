package trabalho.view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import trabalho.model.PagamentoModel;

public class PagamentoTableModel extends AbstractTableModel {

    private ArrayList<PagamentoModel> linhas;
    String[] colunas;

    public PagamentoTableModel(ArrayList<PagamentoModel> arraypagamento, String[] colunas) {
        this.colunas = colunas;
        linhas = arraypagamento;
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
        PagamentoModel pagamento = (PagamentoModel) linhas.get(row);
        switch (col) {
            case 0:
                return pagamento.getFPG_CODIGO();
            case 1:
                return pagamento.getFPG_NOME();
            case 2:
               return pagamento.getFPG_ATIVO();
             default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de pagamentoModel
    public void addLista(ArrayList<PagamentoModel> pagamento) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhas.addAll(pagamento);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
}