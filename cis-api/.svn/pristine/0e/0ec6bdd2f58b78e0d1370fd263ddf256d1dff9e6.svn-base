package uk.ac.reigate.api.exams.basedata

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
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import uk.ac.reigate.domain.exams.basedata.OptionComponent
import uk.ac.reigate.dto.exams.basedata.OptionComponentDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.exams.basedata.OptionComponentService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = "/option-components", produces = [APPLICATION_JSON_VALUE])
@Api(value = "/OptionComponentsApi", description = "The Exam basedata OptionComponent Resource API")
public class OptionComponentsApi {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(OptionComponentsApi.class)
    
    @Autowired
    OptionComponentService optionComponentService
    
    
    /**
     * Default No Args constructor
     */
    OptionComponentsApi() {}
    
    /**
     * Default Autowired constructor
     */
    OptionComponentsApi(OptionComponentService optionComponentService) {
        this.optionComponentService = optionComponentService;
    }
    
    /**
     * The optionComponentPost method is used to create a new instance of an OptionComponent object from the supplied OptionComponentDto entity
     * 
     * @param optionComponent The optionComponentDto to use to create the new OptionComponent object
     * @return A ResponseEntity with an OK object
     * @throws NotFoundException
     */
    @ApiOperation(value = "Creates a new OptionComponent entity",
    notes = "A POST request to the OptionComponents endpoint with an OptionComponent object in the request body will create a new OptionComponent entity in the database")
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns an OK object stating that the OptionComponent entity has just been created")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<OptionComponentDto> create(
            @ApiParam(value = "The optionComponent object to be created", required = true)
            @RequestBody @Valid OptionComponentDto optionComponent
    ) throws NotFoundException {
        LOGGER.info("** OptionComponentApi - optionComponentPost");
        OptionComponent savedOptionComponent = optionComponentService.createFromDto(optionComponent);
        return new ResponseEntity<OptionComponentDto>(OptionComponentDto.mapFromEntity(savedOptionComponent), HttpStatus.CREATED);
    }
}
