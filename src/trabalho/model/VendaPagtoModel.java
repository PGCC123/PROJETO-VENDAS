package trabalho.model;

public class VendaPagtoModel {
    
    private int VDP_CODIGO;
    private VendaModel VDA_MODEL;
    private PagamentoModel FPG_MODEL;
    private double VDP_VALOR;

    public VendaPagtoModel() {
    }

    public VendaPagtoModel(int VDP_CODIGO, VendaModel VDA_MODEL, PagamentoModel FPG_MODEL, double VDP_VALOR) {
        this.VDP_CODIGO = VDP_CODIGO;
        this.VDA_MODEL = VDA_MODEL;
        this.FPG_MODEL = FPG_MODEL;
        this.VDP_VALOR = VDP_VALOR;
    }

    public int getVDP_CODIGO() {
        return VDP_CODIGO;
    }

    public void setVDP_CODIGO(int VDP_CODIGO) {
        this.VDP_CODIGO = VDP_CODIGO;
    }

    public VendaModel getVDA_MODEL() {
        return VDA_MODEL;
    }

    public void setVDA_MODEL(VendaModel VDA_MODEL) {
        this.VDA_MODEL = VDA_MODEL;
    }

    public PagamentoModel getFPG_MODEL() {
        return FPG_MODEL;
    }

    public void setFPG_MODEL(PagamentoModel FPG_MODEL) {
        this.FPG_MODEL = FPG_MODEL;
    }

    public double getVDP_VALOR() {
        return VDP_VALOR;
    }

    public void setVDP_VALOR(double VDP_VALOR) {
        this.VDP_VALOR = VDP_VALOR;
    }
}
