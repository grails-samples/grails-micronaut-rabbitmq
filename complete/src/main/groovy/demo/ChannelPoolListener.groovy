package demo

import com.rabbitmq.client.BuiltinExchangeType
import com.rabbitmq.client.Channel
import io.micronaut.configuration.rabbitmq.connect.ChannelInitializer

import javax.inject.Singleton

@Singleton
class ChannelPoolListener  extends ChannelInitializer {
    @Override
    void initialize(Channel channel) throws IOException {
        channel.exchangeDeclare("micronaut", BuiltinExchangeType.DIRECT, true)
        channel.queueDeclare("analytics", true, false, false, null)
        channel.queueBind("analytics", "micronaut", "analytics")
    }
}
