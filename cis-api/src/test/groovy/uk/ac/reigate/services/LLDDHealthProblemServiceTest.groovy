package uk.ac.reigate.services

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import uk.ac.reigate.domain.ilr.LLDDHealthProblem;
import uk.ac.reigate.dto.LLDDHealthProblemDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.ilr.LLDDHealthProblemRepository


class LLDDHealthProblemServiceTest {
    
    private LLDDHealthProblemRepository lLDDHealthProblemRepository;
    
    private LLDDHealthProblemService lLDDHealthProblemService;
    
    private LLDDHealthProblem lLDDHealthProblem;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        this.lLDDHealthProblemRepository = Mockito.mock(LLDDHealthProblemRepository.class)
        this.lLDDHealthProblemService = new LLDDHealthProblemService(lLDDHealthProblemRepository);
        
        lLDDHealthProblem = new LLDDHealthProblem(
                id: 1,
                code: 'N',
                description: 'New',
                shortDescription: 'New',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/11/11'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2016/11/11')
                )
        
        when(lLDDHealthProblemRepository.findById(1)).thenReturn(new Optional(lLDDHealthProblem));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        LLDDHealthProblemService service = new LLDDHealthProblemService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindLLDDHealthProblems() {
        List<LLDDHealthProblem> result = lLDDHealthProblemService.findAll();
        verify(lLDDHealthProblemRepository, times(1)).findAll()
        verifyNoMoreInteractions(lLDDHealthProblemRepository)
    }
    
    @Test
    public void testFindLLDDHealthProblem() {
        LLDDHealthProblem result = lLDDHealthProblemService.findById(1);
        verify(lLDDHealthProblemRepository, times(1)).findById(1)
        verifyNoMoreInteractions(lLDDHealthProblemRepository)
    }
    
    @Test
    public void testFindByShortDescription() {
        LLDDHealthProblem result = lLDDHealthProblemService.findByShortDescription('Test');
        verify(lLDDHealthProblemRepository, times(1)).findByShortDescription('Test')
        verifyNoMoreInteractions(lLDDHealthProblemRepository)
    }
    
    @Test
    public void testSaveNewLLDDHealthProblem() {
        LLDDHealthProblem savedLLDDHealthProblem = lLDDHealthProblemService.save(lLDDHealthProblem);
        verify(lLDDHealthProblemRepository, times(1)).save(any())
        verifyNoMoreInteractions(lLDDHealthProblemRepository)
    }
    
    @Test
    public void testSaveLLDDHealthProblem() {
        LLDDHealthProblem savedLLDDHealthProblem = lLDDHealthProblemService.save(lLDDHealthProblem);
        verify(lLDDHealthProblemRepository, times(1)).save(any())
        verifyNoMoreInteractions(lLDDHealthProblemRepository)
    }
    
    @Test
    public void testSaveLLDDHealthProblems() {
        List<LLDDHealthProblem> savedLLDDHealthProblems = lLDDHealthProblemService.saveLLDDHealthProblems([
            new LLDDHealthProblem(id: 1),
            new LLDDHealthProblem(id: 2)
        ]);
        verify(lLDDHealthProblemRepository, times(2)).save(any(LLDDHealthProblem.class))
        verifyNoMoreInteractions(lLDDHealthProblemRepository)
    }
    
    @Test
    public void testSaveLLDDHealthProblemByFields() {
        LLDDHealthProblem savedLLDDHealthProblem = lLDDHealthProblemService.save(lLDDHealthProblem);
        verify(lLDDHealthProblemRepository, times(1)).save(any())
        verifyNoMoreInteractions(lLDDHealthProblemRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        LLDDHealthProblemDto dto = new LLDDHealthProblemDto(id: 1, code: 'A')
        lLDDHealthProblemService.createFromDto(dto)
        verify(lLDDHealthProblemRepository, times(1)).save(any(LLDDHealthProblem.class))
        verifyNoMoreInteractions(lLDDHealthProblemRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        LLDDHealthProblemDto dto = new LLDDHealthProblemDto(id: 1, code: 'A')
        lLDDHealthProblemService.updateFromDto(dto)
        verify(lLDDHealthProblemRepository, times(1)).findById(lLDDHealthProblem.id)
        verify(lLDDHealthProblemRepository, times(1)).save(lLDDHealthProblem)
        verifyNoMoreInteractions(lLDDHealthProblemRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create lLDDHealthProblem from null object.")
        LLDDHealthProblemDto dto = null
        lLDDHealthProblemService.createFromDto(dto)
        verifyNoMoreInteractions(lLDDHealthProblemRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update lLDDHealthProblem from null object.")
        LLDDHealthProblemDto dto = null
        lLDDHealthProblemService.updateFromDto(dto)
        verifyNoMoreInteractions(lLDDHealthProblemRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("LLDDHealthProblem should not be deleted")
        lLDDHealthProblemService.delete(new LLDDHealthProblem(id: 1))
    }
}

