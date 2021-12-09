package uk.ac.reigate.api;

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
import uk.ac.reigate.domain.lookup.SchoolReportStatus
import uk.ac.reigate.dto.SchoolReportStatusDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.SchoolReportStatusService


@Controller
@RequestMapping(value = "/schoolReportStatuses", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/schoolReportStatuses", description = "the schoolReportStatuss API")
public class SchoolReportStatusesApi implements ICoreDataBaseApi<SchoolReportStatusDto, Integer>{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolReportStatusesApi.class);
    
    @Autowired
    private final SchoolReportStatusService schoolReportStatusService;
    
    /**
     * Default NoArgs constructor
     */
    SchoolReportStatusesApi() {}
    
    /**
     * Autowired constructor
     */
    SchoolReportStatusesApi(SchoolReportStatusService schoolReportStatusService) {
        this.schoolReportStatusService = schoolReportStatusService;
    }
    
    /**
     * The schoolReportStatussGet method is used to retrieve a full list of all the SchoolReportStatusDto objects
     *
     * @return A ResponseEntity with the corresponding list of SchoolReportStatusDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of SchoolReportStatus entities", notes = "A GET request to the SchoolReportStatuss endpoint returns an array of all the schoolReportStatuss in the system.", response = SchoolReportStatusDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of schoolReportStatuss")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<SchoolReportStatusDto>> getAll() throws NotFoundException {
        LOGGER.info("** SchoolReportStatussApi - schoolReportStatussGet");
        List<SchoolReportStatus> schoolReportStatuss = schoolReportStatusService.findAll();
        return new ResponseEntity<List<SchoolReportStatusDto>>(SchoolReportStatusDto.mapFromList(schoolReportStatuss), HttpStatus.OK);
    }
    
    
    /**
     * The schoolReportStatussSchoolReportStatusIdGet method is used to retrieve an instance of a SchoolReportStatusDto object as identified by the schoolReportStatusId provided
     *
     * @param schoolReportStatusId the schoolReportStatus ID for the SchoolReportStatus object retrieve
     * @return A ResponseEntity with the corresponding SchoolReportStatusDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a SchoolReportStatus identified by the schoolReportStatusId", notes = "A getGET request to the SchoolReportStatus instance endpoint will retrieve an instance of a SchoolReportStatus entity as identified by the schoolReportStatusId provided in the URI.", response = SchoolReportStatusDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the SchoolReportStatus as identified by the schoolReportStatusId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{schoolReportStatusId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<SchoolReportStatusDto> getById(
            @ApiParam(value = "The unique ID of the SchoolReportStatus to retrieve", required = true)
            @PathVariable("schoolReportStatusId") Integer schoolReportStatusId
    ) throws NotFoundException {
        LOGGER.info("** SchoolReportStatussApi - schoolReportStatussSchoolReportStatusIdGet");
        SchoolReportStatus schoolReportStatus = schoolReportStatusService.findById(schoolReportStatusId);
        if (schoolReportStatus == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<SchoolReportStatusDto>(SchoolReportStatusDto.mapFromEntity(schoolReportStatus), HttpStatus.OK);
    }
    
    /**
     * The schoolReportStatussSchoolReportStatusIdPut is used to update
     *
     * @param schoolReportStatusId the schoolReportStatus ID for the SchoolReportStatus object to update
     * @param schoolReportStatus the new data for the SchoolReportStatus object
     * @return the newly updated SchoolReportStatusDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a SchoolReportStatus entity", notes = "A PUT request to the SchoolReportStatus instance endpoint with a SchoolReportStatus object in the request body will update an existing SchoolReportStatus entity in the database.", response = SchoolReportStatusDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated SchoolReportStatus object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{schoolReportStatusId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<SchoolReportStatusDto> update(
            @ApiParam(value = "The unique ID of the SchoolReportStatus to retrieve", required = true)
            @PathVariable("schoolReportStatusId") Integer schoolReportStatusId,
            @ApiParam(value = "The SchoolReportStatus object to be created, without the schoolReportStatusId fields", required = true)
            @RequestBody SchoolReportStatusDto schoolReportStatusDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** SchoolReportStatussApi - schoolReportStatussPUT");
        if (schoolReportStatusId != schoolReportStatusDto.id) {
            throw new InvalidDataException()
        }
        SchoolReportStatus schoolReportStatus = schoolReportStatusService.updateFromDto(schoolReportStatusDto)
        return new ResponseEntity<SchoolReportStatusDto>(SchoolReportStatusDto.mapFromEntity(schoolReportStatus), HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<SchoolReportStatusDto> create(SchoolReportStatusDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
}
