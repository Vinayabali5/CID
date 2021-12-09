package uk.ac.reigate.api.learningsupport;

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
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.ConcessionType
import uk.ac.reigate.domain.learning_support.StudentConcessionType
import uk.ac.reigate.domain.learning_support.StudentCourseConcession
import uk.ac.reigate.dto.learningsupport.StudentCourseConcessionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.learningsupport.StudentCourseConcessionService
import uk.ac.reigate.services.lookup.ConcessionTypeService
import uk.ac.reigate.services.student.StudentService


@Controller
@RequestMapping(value = "/", produces = [ MediaType.APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "The HTTP endpoint for dealing with StudentCourseConcession data objects.")
public class StudentCourseConcessionsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentCourseConcessionsApi.class);
    
    @Autowired
    private final StudentCourseConcessionService studentCourseConcessionService;
    
    @Autowired
    private final StudentService studentService;
    
    @Autowired
    private final CourseService courseService;
    
    @Autowired
    private final ConcessionTypeService concessionTypeService;
    
    /**
     * Default NoArgs constructor
     */
    StudentCourseConcessionsApi() {}
    
    /**
     * This method is used to retrieve a list of the StudentCourseConcessionDto objects for the supplied studentId.
     * 
     * @param studentId the ID for the student to use in the search. 
     * @return a ResponseEntity with the corresponding list of StudentCourseConcessionDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentCourseConcession entities for the supplied studentId.", notes = "A GET request to this endpoint returns an array of all the StudentCourseConcession in the system for the supplied studentId.", response = StudentCourseConcessionDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of studentConcessionTypes")
    ])
    @RequestMapping(value = "/students/{studentId}/course-concessions", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentCourseConcessionDto>> getAllByStudent(
            @ApiParam(value = "The student ID", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** StudentCourseConcessionsApi - getAllByStudent");
        List<StudentConcessionType> studentConcessionTypes = studentCourseConcessionService.getByStudentId(studentId);
        if(studentConcessionTypes == null) {
            throw new NotFoundException()
        }
        return new ResponseEntity<List<StudentCourseConcessionDto>>(StudentCourseConcessionDto.mapFromList(studentConcessionTypes), HttpStatus.OK)
    }
    
    /**
     * The studentConcessionTypesPost method is used to create a new instance of a StudentConcessionType from the supplied StudentCourseConcessionDto
     *
     * @param studentConcessionType the StudentCourseConcessionDto to use to create the new StudentConcessionType object
     * @return A ResponseEntity with the newly created StudentConcessionType object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Create a StudentCourseConcession entity", notes = "A POST request to this endpoint with a StudentCourseConcessionDto object as the body will create a StudentCourseConcession object in the database", response = StudentCourseConcessionDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Return HTTP Status code of 200 if an existing object was updated.", response = StudentCourseConcessionDto.class),
        @ApiResponse(code = 201, message = "Return HTTP Status code of 201 if a new object was created.", response = StudentCourseConcessionDto.class)
    ])
    @RequestMapping(value = "/course-concessions", produces = ["application/json"], method = [
        RequestMethod.POST
    ])
    public ResponseEntity<StudentCourseConcessionDto> create(
            @ApiParam(value = "The StudentConcessionType object to be created", required = true)
            @RequestBody @Valid StudentCourseConcessionDto studentCourseConcessionDto) {
        LOGGER.info("** StudentCourseConcessionsApi - create");
        if (studentCourseConcessionDto.studentCourseConcessionId != null) {
            throw new InvalidDataException("An ID should not be supplied when creating a new Student Course Concession")
        }
        
        
        Student student = studentService.findById(studentCourseConcessionDto.studentId)
        Course course = courseService.findById(studentCourseConcessionDto.courseId)
        ConcessionType concessionType = concessionTypeService.findById(studentCourseConcessionDto.concessionTypeId)
        
        if (student != null && course != null && concessionType != null) {
            Boolean created = false
            StudentCourseConcession studentCourseConcession = new StudentCourseConcession()
            studentCourseConcession.student = student
            studentCourseConcession.course = course
            studentCourseConcession.concessionType = concessionType
            studentCourseConcession.extraTimePercentage = studentCourseConcessionDto.extraTimePercentage
            StudentCourseConcession studentCourseConcessionSaved = studentCourseConcessionService.save(studentCourseConcession)
            return new ResponseEntity<StudentCourseConcessionDto>(StudentCourseConcessionDto.mapFromEntity(studentCourseConcessionSaved), created == true ? HttpStatus.CREATED : HttpStatus.OK);
        } else {
            throw new InvalidDataException("The data supplied does not match the expected.")
        }
    }
    
    /**
     * The studentConcessionTypesPost method is used to create a new instance of a StudentConcessionType from the supplied StudentCourseConcessionDto
     *
     * @param studentConcessionType the StudentCourseConcessionDto to use to create the new StudentConcessionType object
     * @return A ResponseEntity with the newly created StudentConcessionType object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Create a StudentCourseConcession entity", notes = "A POST request to this endpoint with a StudentCourseConcessionDto object as the body will create a StudentCourseConcession object in the database", response = StudentCourseConcessionDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Return HTTP Status code of 200 if an existing object was updated.", response = StudentCourseConcessionDto.class),
        @ApiResponse(code = 201, message = "Return HTTP Status code of 201 if a new object was created.", response = StudentCourseConcessionDto.class)
    ])
    @RequestMapping(value = "/students/{studentId}/course-concessions/all-courses", produces = ["application/json"], method = [
        RequestMethod.POST
    ])
    public ResponseEntity<StudentCourseConcessionDto> createCourseConcession(
            @ApiParam(value = "The StudentConcessionType object to be created", required = true)
            @RequestBody @Valid StudentCourseConcessionDto studentCourseConcessionDto) {
        LOGGER.info("** StudentCourseConcessionsApi - create");
        if (studentCourseConcessionDto.studentCourseConcessionId != null) {
            throw new InvalidDataException("An ID should not be supplied when creating a new Student Course Concession")
        }
        StudentCourseConcession studentCourseConcessionSaved = studentCourseConcessionService.createFromDto(studentCourseConcessionDto)
        return new ResponseEntity<StudentCourseConcessionDto>(StudentCourseConcessionDto.mapFromEntity(studentCourseConcessionSaved),  HttpStatus.CREATED);
    }
    
    /**
     * This method is used to update an instance of a StudentCourseConcession from the supplied StudentCourseConcessionDto.
     *
     * @param studentCourseConcessionId the for the StudentCourseConcession object to update
     * @param studentConcessionType the StudentCourseConcessionDto to use to update the StudentCourseConcession object
     * @return A ResponseEntity with the updated StudentCourseConcession object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Update a StudentCourseConcession entity", notes = "A PUT request to this endpoint with a StudentCourseConcessionDto object as the body will update the StudentCourseConcession object in the database", response = StudentCourseConcessionDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Return HTTP Status code of 200 if an existing object was updated.", response = StudentCourseConcessionDto.class),
        @ApiResponse(code = 201, message = "Return HTTP Status code of 201 if a new object was created.", response = StudentCourseConcessionDto.class)
    ])
    @RequestMapping(value = "/course-concessions/{studentCourseConcessionId}", produces = ["application/json"], method = [RequestMethod.PUT])
    public ResponseEntity<StudentCourseConcessionDto> update(
            @ApiParam(value = "The ID for the StudentCourseConcession object to be updated", required = true)
            @PathVariable Integer studentCourseConcessionId,
            @ApiParam(value = "The StudentCourseConcession object to be use for the update", required = true)
            @RequestBody @Valid StudentCourseConcessionDto studentCourseConcessionDto) {
        LOGGER.info("** StudentCourseConcessionsApi - update");
        if (studentCourseConcessionId != studentCourseConcessionDto.studentCourseConcessionId) {
            throw new InvalidDataException()
        }
        StudentCourseConcession studentCourseConcession = studentCourseConcessionService.updateFromDto(studentCourseConcessionDto)
        return new ResponseEntity<StudentCourseConcessionDto>(StudentCourseConcessionDto.mapFromEntity(studentCourseConcession), HttpStatus.OK);
    }
    
    
    /**
     * This method is used to delete a StudentCourseConcession based on the supplied ID values.
     * 
     * @param studentId the studentId to use in the deletion.
     * @param courseId the courseId to use in the deletion.
     * @param concessionTypeId the concessionTypeId to use in the deletion.
     * @return
     */
    @RequestMapping(value = "/course-concessions/{studentCourseConcessionId}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<StudentCourseConcessionDto> delete(
            @ApiParam(value = "The unique ID of the StudentCourseConcession to delete", required = true)
            @PathVariable("studentCourseConcessionId") Integer studentCourseConcessionId
    ) {
        LOGGER.info("** StudentCourseConcessionsApi - delete");
        if (studentCourseConcessionId != null) {
            StudentCourseConcession studentCourseConcession = studentCourseConcessionService.findById(studentCourseConcessionId)
            if (studentCourseConcession != null) {
                studentCourseConcessionService.delete(studentCourseConcession)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT)
            } else {
                throw new NotFoundException("The record you are trying to delete cannot be found.")
            }
        } else {
            throw new InvalidDataException("Incorrect data supplied.")
        }
    }
}
