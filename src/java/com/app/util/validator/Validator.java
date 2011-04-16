/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.util.validator;

/**
 *
 * @author maycon
 */
public interface Validator<T> {
    public void validate(T object) throws ValidatorException;
    public void antiXss(T object);
}
