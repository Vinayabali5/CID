package uk.ac.reigate.repositories.search

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student

interface StudentSearchRepository extends PagingAndSortingRepository<Student, Integer> {
    
    List<Student> findByAcademicYearAndPerson_SurnameLikeAndPerson_FirstNameLikeAndReferenceNoLike(AcademicYear academicYear, String surname, String firstName, String reference)
    
    /**
     * This method is used to search for a list of students based on their first name or their surname
     * 
     * @param searchTerm the name to search for
     * @return a list for matching students
     */
    @Query(value = "SELECT s FROM Student s WHERE s.person.surname LIKE %:searchTerm% OR s.person.firstName LIKE %:searchTerm%")
    List<Student> searchByName(@Param("searchTerm") String searchTerm)
    
    /**
     * This method is used to find a list of students where they have an entry in the student years table that matches the supplied academicYear plus 
     * the other supplied criteria (surname, firstName and reference)
     * 
     * @param academicYear an AcademicYear object to search for
     * @param surname the surname of the student's to find
     * @param firstName the first name of the student's to find
     * @param reference the reference of the student's to find
     * @return a list of matching students
     */
    List<Student> findByStudentYears_YearAndPerson_SurnameLikeAndPerson_FirstNameLikeAndReferenceNoLike(AcademicYear academicYear, String surname, String firstName, String reference)
    
    @Query(value = "SELECT s FROM Student s JOIN s.studentYears sy WHERE sy.year = :year AND s.person.surname LIKE %:surname% AND (s.person.firstName LIKE %:firstName%  OR s.person.preferredName LIKE %:preferredName%) AND s.referenceNo LIKE %:referenceNo%")
    List<Student> findByStudentYears_YearAndPerson_SurnameLikeAndPerson_FirstNameLikeOrPerson_PreferredNameLikeAndReferenceNoLike(@Param(value = "year")AcademicYear year, @Param(value = "surname")String surname, @Param(value = "firstName")String firstName, @Param(value = "preferredName")String preferredName, @Param(value = "referenceNo")String referenceNo)
    
    List<Student> findByStudentYears_YearAndStudentYears_CandidateNo(@Param(value = "year")AcademicYear year, @Param(value = "candidateNo")Integer candidateNo)
    
    @Query(value = "SELECT s FROM Student s JOIN s.studentYears sy WHERE sy.year = :year AND (s.person.surname LIKE %:surname% OR s.person.previousSurname LIKE %:surname%) AND (s.person.firstName LIKE %:name%  OR s.person.preferredName LIKE %:name%) AND s.referenceNo LIKE %:referenceNo%")
    List<Student> searchStudent(@Param(value = "year")AcademicYear year, @Param(value = "surname")String surname, @Param(value = "name")String name, @Param(value = "referenceNo")String referenceNo)
}
