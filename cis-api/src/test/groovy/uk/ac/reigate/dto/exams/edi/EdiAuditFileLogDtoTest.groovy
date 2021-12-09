package uk.ac.reigate.dto.exams.edi

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.domain.exams.edi.EdiAuditFileLog

class EdiAuditFileLogDtoTest {
    
    private EdiAuditFileLog ediAuditFileLog1
    
    private EdiAuditFileLog ediAuditFileLog2
    
    private List<EdiAuditFileLog> ediAuditFileLogs
    
    @Before
    public void setupTest() {
        this.ediAuditFileLog1 = new EdiAuditFileLog(
                id: 1,
                examSeries : new ExamSeries(id: 1),
                ediFileName : 'Test',
                fileTimeStamp : null
                )
        this.ediAuditFileLog2 = new EdiAuditFileLog(
                id: 1,
                examSeries : new ExamSeries(id: 2),
                ediFileName : 'Test',
                fileTimeStamp : null
                )
        this.ediAuditFileLogs = Arrays.asList(ediAuditFileLog1, ediAuditFileLog2)
    }
    
    @Test
    public void testConstructorEdiAuditFileLog() {
        EdiAuditFileLogDto ediAuditFileLogDto = new EdiAuditFileLogDto(ediAuditFileLog1)
        assertEquals( ediAuditFileLogDto.ediAuditFileLogId, ediAuditFileLog1.id);
        assertEquals( ediAuditFileLogDto.examSeriesId, ediAuditFileLog1.examSeries.id);
        assertEquals( ediAuditFileLogDto.ediFileName, ediAuditFileLog1.ediFileName)
    }
    
    @Test
    public void testMapFromEntity() {
        EdiAuditFileLogDto ediAuditFileLogDto = EdiAuditFileLogDto.mapFromEntity(ediAuditFileLog1)
        assertEquals( ediAuditFileLogDto.ediAuditFileLogId, ediAuditFileLog1.id);
        assertEquals( ediAuditFileLogDto.examSeriesId, ediAuditFileLog1.examSeries.id);
        assertEquals( ediAuditFileLogDto.ediFileName, ediAuditFileLog1.ediFileName)
    }
    
    @Test
    public void testMapFromList() {
        List<EdiAuditFileLogDto> ediAuditFileLogDto = EdiAuditFileLogDto.mapFromList(ediAuditFileLogs)
        assertEquals( ediAuditFileLogDto[0].ediAuditFileLogId, ediAuditFileLog1.id);
        assertEquals( ediAuditFileLogDto[0].examSeriesId, ediAuditFileLog1.examSeries.id);
        assertEquals( ediAuditFileLogDto[0].ediFileName, ediAuditFileLog1.ediFileName)
        assertEquals( ediAuditFileLogDto[1].ediAuditFileLogId, ediAuditFileLog2.id);
        assertEquals( ediAuditFileLogDto[1].examSeriesId, ediAuditFileLog2.examSeries.id);
        assertEquals( ediAuditFileLogDto[1].ediFileName, ediAuditFileLog2.ediFileName)
    }
}
