package trabalho.model;

public class PagamentoModel {
    private int FPG_CODIGO;
    private String FPG_NOME;
    private String FPG_ATIVO; 

    public PagamentoModel() {
    }

    /**
     *@autor : Patrick carpezani
    *@funcionalidade: método construtor para inicialização dos atributos da classe.
    *@data: 14/09/2018
    */
    public PagamentoModel(int FPG_CODIGO, String FPG_NOME, String FPG_ATIVO) {
        this.FPG_CODIGO = FPG_CODIGO;
        this.FPG_NOME = FPG_NOME;
        this.FPG_ATIVO = FPG_ATIVO;
    }

   /**
     *@autor: Patrick carpezani
    *@funcionalidade:encapsulamento dos atributos para restringir o acesso.
    *@data: 14/09/2018
    */
    public int getFPG_CODIGO() {
        return FPG_CODIGO;
    }

    public void setFPG_CODIGO(int FPG_CODIGO) {
        this.FPG_CODIGO = FPG_CODIGO;
    }

    public String getFPG_NOME() {
        return FPG_NOME;
    }

    public void setFPG_NOME(String FPG_NOME) {
        this.FPG_NOME = FPG_NOME;
    }

    public String getFPG_ATIVO() {
        return FPG_ATIVO;
    }

    public void setFPG_ATIVO(String FPG_ATIVO) {
        this.FPG_ATIVO = FPG_ATIVO;
    }
}
