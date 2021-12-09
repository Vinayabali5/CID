package uk.ac.reigate.api.email;

import javax.validation.Valid

import io.swagger.annotations.Api
import io.swagger.annotations.ApiParam

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import uk.ac.reigate.dto.email.EmailStaffListDto
import uk.ac.reigate.dto.email.StaffILPNotificationEmailDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.email.StaffEmailingService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the Staff Emailing API")
public class StaffEmailingApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StaffEmailingApi.class);
    
    @Autowired
    private final StaffEmailingService staffEmailingService;
    
    /**
     * Default NoArgs constructor
     */
    StaffEmailingApi() {}
    
    /**
     * Autowired constructor
     */
    StaffEmailingApi(StaffEmailingService staffEmailingService) {
        this.staffEmailingService = staffEmailingService;
    }
    
    
    @RequestMapping(value = "emails/related-staff", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<EmailStaffListDto> createStaffEmailing(
            @ApiParam(value = "The StudentRelatedStaff object to be created", required = true)
            @RequestBody @Valid EmailStaffListDto emailStaffDto
    ) throws NotFoundException {
        LOGGER.info("** StaffEmailingApi - create email related");
        return staffEmailingService.sendStaffEmailing(emailStaffDto)
    }
    
    @RequestMapping(value = "emails/staff-ilp-notification", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StaffILPNotificationEmailDto> createStaffILPNotificationEmailing(
            @ApiParam(value = "The StudentRelatedStaff object to be created", required = true)
            @RequestBody @Valid StaffILPNotificationEmailDto staffILPNotificationDto
    ) throws NotFoundException {
        LOGGER.info("** StaffEmailingApi - create email related");
        return staffEmailingService.sendStaffILPNotificationEmail(staffILPNotificationDto)
    }
}
