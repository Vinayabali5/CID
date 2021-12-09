package uk.ac.reigate.api.admissions;

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

import uk.ac.reigate.api.ICoreDataApi
import uk.ac.reigate.domain.admissions.InterviewCategory
import uk.ac.reigate.dto.admissions.InterviewCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.admissions.InterviewCategoryService


@Controller
@RequestMapping(value = "/interview-categories", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/interview-categories", description = "the interviewCategorys API")
public class InterviewCategoriesApi implements ICoreDataApi<InterviewCategoryDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(InterviewCategoriesApi.class);
    
    @Autowired
    private final InterviewCategoryService interviewCategoryService;
    
    /**
     * Default NoArgs constructor
     */
    InterviewCategoriesApi() {}
    
    /**
     * Autowired constructor
     */
    InterviewCategoriesApi(InterviewCategoryService interviewCategoryService) {
        this.interviewCategoryService = interviewCategoryService;
    }
    
    /**
     * The interviewCategorysGet method is used to retrieve a full list of all the InterviewCategoryDto objects
     *
     * @return A ResponseEntity with the corresponding list of InterviewCategoryDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of InterviewCategory entities", notes = "A GET request to the InterviewCategorys endpoint returns an array of all the interviewCategorys in the system.", response = InterviewCategoryDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of interviewCategories")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<InterviewCategoryDto>> getAll() throws NotFoundException {
        LOGGER.info("** InterviewCategorysApi - interviewCategorysGet");
        List<InterviewCategory> interviewCategories = interviewCategoryService.findAll();
        return new ResponseEntity<List<InterviewCategoryDto>>(InterviewCategoryDto.mapFromList(interviewCategories), HttpStatus.OK);
    }
    
    /**
     * The interviewCategorysPost method is used to create a new instance of a InterviewCategory from the supplied InterviewCategoryDto
     *
     * @param interviewCategory the InterviewCategoryDto to use to create the new InterviewCategory object
     * @return A ResponseEntity with the newly created InterviewCategory object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new InterviewCategory entity", notes = "A POST request to the InterviewCategorys endpoint with a InterviewCategory object in the request body will create a new InterviewCategory entity in the database.", response = InterviewCategoryDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created InterviewCategory entity including the interviewCategoryId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<InterviewCategoryDto> create(
            @ApiParam(value = "The InterviewCategory object to be created, without the interviewCategoryId fields", required = true)
            @RequestBody @Valid InterviewCategoryDto interviewCategory) throws NotFoundException, InvalidDataException {
        LOGGER.info("** InterviewCategorysApi - interviewCategorysPOST");
        if (interviewCategory.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        InterviewCategory interviewCategorySaved = interviewCategoryService.createFromDto(interviewCategory)
        return new ResponseEntity<InterviewCategoryDto>(InterviewCategoryDto.mapFromEntity(interviewCategorySaved), HttpStatus.CREATED);
    }
    
    /**
     * The interviewCategorysInterviewCategoryIdGet method is used to retrieve an instance of a InterviewCategoryDto object as identified by the interviewCategoryId provided
     *
     * @param interviewCategoryId the interviewCategory ID for the InterviewCategory object retrieve
     * @return A ResponseEntity with the corresponding InterviewCategoryDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a InterviewCategory identified by the interviewCategoryId", notes = "A getGET request to the InterviewCategory instance endpoint will retrieve an instance of a InterviewCategory entity as identified by the interviewCategoryId provided in the URI.", response = InterviewCategoryDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the InterviewCategory as identified by the interviewCategoryId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{interviewCategoryId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<InterviewCategoryDto> getById(
            @ApiParam(value = "The unique ID of the InterviewCategory to retrieve", required = true)
            @PathVariable("interviewCategoryId") Integer interviewCategoryId
    ) throws NotFoundException {
        LOGGER.info("** InterviewCategoriesApi - interviewCategorysInterviewCategoryIdGet");
        InterviewCategory interviewCategory = interviewCategoryService.findById(interviewCategoryId);
        if (interviewCategory == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<InterviewCategoryDto>(InterviewCategoryDto.mapFromEntity(interviewCategory), HttpStatus.OK);
    }
    
    /**
     * The interviewCategorysInterviewCategoryIdPut is used to update
     *
     * @param interviewCategoryId the interviewCategory ID for the InterviewCategory object to update
     * @param interviewCategory the new data for the InterviewCategory object
     * @return the newly updated InterviewCategoryDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a InterviewCategory entity", notes = "A PUT request to the InterviewCategory instance endpoint with a InterviewCategory object in the request body will update an existing InterviewCategory entity in the database.", response = InterviewCategoryDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated InterviewCategory object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{interviewCategoryId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<InterviewCategoryDto> update(
            @ApiParam(value = "The unique ID of the InterviewCategory to retrieve", required = true)
            @PathVariable("interviewCategoryId") Integer interviewCategoryId,
            @ApiParam(value = "The InterviewCategory object to be created, without the interviewCategoryId fields", required = true)
            @RequestBody InterviewCategoryDto interviewCategory
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** InterviewCategorysApi - interviewCategorysPUT");
        if (interviewCategoryId != interviewCategory.id) {
            throw new InvalidDataException()
        }
        InterviewCategory interviewCategorySaved = interviewCategoryService.updateFromDto(interviewCategory)
        return new ResponseEntity<InterviewCategoryDto>(InterviewCategoryDto.mapFromEntity(interviewCategorySaved), HttpStatus.OK);
    }
}
