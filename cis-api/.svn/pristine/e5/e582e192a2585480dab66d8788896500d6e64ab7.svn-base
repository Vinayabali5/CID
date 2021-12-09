package uk.ac.reigate.api.exams.edi

import io.swagger.annotations.Api
import io.swagger.annotations.ApiParam

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import uk.ac.reigate.domain.exams.edi.EdiAuditEntryLog
import uk.ac.reigate.dto.exams.edi.EdiAuditEntryLogDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.exams.edi.EdiAuditEntryLogService
import uk.ac.reigate.services.student.StudentService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = "/", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/", description = "the EdiAuditEntryLog API")
public class EdiAuditEntryLogsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EdiAuditEntryLogsApi.class);
    
    @Autowired
    private final EdiAuditEntryLogService ediAuditEntryLogService;
    
    @Autowired
    private final StudentService studentService;
    
    /**
     * Default No Args constructor
     */
    EdiAuditEntryLogsApi() {}
    
    /**
     * Default Autowired constructor
     */
    EdiAuditEntryLogsApi(EdiAuditEntryLogService ediAuditEntryLogService) {
        this.ediAuditEntryLogService = ediAuditEntryLogService;
    }
    
    
    /**
     * @return List of EdiAuditEntryLogDto objects
     * @throws NotFoundException
     */
    @RequestMapping(value = "/ediAuditEntryLogs", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<EdiAuditEntryLogDto>> getAll() throws NotFoundException {
        LOGGER.info("** EdiAuditEntryLogsApi - ediAuditEntryLogsGet");
        List<EdiAuditEntryLog> ediAuditEntryLogs = ediAuditEntryLogService.findAll();
        return new ResponseEntity<List<EdiAuditEntryLogDto>>(EdiAuditEntryLogDto.mapFromList(ediAuditEntryLogs), HttpStatus.OK);
    }
    
    
    /**
     * @param examYear
     * @return List of EdiAuditEntryLogDto objects By examYear
     * @throws NotFoundException
     */
    @RequestMapping(value = "/ediAuditEntryLogs/examYear", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<EdiAuditEntryLogDto>> getByYear(
            @ApiParam(value = "exam Year", name = "examYear", required = true)
            @RequestParam(value = "examYear", required = true)String examYear) throws NotFoundException {
        List<EdiAuditEntryLog> ediAuditEntryLog = ediAuditEntryLogService.getByYear(examYear);
        return new ResponseEntity<List<EdiAuditEntryLogDto>>(EdiAuditEntryLogDto.mapFromList(ediAuditEntryLog), HttpStatus.OK)
    }
    
    /**
     * @param studentId
     * @param examYear
     * @return List of EdiAuditEntryLogDto objects on studentId and exam year
     * @throws NotFoundException
     */
    @RequestMapping(value = "/ediAuditEntryLogs/studentId/examYear", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<EdiAuditEntryLogDto>> getByStudentAndYear(
            @ApiParam(value = "studentId", name = "studentId", required = true)
            @RequestParam(value = "studentId", required = true)Integer studentId,
            @ApiParam(value = "exam Year", name = "examYear", required = true)
            @RequestParam(value = "examYear", required = true) String examYear
    ) throws NotFoundException {
        List<EdiAuditEntryLog> ediAuditEntryLog = ediAuditEntryLogService.getByStudentAndYear(studentId, examYear);
        return new ResponseEntity<List<EdiAuditEntryLogDto>>(EdiAuditEntryLogDto.mapFromList(ediAuditEntryLog), HttpStatus.OK)
    }
}
