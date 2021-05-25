package ar.edu.unq.desapp.grupoh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ar.edu.unq.desapp.grupoh.filter.RequestWithApiKeyFilter;
import ar.edu.unq.desapp.grupoh.service.ClientPlatformService;

@Configuration
public class FilterConfig {
	@Autowired
	private ClientPlatformService clientService;
	
	@Bean
    public FilterRegistrationBean<RequestWithApiKeyFilter> loggingFilter() {
        FilterRegistrationBean<RequestWithApiKeyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestWithApiKeyFilter(clientService));
        registrationBean.addUrlPatterns("/api/reviews/*", "/api/platformcontents/*");

        return registrationBean;
    }
}
