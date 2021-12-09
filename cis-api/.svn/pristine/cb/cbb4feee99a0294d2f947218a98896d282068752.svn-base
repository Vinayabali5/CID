package uk.ac.reigate.config.security

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.core.annotation.Order
import org.springframework.core.env.Environment
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.CsrfTokenRepository
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository
import org.springframework.util.StringUtils

import uk.ac.reigate.security.SecurityChecker

@Profile('secured')
@Configuration
@Order(1)
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled = true)
class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    private final static Logger LOGGER = LoggerFactory.getLogger("Security Settings");
    
    private final static String DEFAULT_REALM_NAME = "CID"
    
    @Autowired
    Environment env
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info("II Configuring HTTP Basic Security");
        
        String defaultReaders = StringUtils.collectionToDelimitedString(SecurityChecker.DEFAULT_READER_ROLES, ' or ', "hasRole('", "')");
        String defaultWriters = StringUtils.collectionToDelimitedString(SecurityChecker.DEFAULT_WRITER_ROLES, ' or ', "hasRole('", "')");
        String defaultPowerUsers = StringUtils.collectionToDelimitedString(SecurityChecker.DEFAULT_POWER_USER_ROLES, ' or ', "hasRole('", "')");
        
        //BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint()
        //entryPoint.setRealmName(DEFAULT_REALM_NAME)
        
        //RestAuthenticationEntryPoint restAuthenticationEntryPoint = new RestAuthenticationEntryPoint(DEFAULT_REALM_NAME)
        //restAuthenticationEntryPoint.setRealmName(DEFAULT_REALM_NAME)
        
        if (env.acceptsProfiles("swagger")) {
            LOGGER.info("II Configuring Security Settings for Swagger");
            http.authorizeRequests()
                    .antMatchers("/swagger-ui.html", "/webjars/**", "/api-docs", "/swagger-resources", "/configuration/**").permitAll()
        }
        
        if (env.acceptsProfiles("dev")) {
            LOGGER.info("II Configuring Security Settings for Development Instance");
            http.authorizeRequests()
                    .antMatchers("/swagger-ui.html", "/webjars/**", "/api-docs", "/swagger-resources", "/configuration/**").permitAll()
        } else {
            http.authorizeRequests()
                    .antMatchers("/swagger-ui.html", "/webjars/**", "/api-docs", "/swagger-resources", "/configuration/**").access(defaultPowerUsers)
        }
        
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/user").authenticated()
                //.antMatchers(HttpMethod.POST, "/import/**").access("hasRole('Service User')")
                //.antMatchers(HttpMethod.GET, "/academic-years/**").permitAll()
                //.antMatchers(HttpMethod.GET, "/**").permitAll()
                //.anyRequest().authenticated()
                .and()
                .httpBasic()
                //.authenticationEntryPoint(entryPoint)
                .authenticationEntryPoint(restAuthenticationEntryPoint())
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable()
        
        //http.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
        
    }
    
    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }
    
    @Bean("restAuthenticationEntryPoint")
    public RestAuthenticationEntryPoint restAuthenticationEntryPoint() {
        RestAuthenticationEntryPoint restAuthenticationEntryPoint = new RestAuthenticationEntryPoint(DEFAULT_REALM_NAME)
    }
    
    //    @Bean
    //    public AuthenticationFailureHandler customAuthenticationFailureHandler() {
    //        return new CustomAuthenticationFailureHandler();
    //    }
}
