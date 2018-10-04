package trabalho.model;

public class ClienteModel {

    private int CLI_CODIGO;
    private double CLI_LIMITECRED;
    private PessoaModel pessoamodel; 


    
        public ClienteModel() {
    }

    public ClienteModel(int CLI_CODIGO, double CLI_LIMITECRED, PessoaModel pessoamodel ) {
        this.CLI_CODIGO = CLI_CODIGO;
        this.CLI_LIMITECRED = CLI_LIMITECRED;
        this.pessoamodel = pessoamodel;

    }
    
    public PessoaModel getPessoamodel() {
        return pessoamodel;
    }

    public void setPessoamodel(PessoaModel pessoamodel) {
        this.pessoamodel = pessoamodel;
    }

    public int getCLI_CODIGO() {
        return CLI_CODIGO;
    }

    public void setCLI_CODIGO(int CLI_CODIGO) {
        this.CLI_CODIGO = CLI_CODIGO;
    }

    public double getCLI_LIMITECRED() {
        return CLI_LIMITECRED;
    }

    public void setCLI_LIMITECRED(double CLI_LIMITECRED) {
        this.CLI_LIMITECRED = CLI_LIMITECRED;
    }
}
