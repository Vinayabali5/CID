package uk.ac.reigate.domain.exams

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.NamedEntityNoIdentity
import uk.ac.reigate.domain.exams.basedata.ExamSeries

@Entity
@Table(name = "exam_board", schema = "Exams")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "exam_board_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class ExamBoard extends NamedEntityNoIdentity {
    
    /**
     * The text representation of the Boards internally used code
     */
    @Column(name = "board_code")
    String boardCode
    
    /**
     * The text representation of the provdier's centre number for the exam board
     */
    @Column(name = "board_centre_number", unique = true)
    String boardCentreNumber
    
    /**
     * The text representation of the Boards externally used identifier
     */
    @Column(name = "board_identifier")
    String boardIdentifier
    
    /**
     * The text representation of the Boards contact telephone number
     */
    @Column(name = "telephone_no")
    String telephoneNo
    
    @OneToMany(mappedBy = "examBoard")
    List<ExamSeries> examSeries
    
    /**
     * Default noArgs constructor
     */
    ExamBoard(){}
    
    /**
     * The toString function for the ExamBoard object returns the name as specified.
     */
    @Override
    public String toString() {
        return name
    }
}
