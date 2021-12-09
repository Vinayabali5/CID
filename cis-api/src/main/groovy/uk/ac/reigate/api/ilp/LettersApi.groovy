package uk.ac.reigate.api.ilp;

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
import org.springframework.web.bind.annotation.RequestParam

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import uk.ac.reigate.api.ICoreDataYearSpecificApi
import uk.ac.reigate.api.IStudentDataRetrievalApi
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.ilp.ILPInterview
import uk.ac.reigate.domain.ilp.Letter
import uk.ac.reigate.dto.LetterDto;
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.ilp.ILPInterviewService
import uk.ac.reigate.services.ilp.LetterService


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the letters API")
public class LettersApi implements ICoreDataYearSpecificApi<LetterDto, Integer>, IStudentDataRetrievalApi<LetterDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(LettersApi.class);
    
    @Autowired
    private final LetterService letterService;
    
    @Autowired
    private final ILPInterviewService ilpInterviewService;
    
    @Autowired
    private final AcademicYearService academicYearService;
    
    /**
     * Default NoArgs constructor
     */
    LettersApi() {}
    
    /**
     * Autowired constructor
     */
    LettersApi(LetterService letterService) {
        this.letterService = letterService;
    }
    
    /**
     * This method is used to retrieve a full list of all the LetterDto objects
     *
     * @return A ResponseEntity with the corresponding list of LetterDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Letter entities", notes = "A GET request to the Letters endpoint returns an array of all the Letter in the system.", response = LetterDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of letters")
    ])
    @RequestMapping(value = "/ilp-letters", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<LetterDto>> getAll(
            @ApiParam(value = "The id of the AcademicYear to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** LettersApi - getAll");
        AcademicYear academicYear
        if (yearId != null) {
            LOGGER.info("II Searching for Year ID: " + yearId);
            academicYear = academicYearService.findById(yearId)
        }
        if (academicYear == null) {
            LOGGER.info("LettersApi No Year Found or Supplied - Using default")
            academicYear = academicYearService.getCurrentAcademicYear()
        }
        List<Letter> letters = letterService.findByYear(academicYear);
        return new ResponseEntity<List<LetterDto>>(LetterDto.mapFromList(letters), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve an instance of a LetterDto object as identified by the 
     * letterId provided.
     *
     * @param letterId the letter ID for the Letter object retrieve
     * @return A ResponseEntity with the corresponding LetterDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a LetterType identified by the letterTypeId", notes = "A getGET request to the Letter instance endpoint will retrieve an instance of a Letter entity as identified by the letterId provided in the URI.", response = LetterDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Letter as identified by the letterId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/ilp-letters/{letterId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<LetterDto> getById(
            @ApiParam(value = "The unique ID of the Letter to retrieve", required = true)
            @PathVariable("letterId") Integer letterId
    ) throws NotFoundException {
        LOGGER.info("** LettersApi - getById");
        Letter letter = letterService.findById(letterId);
        if (letter == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<LetterDto>(LetterDto.mapFromEntity(letter), HttpStatus.OK);
    }
    
    /**
     * The lettersPost method is used to create a new instance of a Letter from the supplied LetterDto
     *
     * @param letter the LetterDto to use to create the new Letter object
     * @return A ResponseEntity with the newly created Letter object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new Letter entity", notes = "A POST request to the Letters endpoint with a Letter object in the request body will create a new Letter entity in the database.", response = LetterDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created Letter entity including the letterId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "/ilp-letter", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<LetterDto> create(
            @ApiParam(value = "The Letter object to be created, without the letterId fields", required = true)
            @RequestBody @Valid LetterDto letterDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** LettersApi - lettersPOST");
        if (letterDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        Letter letterSaved = letterService.createFromDto(letterDto)
        return new ResponseEntity<LetterDto>(LetterDto.mapFromEntity(letterSaved), HttpStatus.CREATED);
    }
    
    /**
     * This method is used to create an API end-point used to update a Letter data object from 
     * a LetterDto object. 
     *
     * @param letterId the letter ID for the Letter object to update
     * @param letter the new data for the Letter object
     * @return the newly updated LetterDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a Letter entity", notes = "A PUT request to the Letter instance endpoint with a Letter object in the request body will update an existing Letter entity in the database.", response = LetterDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated Letter object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/ilp-letter/{letterId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<LetterDto> update(
            @ApiParam(value = "The unique ID of the Letter to retrieve", required = true)
            @PathVariable("letterId") Integer letterId,
            @ApiParam(value = "The Letter object to be created, without the letterId fields", required = true)
            @RequestBody LetterDto letter
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** LettersApi - lettersPUT");
        if (letterId != letter.id) {
            throw new InvalidDataException()
        }
        Letter letterSaved = letterService.updateFromDto(letter)
        return new ResponseEntity<LetterDto>(LetterDto.mapFromEntity(letterSaved), HttpStatus.OK);
    }
    
    /**
     *  This delete method is used to delete the letter object using letterId
     */
    @RequestMapping(value = "/ilp-letters/{letterId}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(
            @ApiParam(value = "The unique ID of the Letter to retrieve", required = true)
            @PathVariable("letterId") Integer letterId
    ) throws NotFoundException {
        LOGGER.info("** LettersApi - letterTypesLetterTypeIdDelete");
        Letter letter = letterService.findById(letterId);
        if(letter != null) {
            ILPInterview iLPInterview = ilpInterviewService.findById(letter.interview.id)
            iLPInterview.letterSent = false;
            ilpInterviewService.save(iLPInterview)
        }
        letterService.delete(letterId);
        return new ResponseEntity<?>(HttpStatus.NO_CONTENT);
    }
    
    /**
     *  The delete is used to delete the ILP Interview object and ILP Letter object from the database.
     */
    @RequestMapping(value = "/ilp-letters/{letterId}/ilpEntry", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(
            @ApiParam(value = "The unique ID of the Letter to retrieve", required = true)
            @PathVariable("letterId") Integer letterId
    ) throws NotFoundException {
        LOGGER.info("** LettersApi - letterTypesLetterTypeIdDelete");
        Letter letter = letterService.findById(letterId);
        if(letter != null) {
            ilpInterviewService.delete(letter.interview.id)
            letterService.delete(letter.id);
        }
        return new ResponseEntity<?>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * The lettersStudentIdGet method is used to retrieve an instance of a LetterDto object as identified by the studentId provided
     *
     * @param studentId the student ID for the Letter object retrieve
     * @return A ResponseEntity with the corresponding LetterDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Letter identified by the letterId", notes = "A getGET request to the Letter instance endpoint will retrieve an instance of a Letter entity as identified by the letterId provided in the URI.", response = LetterDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Letter as identified by the letterId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/students/{studentId}/ilp-letters", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<LetterDto>> getByStudent(
            @ApiParam(value = "The unique ID of the Letter to retrieve", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException {
        LOGGER.info("** LettersApi - lettersLetterIdGet");
        List<Letter> letter = letterService.getByStudentId(studentId);
        if (letter == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<LetterDto>>(LetterDto.mapFromList(letter), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve a List of LetterDto objects that are marked as authorised and  
     * waiting to be processed by the Student Services team.
     *
     * @return A ResponseEntity with a List of LetterDto objects
     */
    @ApiOperation(value = "Collection of Letter entities", notes = "A GET request to the Letters endpoint returns an array of all the Letter in the system.", response = LetterDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of letters")
    ])
    @RequestMapping(value = "/ilp-letters/authorised", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<LetterDto>> getAuthorisedLetters(
            @ApiParam(value = "The id of the AcademicYear to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** LettersApi - getAuthorisedLetters");
        AcademicYear academicYear
        if (yearId != null) {
            LOGGER.info("II Searching for Year ID: " + yearId);
            academicYear = academicYearService.findById(yearId)
        }
        if (academicYear == null) {
            LOGGER.info("LettersApi No Year Found or Supplied - Using default")
            academicYear = academicYearService.getCurrentAcademicYear()
        }
        List<Letter> letters = letterService.findAuthorisedByAcdemicYear(academicYear);
        return new ResponseEntity<List<LetterDto>>(LetterDto.mapFromList(letters), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve a List of LetterDto objects that are marked as authorised and  
     * waiting to be sent out by the SQL Server.
     *
     * @return A ResponseEntity with a List of LetterDto objects
     */
    @ApiOperation(value = "Collection of Letter entities", notes = "A GET request get a list of Letters .", response = LetterDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of letters")
    ])
    @RequestMapping(value = "/ilp-letters/going-tonight", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<LetterDto>> getLettersGoingTonight(
            @ApiParam(value = "The id of the AcademicYear to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) {
        LOGGER.info("** LettersApi - getLettersGoingTonight");
        AcademicYear academicYear
        if (yearId != null) {
            LOGGER.info("II Searching for Year ID: " + yearId);
            academicYear = academicYearService.findById(yearId)
        }
        if (academicYear == null) {
            LOGGER.info("LettersApi No Year Found or Supplied - Using default")
            academicYear = academicYearService.getCurrentAcademicYear()
        }
        List<Letter> letters = letterService.findGoingTonightByAcdemicYear(academicYear);
        return new ResponseEntity<List<LetterDto>>(LetterDto.mapFromList(letters), HttpStatus.OK);
    }
    
    /**
     * This method is used to retrieve a full list of all the LetterDto objects
     *
     * @return A ResponseEntity with the corresponding list of LetterDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Letter entities", notes = "A GET request to the Letters endpoint returns an array of all the Letter in the system.", response = LetterDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of letters")
    ])
    @RequestMapping(value = "/ilp-letters/to-produce", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<LetterDto>> getLettersToProduce(
            @ApiParam(value = "The id of the AcademicYear to retrieve", required = false)
            @RequestParam(value = "yearId", required = false) Integer yearId
    ) throws NotFoundException {
        LOGGER.info("** LettersApi - getlettersToProduce");
        AcademicYear academicYear
        if (yearId != null) {
            LOGGER.info("II Searching for Year ID: " + yearId);
            academicYear = academicYearService.findById(yearId)
        }
        if (academicYear == null) {
            LOGGER.info("LettersApi No Year Found or Supplied - Using default")
            academicYear = academicYearService.getCurrentAcademicYear()
        }
        List<Letter> letters = letterService.findByAcdemicYearAndProcessingFlag(academicYear, 0)
        return new ResponseEntity<List<LetterDto>>(LetterDto.mapFromList(letters), HttpStatus.OK);
    }
}
