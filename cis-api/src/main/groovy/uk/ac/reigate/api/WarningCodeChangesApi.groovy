package uk.ac.reigate.api;

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import uk.ac.reigate.domain.lookup.WarningCodeChange
import uk.ac.reigate.dto.WarningCodeChangeDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.WarningCodeChangeService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the warningCodeChanges API")
public class WarningCodeChangesApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(WarningCodeChangesApi.class);
    
    @Autowired
    private final AcademicYearService academicYearService
    
    @Autowired
    private final WarningCodeChangeService warningCodeChangeService;
    
    /**
     * Default NoArgs constructor
     */
    WarningCodeChangesApi() {}
    
    /**
     * Autowired constructor
     */
    WarningCodeChangesApi(WarningCodeChangeService warningCodeChangeService) {
        this.warningCodeChangeService = warningCodeChangeService;
    }
    
    /**
     * The warningCodeChangesGet method is used to retrieve a full list of all the WarningCodeChangeDto objects
     *
     * @return A ResponseEntity with the corresponding list of WarningCodeChangeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of WarningCodeChange entities", notes = "A GET request to the WarningCodeChanges endpoint returns an array of all the warningCodeChanges in the system.", response = WarningCodeChangeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of warningCodeChanges")
    ])
    @RequestMapping(value = "warningCodeChanges", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<WarningCodeChangeDto>> getAll() throws NotFoundException {
        LOGGER.info("** WarningCodeChangesApi - warningCodeChangesGet");
        List<WarningCodeChange> warningCodeChanges = warningCodeChangeService.findAll();
        return new ResponseEntity<List<WarningCodeChangeDto>>(WarningCodeChangeDto.mapFromList(warningCodeChanges), HttpStatus.OK);
    }
    
    /**
     * The warningCodeChangesWarningCodeChangeIdGet method is used to retrieve an instance of a WarningCodeChangeDto object as identified by the warningCodeChangeId provided
     *
     * @param warningCodeChangeId the warningCodeChange ID for the WarningCodeChange object retrieve
     * @return A ResponseEntity with the corresponding WarningCodeChangeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a WarningCodeChange identified by the warningCodeChangeId", notes = "A getGET request to the WarningCodeChange instance endpoint will retrieve an instance of a WarningCodeChange entity as identified by the warningCodeChangeId provided in the URI.", response = WarningCodeChangeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the WarningCodeChange as identified by the warningCodeChangeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "warningCodeChanges/{warningCodeChangeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<WarningCodeChangeDto> getById(
            @ApiParam(value = "The unique ID of the WarningCodeChange to retrieve", required = true)
            @PathVariable("warningCodeChangeId") Integer warningCodeChangeId
    ) throws NotFoundException {
        LOGGER.info("** WarningCodeChangesApi - warningCodeChangesWarningCodeChangeIdGet");
        WarningCodeChange warningCodeChange = warningCodeChangeService.findById(warningCodeChangeId);
        if (warningCodeChange == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<WarningCodeChangeDto>(WarningCodeChangeDto.mapFromEntity(warningCodeChange), HttpStatus.OK);
    }
    
    @ApiOperation(value = "Retrieves an indivdual instance of a WarningCodeChange identified by the warningCodeChangeId", notes = "A getGET request to the WarningCodeChange instance endpoint will retrieve an instance of a WarningCodeChange entity as identified by the warningCodeChangeId provided in the URI.", response = WarningCodeChangeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the WarningCodeChange as identified by the warningCodeChangeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "students/{studentId}/warningCodeChanges", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<WarningCodeChangeDto> getByStudentId(
            @ApiParam(value = "The unique ID of the WarningCodeChange to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The ID of the year year to retrieve the warningCodeChange for", required = false)
            @RequestParam(name = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** WarningCodeChangesApi - warningCodeChangesWarningCodeChangeIdGet");
        if (yearId == null) {
            yearId = academicYearService.getCurrentAcademicYear().id
        }
        List<WarningCodeChange> warningCodeChange = warningCodeChangeService.getByStudentAndYear(studentId, yearId);
        if (warningCodeChange == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<WarningCodeChangeDto>>(WarningCodeChangeDto.mapFromList(warningCodeChange), HttpStatus.OK);
    }
}
