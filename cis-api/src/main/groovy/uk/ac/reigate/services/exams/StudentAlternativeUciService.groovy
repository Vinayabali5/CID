package uk.ac.reigate.services.exams

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service

import uk.ac.reigate.domain.exams.StudentAlternativeUci
import uk.ac.reigate.domain.exams.StudentAlternativeUciPk
import uk.ac.reigate.dto.exams.StudentAlternativeUciDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.exams.StudentAlternativeUciRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.student.StudentService

@Service
class StudentAlternativeUciService implements ICoreDataService<StudentAlternativeUci,StudentAlternativeUciPk>{
    
    @Autowired
    StudentAlternativeUciRepository studentAlternativeUciRepository
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    ExamBoardService examBoardService;
    
    StudentAlternativeUciService(){}
    
    StudentAlternativeUciService(StudentAlternativeUciRepository studentAlternativeUciRepository, StudentService studentService, ExamBoardService examBoardService){
        this.studentAlternativeUciRepository = studentAlternativeUciRepository
        this.studentService = studentService
        this.examBoardService = examBoardService
    }
    /**
     * This method is used to retrive the list of StudentAlternativeUci by studentId
     * @param studentId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<StudentAlternativeUci> getByStudent(Integer studentId){
        return studentAlternativeUciRepository.findByStudent_Id(studentId)
    }
    
    /** Returns a individual StudentAlternativeUci 
     * @param studentId
     * @param examBoardId
     * @return 
     */
    public StudentAlternativeUci getByStudentAndExamBoardId(Integer studentId, Integer examBoardId){
        return findById(new StudentAlternativeUciPk(studentId, examBoardId))
    }
    
    /**
     * This method is used to save the studentAlternativeUci object to the database.
     */
    @Override
    public StudentAlternativeUci save(StudentAlternativeUci studentAlternativeUci){
        return studentAlternativeUciRepository.save(studentAlternativeUci)
    }
    
    /** Deletes an instance of StudentAlterntativeUci of a particular studentId and examBoardId
     * @param studentId
     * @param examBoardId
     * @return
     */
    public boolean deleteAltenativeUci(Integer studentId,Integer examBoardId){
        StudentAlternativeUci studentAlternativeUci = getByStudentAndExamBoardId(studentId, examBoardId)
        delete(studentAlternativeUci);
    }
    
    /**
     * This method is used to create the studentAlternativeUci object to the database.
     */
    public StudentAlternativeUci createFromDto(StudentAlternativeUciDto studentAlternativeUciDto) {
        if(studentAlternativeUciDto == null) {
            throw new InvalidDataException("Cannot create studentAlternativeUciDto from null object.")
        }
        if(studentAlternativeUciDto.studentId == null && studentAlternativeUciDto.examBoardId) {
            throw new InvalidDataException("Cannot create studentAlternativeUciDto from null studentId and ExamBoardId.")
        }
        StudentAlternativeUci studentAlternativeUci = new StudentAlternativeUci()
        studentAlternativeUci.student = studentService.findById(studentAlternativeUciDto.studentId)
        studentAlternativeUci.examBoard = examBoardService.findById(studentAlternativeUciDto.examBoardId)
        studentAlternativeUci.alternativeUci = studentAlternativeUciDto.alternativeUci
        return save(studentAlternativeUci)
    }
    
    /**
     * This method is used to update the studentAlternativeUci object to the database.
     */
    public StudentAlternativeUci updateFromDto(StudentAlternativeUciDto studentAlternativeUciDto) {
        if(studentAlternativeUciDto == null) {
            throw new InvalidDataException("Cannot update studentAlternativeUciDto from null object.")
        }
        StudentAlternativeUci studentAlternativeUci = getByStudentAndExamBoardId(studentAlternativeUciDto.studentId, studentAlternativeUciDto.examBoardId)
        studentAlternativeUci.student = studentService.findById(studentAlternativeUciDto.studentId)
        studentAlternativeUci.examBoard = examBoardService.findById(studentAlternativeUciDto.examBoardId)
        studentAlternativeUci.alternativeUci = studentAlternativeUciDto.alternativeUci
        return save(studentAlternativeUci)
    }
    
    /**
     * This method is used to the retrieve the StudentAlternativeUci by studentAlternativeUciPk
     */
    @Override
    public StudentAlternativeUci findById(StudentAlternativeUciPk studentAlternativeUciPk) {
        return studentAlternativeUciRepository.findById(studentAlternativeUciPk).orElse(null)
    }
    
    /**
     * This method is used to retrieve the list of the StudentAlternativeUci.
     */
    @Override
    public List<StudentAlternativeUci> findAll() {
        return studentAlternativeUciRepository.findAll();
    }
    
    /**
     * This method is used to delete the studentAlternativeUci object from the database.
     */
    public Boolean deleteByIds(Integer studentId, Integer examBoardId) {
        StudentAlternativeUci studentAlternativeUci = studentAlternativeUciRepository.findByStudent_IdAndExamBoard_Id(studentId, examBoardId)
        if(studentAlternativeUci != null) {
            delete(studentAlternativeUci)
            return true;
        }
        return false;
    }
    
    /**
     * This method is used to delete the StudentAlternativeUci from the database.
     */
    @Override
    public void delete(StudentAlternativeUci studentAlternativeUci) {
        studentAlternativeUciRepository.delete(studentAlternativeUci)
    }
}
