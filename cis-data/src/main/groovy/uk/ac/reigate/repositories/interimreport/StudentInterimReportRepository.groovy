package uk.ac.reigate.repositories.interimreport

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.interimreport.InterimReport
import uk.ac.reigate.domain.interimreport.StudentInterimReport


interface StudentInterimReportRepository extends CrudRepository<StudentInterimReport, Integer> {
    
    List<StudentInterimReport> findByCourse(Course course)
    
    List<StudentInterimReport> findByCourse_Id(Integer courseId)
    
    List<StudentInterimReport> findByCourseGroup(CourseGroup courseGroup)
    
    List<StudentInterimReport> findByCourseGroup_Id(Integer courseGroupId)
    
    List<StudentInterimReport> findByCourseGroupAndInterimReport(CourseGroup courseGroup, InterimReport interimReport)
    
    List<StudentInterimReport> findByCourseGroup_IdAndInterimReport_Id(Integer courseGroupId, Integer interimReportId)
    
    List<StudentInterimReport> findByStudent(Student student)
    
    List<StudentInterimReport> findByStudent_Id(Integer studentId)
    
    List<StudentInterimReport> findByStudent_IdAndInterimReport_Year_Id(Integer studentId, Integer yearId)
    
    List<StudentInterimReport> findByStudent_IdAndInterimReport_Id(Integer studentId, Integer interimReportId)
    
    List<StudentInterimReport> findByStudentAndCourseAndInterimReport(Student student, Course course, InterimReport interimReport)
    
    List<StudentInterimReport> findByStudent_IdAndCourse_IdAndInterimReport_Id(Integer studentId, Integer courseId, Integer interimReportId)
    
    StudentInterimReport findByStudentAndCourseGroupAndInterimReport(Student student, CourseGroup courseGroup, InterimReport interimReport)
    
    StudentInterimReport findByStudent_IdAndCourseGroup_IdAndInterimReport_Id(Integer studentId, Integer courseGroupId, Integer interimReportId)
}