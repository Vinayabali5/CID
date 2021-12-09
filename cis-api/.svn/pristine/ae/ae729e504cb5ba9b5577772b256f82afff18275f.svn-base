package uk.ac.reigate.services.attendance

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.attendance.StudentAttendance
import uk.ac.reigate.repositories.attendance.StudentAttendanceRepository
import uk.ac.reigate.services.AcademicYearService

@Service
class StudentAttendanceService {
    
    @Autowired
    StudentAttendanceRepository studentAttendanceRepository
    
    @Autowired
    private final AcademicYearService academicYearService
    
    /**
     * Default NoArgs constructor
     */
    StudentAttendanceService() {}
    
    /**
     * Autowired Constructor
     *
     * @param studentAttendanceRepository
     */
    StudentAttendanceService(StudentAttendanceRepository studentAttendanceRepository, AcademicYearService academicYearService) {
        this.studentAttendanceRepository = studentAttendanceRepository;
        this.academicYearService = academicYearService;
    }
    
    /**
     * Find an individual studentAttendance using the studentAttendances ID fields
     *
     * @param id the ID fields to search for
     * @return the StudentAttendance object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    StudentAttendance findByStudentIdAndCourseId(Integer studentId, Integer courseId) {
        return studentAttendanceRepository.findByStudentIdAndCourseId(studentId, courseId)
    }
    
    @Transactional(readOnly = true)
    StudentAttendance searchByYearStudentIdAndCourseId(AcademicYear academicYear, Integer studentId, Integer courseId, Date startDate, Date endDate) {
        return studentAttendanceRepository.findByAcademicYearStudentIdAndCourseIdForDateRange(academicYear, studentId, courseId, startDate, endDate)
    }
    
    /**
     * Find a single page of StudentAttendance objects
     * @return a SearchResult set with the list of StudentAttendances
     */
    @Transactional(readOnly = true)
    List<StudentAttendance> findAll() {
        return studentAttendanceRepository.findAll();
    }
}
