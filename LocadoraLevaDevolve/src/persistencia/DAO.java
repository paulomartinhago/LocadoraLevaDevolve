package persistencia;

import java.util.List;
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
    
    public List consultar(Class classe)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(classe);
        List results = crit.list();
        
        return results;
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
