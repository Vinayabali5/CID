package uk.ac.reigate.services.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.StudentRemarkPermission
import uk.ac.reigate.dto.StudentRemarkPermissionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.StudentRemarkPermissionRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class StudentRemarkPermissionService implements ICoreDataService<StudentRemarkPermission, Integer>, IDtoCreateUpdateService<StudentRemarkPermissionDto, StudentRemarkPermission>{
    
    @Autowired
    StudentRemarkPermissionRepository studentRemarkPermissionRepository
    
    /**
     * Default NoArgs constructor
     */
    StudentRemarkPermissionService() {}
    
    /**
     * Autowired Constructor
     *
     * @param studentRemarkPermissionRepository
     */
    StudentRemarkPermissionService(StudentRemarkPermissionRepository studentRemarkPermissionRepository) {
        this.studentRemarkPermissionRepository = studentRemarkPermissionRepository;
    }
    
    /**
     * Find an individual studentRemarkPermission using the studentRemarkPermissions ID fields
     *
     * @param id the ID fields to search for
     * @return the StudentRemarkPermission object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    StudentRemarkPermission findById(Integer id) {
        return studentRemarkPermissionRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all studentRemarkPermissions
     *
     * @return a SearchResult set with the list of StudentRemarkPermissions
     */
    @Override
    @Transactional(readOnly = true)
    List<StudentRemarkPermission> findAll() {
        return studentRemarkPermissionRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete StudentRemarkPermission object in the database
     *
     * @param studentRemarkPermission the new StudentRemarkPermission object to be saved
     * @return the saved version of the StudentRemarkPermission object
     */
    @Override
    @Transactional
    public StudentRemarkPermission save(StudentRemarkPermission studentRemarkPermission) {
        return studentRemarkPermissionRepository.save(studentRemarkPermission)
    }
    
    /**
     * This service method is used to update an StudentRemarkPermission object in the database from a partial or complete StudentRemarkPermission object.
     *
     * @param studentRemarkPermission the partial or complete StudentRemarkPermission object to be saved
     * @return the saved version of the StudentRemarkPermission object
     */
    @Transactional
    public StudentRemarkPermission createFromDto(StudentRemarkPermissionDto studentRemarkPermissionDto) {
        if (studentRemarkPermissionDto == null) {
            throw new InvalidDataException("Cannot create studentRemarkPermission from null object.")
        }
        StudentRemarkPermission studentRemarkPermission = new StudentRemarkPermission()
        studentRemarkPermission.id = studentRemarkPermissionDto.id
        studentRemarkPermission.code = studentRemarkPermissionDto.code
        studentRemarkPermission.description = studentRemarkPermissionDto.description
        return save(studentRemarkPermission)
    }
    
    /**
     * This service method is used to update an StudentRemarkPermission object in the database from a partial or complete StudentRemarkPermission object.
     *
     * @param studentRemarkPermission the partial or complete StudentRemarkPermission object to be saved
     * @return the saved version of the StudentRemarkPermission object
     */
    @Transactional
    public StudentRemarkPermission updateFromDto(StudentRemarkPermissionDto studentRemarkPermissionDto) {
        if (studentRemarkPermissionDto == null) {
            throw new InvalidDataException("Cannot update studentRemarkPermission from null object.")
        }
        StudentRemarkPermission studentRemarkPermission = findById(studentRemarkPermissionDto.id);
        studentRemarkPermission.code = studentRemarkPermissionDto.code
        studentRemarkPermission.description = studentRemarkPermissionDto.description
        return save(studentRemarkPermission)
    }
    
    /**
     * Saves a list of StudentRemarkPermission objects to the database
     *
     * @param studentRemarkPermissions a list of StudentRemarkPermissions to be saved to the database
     * @return the list of save StudentRemarkPermission objects
     */
    @Transactional
    public List<StudentRemarkPermission> saveStudentRemarkPermissions(List<StudentRemarkPermission> studentRemarkPermissions) {
        return studentRemarkPermissions.collect { studentRemarkPermission -> save(studentRemarkPermission) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. StudentRemarkPermission should not be deleted.
     */
    @Override
    public void delete(StudentRemarkPermission obj) {
        throw new InvalidOperationException("StudentRemarkPermission should not be deleted")
    }
}
