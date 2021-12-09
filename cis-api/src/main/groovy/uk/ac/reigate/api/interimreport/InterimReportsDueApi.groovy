package uk.ac.reigate.api.interimreport;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import uk.ac.reigate.domain.attendance.StudentAttendanceByCourseGroupForPeriod
import uk.ac.reigate.domain.interimreport.InterimReportsDue
import uk.ac.reigate.domain.interimreport.StudentInterimReport
import uk.ac.reigate.dto.interimreport.InterimReportDataCollectionDto
import uk.ac.reigate.dto.interimreport.InterimReportsDueDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.attendance.StudentAttendanceByCourseGroupForPeriodService
import uk.ac.reigate.services.interimreport.InterimReportsDueService
import uk.ac.reigate.services.interimreport.StudentInterimReportService


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the InterimReportsDues API")
public class InterimReportsDueApi{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(InterimReportsDueApi.class);
    
    @Autowired
    private final InterimReportsDueService interimReportsDueService;
    
    @Autowired
    private final StudentInterimReportService studentInterimReportService;
    
    @Autowired
    private final StudentAttendanceByCourseGroupForPeriodService studentAttendanceByCourseGroupForPeriodService
    
    /**
     * Default NoArgs constructor
     */
    InterimReportsDueApi() {}
    
    /**
     * Autowired constructor
     */
    InterimReportsDueApi(InterimReportsDueService interimReportsDueService) {
        this.interimReportsDueService = interimReportsDueService;
    }
    
    /**
     * The InterimReportsDuesGet method is used to retrieve a current list of all the InterimReportsDueDto objects
     *
     * @return A ResponseEntity with the corresponding current list of InterimReportsDueDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of InterimReportsDue entities", notes = "A GET request to the InterimReportsDues endpoint returns an array of all the InterimReportsDues in the system.", response = InterimReportsDueDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of interimReports")
    ])
    @RequestMapping(value = "interim-reports-due", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<InterimReportsDueDto>> getAll() throws NotFoundException {
        LOGGER.info("** InterimReportsDuesApi - InterimReportsDuesGet current list");
        List<InterimReportsDue> interimReportsDues = interimReportsDueService.findAll();
        return new ResponseEntity<List<InterimReportsDueDto>>(InterimReportsDueDto.mapFromList(interimReportsDues), HttpStatus.OK);
    }
    
    /**
     * The myInterimReports method is used to retrieve the list based on the staffId of all the InterimReportsDueDto objects
     *
     * @return A ResponseEntity with the corresponding current list of InterimReportsDueDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @RequestMapping(value = "interim-reports-due/{staffId}/my-interim-reports", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<InterimReportsDueDto>> myInterimReports(
            @ApiParam(value = "The unique courseGroupId of the StudentInterimReport to retrieve", required = true)
            @PathVariable("staffId") Integer staffId) throws NotFoundException {
        LOGGER.info("** StaffsApi - getStaffCourseGroup");
        List<InterimReportsDue> interimReportsDues = interimReportsDueService.findMyInterimReports(staffId);
        return new ResponseEntity<List<InterimReportsDueDto>>(InterimReportsDueDto.mapFromList(interimReportsDues), HttpStatus.OK)
    }
    
    /**
     * The attendanceList method is used to retrieve the list of all the InterimReportDataCollectionDto objects
     *
     * @return A ResponseEntity with the corresponding current list of InterimReportDataCollectionDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @RequestMapping(value = "interim-reports-due/course-group/{courseGroupId}/data-collection", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<InterimReportDataCollectionDto>> attendanceList(
            @ApiParam(value = "The unique courseGroupId of the StudentInterimReport to retrieve", required = true)
            @PathVariable("courseGroupId") Integer courseGroupId) throws NotFoundException {
        LOGGER.info("** StaffsApi - getStaffCourseGroup");
        List<InterimReportDataCollectionDto> interimReportsDues = interimReportsDueService.findCurrentReviewList(courseGroupId);
        return new ResponseEntity<?>(interimReportsDues, HttpStatus.OK)
    }
}
