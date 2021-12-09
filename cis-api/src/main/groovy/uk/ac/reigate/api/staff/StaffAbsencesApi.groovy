package uk.ac.reigate.api.staff;

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
import uk.ac.reigate.domain.staff.StaffAbsence
import uk.ac.reigate.dto.staff.StaffAbsenceDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.staff.StaffAbsenceService


@Controller
@RequestMapping(value = "/staff-absences", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/staff-absences", description = "the staffAbsences API")
public class StaffAbsencesApi  {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StaffAbsencesApi.class);
    
    @Autowired
    private final StaffAbsenceService staffAbsenceService;
    
    /**
     * Default NoArgs constructor
     */
    StaffAbsencesApi() {}
    
    /**
     * Autowired constructor
     */
    StaffAbsencesApi(StaffAbsenceService staffAbsenceService) {
        this.staffAbsenceService = staffAbsenceService;
    }
    
    /**
     * The staffAbsencesGet method is used to retrieve a full list of all the StaffAbsenceDto objects
     *
     * @return A ResponseEntity with the corresponding list of StaffAbsenceDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of StaffAbsence entities", notes = "A GET request to the Nationalities endpoint returns an array of all the staffAbsences in the system.", response = StaffAbsenceDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of staffAbsences")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StaffAbsenceDto>> getAll() throws NotFoundException {
        LOGGER.info("** StaffAbsencesApi - staffAbsencesGet");
        List<StaffAbsence> staffAbsences = staffAbsenceService.findAll();
        return new ResponseEntity<List<StaffAbsenceDto>>(StaffAbsenceDto.mapFromList(staffAbsences), HttpStatus.OK);
    }
    
    /**
     * The staffAbsencesStaffAbsenceIdGet method is used to retrieve an instance of a StaffAbsenceDto object as identified by the staffAbsenceId provided
     *
     * @param staffAbsenceId the staffAbsence ID for the StaffAbsence object retrieve
     * @return A ResponseEntity with the corresponding StaffAbsenceDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a StaffAbsence identified by the staffAbsenceId", notes = "A getGET request to the StaffAbsence instance endpoint will retrieve an instance of a StaffAbsence entity as identified by the staffAbsenceId provided in the URI.", response = StaffAbsenceDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the StaffAbsence as identified by the staffAbsenceId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{staffAbsenceId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<StaffAbsenceDto> getById(
            @ApiParam(value = "The unique ID of the StaffAbsence to retrieve", required = true)
            @PathVariable("staffAbsenceId") Integer staffAbsenceId
    ) throws NotFoundException {
        LOGGER.info("** StaffAbsencesApi - staffAbsencesStaffAbsenceIdGet");
        StaffAbsence staffAbsence = staffAbsenceService.findById(staffAbsenceId);
        if (staffAbsence == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<StaffAbsenceDto>(StaffAbsenceDto.mapFromEntity(staffAbsence), HttpStatus.OK);
    }
    
    @RequestMapping(value = "staff/{staffId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<StaffAbsenceDto>> getByStaffId(
            @ApiParam(value = "The unique ID of the Staff to retrieve", required = true)
            @PathVariable("staffId") Integer staffId
    ) throws NotFoundException {
        LOGGER.info("** StaffAbsencesApi - staffAbsencesStaffAbsenceIdGet");
        List<StaffAbsence> staffAbsences = staffAbsenceService.findByStaffId(staffId);
        if (staffAbsences == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<List<StaffAbsenceDto>>(StaffAbsenceDto.mapFromList(staffAbsences), HttpStatus.OK);
    }
}
