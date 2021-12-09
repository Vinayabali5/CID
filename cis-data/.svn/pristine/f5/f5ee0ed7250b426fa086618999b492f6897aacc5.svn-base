package uk.ac.reigate.repositories.lookup

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.lookup.StudentRemarkPermission

interface StudentRemarkPermissionRepository extends PagingAndSortingRepository<StudentRemarkPermission, Integer> {
    
    List<StudentRemarkPermission> findAll()
    
    StudentRemarkPermission findByCode(String code)
}
