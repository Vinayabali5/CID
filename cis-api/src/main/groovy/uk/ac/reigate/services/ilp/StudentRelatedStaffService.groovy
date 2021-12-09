package uk.ac.reigate.services.ilp

//import static org.springframework.util.Assert

import org.apache.poi.openxml4j.exceptions.InvalidOperationException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilp.StudentRelatedStaff
import uk.ac.reigate.repositories.ilp.StudentRelatedStaffRepository
import uk.ac.reigate.services.ICoreDataService


@Service
class StudentRelatedStaffService implements ICoreDataService<StudentRelatedStaff, Integer>{
    
    @Autowired
    StudentRelatedStaffRepository studentRelatedStaffRepository
    
    /**
     * Default NoArgs constructor
     */
    StudentRelatedStaffService() {}
    
    /**
     * Autowired Constructor
     *
     * @param studentRelatedStaffRepository
     */
    StudentRelatedStaffService(StudentRelatedStaffRepository studentRelatedStaffRepository) {
        this.studentRelatedStaffRepository = studentRelatedStaffRepository
    }
    
    /**
     * This is retrieving distinct StaffId using studentId
     *
     * @param id the ID fields to search for
     * @return the StudentRelatedStaff object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    List<StudentRelatedStaff> findByDistinctStaffByStudentId(Integer studentId) {
        return studentRelatedStaffRepository.findDistinctStaffIdByStudent_Id(studentId);
    }
    
    /**
     * Find an individual studentRelatedStaff using the studentRelatedStaffs ID fields
     *
     * @param id the ID fields to search for
     * @return the StudentRelatedStaff object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    List<StudentRelatedStaff> findByStudentId(Integer studentId) {
        return studentRelatedStaffRepository.findByStudent_Id(studentId);
    }
    
    /**
     * Find a single page of StudentRelatedStaff objects
     * @return a SearchResult set with the list of StudentRelatedStaffs
     */
    @Transactional(readOnly = true)
    List<StudentRelatedStaff> findAll() {
        return studentRelatedStaffRepository.findAll();
        
    }
    
    /* (non-Javadoc)
     * @see uk.ac.reigate.services.ICoreDataService#save(java.lang.Object)
     */
    @Override
    public StudentRelatedStaff save(StudentRelatedStaff obj) {
        return studentRelatedStaffRepository.save(obj)
    }
    
    @Override
    public StudentRelatedStaff findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void delete(StudentRelatedStaff obj) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
