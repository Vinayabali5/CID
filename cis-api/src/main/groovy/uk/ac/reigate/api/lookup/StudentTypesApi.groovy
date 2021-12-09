package uk.ac.reigate.api.lookup;

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

import uk.ac.reigate.api.ICoreDataBaseApi
import uk.ac.reigate.domain.lookup.StudentType
import uk.ac.reigate.dto.lookup.StudentTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.lookup.StudentTypeService


@Controller
@RequestMapping(value = "/studentTypes", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/studentTypes", description = "the studentTypes API")
public class StudentTypesApi implements ICoreDataBaseApi<StudentTypeDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTypesApi.class);
    
    @Autowired
    private final StudentTypeService studentTypeService;
    
    /**
     * Default NoArgs constructor
     */
    StudentTypesApi() {}
    
    /**
     * Autowired constructor
     */
    StudentTypesApi(StudentTypeService studentTypeService) {
        this.studentTypeService = studentTypeService;
    }
    
    /**
     * The studentTypesGet method is used to retrieve a full list of all the StudentTypeDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentTypeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentType entities", notes = "A GET request to the StudentTypes endpoint returns an array of all the studentTypes in the system.", response = StudentTypeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of studentTypes")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentTypeDto>> getAll() throws NotFoundException {
        LOGGER.info("** StudentTypesApi - studentTypesGet");
        List<StudentType> studentTypes = studentTypeService.findAll();
        return new ResponseEntity<List<StudentTypeDto>>(StudentTypeDto.mapFromList(studentTypes), HttpStatus.OK);
    }
    
    /**
     * The studentTypesPost method is used to create a new instance of a StudentType from the supplied StudentTypeDto
     *
     * @param studentType the StudentTypeDto to use to create the new StudentType object
     * @return A ResponseEntity with the newly created StudentType object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new StudentType entity", notes = "A POST request to the StudentTypes endpoint with a StudentType object in the request body will create a new StudentType entity in the database.", response = StudentTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created StudentType entity including the studentTypeId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentTypeDto> create(
            @ApiParam(value = "The StudentType object to be created, without the studentTypeId fields", required = true)
            @RequestBody @Valid StudentTypeDto studentTypeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentTypesApi - studentTypesPOST");
        if (studentTypeDto.id == null) {
            throw new NotFoundException();
        }
        StudentType studentType = studentTypeService.createFromDto(studentTypeDto)
        return new ResponseEntity<StudentTypeDto>(StudentTypeDto.mapFromEntity(studentType), HttpStatus.CREATED);
    }
    
    /**
     * The studentTypesStudentTypeIdGet method is used to retrieve an instance of a StudentTypeDto object as identified by the studentTypeId provided
     *
     * @param studentTypeId the studentType ID for the StudentType object retrieve
     * @return A ResponseEntity with the corresponding StudentTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StudentType identified by the studentTypeId", notes = "A getGET request to the StudentType instance endpoint will retrieve an instance of a StudentType entity as identified by the studentTypeId provided in the URI.", response = StudentTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StudentType as identified by the studentTypeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentTypeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentTypeDto> getById(
            @ApiParam(value = "The unique ID of the StudentType to retrieve", required = true)
            @PathVariable("studentTypeId") Integer studentTypeId
    ) throws NotFoundException {
        LOGGER.info("** StudentTypesApi - studentTypesStudentTypeIdGet");
        StudentType studentType = studentTypeService.findById(studentTypeId);
        if (studentType == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StudentTypeDto>(StudentTypeDto.mapFromEntity(studentType), HttpStatus.OK);
    }
    
    /**
     * The studentTypesStudentTypeIdPut is used to update
     *
     * @param studentTypeId the studentType ID for the StudentType object to update
     * @param studentType the new data for the StudentType object
     * @return the newly updated StudentTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a StudentType entity", notes = "A PUT request to the StudentType instance endpoint with a StudentType object in the request body will update an existing StudentType entity in the database.", response = StudentTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated StudentType object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentTypeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentTypeDto> update(
            @ApiParam(value = "The unique ID of the StudentType to retrieve", required = true)
            @PathVariable("studentTypeId") Integer studentTypeId,
            @ApiParam(value = "The StudentType object to be created, without the studentTypeId fields", required = true)
            @RequestBody StudentTypeDto studentTypeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentTypesApi - studentTypesPOST");
        if (studentTypeId != studentTypeDto.id) {
            throw new InvalidDataException()
        }
        StudentType studentType = studentTypeService.updateFromDto(studentTypeDto)
        return new ResponseEntity<StudentTypeDto>(StudentTypeDto.mapFromEntity(studentType), HttpStatus.OK);
    }
}
