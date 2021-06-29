package ar.edu.unq.desapp.grupoh.aspect;

import java.time.LocalDate;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	@Around(
		"execution(* ar.edu.unq.desapp.grupoh.webservice.ReviewController.*(..))"
		+ "|| execution(* ar.edu.unq.desapp.grupoh.webservice.PlatformContentController.inverseSearch(..))"
	)
	public Object registerAPIUsage(ProceedingJoinPoint jp) throws Throwable {
		Logger logger = LoggerFactory.getLogger(APIUsageAfterAspect.class);
		LocalDate date = LocalDate.now();
		String calledMethod = jp.getSignature().toString();
		String action = "";
		String platformName = "";
		long startTime = System.currentTimeMillis();
		
		Object object = jp.proceed();
		
		long endtime = System.currentTimeMillis();
		
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
			
		logger.info(this.makeLogMessage(platformName, action, jp.getArgs(), endtime, startTime));
		
		return object;
    }

	private String makeLogMessage(String platformName, String action, Object[] args, long endtime, long startTime) {
		String sep = " - ";
		String user = "ClientPlatform: " + platformName + sep;
		String operation = "Action: " + action + sep;
		String params = "Arguments: " + Arrays.toString(args) + sep;
		String runtime = "Runtime: " + (endtime-startTime) + "ms";
		return user + operation + params + runtime;
	}
}
