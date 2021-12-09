package uk.ac.reigate.dto.exams.seatingplan

import org.junit.Before
import static org.junit.Assert.*
import org.junit.Test

import uk.ac.reigate.domain.Room
import uk.ac.reigate.domain.exams.seatingplan.ExamSeatingPlan
import uk.ac.reigate.domain.exams.seatingplan.ExamSession

class ExamSeatingPlanDtoTest {
    
    private ExamSeatingPlan examSeatingPlan1
    
    private ExamSeatingPlan examSeatingPlan2
    
    private ExamSeatingPlan examSeatingPlan3
    
    private List<ExamSeatingPlan> examSeatingPlans
    
    @Before
    public void setup() {
        this.examSeatingPlan1 = new ExamSeatingPlan(
                id: 1,
                examSession : new ExamSession(id: 1),
                room : new Room(id: 1),
                rows: 5,
                cols: 5
                )
        this.examSeatingPlan2 = new ExamSeatingPlan(
                id: 1,
                examSession : new ExamSession(id: 1),
                room : new Room(id: 1),
                rows: 5,
                cols: 5
                )
        this.examSeatingPlan3 = new ExamSeatingPlan(
                id: 1,
                examSession : null,
                room : null,
                rows: 5,
                cols: 5
                )
        this.examSeatingPlans = Arrays.asList(examSeatingPlan1, examSeatingPlan2)
    }
    
    @Test
    public void testConstructor() {
        ExamSeatingPlanDto dto = new ExamSeatingPlanDto(examSeatingPlan3)
        assertEquals( dto.id, examSeatingPlan3.id)
        assertEquals( dto.examSessionId, examSeatingPlan3.examSession)
        assertEquals( dto.roomId, examSeatingPlan3.room)
        assertEquals( dto.cols, examSeatingPlan3.cols)
        assertEquals( dto.rows, examSeatingPlan3.rows)
    }
    
    @Test
    public void testConstructor_NullObject() {
        ExamSeatingPlan examSeatingPlan = null
        ExamSeatingPlanDto dto = new ExamSeatingPlanDto(examSeatingPlan)
        assertEquals( examSeatingPlan, null)
    }
    
    @Test
    public void testMapFromEntity() {
        ExamSeatingPlanDto dto = ExamSeatingPlanDto.mapFromEntity(examSeatingPlan1)
        assertEquals( dto.id, examSeatingPlan1.id)
        assertEquals( dto.examSessionId, examSeatingPlan1.examSession.id)
        assertEquals( dto.roomId, examSeatingPlan1.room.id)
        assertEquals( dto.cols, examSeatingPlan1.cols)
        assertEquals( dto.rows, examSeatingPlan1.rows)
    }
    
    @Test
    public void testMapFromList() {
        List<ExamSeatingPlanDto> dto = ExamSeatingPlanDto.mapFromList(examSeatingPlans)
        assertEquals( dto[0].id, examSeatingPlan1.id)
        assertEquals( dto[0].examSessionId, examSeatingPlan1.examSession.id)
        assertEquals( dto[0].roomId, examSeatingPlan1.room.id)
        assertEquals( dto[0].cols, examSeatingPlan1.cols)
        assertEquals( dto[0].rows, examSeatingPlan1.rows)
        assertEquals( dto[1].id, examSeatingPlan2.id)
        assertEquals( dto[1].examSessionId, examSeatingPlan2.examSession.id)
        assertEquals( dto[1].roomId, examSeatingPlan2.room.id)
        assertEquals( dto[1].cols, examSeatingPlan2.cols)
        assertEquals( dto[1].rows, examSeatingPlan2.rows)
    }
}
