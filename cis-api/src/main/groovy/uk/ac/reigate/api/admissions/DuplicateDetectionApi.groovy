package uk.ac.reigate.api.admissions;

import javax.validation.Valid

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.admissions.DuplicateApplicationDto
import uk.ac.reigate.dto.admissions.DuplicateDetectionDto
import uk.ac.reigate.dto.admissions.OfferTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.student.StudentService

@Controller
@RequestMapping(value = "/duplicate-detection", produces = [ MediaType.APPLICATION_JSON_VALUE ])
@Api(value = "/duplicate-detection", description = "the interviews API")
public class DuplicateDetectionApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DuplicateDetectionApi.class);
    
    @Autowired
    private final StudentService studentService
    
    /**
     * Default NoArgs constructor
     */
    DuplicateDetectionApi() {}
    
    /**
     * This method is used to detect potential duplicate applications
     *
     * @param dupp a DuplicateDetectionDto Json Packet with at minimum a Surname and DoB
     * @return ResponseEntity with the DuplicateDetectionDto and the appropriate HttpStatus code
     */
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<DuplicateDetectionDto> detectDuplicate(
            @RequestBody @Valid DuplicateDetectionDto dupp) {
        LOGGER.info("*** InterviewRestController.getByStudent")
        if(dupp.surname != null && dupp.dob != null) {
            List<Student> duplicates = studentService.findByPersonSurnameAndDob(dupp.surname, (Date) dupp.dob)
            if(duplicates != null && duplicates.size() != 0) {
                dupp.matches = new ArrayList<DuplicateApplicationDto>()
                duplicates.each { it ->
                    dupp.matches.add(new DuplicateApplicationDto(it.id, it.person))
                }
                return new ResponseEntity<DuplicateDetectionDto>(dupp, HttpStatus.OK)
            }  else {
                return new ResponseEntity<List<DuplicateDetectionDto>>(dupp, HttpStatus.BAD_REQUEST)
            }
        }
    }
}