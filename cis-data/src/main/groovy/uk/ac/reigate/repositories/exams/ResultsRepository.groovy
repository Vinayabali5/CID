package uk.ac.reigate.repositories.exams

import org.springframework.data.repository.PagingAndSortingRepository
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.Results

interface ResultsRepository extends PagingAndSortingRepository<Results,Integer>{
    
    List<Results> findByStudent_Id(Integer studentId)
}
