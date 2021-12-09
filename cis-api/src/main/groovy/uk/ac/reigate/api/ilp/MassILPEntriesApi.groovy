package uk.ac.reigate.api.ilp;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

import javax.validation.Valid

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import io.swagger.annotations.Api
import io.swagger.annotations.ApiParam
import uk.ac.reigate.dto.ilp.MassILPEntryDto
import uk.ac.reigate.dto.ilp.MassILPLetterDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.ilp.MassILPEntryService


@Controller
@RequestMapping(value = "/mass-ilp-entry", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/mass-ilp-entry", description = "the mass ilp interview API")
public class MassILPEntriesApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MassILPEntriesApi.class);
    
    
    @Autowired
    private final MassILPEntryService massILPEntryService
    
    /**
     * Default NoArgs constructor
     */
    MassILPEntriesApi() {}
    
    /**
     * Autowired constructor
     */
    MassILPEntriesApi(MassILPEntryService massILPEntryService) {
        this.massILPEntryService = massILPEntryService;
    }
    
    /**
     * The massLetterPOST is used to create mass letters
     */
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<MassILPEntryDto> createMassILPEntry(
            @ApiParam(value = "The ILP Interview object to be created, with the ilpInterviewId fields", required = true)
            @RequestBody @Valid MassILPEntryDto massILPEntryDto
    ) throws NotFoundException{
        LOGGER.info("** StatementBanksApi - mass ILP Entry POST");
        return massILPEntryService.createMassILPEntries(massILPEntryDto)
    }
}
