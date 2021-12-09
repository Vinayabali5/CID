package uk.ac.reigate.api.ilp;

import javax.validation.Valid

import io.swagger.annotations.Api
import io.swagger.annotations.ApiParam

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import uk.ac.reigate.dto.ilp.MassILPLetterDto
import uk.ac.reigate.dto.ilp.MassILPPraiseLetterDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.ilp.MassILPLetterService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/mass-letters", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/mass-letters", description = "the statementBanks API")
public class MassILPLettersApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MassILPLettersApi.class);
    
    
    @Autowired
    private final MassILPLetterService massILPLetterService
    
    /**
     * Default NoArgs constructor
     */
    MassILPLettersApi() {}
    
    /**
     * Autowired constructor
     */
    MassILPLettersApi(MassILPLetterService massILPLetterService) {
        this.massILPLetterService = massILPLetterService;
    }
    
    /**
     * The massLetterPOST is used to create mass letters
     */
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<MassILPLetterDto> createMassLetter(
            @ApiParam(value = "The Letter object to be created, with the letterId fields", required = true)
            @RequestBody @Valid MassILPLetterDto massILPLetterDto
    ) throws NotFoundException{
        LOGGER.info("** StatementBanksApi - mass Letter POST");
        return massILPLetterService.createMassLetter(massILPLetterDto)
    }
    
    /**
     * The massPraise email POST is used to create mass praise letters
     */
    @RequestMapping(value = "/praise-email", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<MassILPPraiseLetterDto> createMassPraiseEmail(
            @ApiParam(value = "The Letter object to be created, with the letterId fields", required = true)
            @RequestBody @Valid MassILPPraiseLetterDto massILPPraiseLetterDto
    ) throws NotFoundException{
        LOGGER.info("** StatementBanksApi - mass Letter POST");
        return massILPLetterService.createMassPraiseEmail(massILPPraiseLetterDto)
    }
}
