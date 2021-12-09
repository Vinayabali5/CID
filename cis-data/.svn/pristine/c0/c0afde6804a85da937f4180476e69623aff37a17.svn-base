package uk.ac.reigate.domain.exams.basedata

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType;
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

import com.fasterxml.jackson.annotation.JsonBackReference

import uk.ac.reigate.domain.BaseEntity
import uk.ac.reigate.domain.exams.CourseOption

@Entity
@Table(name = "exam_option", schema = "Exams")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "exam_option_id"))
])
class ExamOption extends BaseEntity implements Serializable {
    
    @Column(name = "option_entry_code", length = 6)
    private String optionEntryCode
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "syllabus_id")
    @JsonBackReference
    private Syllabus syllabus
    
    @Column(name = "exam_type_qualification_cert", length = 4)
    private String examTypeQualificationCert
    
    @Column(name = "exam_type_level_cert", length = 3)
    private String examTypeLevelCert
    
    @Column(name = "exam_type_item", length = 1)
    private String examTypeItem
    
    @Column(name = "exam_type_qualification_unit", length = 4)
    private String examTypeQualificationUnit
    
    @Column(name = "exam_type_level_unit", length = 3)
    private String examTypeLevelUnit
    
    @Column(name = "process", length = 1)
    private String process
    
    @Column(name = "qca_classification_code", length = 4)
    private String qcaClassificationCode
    
    @Column(name = "qca_accreditation_no", length = 8)
    private String qcaAccreditationNo
    
    @Column(name = "option_title", length = 36)
    private String optionTitle
    
    @Column(name = "fee_defined", length = 1)
    private String feeDefined
    
    @Column(name = "examination_fee")
    private Integer examinationFee
    
    @Column(name = "first_forecast_grade_gradeset", length = 4)
    private String firstForecastGradeGradeset
    
    @Column(name = "second_forecast_grade_gradeset", length = 4)
    private String secondForecastGradeGradeset
    
    @Column(name = "result_type", length = 1)
    private String resultType
    
    @Column(name = "first_grade_result_gradeset", length = 4)
    private String firstGradeResultGradeset
    
    @Column(name = "second_grade_result_gradeset", length = 4)
    private String secondGradeResultGradeset
    
    @Column(name = "endorsement_to_first_grade_result_gradeset", length = 4)
    private String endorsementToFirstGradeResultGradeset
    
    @Column(name = "endorsement_to_second_grade_result_gradeset", length = 4)
    private String endorsementToSecondGradeResultGradeset
    
    @Column(name = "max_mark_ums")
    private Integer maxMarkUms
    
    @Column(name = "no_of_components")
    private Integer noOfComponents
    
    @ManyToOne(cascade=[CascadeType.DETACH])
    @JoinColumn(name = "exam_type_cert", referencedColumnName = "exam_type_id")
    private ExamType examTypeCert
    
    @ManyToOne(cascade=[CascadeType.DETACH])
    @JoinColumn(name = "exam_type_unit", referencedColumnName = "exam_type_id")
    private ExamType examTypeUnit
    
    @OneToMany(mappedBy = "examOption")
    private List<OptionComponent> optionComponents
    
    @OneToMany(mappedBy = "examOption")
    List<CourseOption> courseOptions
    
    /**
     * Default noArgs constructor
     */
    public ExamOption() {}
    
    /**
     * The toString function for the ExamOption object returns the optionEntryCode as specified.
     */
    @Override
    public String toString() {
        return optionEntryCode
    }
}