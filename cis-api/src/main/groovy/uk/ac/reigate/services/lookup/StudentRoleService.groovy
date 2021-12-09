package uk.ac.reigate.services.lookup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.StudentRole
import uk.ac.reigate.dto.lookup.StudentRoleDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.StudentRoleRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class StudentRoleService implements ICoreDataService<StudentRole, Integer>, IDtoCreateUpdateService<StudentRoleDto, StudentRole>{
    
    @Autowired
    StudentRoleRepository studentRoleRepository
    
    /**
     * Default NoArgs constructor
     */
    StudentRoleService() {}
    
    /**
     * Autowired Constructor
     *
     * @param studentRoleRepository
     */
    StudentRoleService(StudentRoleRepository studentRoleRepository) {
        this.studentRoleRepository = studentRoleRepository;
    }
    
    /**
     * Find an individual studentRole using the studentRoles ID fields
     *
     * @param id the ID fields to search for
     * @return the StudentRole object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    StudentRole findById(Integer id) {
        return studentRoleRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all studentRoles
     *
     * @return a SearchResult set with the list of StudentRoles
     */
    @Override
    @Transactional(readOnly = true)
    List<StudentRole> findAll() {
        return studentRoleRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete StudentRole object in the database
     *
     * @param studentRole the new StudentRole object to be saved
     * @return the saved version of the StudentRole object
     */
    @Override
    @Transactional
    public StudentRole save(StudentRole studentRole) {
        return studentRoleRepository.save(studentRole)
    }
    
    /**
     * Saves a list of StudentRole objects to the database
     *
     * @param studentRoles a list of StudentRoles to be saved to the database
     * @return the list of save StudentRole objects
     */
    @Transactional
    public List<StudentRole> saveStudentRoles(List<StudentRole> studentRoles) {
        return studentRoles.collect { studentRole -> save(studentRole) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. StudentRole should not be deleted.
     */
    @Override
    public void delete(StudentRole obj) {
        throw new InvalidOperationException("StudentRole should not be deleted");
    }
    
    /**
     * This service method is used to create an StudentRole object in the database from a partial or complete StudentRole object.
     *
     * @param studentRole the partial or complete StudentRole object to be saved
     * @return the saved version of the StudentRole object
     */
    @Transactional
    public StudentRole createFromDto(StudentRoleDto studentRoleDto) {
        if (studentRoleDto == null) {
            throw new InvalidDataException("Cannot create studentRole from null object.")
        }
        StudentRole studentRole = new StudentRole()
        studentRole.code = studentRoleDto.code
        studentRole.description = studentRoleDto.description
        return save(studentRole)
    }
    
    /**
     * This service method is used to update an StudentRole object in the database from a partial or complete StudentRole object.
     *
     * @param studentRole the partial or complete StudentRole object to be saved
     * @return the saved version of the StudentRole object
     */
    @Transactional
    public StudentRole updateFromDto(StudentRoleDto studentRoleDto) {
        if (studentRoleDto == null) {
            throw new InvalidDataException("Cannot update studentRole from null object.")
        }
        StudentRole studentRole = findById(studentRoleDto.id);
        studentRole.code = studentRoleDto.code
        studentRole.description = studentRoleDto.description
        return save(studentRole)
    }
}
