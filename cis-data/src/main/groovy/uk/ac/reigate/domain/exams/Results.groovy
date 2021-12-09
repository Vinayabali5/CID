package uk.ac.reigate.domain.exams

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.basedata.ExamOption


@Entity
@Table(name="results", schema = "Exams")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "results_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
class Results extends BaseEntity implements Serializable{
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "board_identifier",referencedColumnName = 'board_identifier')
    private ExamBoard examBoard;
    
    @Column(name = 'exam_series')
    String examSeries;
    
    @Column(name = 'exam_year')
    String examYear
    
    @Column(name ='edi_file')
    String ediFile
    
    @Column(name= 'candidate_no')
    Integer candidateNo
    
    @Column(name='uln')
    String uln
    
    @Column(name='uci')
    String uci
    
    @Column(name ='entry_code')
    String entryCode
    
    @Column(name = 'results_code')
    String resultsCode
    
    @Column(name ='results_type')
    String resultsType
    
    @Column(name='score')
    String score
    
    @Column(name='grade')
    String grade
    
    @Column(name='endorsement_to_first_grade')
    String endorsementToFirstGrade
    
    @Column(name='endorsement_to_second_grade')
    String endorsementToSecondGrade
    
    @Column(name='first_grade_partial_absence')
    String firstGradePartialAbsence
    
    @Column(name='second_grade_partial_absence')
    String secondGradePartialAbsence
    
    @Column(name='endorsement_to_first_grade_partial_absence')
    String endorsementToFirstGradePartialAbsence
    
    @Column(name='endorsement_to_second_grade_partial_absence')
    String endorsementToSecondGradePartialAbsence
    
    @OneToOne
    @JoinColumn(name='student_id',referencedColumnName = "student_id")
    Student student
    
    @OneToOne
    @JoinColumn(name='academic_year_id')
    AcademicYear academicYear
    
    @OneToOne
    @JoinColumn(name='exam_option_id')
    ExamOption examOption
    
    @Column(name='notes')
    String notes
    
    @Column(name ='course_id')
    Integer courseId
    
    @Column(name = 'import_date')
    Date importDate
    
    @Column(name = 'exam_date')
    Date examDate
    
    public Results(){}
}
