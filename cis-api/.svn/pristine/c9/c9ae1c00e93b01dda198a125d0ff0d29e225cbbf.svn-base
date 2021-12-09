package uk.ac.reigate.dto.exams;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.StudentAlternativeUci

public class StudentAlternativeUciDtoTest {
    
    private StudentAlternativeUci studentAlternativeUci1
    
    private StudentAlternativeUci studentAlternativeUci2
    
    private List<StudentAlternativeUci> studentAlternativeUcis
    
    private Student student
    
    private ExamBoard examBoard
    
    @Before
    public void setup() {
        this.studentAlternativeUci1 = new StudentAlternativeUci(
                student : new Student(id: 1),
                examBoard : new ExamBoard(id: 1, name: 'Test', boardIdentifier: '1F', description: 'OCR' ),
                alternativeUci : 'uci'
                );
        this.studentAlternativeUci2 = new StudentAlternativeUci(
                student : new Student(id: 4),
                examBoard : new ExamBoard(id: 4),
                alternativeUci : 'uci'
                );
        this.studentAlternativeUcis = Arrays.asList(this.studentAlternativeUci1, this.studentAlternativeUci2);
    }
    
    @Test
    void testconstructor_studentAlternativeUciDto() {
        StudentAlternativeUciDto studentAlternativeUciDto = new StudentAlternativeUciDto(studentAlternativeUci1)
        assertEquals( studentAlternativeUciDto.studentId, studentAlternativeUci1.student.id)
        assertEquals( studentAlternativeUciDto.examBoardId, studentAlternativeUci1.examBoard.id)
        assertEquals( studentAlternativeUciDto.alternativeUci, studentAlternativeUci1.alternativeUci)
    }
    
    @Test
    public void testMapFromStudentAlternativeUciEntity() {
        StudentAlternativeUciDto studentAlternativeUciDto = StudentAlternativeUciDto.mapFromEntity( studentAlternativeUci1 );
        assertEquals( studentAlternativeUciDto.studentId, studentAlternativeUci1.student.id);
        assertEquals( studentAlternativeUciDto.examBoardId, studentAlternativeUci1.examBoard.id);
        assertEquals( studentAlternativeUciDto.alternativeUci, studentAlternativeUci1.alternativeUci);
    }
    
    @Test
    public void testMapFromStudentComponentsEntities(){
        List<StudentAlternativeUciDto> studentComponentDtoList = StudentAlternativeUciDto.mapFromList( this.studentAlternativeUcis )
        assertEquals( studentComponentDtoList[0].studentId, studentAlternativeUci1.student.id);
        assertEquals( studentComponentDtoList[0].examBoardId, studentAlternativeUci1.examBoard.id);
        assertEquals( studentComponentDtoList[0].alternativeUci, studentAlternativeUci1.alternativeUci);
        assertEquals( studentComponentDtoList[1].studentId, studentAlternativeUci2.student.id);
        assertEquals( studentComponentDtoList[1].examBoardId, studentAlternativeUci2.examBoard.id);
        assertEquals( studentComponentDtoList[1].alternativeUci, studentAlternativeUci2.alternativeUci);
    }
    
    @Test
    public void testMethod_Get_ExamBoardIdentifier() {
        StudentAlternativeUciDto studentAlternativeUciDto1 = new StudentAlternativeUciDto(studentAlternativeUci1)
        assertEquals(studentAlternativeUciDto1.examBoard.boardIdentifier, studentAlternativeUciDto1.get_ExamBoardIdentifier())
    }
    
    @Test
    public void testMethod_Get_ExamBoardName() {
        StudentAlternativeUciDto studentAlternativeUciDto1 = new StudentAlternativeUciDto(studentAlternativeUci1)
        assertEquals(studentAlternativeUciDto1.examBoard.name, studentAlternativeUciDto1.get_ExamBoardName())
    }
    
    @Test
    public void testMethod_Get_ExamBoardDescription() {
        StudentAlternativeUciDto studentAlternativeUciDto1 = new StudentAlternativeUciDto(studentAlternativeUci1)
        assertEquals(studentAlternativeUciDto1.examBoard.description, studentAlternativeUciDto1.get_ExamBoardDescription())
    }
}
