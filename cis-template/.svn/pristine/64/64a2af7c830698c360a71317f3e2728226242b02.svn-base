package uk.ac.reigate.controllers

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ConfigurationController {
    
    protected static Logger LOGGER = LoggerFactory.getLogger(ConfigurationController.class);
    
    @Value("\${location}")
    String location
    
    @Value("\${profile}")
    String profile
    
    @Value("\${apiUrl}")
    String apiUrl
    
    @Value("\${reportUrl}")
    String reportUrl
    
    @Value("\${studentImagesUrl}")
    String studentImagesUrl
    
    @Value("\${debugMode}")
    String debug
    
    @RequestMapping(["/config.json"])
    public Map<String, String> loadConfig() {
        LOGGER.info('II Loading Configuration')
        def out = [
            location: this.location,
            profile: this.profile,
            apiUrl: this.apiUrl,
            reportUrl: this.reportUrl,
            studentImagesUrl: this.studentImagesUrl,
            debug: this.debug
            
            
        ];
        return out
    }
}
