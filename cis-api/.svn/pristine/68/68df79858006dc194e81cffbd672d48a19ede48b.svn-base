package uk.ac.reigate.api.admissions

import javax.validation.Valid

import io.swagger.annotations.Api
import io.swagger.annotations.ApiParam

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
import org.springframework.web.bind.annotation.ResponseBody

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.dto.admissions.ApplicationFormDto
import uk.ac.reigate.dto.admissions.ApplicationNewFormDto
import uk.ac.reigate.dto.admissions.StudentSearchDto
import uk.ac.reigate.dto.errorhandling.ErrorDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.repositories.academic.StudentYearRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.PostcodeLookupService
import uk.ac.reigate.services.admissions.ApplicationFormService
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentYearService
import uk.ac.reigate.util.exception.ApplicationNotFoundException

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value="/applications", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/applications", description = "The Application Form API")
class ApplicationFormApi {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(ApplicationFormApi.class);
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    PostcodeLookupService postcodeLookupService
    
    @Autowired
    StudentService studentService
    
    @Autowired
    StudentYearService studentYearService
    
    @Autowired
    ApplicationFormService applicationFormService
    
    @Autowired
    StudentYearRepository studentYearRepository
    
    /**
     * This method is used to retrieves the list of  application form from the database and return an ApplicationFormDto object to the API.
     * 
     * @param studentId
     * @return
     */
    @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<StudentSearchDto>> getAll() throws ApplicationNotFoundException {
        LOGGER.info("*** ApplicationController.getById")
        List<StudentSearchDto> output = new ArrayList<StudentSearchDto>()
        List<Student> students = studentService.findAllApplication();
        if (students != null) {
            students.each { it ->
                String personName = it.person
                String schoolName = it.school
                output.add(new StudentSearchDto(it.id, it.referenceNo, personName, schoolName, it.status.toString()))
            }
        }
        return new ResponseEntity<?>(output, HttpStatus.OK)
    }
    
    /**
     *  This method is used to retrieve an existing application form from the database and return an ApplicationFormDto object to the API.
     *
     * @param applicationId the application ID for the Application form object retrieve
     * @return A ResponseEntity with the corresponding ApplicationFormDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ApplicationFormDto> getById(
            @ApiParam(value = "The unique ID of the Student to retrieve", required = true)
            @PathVariable(value="id") Integer studentId,
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws ApplicationNotFoundException {
        LOGGER.info("*** ApplicationController.getById")
        AcademicYear year
        if (yearId != null) {
            year = academicYearService.findById(yearId)
        } else {
            year = academicYearService.getNextAcademicYear()
        }
        Student student = studentService.findById(studentId)
        StudentYear studentYear = studentYearService.findByStudentAndYear(student, year)
        if (student == null) {
            throw new ApplicationNotFoundException(studentId.toString())
        }
        ApplicationFormDto app = new ApplicationFormDto(student, studentYear)
        return new ResponseEntity<ApplicationFormDto>(app, HttpStatus.OK)
    }
    
    
    /**
     * The ApplicationFormPost method is used to create a new instance of a Student and StudentYear from the supplied ApplicationFormDto
     *
     * @param student and studentYear the ApplicationFormDto to use to create the new Student and StudentYear object
     * @return A ResponseEntity with the newly created Student and StudentYear object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @RequestMapping(value="", produces = ["application/json"], method=RequestMethod.POST)
    public ResponseEntity<ApplicationNewFormDto> create(
            @ApiParam(value = "The Student and StudentYear object to be created, with the studentId fields", required = true)
            @RequestBody @Valid ApplicationNewFormDto applicationNewFormDto)
    throws NotFoundException, InvalidDataException {
        LOGGER.info("** ApplicationFormsApi - applicationFormsPOST");
        if(applicationNewFormDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        Student studentSaved = applicationFormService.create(applicationNewFormDto)
        return new ResponseEntity<ApplicationNewFormDto>(ApplicationNewFormDto.mapFromEntity(studentSaved), HttpStatus.OK)
    }
    
    /**
     * The ApplicationFormPut method is used to create a new instance of a Student and StudentYear from the supplied ApplicationFormDto
     *
     * @param student and studentYear the ApplicationFormDto to use to update the new Student and StudentYear object
     * @return A ResponseEntity with the newly created Student and StudentYear object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @RequestMapping(value="/{id}", produces = ["application/json"], method=RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<ApplicationFormDto> update(
            @ApiParam(value = "The unique ID of the Student to retrieve", required = true)
            @PathVariable("id") Integer id,
            @ApiParam(value = "The Student and StudentYear object to be updated, with the studentId fields", required = true)
            @RequestBody ApplicationFormDto applicationFormDto,
            @ApiParam(value = "The code of the AcademicYear to retrieve", required = false)
            @RequestParam(value = "academicYearId", required = false) Integer academicYearId
    )  throws InvalidDataException {
        LOGGER.info("** ApplicationFormsApi - applicationForm update");
        if(id != applicationFormDto.id) {
            throw new InvalidDataException()
        }
        ApplicationFormDto form = applicationFormService.update(applicationFormDto)
        return new ResponseEntity<ApplicationFormDto>(form, HttpStatus.OK)
    }
    
    /**
     * This method is used to search for a list of Student by using the student ID or Name
     *
     * @param searchTerm The search term to use for the search.
     * @return A ResponseEntity will retrieve the studentSearchDto
     */
    @ResponseBody
    @RequestMapping(value = '/search/{q}', method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<StudentSearchDto>> search(
            @PathVariable(value="q") String searchTerm
    ) {
        LOGGER.info("*** StudentRestController.search")
        if (searchTerm.length() > 0) {
            List<Student> students
            if (searchTerm.isNumber()) {
                Integer studentId
                try {
                    studentId = searchTerm.toInteger()
                } catch (Exception ex) {
                    ex.printStackTrace()
                }
                students = applicationFormService.findByStudentId(studentId)
            } else {
                students = applicationFormService.findByNamePart(searchTerm)
            }
            if (students != null && !students.empty) {
                List<StudentSearchDto> output = new ArrayList<StudentSearchDto>()
                output = students.collect { it ->
                    String personName = it.person
                    String schoolName = it.school
                    return new StudentSearchDto(it.id, it.referenceNo, personName, schoolName, it.status.toString())
                }
                return new ResponseEntity<?>(output, HttpStatus.OK)
            } else {
                throw new NotFoundException("No results found matching the search term: " + searchTerm)
            }
        } else {
            return new ResponseEntity<?>(new ErrorDto(message: "A search term is required to perform the search."), HttpStatus.NOT_ACCEPTABLE)
        }
    }
}
