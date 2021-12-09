package uk.ac.reigate.dto.exams

import groovy.transform.EqualsAndHashCode

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.Course;
import uk.ac.reigate.domain.exams.CourseSyllabus
import uk.ac.reigate.domain.exams.basedata.Syllabus

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class CourseSyllabusDto implements Serializable {
    
    @JsonProperty
    private Integer courseId;
    
    @JsonProperty
    private Integer syllabusId;
    
    /**
     * Default No Args constructor
     */
    CourseSyllabusDto() {}
    
    /**
     * Constructor to create a CourseSyllabus object
     *
     * @param courseId
     * @param syllabusId
     */
    CourseSyllabusDto(Course course, Syllabus syllabus) {
        this.courseId = course.id;
        this.syllabusId = syllabus.id;
    }
    
    /**
     * Constructor to create a CourseSyllabus object
     * 
     * @param courseId
     * @param syllabusId
     */
    CourseSyllabusDto(CourseSyllabus courseSyllabus) {
        this.courseId = courseSyllabus.course.id;
        this.syllabusId = courseSyllabus.syllabus.id;
    }
    
    /**
     * This static method is used to create a CourseSyllabusDto from a CourseSyllabus data object.
     *
     * @param courseSyllabus the CourseSyllabus data object to use for the creation.
     * @return a CourseSyllabusDto object based on the CourseSyllabus data object supplied.
     */
    public static CourseSyllabusDto mapFromEntity(CourseSyllabus courseSyllabus) {
        return new CourseSyllabusDto(courseSyllabus);
    }
    
    /**
     * This static method is used to create a List of CourseSyllabusDto from a List of CourseSyllabus data object.
     *
     * @param courseSyllabuss the List of CourseSyllabus data object to use for the creation.
     * @return a List of CourseSyllabusDto object based on the List of CourseSyllabus data object supplied.
     */
    public static List<CourseSyllabusDto> mapFromList(List<CourseSyllabus> courseSyllabusList) {
        return courseSyllabusList.collect { courseSyllabus -> new CourseSyllabusDto(courseSyllabus) } ;
    }
}
