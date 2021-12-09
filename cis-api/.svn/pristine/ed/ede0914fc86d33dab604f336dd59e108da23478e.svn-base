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

import uk.ac.reigate.domain.exams.Results
import uk.ac.reigate.dto.exams.ResultsDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.exams.ResultsService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the Student Results API")
class ResultsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ResultsApi.class);
    
    @Autowired
    private final ResultsService resultService;
    
    /**
     * This method is used to retrieve an instance of Results data object from the supplied resultId.
     * 
     * @param resultId the resultId to use for the search.
     * @return a ResultDto object 
     */
    @ApiOperation(value = "Get an instance of Result Entity based on  the resultId" , notes = " A GET request to get an instance of Result object", response = ResultsDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of Results")
    ])
    @RequestMapping(value = "/exam-results/{resultId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<ResultsDto> getById(
            @ApiParam(value = "id of the Result object" , required = true )
            @PathVariable(value = "resultId", required = true) Integer resultId
    ){
        Results result= resultService.findById(resultId)
        if (result == null){
            throw new NotFoundException("Result not found");
        }
        return new ResponseEntity<ResultsDto>(ResultsDto.mapFromEntity(result), HttpStatus.OK)
    }
    
    /**
     * This method is used to update a Result data object from the supplied ResultDto object.
     * 
     * @param resultId the resultId for the Result data object to update.
     * @param resultDto a ResultDto object that will be used for the update.
     * @return the update ResultDto object.
     */
    @ApiOperation(value = "Updates the Result entity with score and grade" , notes = "A POST request to update an existing Result" ,  response =  ResultsDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of Results")
    ])
    @RequestMapping(value="/exam-results/{resultsId}",produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<ResultsDto> update(
            @ApiParam(value = "The result Id to be updated" , required = true)
            @PathVariable("resultsId") Integer resultId,
            @ApiParam(value = "The resultDto object that needs to be saved" , required = true)
            @RequestBody @Valid ResultsDto resultDto
    )throws NotFoundException, InvalidDataException{
        if(resultId != resultDto.id){
            throw new InvalidDataException("Invalid Data");
        }
        Results savedResults = resultService.updateFromDto(resultDto)
        return new ResponseEntity<ResultsDto>(ResultsDto.mapFromEntity(savedResults), HttpStatus.OK)
    }
    
    /**
     * This method is used to retrieve a list of exam-results for a student identified by the supplied studentId.
     *
     * @param studentId the studentId to use for the search.
     * @return A ResponseEntity with the corresponding list of Results objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Results entities", notes = "A GET request returns an array of all the results for the student.", response = ResultsDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of Results")
    ])
    @RequestMapping(value="/students/{studentId}/exam-results",produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ResultsDto>> getByStudent(
            @ApiParam(value = "studentId", required = true)
            @PathVariable("studentId") Integer studentId
    ) throws NotFoundException{
        List<Results> resultsList = resultService.getByStudentId(studentId)
        if(resultsList == null){
            throw new NotFoundException();
        }
        return new ResponseEntity<List<ResultsDto>>(ResultsDto.mapFromList(resultsList), HttpStatus.OK);
    }
}

