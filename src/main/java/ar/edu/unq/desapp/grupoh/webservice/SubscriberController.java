package ar.edu.unq.desapp.grupoh.webservice;

import ar.edu.unq.desapp.grupoh.dto.SubscriberDTO;
import ar.edu.unq.desapp.grupoh.exception.UnauthorizedException;
import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import ar.edu.unq.desapp.grupoh.service.ClientPlatformService;
import ar.edu.unq.desapp.grupoh.service.PlatformContentService;
import ar.edu.unq.desapp.grupoh.service.SubscribeRequestBody;
import ar.edu.unq.desapp.grupoh.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubscriberController {
    @Autowired
    private ClientPlatformService clientPlatformService;
    @Autowired
    private SubscriberService subscriberService;

    @CrossOrigin
    @PostMapping("/api/subscribe/platformcontent")
    public ResponseEntity subscribe(@RequestBody SubscribeRequestBody requestBody,
                                    @RequestHeader(value = "Api-key") String apiKey
    ) {
        ClientPlatform clientPlatform = clientPlatformService.get(apiKey).get();
        if (clientPlatform != null) {
            SubscriberDTO subscriber = new SubscriberDTO(requestBody.getContentImdbId(), clientPlatform, requestBody.getUrl());
            subscriberService.setSubscriber(subscriber);
            return ResponseEntity.ok(null);
        } else {
            throw new UnauthorizedException();
        }
    }
}
