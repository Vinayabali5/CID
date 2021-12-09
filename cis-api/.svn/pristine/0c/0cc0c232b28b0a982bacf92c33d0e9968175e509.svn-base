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
import uk.ac.reigate.domain.lookup.StaffType
import uk.ac.reigate.dto.lookup.StaffTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.lookup.StaffTypeService


@Controller
@RequestMapping(value = "/staffTypes", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/staffTypes", description = "the staffTypes API")
public class StaffTypesApi implements ICoreDataBaseApi<StaffTypeDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StaffTypesApi.class);
    
    @Autowired
    private final StaffTypeService staffTypeService;
    
    /**
     * Default NoArgs constructor
     */
    StaffTypesApi() {}
    
    /**
     * Autowired constructor
     */
    StaffTypesApi(StaffTypeService staffTypeService) {
        this.staffTypeService = staffTypeService;
    }
    
    /**
     * The staffTypesGet method is used to retrieve a full list of all the StaffTypeDto objects
     *
     * @return A ResponseEntity with the corresponding list of StaffTypeDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StaffType entities", notes = "A GET request to the StaffTypes endpoint returns an array of all the staffTypes in the system.", response = StaffTypeDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of staffTypes")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StaffTypeDto>> getAll() throws NotFoundException {
        LOGGER.info("** StaffTypesApi - staffTypesGet");
        List<StaffType> staffTypes = staffTypeService.findAll();
        return new ResponseEntity<List<StaffTypeDto>>(StaffTypeDto.mapFromList(staffTypes), HttpStatus.OK);
    }
    
    /**
     * The staffTypesPost method is used to create a new instance of a StaffType from the supplied StaffTypeDto
     *
     * @param staffType the StaffTypeDto to use to create the new StaffType object
     * @return A ResponseEntity with the newly created StaffType object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new StaffType entity", notes = "A POST request to the StaffTypes endpoint with a StaffType object in the request body will create a new StaffType entity in the database.", response = StaffTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created StaffType entity including the staffTypeId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<StaffTypeDto> create(
            @ApiParam(value = "The StaffType object to be created, without the staffTypeId fields", required = true)
            @RequestBody @Valid StaffTypeDto staffTypeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StaffTypesApi - staffTypesPOST");
        if (staffTypeDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        StaffType staffType = staffTypeService.createFromDto(staffTypeDto)
        return new ResponseEntity<StaffTypeDto>(StaffTypeDto.mapFromEntity(staffType), HttpStatus.CREATED);
    }
    
    /**
     * The staffTypesStaffTypeIdGet method is used to retrieve an instance of a StaffTypeDto object as identified by the staffTypeId provided
     *
     * @param staffTypeId the staffType ID for the StaffType object retrieve
     * @return A ResponseEntity with the corresponding StaffTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StaffType identified by the staffTypeId", notes = "A getGET request to the StaffType instance endpoint will retrieve an instance of a StaffType entity as identified by the staffTypeId provided in the URI.", response = StaffTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StaffType as identified by the staffTypeId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{staffTypeId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StaffTypeDto> getById(
            @ApiParam(value = "The unique ID of the StaffType to retrieve", required = true)
            @PathVariable("staffTypeId") Integer staffTypeId
    ) throws NotFoundException {
        LOGGER.info("** StaffTypesApi - staffTypesStaffTypeIdGet");
        StaffType staffType = staffTypeService.findById(staffTypeId);
        if (staffType == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StaffTypeDto>(StaffTypeDto.mapFromEntity(staffType), HttpStatus.OK);
    }
    
    /**
     * The staffTypesStaffTypeIdPut is used to update
     *
     * @param staffTypeId the staffType ID for the StaffType object to update
     * @param staffType the new data for the StaffType object
     * @return the newly updated StaffTypeDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a StaffType entity", notes = "A PUT request to the StaffType instance endpoint with a StaffType object in the request body will update an existing StaffType entity in the database.", response = StaffTypeDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated StaffType object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{staffTypeId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<StaffTypeDto> update(
            @ApiParam(value = "The unique ID of the StaffType to retrieve", required = true)
            @PathVariable("staffTypeId") Integer staffTypeId,
            @ApiParam(value = "The StaffType object to be created, without the staffTypeId fields", required = true)
            @RequestBody StaffTypeDto staffTypeDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** StaffTypesApi - staffTypesPUT");
        if (staffTypeId != staffTypeDto.id) {
            throw new InvalidDataException()
        }
        StaffType staffType = staffTypeService.updateFromDto(staffTypeDto)
        return new ResponseEntity<StaffTypeDto>(StaffTypeDto.mapFromEntity(staffType), HttpStatus.OK);
    }
}
