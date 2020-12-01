# Shows how to use Grails 4 with Micronaut Rabbit MQ

## Run the demo

### Start RabbitMQ is via Docker:

```
docker run --rm -it -p 5672:5672 -p 15672:15672 rabbitmq:3.7.11-management
```

### Start Book Store application

```
% cd complete
complete % ./gradlew bootRun
```

open your browser and go to http://localhost:8080

Click on a book.

Visit RabbitMQ http://localhost:15672 (guest/guest)

You should see one connection and one book in the queue

### Start Analytics application

```
% cd complete-analytics
complete-analytics % ./gradlew bootRun
```

Now query the `analytics` app.

```
% curl -i localhost:8090/bookPageView

HTTP/1.1 200 
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Tue, 01 Dec 2020 17:05:35 GMT

[{"id":1,"bookName":"Falando de Grails","views":1,"bookId":3}]%    
```

You will see an entry because the event was consumed. 
