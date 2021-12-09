package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.academic.ExternalResultsArchive
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing ExternalResultsArchive data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ExternalResultsArchiveDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId
    
    @JsonProperty
    private String courseSpec
    
    @JsonProperty
    private String levelDescription
    
    @JsonProperty
    private String subjectDescription
    
    @JsonProperty
    private String syllabus
    
    @JsonProperty
    private String grade
    
    @JsonProperty
    private String mark
    
    @JsonProperty
    private String maxMark
    
    @JsonProperty
    private Date dateAchieved
    
    @JsonProperty
    private String series
    
    @JsonProperty
    private String year
    
    @JsonProperty
    private String examType
    
    /**
     * Default No Args constructor
     */
    public ExternalResultsArchiveDto() {
    }
    
    /**
     * Constructor to create an ExternalResultsArchiveDto object from a ExternalResultsArchive object
     *
     * @param externalResultsArchive the ExternalResultsArchive object to use for construction
     */
    ExternalResultsArchiveDto(ExternalResultsArchive externalResultsArchive) {
        if(externalResultsArchive != null) {
            this.id = externalResultsArchive.id;
            this.studentId = externalResultsArchive.student != null ? externalResultsArchive.student.id : null;
            this.courseSpec = externalResultsArchive.courseSpec;
            this.levelDescription = externalResultsArchive.levelDescription;
            this.subjectDescription = externalResultsArchive.subjectDescription;
            this.syllabus = externalResultsArchive.syllabus;
            this.grade = externalResultsArchive.grade;
            this.mark = externalResultsArchive.mark;
            this.maxMark = externalResultsArchive.maxMark;
            this.dateAchieved = externalResultsArchive.dateAchieved;
            this.series = externalResultsArchive.series;
            this.year = externalResultsArchive.year;
            this.examType = externalResultsArchive.examType;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a ExternalResultsArchiveDto from a ExternalResultsArchive data object.
     *
     * @param externalResultsArchive the ExternalResultsArchive data object to use for the creation.
     * @return a ExternalResultsArchiveDto object based on the ExternalResultsArchive data object supplied.
     */
    public static ExternalResultsArchiveDto mapFromEntity(ExternalResultsArchive externalResultsArchive) {
        return new ExternalResultsArchiveDto(externalResultsArchive)
    }
    
    /**
     * This static method is used to create a List of ExternalResultsArchiveDto from a List of ExternalResultsArchive data object.
     *
     * @param externalResultsArchives the List of ExternalResultsArchive data object to use for the creation.
     * @return a List of ExternalResultsArchiveDto object based on the List of ExternalResultsArchive data object supplied.
     */
    public static List<ExternalResultsArchiveDto> mapFromList(List<ExternalResultsArchive> externalResultsArchives) {
        return externalResultsArchives.collect { externalResultsArchive ->  new ExternalResultsArchiveDto(externalResultsArchive) };
    }
}