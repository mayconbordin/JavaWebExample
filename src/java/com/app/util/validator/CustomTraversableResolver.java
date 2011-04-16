package com.app.util.validator;

import java.lang.annotation.ElementType;
import javax.validation.Path;
import javax.validation.TraversableResolver;

/**
 * TransversalResolver do validador
 *
 * @author Maycon Bordin
 * @version 1.0
 * @created 04-out-2010 13:24:50
 */
public class CustomTraversableResolver implements TraversableResolver {

    /**
     *
     * @param traversableObject
     * @param traversableProperty
     * @param rootBeanType
     * @param pathToTraversableObject
     * @param elementType
     * @return
     */
    public boolean isReachable(Object traversableObject, Path.Node traversableProperty,
                               Class rootBeanType, Path pathToTraversableObject,
                               ElementType elementType) {
        return true;
    }

    /**
     *
     * @param object
     * @param node
     * @param c
     * @param path
     * @param elementType
     * @return
     */
    public boolean isCascadable(Object object, Path.Node node, Class c,
                                Path path, ElementType elementType) {
        return true;
    }
}
