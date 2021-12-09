package uk.ac.reigate.api.exams.edi

import io.swagger.annotations.Api

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import uk.ac.reigate.domain.exams.edi.EdiAuditFileLog
import uk.ac.reigate.dto.exams.edi.EdiAuditFileLogDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.exams.edi.EdiAuditFileLogService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the EdiAuditFileLog API")
public class EdiAuditFileLogsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EdiAuditFileLogsApi.class);
    
    @Autowired
    private final EdiAuditFileLogService ediAuditFileLogService;
    
    /**
     * Default No Args constructor
     */
    EdiAuditFileLogsApi() {}
    
    /**
     * Default Autowired constructor
     */
    EdiAuditFileLogsApi(EdiAuditFileLogService ediAuditFileLogService) {
        this.ediAuditFileLogService = ediAuditFileLogService;
    }
    
    /**
     * The getAll method is used to retrieve a full list of all the EdiAuditFileLogDto objects
     *
     * @return A ResponseEntity with the corresponding list of EdiAuditFileLogDto objects.
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @RequestMapping(value = "/ediAuditFileLogs", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<EdiAuditFileLogDto>> getAll() throws NotFoundException {
        LOGGER.info("** EdiAuditFileLogsApi - ediAuditFileLogsGet");
        List<EdiAuditFileLog> ediAuditFileLogs = ediAuditFileLogService.findAll();
        return new ResponseEntity<List<EdiAuditFileLogDto>>(EdiAuditFileLogDto.mapFromList(ediAuditFileLogs), HttpStatus.OK);
    }
}
