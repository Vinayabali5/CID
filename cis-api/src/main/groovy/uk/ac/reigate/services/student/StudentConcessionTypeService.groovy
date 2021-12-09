package uk.ac.reigate.services.student

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.ConcessionType
import uk.ac.reigate.domain.learning_support.StudentConcessionType
import uk.ac.reigate.domain.learning_support.StudentConcessionTypePk
import uk.ac.reigate.domain.learning_support.StudentCourseConcession
import uk.ac.reigate.dto.StudentConcessionTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.learning_support.StudentConcessionTypeRepository;
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.lookup.ConcessionTypeService

@Service
class StudentConcessionTypeService implements ICoreDataService<StudentConcessionType, StudentConcessionTypePk>{
    
    @Autowired
    StudentConcessionTypeRepository studentConcessionTypeRepository
    
    @Autowired
    ConcessionTypeService concessionTypeService;
    
    @Autowired
    StudentService studentService;
    
    StudentConcessionTypeService() {}
    
    StudentConcessionTypeService(StudentConcessionTypeRepository studentConcessionTypeRepository) {
        this.studentConcessionTypeRepository = studentConcessionTypeRepository;
    }
    /**
     * This service method is used to retrieve the list of studentConcessionType by studentId
     *
     * @param studentId
     * @return
     */
    public List<StudentConcessionType> getByStudent(Integer studentId){
        return studentConcessionTypeRepository.findByStudent_Id(studentId)
    }
    
    /**
     * This service method is used to save the studentConcessionType
     *
     * @param studentConcessionType
     * @return
     */
    @Override
    @Transactional
    public StudentConcessionType save(StudentConcessionType studentConcessionType) {
        return studentConcessionTypeRepository.save(studentConcessionType)
    }
    
    public StudentConcessionType createFromDto(StudentConcessionTypeDto dto) {
        if (dto == null) {
            throw new InvalidDataException("Cannot create StudentConcessionType from null object.")
        }
        StudentConcessionType concession = new StudentConcessionType()
        if(dto.studentId != null) {
            concession.student = studentService.findById(dto.studentId)
        }
        if(dto.concessionTypeId != null) {
            concession.concessionType = concessionTypeService.findById(dto.concessionTypeId)
        }
        concession.extraTimePercentage = dto.extraTimePercentage
        return save(concession)
    }
    /**
     * This method is used to delete the studentConcessionType by studentId and ConcessionId
     *
     * @param studentId 
     * @param concessionTypeId
     * @return
     */
    public void deleteById(Integer studentId, Integer concessionTypeId){
        studentConcessionTypeRepository.deleteById(new StudentConcessionTypePk(studentId, concessionTypeId));
    }
    
    /**
     * @param student
     * @param concessionType
     * @return
     */
    public Boolean  deleteByStudentAndConcessionType(Student student, ConcessionType concessionType){
        return deleteById(student.id, concessionType.id);
    }
    
    
    /**
     * Find all StudentConcessionType
     *
     * @return a List of StudentConcessionType
     */
    @Override
    public List<StudentConcessionType> findAll() {
        return studentConcessionTypeRepository.findAll()
    }
    
    /**
     * Deletes StudentConcessionType object
     * 
     */
    @Override
    public void delete(StudentConcessionType studentConcessionType) {
        studentConcessionTypeRepository.delete(new StudentConcessionTypePk(studentConcessionType))
    }
    
    @Override
    public StudentConcessionType findById(StudentConcessionTypePk studentConcessionTypePk) {
        return studentConcessionTypeRepository.findById(studentConcessionTypePk).orElse(null)
    }
}
