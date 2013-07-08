/*
 * _web
 * Copyright (c) 2012 Cybervision. All rights reserved.
 */
package io.belov.underscore

import org.springframework.web.context.request.RequestContextHolder

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class _web {

    private static final HEADER_PRAGMA = "Pragma";
    private static final HEADER_EXPIRES = "Expires";
    private static final HEADER_CACHE_CONTROL = "Cache-Control";

    static void addIsAjaxMethod() {
        HttpServletRequest.metaClass.isAjax = {->
            'XMLHttpRequest' == delegate.getHeader('X-Requested-With')
        }
    }

    /**
     * @return current http request
     */
    static HttpServletRequest getCurrentRequest() {
        return RequestContextHolder.currentRequestAttributes().getRequest();
    }

    static doNotCache(HttpServletResponse response) {
        //http://stackoverflow.com/questions/49547/making-sure-a-web-page-is-not-cached-across-all-browsers
        //http://groovyguts.wordpress.com/2010/02/15/preventing-caching-in-grails/
        response.setHeader(HEADER_PRAGMA, "no-cache");
        response.setDateHeader(HEADER_EXPIRES, 1L);
        response.setHeader(HEADER_CACHE_CONTROL, "no-cache");
        response.addHeader(HEADER_CACHE_CONTROL, "no-store");
    }
}
