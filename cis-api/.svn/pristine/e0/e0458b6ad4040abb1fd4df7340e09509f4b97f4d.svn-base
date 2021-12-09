package uk.ac.reigate.api.testing;

import io.swagger.annotations.Api

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import uk.ac.reigate.domain.ilp.ILPInterview
import uk.ac.reigate.domain.system.Setting
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.model.email.EmailMessage
import uk.ac.reigate.services.SettingService
import uk.ac.reigate.services.ilp.ILPInterviewService
import uk.ac.reigate.services.integration.email.EmailService
import uk.ac.reigate.services.lip.LIPService

@Profile(value = 'dev')
@Controller
@RequestMapping(value = ["/testing"], produces = [ MediaType.APPLICATION_JSON_VALUE ])
@Api(value = "/testing")
public class TestApi {
    
    final static String lipEmailSetting = 'LIPMailRecipient'
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TestApi.class);
    
    @Autowired
    SettingService settingService
    
    @Autowired(required = false)
    EmailService emailService
    
    @Autowired
    ILPInterviewService ilpInterviewService
    
    @Autowired
    LIPService lipService
    
    /**
     * Default NoArgs constructor
     */
    TestApi() {}
    
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService
    }
    
    @RequestMapping(value = ["email"], produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<?> testEmail() throws NotFoundException {
        LOGGER.info("** TestApi - testEmail");
        if (emailService != null) {
            LOGGER.info("** TestApi - email service is defined");
            Setting lipEmail = settingService.findSettingBySetting(lipEmailSetting)
            if (lipEmail != null) {
                LOGGER.info("** TestApi - LIP Email is defined");
                EmailMessage email = new EmailMessage()
                email.to.add(lipEmail.value)
                email.subject = "LIP Referral: Test Email"
                emailService.sendEmail(email)
            }
        }
    }
}