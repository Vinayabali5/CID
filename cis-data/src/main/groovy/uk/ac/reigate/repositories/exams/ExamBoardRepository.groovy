package uk.ac.reigate.repositories.exams

import org.springframework.data.repository.PagingAndSortingRepository

import uk.ac.reigate.domain.exams.ExamBoard

interface ExamBoardRepository extends PagingAndSortingRepository<ExamBoard, Integer> {
    
    ExamBoard findByName(String name)
    
    ExamBoard findByBoardIdentifier(String boardIdentifier)
    
    List<ExamBoard> findByBoardCode(String boardCode)
}
