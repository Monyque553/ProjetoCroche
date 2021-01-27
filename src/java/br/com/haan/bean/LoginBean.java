
package br.com.haan.bean;
import br.com.vo.Login;

public class LoginBean {
    private Login login;
    
    public LoginBean(){
        login = new Login();
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public String salvar(){
        login= new Login();
        return "telaInicial.xhtml";
    }
}
