package uk.ac.reigate.repositories.exams


import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.StudentOptionEntry
import uk.ac.reigate.domain.exams.StudentOptionEntryPk
import uk.ac.reigate.domain.exams.basedata.ExamOption

interface StudentOptionEntryRepository extends CrudRepository<StudentOptionEntry, StudentOptionEntryPk> {
    
    StudentOptionEntry findByStudentAndExamOption(Student student, ExamOption examOption)
    
    StudentOptionEntry findByStudent_IdAndExamOption_Id(Integer studentId, Integer examOptionId)
    
    List<StudentOptionEntry> findByStudent_Id(Integer studentId)
    
    StudentOptionEntry findByStudent(Student student)
    
    List<StudentOptionEntry> findByExamOption_OptionComponents_ExamComponentId(Integer examComponentId)
    
    List<StudentOptionEntry> findByExamOption_OptionComponents_ExamComponentIdAndStatusType_Id(Integer examComponentId, Integer statusTypeId)
    
    @Query(value="SELECT c FROM StudentOptionEntry c WHERE c.examOption.syllabus.examSeries.academicYear.id = :academicYearId AND student.id = :studentId")
    List<StudentOptionEntry> findByOptionYearIdAndStudentId(@Param(value="academicYearId") Integer academicYearId, @Param(value="studentId") Integer studentId)
}
