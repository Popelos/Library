package popelos.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import popelos.interfaces.ICrudDao;


public abstract class SuperDao<E> implements ICrudDao<E> {

    @Autowired
    private SessionFactory sessionFactory;
    Logger logger = Logger.getLogger(SuperDao.class);

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<E> findAll(String namedQuery) {
        Query query = getSession().createNamedQuery(namedQuery);
        List<E> items = query.getResultList();
        return items;
    }

    public E findById(int id, String nameQuery) {
        Session session = getSession();
        Query query = session.getNamedQuery(nameQuery);
        query.setParameter("id", id);
        E entity = null;
        try {
            entity = (E) query.getSingleResult();
        } catch (NoResultException nre) {
            logger.log(Logger.Level.WARN, ">>>>>>>>findById:NoResultException:Entity with id=" + id + " not found!!!");
        }
        return entity;
    }

    @Override
    public Serializable add(E e) {
        Session session = getSession();
        Serializable identifier = session.save(e);
        return identifier;
    }

    @Override
    public void update(E e) {
        Session session = getSession();
        session.saveOrUpdate(e);
    }
    
    public String remove(int id, String namedQuery) {
        Session session = getSession();
        int indexOfPeriod = namedQuery.indexOf("."); // seperate the enity from the named query
        String entity = namedQuery.substring(0, indexOfPeriod);
        org.hibernate.query.Query q = session.createNamedQuery(namedQuery);
        q.setParameter("id", id);
        String message;
        try {
            int numberOfEntitiesDeleted = q.executeUpdate();
            if(numberOfEntitiesDeleted > 0){
                message = entity+ " deleted successfully!!";
            }else{
                message = entity+ " with id:"+id+" not found!!";
            }
        } catch (PersistenceException e) {
            message = entity+ " cannot be deleted";
        }
        return message;
    }
    
    
}
