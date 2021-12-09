package uk.ac.reigate.dto.exams.basedata

import org.springframework.beans.factory.annotation.Autowired

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.exams.CourseOption
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.dto.CourseDto
import uk.ac.reigate.dto.exams.CourseOptionDto
import uk.ac.reigate.exceptions.DataConversionException
import uk.ac.reigate.services.exams.CourseOptionService

@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class ExamOptionDto {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String optionEntryCode;
    
    @JsonProperty
    private Integer syllabusId
    
    @JsonProperty
    private SyllabusSummaryDto syllabus;
    
    @JsonProperty
    private String examTypeQualificationCert;
    
    @JsonProperty
    private String examTypeLevelCert;
    
    @JsonProperty
    private String examTypeItem
    
    @JsonProperty
    private String examTypeQualificationUnit;
    
    @JsonProperty
    private String examTypeLevelUnit;
    
    @JsonProperty
    private String process;
    
    @JsonProperty
    private String qcaClassificationCode;
    
    @JsonProperty
    private String qcaAccreditationNo;
    
    @JsonProperty
    private String optionTitle;
    
    @JsonProperty
    private String feeDefined;
    
    @JsonProperty
    private Integer examinationFee;
    
    @JsonProperty
    private String firstForecastGradeGradeset;
    
    @JsonProperty
    private String secondForecastGradeGradeset;
    
    @JsonProperty
    private String resultType;
    
    @JsonProperty
    private String firstGradeResultGradeset;
    
    @JsonProperty
    private String secondGradeResultGradeset;
    
    @JsonProperty
    private String endorsementToFirstGradeResultGradeset;
    
    @JsonProperty
    private String endorsementToSecondGradeResultGradeset;
    
    @JsonProperty
    private Integer maxMarkUms;
    
    @JsonProperty
    private Integer noOfComponents;
    
    @JsonProperty
    private Integer examTypeCertId
    
    @JsonProperty
    private Integer examTypeUnitId
    
    @JsonProperty
    private List<ExamComponentDto> examComponents;
    
    @JsonProperty
    private List<CourseOptionDto> courseOption;
    
    /**
     * Default No Args constructor    
     */
    public ExamOptionDto(){}
    
    public ExamOptionDto(ExamOption examOption) {
        this.id = examOption.id
        this.optionEntryCode = examOption.optionEntryCode
        this.syllabusId = examOption.syllabus != null ? examOption.syllabus.id : null
        this.syllabus = examOption.syllabus != null ? SyllabusSummaryDto.mapFromEntity(examOption.syllabus) : null
        this.examTypeQualificationCert = examOption.examTypeCert != null ? examOption.examTypeCert.qualification : null
        this.examTypeLevelCert = examOption.examTypeCert != null ? examOption.examTypeCert.level : null
        this.examTypeQualificationUnit = examOption.examTypeUnit != null ? examOption.examTypeUnit.qualification : null
        this.examTypeLevelUnit = examOption.examTypeUnit != null ? examOption.examTypeUnit.level : null
        
        this.process = examOption.process
        this.qcaClassificationCode = examOption.qcaClassificationCode
        this.qcaAccreditationNo = examOption.qcaAccreditationNo
        this.optionTitle = examOption.optionTitle
        this.feeDefined = examOption.feeDefined
        this.examinationFee = examOption.examinationFee
        this.firstForecastGradeGradeset = examOption.firstForecastGradeGradeset
        this.secondForecastGradeGradeset = examOption.secondForecastGradeGradeset
        this.resultType = examOption.resultType
        this.firstGradeResultGradeset = examOption.firstGradeResultGradeset
        this.secondGradeResultGradeset = examOption.secondGradeResultGradeset
        this.endorsementToFirstGradeResultGradeset = examOption.endorsementToFirstGradeResultGradeset
        this.endorsementToSecondGradeResultGradeset = examOption.endorsementToSecondGradeResultGradeset
        this.maxMarkUms = examOption.maxMarkUms
        this.noOfComponents = examOption.noOfComponents
        this.examTypeCertId = examOption.examTypeCert != null ? examOption.examTypeCert.examTypeId : null
        this.examTypeUnitId = examOption.examTypeUnit != null ? examOption.examTypeUnit.examTypeId : null
        this.examComponents = examOption.optionComponents != null ? ExamComponentDto.mapFromList(examOption.optionComponents.collect { it.examComponent } ) : null
        this.courseOption = examOption.courseOptions != null ? CourseOptionDto.mapFromList(examOption.courseOptions): null
    }
    
    /**
     * This method is used to convert a single ExamOption object into and ExamOptionDto object.
     * 
     * @param examOption An ExamOption object
     * @return An ExamOptionDto object
     */
    public static ExamOptionDto mapFromEntity(ExamOption examOption) {
        return new ExamOptionDto(examOption)
    }
    
    /**
     * This method is used to convert a List of ExamOption objects into a List of ExamOptionDto
     * objects.
     * 
     * @param examOptions A List of ExamOption objects
     * @return A List of ExamOptionDto objects
     */
    public static List<ExamOptionDto> mapFromList(List<ExamOption> examOptions) {
        return examOptions.collect { ExamOption examOption ->  new ExamOptionDto(examOption)  };
    }
}
