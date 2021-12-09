package uk.ac.reigate.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import io.swagger.annotations.ApiParam
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.CourseSpecService

@RestController
@RequestMapping(value = ["/courseSpecs", "/course-specs"])
class CourseSpecApi {
    
    @Autowired
    CourseSpecService courseSpecService
    
    @Autowired
    AcademicYearService academicYearService
    
    @RequestMapping(value = "{spec}", method = RequestMethod.GET, produces = 'application/json')
    ResponseEntity<?> getCourseSpecDescription(@PathVariable String spec) {
        def out = [spec: spec, description: courseSpecService.getCourseSpecDescription(spec)]
        return new ResponseEntity<?>(out, HttpStatus.OK)
    }
    
    @RequestMapping(value = "{spec}/valid", method = RequestMethod.GET, produces = 'application/json')
    ResponseEntity<?> checkCourseSpecIsValid(
            @ApiParam(value = "The Spec of the CourseGroup to retrieve", required = true)
            @PathVariable String spec,
            @ApiParam(value = "The Id of the Year to retrieve", required = false)
            @RequestParam(value = "academicYearId", required = false) Integer academicYearId) {
        if (academicYearId == null) {
            academicYearId  = academicYearService.getCurrentAcademicYear().id
        }
        def out = [spec: spec, valid: courseSpecService.isCourseSpecOnTimetable(spec, academicYearId)]
        return new ResponseEntity<?>(out, HttpStatus.OK)
    }
}
