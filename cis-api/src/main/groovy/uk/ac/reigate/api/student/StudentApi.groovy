package uk.ac.reigate.api.student

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
import org.springframework.web.bind.annotation.RequestParam

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.dto.CourseDto
import uk.ac.reigate.dto.CourseGroupDto
import uk.ac.reigate.dto.EnrolmentDto
import uk.ac.reigate.dto.EnrolmentSummaryDto
import uk.ac.reigate.dto.StudentAdmissionDto
import uk.ac.reigate.dto.StudentDto
import uk.ac.reigate.dto.StudentYearDto
import uk.ac.reigate.dto.student.StudentWithdrawalDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.SimilarNamedStudentService
import uk.ac.reigate.services.enrolments.EnrolmentService;
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentYearService

@Controller
@RequestMapping(value = "/students", produces = [ MediaType.APPLICATION_JSON_VALUE ])
@Api(value = "/students", description = "the Students API")
public class StudentApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentApi.class);
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    StudentService studentService
    
    @Autowired
    EnrolmentService enrolmentService
    
    @Autowired
    StudentYearService studentYearService
    
    @Autowired
    SimilarNamedStudentService similarNamedStudentService
    
    /**
     * Default No Args constructor
     */
    StudentApi() {}
    
    /**
     * Default Autowired constructor
     */
    StudentApi(AcademicYearService academicYearService, StudentService studentService, StudentYearService studentYearService) {
        this.studentService = studentService;
    }
    
    /**
     * This method is used to retrieve an instance of a StudentDto object as identified by the studentId provided
     *
     * @param studentId the student ID for the Student object retrieve
     * @return A ResponseEntity with the corresponding StudentDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Student identified by the academicYearId", notes = "A GET request to the Student instance endpoint will retrieve an instance of a Student entity as identified by the studentId provided in the URI.", response = StudentDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Student as identified by the studentId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentDto> get(
            @ApiParam(value = "The unique ID of the Student to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The code of the AcademicYear to retrieve", required = false)
            @RequestParam(value = "year", required = false) String year
    ) throws NotFoundException {
        LOGGER.info("** StudentsApi - studentsStudentIdGet");
        AcademicYear academicYear
        if (year) {
            LOGGER.info("II Searching for Year Code: " + year);
            academicYear = academicYearService.findByCode(year)
        }
        if (academicYear == null) {
            LOGGER.info("II No Year Found or Supplied - Using default")
            academicYear = academicYearService.getCurrentAcademicYear()
        }
        Student student = studentService.findById(studentId)
        if (student == null) {
            throw new NotFoundException();
        } else {
            // check if the similar named student exists.
            boolean similarNamedStudent = similarNamedStudentService.findByStudentId(studentId)
            if(similarNamedStudent) {
                return new ResponseEntity<?>(new StudentDto(student, similarNamedStudent), HttpStatus.OK);
            }     else {
                return new ResponseEntity<?>(new StudentDto(student), HttpStatus.OK);
            }
        }
    }
    
    /**
     * This method is used to retrieve an instance of a StudentAdmissionDto object as identified by the studentId provided
     *
     * @param studentId the student ID for the Student object retrieve
     * @return A ResponseEntity with the corresponding StudentAdmissionDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Student identified by the academicYearId", notes = "A GET request to the Student instance endpoint will retrieve an instance of a Student entity as identified by the studentId provided in the URI.", response = StudentAdmissionDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Student as identified by the studentId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentId}/admissions", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentDto> getAdmissions(
            @ApiParam(value = "The unique ID of the Student to retrieve", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** StudentsApi - studentsStudentIdGetAdmissions");
        Student student = studentService.findById(studentId)
        if (student == null) {
            throw new NotFoundException();
        } else {
            return new ResponseEntity<StudentDto>(new StudentAdmissionDto(student), HttpStatus.OK);
        }
    }
    
    /**
     * This method is used to retrieve an instance of a EnrolmentDto object as identified by the studentId provided
     *
     * @param studentId the student ID for the Student object retrieve
     * @return A ResponseEntity with the corresponding EnrolmentDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @RequestMapping(value = "/{studentId}/enrolments", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<EnrolmentSummaryDto> getEnrolments (
            @ApiParam(value = "The unique ID of the Student to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The code of the AcademicYear to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** StudentsApi - studentsStudentIdGet");
        Student student = studentService.findById(studentId)
        if (student == null) {
            throw new NotFoundException()
        }
        List<Enrolment> enrolments
        if (yearId == null) {
            enrolments = enrolmentService.findByStudentId(studentId)
        } else {
            enrolments = enrolmentService.findByStudentAndYearId(studentId, yearId)
        }
        return new ResponseEntity<List<EnrolmentSummaryDto>>(EnrolmentSummaryDto.mapFromList(enrolments),HttpStatus.OK)
    }
    
    /**
     * This method is used to retrieve an instance of a CourseDto object as identified by the studentId provided
     *
     * @param studentId the student ID for the Student object retrieve
     * @return A ResponseEntity with the corresponding CourseDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @RequestMapping(value = "/{studentId}/courses", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<CourseDto> getStudentCourses(
            @ApiParam(value = "The unique ID of the Student to retrieve the Course objects for", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** StudentsApi - studentCourses");
        Student student = studentService.findById(studentId)
        List<Course> courses
        if (student == null) {
            throw new NotFoundException();
        } else {
            courses = studentService.findStudentCourses(student)
        }
        return new ResponseEntity<CourseDto>(CourseDto.mapFromList(courses.unique()), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a CourseGroupDto object as identified by the studentId provided
     *
     * @param studentId the student ID for the Student object retrieve
     * @return A ResponseEntity with the corresponding CourseGroupDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @RequestMapping(value = "/{studentId}/course-groups", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<CourseGroupDto> getStudentCourseGroups(
            @ApiParam(value = "The unique ID of the Student to retrieve the Course Group objects for", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The code of the AcademicYear to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** StudentsApi - studentCourseGroups");
        Student student = studentService.findById(studentId)
        List<CourseGroup> courseGroups
        if (student == null) {
            throw new NotFoundException();
        } else {
            AcademicYear year
            if (yearId != null) {
                year = academicYearService.findById(yearId)
            } else {
                year = academicYearService.getCurrentAcademicYear()
            }
            courseGroups = studentService.findStudentCourseGroupsByYear(student, year)
        }
        return new ResponseEntity<CourseGroupDto>(CourseGroupDto.mapFromList(courseGroups.unique()), HttpStatus.OK);
    }
    
    /**
     * This method is used to update a Student object from the supplied StudentDto object.
     *
     * @param studentId the student ID for the Student object to update
     * @param student the new data for the Student object
     * @return the newly updated StudentDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @RequestMapping(value = "/{studentId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentDto> update(
            @ApiParam(value = "The unique ID of the Student to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The Student object should be created, without the studentId fields", required = true)
            @RequestBody StudentDto studentDto
    ) throws NotFoundException {
        if (studentId != studentDto.id) {
            throw new InvalidDataException("The data provided is not valid. The student ID does not match.")
        }
        Student studentSaved = studentService.updateFromDto(studentDto)
        return new ResponseEntity<StudentDto>(StudentDto.mapFromEntity(studentSaved), HttpStatus.OK)
    }
    
    /**
     * This method is used to update a Student object from the supplied StudentAdmissionDto object.
     *
     * @param studentId the student ID for the Student object to update
     * @param student the new data for the Student object
     * @return the newly updated StudentAdmissionDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Student identified by the academicYearId", notes = "A GET request to the Student instance endpoint will retrieve an instance of a Student entity as identified by the studentId provided in the URI.", response = StudentAdmissionDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Student as identified by the studentId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentId}/admissions", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StudentDto> updateAdmissions(
            @ApiParam(value = "The unique ID of the Student to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value ="The StudentDto", required= true)
            @RequestBody @Valid StudentAdmissionDto studentAdmissionsDto
    ) throws NotFoundException {
        LOGGER.info("** StudentsApi - studentsStudentIdGetAdmissions");
        if (studentId != studentAdmissionsDto.id) {
            throw new InvalidDataException()
        }
        Student studentSaved = studentService.updateFromAdmissionDto(studentAdmissionsDto)
        return new ResponseEntity<StudentAdmissionDto>(StudentAdmissionDto.mapFromEntity(studentSaved), HttpStatus.OK);
    }
    
    /**
     * This method is used to create a new instance of a StudentYear from the supplied StudentWithdrawalDto
     *
     * @param studentYear the StudentWithdrawalDto to use to create the new StudentYear object
     * @return A ResponseEntity with the newly created StudentWithdrawalDto object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "This method is used to withdraw a student from a specified academic year.", notes = "A GET request to the Student instance endpoint will retrieve an instance of a Student entity as identified by the studentId provided in the URI.", response = StudentYearDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Student as identified by the studentId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{studentId}/withdraw", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<?> studentWithdrawal(
            @ApiParam(value = "The unique ID of the Student to withdraw", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The StudentWithdrawalDto object to be used to perform the withdrawal of a student.", required = true)
            @RequestBody @Valid StudentWithdrawalDto studentWithdrawal
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StudentsApi - studentWithdrawal");
        if (studentId != studentWithdrawal.studentId) {
            throw new InvalidDataException(400, "The data provided is not valid. The student ID does not match the withdrawal request.");
        }
        
        try {
            StudentYear studentYear = studentYearService.withdrawStudent(studentWithdrawal.studentId, studentWithdrawal.yearId, studentWithdrawal.withdrawalDate, studentWithdrawal.destinationId, studentWithdrawal.collegeEmployer, studentWithdrawal.courseCareer);
            StudentYearDto output = new StudentYearDto(studentYear);
            return new ResponseEntity<?>(output, HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }
}
