package ar.edu.unq.desapp.grupoh.consumer;

import ar.edu.unq.desapp.grupoh.messagebroker.MessagingConfig;
import ar.edu.unq.desapp.grupoh.model.AppContent.Subscriber;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import ar.edu.unq.desapp.grupoh.service.PlatformContentService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.net.*;
import java.util.List;

@Component
public class NewReviewsConsumer {
    @Autowired
    PlatformContentService platformContentService;

    @Autowired
    RestTemplate restTemplate;

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(ReviewNotification review) {

        PlatformContent platformContent = platformContentService.getByTitleId(review.getTitleId()).get();
        List<Subscriber> subscribers = platformContent.getSubscribers();

        subscribers.forEach((Subscriber subscriber) -> {
            try {
                String baseUrl = subscriber.getUrl();
                URI uri = new URI(baseUrl);
                ResponseEntity<String> result = restTemplate.postForEntity(uri, review, String.class);
                System.out.println(result);
            } catch (Error | URISyntaxException error) {
                System.out.println(error);
            }
        });



    }
}
