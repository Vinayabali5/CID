package uk.ac.reigate.repositories

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.lookup.StaffType

interface StaffRepository extends PagingAndSortingRepository<Staff, Integer>, QuerydslPredicateExecutor<Staff> {
    
    Staff findByPerson(Person person)
    
    List<Staff> findByEndDateIsNull()
    
    @Query("select s from Staff s where s.endDate is null AND s.type.needInitials = True")
    List<Staff> findAllCurrent()
    
    @Query("select s from Staff s where s.endDate is null AND s.type.needInitials = True")
    Page<Staff> findAllCurrent(Pageable page)
    
    List<Staff> findByType_NeedInitialsTrue()
    
    List<Staff> findByTypeIn(List<StaffType> staffTypes)
    
    @Query("select distinct s from Timetable t inner join t.teacher s where t.courseGroup = :courseGroup")
    List<Staff> findTeacherByCourseGroup(@Param("courseGroup") CourseGroup courseGroup)
}
