package uk.ac.reigate.dto.careers

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.StudentCareersRecord

/**
 *
 * JSON serializable DTO containing LearningSupport data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentCareersRecordDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer careersRecordTypeId
    
    @JsonProperty
    private CareersRecordTypeDto careersRecordType
    
    @JsonProperty
    private Date startDate
    
    @JsonProperty
    private Date endDate
    
    @JsonProperty
    private String employerInstitution
    
    @JsonProperty
    private String organiser
    
    @JsonProperty
    private String note
    
    /**
     * Default No Args constructor
     */
    public StudentCareersRecordDto() {
    }
    
    /**
     * Constructor to create a StudentCareersRecordDto object from a Student, StudentCareersRecord object
     *
     * @param student, studentCareersRecord the Student, StudentCareersRecord object to use for construction
     */
    public StudentCareersRecordDto(StudentCareersRecord studentCareersRecord) {
        if(studentCareersRecord != null) {
            this.id = studentCareersRecord.id
            this.studentId = studentCareersRecord.student != null ? studentCareersRecord.student.id : null;
            this.startDate = studentCareersRecord.startDate
            this.endDate = studentCareersRecord.endDate
            this.note = studentCareersRecord.note
            this.employerInstitution = studentCareersRecord.employerInstitution
            this.organiser = studentCareersRecord.organiser
            this.careersRecordTypeId = studentCareersRecord.careersRecordType != null ? studentCareersRecord.careersRecordType.id : null;
            this.careersRecordType = studentCareersRecord.careersRecordType != null ? CareersRecordTypeDto.mapFromEntity(studentCareersRecord.careersRecordType) : null
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentCareersRecordDto from a StudentCareersRecord data object.
     *
     * @param contact the StudentCareersRecord data object to use for the creation.
     * @return a StudentCareersRecordDto object based on the StudentCareersRecord data object supplied.
     */
    public static StudentCareersRecordDto mapFromEntity(StudentCareersRecord studentCareersRecord) {
        return new StudentCareersRecordDto(studentCareersRecord);
    }
    
    /**
     * This static method is used to create a List of StudentCareersRecordDto from a List of StudentCareersRecord data object.
     *
     * @param studentCareersRecords the List of StudentCareersRecord data object to use for the creation.
     * @return a List of StudentCareersRecordDto object based on the List of StudentCareersRecord data object supplied.
     */
    public static List<StudentCareersRecordDto> mapFromList(List<StudentCareersRecord> studentCareersRecords) {
        return studentCareersRecords.collect { studentCareersRecord ->  new StudentCareersRecordDto(studentCareersRecord) };
    }
    
    /**
     * This method is used to return the CareersRecordType Description for the Contact object
     *
     * @return the CareersRecordType Description for the Contact object
     */
    @JsonProperty(value = "_careersRecordTypeDescription")
    public String get_CareersRecordTypeDescription() {
        return this.careersRecordType != null ? this.careersRecordType.description : null
    }
}