package uk.ac.reigate.domain.academic

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.PrimaryKeyJoinColumn
import javax.persistence.Table


@Entity
@Table(name = "[GCSEScores]", schema = "Data")
class GCSEScore implements Serializable {
    
    @Id
    @Column(name="student_id")
    int studentId;
    
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name="student_id", referencedColumnName="student_id")
    Student student
    
    @Column(name="COUNTOFQUALIFICATIONS")
    Integer countOfQualifications
    
    @Column(name="COUNTOFGCSES")
    Integer countOfGCSEs
    
    @Column(name = "Passes")
    Integer passes
    
    @Column(name="`PASSESA-C`")
    Integer passesAToC
    
    @Column(name="score")
    Double score
    
    @Column(name="average", columnDefinition = "numeric")
    Double average
}
