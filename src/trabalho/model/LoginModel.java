
package trabalho.model;

public class LoginModel {

    private String USU_LOGIN;
    private String USU_SENHA;

    public LoginModel() {
    }
    
    public LoginModel(String USU_LOGIN, String USU_SENHA) {
        this.USU_LOGIN = USU_LOGIN;
        this.USU_SENHA = USU_SENHA;
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
}
