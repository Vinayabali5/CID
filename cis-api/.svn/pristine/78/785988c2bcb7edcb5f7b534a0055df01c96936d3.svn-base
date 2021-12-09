package uk.ac.reigate.dto.exams.basedata

import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.exams.basedata.Syllabus

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class SyllabusDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer examSeriesId;
    
    @JsonProperty
    private ExamSeriesDto examSeries;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String title;
    
    @JsonProperty
    List<ExamOptionDto> examOptions
    
    /**
     * Default No Args constructor    
     */
    public SyllabusDto(){}
    
    /**
     * Constructor to create a DepartmentDto object from a Department object
     *
     * @param department the Department object to use for construction
     */
    public SyllabusDto(Syllabus syllabus) {
        this.id = syllabus.id
        this.examSeriesId = syllabus.examSeries != null ? syllabus.examSeries.id : null;
        this.examSeries = ExamSeriesDto.mapFromEntity(syllabus.examSeries);
        this.code = syllabus.code;
        this.title = syllabus.title;
        this.examOptions = syllabus.examOptions.collect { examOption ->
            new ExamOptionDto(examOption)
        }
    }
    
    /**
     * This method is used to map a Syllabus object to a SyllabisDto object. 
     * 
     * @param syllabus the Syllabus object to perform the mapping on.
     * @return a SyllabusDto object that represent the Syllabus object supplied. 
     */
    public static SyllabusDto mapFromEntity(Syllabus syllabus) {
        return new SyllabusDto(syllabus)
    }
    
    /**
     * This method is used to map a List of Syllabus objects to a List of SyllabusDto objects.
     * 
     * @param syllabi the list of Syllabus object to perform the mapping on.
     * @return a list of SyllabusDto objects that represent the list of Syllabus objects supplied.
     */
    public static List<SyllabusDto> mapFromList(List<Syllabus> syllabi) {
        return syllabi.collect { syllabus -> new SyllabusDto(syllabus) } ;
    }
}
