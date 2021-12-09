package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.exceptions.InvalidDataException


/**
 *
 * JSON serializable DTO containing StudentYear data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class TutorGroupRemarkPermissionDto {
    
    @JsonProperty
    Integer studentId
    
    @JsonProperty
    StudentDto student
    
    @JsonProperty
    Integer studentRemarkPermissionId
    
    @JsonProperty
    StudentRemarkPermissionDto studentRemarkPermission
    
    @JsonProperty
    Integer tutorGroupId
    
    @JsonProperty
    TutorGroupDto tutorGroup
    
    @JsonProperty
    Integer candidateNo
    
    @JsonProperty
    Date _startDate
    
    @JsonProperty
    Date _endDate
    
    /**
     * Default NoArgs constructor
     */
    TutorGroupRemarkPermissionDto() {}
    
    /**
     * Constructor to create an TutorGroupRemarkPermissionDto object from an StudentYear object
     *
     * @param studentYear the StudentYear object to use for construction
     */
    TutorGroupRemarkPermissionDto(StudentYear studentYear) {
        if(studentYear != null) {
            this.studentId = studentYear.student.id
            this.student = StudentDto.mapFromEntity(studentYear.student)
            this.candidateNo = studentYear.candidateNo
            this.studentRemarkPermissionId = studentYear.student.studentRemarkPermission != null ? studentYear.student.studentRemarkPermission.id : null
            this.studentRemarkPermission = studentYear.student.studentRemarkPermission != null ? StudentRemarkPermissionDto.mapFromEntity(studentYear.student.studentRemarkPermission) : null;
            this.tutorGroupId = studentYear.tutorGroup != null ? studentYear.tutorGroup.id : null
            this.tutorGroup = studentYear.tutorGroup != null ? TutorGroupDto.mapFromEntity(studentYear.tutorGroup) : null
            this._startDate = studentYear.startDate
            this._endDate = studentYear.endDate
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a TutorGroupRemarkPermissionDto from a StudentYear data object.
     *
     * @param studentYear the StudentYear data object to use for the creation.
     * @return a TutorGroupRemarkPermissionDto object based on the StudentYear data object supplied.
     */
    public static TutorGroupRemarkPermissionDto mapFromStudentEntity(StudentYear studentYear) {
        return new TutorGroupRemarkPermissionDto(studentYear)
    }
    
    /**
     * This static method is used to create a List of TutorGroupRemarkPermissionDto from a List of StudentYear data object.
     *
     * @param studentYears the List of StudentYear data object to use for the creation.
     * @return a List of TutorGroupRemarkPermissionDto object based on the List of StudentYear data object supplied.
     */
    public static List<TutorGroupRemarkPermissionDto> mapFromStudentsEntities( List<StudentYear> studentYears) {
        return studentYears.collect { studentYear ->  new TutorGroupRemarkPermissionDto(studentYear) };
    }
    
    /**
     * This method is used to return the TutorGroup Code for the StudentYear object
     *
     * @return the TutorGroup Code for the StudentYear object
     */
    @JsonProperty(value = "_tutorGroupCode")
    public String get_TutorGroupCode() {
        return this.tutorGroup != null ? this.tutorGroup.code : null
    }
    
    /**
     * This method is used to return the StudentRemarkPermission Decription for the StudentYear object
     *
     * @return the Student surname for the StudentYear object
     */
    @JsonProperty(value = "_studentRemarkPermissionDecription")
    public String get_StudentRemarkPermissionDecription() {
        return this.studentRemarkPermission != null ? this.studentRemarkPermission.description : null
    }
    
    /**
     * This method is used to return the Student firstName for the StudentYear object
     *
     * @return the Student firstName for the StudentYear object
     */
    @JsonProperty(value = "_firstName")
    public String get_FirstName() {
        return this.student.person != null ? this.student.person.firstName : null
    }
    
    /**
     * This method is used to return the Student surname for the StudentYear object
     *
     * @return the Student surname for the StudentYear object
     */
    @JsonProperty(value = "_surname")
    public String get_Surname() {
        return this.student.person != null ? this.student.person.surname : null
    }
}
