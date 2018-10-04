package trabalho.view;

import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import trabalho.model.VendaProdutoModel;

public class VendaProdutoTableModel extends AbstractTableModel {
    private final NumberFormat NFC = NumberFormat.getCurrencyInstance();
    private ArrayList<VendaProdutoModel> linhas;
    String[] colunas;

    public VendaProdutoTableModel(ArrayList<VendaProdutoModel> linhas, String[] colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    //Retorna o nome da coluna, recebendo seu índice
    @Override
    public String getColumnName(int indiceColuna) {
        return colunas[indiceColuna];
    }

    @Override
    public Object getValueAt(int row, int col) {
        VendaProdutoModel vendapro = (VendaProdutoModel) linhas.get(row);
        switch (col) {
            case 0:
                return vendapro.getPRO_MODEL().getPRO_CODIGO();
            case 1:
                return vendapro.getPRO_MODEL().getPRO_NOME();
            case 2:
                return vendapro.getVEP_QTDE();
            case 3:
                return NFC.format(vendapro.getVEP_PRECO());
            case 4:
                return NFC.format(vendapro.getVEP_DESCONTO());
            case 5:
                return NFC.format(vendapro.getVEP_TOTAL());
            default:
                return null;
        }
    }
}
