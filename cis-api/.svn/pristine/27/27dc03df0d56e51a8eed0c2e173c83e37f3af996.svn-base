package uk.ac.reigate.dto.exams.edi;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.edi.EdiAuditEntryLog
import uk.ac.reigate.domain.exams.edi.EdiAuditFileLog
import uk.ac.reigate.domain.learning_support.ReferralReason;
import uk.ac.reigate.domain.learning_support.StudentReferralReason

/**
 *
 * JSON serializable DTO containing ReferralReason data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class EdiAuditEntryLogDto implements Serializable {
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Integer examOptionId;
    
    @JsonProperty
    private Integer ediAuditFileLogId;
    
    
    /**
     * Default No Args constructor
     */
    public EdiAuditEntryLogDto() {}
    
    /**
     * Constructor to create a ReferralReasonDto object
     *
     * @param id the Id for the ReferralReason
     * @param code the code for the ReferralReason
     * @param description the description for the ReferralReason
     */
    public EdiAuditEntryLogDto(Student student, ExamOption examOption, EdiAuditFileLog ediAuditFileLog) {
        this.studentId = student.id;
        this.examOptionId = examOption.id;
        this.ediAuditFileLogId = ediAuditFileLog.id;
    }
    
    /**
     * Constructor to create a EdiAuditEntryLogDto object from a EdiAuditEntryLog object
     *
     * @param EdiAuditEntryLog object to use for construction
     */
    public EdiAuditEntryLogDto(EdiAuditEntryLog ediAuditEntryLog) {
        this.studentId = ediAuditEntryLog.student.id;
        this.examOptionId = ediAuditEntryLog.examOption.id;
        this.ediAuditFileLogId = ediAuditEntryLog.ediAuditFileLog.id;
    }
    
    /**
     * This static method is used to create a EdiAuditEntryLogDto from a EdiAuditEntryLog data object.
     *
     * @param ediAuditEntryLog the EdiAuditEntryLog data object to use for the creation.
     * @return a EdiAuditEntryLogDto object based on the EdiAuditEntryLog data object supplied.
     */
    public static EdiAuditEntryLogDto mapFromEntity(EdiAuditEntryLog ediAuditEntryLog) {
        return new EdiAuditEntryLogDto(ediAuditEntryLog);
    }
    
    /**
     * This static method is used to create a List of EdiAuditEntryLogDto from a List of EdiAuditEntryLog data object.
     *
     * @param EdiAuditEntryLogs the List of EdiAuditEntryLog data object to use for the creation.
     * @return a List of EdiAuditEntryLogDto object based on the List of EdiAuditEntryLog data object supplied.
     */
    public static List<EdiAuditEntryLogDto> mapFromList(List<EdiAuditEntryLog> ediAuditEntryLogs) {
        return ediAuditEntryLogs.collect { ediAuditEntryLog ->  new EdiAuditEntryLogDto(ediAuditEntryLog) };
    }
}
