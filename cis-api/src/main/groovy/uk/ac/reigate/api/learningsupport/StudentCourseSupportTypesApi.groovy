package uk.ac.reigate.api.learningsupport;

import javax.validation.Valid

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
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
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentConcessionType
import uk.ac.reigate.domain.learning_support.StudentCourseSupportType
import uk.ac.reigate.domain.learning_support.SupportType
import uk.ac.reigate.dto.learningsupport.StudentCourseSupportTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.learningsupport.StudentCourseSupportTypeService
import uk.ac.reigate.services.lookup.ConcessionTypeService
import uk.ac.reigate.services.student.StudentService


@Controller
@RequestMapping(value = "/", produces = [ MediaType.APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "The HTTP endpoint for dealing with StudentCourseSupportType data objects.")
public class StudentCourseSupportTypesApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentCourseSupportTypesApi.class);
    
    @Autowired
    private final StudentCourseSupportTypeService studentCourseSupportTypeService;
    
    /**
     * Default NoArgs constructor
     */
    StudentCourseSupportTypesApi() {}
    
    /**
     * This method is used to retrieve a list of the StudentCourseSupportTypeDto objects for the supplied studentId.
     * 
     * @param studentId the ID for the student to use in the search. 
     * @return a ResponseEntity with the corresponding list of StudentCourseSupportTypeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentCourseSupportType entities for the supplied studentId.", notes = "A GET request to this endpoint returns an array of all the StudentCourseSupportType in the system for the supplied studentId.", response = StudentCourseSupportTypeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of studentConcessionTypes")
    ])
    @RequestMapping(value = "/students/{studentId}/support-types", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentCourseSupportTypeDto>> getAllByStudent(
            @ApiParam(value = "The student ID", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** StudentCourseSupportTypesApi - getAllByStudent");
        List<StudentConcessionType> studentConcessionTypes = studentCourseSupportTypeService.getByStudentId(studentId);
        if(studentConcessionTypes == null) {
            throw new NotFoundException()
        }
        return new ResponseEntity<List<StudentCourseSupportTypeDto>>(StudentCourseSupportTypeDto.mapFromList(studentConcessionTypes), HttpStatus.OK)
    }
    
    /**
     * The studentConcessionTypesPost method is used to create a new instance of a StudentConcessionType from the supplied StudentCourseSupportTypeDto
     *
     * @param studentConcessionType the StudentCourseSupportTypeDto to use to create the new StudentConcessionType object
     * @return A ResponseEntity with the newly created StudentConcessionType object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Create a StudentCourseSupportType entity", notes = "A POST request to this endpoint with a StudentCourseSupportTypeDto object as the body will create a StudentCourseSupportType object in the database", response = StudentCourseSupportTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Return HTTP Status code of 200 if an existing object was updated.", response = StudentCourseSupportTypeDto.class),
        @ApiResponse(code = 201, message = "Return HTTP Status code of 201 if a new object was created.", response = StudentCourseSupportTypeDto.class)
    ])
    @RequestMapping(value = "/course-support-types", produces = ["application/json"], method = [
        RequestMethod.POST
    ])
    public ResponseEntity<StudentCourseSupportTypeDto> create(
            @ApiParam(value = "The StudentConcessionType object to be created", required = true)
            @RequestBody @Valid StudentCourseSupportTypeDto studentCourseSupportTypeDto) {
        LOGGER.info("** StudentCourseSupportTypesApi - create");
        if (studentCourseSupportTypeDto.studentCourseSupportTypeId != null) {
            throw new InvalidDataException("An ID should not be supplied when creating a new Student Course Concession")
        }
        StudentCourseSupportType studentCourseSupportType = studentCourseSupportTypeService.createFromDto(studentCourseSupportTypeDto)
        return new ResponseEntity<StudentCourseSupportTypeDto>(StudentCourseSupportTypeDto.mapFromEntity(studentCourseSupportType), HttpStatus.OK);
    }
    
    /**
     * This method is used to update an instance of a StudentCourseSupportType from the supplied StudentCourseSupportTypeDto.
     *
     * @param studentCourseSupportTypeId the for the StudentCourseSupportType object to update
     * @param studentConcessionType the StudentCourseSupportTypeDto to use to update the StudentCourseSupportType object
     * @return A ResponseEntity with the updated StudentCourseSupportType object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Update a StudentCourseSupportType entity", notes = "A PUT request to this endpoint with a StudentCourseSupportTypeDto object as the body will update the StudentCourseSupportType object in the database", response = StudentCourseSupportTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Return HTTP Status code of 200 if an existing object was updated.", response = StudentCourseSupportTypeDto.class),
        @ApiResponse(code = 201, message = "Return HTTP Status code of 201 if a new object was created.", response = StudentCourseSupportTypeDto.class)
    ])
    @RequestMapping(value = "/course-support-types/{studentCourseSupportTypeId}", produces = ["application/json"], method = [RequestMethod.PUT])
    public ResponseEntity<StudentCourseSupportTypeDto> update(
            @ApiParam(value = "The ID for the StudentCourseSupportType object to be updated", required = true)
            @PathVariable Integer studentCourseSupportTypeId,
            @ApiParam(value = "The StudentCourseSupportType object to be use for the update", required = true)
            @RequestBody @Valid StudentCourseSupportTypeDto studentCourseSupportTypeDto) {
        LOGGER.info("** StudentCourseSupportTypesApi - update");
        if (studentCourseSupportTypeId != studentCourseSupportTypeDto.studentCourseSupportTypeId) {
            throw new InvalidDataException()
        }
        StudentCourseSupportType studentCourseSupportType = studentCourseSupportTypeService.updateFromDto(studentCourseSupportTypeDto)
        return new ResponseEntity<StudentCourseSupportTypeDto>(StudentCourseSupportTypeDto.mapFromEntity(studentCourseSupportType), HttpStatus.OK);
    }
    
    
    /**
     * This method is used to delete a StudentCourseSupportType based on the supplied ID values.
     * 
     * @param studentId the studentId to use in the deletion.
     * @param courseId the courseId to use in the deletion.
     * @param supportTypeId the supportTypeId to use in the deletion.
     * @return
     */
    @RequestMapping(value = "/course-support-types/{studentCourseSupportTypeId}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<StudentCourseSupportTypeDto> delete(
            @ApiParam(value = "The unique ID of the StudentCourseSupportType to delete", required = true)
            @PathVariable("studentCourseSupportTypeId") Integer studentCourseSupportTypeId
    ) {
        LOGGER.info("** StudentCourseSupportTypesApi - delete");
        if (studentCourseSupportTypeId != null) {
            StudentCourseSupportType studentCourseSupportType = studentCourseSupportTypeService.findById(studentCourseSupportTypeId)
            if (studentCourseSupportType != null) {
                studentCourseSupportTypeService.delete(studentCourseSupportType)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT)
            } else {
                throw new NotFoundException("The record you are trying to delete cannot be found.")
            }
        } else {
            throw new InvalidDataException("Incorrect data supplied.")
        }
    }
}
