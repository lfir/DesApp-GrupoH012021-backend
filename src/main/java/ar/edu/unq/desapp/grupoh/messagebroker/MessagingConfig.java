package ar.edu.unq.desapp.grupoh.messagebroker;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    public static final String QUEUE = "re-notification_queue";
    public static final String EXCHANGE = "re-notification_exchange";
    public static final String ROUTING_KEY = "re-notification_routingKey";

    @Bean
    public Queue queue () {
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange exchange () {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding (Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter () {
        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

        return new Jackson2JsonMessageConverter(mapper);
    }

    @Bean
    public AmqpTemplate template (ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
