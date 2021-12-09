package uk.ac.reigate.domain.exams.seatingplan

import groovy.transform.EqualsAndHashCode

import java.text.SimpleDateFormat

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import com.fasterxml.jackson.annotation.JsonFormat

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity



@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "exam_session_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
@Table(name = "exam_session", schema = "Exams")
class ExamSession extends BaseEntity {
    
    @Column(name = "date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date date
    
    @Column(name = "session", length = 1)
    String session
    
    /*
     * Constructors:
     */
    public ExamSession() {}
    
    public ExamSession(Integer id, Date date, String session) {
        this.id = id;
        this.date = date;
        this.session = session;
    }
    
    @Override
    public String toString() {
        return "ExamSession [id=" + String.valueOf(id) + ", date=" + dateToString(date) + ", session=" + session + "]";
    }
    
    private String dateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (date != null)
            dateFormat.format(date);
    }
}
