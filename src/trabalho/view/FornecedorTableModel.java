package trabalho.view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import trabalho.model.ClienteModel;
import trabalho.model.FornecedorModel;
import trabalho.model.PessoaModel;

public class FornecedorTableModel extends AbstractTableModel {

    private ArrayList<FornecedorModel> linhas;
    String[] colunas;

    public FornecedorTableModel(ArrayList<FornecedorModel> arrayfornecedor, String[] colunas) {
        this.colunas = colunas;
        linhas = arrayfornecedor;
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

        FornecedorModel fornecedor = (FornecedorModel) linhas.get(row);

        switch (col) {
            case 0:
                return fornecedor.getFOR_CODIGO();
            case 1:
                return fornecedor.getPES_MODEL().getPES_NOME();
            case 2:
                return fornecedor.getPES_MODEL().getPES_CPFCNPJ();
            case 3:
                return fornecedor.getPES_MODEL().getPES_RGIE();
            case 4:
                return fornecedor.getPES_MODEL().getPES_ATIVO();
            case 5:
                return fornecedor.getPES_MODEL().getPES_FISICA();
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de clienteModel
    public void addLista(ArrayList<FornecedorModel> fornecedor) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhas.addAll(fornecedor);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
}
