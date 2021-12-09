package uk.ac.reigate.domain.exams

import groovy.transform.EqualsAndHashCode

import javax.persistence.Embeddable

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.exams.basedata.Syllabus

@Embeddable
@EqualsAndHashCode
class CourseSyllabusPk implements Serializable {
    
    Integer course;
    
    Integer syllabus;
    
    public CourseSyllabusPk() {}
    
    public CourseSyllabusPk(Integer courseId, Integer syllabusId) {
        super();
        this.course = courseId;
        this.syllabus = syllabusId;
    }
    
    public CourseSyllabusPk(Course course, Syllabus syllabus) {
        super();
        this.course = course.id;
        this.syllabus = syllabus.id;
    }
    
    public CourseSyllabusPk(CourseSyllabus courseSyllabus) {
        super();
        this.course = courseSyllabus.course.id;
        this.syllabus = courseSyllabus.syllabus.id;
    }
}
