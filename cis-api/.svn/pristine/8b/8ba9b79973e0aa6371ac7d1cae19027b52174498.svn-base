package uk.ac.reigate.dto.exams.seatingplan

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Room
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.seatingplan.ExamSeat
import uk.ac.reigate.domain.exams.seatingplan.ExamSeatingPlan
import uk.ac.reigate.domain.exams.seatingplan.ExamSession
import uk.ac.reigate.domain.learning_support.StudentCourseConcession

class ExamSeatDtoTest {
    
    private ExamSeat examSeat1
    
    private ExamSeat examSeat2
    
    private List<ExamSeat> examSeats
    
    ExamSession examSession = new ExamSession(id:1)
    
    Room room = new Room(id: 1)
    
    ExamComponent examComponent = new ExamComponent(id: 1)
    
    Student createStudent() {
        Student student = new Student(
                id: 190001,
                person: createPerson()
                )
    }
    
    Person createPerson() {
        Person person = new Person(
                id: 1,
                firstName : 'Vinaya',
                surname : 'Bali'
                )
    }
    StudentYear createStudentYear() {
        StudentYear studentYear = new StudentYear(
                student : createStudent(),
                candidateNo : 20000
                )
    }
    
    ExamSeatingPlan createExamSeatingPlan() {
        ExamSeatingPlan examSeatingPlan = new ExamSeatingPlan(
                id : 1,
                examSession : examSession,
                room : room,
                rows: 5,
                cols : 5
                )
    }
    
    @Before
    public void setup() {
        this.examSeat1 = new ExamSeat(
                examSeatingPlan : createExamSeatingPlan(),
                row: 5,
                col : 5,
                student : createStudent(),
                examComponent : new ExamComponent(id: 1, code: 'Test', title: 'MAT')
                )
        this.examSeat2 = new ExamSeat(
                examSeatingPlan : new ExamSeatingPlan(),
                row: 5,
                col : 5,
                student : new Student(id: 200002, person: null),
                examComponent : null
                )
        this.examSeats = Arrays.asList(examSeat1, examSeat2)
    }
    
    @Test
    public void testMapFromEntity() {
        ExamSeatsDto examSeatDto = ExamSeatsDto.mapFromEntity(examSeat1)
        assertEquals(examSeatDto.examSeatingPlanId, examSeat1.examSeatingPlan.id)
        assertEquals( examSeatDto.studentId, examSeat1.student.id)
        assertEquals( examSeatDto.col, examSeat1.col)
        assertEquals( examSeatDto.row, examSeat1.row)
        assertEquals( examSeatDto.examComponentId, examSeat1.examComponent.id)
    }
    
    @Test
    public void testMapFromList() {
        List<ExamSeatsDto> examSeatDto = ExamSeatsDto.mapFromList(examSeats)
        assertEquals( examSeatDto[0].examSeatingPlanId, examSeat1.examSeatingPlan.id)
        assertEquals( examSeatDto[0].studentId, examSeat1.student.id)
        assertEquals( examSeatDto[0].col, examSeat1.col)
        assertEquals( examSeatDto[0].row, examSeat1.row)
        assertEquals( examSeatDto[0].examComponentId, examSeat1.examComponent.id)
        assertEquals( examSeatDto[1].examSeatingPlanId, examSeat2.examSeatingPlan.id)
        assertEquals( examSeatDto[1].studentId, examSeat2.student.id)
        assertEquals( examSeatDto[1].col, examSeat2.col)
        assertEquals( examSeatDto[1].row, examSeat2.row)
        assertEquals( examSeatDto[1].examComponentId, examSeat2.examComponent)
    }
    
    @Test
    public void testConstructor() {
        ExamSeatsDto examSeatDto = new ExamSeatsDto(examSeat1)
        assertEquals(examSeatDto.examSeatingPlanId, examSeat1.examSeatingPlan.id)
        assertEquals( examSeatDto.studentId, examSeat1.student.id)
        assertEquals( examSeatDto.col, examSeat1.col)
        assertEquals( examSeatDto.row, examSeat1.row)
        assertEquals( examSeatDto.examComponentId, examSeat1.examComponent.id)
    }
    
    @Test
    public void testConstructor_Student() {
        ExamSeatsDto examSeatDto = new ExamSeatsDto(createStudent(), examComponent, createExamSeatingPlan(), 5, 5)
        assertEquals(examSeatDto.examSeatingPlanId, createExamSeatingPlan().id)
        assertEquals( examSeatDto.studentId, createStudent().id)
        assertEquals( examSeatDto.col, 5)
        assertEquals( examSeatDto.row, 5)
        assertEquals( examSeatDto.examComponentId, examComponent.id)
    }
    
    @Test
    public void testConstructorNullRow() {
        ExamSeatsDto examSeatDto = new ExamSeatsDto(createStudent(), examComponent, createExamSeatingPlan(), null, null)
        assertEquals(examSeatDto.examSeatingPlanId, createExamSeatingPlan().id)
        assertEquals( examSeatDto.studentId, createStudent().id)
        assertEquals( examSeatDto.col, null)
        assertEquals( examSeatDto.row, null)
        assertEquals( examSeatDto.examComponentId, examComponent.id)
    }
    
    @Test
    public void testConstructorStudentYear() {
        ExamSeatsDto examSeatDto = new ExamSeatsDto(examSeat1, createStudentYear())
        assertEquals(examSeatDto.examSeatingPlanId, examSeat1.examSeatingPlan.id)
        assertEquals( examSeatDto.studentId, examSeat1.student.id)
        assertEquals( examSeatDto.col, examSeat1.col)
        assertEquals( examSeatDto.row, examSeat1.row)
        assertEquals( examSeatDto.examComponentId, examSeat1.examComponent.id)
        assertEquals( examSeatDto._candidateNo, createStudentYear().candidateNo)
    }
    
    @Test
    public void testConstructor_Concession() {
        StudentCourseConcession concession = new StudentCourseConcession(id : 1)
        List<StudentCourseConcession> concessions = [concession]
        ExamSeatsDto examSeatDto = new ExamSeatsDto(createStudent(), examComponent, createExamSeatingPlan(), 5, 5, createStudentYear(), concessions)
        assertEquals(examSeatDto.examSeatingPlanId, createExamSeatingPlan().id)
        assertEquals( examSeatDto.studentId, createStudent().id)
        assertEquals( examSeatDto.col, examSeat1.col)
        assertEquals( examSeatDto.row, examSeat1.row)
        assertEquals( examSeatDto.examComponentId, examSeat1.examComponent.id)
        assertEquals( examSeatDto._candidateNo, createStudentYear().candidateNo)
    }
    
    @Test
    public void testMethod_Get_FirstName() {
        ExamSeatsDto examSeatDto = new ExamSeatsDto(examSeat1)
        assertEquals(examSeatDto.student.person.firstName, examSeatDto.get_FirstName())
    }
    
    @Test
    public void testMethod_Get_Surname() {
        ExamSeatsDto examSeatDto = new ExamSeatsDto(examSeat1)
        assertEquals(examSeatDto.student.person.surname, examSeatDto.get_Surname())
    }
    
    @Test
    public void testMethod_Get_ExamComponentCode() {
        ExamSeatsDto examSeatDto = new ExamSeatsDto(examSeat1)
        assertEquals( examSeatDto.examComponent.code, examSeatDto.get_ExamComponentCode())
    }
    
    @Test
    public void testMethod_Get_ExamComponentTitle() {
        ExamSeatsDto examSeatDto = new ExamSeatsDto(examSeat1)
        assertEquals( examSeatDto.examComponent.title, examSeatDto.get_ExamComponentTitle())
    }
    
    @Test
    public void testMethod_Get_ExamRoomRoomCode() {
        ExamSeatsDto examSeatDto = new ExamSeatsDto(examSeat1)
        assertEquals( examSeatDto.examSeatingPlan.room.code, examSeatDto.get_ExamRoomRoomCode())
    }
    
    @Test
    public void testMethod_Get_NullExamRoomRoomCode() {
        ExamSeatsDto examSeatDto = new ExamSeatsDto(examSeat2)
        assertEquals( examSeatDto.examSeatingPlan.room, examSeatDto.get_ExamRoomRoomCode())
    }
    
    @Test
    public void testMethod_Get_ExamRoomRoomDescription() {
        ExamSeatsDto examSeatDto = new ExamSeatsDto(examSeat1)
        assertEquals( examSeatDto.examSeatingPlan.room.description, examSeatDto.get_ExamRoomRoomDescription())
    }
}
