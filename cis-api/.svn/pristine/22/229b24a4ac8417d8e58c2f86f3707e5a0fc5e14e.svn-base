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
import uk.ac.reigate.domain.learning_support.StudentLLDDHealthProblemCategory
import uk.ac.reigate.dto.StudentLLDDHealthProblemCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.LLDDHealthProblemCategoryService
import uk.ac.reigate.services.student.StudentLLDDHealthProblemCategoryService
import uk.ac.reigate.services.student.StudentService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentLLDDHealthProblemCategories API")
public class StudentLLDDHealthProblemCategoriesApi implements ICoreDataApi<StudentLLDDHealthProblemCategoryDto, Integer>, IStudentDataRetrievalApi<StudentLLDDHealthProblemCategoryDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentLLDDHealthProblemCategoriesApi.class)
    
    @Autowired
    private final StudentLLDDHealthProblemCategoryService studentLLDDHealthProblemCategoryService
    
    @Autowired
    private final StudentService studentService
    
    @Autowired
    private final LLDDHealthProblemCategoryService lLDDHealthProblemCategoryService
    
    /**
     * Default NoArgs constructor
     */
    StudentLLDDHealthProblemCategoriesApi() {}
    
    /**
     * Autowired constructor
     */
    StudentLLDDHealthProblemCategoriesApi(StudentLLDDHealthProblemCategoryService studentLLDDHealthProblemCategoryService) {
        this.studentLLDDHealthProblemCategoryService = studentLLDDHealthProblemCategoryService
    }
    
    /**
     * The studentLLDDHealthProblemCategorysGet method is used to retrieve a full list of all the StudentLLDDHealthProblemCategoryDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentLLDDHealthProblemCategoryDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentLLDDHealthProblemCategory entities", notes = "A GET request to the StudentLLDDHealthProblemCategories endpoint returns an array of all the studentLLDDHealthProblemCategories in the system.", response = StudentLLDDHealthProblemCategoryDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of studentLLDDHealthProblemCategories")
    ])
    @RequestMapping(value = [
        "/studentLLDDHealthProblemCategories",
        "/student-lldd-health-problem-categories"
    ], produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentLLDDHealthProblemCategoryDto>> getAll() throws NotFoundException {
        LOGGER.info("** StudentLLDDHealthProblemCategoriesApi - getAll");
        List<StudentLLDDHealthProblemCategory> studentLLDDHealthProblemCategories = studentLLDDHealthProblemCategoryService.findAll();
        if (studentLLDDHealthProblemCategories) {
            return new ResponseEntity<List<StudentLLDDHealthProblemCategoryDto>>(StudentLLDDHealthProblemCategoryDto.mapFromList(studentLLDDHealthProblemCategories), HttpStatus.OK)
        } else {
            throw new NotFoundException()
        }
    }
    
    /**
     * The studentLLDDHealthProblemCategoryIdGet method is used to retrieve an instance of a StudentLLDDHealthProblemCategoryDto object as identified by the studentLLDDHealthProblemCategoryId provided
     *
     * @param studentLLDDHealthProblemCategoryId the studentLLDDHealthProblemCategoryd for the StudentLLDDHealthProblemCategory object retrieve
     * @return A ResponseEntity with the corresponding StudentLLDDHealthProblemCategoryDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentLLDDHealthProblemCategory identified by the studentLLDDHealthProblemCategoryId", notes = "A getGET request to the StudentLLDDHealthProblemCategory instance endpoint will retrieve an instance of a ILPInterview entity as identified by the studentLLDDHealthProblemCategoryId provided in the URI.", response = StudentLLDDHealthProblemCategoryDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the studentLLDDHealthProblemCategory as identified by the studentLLDDHealthProblemCategoryId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = [
        "/studentLLDDHealthProblemCategories/{studentLLDDHealthProblemCategoryId}",
        "/student-lldd-health-problem-categories/{studentLLDDHealthProblemCategoryId}"
    ], produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentLLDDHealthProblemCategoryDto> getById(
            @ApiParam(value = "The unique ID of the ILPInterview to retrieve", required = true)
            @PathVariable("studentLLDDHealthProblemCategoryId") Integer studentLLDDHealthProblemCategoryId
    ) throws NotFoundException {
        LOGGER.info("** StudentLLDDHealthProblemCategoriesApi - studentLLDDHealthProblemCategoriesGet");
        StudentLLDDHealthProblemCategory studentLLDDHealthProblemCategory = studentLLDDHealthProblemCategoryService.findById(studentLLDDHealthProblemCategoryId);
        if (studentLLDDHealthProblemCategory == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StudentLLDDHealthProblemCategoryDto>(StudentLLDDHealthProblemCategoryDto.mapFromEntity(studentLLDDHealthProblemCategory), HttpStatus.OK);
    }
    
    /**
     * The studentLLDDHealthProblemCategorysPost method is used to create a new instance of a StudentLLDDHealthProblemCategory from the supplied StudentLLDDHealthProblemCategoryDto
     *
     * @param studentLLDDHealthProblemCategory the StudentLLDDHealthProblemCategoryDto to use to create the new StudentLLDDHealthProblemCategory object
     * @return A ResponseEntity with the newly created StudentLLDDHealthProblemCategory object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @RequestMapping(value = [
        "/studentLLDDHealthProblemCategories",
        "/student-lldd-health-problem-categories"
    ], produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentLLDDHealthProblemCategoryDto> create(
            @ApiParam(value = "The StudentLLDDHealthProblemCategory object to be created", required = true)
            @RequestBody @Valid StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentLLDDHealthProblemCategorysApi - createForStudentLLDDHealthProblemCategory")
        if (studentLLDDHealthProblemCategoryDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        StudentLLDDHealthProblemCategory studentLLDDHealthProblemCategorySaved = studentLLDDHealthProblemCategoryService.createFromDto(studentLLDDHealthProblemCategoryDto)
        return new ResponseEntity<StudentLLDDHealthProblemCategoryDto>(StudentLLDDHealthProblemCategoryDto.mapFromEntity(studentLLDDHealthProblemCategorySaved), HttpStatus.CREATED)
    }
    
    /**
     * The studentLLDDHealthProblemCategorysStudentLLDDHealthProblemCategoryIdPut is used to update
     *
     * @param studentLLDDHealthProblemCategoryId the studentLLDDHealthProblemCategory ID for the StudentLLDDHealthProblemCategory object to update
     * @param studentLLDDHealthProblemCategory the new data for the StudentLLDDHealthProblemCategory object
     * @return the newly updated StudentLLDDHealthProblemCategoryDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @RequestMapping(value = [
        "/studentLLDDHealthProblemCategories/{studentLLDDHealthProblemCategoryId}",
        "/student-lldd-health-problem-categories/{studentLLDDHealthProblemCategoryId}"
    ], produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentLLDDHealthProblemCategoryDto> update(
            @ApiParam(value = "The ID of the LLDDHealthProblemCategory to use in the update", required = true)
            @PathVariable("studentLLDDHealthProblemCategoryId") Integer studentLLDDHealthProblemCategoryId,
            @ApiParam(value = "The StudentLLDDHealthProblemCategory object to use for the update", required = true)
            @RequestBody @Valid StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto)
    throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentLLDDHealthProblemCategorysApi - updateForStudent")
        if(studentLLDDHealthProblemCategoryId != studentLLDDHealthProblemCategoryDto.id) {
            throw new InvalidDataException()
        }
        StudentLLDDHealthProblemCategory studentLLDDHealthProblemCategory = studentLLDDHealthProblemCategoryService.updateFromDto(studentLLDDHealthProblemCategoryDto)
        return new ResponseEntity<StudentLLDDHealthProblemCategoryDto>(StudentLLDDHealthProblemCategoryDto.mapFromEntity(studentLLDDHealthProblemCategory), HttpStatus.OK)
    }
    
    /**
     * The delete is used to delete the StudentLLDDHealthProblemCategoryById
     */
    @RequestMapping(value = [
        "/studentLLDDHealthProblemCategories/{studentLLDDHealthProblemCategoryId}",
        "/student-lldd-health-problem-categories/{studentLLDDHealthProblemCategoryId}"
    ], produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<StudentLLDDHealthProblemCategoryDto> delete(
            @ApiParam(value = "The ID of the LLDDHealthProblemCategory to use in the update", required = true)
            @PathVariable("studentLLDDHealthProblemCategoryId") Integer studentLLDDHealthProblemCategoryId
    ) throws NotFoundException {
        LOGGER.info("** StudentLLDDHealthProblemCategorysApi - deleteById")
        studentLLDDHealthProblemCategoryService.delete(studentLLDDHealthProblemCategoryId)
        return new ResponseEntity<?>(HttpStatus.OK)
    }
    
    /**
     * The studentLLDDHealthProblemCategorysStudentIdGet method is used to retrieve an instance of a StudentLLDDHealthProblemCategoryDto object as identified by the studentId provided
     *
     * @param studentId the student ID for the StudentLLDDHealthProblemCategory object retrieve
     * @return A ResponseEntity with the corresponding StudentLLDDHealthProblemCategoryDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentLLDDHealthProblemCategory identified by the studentId", notes = "A getGET request to the StudentLLDDHealthProblemCategory instance endpoint will retrieve an instance of a StudentLLDDHealthProblemCategory entity as identified by the studentId provided in the URI.", response = StudentLLDDHealthProblemCategoryDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentLLDDHealthProblemCategory as identified by the studentId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = [
        "/students/{studentId}/studentLLDDHealthProblemCategories",
        "/students/{studentId}/student-lldd-health-problem-categories"
    ], produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentLLDDHealthProblemCategoryDto>> getByStudent(
            @ApiParam(value = "The unique ID of the StudentLLDDHealthProblemCategorys to retrieve", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** StudentLLDDHealthProblemCategoriesApi - studentLLDDHealthProblemCategorysIdGet");
        List<StudentLLDDHealthProblemCategory> studentLLDDHealthProblemCategory = studentLLDDHealthProblemCategoryService.getByStudentId(studentId);
        
        if (studentLLDDHealthProblemCategory == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<StudentLLDDHealthProblemCategoryDto>>(StudentLLDDHealthProblemCategoryDto.mapFromList(studentLLDDHealthProblemCategory), HttpStatus.OK);
    }
}
