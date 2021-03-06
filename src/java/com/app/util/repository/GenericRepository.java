package com.app.util.repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author maycon
 */
public interface GenericRepository<T, ID extends Serializable> {
    public void save(T object) throws RepositoryException;
    public void save(List<T> objects) throws RepositoryException;
    
    public void delete(T object) throws RepositoryException;
    public void delete(List<T> objects) throws RepositoryException;

    public List<T> findAll() throws RepositoryException;
    public List<T> findAll(String orderBy, String orderType) throws RepositoryException;
    public List<T> findAllWithPagination(int min, int max) throws RepositoryException;
    public List<T> findAllWithPagination(int min, int max, String orderBy, String orderType) throws RepositoryException;

    public List<T> findAllByExample(T object) throws RepositoryException;
    public List<T> findAllByExample(T object, String orderBy, String orderType) throws RepositoryException;
    public List<T> findAllByExampleWithPagination(T object, int min, int max) throws RepositoryException;

    public T findByExample(T object) throws RepositoryException;
    public T findById(ID id) throws RepositoryException;

    public Integer count() throws RepositoryException;
}
