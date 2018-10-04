package trabalho.view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import trabalho.model.PessoaModel;


public class PessoaTableModel extends AbstractTableModel {

    private ArrayList<PessoaModel> linhas;
    String[] colunas;

    public PessoaTableModel(ArrayList<PessoaModel> arraypessoa, String[] colunas) {
        this.colunas = colunas;
        linhas = arraypessoa;
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
        PessoaModel pessoa = (PessoaModel) linhas.get(row);
        switch (col) {
            case 0:
                return pessoa.getPES_CODIGO();
            case 1:
                return pessoa.getPES_NOME();
            case 2:
                return pessoa.getPES_FISICA();
            case 3:
                return pessoa.getPES_CPFCNPJ();
            case 4:
                return pessoa.getPES_ENDERECO();
            case 5:
                return pessoa.getPES_NUMERO();
            case 6:
                return pessoa.getPES_BAIRRO();
            case 7:
                return pessoa.getPES_CIDADE();
            case 8:
                return pessoa.getPES_UF();
            case 9:
                return pessoa.getPES_CELULAR();
            case 10:
                return pessoa.getPES_ATIVO();
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de PESenteModel
    public void addLista(ArrayList<PessoaModel> pessoa) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhas.addAll(pessoa);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
}
