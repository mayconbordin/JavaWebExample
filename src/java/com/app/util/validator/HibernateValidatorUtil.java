package com.app.util.validator;

import javax.validation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


/**
 * Utilidades do Hibernate Validator
 *
 * @author Maycon Bordin
 * @version 1.0
 * @created 04-out-2010 13:24:50
 */
public class HibernateValidatorUtil {
    private static ValidatorFactory factory;

    static {
        try {
            //Getting the configuration so we can change attributes
            Configuration<?> config = Validation.byDefaultProvider().configure();

            // Using a TraversableResolver
            config.traversableResolver(new CustomTraversableResolver());

            // Building the customized factory (along with the changed configuration)
            factory = config.buildValidatorFactory();
        } catch (Exception e) {
            System.err.println("Initial ValidatorFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Recupera o validador
     * @return
     */
    public static Validator getValidator() {
        Validator validator = factory.getValidator();
        return validator;
    }
}