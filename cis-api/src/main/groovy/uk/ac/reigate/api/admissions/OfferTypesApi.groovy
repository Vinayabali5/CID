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
import uk.ac.reigate.domain.admissions.OfferType
import uk.ac.reigate.dto.admissions.OfferTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.admissions.OfferTypeService


@Controller
@RequestMapping(value = "/offerTypes", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/offerTypes", description = "the offerTypes API")
public class OfferTypesApi implements ICoreDataApi<OfferTypeDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OfferTypesApi.class);
    
    @Autowired
    private final OfferTypeService offerTypeService;
    
    /**
     * Default NoArgs constructor
     */
    OfferTypesApi() {}
    
    /**
     * Autowired constructor
     */
    OfferTypesApi(OfferTypeService offerTypeService) {
        this.offerTypeService = offerTypeService;
    }
    
    /**
     * The offerTypesGet method is used to retrieve a full list of all the OfferTypeDto objects
     *
     * @return A ResponseEntity with the corresponding list of OfferTypeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of OfferType entities", notes = "A GET request to the OfferTypes endpoint returns an array of all the offerTypes in the system.", response = OfferTypeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of offerTypes")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<OfferTypeDto>> getAll() throws NotFoundException {
        LOGGER.info("** OfferTypesApi - offerTypesGet");
        List<OfferType> offerTypes = offerTypeService.findAll();
        return new ResponseEntity<List<OfferTypeDto>>(OfferTypeDto.mapFromList(offerTypes), HttpStatus.OK);
    }
    
    /**
     * The offerTypesPost method is used to create a new instance of a OfferType from the supplied OfferTypeDto
     *
     * @param offerType the OfferTypeDto to use to create the new OfferType object
     * @return A ResponseEntity with the newly created OfferType object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new OfferType entity", notes = "A POST request to the OfferTypes endpoint with a OfferType object in the request body will create a new OfferType entity in the database.", response = OfferTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created OfferType entity including the offerTypeId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<OfferTypeDto> create(
            @ApiParam(value = "The OfferType object to be created, without the offerTypeId fields", required = true)
            @RequestBody @Valid OfferTypeDto offerType) throws NotFoundException, InvalidDataException {
        LOGGER.info("** OfferTypesApi - offerTypesPOST");
        if (offerType.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        OfferType offerTypeSaved = offerTypeService.createFromDto(offerType)
        return new ResponseEntity<OfferTypeDto>(OfferTypeDto.mapFromEntity(offerTypeSaved), HttpStatus.CREATED);
    }
    
    /**
     * The offerTypesOfferTypeIdGet method is used to retrieve an instance of a OfferTypeDto object as identified by the offerTypeId provided
     *
     * @param offerTypeId the offerType ID for the OfferType object retrieve
     * @return A ResponseEntity with the corresponding OfferTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a OfferType identified by the offerTypeId", notes = "A getGET request to the OfferType instance endpoint will retrieve an instance of a OfferType entity as identified by the offerTypeId provided in the URI.", response = OfferTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the OfferType as identified by the offerTypeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{offerTypeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<OfferTypeDto> getById(
            @ApiParam(value = "The unique ID of the OfferType to retrieve", required = true)
            @PathVariable("offerTypeId") Integer offerTypeId
    ) throws NotFoundException {
        LOGGER.info("** OfferTypesApi - offerTypesOfferTypeIdGet");
        OfferType offerType = offerTypeService.findById(offerTypeId);
        if (offerType == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<OfferTypeDto>(OfferTypeDto.mapFromEntity(offerType), HttpStatus.OK);
    }
    
    /**
     * The offerTypesOfferTypeIdPut is used to update
     *
     * @param offerTypeId the offerType ID for the OfferType object to update
     * @param offerType the new data for the OfferType object
     * @return the newly updated OfferTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a OfferType entity", notes = "A PUT request to the OfferType instance endpoint with a OfferType object in the request body will update an existing OfferType entity in the database.", response = OfferTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated OfferType object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{offerTypeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<OfferTypeDto> update(
            @ApiParam(value = "The unique ID of the OfferType to retrieve", required = true)
            @PathVariable("offerTypeId") Integer offerTypeId,
            @ApiParam(value = "The OfferType object to be created, without the offerTypeId fields", required = true)
            @RequestBody OfferTypeDto offerType
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** OfferTypesApi - offerTypesPUT");
        if (offerTypeId != offerType.id) {
            throw new InvalidDataException()
        }
        OfferType offerTypeSaved = offerTypeService.updateFromDto(offerType)
        return new ResponseEntity<OfferTypeDto>(OfferTypeDto.mapFromEntity(offerTypeSaved), HttpStatus.OK);
    }
}
