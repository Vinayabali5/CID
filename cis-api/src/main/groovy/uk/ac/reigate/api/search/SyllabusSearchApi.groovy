package uk.ac.reigate.api.search

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.exams.basedata.Syllabus
import uk.ac.reigate.dto.exams.basedata.SyllabusDto
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.exams.basedata.SyllabusService

@RestController
@RequestMapping(value="/")
@Api(value = "/", description = "The Exam basedata Syllabus Searching API")
class SyllabusSearchApi {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(SyllabusSearchApi.class);
    
    @Autowired
    SyllabusService syllabusService
    
    @Autowired
    AcademicYearService academicYearService
    
    /**
     * This method is used to search the syllabus by syllabusCode
     * @param syllabusCode
     * @return
     * @throws NotFoundException
     */
    @ApiOperation(value = "Performs a search for syllabi based on given parameters.", response = SyllabusDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of Syllabi objects")
    ])
    @RequestMapping(value="/search/syllabus", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<SyllabusDto>> search(
            @ApiParam(value = "syllabus Code", name = "syllabusCode", required = true)
            @RequestParam(value = "syllabusCode", required = true) List<String> syllabusCode
    ) throws NotFoundException {
        List<Syllabus> syllabi = syllabusService.findByCode(syllabusCode);
        List<Syllabus> entryCodeSyllabi;
        if(syllabusCode != null) {
            entryCodeSyllabi = syllabusService.findByEntryCode(syllabusCode)
        }
        List<Syllabus> allSyllabi = (syllabi + entryCodeSyllabi).unique(false)
        return new ResponseEntity<List<SyllabusDto>>(SyllabusDto.mapFromList(allSyllabi), HttpStatus.OK);
    }
    
    /**
     * This method is used to search the syllabus by syllabusCode and academicYear
     * @param syllabusCode
     * @param year
     * @return
     * @throws NotFoundException
     */
    @ApiOperation(value = "Performs a search for syllabi based on given parameters.", response = SyllabusDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of Syllabi objects")
    ])
    @RequestMapping(value="/searchByYear/syllabus", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<SyllabusDto>> searchByYearAndCode(
            @ApiParam(value = "syllabus Code", name = "syllabusCode", required = true)
            @RequestParam(value = "syllabusCode", required = true) List<String> syllabusCode,
            @RequestParam(value = "year", required = false) String year
    ) throws NotFoundException {
        AcademicYear academicYear
        if (year) {
            LOGGER.info("CourseApi Searching for Year Code: " + year);
            academicYear = academicYearService.findByCode(year)
        }
        if (academicYear == null) {
            LOGGER.info("CourseApi No Year Found or Supplied - Using default")
            academicYear = academicYearService.getCurrentAcademicYear()
        }
        List<Syllabus> syllabi = syllabusService.findByCodeAndYear(academicYear, syllabusCode);
        List<Syllabus> entryCodeSyllabi;
        if(syllabusCode != null) {
            entryCodeSyllabi = syllabusService.findByEntryCodeAndYear(academicYear, syllabusCode)
        }
        List<Syllabus> allSyllabi = (syllabi + entryCodeSyllabi).unique(false)
        return new ResponseEntity<List<SyllabusDto>>(SyllabusDto.mapFromList(allSyllabi), HttpStatus.OK);
    }
}
