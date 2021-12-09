package uk.ac.reigate.dto

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.EntryQualification
import uk.ac.reigate.domain.academic.EntryQualificationType
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentPredictedGrade
import uk.ac.reigate.domain.exams.ExamBoard

class StudentPrdictedGradeDtoTest {
    
    private StudentPredictedGrade studentPredictedGrade1
    
    private StudentPredictedGrade studentPredictedGrade2
    
    private StudentPredictedGrade studentPredictedGrade3
    
    private List<StudentPredictedGrade> studentPredictedGrades
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    EntryQualification createEntryQualification() {
        EntryQualification qualification = new EntryQualification(
                type: new EntryQualificationType(id:1 )
                )
        qualification.id = 1
        return qualification
    }
    
    @Before
    public void setup() {
        this.studentPredictedGrade1 = new StudentPredictedGrade(
                id: 1,
                student : createStudent(),
                predictedGrade: createEntryQualification(),
                grade : 'A',
                examBoard: new ExamBoard(id: 1)
                );
        this.studentPredictedGrade2 = new StudentPredictedGrade(
                id: 2,
                student : createStudent(),
                predictedGrade: createEntryQualification(),
                grade : 'A',
                examBoard: new ExamBoard(id: 1)
                )
        this.studentPredictedGrade3 = new StudentPredictedGrade(
                id: 3,
                student : null,
                predictedGrade: null,
                grade : 'A',
                examBoard: null
                )
        this.studentPredictedGrades = Arrays.asList(studentPredictedGrade1, studentPredictedGrade2)
    }
    
    @Test
    public void testMapFromEntity() {
        StudentPredictedGradeDto studentPredictedGradeDto = StudentPredictedGradeDto.mapFromEntity(studentPredictedGrade1)
        assertEquals( studentPredictedGradeDto.studentId, studentPredictedGrade1.student.id );
        assertEquals( studentPredictedGradeDto.predictedGradeId, studentPredictedGrade1.predictedGrade.id);
        assertEquals( studentPredictedGradeDto.examBoardId, studentPredictedGrade1.examBoard.id);
        assertEquals( studentPredictedGradeDto.grade, studentPredictedGrade1.grade)
    }
    
    @Test
    public void testMapFromList() {
        List<StudentPredictedGradeDto> studentPredictedGradeDto = StudentPredictedGradeDto.mapFromList(studentPredictedGrades)
        assertEquals( studentPredictedGradeDto[0].studentId, studentPredictedGrade1.student.id );
        assertEquals( studentPredictedGradeDto[0].predictedGradeId, studentPredictedGrade1.predictedGrade.id);
        assertEquals( studentPredictedGradeDto[0].examBoardId, studentPredictedGrade1.examBoard.id);
        assertEquals( studentPredictedGradeDto[0].grade, studentPredictedGrade1.grade)
        assertEquals( studentPredictedGradeDto[1].studentId, studentPredictedGrade2.student.id );
        assertEquals( studentPredictedGradeDto[1].predictedGradeId, studentPredictedGrade2.predictedGrade.id);
        assertEquals( studentPredictedGradeDto[1].examBoardId, studentPredictedGrade2.examBoard.id);
        assertEquals( studentPredictedGradeDto[1].grade, studentPredictedGrade2.grade)
    }
    
    @Test
    public void testConstructor() {
        StudentPredictedGradeDto studentPredictedGradeDto = new StudentPredictedGradeDto(studentPredictedGrade1)
        assertEquals( studentPredictedGradeDto.studentId, studentPredictedGrade1.student.id );
        assertEquals( studentPredictedGradeDto.predictedGradeId, studentPredictedGrade1.predictedGrade.id);
        assertEquals( studentPredictedGradeDto.examBoardId, studentPredictedGrade1.examBoard.id);
        assertEquals( studentPredictedGradeDto.grade, studentPredictedGrade1.grade)
    }
    
    @Test
    public void testConstructorNullObject() {
        StudentPredictedGradeDto studentPredictedGradeDto = new StudentPredictedGradeDto(studentPredictedGrade3)
        assertEquals( studentPredictedGradeDto.studentId, studentPredictedGrade3.student );
        assertEquals( studentPredictedGradeDto.predictedGradeId, studentPredictedGrade3.predictedGrade);
        assertEquals( studentPredictedGradeDto.examBoardId, studentPredictedGrade3.examBoard);
        assertEquals( studentPredictedGradeDto.grade, studentPredictedGrade3.grade)
    }
    
    @Test
    public void testConstructor_NullDto() {
        StudentPredictedGrade studentPredictedGrade = null
        StudentPredictedGradeDto studentPredictedGradeDto = new StudentPredictedGradeDto(studentPredictedGrade)
        assertEquals( studentPredictedGrade, null )
    }
    
    @Test
    public void testMethod_Get_NullExamBoardName() {
        StudentPredictedGradeDto studentPredictedGradeDto1 = new StudentPredictedGradeDto(studentPredictedGrade3)
        assertEquals(studentPredictedGradeDto1.examBoard, studentPredictedGradeDto1.get_ExamBoardName())
    }
    
    @Test
    public void testMethod_Get_ExamBoardName() {
        StudentPredictedGradeDto studentPredictedGradeDto1 = new StudentPredictedGradeDto(studentPredictedGrade1)
        assertEquals(studentPredictedGradeDto1.examBoard.name, studentPredictedGradeDto1.get_ExamBoardName())
    }
}
