package ar.edu.unq.desapp.grupoh.consumer;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ar.edu.unq.desapp.grupoh.aspect.APIUsageAfterAspect;
import ar.edu.unq.desapp.grupoh.model.AppContent.Subscriber;
import ar.edu.unq.desapp.grupoh.model.AppContent.Title.PlatformContent;
import ar.edu.unq.desapp.grupoh.service.PlatformContentService;

@Component
public class NewReviewsConsumer {
    @Autowired
    PlatformContentService platformContentService;

    @Autowired
    RestTemplate restTemplate;

    // @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(ReviewNotification review) {

        PlatformContent platformContent = platformContentService.getByTitleId(review.getTitleId()).get();
        List<Subscriber> subscribers = platformContent.getSubscribers();

        subscribers.forEach((Subscriber subscriber) -> {
            try {
                String baseUrl = subscriber.getUrl();
                URI uri = new URI(baseUrl);
                restTemplate.postForEntity(uri, review, String.class);
            } catch (Error | URISyntaxException error) {
            	Logger logger = LoggerFactory.getLogger(APIUsageAfterAspect.class);
                logger.error(error.toString());
            }
        });
    }
}
