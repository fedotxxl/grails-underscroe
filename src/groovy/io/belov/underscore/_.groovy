package io.belov.underscore

class _ {

    static String encodeAsURL(String source) {
        return java.net.URLEncoder.encode(source)
    }

    static void extend(Object target, Object... sources) {
        //http://stackoverflow.com/questions/9072307/copy-groovy-class-properties
        sources.each { source ->
            def properties

            if (source instanceof Map) {
                properties = source
            } else {
                properties = source.properties
            }

            properties.each { key, value ->
                if (target.hasProperty(key) && !(key in ['class', 'metaClass']))
                    target[key] = value
            }
        }
    }

}