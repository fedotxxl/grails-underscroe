/*
 * _grails
 * Copyright (c) 2012 Cybervision. All rights reserved.
 */
package io.belov.underscore
import grails.util.Holders
import org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib
import org.springframework.context.MessageSource

class _grails {

    private static grailsApplication = null
    private static g  = null
    private static messageSource = null

    public static getBean(String beanName) {
        return getGrailsApplication().mainContext.getBean(beanName);
    }

    public static getBean(Class clazz) {
        return getGrailsApplication().mainContext.getBean(clazz);
    }

    static getGrailsApplication() {
        //todo implement synchronized signleton
        if (!this.@grailsApplication) {
            grailsApplication = Holders.grailsApplication
        }

        return this.@grailsApplication
    }

    /**
     * Do not use it outside request context. Generates "No thread-bound request found" exception
     * @throws java.lang.IllegalStateException
     * @return g tagLib
     */
    static ApplicationTagLib getG() {
        //todo implement synchronized signleton
        if (!this.@g) {
            g = getBean('org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib')
        }

        return this.@g
    }

    static MessageSource getMessageSource() {
        if (!this.@messageSource) {
            messageSource = getBean('messageSource')
        }

        return this.@messageSource
    }

}
