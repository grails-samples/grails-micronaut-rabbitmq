package demo

import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired

@CompileStatic
class BookShowInterceptor {

    @Autowired
    AnalyticsClient analyticsClient

    BookShowInterceptor() { //<2>
        match(controller:"book", action:"show")
    }

    boolean after() { //<3>
        final Book book = (Book) model.bookInstance // <4>
        analyticsClient.updateAnalytics(book)
        true
    }
}