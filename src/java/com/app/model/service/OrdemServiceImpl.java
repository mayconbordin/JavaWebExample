package com.app.model.service;

import com.app.model.repository.OrdemRepository;
import com.app.model.repository.OrdemRepositoryHibernate;
import com.app.model.entity.Ordem;
import com.app.util.repository.RepositoryException;
import com.app.util.validator.ValidatorException;
import com.app.util.validator.ValidatorImpl;
import java.util.List;

/**
 *
 * @author maycon
 */
public class OrdemServiceImpl implements OrdemService {
    private OrdemRepository ordemRepository;
    private ValidatorImpl validator;

    public OrdemServiceImpl() {}

    public OrdemServiceImpl(OrdemRepository ordemRepository) {
        this.ordemRepository = ordemRepository;
    }

    public void save(Ordem ordem) throws RepositoryException, ValidatorException {
        getValidator().validate(ordem);
        ordem.calcularTotal();
        getOrdemRepository().save(ordem);
    }

    public void delete(Integer id) throws RepositoryException {
        Ordem ordem = getOrdemRepository().findById(id);
        getOrdemRepository().delete(ordem);
    }

    public List<Ordem> findAll() throws RepositoryException {
        return getOrdemRepository().findAll();
    }

    public List<Ordem> findAll(String orderBy, String orderType) throws RepositoryException {
        return getOrdemRepository().findAll(orderBy, orderType);
    }

    public Ordem findById(Integer id) throws RepositoryException {
        return getOrdemRepository().findById(id);
    }

    /**
     * @return the dao
     */
    public OrdemRepository getOrdemRepository() {
        if (ordemRepository == null) {
            setOrdemRepository(new OrdemRepositoryHibernate());
        }

        return ordemRepository;
    }

    /**
     * @param ordemRepository the dao to set
     */
    public void setOrdemRepository(OrdemRepository ordemRepository) {
        this.ordemRepository = ordemRepository;
    }

    /**
     * @return the validator
     */
    public ValidatorImpl getValidator() {
        if (validator == null) {
            setValidator(new ValidatorImpl<Ordem>());
        }
        return validator;
    }

    /**
     * @param validator the validator to set
     */
    public void setValidator(ValidatorImpl validator) {
        this.validator = validator;
    }
}
