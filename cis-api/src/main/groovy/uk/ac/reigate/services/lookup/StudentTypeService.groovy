package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.StudentType
import uk.ac.reigate.dto.lookup.StudentTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.StudentTypeRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class StudentTypeService implements ICoreDataService<StudentType, Integer>, IDtoCreateUpdateService<StudentTypeDto, StudentType>{
    
    @Autowired
    StudentTypeRepository studentTypeRepository
    
    /**
     * Default NoArgs constructor
     */
    StudentTypeService() {}
    
    /**
     * Autowired Constructor
     *
     * @param studentTypeRepository
     */
    StudentTypeService(StudentTypeRepository studentTypeRepository) {
        this.studentTypeRepository = studentTypeRepository;
    }
    
    /**
     * Find an individual studentType using the studentTypes ID fields
     *
     * @param id the ID fields to search for
     * @return the StudentType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    StudentType findById(Integer id) {
        return studentTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of StudentType objects
     * @return a List of StudentTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<StudentType> findAll() {
        return studentTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete StudentType object in the database
     *
     * @param studentType the new StudentType object to be saved
     * @return the saved version of the StudentType object
     */
    @Override
    @Transactional
    public StudentType save(StudentType studentType) {
        return studentTypeRepository.save(studentType)
    }
    
    /**
     * This service method is used to update an StudentType object in the database from a partial or complete StudentType object.
     *
     * @param studentType the partial or complete StudentType object to be saved
     * @return the saved version of the StudentType object
     */
    @Transactional
    public StudentType createFromDto(StudentTypeDto studentTypeDto) {
        if (studentTypeDto == null) {
            throw new InvalidDataException("Cannot create studentType from null object.")
        }
        StudentType studentType = new StudentType()
        studentType.id = studentTypeDto.id
        studentType.code = studentTypeDto.code
        studentType.description = studentTypeDto.description
        return save(studentType)
    }
    
    /**
     * This service method is used to update an StudentType object in the database from a partial or complete StudentType object.
     *
     * @param studentType the partial or complete StudentType object to be saved
     * @return the saved version of the StudentType object
     */
    @Transactional
    public StudentType updateFromDto(StudentTypeDto studentTypeDto) {
        if (studentTypeDto == null) {
            throw new InvalidDataException("Cannot update studentType from null object.")
        }
        StudentType studentType = findById(studentTypeDto.id)
        studentType.code = studentTypeDto.code
        studentType.description = studentTypeDto.description
        return save(studentType)
    }
    
    /**
     * Saves a list of StudentType objects to the database
     *
     * @param studentTypes a list of StudentTypes to be saved to the database
     * @return the list of save StudentType objects
     */
    @Transactional
    public List<StudentType> saveStudentTypes(List<StudentType> studentTypes) {
        return studentTypes.collect { studentType -> save(studentType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. StudentType should not be deleted.
     */
    @Override
    public void delete(StudentType obj) {
        throw new InvalidOperationException("StudentType should not be deleted")
    }
}
