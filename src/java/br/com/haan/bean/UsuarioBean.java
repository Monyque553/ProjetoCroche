
package br.com.haan.bean;

import br.com.haan.dao.UsuarioDAO;
import br.com.vo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

    
@ManagedBean
@SessionScoped
public class UsuarioBean {
         private EntityManager manager;
    private Usuario usuario;
    
    public UsuarioBean(){
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String salvar(){
        new UsuarioDAO().salvar(usuario);
        usuario= new Usuario();
        return "telaInicial.xhtml";
    }
    

}
