package uk.ac.reigate.services.exams

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.StudentAlternativeUci
import uk.ac.reigate.domain.exams.StudentAlternativeUciPk
import uk.ac.reigate.dto.exams.StudentAlternativeUciDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.exams.StudentAlternativeUciRepository
import uk.ac.reigate.services.student.StudentService

class StudentAlternativeUciServiceTest {
    
    @Mock
    private StudentAlternativeUciRepository studentAlternativeUciRepository
    
    @Mock
    private StudentService studentService
    
    @Mock
    private ExamBoardService examBoardService
    
    @InjectMocks
    StudentAlternativeUciService studentAlternativeUciService
    
    private StudentAlternativeUci studentAlternativeUci
    
    private StudentAlternativeUciPk studentAlternativeUciPk
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    
    StudentAlternativeUci createStudentAlternativeUci() {
        return new StudentAlternativeUci(
                student : new Student(id: 20001),
                examBoard : new ExamBoard(id: 1),
                alternativeUci : 'test'
                )
    }
    
    StudentAlternativeUciDto createDto() {
        StudentAlternativeUci sampleStudentAlternativeUci = createStudentAlternativeUci()
        return new StudentAlternativeUciDto(
                studentId: sampleStudentAlternativeUci.student.id,
                examBoardId : sampleStudentAlternativeUci.examBoard.id,
                alternativeUci : sampleStudentAlternativeUci.alternativeUci
                )
    }
    
    @Before
    public void setup() {
        studentAlternativeUciRepository = mock(StudentAlternativeUciRepository.class)
        studentService = mock(StudentService.class)
        examBoardService = mock(ExamBoardService.class)
        
        studentAlternativeUci = createStudentAlternativeUci()
        studentAlternativeUciService = new StudentAlternativeUciService(studentAlternativeUciRepository, studentService, examBoardService)
        when(studentAlternativeUciService.getByStudentAndExamBoardId(studentAlternativeUci.student.id, studentAlternativeUci.examBoard.id)).thenReturn(new Optional(new StudentAlternativeUci()));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        StudentAlternativeUciService service = new StudentAlternativeUciService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<StudentAlternativeUci> result = studentAlternativeUciService.findAll();
        verify(studentAlternativeUciRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentAlternativeUciRepository)
    }
    
    @Test
    public void testFindById() {
        StudentAlternativeUci result = studentAlternativeUciService.findById(studentAlternativeUciPk)
        verify(studentAlternativeUciRepository, times(1)).findById(studentAlternativeUciPk)
        verifyNoMoreInteractions(studentAlternativeUciRepository)
    }
    
    @Test
    public void testGetByStudent() {
        StudentAlternativeUci result = studentAlternativeUciService.getByStudent(190001)
        verify(studentAlternativeUciRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(studentAlternativeUciRepository)
    }
    
    @Test
    public void testGetByStudentAndExamBoardId() {
        StudentAlternativeUci result = studentAlternativeUciService.getByStudentAndExamBoardId(190001, 1)
        studentAlternativeUciService.findById(new StudentAlternativeUciPk(190001, 1))
        //verifyNoMoreInteractions(studentAlternativeUciService)
    }
    
    @Test
    public void testSave() {
        StudentAlternativeUciService result = studentAlternativeUciService.save(studentAlternativeUci)
        verify(studentAlternativeUciRepository, times(1)).save(studentAlternativeUci)
        verifyNoMoreInteractions(studentAlternativeUciRepository)
    }
    
    @Test
    public void testDeleteAltenativeUci() {
        Boolean result = studentAlternativeUciService.deleteAltenativeUci(1, 2)
        StudentAlternativeUci studentAlternativeUci = studentAlternativeUciService.getByStudentAndExamBoardId(1, 1)
        studentAlternativeUciService.delete(studentAlternativeUci)
        //verifyNoMoreInteractions(studentAlternativeUciService)
    }
    
    @Test
    public void testDelete() {
        StudentAlternativeUciService result = studentAlternativeUciService.delete(studentAlternativeUci)
        verify(studentAlternativeUciRepository, times(1)).delete(studentAlternativeUci)
        verifyNoMoreInteractions(studentAlternativeUciRepository)
    }
    
    @Test
    public void testDeleteByIds() {
        Boolean result = studentAlternativeUciService.deleteByIds(1, 2)
        StudentAlternativeUci studentAlternativeUci = studentAlternativeUciRepository.findByStudent_IdAndExamBoard_Id(1, 2)
        studentAlternativeUci != null
        studentAlternativeUciService.delete(studentAlternativeUci)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentAlternativeUciDto from null object.")
        StudentAlternativeUciDto dto = null
        studentAlternativeUciService.createFromDto(dto)
        verifyNoMoreInteractions(studentAlternativeUciRepository)
    }
    
    
    @Test
    public void testCreateFromDto() {
        StudentAlternativeUciDto dto = createDto()
        studentAlternativeUciService.createFromDto(dto)
        verify(studentAlternativeUciRepository, times(1)).save(any(StudentAlternativeUci.class))
        verifyNoMoreInteractions(studentAlternativeUciRepository)
    }
    
    //@Test
    public void testUpdateFromDto_withDto() {
        StudentAlternativeUciDto dto = createDto()
        studentAlternativeUciService.updateFromDto(dto)
        when(studentAlternativeUciService.getByStudentAndExamBoardId(dto.studentId, dto.examBoardId)).thenReturn(null);
        verify(studentAlternativeUciRepository, times(1)).save(any(StudentAlternativeUci.class))
        //verifyNoMoreInteractions(studentAlternativeUciRepository)
    }
    
    @Test
    public void testUpdateFromDto_withDtoWithNoId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentAlternativeUciDto from null object.");
        // Initialise Test
        StudentAlternativeUciDto dto = null
        studentAlternativeUciService.updateFromDto(dto)
        // Verify Results
        verifyNoMoreInteractions(studentAlternativeUciRepository)
    }
    
}
