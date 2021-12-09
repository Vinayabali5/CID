package uk.ac.reigate.repositories.academic

import java.util.List;

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.academic.StudentYearPk
import uk.ac.reigate.domain.learning_support.StudentSpecialCategory;

interface StudentYearRepository extends CrudRepository<StudentYear, StudentYearPk> {
    
    StudentYear findByStudentAndYear(Student student, AcademicYear academicYear)
    
    StudentYear findByStudent_IdAndYear_Id(Integer studentId, Integer academicYearId)
    
    StudentYear findByStudent_IdAndYear(Integer studentId, AcademicYear academicYear)
    
    List<StudentYear> findByStudent(Student student)
    
    //	List<StudentYear> findByStudent_Id(Integer studentId)
    
    StudentYear findByStudent_Id(Integer studentId)
    
    List<StudentYear> findByTutorGroup_IdAndYear(Integer tutorGroupId, AcademicYear academicYear)
    
    List<StudentYear> findByTutorGroup_IdAndYear_Id(Integer tutorGroupId, Integer academicYearId)
    
    List<StudentYear> findByTutorGroup_Id(Integer tutorGroupId)
}
