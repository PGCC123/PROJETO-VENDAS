package trabalho.model;

public class UsuarioModel {
    private int USU_CODIGO;
    private String USU_NOME;
    private String USU_LOGIN;
    private String USU_SENHA;
    private String USU_CADASTRO; // MODIFICAÇÃO
    private String USU_ATIVO; 

    public UsuarioModel() {
    }

    public UsuarioModel(int USU_CODIGO, String USU_NOME, String USU_LOGIN, String USU_SENHA, String USU_CADASTRO, String USU_ATIVO) {
        this.USU_CODIGO = USU_CODIGO;
        this.USU_NOME = USU_NOME;
        this.USU_LOGIN = USU_LOGIN;
        this.USU_SENHA = USU_SENHA;
        this.USU_CADASTRO = USU_CADASTRO;
        this.USU_ATIVO = USU_ATIVO;
    }

    public int getUSU_CODIGO() {
        return USU_CODIGO;
    }

    public void setUSU_CODIGO(int USU_CODIGO) {
        this.USU_CODIGO = USU_CODIGO;
    }

    public String getUSU_NOME() {
        return USU_NOME;
    }

    public void setUSU_NOME(String USU_NOME) {
        this.USU_NOME = USU_NOME;
    }

    public String getUSU_LOGIN() {
        return USU_LOGIN;
    }

    public void setUSU_LOGIN(String USU_LOGIN) {
        this.USU_LOGIN = USU_LOGIN;
    }

    public String getUSU_SENHA() {
        return USU_SENHA;
    }

    public void setUSU_SENHA(String USU_SENHA) {
        this.USU_SENHA = USU_SENHA;
    }

    public String getUSU_CADASTRO() {
        return USU_CADASTRO;
    }

    public void setUSU_CADASTRO(String USU_CADASTRO) {
        this.USU_CADASTRO = USU_CADASTRO;
    }

    public String getUSU_ATIVO() {
        return USU_ATIVO;
    }

    public void setUSU_ATIVO(String USU_ATIVO) {
        this.USU_ATIVO = USU_ATIVO;
    }
}
