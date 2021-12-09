package uk.ac.reigate.api.student

import javax.validation.Valid

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
import org.springframework.security.access.annotation.Secured
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import uk.ac.reigate.api.ICoreDataApi
import uk.ac.reigate.api.IStudentDataRetrievalApi
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.ReferralReason
import uk.ac.reigate.domain.learning_support.StudentReferralReason
import uk.ac.reigate.domain.learning_support.StudentReferralReasonPk
import uk.ac.reigate.dto.StudentReferralReasonDto
import uk.ac.reigate.dto.ilp.ILPInterviewDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.ReferralReasonService
import uk.ac.reigate.services.student.StudentReferralReasonService
import uk.ac.reigate.services.student.StudentService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentReferralReasons API")
public class StudentReferralReasonsApi implements ICoreDataApi<StudentReferralReasonDto, Integer>, IStudentDataRetrievalApi<StudentReferralReasonDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentReferralReasonsApi.class)
    
    @Autowired
    private final StudentReferralReasonService studentReferralReasonService
    
    @Autowired
    private final StudentService studentService
    
    @Autowired
    private final ReferralReasonService referralReasonService
    
    /**
     * Default NoArgs constructor
     */
    StudentReferralReasonsApi() {}
    
    /**
     * Autowired constructor
     */
    StudentReferralReasonsApi(StudentService studentService, ReferralReasonService referralReasonService) {
        this.studentService = studentService
    }
    
    /**
     * The studentReferralReasonsGet method is used to retrieve a full list of all the StudentReferralReasonDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentReferralReasonDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentReferralReason entities", notes = "A GET request to the StudentReferralReasons endpoint returns an array of all the studentReferralReasons in the system.", response = StudentReferralReasonDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of studentReferralReasons")
    ])
    @RequestMapping(value = [
        "/studentReferralReasons",
        "/student-referral-reasons"
    ], produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentReferralReasonDto>> getAll() throws NotFoundException {
        LOGGER.info("** StudentReferralReasonsApi - getAll");
        List<StudentReferralReason> studentReferralReasons = studentReferralReasonService.findAll();
        if (studentReferralReasons) {
            return new ResponseEntity<List<StudentReferralReasonDto>>(StudentReferralReasonDto.mapFromList(studentReferralReasons), HttpStatus.OK)
        } else {
            throw new NotFoundException()
        }
    }
    
    /**
     * The studentReferralReasonIdGet method is used to retrieve an instance of a StudentReferralReasonDto object as identified by the studentReferralReasonId provided
     *
     * @param studentReferralReasonId the studentReferralReasond for the StudentReferralReason object retrieve
     * @return A ResponseEntity with the corresponding StudentReferralReasonDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentReferralReason identified by the studentReferralReasonId", notes = "A getGET request to the StudentReferralReason instance endpoint will retrieve an instance of a ILPInterview entity as identified by the studentReferralReasonId provided in the URI.", response = StudentReferralReasonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the studentReferralReason as identified by the studentReferralReasonId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = [
        "/studentReferralReasons/{studentReferralReasonId}",
        "/student-referral-reasons/{studentReferralReasonId}"
    ], produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentReferralReasonDto> getById(
            @ApiParam(value = "The unique ID of the ILPInterview to retrieve", required = true)
            @PathVariable("studentReferralReasonId") Integer studentReferralReasonId
    ) throws NotFoundException {
        LOGGER.info("** ILPInterviewsApi - iLPInterviewsILPInterviewIdGet");
        StudentReferralReason studentReferralReason = studentReferralReasonService.findById(studentReferralReasonId);
        if (studentReferralReason == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StudentReferralReasonDto>(StudentReferralReasonDto.mapFromEntity(studentReferralReason), HttpStatus.OK);
    }
    
    /**
     * The studentReferralReasonsPost method is used to create a new instance of a StudentReferralReason from the supplied StudentReferralReasonDto
     *
     * @param studentReferralReason the StudentReferralReasonDto to use to create the new StudentReferralReason object
     * @return A ResponseEntity with the newly created StudentReferralReason object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @RequestMapping(value = [
        "/studentReferralReasons",
        "/student-referral-reasons"
    ], produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentReferralReasonDto> create(
            @ApiParam(value = "The StudentReferralReason object to be created", required = true)
            @RequestBody @Valid StudentReferralReasonDto studentReferralReasonDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentReferralReasonsApi - createForStudentReferralReason")
        
        if (studentReferralReasonDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        StudentReferralReason studentReferralReasonSaved = studentReferralReasonService.createFromDto(studentReferralReasonDto)
        return new ResponseEntity<StudentReferralReasonDto>(StudentReferralReasonDto.mapFromEntity(studentReferralReasonSaved), HttpStatus.CREATED)
    }
    
    /**
     * The studentReferralReasonsStudentReferralReasonIdPut is used to update
     *
     * @param studentReferralReasonId the studentReferralReason ID for the StudentReferralReason object to update
     * @param studentReferralReason the new data for the StudentReferralReason object
     * @return the newly updated StudentReferralReasonDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @RequestMapping(value = [
        "/studentReferralReasons/{studentReferralReasonId}",
        "/student-referral-reasons/{studentReferralReasonId}"
    ], produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentReferralReasonDto> update(
            @ApiParam(value = "The ID of the ReferralReason to use in the update", required = true)
            @PathVariable("studentReferralReasonId") Integer studentReferralReasonId,
            @ApiParam(value = "The StudentReferralReason object to use for the update", required = true)
            @RequestBody @Valid StudentReferralReasonDto studentReferralReasonDto)
    throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentReferralReasonsApi - updateForStudent")
        if(studentReferralReasonId != studentReferralReasonDto.id) {
            throw new InvalidDataException()
        }
        StudentReferralReason studentReferralReason = studentReferralReasonService.updateFromDto(studentReferralReasonDto)
        return new ResponseEntity<StudentReferralReasonDto>(StudentReferralReasonDto.mapFromEntity(studentReferralReason), HttpStatus.OK)
    }
    
    /**
     * The delete is used to delete the StudentReferralReasonById
     */
    @RequestMapping(value = [
        "/studentReferralReasons/{studentReferralReasonId}",
        "/student-referral-reasons/{studentReferralReasonId}"
    ], produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<StudentReferralReasonDto> delete(
            @ApiParam(value = "The ID of the ReferralReason to use in the update", required = true)
            @PathVariable("studentReferralReasonId") Integer studentReferralReasonId
    ) throws NotFoundException {
        LOGGER.info("** StudentReferralReasonsApi - deleteById")
        studentReferralReasonService.delete(studentReferralReasonId)
        return new ResponseEntity<?>(HttpStatus.OK)
    }
    
    /**
     * The studentReferralReasonsStudentIdGet method is used to retrieve an instance of a StudentReferralReasonDto object as identified by the studentId provided
     *
     * @param studentId the student ID for the StudentReferralReason object retrieve
     * @return A ResponseEntity with the corresponding StudentReferralReasonDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentReferralReason identified by the studentId", notes = "A getGET request to the StudentReferralReason instance endpoint will retrieve an instance of a StudentReferralReason entity as identified by the studentId provided in the URI.", response = StudentReferralReasonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentReferralReason as identified by the studentId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = [
        "/students/{studentId}/studentReferralReasons",
        "/students/{studentId}/student-referral-reasons"
    ], produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentReferralReasonDto>> getByStudent(
            @ApiParam(value = "The unique ID of the StudentReferralReasons to retrieve", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** StudentReferralReasonsApi - studentReferralReasonsIdGet");
        List<StudentReferralReason> studentReferralReason = studentReferralReasonService.getByStudentId(studentId);
        
        if (studentReferralReason == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<StudentReferralReasonDto>>(StudentReferralReasonDto.mapFromList(studentReferralReason), HttpStatus.OK);
    }
}
