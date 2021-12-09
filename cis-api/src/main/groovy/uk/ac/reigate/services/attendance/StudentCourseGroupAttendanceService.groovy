package uk.ac.reigate.services.attendance

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.attendance.StudentCourseGroupAttendance
import uk.ac.reigate.repositories.attendance.StudentCourseGroupAttendanceRepository
import uk.ac.reigate.services.AcademicYearService

@Service
class StudentCourseGroupAttendanceService {
    
    @Autowired
    StudentCourseGroupAttendanceRepository studentCourseGroupAttendanceRepository
    
    @Autowired
    private final AcademicYearService academicYearService
    
    /**
     * Default NoArgs constructor
     */
    StudentCourseGroupAttendanceService() {}
    
    /**
     * Autowired Constructor
     *
     * @param studentCourseGroupAttendanceRepository
     */
    StudentCourseGroupAttendanceService(StudentCourseGroupAttendanceRepository studentCourseGroupAttendanceRepository, AcademicYearService academicYearService) {
        this.studentCourseGroupAttendanceRepository = studentCourseGroupAttendanceRepository;
        this.academicYearService = academicYearService;
    }
    
    /**
     * Find an individual studentCourseGroupAttendance using the studentCourseGroupAttendances ID fields
     *
     * @param id the ID fields to search for
     * @return the StudentCourseGroupAttendance object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    StudentCourseGroupAttendance findByStudentIdAndCourseId(Integer studentId, Integer courseId) {
        return studentCourseGroupAttendanceRepository.findByStudentIdAndCourseId(studentId, courseId)
    }
    
    @Transactional(readOnly = true)
    StudentCourseGroupAttendance searchByYearStudentIdAndCourseId(AcademicYear academicYear, Integer studentId, Integer courseId, Date startDate, Date endDate) {
        return studentCourseGroupAttendanceRepository.findByAcademicYearStudentIdAndCourseGroupIdForDateRange(academicYear, studentId, courseId, startDate, endDate)
    }
    
    /**
     * Find a single page of StudentCourseGroupAttendance objects
     * @return a SearchResult set with the list of StudentCourseGroupAttendances
     */
    @Transactional(readOnly = true)
    List<StudentCourseGroupAttendance> findAll() {
        return studentCourseGroupAttendanceRepository.findAll();
    }
}
