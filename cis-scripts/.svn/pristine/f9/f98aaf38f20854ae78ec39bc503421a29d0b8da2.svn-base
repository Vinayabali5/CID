package uk.ac.reigate.services.schoolimport

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.academic.StudentYearPk
import uk.ac.reigate.domain.ilr.Destination
import uk.ac.reigate.domain.lookup.AttendanceMonitoring
import uk.ac.reigate.domain.lookup.PunctualityMonitoring
import uk.ac.reigate.domain.lookup.TutorGroup
import uk.ac.reigate.model.SearchResult
import uk.ac.reigate.repositories.academic.StudentYearRepository

@Service
class StudentYearService {
    
    @Autowired
    StudentTypeService studentTypeService
    
    @Autowired
    TutorGroupService tutorGroupService
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    StudentService studentService
    
    @Autowired
    StudentYearRepository studentYearRepository
    
    /**
     * Default NoArgs constructor
     */
    StudentYearService() {}
    
    /**
     * Autowired constructor
     * 
     * @param studentYearRepository
     */
    StudentYearService(StudentYearRepository studentYearRepository) {
        this.studentYearRepository = studentYearRepository
    }
    
	@Transactional(readOnly = true)
	List<StudentYear> findByTutorGroupAndYear(Integer tutorGroupId, AcademicYear year){
		List<StudentYear> studentYears = studentYearRepository.findByTutorGroup_IdAndYear(tutorGroupId, year)
		return studentYears
	}
	
	@Transactional(readOnly = true)
	List<StudentYear> findByTutorGroup(Integer tutorGroupId){
		List<StudentYear> output = studentYearRepository.findByTutorGroup_Id(tutorGroupId)
		return output
	}
    /**
     * This service is used to retrieve a specified student year for the given Student and Year
     * @param student
     * @param year
     * @return
     */
    @Transactional(readOnly = true)
    StudentYear findByStudentAndYear(Student student, AcademicYear year){
        return studentYearRepository.findOne(new StudentYearPk(student, year))
    }
    
    /**
     * This service method is used to retrieve a specified student year for the given studentId and yearId
     * 
     * @param studentId the studentId to retrieve data for
     * @param yearId the yearId to retrieve data for
     * @return a StudentYear object that matches the studentId and yearId or null if no record found
     */
    @Transactional(readOnly = true)
    StudentYear findByStudentAndYear(Integer studentId, Integer yearId){
        return studentYearRepository.findByStudent_IdAndYear_Id(studentId, yearId)
    }
    //
    
    /**
     * This service is used to retrieve a list of StudentYears objects for the given Student
     * @param student
     * @param year
     * @return
     */
    @Transactional(readOnly = true)
    List<StudentYear> findByStudent(Student student){
        List<StudentYear> studentYears = studentYearRepository.findByStudent(student)
        return studentYears
    }
    
    /**
     * This service method is used to retrieve all instances of the StudentYear object from the database.
     * 
     * @return A List of StudentYear objects
     */
    @Transactional(readOnly = true)
    SearchResult<StudentYear> findStudentYears() {
        List<StudentYear> studentYears = studentYearRepository.findAll();
        int resultsCount = studentYears.size()
        return new SearchResult<>(resultsCount, studentYears);
    }
    
    /**
     * This service method is used to save a complete instance of a StudentYear object to the database.
     * 
     * @param studentYear a complete StudentYear object to persist to the database 
     * @return the saved version of the StudentYear object 
     */
    public StudentYear saveStudentYear(StudentYear studentYear) {
        return studentYearRepository.save(studentYear)
    }
    
    /**
     * This service method is used to save a list of complete StudentYear objects to the database. 
     * 
     * @param studentYears a list of StudentYear objects to persist to the database
     * @return the saved version of the list of StudentYear objects
     */
    @Transactional
    public List<StudentYear> saveStudentYears(List<StudentYear> studentYears) {
        return studentYears.collect { studentYear -> saveStudentYear( studentYear ) };
    }
    
    /**
     * This method is used to udpate the student type of a specified student and year combination
     *  
     * @param studentId The ID for the student to update
     * @param yearId The ID for the year to update
     * @param typeId The ID for the new student type
     * @return
     */
    StudentYear updateStudentType(Integer studentId, Integer yearId, Integer typeId) {
        StudentYear studentYear = studentYearRepository.findByStudentAndYear(studentService.findStudent(studentId), academicYearService.findAcademicYear(yearId));
        if (studentYear != null) {
            studentYear.type = typeId != null ? studentTypeService.findStudentType(typeId) : null;
            return saveStudentYear(studentYear);
        } else {
            throw new Exception('Could not locate the student/year combination');
        }
    }
    
    /**
     * This method is used to udpate the tutor group of a specified student and year combination
     *
     * @param studentId The ID for the student to update
     * @param yearId The ID for the year to update
     * @param tutorGroupId The ID for the new tutor group
     * @return
     */
    StudentYear updateTutorGroup(Integer studentId, Integer yearId, Integer tutorGroupId) {
        StudentYear studentYear = findByStudentAndYear(studentId, yearId);
        if (studentYear != null) {
            TutorGroup newTutorGroup = tutorGroupService.findTutorGroup(tutorGroupId);
            studentYear.tutorGroup = newTutorGroup;
            return saveStudentYear(studentYear);
        } else {
            throw new Exception('Could not locate the student/year combination');
        }
    }
    
}
