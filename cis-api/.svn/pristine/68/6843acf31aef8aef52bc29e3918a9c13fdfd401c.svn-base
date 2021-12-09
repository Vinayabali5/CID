package uk.ac.reigate.api.ilp;

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
import uk.ac.reigate.domain.ilp.LetterWarningParagraph
import uk.ac.reigate.dto.LetterWarningParagraphDto
import uk.ac.reigate.dto.LetterWarningParagraphDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.ilp.LetterWarningParagraphService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

import javax.validation.Valid

@Controller
@RequestMapping(value = "/letter-warning-paragraphs", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/letter-warning-paragraphs", description = "the letterWarningParagraphs API")
public class LetterWarningParagraphsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(LetterWarningParagraphsApi.class);
    
    @Autowired
    private final LetterWarningParagraphService letterWarningParagraphService;
    
    /**
     * Default NoArgs constructor
     */
    LetterWarningParagraphsApi() {}
    
    /**
     * Autowired constructor
     */
    LetterWarningParagraphsApi(LetterWarningParagraphService letterWarningParagraphService) {
        this.letterWarningParagraphService = letterWarningParagraphService;
    }
    
    /**
     * The letterWarningParagraphsGet method is used to retrieve a full list of all the LetterWarningParagraphDto objects
     *
     * @return A ResponseEntity with the corresponding list of LetterWarningParagraphDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of LetterWarningParagraph entities", notes = "A GET request to the LetterWarningParagraphs endpoint returns an array of all the letterWarningParagraphs in the system.", response = LetterWarningParagraphDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of letterWarningParagraphs")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<LetterWarningParagraphDto>> getAll() throws NotFoundException {
        LOGGER.info("** LetterWarningParagraphsApi - letterWarningParagraphsGet");
        List<LetterWarningParagraph> letterWarningParagraphs = letterWarningParagraphService.findAll();
        return new ResponseEntity<List<LetterWarningParagraphDto>>(LetterWarningParagraphDto.mapFromList(letterWarningParagraphs), HttpStatus.OK);
    }
    
    
    
    /**
     * The letterWarningParagraphsLetterWarningParagraphIdGet method is used to retrieve an instance of a LetterWarningParagraphDto object as identified by the letterWarningParagraphId provided
     *
     * @param letterWarningParagraphId the letterWarningParagraph ID for the LetterWarningParagraph object retrieve
     * @return A ResponseEntity with the corresponding LetterWarningParagraphDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a LetterWarningParagraph identified by the letterWarningParagraphId", notes = "A getGET request to the LetterWarningParagraph instance endpoint will retrieve an instance of a LetterWarningParagraph entity as identified by the letterWarningParagraphId provided in the URI.", response = LetterWarningParagraphDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the LetterWarningParagraph as identified by the letterWarningParagraphId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{letterWarningParagraphId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<LetterWarningParagraphDto> getById(
            @ApiParam(value = "The unique ID of the LetterWarningParagraph to retrieve", required = true)
            @PathVariable("letterWarningParagraphId") Integer letterWarningParagraphId
    ) throws NotFoundException {
        LOGGER.info("** LetterWarningParagraphsApi - letterWarningParagraphsLetterWarningParagraphIdGet");
        LetterWarningParagraph letterWarningParagraph = letterWarningParagraphService.findById(letterWarningParagraphId);
        if (letterWarningParagraph == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<LetterWarningParagraphDto>(LetterWarningParagraphDto.mapFromEntity(letterWarningParagraph), HttpStatus.OK);
    }
    
    /**
     * The letterWarningParagraphsPost method is used to create a new instance of a LetterWarningParagraph from the supplied LetterWarningParagraphDto
     *
     * @param letterWarningParagraph the LetterWarningParagraphDto to use to create the new LetterWarningParagraph object
     * @return A ResponseEntity with the newly created LetterWarningParagraph object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new LetterWarningParagraph entity", notes = "A POST request to the LetterWarningParagraphs endpoint with a LetterWarningParagraph object in the request body will create a new LetterWarningParagraph entity in the database.", response = LetterWarningParagraphDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created LetterWarningParagraph entity including the letterWarningParagraphId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<LetterWarningParagraphDto> create(
            @ApiParam(value = "The LetterWarningParagraph object to be created, without the letterWarningParagraphId fields", required = true)
            @RequestBody @Valid LetterWarningParagraphDto letterWarningParagraph
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** LetterWarningParagraphsApi - create");
        if (letterWarningParagraph.id == null) {
            throw new InvalidDataException(400, "ID field should be provided when creating")
        }
        LetterWarningParagraph letterWarningParagraphSaved = letterWarningParagraphService.createFromDto(letterWarningParagraph)
        return new ResponseEntity<LetterWarningParagraphDto>(LetterWarningParagraphDto.mapFromEntity(letterWarningParagraphSaved), HttpStatus.CREATED);
    }
    /**
     * The letterWarningParagraphsLetterWarningParagraphIdPut is used to update
     *
     * @param letterWarningParagraphId the letterWarningParagraph ID for the LetterWarningParagraph object to update
     * @param letterWarningParagraph the new data for the LetterWarningParagraph object
     * @return the newly updated LetterWarningParagraphDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a LetterWarningParagraph entity", notes = "A PUT request to the LetterWarningParagraph instance endpoint with a LetterWarningParagraph object in the request body will update an existing LetterWarningParagraph entity in the database.", response = LetterWarningParagraphDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated LetterWarningParagraph object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{letterWarningParagraphId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<LetterWarningParagraphDto> update(
            @ApiParam(value = "The unique ID of the LetterWarningParagraph to retrieve", required = true)
            @PathVariable("letterWarningParagraphId") Integer letterWarningParagraphId,
            @ApiParam(value = "The LetterWarningParagraph object to be created, without the letterWarningParagraphId fields", required = true)
            @RequestBody LetterWarningParagraphDto letterWarningParagraph
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** LetterWarningParagraphsApi - letterWarningParagraphsPUT");
        if (letterWarningParagraphId != letterWarningParagraph.id) {
            throw new InvalidDataException()
        }
        LetterWarningParagraph letterWarningParagraphSaved = letterWarningParagraphService.updateFromDto(letterWarningParagraph)
        return new ResponseEntity<LetterWarningParagraphDto>(LetterWarningParagraphDto.mapFromEntity(letterWarningParagraphSaved), HttpStatus.OK);
    }
}
