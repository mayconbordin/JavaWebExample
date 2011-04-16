package com.app.util.hibernate;

import com.app.util.repository.RepositoryException;
import com.app.util.repository.GenericRepository;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

/**
 * Classe abstrata para classes DAO. Provê a session para
 * as operações com o Hibernate.
 *
 * @author Maycon Bordin
 * @version 1.0
 * @created 04-out-2010 13:24:50
 */
public class GenericRepositoryHibernate<T, ID extends Serializable> implements GenericRepository<T, ID> {

    private Session session;
    private Class<T> persistentClass;

    /**
     * Construtor da Classe
     */
    public GenericRepositoryHibernate(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    /**
     * @return the session
     */
    public Session getSession() {
        if (session == null) {
            setSession(HibernateUtil.getSession());
        }
        
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * @return the persistentClass
     */
    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void save(T object) throws RepositoryException {
        try {
            Transaction t = getSession().beginTransaction();
            getSession().saveOrUpdate(object);
            t.commit();
        } catch (HibernateException e) {
            throw new RepositoryException(e);
        } catch (Exception e) {
            throw new RepositoryException(e);
        }
    }

    public void save(List<T> objects) throws RepositoryException {
        try {
            Transaction t = getSession().beginTransaction();

            for (T object : objects) {
                getSession().saveOrUpdate(object);
            }

            t.commit();
        } catch (HibernateException e) {
            throw new RepositoryException(e);
        } catch (Exception e) {
            throw new RepositoryException(e);
        }
    }

    public void delete(T object) throws RepositoryException {
        try {
            Transaction t = getSession().beginTransaction();
            getSession().delete(object);
            t.commit();
        } catch (HibernateException ex) {
            throw new RepositoryException(ex);
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }

    public void delete(List<T> objects) throws RepositoryException {
        try {
            Transaction t = getSession().beginTransaction();

            for (T object : objects) {
                getSession().delete(object);
            }

            t.commit();
        } catch (HibernateException ex) {
            throw new RepositoryException(ex);
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }

    public List<T> findAll() throws RepositoryException {
        try {
            return findByCriteria();
        } catch (RepositoryException ex) {
            throw ex;
        }
    }

    public T findById(ID id) throws RepositoryException {
        try {
            T entity = (T) getSession().load(getPersistentClass(), id);

            if (entity == null) {
                throw new RepositoryException();
            }
            
            return entity;
        } catch (HibernateException ex) {
            throw new RepositoryException(ex);
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }

    /**
     *
     * @param criterion Undefined number of arguments (varargs)
     * @return
     */
    protected List<T> findByCriteria(Criterion... criterion) throws RepositoryException {
        try {
            Criteria criteria = getSession().createCriteria(getPersistentClass());
            for (Criterion c : criterion) {
                criteria.add(c);
            }
            return criteria.list();
        } catch (HibernateException ex) {
            throw new RepositoryException(ex);
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }

    protected Integer countByCriterion(Criterion criterion) throws RepositoryException {
        try {
            Criteria c = getSession().createCriteria(getPersistentClass());
            c.add(criterion);
            c.setProjection(Projections.rowCount());
            return (Integer) c.uniqueResult();
        } catch (HibernateException ex) {
            throw new RepositoryException(ex);
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }

    public List<T> findAllByExample(T object) throws RepositoryException {
        try {
            Example example = Example.create(object).ignoreCase()
                              .enableLike(MatchMode.ANYWHERE);

            return findByCriteria(example);
        } catch (HibernateException ex) {
            throw new RepositoryException(ex);
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }

    public List<T> findAllByExample(T object, String orderBy, String orderType) throws RepositoryException {
        try {
            Example example = Example.create(object)
                                     .ignoreCase()
                                     .enableLike(MatchMode.ANYWHERE);
            
            Criteria c = getSession().createCriteria(getPersistentClass());
            c.add(example);

            if (orderType.toLowerCase().equals("desc")) {
                c.addOrder(Order.desc(orderBy));
            } else {
                c.addOrder(Order.asc(orderBy));
            }
            
            return c.list();
        } catch (HibernateException ex) {
            throw new RepositoryException(ex);
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }

    public List<T> findAllByExampleWithPagination(T object, int min, int max) throws RepositoryException {
        try {
            Integer count = 0;

            Example example = Example.create(object)
                                     .ignoreCase()
                                     .enableLike(MatchMode.ANYWHERE);

            Criteria c = getSession().createCriteria(getPersistentClass());
            c.add(example);

            count = countByCriterion(example);

            if (count < max)
                max = count;

            if (min >= 0)
                c.setFirstResult(min);
            if (max >= 0)
                c.setMaxResults(max);

            return c.list();
        } catch (HibernateException ex) {
            throw new RepositoryException(ex);
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }

    public T findByExample(T object) throws RepositoryException {
        try {
            Example example = Example.create(object).ignoreCase();

            Criteria c = getSession().createCriteria(getPersistentClass());
            c.add(example);
            
            return (T) c.uniqueResult();
        } catch (HibernateException ex) {
            throw new RepositoryException(ex);
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }

    public List<T> findAll(String orderBy, String orderType) throws RepositoryException {
        try {
            Criteria c = getSession().createCriteria(getPersistentClass());

            if (orderType.toLowerCase().equals("desc")) {
                c.addOrder(Order.desc(orderBy));
            } else {
                c.addOrder(Order.asc(orderBy));
            }

            return c.list();
        } catch (HibernateException ex) {
            throw new RepositoryException(ex);
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }

    public List<T> findAllWithPagination(int min, int max) throws RepositoryException {
        try {
            Integer count = 0;

            Criteria c = getSession().createCriteria(getPersistentClass());

            count = count();

            if (count < max)
                max = count;

            if (min >= 0)
                c.setFirstResult(min);
            if (max >= 0)
                c.setMaxResults(max);

            return c.list();
        } catch (HibernateException ex) {
            throw new RepositoryException(ex);
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }

    public Integer count() throws RepositoryException {
        try {
            Criteria c = getSession().createCriteria(getPersistentClass());
            Integer count = (Integer) c.setProjection(Projections.rowCount()).uniqueResult();

            return count;
        } catch (HibernateException ex) {
            throw new RepositoryException(ex);
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }

    public List<T> findAllWithPagination(int min, int max, String orderBy, String orderType) throws RepositoryException {
        try {
            Integer count = 0;

            Criteria c = getSession().createCriteria(getPersistentClass());

            if (orderType.toLowerCase().equals("desc")) {
                c.addOrder(Order.desc(orderBy));
            } else {
                c.addOrder(Order.asc(orderBy));
            }

            count = count();

            if (count < max)
                max = count;

            if (min >= 0)
                c.setFirstResult(min);
            if (max >= 0)
                c.setMaxResults(max);

            return c.list();
        } catch (HibernateException ex) {
            throw new RepositoryException(ex);
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
    }
}