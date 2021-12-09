package uk.ac.reigate.controllers

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.stereotype.Controller

@Controller
class LandingPageController {
    
    protected static Logger LOGGER = LoggerFactory.getLogger(LandingPageController.class);
    
    private static final String DEFAULT_VIEW = "index"
    
    //    @RequestMapping(["/", "/home"])
    public String showHomePage() {
        LOGGER.info("II Loading landing page");
        return DEFAULT_VIEW;
    }
}