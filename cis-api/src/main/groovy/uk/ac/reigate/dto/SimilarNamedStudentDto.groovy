package uk.ac.reigate.dto

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.AcademicYear;
import uk.ac.reigate.domain.academic.SimilarNamedStudent
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.Level
import uk.ac.reigate.domain.lookup.PossibleGrade
import uk.ac.reigate.domain.lookup.Subject
import uk.ac.reigate.dto.lookup.PossibleGradeDto

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class SimilarNamedStudentDto implements Serializable {
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer academicYearId;
    
    @JsonProperty
    private Integer numberSimilarNames;
    
    /**
     * Default No Args constructor
     */
    SimilarNamedStudentDto() {}
    
    /**
     * Constructor to create a AcademicYearOption object
     * 
     * @param academicYear
     * @param option
     */
    SimilarNamedStudentDto(Student student, AcademicYear academicYear, PossibleGrade predictedGrade) {
        this.studentId = student.id
        this.academicYearId = academicYear.id;
        this.numberSimilarNames = numberSimilarNames;
    }
    
    /**
     * Constructor to create a Similar name object object
     *
     * @param academicYear
     * @param option
     */
    SimilarNamedStudentDto(SimilarNamedStudent similarNamedStudent) {
        this.studentId = similarNamedStudent.student != null ? similarNamedStudent.student.id : null
        this.academicYearId = similarNamedStudent.academicYear != null ? similarNamedStudent.academicYear.id : null;
        this.numberSimilarNames = similarNamedStudent.numberSimilarNames;
    }
    
    /**
     * This method is used to map an SimilarNamedStudent object to an SimilarNamedStudentDto object
     *
     * @param similarNamedStudent an SimilarNamedStudent object
     * @return an SimilarNamedStudentDto object
     */
    public static SimilarNamedStudentDto mapFromEntity(SimilarNamedStudent similarNamedStudent) {
        return new SimilarNamedStudentDto(similarNamedStudent);
    }
    
    /**
     * This method is used to map a List of SimilarNamedStudent objects to a List of SimilarNamedStudentDto objects.
     *
     * @param similarNamedStudentList a List of SimilarNamedStudent objects
     * @return a List of SimilarNamedStudentDto objects
     */
    public static List<SimilarNamedStudentDto> mapFromList(List<SimilarNamedStudent> similarNamedStudents) {
        return similarNamedStudents.collect { similarNamedStudent -> mapFromEntity(similarNamedStudent) } ;
    }
}
