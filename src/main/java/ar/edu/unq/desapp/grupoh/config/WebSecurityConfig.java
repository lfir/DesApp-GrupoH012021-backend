package ar.edu.unq.desapp.grupoh.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String[] AUTH_WHITELIST = {
		"/**"
	};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable().authorizeRequests()
	        .antMatchers(AUTH_WHITELIST).permitAll()
	        .antMatchers("/csrf").permitAll()
	        .anyRequest().authenticated(); 

        http.cors(); // Disable this line to reproduce the CORS 401
    }
}
