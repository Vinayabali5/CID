package uk.ac.reigate.dto.learningsupport

import com.fasterxml.jackson.annotation.JsonProperty

import uk.ac.reigate.domain.learning_support.StudentCourseConcession
import uk.ac.reigate.dto.CourseSummaryDto
import uk.ac.reigate.dto.lookup.ConcessionTypeDto

class StudentCourseConcessionDto {
    
    @JsonProperty
    private Integer studentCourseConcessionId;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer courseId;
    
    @JsonProperty
    private CourseSummaryDto course
    
    @JsonProperty
    private Integer concessionTypeId;
    
    @JsonProperty
    private ConcessionTypeDto concessionType;
    
    @JsonProperty
    private Integer extraTimePercentage;
    
    /**
     * Default NoArgs constructor.
     */
    public StudentCourseConcessionDto() {}
    
    /**
     * Constructor to create a StudentCourseConcessionDto object from a StudentCourseConcession object
     *
     * @param studentCourseConcession the StudentCourseConcession object to use for construction
     */
    public StudentCourseConcessionDto(StudentCourseConcession studentCourseConcession) {
        if(studentCourseConcession != null) {
            this.studentCourseConcessionId = studentCourseConcession.id
            this.studentId = studentCourseConcession.student != null ? studentCourseConcession.student.id : null
            this.courseId = studentCourseConcession.course != null ? studentCourseConcession.course.id : null
            this.course = studentCourseConcession.course != null ? new CourseSummaryDto(studentCourseConcession.course) : null
            this.concessionTypeId = studentCourseConcession.concessionType != null ?studentCourseConcession.concessionType.id : null
            this.concessionType = ConcessionTypeDto.mapFromEntity(studentCourseConcession.concessionType)
            this.extraTimePercentage = studentCourseConcession.extraTimePercentage
        }
    }
    
    /**
     * This static method is used to create a StudentCourseConcessionDto from a StudentCourseConcession data object.
     *
     * @param studentCourseConcession the StudentCourseConcession data object to use for the creation.
     * @return a StudentCourseConcessionDto object based on the StudentCourseConcession data object supplied.
     */
    public static StudentCourseConcessionDto mapFromEntity(StudentCourseConcession studentCourseConcession) {
        return new StudentCourseConcessionDto(studentCourseConcession);
    }
    
    /**
     * This static method is used to create a List of StudentCourseConcessionDto from a List of StudentCourseConcession data object.
     *
     * @param studentCourseConcessions the List of StudentCourseConcession data object to use for the creation.
     * @return a List of StudentCourseConcessionDto object based on the List of StudentCourseConcession data object supplied.
     */
    public static List<StudentCourseConcessionDto> mapFromList(List<StudentCourseConcession> studentCourseConcessions) {
        return studentCourseConcessions.collect { studentCourseConcession ->  new StudentCourseConcessionDto(studentCourseConcession) };
    }
    
    /**
     * This method is used to return the Concession Code for the StudentCourseConcession object
     *
     * @return the Concession Code for the StudentCourseConcession object
     */
    @JsonProperty(value = "_concessionCode")
    public String get_ConcessionCode() {
        return this.concessionType != null  ? this.concessionType.code : null
    }
    
    /**
     * This method is used to return the Concession Description for the StudentCourseConcession object
     *
     * @return the Concession Description for the StudentCourseConcession object
     */
    @JsonProperty(value = "_concessionDescription")
    public String get_ConcessionDescription() {
        return this.concessionType != null  ? this.concessionType.description : null
    }
}
