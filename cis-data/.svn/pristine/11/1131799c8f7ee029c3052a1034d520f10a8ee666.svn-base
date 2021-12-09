package uk.ac.reigate.repositories.learning_support

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentCourseConcession

interface StudentCourseConcessionRepository extends CrudRepository<StudentCourseConcession, Integer> {
    
    List<StudentCourseConcession> findByStudent(Student student)
    
    List<StudentCourseConcession> findByStudentId(Integer studentId)
    
    List<StudentCourseConcession> findByStudentAndCourse(Student student, Course course)
    
    List<StudentCourseConcession> findByStudentIdAndCourseId(Integer studentId, Integer courseId)
}
