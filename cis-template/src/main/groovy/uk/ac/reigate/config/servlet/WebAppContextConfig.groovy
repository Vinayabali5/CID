package uk.ac.reigate.config.servlet;


import java.util.concurrent.TimeUnit

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.http.CacheControl
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 *
 * Spring MVC config for the servlet context in the application.
 *
 * The beans of this context are only visible inside the servlet context.
 *
 */
@Configuration
public class WebAppContextConfig implements WebMvcConfigurer {
    
    @Autowired
    Environment env
    
    @Value('${resourceLocation:/resources/}')
    String resourceLocation
    
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (env.acceptsProfiles("dev")) {
            registry.addResourceHandler("/orig/**").addResourceLocations("/resources/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        } else {
        }
        registry.addResourceHandler("/**").addResourceLocations(resourceLocation).setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
    }
    
    public void addViewControllers(ViewControllerRegistry registry) {
        if (env.acceptsProfiles("dev")) {
            registry.addViewController("/orig/").setViewName("forward:/orig/index.html");
        }
        registry.addViewController("/").setViewName("forward:/index.html");
    }
}
