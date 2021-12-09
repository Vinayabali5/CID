package uk.ac.reigate.api

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
import org.springframework.web.bind.annotation.RequestParam

import uk.ac.reigate.domain.system.LetterTemplate
import uk.ac.reigate.dto.LetterTemplateDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.system.LetterTemplateService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/letterTemplates", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/letterTemplates", description = "the letterTemplate API")
public class LetterTemplateApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(LetterTemplateApi.class);
    
    @Autowired
    private final LetterTemplateService letterTemplateService
    
    /**
     * Default NoArgs constructor
     */
    LetterTemplateApi(){}
    
    
    /**
     * Autowired constructor
     */
    LetterTemplateApi(LetterTemplateService letterTemplateService) {
        this.letterTemplateService = letterTemplateService;
    }
    
    /**
     * 
     * 
     * @return A ResponseEntity with the corresponding LetterTemplateDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves Letter Templates that is in use", notes = "A GET request to retrieve all the letter templates", response = LetterTemplateDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns all of the LetterTenplate"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<LetterTemplateDto>> getAll(
            @RequestParam(value = "showAll", required = false) Boolean showAll)
    throws NotFoundException {
        LOGGER.info("** LearningTemplateApi - letterTemplateGet");
        List<LetterTemplate> letterTemplate
        if(showAll){
            letterTemplate = letterTemplateService.findAll();
        }else{
            letterTemplate = letterTemplateService.findValidLetterTemplates()
        }
        if (letterTemplate == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<LetterTemplateDto>>(LetterTemplateDto.mapFromList(letterTemplate), HttpStatus.OK);
    }
    
    
    /**
     * @param letterTemplateDto - Request body to create new Letter Template Object
     * @return new LetterTemplate object created 
     * @throws NotFoundException
     * @throws InvalidDataException
     */
    @ApiOperation(value = "Creates a new LetterTemplate entity", notes = "A POST request to the LetterTemplate endpoint with a ILPInterview object in the request body will create a new ILPInterview entity in the database.", response = LetterTemplateDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created LetterTemplate entity including the LetterTemplate that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<LetterTemplateDto> create(
            @ApiParam(value ="The Request Body to create new letterTemplateDto", required = true)
            @Valid @RequestBody LetterTemplateDto letterTemplateDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** LearningTemplateApi - letterTemplatePOST");
        if(letterTemplateDto.id != null){
            throw new InvalidDataException()
        }
        LetterTemplate letterTemplateSaved = letterTemplateService.createFromDto(letterTemplateDto)
        return new ResponseEntity<LetterTemplate>(LetterTemplateDto.mapFromEntity(letterTemplateSaved), HttpStatus.CREATED)
    }
    
    
    /**
     * @param letterTemplateId - letter template id to be updated
     * @param letterTemplateDto - Request body that has to be updated
     * @return updated letterTemplate object
     */
    @ApiOperation(value = "Used to update a Letter Template entity", notes = "A PUT request to the Letter Template instance endpoint with a LetterTemplate object in the request body will update an existing Level entity in the database.", response = LetterTemplateDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated Letter Template object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{letterTemplateId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<LetterTemplateDto> update(
            @ApiParam(value= "Letter Template id that has to be updated", required = true)
            @PathVariable("letterTemplateId")  Integer letterTemplateId,
            @ApiParam(value = "The Request Body to be updated")
            @Valid @RequestBody LetterTemplateDto letterTemplateDto
    ){
        if(letterTemplateId != letterTemplateDto.id){
            throw new InvalidDataException("Id are not the same")
        }
        LetterTemplate letterTemplateSaved = letterTemplateService.updateFromDto(letterTemplateDto)
        return new ResponseEntity<LetterTemplate>(LetterTemplateDto.mapFromEntity(letterTemplateSaved), HttpStatus.OK)
    }
    
    
    /**
     * @param letterTemplateId Id of the Letter Template Object that needs to be retrieved
     * @return LetterTemplateDto object 
     * @throws InvalidDataException
     */
    @ApiOperation(value = "Retrieves Letter Templates that is in use", notes = "A GET request to retrieve all the letter templates", response = LetterTemplateDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns all of the LetterTenplate"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{letterTemplateId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<LetterTemplateDto> getById(
            @ApiParam(value = "The unique id of Letter Template of the object to be retrieved", required = true)
            @PathVariable("letterTemplateId") Integer letterTemplateId
    )throws InvalidDataException{
        LetterTemplate letterTemplate = letterTemplateService.findById(letterTemplateId)
        return new ResponseEntity<LetterTemplateDto>(LetterTemplateDto.mapFromEntity(letterTemplate), HttpStatus.OK)
    }
}
