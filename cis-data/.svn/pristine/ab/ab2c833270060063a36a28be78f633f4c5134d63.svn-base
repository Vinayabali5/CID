package uk.ac.reigate.domain.exams

import groovy.transform.EqualsAndHashCode

import javax.persistence.Embeddable

import uk.ac.reigate.domain.academic.Course;;;;
import uk.ac.reigate.domain.exams.basedata.ExamOption

@Embeddable
@EqualsAndHashCode
class CourseOptionPk implements Serializable {
    
    Integer course;
    
    Integer examOption;
    
    public CourseOptionPk() {}
    
    public CourseOptionPk(Integer courseId, Integer examOptionId) {
        super();
        this.course = courseId;
        this.examOption = examOptionId;
    }
    
    public CourseOptionPk(Course course, ExamOption examOption) {
        super();
        this.course = course.id;
        this.examOption = examOption.id;
    }
    
    public CourseOptionPk(CourseOption courseOption) {
        this.course = courseOption.course.id;
        this.examOption = courseOption.examOption.id;
    }
}
