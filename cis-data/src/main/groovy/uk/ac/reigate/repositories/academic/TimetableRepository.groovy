package uk.ac.reigate.repositories.academic

import org.springframework.data.jpa.repository.Query
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Timetable

interface TimetableRepository extends CrudRepository<Timetable, Integer>, QuerydslPredicateExecutor<Timetable> {
    
    List<Timetable> findByCourseGroup_YearAndTeacher(AcademicYear year, Staff staff)
    
    List<Timetable> findByCourseGroup_Year_IdAndCourseGroup_Id(Integer yearId, Integer courseGroupId)
    
    List<Timetable> findByCourseGroup_Id(Integer courseGroupId)
    
    @Query("SELECT t FROM Timetable t JOIN t.courseGroup as cg  WHERE cg.year = :year AND t.teacher = :staff AND GETDATE() BETWEEN t.validFrom AND t.validTo")
    List<Timetable> findByYearAndTeacherCurrent(@Param(value="year") AcademicYear year, @Param(value="staff") Staff staff)
    
    @Query("SELECT t FROM Timetable t JOIN t.courseGroup as cg  WHERE cg.year = :year AND t.teacher = :staff AND :date BETWEEN t.validFrom AND t.validTo")
    List<Timetable> findByYearAndTeacherOnDate(@Param(value="year") AcademicYear year, @Param(value="staff") Staff staff, @Param(value="date") Date date)
}
