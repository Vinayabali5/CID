package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Department
import uk.ac.reigate.domain.academic.Faculty

interface DepartmentRepository extends CrudRepository<Department, Integer> {
    
    Department findByName(String name)
    
    List<Department> findByFaculty(Faculty faculty)
    
    List<Department> findByFaculty_Id(Integer facultyId)
    
    List<Department> findByHodOrHod2(Staff hod, Staff hod2)
}
