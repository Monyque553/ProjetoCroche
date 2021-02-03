package br.com.haan.bean;

import br.com.haan.bo.UsuarioBO;
import br.com.haan.dao.UsuarioDAO;
import br.com.vo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

@ManagedBean
@SessionScoped

public class UsuarioBean implements Serializable {

    private Usuario usuario;
    private Usuario usuarioSelecionado;
    private List<Usuario> lista;
    private List<Usuario> listaFiltrada;
    private Usuario usuarioParaComprar;
    private EntityManager manager;
    
    public UsuarioBean() {
        usuario = new Usuario();
        lista = new UsuarioDAO().listarTudo();
        listaFiltrada = new ArrayList<Usuario>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> listar() {
        return new UsuarioDAO().listarTudo();
        // como seria a consulta para vir ordenado???
        // String sql= " select * from Usuario order by nome asc;"
        // String´[] param = {};
        // return new UsuarioDAO().listar(sql,param);
    }

    public List<Usuario> listarUsuariosOk() {

        return UsuarioBO.listarUsuariosOk();
    }

    public void remover() {
        new UsuarioDAO().remover(usuarioSelecionado);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Removido com Sucesso", "O Usuario " + usuarioSelecionado.getNome() + " foi removido.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        lista = new UsuarioDAO().listarTudo();
    }

    public String prepararParaAtualizar() {
        usuario = usuarioSelecionado;
        return "addUsuario.xhtml";
    }

    public String prepararParaAlugar() {
        return "alugar.xhtml";
    }

    public String salvar() {

        if (usuario.getId() != 0) {
            new UsuarioDAO().atualizar(usuario);
        } else {
            new UsuarioDAO().salvar(this.usuario);
        }
        return "telaInicial.xhtml";

    }

    /**
     * @return the manager
     */
    public EntityManager getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    /**
     * @return the usuarioSelecionado
     */
    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    /**
     * @param usuarioSelecionado the usuarioSelecionado to set
     */
    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    /**
     * @return the lista
     */
    public List<Usuario> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    /**
     * @return the listaFiltrada
     */
    public List<Usuario> getListaFiltrada() {
        return listaFiltrada;
    }

    /**
     * @param listaFiltrada the listaFiltrada to set
     */
    public void setListaFiltrada(List<Usuario> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    /**
     * @return the usuarioParaComprar
     */
    public Usuario getUsuarioParaComprar() {
        return usuarioParaComprar;
    }

    /**
     * @param usuarioParaComprar the usuarioParaComprar to set
     */
    public void setUsuarioParaComprar(Usuario usuarioParaComprar) {
        this.usuarioParaComprar = usuarioParaComprar;
    }

}
