package uk.ac.reigate.dto.learningsupport

import com.fasterxml.jackson.annotation.JsonProperty

import uk.ac.reigate.domain.learning_support.StudentCourseSupportType
import uk.ac.reigate.dto.CourseSummaryDto
import uk.ac.reigate.dto.lookup.ConcessionTypeDto
import uk.ac.reigate.dto.lookup.SupportTypeDto

class StudentCourseSupportTypeDto {
    
    @JsonProperty
    private Integer studentCourseSupportTypeId;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer courseId;
    
    @JsonProperty
    private CourseSummaryDto course
    
    @JsonProperty
    private Integer supportTypeId;
    
    @JsonProperty
    private SupportTypeDto supportType;
    
    @JsonProperty
    private Date startDate;
    
    @JsonProperty
    private Date endDate;
    
    /**
     * Default NoArgs constructor.
     */
    public StudentCourseSupportTypeDto() {}
    
    /**
     * Constructor to create a StudentCourseSupportTypeDto object from a StudentCourseSupportType object
     *
     * @param studentCourseSupportType the StudentCourseSupportType object to use for construction
     */
    public StudentCourseSupportTypeDto(StudentCourseSupportType studentCourseSupportType) {
        if(studentCourseSupportType != null) {
            this.studentCourseSupportTypeId = studentCourseSupportType.id
            this.studentId = studentCourseSupportType.student != null ? studentCourseSupportType.student.id : null
            this.courseId = studentCourseSupportType.course != null ? studentCourseSupportType.course.id : null
            this.course = studentCourseSupportType.course != null ? new CourseSummaryDto(studentCourseSupportType.course) : null
            this.supportTypeId = studentCourseSupportType.supportType != null ?studentCourseSupportType.supportType.id : null
            this.supportType = SupportTypeDto.mapFromSupportTypeEntity(studentCourseSupportType.supportType)
            this.startDate = studentCourseSupportType.startDate
            this.endDate = studentCourseSupportType.endDate
        }
    }
    
    /**
     * This static method is used to create a StudentCourseSupportTypeDto from a StudentCourseSupportType data object.
     *
     * @param studentCourseSupportType the StudentCourseSupportType data object to use for the creation.
     * @return a StudentCourseSupportTypeDto object based on the StudentCourseSupportType data object supplied.
     */
    public static StudentCourseSupportTypeDto mapFromEntity(StudentCourseSupportType studentCourseSupportType) {
        return new StudentCourseSupportTypeDto(studentCourseSupportType);
    }
    
    /**
     * This static method is used to create a List of StudentCourseSupportTypeDto from a List of StudentCourseSupportType data object.
     *
     * @param studentCourseSupportTypes the List of StudentCourseSupportType data object to use for the creation.
     * @return a List of StudentCourseSupportTypeDto object based on the List of StudentCourseSupportType data object supplied.
     */
    public static List<StudentCourseSupportTypeDto> mapFromList(List<StudentCourseSupportType> studentCourseSupportTypes) {
        return studentCourseSupportTypes.collect { studentCourseSupportType ->  new StudentCourseSupportTypeDto(studentCourseSupportType) };
    }
    
    /**
     * This method is used to return the supportType Code for the StudentCourseSupportType object
     *
     * @return the supportType Code for the StudentCourseSupportType object
     */
    @JsonProperty(value = "_supportType")
    public String get_SupportType() {
        return this.supportType != null  ? this.supportType.support : null
    }
}
