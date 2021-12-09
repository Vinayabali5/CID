package uk.ac.reigate.domain.exams.basedata

import groovy.transform.EqualsAndHashCode

import javax.persistence.Embeddable

@Embeddable
@EqualsAndHashCode
class OptionComponentPk implements Serializable {
    
    Integer examOption;
    
    Integer examComponent;
    
    public OptionComponentPk() {}
    
    public OptionComponentPk(Integer examOptionId, Integer examComponentId) {
        super();
        this.examOption = examOptionId;
        this.examComponent = examComponentId;
    }
    
    public OptionComponentPk(ExamOption examOption, ExamComponent examComponent) {
        super();
        this.examOption = examOption.id;
        this.examComponent = examComponent.id;
    }
    
    public OptionComponentPk(OptionComponent optionComponent) {
        super();
        this.examOption = optionComponent.examOption.id;
        this.examComponent = optionComponent.examComponent.id;
    }
}
