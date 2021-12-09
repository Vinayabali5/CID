package uk.ac.reigate.repositories.exams.seatingplan

import javax.transaction.Transactional

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.exams.seatingplan.ExamSeat
import uk.ac.reigate.domain.exams.seatingplan.ExamSeatPk

@Transactional
public interface ExamSeatRepository extends CrudRepository<ExamSeat, ExamSeatPk> {
    
    @Query(value = "SELECT s AS student,ec as examComponent,(SELECT es.examSeatingPlan FROM ExamSeat es WHERE (es.examComponent = ec.id AND es.student = s.id)) as examSeatingPlan, (SELECT es.row FROM ExamSeat es WHERE (es.examComponent = ec.id AND es.student = s.id)) as row, (SELECT es.col FROM ExamSeat es WHERE (es.examComponent = ec.id AND es.student = s.id)) as col FROM StudentOptionEntry soe INNER JOIN soe.examOption eo INNER JOIN eo.optionComponents oc INNER JOIN oc.examComponent ec INNER JOIN soe.student s WHERE soe.statusType.id = 1 AND ec.id = :examComponentId")
    List<ExamSeat> findByExamComponentId(@Param(value = "examComponentId") Integer examComponentId)
    
    ExamSeat findByStudent_IdAndExamComponent_Id(@Param(value = "studentId") Integer studentId, @Param(value = "examComponentId") Integer examComponentId)
}
