package uk.ac.reigate.api.exams

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
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.StudentAlternativeUci
import uk.ac.reigate.dto.exams.StudentAlternativeUciDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.exams.ExamBoardService
import uk.ac.reigate.services.exams.StudentAlternativeUciService
import uk.ac.reigate.services.student.StudentService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the studentAlternativeUci API")
class StudentAlternativeUciApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentAlternativeUciApi.class);
    
    @Autowired
    private final StudentAlternativeUciService studentAlternativeUciService;
    
    StudentAlternativeUciApi(){}
    
    StudentAlternativeUciApi(StudentAlternativeUciService studentAlternativeUciService){
        this.studentAlternativeUciService=studentAlternativeUciService
    }
    
    /**
     * The StudentAlternativeUciGet method is used to retrieve a list of alternativeUci for a exam board by the StudentAlternativeUciDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentAlternativeUciDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StudentAlternativeUci entities", notes = "A GET request to the StudentAlternativeUci endpoint returns an array of all the alternative uci for the student.", response = StudentAlternativeUciDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of StudentAlternativeUci")
    ])
    @RequestMapping(value = "/students/{studentId}/alternative-ucis", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StudentAlternativeUciDto>> getByStudentId(
            @ApiParam(value = "The unique ID of the Student retrieves the List of Altenative Ucis for the selected student", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** StudentAlternativeUciApi - StudentAlternativeUciGet");
        List<StudentAlternativeUciDto> studentAlternativeUcis = studentAlternativeUciService.getByStudent(studentId);
        if (studentAlternativeUcis == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<StudentAlternativeUciDto>>(StudentAlternativeUciDto.mapFromList(studentAlternativeUcis), HttpStatus.OK);
    }
    
    /**
     * The StudentAlternativeUciGet method is used to retrieve a list of alternativeUci for a exam board by the StudentAlternativeUciDto objects
     *
     * @return A ResponseEntity with the corresponding list of StudentAlternativeUciDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "A record of StudentAlternativeUci entity", notes = "A GET request to the StudentAlternativeUci endpoint returns a record for a particular student with an exam board id.", response = StudentAlternativeUciDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "A record of StudentAlternativeUci")
    ])
    @RequestMapping(value = "/students/{studentId}/alternative-ucis/{examBoardId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StudentAlternativeUciDto> getByStudentIdAndExamBoardId(
            @ApiParam(value = "The unique ID of the Student", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value = "The unique ID of the Student", required = true)
            @PathVariable("examBoardId") Integer examBoardId
    ) throws NotFoundException {
        LOGGER.info("** StudentAlternativeUciApi - StudentAlternativeUciGet");
        StudentAlternativeUci studentAlternativeUci = studentAlternativeUciService.getByStudentAndExamBoardId(studentId, examBoardId);
        if(studentAlternativeUci == null){
            throw new NotFoundException();
        }
        return new ResponseEntity<StudentAlternativeUciDto>(StudentAlternativeUciDto.mapFromEntity(studentAlternativeUci),HttpStatus.OK);
    }
    
    /**
     * The studentAlternativeUciStudentIdPost method is used to create a new instance of a StudentAlternativeUci from the supplied StudentAlternativeUciDto.
     * @param studentId the studentId
     * @param studentAlternativeUciDto the StudentAlternativeUciDto to use to create the new StudentAlternativeUci object
     * @return A ResponseEntity with the newly created StudentAlternativeUci object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new StudentAlternativeUci entity", notes = "A POST request to the alternative-ucis endpoint with a StudentAlternativeUCI object in the request body will create a new StudentAlternativeUCI entity in the database.", response = StudentAlternativeUciDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created StudentAlternativeUci entity"),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "/students/{studentId}/alternative-ucis", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StudentAlternativeUciDto> create(
            @ApiParam(value ="The Student Id with which the new object is created", required=true)
            @PathVariable(value="studentId") Integer studentId,
            @ApiParam(value = "The StudentAlternativeUci object to be created, without the alternativeUci fields", required = true)
            @RequestBody @Valid StudentAlternativeUciDto studentAlternativeUci
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("**StudentAlternativeUCI-- StudentAlternative POST**");
        if(studentId != studentAlternativeUci.studentId){
            throw new InvalidDataException(400,"Incorrect data provided");
        }
        StudentAlternativeUci studentAlternativeUciSaved = studentAlternativeUciService.createFromDto(studentAlternativeUci);
        return new ResponseEntity<StudentAlternativeUciDto>(StudentAlternativeUciDto.mapFromEntity(studentAlternativeUciSaved),HttpStatus.CREATED);
    }
    
    /**
     * The studentAlternativeUciPut method is used to update an existing instance of a StudentAlternativeUci from the supplied StudentAlternativeUciDto
     * @param studentId the studentId
     * @param examBoardId the examBoardId
     * @param studentAlternativeUciDto the StudentAlternativeUciDto to use to create the new StudentAlternativeUci object
     * @return A ResponseEntity with the newly created StudentAlternativeUci object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    
    @ApiOperation(value = "Updates an existing StudentAlternativeUci entity", notes = "A PUT request to the alternative-ucis endpoint with a StudentAlternativeUCI object in the request body will update an existing StudentAlternativeUCI entity in the database.", response = StudentAlternativeUciDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the updated StudentAlternativeUci entity"),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value="/students/{studentId}/alternative-ucis/{examBoardId}",produces = ["application/json"],method = RequestMethod.PUT)
    public ResponseEntity<StudentAlternativeUciDto> update(
            @ApiParam(value="The student id to retrieve",required=true)
            @PathVariable ("studentId") Integer studentId,
            @ApiParam(value="The Exam Board id to retrieve",required = true)
            @PathVariable("examBoardId") Integer examBoardId,
            @ApiParam(value="The Exam Board id to retrieve",required = true)
            @RequestBody StudentAlternativeUciDto studentAlternativeUci
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("**StudentAlternativeUCI-- StudentAlternative PUT**");
        if(studentId != studentAlternativeUci.studentId || examBoardId != studentAlternativeUci.examBoardId){
            throw new InvalidDataException(400,"Incorrect data provided");
        }
        StudentAlternativeUci studentAlternativeUciSaved = studentAlternativeUciService.updateFromDto(studentAlternativeUci);
        return new ResponseEntity<StudentAlternativeUciDto>(StudentAlternativeUciDto.mapFromEntity(studentAlternativeUciSaved),HttpStatus.OK);
    }
    
    /**  This method is to delete an StudentAlternativeUci Object of a particular studentId and examBoardId
     * @param studentId
     * @param examBoardId
     * @return
     */
    @RequestMapping(value = "/students/{studentId}/alternative-ucis/{examBoardId}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<StudentAlternativeUciDto> delete(
            @ApiParam(value="The student id to retrieve", required = true)
            @PathVariable("studentId") Integer studentId,
            @ApiParam(value="The examBoardId", required = true)
            @PathVariable("examBoardId") Integer examBoardId) {
        Boolean deleted = studentAlternativeUciService.deleteByIds(studentId, examBoardId)
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
