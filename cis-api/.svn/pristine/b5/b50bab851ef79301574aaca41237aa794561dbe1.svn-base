package uk.ac.reigate.api.integration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.integration.ApplicationImportDTO
import uk.ac.reigate.services.integration.ApplicationImportService
import uk.ac.reigate.services.student.StudentService

@RestController
@RequestMapping(value = '/import/application')
class ApplicationImportApi {
    
    @Autowired
    ApplicationImportService applicationImportService
    
    @Autowired
    StudentService studentService
    
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasRole('Service User')")
    @RequestMapping(value = '', method = RequestMethod.POST, produces = 'application/json')
    public ResponseEntity<ApplicationImportDTO> importApplication(@RequestBody ApplicationImportDTO app) {
        Student student = applicationImportService.processImport(app)
        //studentService.find
        return new ResponseEntity<ApplicationImportDTO>(new ApplicationImportDTO(student), HttpStatus.CREATED)
    }
}
