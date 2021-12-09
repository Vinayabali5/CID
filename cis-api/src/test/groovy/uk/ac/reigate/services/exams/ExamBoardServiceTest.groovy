package uk.ac.reigate.services.exams;

import static org.mockito.Mockito.*
import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.dto.exams.ExamBoardDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.exams.ExamBoardRepository


public class ExamBoardServiceTest {
    
    @Mock
    private ExamBoardRepository examBoardRepository
    
    @InjectMocks
    private ExamBoardService examBoardService;
    
    private ExamBoard examBoard
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    
    
    ExamBoard createExamBoard() {
        return new ExamBoard(
                id: 1,
                name: 'Excel',
                description: 'ExcelBtec',
                boardCode: '111',
                boardCentreNumber: '1',
                boardIdentifier: '1',
                telephoneNo:  '1828932'
                )
    }
    
    ExamBoardDto createDto() {
        ExamBoard sampleExamBoard = createExamBoard();
        return new ExamBoardDto(
                id : sampleExamBoard.id,
                name: sampleExamBoard.name,
                description: sampleExamBoard.description,
                boardCode: sampleExamBoard.boardCode,
                boardCentreNumber: sampleExamBoard.boardCentreNumber,
                boardIdentifier: sampleExamBoard.boardIdentifier,
                telephoneNo : sampleExamBoard.telephoneNo
                )
    }
    
    @Before
    public void setup() {
        this.examBoardRepository = Mockito.mock(ExamBoardRepository.class);
        this.examBoardService = new ExamBoardService(examBoardRepository);
        
        examBoard = createExamBoard()
        
        when(examBoardRepository.findById(examBoard.id)).thenReturn(new Optional(new ExamBoard()));
    }
    
    @Test
    public void testFindAll() {
        List<ExamBoard> result = examBoardService.findAll();
        verify(examBoardRepository, times(1)).findAll()
        verifyNoMoreInteractions(examBoardRepository)
    }
    
    @Test
    public void testFindById() {
        ExamBoard result = examBoardService.findById(1);
        verify(examBoardRepository, times(1)).findById(1)
        verifyNoMoreInteractions(examBoardRepository)
    }
    
    @Test
    public void testSave() {
        ExamBoard savedExamBoard = examBoardService.save(examBoard);
        verify(examBoardRepository, times(1)).save(any())
        verifyNoMoreInteractions(examBoardRepository)
    }
    
    @Test
    public void testSaveExamBoard() {
        ExamBoard savedExamBoard = examBoardService.save(examBoard);
        verify(examBoardRepository, times(1)).save(any())
        verifyNoMoreInteractions(examBoardRepository)
    }
    
    @Test
    public void testSaveExamBoards() {
        List<ExamBoard> savedExamBoards = examBoardService.saveExamBoards([
            new ExamBoard(id: 1),
            new ExamBoard(id: 2)
        ]);
        verify(examBoardRepository, times(2)).save(any(ExamBoard.class))
        verifyNoMoreInteractions(examBoardRepository)
    }
    
    @Test
    public void testCreateFromDto() {
        ExamBoardDto dto = createDto()
        examBoardService.createFromDto(dto)
        verify(examBoardRepository, times(1)).save(any(ExamBoard.class))
        verifyNoMoreInteractions(examBoardRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create examBoardDto from null object.")
        ExamBoardDto dto = null
        examBoardService.createFromDto(dto)
        verifyNoMoreInteractions(examBoardRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        ExamBoardDto dto = createDto()
        examBoardService.updateFromDto(dto)
        when(examBoardService.findById(dto.id)).thenReturn(null);
        verify(examBoardRepository, times(1)).save(any(ExamBoard.class))
    }
    
    @Test
    public void testUpdateFromDto_withDtoWithNoId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update examBoardDto from null object.");
        // Initialise Test
        ExamBoardDto dto = null
        examBoardService.updateFromDto(dto)
        // Verify Results
        verifyNoMoreInteractions(examBoardRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("ExamBoard should not be deleted");
        examBoardService.delete(examBoard)
        verifyNoMoreInteractions(examBoardRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    @Test
    public void testFindByBoardIdentifier() {
        ExamBoard result = examBoardService.findByBoardIdentifier('AQA');
        verify(examBoardRepository, times(1)).findByBoardIdentifier('AQA')
        verifyNoMoreInteractions(examBoardRepository)
    }
}
