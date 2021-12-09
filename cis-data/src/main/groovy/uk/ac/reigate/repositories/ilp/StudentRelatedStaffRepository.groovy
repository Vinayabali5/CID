package uk.ac.reigate.repositories.ilp

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.ilp.StudentRelatedStaff
import uk.ac.reigate.domain.ilp.StudentRelatedStaffPk

interface StudentRelatedStaffRepository extends CrudRepository<StudentRelatedStaff, StudentRelatedStaffPk> {
    
    StudentRelatedStaff findByStudent(Student student)
    
    List<StudentRelatedStaff> findByStudent_Id(Integer studentId)
    
    //    @Query(nativeQuery = true,value = "SELECT DISTINCT student_id, StaffId, StaffInitials, StaffName, '' AS relationship FROM ILP.StudentRelatedStaff WHERE student_id = :studentId")
    //    List<StudentRelatedStaff> findDistinctStaffIdByStudent_Id(@Param("studentId") Integer studentId)
    
    @Query(nativeQuery = true,value = "SELECT DISTINCT student_id, StaffId, StaffInitials, StaffName, string_agg([Relationship], ', ') AS relationship FROM ILP.StudentRelatedStaff WHERE student_id = :studentId GROUP BY student_id, StaffId, StaffInitials, StaffName" )
    List<StudentRelatedStaff> findDistinctStaffIdByStudent_Id(@Param("studentId") Integer studentId)
    
    List<StudentRelatedStaff> findDistinctStaffByStudent_Id(@Param("studentId") Integer studentId)
}
