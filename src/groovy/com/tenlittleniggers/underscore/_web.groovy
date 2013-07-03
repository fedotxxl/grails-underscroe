/*
 * _web
 * Copyright (c) 2012 Cybervision. All rights reserved.
 */
package io.belov.underscore

import javax.servlet.http.HttpServletRequest
import org.springframework.web.context.request.RequestContextHolder

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
