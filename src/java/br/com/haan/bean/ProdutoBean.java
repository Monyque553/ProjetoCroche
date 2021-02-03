package br.com.haan.bean;

import br.com.haan.bo.ProdutoBO;
import br.com.haan.dao.ProdutoDAO;
import br.com.vo.Produto;
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

public class ProdutoBean implements Serializable {

    private Produto produto;
    private Produto produtoSelecionado;
    private List<Produto> lista;
    private List<Produto> listaFiltrada;
    private Produto produtoParaComprar;
    private EntityManager manager;
    
    public ProdutoBean() {
        produto = new Produto();
        lista = new ProdutoDAO().listarTudo();
        listaFiltrada = new ArrayList<Produto>();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> listar() {
        return new ProdutoDAO().listarTudo();
        // como seria a consulta para vir ordenado???
        // String sql= " select * from Produto order by nome asc;"
        // String´[] param = {};
        // return new ProdutoDAO().listar(sql,param);
    }

    public List<Produto> listarProdutosOk() {

        return ProdutoBO.listarProdutoOk();
    }

    public void remover() {
        new ProdutoDAO().remover(produtoSelecionado);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Removido com Sucesso", "O Produto " + produtoSelecionado.getNome() + " foi removido.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        lista = new ProdutoDAO().listarTudo();
    }

    public String prepararParaAtualizar() {
        produto = produtoSelecionado;
        return "addProduto.xhtml";
    }

    public String prepararParaAlugar() {
        return "alugar.xhtml";
    }

    public String salvar() {

        if (produto.getId() != 0) {
            new ProdutoDAO().atualizar(produto);
        } else {
            new ProdutoDAO().salvar(this.produto);
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
     * @return the produtoSelecionado
     */
    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    /**
     * @param produtoSelecionado the produtoSelecionado to set
     */
    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    /**
     * @return the lista
     */
    public List<Produto> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Produto> lista) {
        this.lista = lista;
    }

    /**
     * @return the listaFiltrada
     */
    public List<Produto> getListaFiltrada() {
        return listaFiltrada;
    }

    /**
     * @param listaFiltrada the listaFiltrada to set
     */
    public void setListaFiltrada(List<Produto> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    /**
     * @return the produtoParaComprar
     */
    public Produto getProdutoParaComprar() {
        return produtoParaComprar;
    }

    /**
     * @param produtoParaComprar the produtoParaComprar to set
     */
    public void setProdutoParaComprar(Produto produtoParaComprar) {
        this.produtoParaComprar = produtoParaComprar;
    }

}
