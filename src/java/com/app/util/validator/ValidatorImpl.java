/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.util.validator;

import java.util.Set;
import javax.validation.ConstraintViolation;

/**
 *
 * @author maycon
 */
public class ValidatorImpl<T> implements Validator<T> {
    private javax.validation.Validator validator = HibernateValidatorUtil.getValidator();

    public void validate(T object) throws ValidatorException {
        Set<ConstraintViolation<T>> constraintViolations
                = validator.validate(object);

        if ( constraintViolations.size() > 0 ) {
            throw new ValidatorException( constraintViolations );
        }
    }

    public void antiXss(T object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
