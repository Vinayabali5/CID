package uk.ac.reigate.config

import org.apache.log4j.Logger
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.CsrfTokenRepository
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository


@Configuration
@Order(10)
@EnableWebSecurity
class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    private final static Logger LOGGER = Logger.getLogger("Security Log");
    
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		http
				.httpBasic().and().logout().and()
				.authorizeRequests()
				.anyRequest().fullyAuthenticated()
				//.and()
				//.formLogin()
				.and()
				.csrf()
				.csrfTokenRepository(csrfTokenRepository())
	}
	
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        LOGGER.info("Configuring HTTP Security");
//        http.httpBasic().and().logout().and().authorizeRequests().antMatchers(
//                "/index.html",
//                "/bower_components/**",
//                "/login",
//                "/").permitAll().anyRequest().authenticated()
//				//.and().csrf()
//                //.csrfTokenRepository(csrfTokenRepository()).and().addFilterAfter(new CsrfHeaderFilter(), SessionManagementFilter.class);
//    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }
}
