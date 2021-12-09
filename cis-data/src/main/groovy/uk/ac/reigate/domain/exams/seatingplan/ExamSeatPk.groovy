package uk.ac.reigate.domain.exams.seatingplan

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode

import javax.persistence.Embeddable
import uk.ac.reigate.domain.academic.Student


@Embeddable
@EqualsAndHashCode(includeFields=true)
//@Canonical
class ExamSeatPk implements Serializable {
    
    Integer examSeatingPlan
    
    Integer row
    
    Integer col
    
    /**
     * Default NoArgs constructor
     */
    ExamSeatPk() {}
    
    /**
     * A constructor that uses an ExamSeat to create the Primary Key object
     * @param examSeat
     */
    ExamSeatPk(ExamSeat examSeat) {
        examSeatingPlan = examSeat.examSeatingPlan.id;
        row = examSeat.row;
        col = examSeat.col;
    }
    
    
    /**
     * Default fields based constructor
     * 
     * @param student the studentId to use to create the object
     * @param option the academicYearId to use to create the object
     */
    ExamSeatPk(Integer examSeatingPlan, Integer row, Integer col) {
        super();
        this.examSeatingPlan = examSeatingPlan;
        this.row = row;
        this.col = col;
    }
    
    /**
     * Default fields based constructor
     * 
     * @param student the Student object to use to create the object
     * @param option the AcademicYear object to use to create the object
     */
    ExamSeatPk(ExamSeatingPlan examSeatingPlan, Integer row, Integer col) {
        super();
        this.examSeatingPlan = examSeatingPlan.id;
        this.row = row;
        this.col = col;
    }
}
