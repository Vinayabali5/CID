package uk.ac.reigate.repositories.academic

import org.springframework.data.jpa.repository.Query
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student

interface CourseRepository extends PagingAndSortingRepository<Course, Integer>, QuerydslPredicateExecutor<Course> {
    
    List <Course> findByValidFrom(AcademicYear validFrom);
    
    @Query("SELECT c FROM Course c WHERE validFrom.id <= :yearId AND (validTo.id IS NULL OR validTo.id >= :yearId)")
    List<Course> findCourseValidOnYear(@Param(value = "yearId") Integer yearId)
    
    @Query("SELECT c FROM Course c WHERE spec LIKE '%' + :spec + '%' AND validFrom.id <= :yearId AND (validTo.id IS NULL OR validTo.id >= :yearId)")
    List<Course> findCoursesBySpecAndCourseValidOnYear(@Param(value = "spec") String spec, @Param(value = "yearId") Integer yearId)
    
    @Query("SELECT c FROM Course c WHERE \
			(spec LIKE '%' + :search + '%' OR level.description LIKE '%' + :search + '%' OR subject.description LIKE '%' + :search + '%') AND \
			validFrom.id <= :yearId AND (validTo.id IS NULL OR validTo.id >= :yearId)")
    List<Course> findCoursesBySpecOrDescriptionAndCourseValidOnYear(@Param(value = "search") String search, @Param(value = "yearId") Integer yearId)
    
    List<Course> findByValidFromAndSpecLike(AcademicYear validFrom, String spec)
    
    @Query("SELECT c from Course c WHERE validFrom.id>= :yearId")
    List<Course> findCourseByvalidFrom(@Param(value="yearId") Integer yearId)
    
    @Query("SELECT c from Course c WHERE id = :courseId AND validFrom.id <= :yearId AND (validTo.id IS NULL OR validTo.id >= :yearId)")
    Course findCourseByIDAndValidFrom(@Param(value = "courseId") Integer courseId , @Param(value ="yearId") Integer yearId)
    
    @Query("SELECT c from Course c WHERE spec = :courseSpec AND validFrom.id <= :yearId AND (validTo.id IS NULL OR validTo.id >= :yearId)")
    List<Course> findByCourseSpec( Integer yearId, String courseSpec)
    
    @Query("SELECT c FROM Course c INNER JOIN c.courseGroups cg INNER JOIN cg.enrolments e WHERE e.student = :student")
    List<Course> findByStudent(@Param(value = "student") Student student)
}
