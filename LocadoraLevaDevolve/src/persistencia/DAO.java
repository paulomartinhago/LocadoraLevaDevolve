package persistencia;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import utils.HibernateUtil;

public class DAO
{
    public void salvar(Object objeto)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(objeto);
        session.getTransaction().commit();
        session.flush(); 
        session.close();
    }
    
    public ObservableList consultar(Class classe){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(classe);
        List results = crit.list();
        session.flush();//LiberaMemoria
        session.close();
        //Convertendo List em ObservableList
        ObservableList lista = FXCollections.observableArrayList();
        for (int i = 0; i < results.size();i++){
            lista.add(results.get(i));
        }
        return lista;
    }
    
    public void update (Object objeto)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(objeto);
        session.getTransaction().commit();
        session.flush(); 
        session.close();
    }
    
    public void delete (Object objeto)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(objeto);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
}
