package ar.edu.unq.desapp.grupoh.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import ar.edu.unq.desapp.grupoh.model.ClientPlatform;
import ar.edu.unq.desapp.grupoh.service.ClientPlatformService;

public class RequestWithApiKeyFilter implements Filter {
	private ClientPlatformService clientService;
	
	public RequestWithApiKeyFilter(ClientPlatformService clientService) {
		this.clientService = clientService;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
		throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String apiKey = req.getHeader("Api-key");
		Optional<ClientPlatform> maybeClient = this.clientService.get(apiKey); 
		if (!maybeClient.isPresent()) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		
		chain.doFilter(request, response);
	}
}
