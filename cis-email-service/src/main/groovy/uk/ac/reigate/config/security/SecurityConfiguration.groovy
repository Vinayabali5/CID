package uk.ac.reigate.config.security

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@Configuration
@Order(1)
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    private final static Logger LOGGER = LoggerFactory.getLogger("Security Settings");
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info("II Configuring HTTP Basic Security");
        
        http.authorizeRequests()
                .antMatchers("/**").authenticated()
                .anyRequest().denyAll()
                .and()
                .httpBasic()
                .and()
		.csrf().disable()
    }
    
}
