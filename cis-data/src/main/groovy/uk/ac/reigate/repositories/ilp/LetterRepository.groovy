package uk.ac.reigate.repositories.ilp

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.ilp.Letter


interface LetterRepository extends CrudRepository<Letter, Integer> {
    
    /**
     * Used to find all Letter data object for the supplied student 
     * 
     * @param student a student
     * @return a List of Letter data objects
     */
    List<Letter> findByStudent(Student student)
    
    /**
     * Used to find all Letter data object for the supplied student ID
     *
     * @param studentId a student ID
     * @return a List of Letter data objects
     */
    List<Letter> findByStudent_Id(Integer studentId)
    
    List<Letter> findByYear(AcademicYear year)
    
    List<Letter> findByYearAndProcessingFlag(AcademicYear year, Integer processingFlag)
    
    List<Letter> findByYearAndRequestedDateIsNotNullAndAuthorisedDateIsNull(AcademicYear year)
    
    List<Letter> findByYearAndRequestedDateIsNotNullAndAuthorisedDateIsNotNull(AcademicYear year)
    
    List<Letter> findByYearAndRequestedDateIsNotNullAndAuthorisedDateIsNullAndProcessingFlagIs(AcademicYear year, Integer processingFlag)
    
    List<Letter> findByYearAndRequestedDateIsNotNullAndAuthorisedDateIsNotNullAndProcessingFlagIs(AcademicYear year, Integer processingFlag)
    
    List<Letter> findByYearAndRequestedDateIsNotNullAndAuthorisedDateIsNotNullAndLetterDateIsNullAndPrintedDateIsNull(AcademicYear year)
    
    List<Letter> findByYearAndRequestedDateIsNotNullAndAuthorisedDateIsNotNullAndLetterDateIsNullAndPrintedDateIsNullAndProcessingFlagIs(AcademicYear year, Integer processingFlag)
}
