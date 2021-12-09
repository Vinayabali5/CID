package uk.ac.reigate.dto.exams.basedata

import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.exams.basedata.Syllabus

/**
 * This class is used as a summary of the Syllabus object without any linkages to the ExamOption for the supplied 
 * syllabus.   
 * 
 * @author Michael Horgan
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class SyllabusSummaryDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private ExamSeriesDto examSeries;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String title;
    
    /**
     * Default No Args constructor    
     */
    public SyllabusSummaryDto(){}
    
    /**
     * This is a constructor the uses a Syllabus object to create a SyllabusDto object
     * 
     * @param syllabus The Syllabus object to use for construction
     */
    public SyllabusSummaryDto(Syllabus syllabus) {
        this.id = syllabus.id
        this.examSeries = ExamSeriesDto.mapFromEntity(syllabus.examSeries);
        this.code = syllabus.code;
        this.title = syllabus.title;
    }
    
    /**
     * This method is used to convert a single Syllabus object into and SyllabusDto object.
     * 
     * @param syllabus An Syllabus object
     * @return An SyllabusDto object
     */
    public static SyllabusSummaryDto mapFromEntity(Syllabus syllabus) {
        return new SyllabusSummaryDto(syllabus)
    }
    
    /**
     * This method is used to map a List of Syllabus objects to a List of SyllabusDto objects.
     * 
     * @param syllabi the list of Syllabus object to perform the mapping on.
     * @return a list of SyllabusDto objects that represent the list of Syllabus objects supplied.
     */
    public static List<SyllabusSummaryDto> mapFromList(List<Syllabus> syllabi) {
        return syllabi.collect { syllabus -> new SyllabusSummaryDto(syllabus) } ;
    }
}
