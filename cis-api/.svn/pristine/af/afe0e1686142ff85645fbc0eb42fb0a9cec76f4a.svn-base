package uk.ac.reigate.dto.exams.seatingplan

import static org.junit.Assert.*
import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.exams.seatingplan.ExamSession

class ExamSessionDtoTest {
    
    private ExamSession examSession1
    
    private ExamSession examSession2
    
    private List<ExamSession> examSessions
    
    @Before
    public void setup() {
        this.examSession1 = new ExamSession(
                id : 1,
                date : new SimpleDateFormat("yyyy/MM/dd").parse('2020/10/10'),
                session : 'A'
                )
        this.examSession2 = new ExamSession(
                id : 2,
                date : new SimpleDateFormat("yyyy/MM/dd").parse('2020/10/12'),
                session : 'P'
                )
        this.examSessions = Arrays.asList(examSession1, examSession2)
    }
    
    @Test
    public void testConstructorExamSession() {
        ExamSessionDto examSessionDto = new ExamSessionDto(examSession1)
        assertEquals(examSessionDto.id, examSession1.id)
        assertEquals(examSessionDto.date, examSession1.date)
        assertEquals(examSessionDto.session, examSession1.session)
    }
    
    @Test
    public void testConstructor_NullExamSession() {
        ExamSession examSession = null
        ExamSessionDto examSessionDto = new ExamSessionDto(examSession)
        assertEquals(examSession, null)
    }
    
    @Test
    public void testMapFromEntity() {
        ExamSessionDto examSessionDto = ExamSessionDto.mapFromEntity(examSession1)
        assertEquals(examSessionDto.id, examSession1.id)
        assertEquals(examSessionDto.date, examSession1.date)
        assertEquals(examSessionDto.session, examSession1.session)
    }
    
    @Test
    public void testMapFromList() {
        List<ExamSessionDto> examSessionDto = ExamSessionDto.mapFromList(examSessions)
        assertEquals(examSessionDto[0].id, examSession1.id)
        assertEquals(examSessionDto[0].date, examSession1.date)
        assertEquals(examSessionDto[0].session, examSession1.session)
        assertEquals(examSessionDto[1].id, examSession2.id)
        assertEquals(examSessionDto[1].date, examSession2.date)
        assertEquals(examSessionDto[1].session, examSession2.session)
    }
}
