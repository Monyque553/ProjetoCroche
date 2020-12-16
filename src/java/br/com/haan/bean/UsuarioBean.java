/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.haan.bean;

import br.com.haan.dao.UsuarioDAO;
import br.com.vo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Helder
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {
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
        return "index.xhtml";
    }
}
