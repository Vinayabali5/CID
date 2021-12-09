package uk.ac.reigate.config.security

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Profile(['dev', 'demo'])
@Configuration
@Order(75)
@EnableWebSecurity
class InMemoryAuthentication {
    
    private final static Logger LOGGER = LoggerFactory.getLogger("Security Settings");
    
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.info("II Adding In Memory Authentication");
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("User").and()
                .withUser("staff").password("{noop}password").roles("Staff").and()
                .withUser("enrolment").password("{noop}password").roles("Staff", "Enrolment Manager").and()
                .withUser("timetables").password("{noop}password").roles("Staff", "Timetabling").and()
                .withUser("student-services").password("{noop}password").roles("Staff", "Office Administration").and()
                .withUser("student-services-super").password("{noop}password").roles("Staff", "Core Data", "Office Administration").and()
                .withUser("admissions").password("{noop}password").roles("Staff", "Admissions").and()
                .withUser("safeguarding").password("{noop}password").roles("Staff", "Safeguarding").and()
                .withUser("pastoral").password("{noop}password").roles("Staff", "Pastoral").and()
                .withUser("exams").password("{noop}password").roles("Staff", "Exams Officer").and()
                .withUser("learning-support").password("{noop}password").roles("Staff", "Learning Support").and()
                .withUser("first-aid").password("{noop}password").roles("Staff", "First Aid Coordinator").and()
                .withUser("qoe").password("{noop}password").roles("Staff", "Quals on Entry").and()
                .withUser("careers").password("{noop}password").roles("Staff", "Careers").and()
                .withUser("id").password("{noop}password").roles("Staff", "ID Violation").and()
                .withUser("admin").password("{noop}admin").roles("Staff", "Office Administration", "Core Data", "System Admin")
    }
}
