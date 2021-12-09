package uk.ac.reigate.api.interimreport;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import uk.ac.reigate.domain.interimreport.CourseGroupInterimReport
import uk.ac.reigate.dto.interimreport.CourseGroupInterimReportDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.interimreport.CourseGroupInterimReportService
import uk.ac.reigate.services.interimreport.InterimReportService


@Controller
@RequestMapping(value = "/course-group-interim-report", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/course-group-interim-report", description = "the CourseGroupInterimReports API")
public class CourseGroupInterimReportsApi{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseGroupInterimReportsApi.class);
    
    @Autowired
    private final CourseGroupInterimReportService courseGroupInterimReportService;
    
    @Autowired
    private final InterimReportService interimReportService
    
    /**
     * Default NoArgs constructor
     */
    CourseGroupInterimReportsApi() {}
    
    /**
     * Autowired constructor
     */
    CourseGroupInterimReportsApi(CourseGroupInterimReportService courseGroupInterimReportService) {
        this.courseGroupInterimReportService = courseGroupInterimReportService;
    }
    
    /**
     * The CourseGroupInterimReportsGet method is used to retrieve a current list of all the CourseGroupInterimReportDto objects
     *
     * @return A ResponseEntity with the corresponding current list of CourseGroupInterimReportDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of CourseGroupInterimReport entities", notes = "A GET request to the CourseGroupInterimReports endpoint returns an array of all the courseGroupInterimReports in the system.", response = CourseGroupInterimReportDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of interimReports")
    ])
    @RequestMapping(value = "/current", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<CourseGroupInterimReportDto>> getCurrent() throws NotFoundException {
        LOGGER.info("** CourseGroupInterimReportsApi - CourseGroupInterimReportsGet current list");
        List<CourseGroupInterimReport> courseGroupInterimReports = courseGroupInterimReportService.getCurrent();
        return new ResponseEntity<List<CourseGroupInterimReportDto>>(CourseGroupInterimReportDto.mapFromList(courseGroupInterimReports), HttpStatus.OK);
    }
    
    
    /**
     * The CourseGroupInterimReportsGet method is used to retrieve a previous list of all the CourseGroupInterimReportDto objects
     *
     * @return A ResponseEntity with the corresponding previous list of CourseGroupInterimReportDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of CourseGroupInterimReport entities", notes = "A GET request to the CourseGroupInterimReports endpoint returns an array of all the courseGroupInterimReports in the system.", response = CourseGroupInterimReportDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of interimReports")
    ])
    @RequestMapping(value = "/previous", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<CourseGroupInterimReportDto>> getPrevious() throws NotFoundException {
        LOGGER.info("** CourseGroupInterimReportsApi - CourseGroupInterimReportsGet current list");
        List<CourseGroupInterimReport> courseGroupInterimReports = courseGroupInterimReportService.getPrevious();
        return new ResponseEntity<List<CourseGroupInterimReportDto>>(CourseGroupInterimReportDto.mapFromList(courseGroupInterimReports), HttpStatus.OK);
    }
    
    
    /**
     * The interimReportsInterimReportIdPut is used to update
     *
     * @param interimReportId the interimReport ID for the InterimReport object to update
     * @param interimReport the new data for the InterimReport object
     * @return the newly updated InterimReportDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a InterimReport entity", notes = "A PUT request to the InterimReport instance endpoint with a InterimReport object in the request body will update an existing InterimReport entity in the database.", response = CourseGroupInterimReportDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated InterimReport object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "interimReports/{interimReportId}/courseGroups/{courseGroupId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<CourseGroupInterimReportDto> update(
            @ApiParam(value = "The unique ID of the InterimReport to retrieve", required = true)
            @PathVariable("interimReportId") Integer interimReportId,
            @ApiParam(value = "The unique ID of the CourseGroup to retrieve", required = true)
            @PathVariable("courseGroupId") Integer courseGroupId,
            @ApiParam(value = "The InterimReport object to be created, without the interimReportId fields", required = true)
            @RequestBody CourseGroupInterimReportDto courseGroupInterimReport
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** InterimReportsApi - interimReportsPUT");
        if (interimReportId != courseGroupInterimReport.interimReportId && courseGroupId != courseGroupInterimReport.courseGroupId) {
            throw new InvalidDataException()
        }
        CourseGroupInterimReport courseGroupInterimReportSaved = courseGroupInterimReportService.updateFromDto(courseGroupInterimReport)
        return new ResponseEntity<CourseGroupInterimReportDto>(new CourseGroupInterimReportDto(courseGroupInterimReportSaved), HttpStatus.OK);
    }
}
