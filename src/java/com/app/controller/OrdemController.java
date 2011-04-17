package com.app.controller;

import com.app.model.entity.Ordem;
import com.app.model.service.OrdemService;
import com.app.model.service.OrdemServiceImpl;
import com.app.util.controller.Controller;
import com.app.util.repository.RepositoryException;
import com.app.util.validator.ValidatorException;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maycon
 */
public class OrdemController extends Controller implements ModelDriven<Ordem> {

    private OrdemService ordemService;

    private Ordem ordem = new Ordem();
    private List<Ordem> ordemList = new ArrayList();
    private Integer id;

    public String index() {
        try {
            ordemList = getOrdemService().findAll("codigo", "asc");
        } catch (RepositoryException ex) {
            errorHandler(ex);
        }

        statusHandler();

        return SUCCESS;
    }

    public String edit() {
        try {
            if (isSave()) {
                getOrdemService().save(ordem);
                return SUCCESS_SAVE;
            } else {
                ordem = getOrdemService().findById(id);
            }
        } catch (RepositoryException ex) {
            errorHandler(ex);
        } catch (ValidatorException ex) {
            errorHandler(ex);
        }

        return SUCCESS;
    }

    public String add() {
        try {
            if (isSave()) {
                getOrdemService().save(ordem);
                return SUCCESS_SAVE;
            }
        } catch (RepositoryException ex) {
            errorHandler(ex);
        } catch (ValidatorException ex) {
            errorHandler(ex);
        }

        return SUCCESS;
    }

    public void delete() {
        try {
            getOrdemService().delete(id);
        } catch (RepositoryException ex) {
            errorHandler(ex);
        }
    }

    /**
     * @return the dao
     */
    public OrdemService getOrdemService() {
        if (ordemService == null) {
            setOrdemService(new OrdemServiceImpl());
        }
        
        return ordemService;
    }

    /**
     * @param ordemRepository the dao to set
     */
    public void setOrdemService(OrdemService ordemService) {
        this.ordemService = ordemService;
    }

    /**
     * @return the ordemList
     */
    public List<Ordem> getOrdemList() {
        return ordemList;
    }

    /**
     * @param ordemList the ordemList to set
     */
    public void setOrdemList(List<Ordem> ordemList) {
        this.ordemList = ordemList;
    }

    /**
     * @return the ordem
     */
    public Ordem getOrdem() {
        return ordem;
    }

    /**
     * @param ordem the ordem to set
     */
    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Ordem getModel() {
        return ordem;
    }
}