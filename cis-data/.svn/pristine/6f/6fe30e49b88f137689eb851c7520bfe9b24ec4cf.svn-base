package uk.ac.reigate.repositories.ilp

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.ilp.ILPInterview

/**
 * This repository is used to manage the ILP Interview data objects.
 * 
 * @author Michael Horgan
 * @author Vinaya Bali
 *
 */
interface ILPInterviewRepository extends CrudRepository<ILPInterview, Integer> {
    
    List<ILPInterview> findByStudent_Id(Integer studentId)
    
    List<ILPInterview> findByCourseGroup_Id(Integer courseGroupId)
    
    @Query("SELECT i FROM ILPInterview i where i.courseGroup.course.id =:courseId AND i.academicYear = :academicYear")
    List<ILPInterview> findByCourseGroup_IdAndAcademicYear(@Param(value = "courseId")Integer courseId, @Param(value = "academicYear")AcademicYear academicYear)
    
    List<ILPInterview> findByStudent(Student student)
    
    @Query("select s from ILPInterview s where student.id = :studentId and (s.type.id <> 10 or s.staff.id = :staffId)")
    List<ILPInterview> findByStudent_IdAndStaff_Id(@Param(value= "studentId")Integer studentId, @Param(value= "staffId")Integer staffId)
    
    List<ILPInterview> findByStudent_IdAndPrivateEntry(Integer studentId, Boolean privateEntry)
    
    ILPInterview findByStudent_IdAndId(Integer studentId, Integer Id)
    
    /**
     * This method is used to retrieve all ILP Interviews for the supplied student where the entry is 
     * not a safeguarding entry (typeId = 10) and is not marked as a privateEntry.
     *      
     * @param studentId the ID for the student 
     * @return a List of ILPInterviews for the given student
     */
    @Query("SELECT i FROM ILPInterview i WHERE i.student.id = :studentId AND i.type.id <> 10 AND i.privateEntry = false")
    List<ILPInterview> findByStudent_NonSensitive(@Param(value= "studentId") Integer studentId)
    
    /**
     * This method is used to retrieve all ILP Interviews for the supplied student where the entry is 
     * not a safeguarding entry (typeId = 10) and is marked as a privateEntry.
     *      
     * @param studentId the ID for the student 
     * @return a List of ILPInterviews for the given student
     */
    @Query("SELECT i FROM ILPInterview i WHERE i.student.id = :studentId AND i.type.id <> 10 AND i.privateEntry = true")
    List<ILPInterview> findByStudent_Sensitive(@Param(value= "studentId") Integer studentId)
    
    /**
     * This method is used to retrieve all safeguarding ILP Interviews for the supplied student.
     *  
     * @param studentId the ID for the student
     * @return a List of ILPInterviews for the given student
     */
    @Query("SELECT i FROM ILPInterview i WHERE i.student.id = :studentId AND i.type.id = 10")
    List<ILPInterview> findByStudent_Safeguarding(@Param(value= "studentId") Integer studentId)
    
    /**
     * This method is used to retrieve all admissions ILP Interviews for the supplied student.
     *  
     * @param studentId the ID for the student
     * @return a List of ILPInterviews for the given student
     */
    @Query("SELECT i FROM ILPInterview i WHERE i.student.id = :studentId AND i.type.id = 14")
    List<ILPInterview> findByStudent_Admissions(@Param(value= "studentId") Integer studentId)
    
    /**
     * This method is used to retrieve all Teaching Guidance ILP Interviews for the supplied student.
     *  
     * @param studentId the ID for the student
     * @return a List of ILPInterviews for the given student
     */
    @Query("SELECT i FROM ILPInterview i WHERE i.student.id = :studentId AND i.type.id = 13")
    List<ILPInterview> findByStudent_TeachingGuidance(@Param(value= "studentId") Integer studentId)
    
    /**
     * This method is used to retrieve all admissions ILP Interviews for the supplied student.
     *  
     * @param studentId the ID for the student
     * @return a List of ILPInterviews for the given student
     */
    @Query("SELECT i FROM ILPInterview i WHERE i.student.id = :studentId AND i.type.id = 15")
    List<ILPInterview> findByStudent_Enrolment(@Param(value= "studentId") Integer studentId)
    
    /**
     * This method is used to retrieve all ILP Interviews for the supplied student where the entry was
     * created by the supplied member of staff.
     * 
     * @param studentId the ID for the student
     * @param staffId the ID for the member of staff 
     * @return a List of ILPInterviews for the given student
     */
    @Query("SELECT i FROM ILPInterview i WHERE i.student.id = :studentId AND i.staff.id = :staffId")
    List<ILPInterview> findByStudentAndStaff(@Param(value= "studentId") Integer studentId, @Param(value= "staffId") Integer staffId)
}

