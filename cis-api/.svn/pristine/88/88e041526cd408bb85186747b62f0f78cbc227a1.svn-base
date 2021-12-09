package uk.ac.reigate.dto.exams.edi;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.domain.exams.edi.EdiAuditFileLog

/**
 *
 * JSON serializable DTO containing ReferralReason data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class EdiAuditFileLogDto implements Serializable {
    
    @JsonProperty
    private Integer ediAuditFileLogId;
    
    @JsonProperty
    private Integer examSeriesId;
    
    @JsonProperty
    private String ediFileName
    
    @JsonProperty
    private Date fileTimeStamp
    
    /**
     * Default No Args constructor
     */
    public EdiAuditFileLogDto() {}
    
    /**
     * Constructor to create a ReferralReasonDto object
     *
     * @param id the Id for the ReferralReason
     * @param code the code for the ReferralReason
     * @param description the description for the ReferralReason
     */
    public EdiAuditFileLogDto(EdiAuditFileLog ediAuditFileLog) {
        this.ediAuditFileLogId = ediAuditFileLog.id
        this.examSeriesId = ediAuditFileLog.examSeries.id;
        this.ediFileName = ediAuditFileLog.ediFileName;
        this.fileTimeStamp = ediAuditFileLog.fileTimeStamp;
    }
    
    /**
     * This static method is used to create a EdiAuditFileLogDto from a EdiAuditFileLog data object.
     *
     * @param ediAuditFileLog the EdiAuditFileLog data object to use for the creation.
     * @return a EdiAuditFileLogDto object based on the EdiAuditFileLog data object supplied.
     */
    public static EdiAuditFileLogDto mapFromEntity(EdiAuditFileLog ediAuditFileLog) {
        return new EdiAuditFileLogDto(ediAuditFileLog);
    }
    
    /**
     * This static method is used to create a List of EdiAuditFileLogDto from a List of EdiAuditFileLog data object.
     *
     * @param ediAuditFileLogs the List of EdiAuditFileLog data object to use for the creation.
     * @return a List of EdiAuditFileLogDto object based on the List of EdiAuditFileLog data object supplied.
     */
    public static List<EdiAuditFileLogDto> mapFromList(List<EdiAuditFileLog> ediAuditFileLogs) {
        return ediAuditFileLogs.collect { ediAuditFileLog ->  new EdiAuditFileLogDto(ediAuditFileLog) };
    }
}