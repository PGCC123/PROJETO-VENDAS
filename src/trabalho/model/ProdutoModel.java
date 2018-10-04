package trabalho.model;

public class ProdutoModel {

    private int PRO_CODIGO;
    private String PRO_NOME;
    private int PRO_ESTOQUE;
    private int PRO_UNIDADE;
    private double PRO_PRECO;
    private double PRO_CUSTO;
    private double PRO_ATACADO;
    private double PRO_MIN;
    private double PRO_MAX;
    private double PRO_EMBALAGEM;
    private double PRO_PESO;
    private String PRO_CADASTRO;
    private String PRO_OBS;
    private String PRO_ATIVO;

    public ProdutoModel() {
    }

    public ProdutoModel(int PRO_CODIGO, String PRO_NOME, int PRO_ESTOQUE, int PRO_UNIDADE, double PRO_PRECO, double PRO_CUSTO, double PRO_ATACADO, double PRO_MIN, double PRO_MAX, double PRO_EMBALAGEM, double PRO_PESO, String PRO_CADASTRO, String PRO_OBS, String PRO_ATIVO) {
        this.PRO_CODIGO = PRO_CODIGO;
        this.PRO_NOME = PRO_NOME;
        this.PRO_ESTOQUE = PRO_ESTOQUE;
        this.PRO_UNIDADE = PRO_UNIDADE;
        this.PRO_PRECO = PRO_PRECO;
        this.PRO_CUSTO = PRO_CUSTO;
        this.PRO_ATACADO = PRO_ATACADO;
        this.PRO_MIN = PRO_MIN;
        this.PRO_MAX = PRO_MAX;
        this.PRO_EMBALAGEM = PRO_EMBALAGEM;
        this.PRO_PESO = PRO_PESO;
        this.PRO_CADASTRO = PRO_CADASTRO;
        this.PRO_OBS = PRO_OBS;
        this.PRO_ATIVO = PRO_ATIVO;
    }

    public int getPRO_CODIGO() {
        return PRO_CODIGO;
    }

    public void setPRO_CODIGO(int PRO_CODIGO) {
        this.PRO_CODIGO = PRO_CODIGO;
    }

    public String getPRO_NOME() {
        return PRO_NOME;
    }

    public void setPRO_NOME(String PRO_NOME) {
        this.PRO_NOME = PRO_NOME;
    }

    public int getPRO_ESTOQUE() {
        return PRO_ESTOQUE;
    }

    public void setPRO_ESTOQUE(int PRO_ESTOQUE) {
        this.PRO_ESTOQUE = PRO_ESTOQUE;
    }

    public int getPRO_UNIDADE() {
        return PRO_UNIDADE;
    }

    public void setPRO_UNIDADE(int PRO_UNIDADE) {
        this.PRO_UNIDADE = PRO_UNIDADE;
    }

    public double getPRO_PRECO() {
        return PRO_PRECO;
    }

    public void setPRO_PRECO(double PRO_PRECO) {
        this.PRO_PRECO = PRO_PRECO;
    }

    public double getPRO_CUSTO() {
        return PRO_CUSTO;
    }

    public void setPRO_CUSTO(double PRO_CUSTO) {
        this.PRO_CUSTO = PRO_CUSTO;
    }

    public double getPRO_ATACADO() {
        return PRO_ATACADO;
    }

    public void setPRO_ATACADO(double PRO_ATACADO) {
        this.PRO_ATACADO = PRO_ATACADO;
    }

    public double getPRO_MIN() {
        return PRO_MIN;
    }

    public void setPRO_MIN(double PRO_MIN) {
        this.PRO_MIN = PRO_MIN;
    }

    public double getPRO_MAX() {
        return PRO_MAX;
    }

    public void setPRO_MAX(double PRO_MAX) {
        this.PRO_MAX = PRO_MAX;
    }

    public double getPRO_EMBALAGEM() {
        return PRO_EMBALAGEM;
    }

    public void setPRO_EMBALAGEM(double PRO_EMBALAGEM) {
        this.PRO_EMBALAGEM = PRO_EMBALAGEM;
    }

    public double getPRO_PESO() {
        return PRO_PESO;
    }

    public void setPRO_PESO(double PRO_PESO) {
        this.PRO_PESO = PRO_PESO;
    }

    public String getPRO_CADASTRO() {
        return PRO_CADASTRO;
    }

    public void setPRO_CADASTRO(String PRO_CADASTRO) {
        this.PRO_CADASTRO = PRO_CADASTRO;
    }

    public String getPRO_OBS() {
        return PRO_OBS;
    }

    public void setPRO_OBS(String PRO_OBS) {
        this.PRO_OBS = PRO_OBS;
    }

    public String getPRO_ATIVO() {
        return PRO_ATIVO;
    }

    public void setPRO_ATIVO(String PRO_ATIVO) {
        this.PRO_ATIVO = PRO_ATIVO;
    }
}
