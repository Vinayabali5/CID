package uk.ac.reigate.repositories

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.Person

interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {
    
    List<Person> findBySurname(String surname)
    
    List<Person> findBySurnameContainingIgnoreCase(String name)
    
    List<Person> findByFirstNameContainingIgnoreCase(String name)
    
    List<Person> findByMiddleNamesContainingIgnoreCase(String name)
    
    List<Person> findByPreferredNameContainingIgnoreCase(String name)
    
    List<Person> findByPreviousSurnameIgnoreCase(String surname)
    
    List<Person> findByPreviousSurnameContainingIgnoreCase(String name)
    
    List<Person> findBySurnameAndDob(String surname, Date dob)
    
    Person findByUsername(String username)
    
    Person findByRfidCardId(byte[] rfidCardId)
    
    @Query("SELECT p FROM Person p WHERE rfidCardID = :id")
    Person findByRfidCardIdByQuery(@Param(value = 'id') String rfidCardId)
    
    @Query(nativeQuery = true, value = "SELECT * FROM [dbo].[person] AS [p] INNER JOIN [dbo].[person_role] AS [pr] ON [pr].[person_id] = [p].[person_id] where pr.person_id = :personId")
    List<Person> findByPerson(@Param(value = "personId") Integer personId)
}
