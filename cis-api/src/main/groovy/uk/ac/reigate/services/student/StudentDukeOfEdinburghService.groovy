package uk.ac.reigate.services.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentDukeOfEdinburgh
import uk.ac.reigate.dto.StudentDukeOfEdinburghDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.StudentDukeOfEdinburghRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService


@Service
class StudentDukeOfEdinburghService implements
ICoreDataService<StudentDukeOfEdinburgh, Integer>,
IDtoCreateUpdateService<StudentDukeOfEdinburghDto, StudentDukeOfEdinburgh> {
    
    @Autowired
    StudentDukeOfEdinburghRepository studentDukeOfEdinburghRepository
    
    @Autowired
    private final StudentService studentService;
    
    /**
     * Default No Args constructor
     */
    StudentDukeOfEdinburghService() {}
    
    StudentDukeOfEdinburghService(StudentDukeOfEdinburghRepository studentDukeOfEdinburghRepository, StudentService studentService) {
        super();
        this.studentDukeOfEdinburghRepository = studentDukeOfEdinburghRepository
        this.studentService = studentService
    }
    
    /**
     * This methods is used to retrieve an instance of a StudentCareerRecord as specified by the supplied id.
     * 
     * @param id the ID to use for the retrieval.
     * @return an instance of the StudentCareerRecord matching the supplied ID.
     */
    @Transactional(readOnly = true)
    StudentDukeOfEdinburgh findById(Integer id) {
        return studentDukeOfEdinburghRepository.findById(id).orElse(null)
    }
    
    /**
     * This method is used to retrieve all instances of StudentDukeOfEdinburgh.
     *
     * @return a List of all StudentDukeOfEdinburgh data objects.
     */
    @Transactional(readOnly = true)
    List<StudentDukeOfEdinburgh> findAll() {
        return studentDukeOfEdinburghRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete StudentDukeOfEdinburgh object in the database
     *
     * @param studentDukeOfEdinburgh the new StudentDukeOfEdinburgh object to be saved
     * @return the saved version of the StudentDukeOfEdinburgh object
     */
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasRole('Wellbeing')")
    @Override
    @Transactional
    public StudentDukeOfEdinburgh save(StudentDukeOfEdinburgh studentDukeOfEdinburgh) {
        return studentDukeOfEdinburghRepository.save(studentDukeOfEdinburgh)
    }
    
    /**
     * This method is used to delete a StudentDukeOfEdinburgh data object from the database
     *
     * @param studentDukeOfEdinburgh the StudentDukeOfEdinburgh object to be deleted
     *
     */
    @Override
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasAnyRole('Office Administration', 'Wellbeing')")
    public void delete(StudentDukeOfEdinburgh studentDukeOfEdinburgh) {
        throw new InvalidOperationException("StudentDukeOfEdinburgh should not be deleted")
    }
    
    /**
     * This Service method is used to create a new StudentLeaningSupport data object from the supplied StudentDukeOfEdinburghDto
     * @param StudentDukeOfEdinburghDto
     * @return
     */
    @Transactional
    public StudentDukeOfEdinburgh createFromDto(StudentDukeOfEdinburghDto studentDukeOfEdinburghDto) {
        if (studentDukeOfEdinburghDto == null) {
            throw new InvalidDataException("Cannot create studentDukeOfEdinburghDto from null object.")
        }
        StudentDukeOfEdinburgh studentDukeOfEdinburgh = new StudentDukeOfEdinburgh()
        if(studentDukeOfEdinburghDto.studentId != null) {
            studentDukeOfEdinburgh.student = studentService.findById(studentDukeOfEdinburghDto.studentId)
        }
        studentDukeOfEdinburgh.startDate = studentDukeOfEdinburghDto.startDate
        studentDukeOfEdinburgh.endDate = studentDukeOfEdinburghDto.endDate
        studentDukeOfEdinburgh.hours = studentDukeOfEdinburghDto.hours
        studentDukeOfEdinburgh.note = studentDukeOfEdinburghDto.note
        studentDukeOfEdinburgh.voluntaryOrganisation = studentDukeOfEdinburghDto.voluntaryOrganisation
        return save(studentDukeOfEdinburgh)
    }
    
    /**
     * This Service method is used to create a new StudentLeaningSupport data object from the supplied StudentDukeOfEdinburghDto
     * @param StudentDukeOfEdinburghDto
     * @return
     */
    @Transactional
    public StudentDukeOfEdinburgh updateFromDto(StudentDukeOfEdinburghDto studentDukeOfEdinburghDto) {
        if (studentDukeOfEdinburghDto == null) {
            throw new InvalidDataException("Cannot update studentDukeOfEdinburghDto from null object.")
        }
        StudentDukeOfEdinburgh studentDukeOfEdinburgh = findById(studentDukeOfEdinburghDto.id)
        if(studentDukeOfEdinburghDto.studentId != null) {
            studentDukeOfEdinburgh.student = studentService.findById(studentDukeOfEdinburghDto.studentId)
        }
        studentDukeOfEdinburgh.startDate = studentDukeOfEdinburghDto.startDate
        studentDukeOfEdinburgh.endDate = studentDukeOfEdinburghDto.endDate
        studentDukeOfEdinburgh.hours = studentDukeOfEdinburghDto.hours
        studentDukeOfEdinburgh.note = studentDukeOfEdinburghDto.note
        studentDukeOfEdinburgh.voluntaryOrganisation = studentDukeOfEdinburghDto.voluntaryOrganisation
        return save(studentDukeOfEdinburgh)
    }
    
    /**
     * This method is used to retrieve a List of StudentCareerRecord data objects for the supplied student.
     * 
     * @param student the Student data object to use for the data retrieval. 
     * @return a List of StudentCareerRecord data objects.
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<StudentDukeOfEdinburgh> findByStudent(Student student){
        List<StudentDukeOfEdinburgh> students = studentDukeOfEdinburghRepository.findByStudent_Id(student.id)
        return students
    }
    
    /**
     * This method is used to retrieve a List of StudentCareerRecord data objects for the supplied studentId.
     * 
     * @param studentId the ID for the student to retrieve the StudentCareerRecord data objects.
     * @return a List of StudentCareerRecord data objects.
     */
    @Transactional(readOnly = true)
    List<StudentDukeOfEdinburgh> findByStudentId(Integer studentId) {
        return studentDukeOfEdinburghRepository.findByStudent_Id(studentId);
    }
    
    /**
     * This method is used to delete a StudentCareerRecord by the ID supplied.
     * 
     * @param studentDukeOfEdinburghId the ID for the StudentCareerRecord data object to delete.
     */
    @Transactional
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasAnyRole('Office Administration', 'Wellbeing')")
    public void deleteById(Integer studentDukeOfEdinburghId){
        studentDukeOfEdinburghRepository.deleteById(studentDukeOfEdinburghId)
    }
}
