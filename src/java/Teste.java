
import br.com.vo.Produto;
public class Teste {
    
    public static void main (String [] args){
        Produto d = new Produto();
        d.setNome("Tapete");
        d.setQuantidade(1);
        d.setValor(50.0);
        
        HibernateUtil.getSessionFactory().openSession().save(d);
    }
    
}
