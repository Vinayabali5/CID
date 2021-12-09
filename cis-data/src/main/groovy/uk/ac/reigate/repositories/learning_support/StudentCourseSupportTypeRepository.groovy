package uk.ac.reigate.repositories.learning_support

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.learning_support.StudentCourseSupportType

interface StudentCourseSupportTypeRepository extends CrudRepository<StudentCourseSupportType, Integer> {
    
    List<StudentCourseSupportType> findByStudent(Student student)
    
    List<StudentCourseSupportType> findByStudentId(Integer studentId)
    
    List<StudentCourseSupportType> findByStudentAndCourse(Student student, Course course)
    
    List<StudentCourseSupportType> findByStudentIdAndCourseId(Integer studentId, Integer courseId)
}
