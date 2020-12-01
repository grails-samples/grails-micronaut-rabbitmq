package example.grails

import groovy.transform.CompileStatic
import groovy.transform.ToString

@ToString
@CompileStatic
class Book {
    Long id
    String title
}
