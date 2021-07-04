package ar.edu.unq.desapp.grupoh.consumer;

import ar.edu.unq.desapp.grupoh.messagebroker.MessagingConfig;
import ar.edu.unq.desapp.grupoh.model.Review.Review;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NewReviewsConsumer {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(Review review) {
        System.out.println("Message recived from queue:" + review.getDescription());
    }
}
