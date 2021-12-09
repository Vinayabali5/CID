package uk.ac.reigate.api.ilp;

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
import uk.ac.reigate.domain.ilp.StudentRelatedStaff
import uk.ac.reigate.dto.StudentRelatedStaffDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.ilp.StudentRelatedStaffService


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentRelatedStaffs API")
public class StudentRelatedStaffApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentRelatedStaffApi.class);
    
    @Autowired
    private final StudentRelatedStaffService studentRelatedStaffService;
    
    /**
     * Default NoArgs constructor
     */
    StudentRelatedStaffApi() {}
    
    /**
     * Autowired constructor
     */
    StudentRelatedStaffApi(StudentRelatedStaffService studentRelatedStaffService) {
        this.studentRelatedStaffService = studentRelatedStaffService;
    }
    
    /**
     * The studentRelatedStaffsGet method is used to retrieve a full list of all the StudentRelatedStaffDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentRelatedStaffDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentRelatedStaff entities", notes = "A GET request to the StudentRelatedStaffs endpoint returns an array of all the studentRelatedStaffs in the system.", response = StudentRelatedStaffDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of studentRelatedStaffs")
    ])
    @RequestMapping(value = "related-staff", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentRelatedStaffDto>> getAll() throws NotFoundException {
        LOGGER.info("** StudentRelatedStaffsApi - studentRelatedStaffsGet");
        List<StudentRelatedStaff> studentRelatedStaffs = studentRelatedStaffService.findAll();
        return new ResponseEntity<List<StudentRelatedStaffDto>>(StudentRelatedStaffDto.mapFromList(studentRelatedStaffs), HttpStatus.OK);
    }
    
    
    /**
     * The studentRelatedStaffsStudentRelatedStaffIdGet method is used to retrieve an instance of a StudentRelatedStaffDto object as identified by the studentRelatedStaffId provided
     *
     * @param studentRelatedStaffId the studentRelatedStaff ID for the StudentRelatedStaff object retrieve
     * @return A ResponseEntity with the corresponding StudentRelatedStaffDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentRelatedStaff identified by the studentRelatedStaffId", notes = "A getGET request to the StudentRelatedStaff instance endpoint will retrieve an instance of a StudentRelatedStaff entity as identified by the studentRelatedStaffId provided in the URI.", response = StudentRelatedStaffDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentRelatedStaff as identified by the studentRelatedStaffId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "students/{studentId}/related-staff", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentRelatedStaffDto>> getByStudentId(
            @ApiParam(value = "The unique ID of the StudentRelatedStaff to retrieve", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** StudentRelatedStaffsApi - getByStudentId");
        List<StudentRelatedStaff> studentRelatedStaffs = studentRelatedStaffService.findByDistinctStaffByStudentId(studentId);
        if (studentRelatedStaffs == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StudentRelatedStaffDto>(StudentRelatedStaffDto.mapFromList(studentRelatedStaffs), HttpStatus.OK);
    }
}
