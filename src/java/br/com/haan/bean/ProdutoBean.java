package br.com.haan.bean;

import br.com.haan.dao.ProdutoDAO;
import br.com.vo.Produto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

@ManagedBean
@SessionScoped
public class ProdutoBean {

    private EntityManager manager;
    private Produto produto;

    public ProdutoBean() {
        produto = new Produto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String salvar() {
        new ProdutoDAO().salvar(produto);
        produto = new Produto();
        return "telaInicial.xhtml";
    }

}
