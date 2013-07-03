/*
 * _web
 * Copyright (c) 2012 Cybervision. All rights reserved.
 */
package io.belov.underscore

import org.springframework.web.context.request.RequestContextHolder

import javax.servlet.http.HttpServletRequest

class _web {

    static {
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

}
