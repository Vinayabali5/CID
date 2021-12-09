package uk.ac.reigate.dto.exams.edi


import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.edi.EdiAuditEntryLog
import uk.ac.reigate.domain.exams.edi.EdiAuditFileLog

class EdiAuditEntryLogDtoTest {
    
    private EdiAuditEntryLog ediAuditEntryLog1
    
    private EdiAuditEntryLog ediAuditEntryLog2
    
    private List<EdiAuditEntryLog> ediAuditEntryLogs
    
    @Before
    public void setupTest() {
        this.ediAuditEntryLog1 = new EdiAuditEntryLog(
                student : new Student(id: 190001),
                examOption : new ExamOption(id : 1),
                ediAuditFileLog : new EdiAuditFileLog(id: 1)
                )
        this.ediAuditEntryLog2 = new EdiAuditEntryLog(
                student : new Student(id: 190002),
                examOption : new ExamOption(id : 1),
                ediAuditFileLog : new EdiAuditFileLog(id: 1)
                )
        this.ediAuditEntryLogs = Arrays.asList(ediAuditEntryLog1, ediAuditEntryLog2)
    }
    
    @Test
    public void testConstructorEdiAuditLog() {
        Student student = new Student(id: 190001)
        ExamOption examOption = new ExamOption(id: 1)
        EdiAuditFileLog ediAuditFileLog = new EdiAuditFileLog(id: 1)
        EdiAuditEntryLogDto ediAuditEntryLog = new EdiAuditEntryLogDto(student, examOption, ediAuditFileLog)
        assertEquals( ediAuditEntryLog.studentId, student.id);
        assertEquals( ediAuditEntryLog.examOptionId, examOption.id);
        assertEquals( ediAuditEntryLog.ediAuditFileLogId, ediAuditFileLog.id)
    }
    
    @Test
    public void testConstructorEdiAuditEntryLogDto() {
        EdiAuditEntryLogDto ediAuditEntryLogDto = new EdiAuditEntryLogDto(ediAuditEntryLog1)
        assertEquals( ediAuditEntryLogDto.studentId, ediAuditEntryLog1.student.id);
        assertEquals( ediAuditEntryLogDto.examOptionId, ediAuditEntryLog1.examOption.id);
        assertEquals( ediAuditEntryLogDto.ediAuditFileLogId, ediAuditEntryLog1.ediAuditFileLog.id)
    }
    
    @Test
    public void testMapFromEntity() {
        EdiAuditEntryLogDto ediAuditEntryLogDto = EdiAuditEntryLogDto.mapFromEntity(ediAuditEntryLog1)
        assertEquals( ediAuditEntryLogDto.studentId, ediAuditEntryLog1.student.id);
        assertEquals( ediAuditEntryLogDto.examOptionId, ediAuditEntryLog1.examOption.id);
        assertEquals( ediAuditEntryLogDto.ediAuditFileLogId, ediAuditEntryLog1.ediAuditFileLog.id)
    }
    
    @Test
    public void testMapFromList() {
        List<EdiAuditEntryLogDto> ediAuditEntryLogDto = EdiAuditEntryLogDto.mapFromList(ediAuditEntryLogs)
        assertEquals( ediAuditEntryLogDto[0].studentId, ediAuditEntryLog1.student.id);
        assertEquals( ediAuditEntryLogDto[0].examOptionId, ediAuditEntryLog1.examOption.id);
        assertEquals( ediAuditEntryLogDto[0].ediAuditFileLogId, ediAuditEntryLog1.ediAuditFileLog.id)
        assertEquals( ediAuditEntryLogDto[1].studentId, ediAuditEntryLog2.student.id);
        assertEquals( ediAuditEntryLogDto[1].examOptionId, ediAuditEntryLog2.examOption.id);
        assertEquals( ediAuditEntryLogDto[1].ediAuditFileLogId, ediAuditEntryLog2.ediAuditFileLog.id)
    }
}
