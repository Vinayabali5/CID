package uk.ac.reigate.repositories.lookup


import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.lookup.TutorGroup

interface TutorGroupRepository extends PagingAndSortingRepository<TutorGroup, Integer> {
    
    TutorGroup findByCode(String code)
    
    List<TutorGroup> findByInUse(Boolean inUse)
    
    List<TutorGroup> findByTutorAndInUseIsTrue(Staff seniorTutor)
    
    List<TutorGroup> findBySeniorTutorAndInUseIsTrue(Staff seniorTutor)
    
    List<TutorGroup> findByFaculty_HofAndInUseIsTrue(Staff hof)
    
    List<TutorGroup> findByFaculty_DolAndInUseIsTrue(Staff hof)
    
    List<TutorGroup> findByFaculty_AdolAndInUseIsTrue(Staff hof)
    
    List<TutorGroup> findByFaculty_PdAndInUseIsTrue(Staff hof)
    
    List<TutorGroup> findByFaculty_ApdAndInUseIsTrue(Staff hof)
}

