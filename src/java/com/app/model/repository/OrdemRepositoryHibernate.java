package com.app.model.repository;

import com.app.model.entity.Ordem;
import com.app.util.hibernate.GenericRepositoryHibernate;

/**
 *
 * @author maycon
 */
public class OrdemRepositoryHibernate extends GenericRepositoryHibernate<Ordem, Integer> implements OrdemRepository {
    public OrdemRepositoryHibernate() {
        super(Ordem.class);
    }
}
