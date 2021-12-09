package uk.ac.reigate.services.schoolimport

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.StudentRemarkPermission
import uk.ac.reigate.model.SearchResult
import uk.ac.reigate.repositories.academic.StudentRepository
import uk.ac.reigate.repositories.learning_support.StudentConcessionTypeRepository

@Service
class StudentService {
    
    @Autowired
    StudentRepository studentRepository
    
    @Autowired
    StudentYearService studentYearService
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    StudentTypeService studentTypeService
    
    @Autowired
    TutorGroupService tutorGroupService
    
    /**
     * Default NoArgs constructor
     */
    StudentService() {}
    
    /**
     * Autowired constructor
     * 
     * @param studentRepository
     */
    StudentService(StudentRepository studentRepository, StudentConcessionTypeRepository studentConcessionTypeRepository) {
        this.studentRepository = studentRepository
    }
    
    /**
     * This service method is used to retrieve an individual Student object from the database.
     * 
     * @param id the id of the member of student to retrieve
     * @return the Student object identified by the id
     */
    @Transactional(readOnly = true)
    Student findStudent(Integer id) {
        return studentRepository.findOne(id);
    }
    
	@Transactional(readOnly = true)
	SearchResult<Student> findTutors(Integer tutorGroupId) {
		List<Student> tutors = studentRepository.findByTutorGroupId(tutorGroupId);
		int resultsCount = tutors.size()
        return new SearchResult<>(resultsCount, tutors);
	}
    /**
     * This service method is used to retrieve all instances of the Student object from the database.
     * 
     * @return A List of Student objects
     */
    @Transactional(readOnly = true)
    SearchResult<Student> findStudents() {
        List<Student> students = studentRepository.findAll();
        int resultsCount = students.size()
        return new SearchResult<>(resultsCount, students);
    }
    
    /**
     * This service method is used to save a complete instance of a Student object to the database.
     * 
     * @param student a complete Student object to persist to the database 
     * @return the saved version of the Student object 
     */
    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student)
    }
    
    /**
     * This service method is used to save a list of complete Student objects to the database. 
     * 
     * @param students a list of Student objects to persist to the database
     * @return the saved version of the list of Student objects
     */
    @Transactional
    public List<Student> saveStudents(List<Student> students) {
        return students.collect { student -> saveStudent( student ) };
    }
    
    /**
     * This service method is used to retrieve an individual Student object from the database.
     *
     * @param id the id of the member of student to retrieve
     * @return the Student object identified by the id
     */
    @Transactional(readOnly = true)
    List<Student> findCurrentStudents() {
        return studentRepository.findCurrent();
    }
    
    List<Student> findStudentsInYear(AcademicYear year) {
        List<Student> students = studentRepository.findAllByStudentYears_Year();
        return students;
    }
    
  
	/**
	 * This method is design to update a single students remark permission 
	 * 
	 * @param student
	 * @param remarkPermission
	 * @return
	 */
	Student updateStudentRemarkPermission(Student student, StudentRemarkPermission remarkPermission) {
		Student s = findStudent(student.id);
		s.studentRemarkPermission = remarkPermission;
		Student output = saveStudent(s);
	}
	
	
	

	
}
