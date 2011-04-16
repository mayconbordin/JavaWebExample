package com.app.model.service;

import com.app.model.entity.Ordem;
import com.app.util.repository.RepositoryException;
import com.app.util.validator.ValidatorException;
import java.util.List;

/**
 *
 * @author maycon
 */
public interface OrdemService {
    public void save(Ordem ordem) throws RepositoryException, ValidatorException;
    public void delete(Integer id) throws RepositoryException;
    public List<Ordem> findAll() throws RepositoryException;
    public List<Ordem> findAll(String orderBy, String orderType) throws RepositoryException;
    public Ordem findById(Integer id) throws RepositoryException;
}
