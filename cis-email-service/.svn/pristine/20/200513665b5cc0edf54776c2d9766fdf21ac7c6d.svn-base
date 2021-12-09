package uk.ac.reigate.config.security

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

//@Profile(['secured', 'dev'])
@Configuration
@Order(75)
@EnableWebSecurity
class InMemoryAuthentication {
    
    private final static Logger LOGGER = LoggerFactory.getLogger("Security Settings");
    
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.info("II Adding In Memory Authentication");
        
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("User").and()
                .withUser("staff").password("password").roles("Staff").and()
                .withUser("student-services").password("password").roles("Administration", "Staff").and()
                .withUser("admin").password("admin").roles("Administration", "Staff", "Core Data");
    }
}
