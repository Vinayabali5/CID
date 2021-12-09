package uk.ac.reigate.repositories.academic

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Faculty

interface FacultyRepository extends CrudRepository<Faculty, Integer> {
    
    Faculty findByCode(String code)
    
    List<Faculty> findByHof(Staff hof)
    
    List<Faculty> findByDol(Staff dol)
    
    List<Faculty> findByAdol(Staff adol)
    
    List<Faculty> findByPd(Staff pd)
    
    List<Faculty> findByApd(Staff apd)
}
