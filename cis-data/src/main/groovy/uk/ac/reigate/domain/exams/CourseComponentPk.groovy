package uk.ac.reigate.domain.exams

import groovy.transform.EqualsAndHashCode

import javax.persistence.Embeddable

import uk.ac.reigate.domain.academic.Course;;;;
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamOption

@Embeddable
@EqualsAndHashCode
class CourseComponentPk implements Serializable {
    
    Integer course;
    
    Integer examOption;
    
    Integer examComponent;
    
    public CourseComponentPk() {}
    
    public CourseComponentPk(Integer courseId, Integer examOptionId, Integer examComponentId) {
        super();
        this.course = courseId;
        this.examOption = examOptionId;
        this.examComponent = examComponentId;
    }
    
    public CourseComponentPk(Course course, ExamOption examOption, ExamComponent examComponent) {
        super();
        this.course = course.id;
        this.examOption = examOption.id;
        this.examComponent = examComponent.id;
    }
    
    public CourseComponentPk(CourseComponent courseComponent) {
        super();
        this.course = courseComponent.course.id
        this.examOption = courseComponent.examOption.id
        this.examComponent = courseComponent.examComponent.id;
    }
}
