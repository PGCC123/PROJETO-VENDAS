package trabalho.model;

public class VendaProdutoModel {
    
    private int VEP_CODIGO;
    private VendaModel VDA_MODEL;
    private ProdutoModel PRO_MODEL;
    private  int VEP_QTDE;
    private double VEP_PRECO;
    private double VEP_DESCONTO;
    private double VEP_TOTAL;

    public VendaProdutoModel() {
    }

    public VendaProdutoModel(int VEP_CODIGO, VendaModel VDA_MODEL, ProdutoModel PRO_MODEL, int VEP_QTDE, double VEP_PRECO, double VEP_DESCONTO, double VEP_TOTAL) {
        this.VEP_CODIGO = VEP_CODIGO;
        this.VDA_MODEL = VDA_MODEL;
        this.PRO_MODEL = PRO_MODEL;
        this.VEP_QTDE = VEP_QTDE;
        this.VEP_PRECO = VEP_PRECO;
        this.VEP_DESCONTO = VEP_DESCONTO;
        this.VEP_TOTAL = VEP_TOTAL;
    }

    public int getVEP_CODIGO() {
        return VEP_CODIGO;
    }

    public void setVEP_CODIGO(int VEP_CODIGO) {
        this.VEP_CODIGO = VEP_CODIGO;
    }

    public VendaModel getVDA_MODEL() {
        return VDA_MODEL;
    }

    public void setVDA_MODEL(VendaModel VDA_MODEL) {
        this.VDA_MODEL = VDA_MODEL;
    }

    public ProdutoModel getPRO_MODEL() {
        return PRO_MODEL;
    }

    public void setPRO_MODEL(ProdutoModel PRO_MODEL) {
        this.PRO_MODEL = PRO_MODEL;
    }

    public int getVEP_QTDE() {
        return VEP_QTDE;
    }

    public void setVEP_QTDE(int VEP_QTDE) {
        this.VEP_QTDE = VEP_QTDE;
    }

    public double getVEP_PRECO() {
        return VEP_PRECO;
    }

    public void setVEP_PRECO(double VEP_PRECO) {
        this.VEP_PRECO = VEP_PRECO;
    }

    public double getVEP_DESCONTO() {
        return VEP_DESCONTO;
    }

    public void setVEP_DESCONTO(double VEP_DESCONTO) {
        this.VEP_DESCONTO = VEP_DESCONTO;
    }

    public double getVEP_TOTAL() {
        return VEP_TOTAL;
    }

    public void setVEP_TOTAL(double VEP_TOTAL) {
        this.VEP_TOTAL = VEP_TOTAL;
    }
}
