package trabalho.model;

public class FornecedorModel {

    private int FOR_CODIGO;
    private String FOR_CONTATO;
    private PessoaModel PES_MODEL;
    
   public FornecedorModel() {
       
   }

    public FornecedorModel(int FOR_CODIGO, String FOR_CONTATO, PessoaModel PES_MODEL) {
        this.FOR_CODIGO = FOR_CODIGO;
        this.FOR_CONTATO = FOR_CONTATO;
        this.PES_MODEL = PES_MODEL;
    }

    public int getFOR_CODIGO() {
        return FOR_CODIGO;
    }

    public void setFOR_CODIGO(int FOR_CODIGO) {
        this.FOR_CODIGO = FOR_CODIGO;
    }

    public String getFOR_CONTATO() {
        return FOR_CONTATO;
    }

    public void setFOR_CONTATO(String FOR_CONTATO) {
        this.FOR_CONTATO = FOR_CONTATO;
    }

    public PessoaModel getPES_MODEL() {
        return PES_MODEL;
    }

    public void setPES_MODEL(PessoaModel PES_MODEL) {
        this.PES_MODEL = PES_MODEL;
    }  
}
