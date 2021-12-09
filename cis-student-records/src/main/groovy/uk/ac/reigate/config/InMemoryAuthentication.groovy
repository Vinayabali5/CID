package uk.ac.reigate.config

import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Profile('dev')
@Configuration
@Order(75)
@EnableWebSecurity
class InMemoryAuthentication extends WebSecurityConfigurerAdapter{
	
    private final static Logger LOGGER = Logger.getLogger("Security Log");

	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		LOGGER.info("II Adding In Memory Authentication");
		
		auth.inMemoryAuthentication()
				.withUser("user").password("password").roles("Staff").and()
				.withUser("admin").password("admin").roles("Staff", "Core Data");
	}

	
}
