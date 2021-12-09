package uk.ac.reigate.api.learningsupport;

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
import uk.ac.reigate.dto.learningsupport.BulkStudentCourseConcessionDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.learningsupport.BulkStudentCourseConcessionService


@Controller
@RequestMapping(value = "/bulk-student-course-concession", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/bulk-student-course-concession", description = "the mass BulkStudentCourseConcession API")
public class BulkStudentCourseConcessionsApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BulkStudentCourseConcessionsApi.class);
    
    
    @Autowired
    private final BulkStudentCourseConcessionService bulkStudentCourseConcessionService
    
    /**
     * Default NoArgs constructor
     */
    BulkStudentCourseConcessionsApi() {}
    
    /**
     * Autowired constructor
     */
    BulkStudentCourseConcessionsApi(BulkStudentCourseConcessionService bulkStudentCourseConcessionService) {
        this.bulkStudentCourseConcessionService = bulkStudentCourseConcessionService;
    }
    
    /**
     * The method is used to create bulk-student-course-concession
     */
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<BulkStudentCourseConcessionDto> createBulkStudentCourseConcession(
            @ApiParam(value = "The StudentCourseConcession object to be created, with the courseId fields", required = true)
            @RequestBody BulkStudentCourseConcessionDto bulkStudentCourseConcessionDto
    ) throws NotFoundException{
        LOGGER.info("** bulk-student-course-concessionApi POST");
        return bulkStudentCourseConcessionService.createBulkCourseConcession(bulkStudentCourseConcessionDto)
    }
}
