/*
 * _convertTo
 * Copyright (c) 2012 Cybervision. All rights reserved.
 */
package io.belov.underscore

class _convertTo {

    static Integer 'int'(String value) {
        if (!value) return null

        try {
            return Integer.parseInt(value);
        } catch (e) {
            return null
        }
    }

    static Integer 'int'(Integer value) {
        return value
    }

}
