package trabalho.model;

public class VendaModel {
    
    private int VDA_CODIGO;
    private UsuarioModel USU_MODEL;
    private ClienteModel CLI_MODEL;
    private String VDA_DATA;
    private double VDA_VALOR;
    private double VDA_DESCONTO;
    private double VDA_TOTAL;
    private String VDA_OBS;

    public VendaModel() {
    }

    public VendaModel(int VDA_CODIGO, UsuarioModel USU_MODEL, ClienteModel CLI_MODEL, String VDA_DATA, double VDA_VALOR, double VDA_DESCONTO, double VDA_TOTAL, String VDA_OBS) {
        this.VDA_CODIGO = VDA_CODIGO;
        this.USU_MODEL = USU_MODEL;
        this.CLI_MODEL = CLI_MODEL;
        this.VDA_DATA = VDA_DATA;
        this.VDA_VALOR = VDA_VALOR;
        this.VDA_DESCONTO = VDA_DESCONTO;
        this.VDA_TOTAL = VDA_TOTAL;
        this.VDA_OBS = VDA_OBS;
    }

    public int getVDA_CODIGO() {
        return VDA_CODIGO;
    }

    public void setVDA_CODIGO(int VDA_CODIGO) {
        this.VDA_CODIGO = VDA_CODIGO;
    }

    public UsuarioModel getUSU_MODEL() {
        return USU_MODEL;
    }

    public void setUSU_MODEL(UsuarioModel USU_MODEL) {
        this.USU_MODEL = USU_MODEL;
    }

    public ClienteModel getCLI_MODEL() {
        return CLI_MODEL;
    }

    public void setCLI_MODEL(ClienteModel CLI_MODEL) {
        this.CLI_MODEL = CLI_MODEL;
    }

    public String getVDA_DATA() {
        return VDA_DATA;
    }

    public void setVDA_DATA(String VDA_DATA) {
        this.VDA_DATA = VDA_DATA;
    }

    public double getVDA_VALOR() {
        return VDA_VALOR;
    }

    public void setVDA_VALOR(double VDA_VALOR) {
        this.VDA_VALOR = VDA_VALOR;
    }

    public double getVDA_DESCONTO() {
        return VDA_DESCONTO;
    }

    public void setVDA_DESCONTO(double VDA_DESCONTO) {
        this.VDA_DESCONTO = VDA_DESCONTO;
    }

    public double getVDA_TOTAL() {
        return VDA_TOTAL;
    }

    public void setVDA_TOTAL(double VDA_TOTAL) {
        this.VDA_TOTAL = VDA_TOTAL;
    }

    public String getVDA_OBS() {
        return VDA_OBS;
    }

    public void setVDA_OBS(String VDA_OBS) {
        this.VDA_OBS = VDA_OBS;
    }
}
