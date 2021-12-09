package uk.ac.reigate.domain.exams.basedata

import groovy.transform.EqualsAndHashCode

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne
import javax.persistence.Table;;
import javax.validation.constraints.NotNull

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate


@Entity
@Table(name = "option_component", schema = "Exams")
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
@IdClass(OptionComponentPk.class)
class OptionComponent implements Serializable {
    
    @Id
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_option_id")
    ExamOption examOption
    
    @Id
    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_component_id")
    ExamComponent examComponent
    
    /**
     * Default No Args constructor
     */
    public OptionComponent() {
    }
    
    public OptionComponent(ExamOption examOption, ExamComponent examComponent) {
        this.examOption = examOption;
        this.examComponent = examComponent;
    }
}
