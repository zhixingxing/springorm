package org.tax.springorm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public abstract class AbstractHibernateDao <E extends Serializable>{
    private Class<E> entityClass;
    private SessionFactory sessionFactory;
     
    protected AbstractHibernateDao(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
 
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
 
    public E findById(Serializable id) {
        return (E) getCurrentSession().get(entityClass, id);
    }
 
    public void save(E e) {
        getCurrentSession().save(e);
    }
 
    public void delete(E e) {
        getCurrentSession().delete(e);
    }
 
    public List<E> query(String hql, Object[] args) {
        Query query=getCurrentSession().createQuery(hql);
        if(args!=null){
            for (int i = 0; i < args.length; i++) {
                query.setParameter(i, args[i]);
            }
        }
        return query.list();
    }

    //setter getter
}