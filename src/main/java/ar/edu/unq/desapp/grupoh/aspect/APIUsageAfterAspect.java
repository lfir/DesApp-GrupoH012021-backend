package ar.edu.unq.desapp.grupoh.aspect;

import java.time.LocalDate;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unq.desapp.grupoh.dto.ReviewDTO;
import ar.edu.unq.desapp.grupoh.service.APIUsageService;

@Aspect
@Component
public class APIUsageAfterAspect {
	@Autowired
	private APIUsageService usageService;
	
	@AfterReturning("execution(* ar.edu.unq.desapp.grupoh.service.ReviewService.*(..))")
	public void registerAPIUsage(JoinPoint jp) {
		LocalDate date = LocalDate.now();
		String calledMethod = jp.getSignature().toString();
		
		if (calledMethod.contains("add")) {
			ReviewDTO reviewDTO = (ReviewDTO) jp.getArgs()[0];	
			String platformName = reviewDTO.getOriginPlatformName();
			this.usageService.add(platformName, "addreview", date);
		}

    }
}
