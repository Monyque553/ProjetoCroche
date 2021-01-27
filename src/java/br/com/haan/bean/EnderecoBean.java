
package br.com.haan.bean;

import br.com.haan.dao.EnderecoDAO;
import br.com.vo.Endereco;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EnderecoBean {
      private Endereco endereco;
    
    public EnderecoBean(){
        endereco = new Endereco();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public String salvar(){
        new EnderecoDAO().salvar(endereco);
        endereco= new Endereco();
        return "telaInicial.xhtml";
    }
}
