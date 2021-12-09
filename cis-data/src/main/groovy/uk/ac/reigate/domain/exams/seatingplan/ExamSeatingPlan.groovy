package uk.ac.reigate.domain.exams.seatingplan

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne;
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity;
import uk.ac.reigate.domain.Room;;;;;



@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "exam_seating_plan_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
@Table(name = "exam_seating_plan", schema = "Exams")
class ExamSeatingPlan extends BaseEntity {
    
    @OneToOne
    @JoinColumn(name = "exam_session_id")
    ExamSession examSession
    
    @OneToOne
    @JoinColumn(name = "room_id")
    Room room
    
    @Column(name="rows")
    Integer rows
    
    @Column(name="cols")
    Integer cols
    
    ExamSeatingPlan(){}
    
    ExamSeatingPlan(Integer id, ExamSession examSession, Room room, Integer rows, Integer cols) {
        this.id = id;
        this.examSession = examSession;
        this.room = room;
        this.rows = rows;
        this.cols = cols;
    }
    
    ExamSeatingPlan(ExamSession examSession, Room room, Integer rows, Integer cols) {
        this(null, examSession, room, rows, cols);
    }
    
    @Override
    public String toString() {
        return "ExamSeatingPlan [id: " + String.valueOf(this.id) + ", examSession: " + examSession + ", room: " + room + ", rows: " + rows + ", cols: " + cols + "]";
    }
}
