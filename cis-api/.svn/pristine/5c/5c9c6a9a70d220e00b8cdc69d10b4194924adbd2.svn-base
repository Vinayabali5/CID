package uk.ac.reigate.dto

import javax.persistence.Column

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.StudentDukeOfEdinburgh

/**
 *
 * JSON serializable DTO containing Student Duke of Edinburgh data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StudentDukeOfEdinburghDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Date startDate
    
    @JsonProperty
    private Date endDate
    
    @JsonProperty
    private Double hours
    
    @JsonProperty
    private String voluntaryOrganisation
    
    @JsonProperty
    private String note
    
    /**
     * Default No Args constructor
     */
    public StudentDukeOfEdinburghDto() {
    }
    
    /**
     * Constructor to create a StudentDukeOfEdinburghDto object from a Student object
     *
     * @param student, studentDukeOfEdinburgh the Student object to use for construction
     */
    public StudentDukeOfEdinburghDto(StudentDukeOfEdinburgh studentDukeOfEdinburgh) {
        if(studentDukeOfEdinburgh != null) {
            this.id = studentDukeOfEdinburgh.id
            this.studentId = studentDukeOfEdinburgh.student != null ? studentDukeOfEdinburgh.student.id : null;
            this.startDate = studentDukeOfEdinburgh.startDate
            this.endDate = studentDukeOfEdinburgh.endDate
            this.hours = studentDukeOfEdinburgh.hours
            this.note = studentDukeOfEdinburgh.note
            this.voluntaryOrganisation = studentDukeOfEdinburgh.voluntaryOrganisation
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a StudentDukeOfEdinburghDto from a StudentDukeOfEdinburgh data object.
     *
     * @param contact the StudentDukeOfEdinburgh data object to use for the creation.
     * @return a StudentDukeOfEdinburghDto object based on the StudentDukeOfEdinburgh data object supplied.
     */
    public static StudentDukeOfEdinburghDto mapFromEntity(StudentDukeOfEdinburgh studentDukeOfEdinburgh) {
        return new StudentDukeOfEdinburghDto(studentDukeOfEdinburgh);
    }
    
    /**
     * This static method is used to create a List of StudentDukeOfEdinburghDto from a List of StudentDukeOfEdinburgh data object.
     *
     * @param studentDukeOfEdinburghs the List of StudentDukeOfEdinburgh data object to use for the creation.
     * @return a List of StudentDukeOfEdinburghDto object based on the List of StudentDukeOfEdinburgh data object supplied.
     */
    public static List<StudentDukeOfEdinburghDto> mapFromList(List<StudentDukeOfEdinburgh> studentDukeOfEdinburghs) {
        return studentDukeOfEdinburghs.collect { studentDukeOfEdinburgh ->  new StudentDukeOfEdinburghDto(studentDukeOfEdinburgh) };
    }
}