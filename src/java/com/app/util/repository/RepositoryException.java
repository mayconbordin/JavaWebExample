/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.util.repository;

import com.app.util.exception.ApplicationException;

/**
 *
 * @author maycon
 */
public class RepositoryException extends ApplicationException {
    public RepositoryException() {
        super();
    }

    public RepositoryException( String message ) {
        super(message);
    }

    public RepositoryException( Exception ex , String message ) {
        super(ex, message);
    }

    public RepositoryException( Exception ex ) {
        super(ex);
    }
}
