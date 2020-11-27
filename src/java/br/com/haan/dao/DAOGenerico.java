
package br.com.haan.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public abstract class DAOGenerico <T> {
    
    private Session sessao;
    private Class classe;
    
    public DAOGenerico (Class classe){
        this.classe = classe;
        this.sessao = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void salvar (T t){
        this.sessao.beginTransaction();
        this.sessao.save(t);
        this.sessao.getTransaction().commit();
        this.sessao.close();
    }
    
    public void remover (T t){
        this.sessao.beginTransaction();
        this.sessao.delete(t);
        this.sessao.getTransaction().commit();
        this.sessao.close();
    }
    
    public void atualizar (T t){
        this.sessao.beginTransaction();
        this.sessao.update(t);
        this.sessao.getTransaction().commit();
        this.sessao.close();
    }
    
    public List<T> listarTudo(){
        List<T> lista;
        this.sessao.beginTransaction();
        lista= sessao.createCriteria(classe).list();
        this.sessao.getTransaction().commit();
        this.sessao.close();
        return lista;
    }
    
    public List<T> listar(String SQL, String [] valores){
        List<T> lista;
        this.sessao.beginTransaction();
        Query query= sessao.createSQLQuery(SQL);
        for (int i=0; i<valores.length; i++){
            query.setString(i, valores[i]);
        }
        
        lista=query.list(); 
        this.sessao.getTransaction().commit();
        this.sessao.close();
        return lista;
    }
    
}
