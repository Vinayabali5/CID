package uk.ac.reigate.services.learningsupport

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Enrolment
import uk.ac.reigate.domain.learning_support.StudentCourseConcession
import uk.ac.reigate.dto.learningsupport.BulkStudentCourseConcessionDto
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.CourseService
import uk.ac.reigate.services.enrolments.EnrolmentService
import uk.ac.reigate.services.lookup.ConcessionTypeService
import uk.ac.reigate.services.student.StudentService

@Service
class BulkStudentCourseConcessionService {
    
    @Autowired
    private final StudentService studentService
    
    @Autowired
    private final EnrolmentService enrolmentService
    
    @Autowired
    private final ConcessionTypeService concessionTypeService
    
    @Autowired
    private final CourseService courseService
    
    @Autowired
    private final StudentCourseConcessionService studentCourseConcessionService
    
    @Autowired
    private final AcademicYearService academicYearService;
    
    
    /**
     * Default NoArgs constructor
     */
    BulkStudentCourseConcessionService() {}
    
    
    /**
     * This service method is used to create a Bulk StudentCourseConcession data object in the database from a partial or 
     * complete StudentCourseConcessionDto object.
     *
     * @param studentCourseConcession the StudentCourseConcessionDto object to use for the creation of the StudentCourseConcession data object.
     * @return the saved version of the StudentCourseConcession data object
     */
    @Transactional
    public void createBulkCourseConcession(BulkStudentCourseConcessionDto bulkStudentCourseConcessionDto) {
        if(bulkStudentCourseConcessionDto.studentId != null && bulkStudentCourseConcessionDto.concessionTypeId) {
            //  AcademicYear academicYear = academicYearService.getCurrentAcademicYear()
            List<Enrolment> enrolmentList = enrolmentService.findByStudentId(bulkStudentCourseConcessionDto.studentId)
            if(enrolmentList != null) {
                enrolmentList.each { it ->
                    if(it.endDate == null && it.ilr == true) {
                        Course course = courseService.findById(it.course.id)
                        if(course != null) {
                            // Create StudentCourseConcession Bulk Entry
                            StudentCourseConcession studentCourseConcession = new StudentCourseConcession()
                            studentCourseConcession.student = studentService.findById(bulkStudentCourseConcessionDto.studentId)
                            studentCourseConcession.course = course
                            studentCourseConcession.concessionType = concessionTypeService.findById(bulkStudentCourseConcessionDto.concessionTypeId)
                            studentCourseConcession.extraTimePercentage = bulkStudentCourseConcessionDto.extraTimePercentage
                            studentCourseConcessionService.save(studentCourseConcession)
                        }
                    }
                }
            }
        }
    }
}
