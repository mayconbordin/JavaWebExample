package com.app.util.controller;

import com.app.util.validator.ValidatorException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.ParametersInterceptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author maycon
 */
public class Controller extends ActionSupport implements ServletRequestAware {
    public static final String SUCCESS_SAVE = "successSave";
    public static final String SUCCESS_DELETE = "successDelete";

    private boolean save = false;

    private String status;

    protected HttpServletRequest request;

    public void statusHandler() {
        if (status != null) {
            String message = getText("status." + status);
            List messages = new ArrayList();
            messages.add(message);

            setActionMessages(messages);
        }
    }

    public void errorHandler(Exception ex) {
        if (ex instanceof ValidatorException) {
            Map errors = new HashMap();

            for (ConstraintViolation constraint : ((ValidatorException)ex).getConstraintViolations()) {
                List message = new ArrayList();
                message.add(constraint.getMessage());
                errors.put(constraint.getPropertyPath().toString(), message);
            }

            setFieldErrors(errors);
        } else {
            List error = new ArrayList();
            error.add(ex.getMessage());
            setActionErrors(error);
        }
    }

    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    public HttpServletRequest getServletRequest() {
        return request;
    }

    /**
     * @return the save
     */
    public boolean isSave() {
        return save;
    }

    /**
     * @param save the save to set
     */
    public void setSave(boolean save) {
        this.save = save;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
