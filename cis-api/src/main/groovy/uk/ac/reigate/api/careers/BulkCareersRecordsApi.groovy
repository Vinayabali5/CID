package uk.ac.reigate.api.careers;

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
import uk.ac.reigate.dto.careers.BulkCareersRecordDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.careers.BulkCareersRecordService


@Controller
@RequestMapping(value = "/bulk-careers-record", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/bulk-careers-record", description = "the mass ilp interview API")
public class BulkCareersRecordsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BulkCareersRecordsApi.class);
    
    
    @Autowired
    private final BulkCareersRecordService bulkCareersRecordService
    
    /**
     * Default NoArgs constructor
     */
    BulkCareersRecordsApi() {}
    
    /**
     * Autowired constructor
     */
    BulkCareersRecordsApi(BulkCareersRecordService bulkCareersRecordService) {
        this.bulkCareersRecordService = bulkCareersRecordService;
    }
    
    /**
     * The method is used to create bulk careers record
     */
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<BulkCareersRecordDto> createBulkCareersRecord(
            @ApiParam(value = "The ILP Interview object to be created, with the ilpInterviewId fields", required = true)
            @RequestBody @Valid BulkCareersRecordDto bulkCareersRecordDto
    ) throws NotFoundException{
        LOGGER.info("** StatementBanksApi - mass ILP Entry POST");
        return bulkCareersRecordService.createMassILPEntries(bulkCareersRecordDto)
    }
}
