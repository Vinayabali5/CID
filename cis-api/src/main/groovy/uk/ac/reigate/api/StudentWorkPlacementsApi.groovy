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
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentWorkPlacement
import uk.ac.reigate.dto.StudentWorkPlacementDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.StudentWorkPlacementService
import uk.ac.reigate.services.student.StudentService


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentWorkPlacements API")
public class StudentWorkPlacementsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentWorkPlacementsApi.class);
    
    @Autowired
    private final StudentWorkPlacementService studentWorkPlacementService;
    
    @Autowired
    StudentService studentService
    
    /**
     * Default NoArgs constructor
     */
    StudentWorkPlacementsApi() {}
    
    /**
     * Autowired constructor
     */
    StudentWorkPlacementsApi(StudentWorkPlacementService studentWorkPlacementService) {
        this.studentWorkPlacementService = studentWorkPlacementService;
    }
    
    /**
     * The workPlacementModesGet method is used to retrieve a full list of all the StudentWorkPlacementDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentWorkPlacementDto objects.
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentWorkPlacement entities", notes = "A GET request to the StudentWorkPlacements endpoint returns an array of all the workPlacementModes in the system.", response = StudentWorkPlacementDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of workPlacementModes")
    ])
    @RequestMapping(value = "/work-placements", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentWorkPlacementDto>> getAll() throws NotFoundException {
        LOGGER.info("** StudentWorkPlacementsApi - workPlacementModesGet");
        List<StudentWorkPlacement> studentWorkPlacements = studentWorkPlacementService.findAll();
        return new ResponseEntity<List<StudentWorkPlacementDto>>(StudentWorkPlacementDto.mapFromList(studentWorkPlacements), HttpStatus.OK);
    }
    
    /**
     * The studentWorkPlacementsStudentWorkPlacementIdGet method is used to retrieve an instance of a StudentWorkPlacementDto object as identified by the studentWorkPlacementId provided
     *
     * @param studentWorkPlacementId the studentWorkPlacement ID for the StudentWorkPlacement object retrieve
     * @return A ResponseEntity with the corresponding StudentWorkPlacementDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentWorkPlacement identified by the studentWorkPlacementId", notes = "A getGET request to the StudentWorkPlacement instance endpoint will retrieve an instance of a StudentWorkPlacement entity as identified by the studentWorkPlacementId provided in the URI.", response = StudentWorkPlacementDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentWorkPlacement as identified by the studentWorkPlacementId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/work-placements/{workPlacementId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentWorkPlacementDto> getById(
            @ApiParam(value = "The unique ID of the StudentWorkPlacement to retrieve", required = true)
            @PathVariable("workPlacementId") Integer workPlacementId) throws NotFoundException {
        LOGGER.info("** StudentWorkPlacementsApi - studentWorkPlacementsStudentWorkPlacementIdGet");
        StudentWorkPlacement studentWorkPlacement = studentWorkPlacementService.findById(workPlacementId)
        return new ResponseEntity<StudentWorkPlacementDto>(StudentWorkPlacementDto.mapFromEntity(studentWorkPlacement), HttpStatus.OK);
    }
    
    /**
     * The studentWorkPlacementsStudentWorkPlacementIdGet method is used to retrieve an instance of a StudentWorkPlacementDto object as identified by the studentWorkPlacementId provided
     *
     * @param studentWorkPlacementId the studentWorkPlacement ID for the StudentWorkPlacement object retrieve
     * @return A ResponseEntity with the corresponding StudentWorkPlacementDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentWorkPlacement identified by the studentWorkPlacementId", notes = "A getGET request to the StudentWorkPlacement instance endpoint will retrieve an instance of a StudentWorkPlacement entity as identified by the studentWorkPlacementId provided in the URI.", response = StudentWorkPlacementDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentWorkPlacement as identified by the studentWorkPlacementId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/students/{studentId}/work-placements", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentWorkPlacementDto>> getByStudentId(
            @ApiParam(value = "The unique ID of the StudentWorkPlacement to retrieve", required = true)
            @PathVariable("studentId") Integer studentId) throws NotFoundException {
        LOGGER.info("** StudentWorkPlacementsApi - studentWorkPlacementsStudentWorkPlacementIdGet");
        Student student = studentService.findById(studentId)
        List<StudentWorkPlacement> studentWorkPlacements = studentWorkPlacementService.findByStudentId(studentId)
        return new ResponseEntity<List<StudentWorkPlacementDto>>(StudentWorkPlacementDto.mapFromList(studentWorkPlacements), HttpStatus.OK);
    }
    
    /**
     * The studentWorkPlacementsStudentWorkPlacementIdGet method is used to create StudentWorkPlacementDto object as identified by the studentWorkPlacementId provided
     *
     * @param studentWorkPlacementId the studentWorkPlacement ID for the StudentWorkPlacement object
     * @return A ResponseEntity with the corresponding StudentWorkPlacementDto object
     */
    @RequestMapping(value = "/work-placements", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentWorkPlacementDto> create(
            @ApiParam(value = "The StudentWorkPlacement object to be created, without the studentWorkPlacementId fields", required = true)
            @RequestBody StudentWorkPlacementDto studentWorkPlacementDto
    ) throws NotFoundException {
        LOGGER.info("** StudentWorkPlacementsApi - studentWorkPlacementsStudentWorkPlacementIdGet");
        Student student
        if (studentWorkPlacementDto.studentId == null) {
            throw new NotFoundException();
        }
        StudentWorkPlacement studentWorkPlacement = studentWorkPlacementService.createFromDto(studentWorkPlacementDto)
        return new ResponseEntity<StudentWorkPlacementDto>(StudentWorkPlacementDto.mapFromEntity(studentWorkPlacement), HttpStatus.OK);
    }
    
    /**
     * The studentWorkPlacementsStudentWorkPlacementIdGet method is used to update StudentWorkPlacementDto object as identified by the studentWorkPlacementId provided
     *
     * @param studentWorkPlacementId the studentWorkPlacement ID for the StudentWorkPlacement object
     * @return A ResponseEntity with the corresponding StudentWorkPlacementDto object
     */
    @RequestMapping(value = "/work-placements/{workPlacementId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentWorkPlacementDto> update(
            @ApiParam(value = "The unique ID of the WorkPlacement to retrieve", required = true)
            @PathVariable("workPlacementId") Integer workPlacementId,
            @ApiParam(value = "The StudentWorkPlacement object to be created, without the studentWorkPlacementId fields", required = true)
            @RequestBody StudentWorkPlacementDto studentWorkPlacementDto
    ) throws NotFoundException {
        LOGGER.info("** StudentWorkPlacementsApi - studentWorkPlacementsStudentWorkPlacementIdGet");
        if (workPlacementId != studentWorkPlacementDto.id) {
            throw new InvalidDataException();
        }
        StudentWorkPlacement studentWorkPlacement = studentWorkPlacementService.updateFromDto(studentWorkPlacementDto)
        return new ResponseEntity<StudentWorkPlacementDto>(StudentWorkPlacementDto.mapFromEntity(studentWorkPlacement), HttpStatus.OK);
    }
}
