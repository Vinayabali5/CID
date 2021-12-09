package uk.ac.reigate.api.student;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

import javax.validation.Valid

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
import uk.ac.reigate.domain.academic.SpecialCategory
import uk.ac.reigate.domain.learning_support.StudentSpecialCategory
import uk.ac.reigate.dto.StudentSpecialCategoryDto
import uk.ac.reigate.dto.StudentSpecialCategoryPublicDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.student.StudentSpecialCategoryService


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentSpecialCategories API")
public class StudentSpecialCategoriesApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentSpecialCategoriesApi.class);
    
    @Autowired
    private final StudentSpecialCategoryService studentSpecialCategoryService;
    
    /**
     * Default NoArgs constructor
     */
    StudentSpecialCategoriesApi() {}
    
    /**
     * Autowired constructor
     */
    StudentSpecialCategoriesApi(StudentSpecialCategoryService studentSpecialCategoryService) {
        this.studentSpecialCategoryService = studentSpecialCategoryService;
    }
    
    /**
     * The studentSpecialCategorysGet method is used to retrieve a full list of all the StudentSpecialCategoryDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentSpecialCategoryDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentSpecialCategory entities", notes = "A GET request to the StudentSpecialCategorys endpoint returns an array of all the studentSpecialCategories in the system.", response = StudentSpecialCategoryDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of studentSpecialCategorys")
    ])
    @RequestMapping(value = "/studentSpecialCategories", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentSpecialCategoryDto>> getAll() throws NotFoundException {
        LOGGER.info("** StudentSpecialCategoriesApi - studentSpecialCategoriesGet");
        List<StudentSpecialCategory> studentSpecialCategories = studentSpecialCategoryService.findAll();
        return new ResponseEntity<List<StudentSpecialCategoryDto>>(StudentSpecialCategoryDto.mapFromList(studentSpecialCategories), HttpStatus.OK);
    }
    
    /**
     * The studentSpecialCategorysPost method is used to create a new instance of a StudentSpecialCategory from the supplied StudentSpecialCategoryDto
     *
     * @param studentSpecialCategory the StudentSpecialCategoryDto to use to create the new StudentSpecialCategory object
     * @return A ResponseEntity with the newly created StudentSpecialCategory object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new StudentSpecialCategory entity", notes = "A POST request to the StudentSpecialCategories endpoint with a StudentSpecialCategory object in the request body will create a new StudentSpecialCategory entity in the database.", response = StudentSpecialCategoryDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created StudentSpecialCategory entity including the studentSpecialCategoryId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "/studentSpecialCategories", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentSpecialCategoryDto> create(
            @ApiParam(value = "The StudentSpecialCategory object to be created, without the studentSpecialCategoryId fields", required = true)
            @RequestBody @Valid StudentSpecialCategoryDto studentSpecialCategory
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentSpecialCategorysApi - studentSpecialCategoriesPOST");
        if (studentSpecialCategory.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        StudentSpecialCategory studentSpecialCategorySaved = studentSpecialCategoryService.createFromDto(studentSpecialCategory)
        return new ResponseEntity<StudentSpecialCategoryDto>(StudentSpecialCategoryDto.mapFromEntity(studentSpecialCategorySaved), HttpStatus.CREATED);
    }
    
    /**
     * The studentSpecialCategorysStudentSpecialCategoryIdGet method is used to retrieve an instance of a StudentSpecialCategoryDto object as identified by the studentSpecialCategoryId provided
     *
     * @param studentSpecialCategoryId the studentSpecialCategory ID for the StudentSpecialCategory object retrieve
     * @return A ResponseEntity with the corresponding StudentSpecialCategoryDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentSpecialCategory identified by the studentSpecialCategoryId", notes = "A getGET request to the StudentSpecialCategory instance endpoint will retrieve an instance of a StudentSpecialCategory entity as identified by the studentSpecialCategoryId provided in the URI.", response = StudentSpecialCategoryDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentSpecialCategory as identified by the studentSpecialCategoryId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/studentSpecialCategories/{studentSpecialCategoryId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentSpecialCategoryDto> getById(
            @ApiParam(value = "The unique ID of the StudentSpecialCategory to retrieve", required = true)
            @PathVariable("studentSpecialCategoryId") Integer studentSpecialCategoryId
    ) throws NotFoundException {
        LOGGER.info("** StudentSpecialCategoriesApi - studentSpecialCategorysStudentSpecialCategoryIdGet");
        StudentSpecialCategory studentSpecialCategory = studentSpecialCategoryService.findById(studentSpecialCategoryId);
        if (studentSpecialCategory == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StudentSpecialCategoryDto>(StudentSpecialCategoryDto.mapFromEntity(studentSpecialCategory), HttpStatus.OK);
    }
    
    /**
     * The studentSpecialCategorysStudentSpecialCategoryIdPut is used to update
     *
     * @param studentSpecialCategoryId the studentSpecialCategory ID for the StudentSpecialCategory object to update
     * @param studentSpecialCategory the new data for the StudentSpecialCategory object
     * @return the newly updated StudentSpecialCategoryDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a StudentSpecialCategory entity", notes = "A PUT request to the StudentSpecialCategory instance endpoint with a StudentSpecialCategory object in the request body will update an existing StudentSpecialCategory entity in the database.", response = StudentSpecialCategoryDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated StudentSpecialCategory object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/studentSpecialCategories/{studentSpecialCategoryId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentSpecialCategoryDto> update(
            @ApiParam(value = "The unique ID of the StudentSpecialCategory to retrieve", required = true)
            @PathVariable("studentSpecialCategoryId") Integer studentSpecialCategoryId,
            @ApiParam(value = "The StudentSpecialCategory object to be created, without the studentSpecialCategoryId fields", required = true)
            @RequestBody StudentSpecialCategoryDto studentSpecialCategory
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentSpecialCategoriesApi - studentSpecialCategorysPUT");
        if (studentSpecialCategoryId != studentSpecialCategory.id) {
            throw new InvalidDataException()
        }
        StudentSpecialCategory studentSpecialCategorySaved = studentSpecialCategoryService.updateFromDto(studentSpecialCategory)
        return new ResponseEntity<StudentSpecialCategoryDto>(StudentSpecialCategoryDto.mapFromEntity(studentSpecialCategorySaved), HttpStatus.OK);
    }
    
    /**
     * The studentSpecialCategorysGet method is used to retrieve a full list of all the StudentSpecialCategoryDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentSpecialCategoryDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentSpecialCategory entities", notes = "A GET request to the StudentSpecialCategorys endpoint returns an array of all the studentSpecialCategories in the system.", response = StudentSpecialCategoryPublicDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of studentSpecialCategories")
    ])
    @RequestMapping(value = "/students/{studentId}/specialCategories", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentSpecialCategoryPublicDto>> specialCategoriesPublicGet(
            @ApiParam(value = "The unique ID of the Student retrieves the List of specialCategories for the selected student", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** StudentSpecialCategoriesApi - SpecialCategoriesGet");
        List<SpecialCategory> specialCategory = studentSpecialCategoryService.getByStudent(studentId);
        return new ResponseEntity<List<StudentSpecialCategoryPublicDto>>(StudentSpecialCategoryPublicDto.mapFromList(specialCategory), HttpStatus.OK);
    }
    
    
    /**
     * The specialCategoriesGet method is used to retrieve a full list of StudentSpecialCategoryDto object as identified by the studentId provided
     *
     * @param studentId the student ID for the StudentSpecialCategory object retrieve
     * @return A ResponseEntity with the corresponding StudentSpecialCategoryDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentSpecialCategory entities", notes = "A GET request to the StudentSpecialCategorys endpoint returns an array of all the studentSpecialCategories in the system.", response = StudentSpecialCategoryDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of studentSpecialCategories")
    ])
    @RequestMapping(value = "/students/{studentId}/specialCategoriesForm", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentSpecialCategoryDto>> specialCategoriesGet(
            @ApiParam(value = "The unique ID of the Student retrieves the List of specialCategories for the selected student", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** StudentSpecialCategoriesApi - SpecialCategoriesGet");
        List<SpecialCategory> specialCategory = studentSpecialCategoryService.getByStudent(studentId);
        return new ResponseEntity<List<StudentSpecialCategoryDto>>(StudentSpecialCategoryDto.mapFromList(specialCategory), HttpStatus.OK);
    }
}
