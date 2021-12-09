package uk.ac.reigate.api.lookup;

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

import uk.ac.reigate.api.ICoreDataBaseApi
import uk.ac.reigate.domain.lookup.FileCategory
import uk.ac.reigate.dto.lookup.FileCategoryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.lookup.FileCategoryService


@Controller
@RequestMapping(value = "/fileCategories", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/fileCategories", description = "the fileCategorys API")
public class FileCategoriesApi implements ICoreDataBaseApi<FileCategoryDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FileCategoriesApi.class);
    
    @Autowired
    private final FileCategoryService fileCategoryService;
    
    /**
     * Default NoArgs constructor
     */
    FileCategoriesApi() {}
    
    /**
     * Autowired constructor
     */
    FileCategoriesApi(FileCategoryService fileCategoryService) {
        this.fileCategoryService = fileCategoryService;
    }
    
    /**
     * The fileCategorysGet method is used to retrieve a full list of all the FileCategoryDto objects
     *
     * @return A ResponseEntity with the corresponding list of FileCategoryDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of FileCategory entities", notes = "A GET request to the FileCategorys endpoint returns an array of all the fileCategorys in the system.", response = FileCategoryDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of fileCategories")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<FileCategoryDto>> getAll() throws NotFoundException {
        LOGGER.info("** FileCategoriesApi - fileCategoriesGet");
        List<FileCategory> fileCategories = fileCategoryService.findAll();
        return new ResponseEntity<List<FileCategoryDto>>(FileCategoryDto.mapFromList(fileCategories), HttpStatus.OK);
    }
    
    /**
     * The fileCategorysPost method is used to create a new instance of a FileCategory from the supplied FileCategoryDto
     *
     * @param fileCategory the FileCategoryDto to use to create the new FileCategory object
     * @return A ResponseEntity with the newly created FileCategory object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new FileCategory entity", notes = "A POST request to the FileCategorys endpoint with a FileCategory object in the request body will create a new FileCategory entity in the database.", response = FileCategoryDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created FileCategory entity including the fileCategoryId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<FileCategoryDto> create(
            @ApiParam(value = "The FileCategory object to be created, without the fileCategoryId fields", required = true)
            @RequestBody @Valid FileCategoryDto fileCategoryDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** FileCategoriesApi - fileCategoriesPOST");
        if (fileCategoryDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        FileCategory fileCategory = fileCategoryService.createFromDto(fileCategoryDto)
        return new ResponseEntity<FileCategoryDto>(FileCategoryDto.mapFromEntity(fileCategory), HttpStatus.CREATED);
    }
    
    /**
     * The fileCategorysFileCategoryIdGet method is used to retrieve an instance of a FileCategoryDto object as identified by the fileCategoryId provided
     *
     * @param fileCategoryId the fileCategory ID for the FileCategory object retrieve
     * @return A ResponseEntity with the corresponding FileCategoryDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a FileCategory identified by the fileCategoryId", notes = "A getGET request to the FileCategory instance endpoint will retrieve an instance of a FileCategory entity as identified by the fileCategoryId provided in the URI.", response = FileCategoryDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the FileCategory as identified by the fileCategoryId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{fileCategoryId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<FileCategoryDto> getById(
            @ApiParam(value = "The unique ID of the FileCategory to retrieve", required = true)
            @PathVariable("fileCategoryId") Integer fileCategoryId
    ) throws NotFoundException {
        LOGGER.info("** FileCategorysApi - fileCategorysFileCategoryIdGet");
        FileCategory fileCategory = fileCategoryService.findById(fileCategoryId);
        if (fileCategory == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<FileCategoryDto>(FileCategoryDto.mapFromEntity(fileCategory), HttpStatus.OK);
    }
    
    /**
     * The fileCategorysFileCategoryIdPut is used to update
     *
     * @param fileCategoryId the fileCategory ID for the FileCategory object to update
     * @param fileCategory the new data for the FileCategory object
     * @return the newly updated FileCategoryDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a FileCategory entity", notes = "A PUT request to the FileCategory instance endpoint with a FileCategory object in the request body will update an existing FileCategory entity in the database.", response = FileCategoryDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated FileCategory object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{fileCategoryId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<FileCategoryDto> update(
            @ApiParam(value = "The unique ID of the FileCategory to retrieve", required = true)
            @PathVariable("fileCategoryId") Integer fileCategoryId,
            @ApiParam(value = "The FileCategory object to be created, without the fileCategoryId fields", required = true)
            @RequestBody FileCategoryDto fileCategoryDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** FileCategorysApi - fileCategorysPOST");
        if (fileCategoryId != fileCategoryDto.id) {
            throw new InvalidDataException()
        }
        FileCategory fileCategory = fileCategoryService.updateFromDto(fileCategoryDto)
        return new ResponseEntity<FileCategoryDto>(FileCategoryDto.mapFromEntity(fileCategory), HttpStatus.OK);
    }
}
