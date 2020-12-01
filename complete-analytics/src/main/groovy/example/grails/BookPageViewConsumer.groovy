package example.grails

import groovy.util.logging.Slf4j
import io.micronaut.configuration.rabbitmq.annotation.Queue
import io.micronaut.configuration.rabbitmq.annotation.RabbitListener
import javax.inject.Inject

@Slf4j
@RabbitListener
class BookPageViewConsumer {

    @Inject
    BookPageViewDataService bookPageViewDataService

    @Queue("analytics")
    void updateAnalytics(Book book) {
        log.debug '{}', book.toString()
        bookPageViewDataService.increment((Long) book.id, (String) book.title) //<3>
    }

}
