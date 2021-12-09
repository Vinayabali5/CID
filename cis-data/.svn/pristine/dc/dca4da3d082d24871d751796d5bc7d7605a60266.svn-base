package uk.ac.reigate.repositories.academic

import org.springframework.data.jpa.repository.Query
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student


interface StudentRepository extends PagingAndSortingRepository<Student, Integer>, QuerydslPredicateExecutor<Student> {
    
    Student findByIdAndStudentYears_Year(Integer id, AcademicYear year)
    
    Student findOneByReferenceNo(String referenceNo)
    
    Student findByReferenceNo(String referenceNo)
    
    Student findByPerson(Person person)
    
    List<Student> findByReferenceNoContainingIgnoreCase(String referenceNo)
    
    List<Student> findByReferenceNoContainingIgnoreCaseAndStudentYears_Year(String referenceNo, AcademicYear year)
    
    List<Student> findByPersonIn(Collection<Person> person)
    
    List<Student> findByPersonInAndStudentYears_Year(Collection<Person> person, AcademicYear year)
    
    Integer countByAcademicYear(AcademicYear year)
    
    //    List<Student> findByStudentYears_Year_IdAndTutorGroup_Id(Integer academicYearId, Integer tutorGroupId)
    //
    //    List<Student> findByAcademicYear_IdAndTutorGroup_Id(Integer academicYearId, Integer tutorGroupId)
    
    List<Student> findByPerson_SurnameAndPerson_Dob(String surname, Date dob)
    
    @Query(
    value = "SELECT * FROM [dbo].[student] INNER JOIN [dbo].[student_year] ON [student_year].[student_id] = [student].[student_id] WHERE [end_date] IS NULL AND [student_year].[academic_year_id] = [dbo].[GetCurrentAcademicYearId]()",
    nativeQuery = true
    )
    List<Student> findCurrent()
    
    List<Student> findAllByStudentYears_Year(AcademicYear year)
}

