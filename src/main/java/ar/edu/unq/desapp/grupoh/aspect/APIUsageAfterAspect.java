package ar.edu.unq.desapp.grupoh.aspect;

import java.time.LocalDate;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unq.desapp.grupoh.dto.ReviewDTO;
import ar.edu.unq.desapp.grupoh.service.APIUsageService;
import ar.edu.unq.desapp.grupoh.service.ClientPlatformService;
import ar.edu.unq.desapp.grupoh.service.ReviewService;
import ar.edu.unq.desapp.grupoh.service.UpdateReviewRequestBody;

@Aspect
@Component
public class APIUsageAfterAspect {
	@Autowired
	private APIUsageService usageService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ClientPlatformService clientService;
	
	@AfterReturning(
		"execution(* ar.edu.unq.desapp.grupoh.webservice.ReviewController.*(..))"
		+ "|| execution(* ar.edu.unq.desapp.grupoh.webservice.PlatformContentController.*(..))"
	)
	public void registerAPIUsage(JoinPoint jp) {
		LocalDate date = LocalDate.now();
		String calledMethod = jp.getSignature().toString();
		String action = "";
		String platformName = "";
		
		if (calledMethod.contains("createAndSaveNewReview")) {
			ReviewDTO reviewDTO = (ReviewDTO) jp.getArgs()[0];	
			platformName = reviewDTO.getOriginPlatformName();
			action = "addreview";
		}
		if (calledMethod.contains("updateReview")) {
			Long reviewId = (Long) jp.getArgs()[0];
			UpdateReviewRequestBody requestBody = (UpdateReviewRequestBody) jp.getArgs()[1];
			platformName = this.reviewService.getPlatformNameOf(reviewId);
			if ("likeDislikeScore".equals(requestBody.getAttribute())) {
				action = "valuereview";
			} else {
				action = "reportreview";
			}
		}
		if (calledMethod.contains("getReviewsOfContent")) {
			String apiKey = (String) jp.getArgs()[12];
			platformName = this.clientService.get(apiKey).get().getPlatformName();
			action = "searchreview";
		}
		if (calledMethod.contains("inverseSearch")) {
			String apiKey = (String) jp.getArgs()[7];
			platformName = this.clientService.get(apiKey).get().getPlatformName();
			action = "searchcontent";
		}
		
		this.usageService.add(platformName, action, date);
    }
}
