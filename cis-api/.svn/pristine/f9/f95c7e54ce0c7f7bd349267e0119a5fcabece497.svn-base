package uk.ac.reigate.services.exams.basedata

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.OptionComponent
import uk.ac.reigate.domain.exams.basedata.OptionComponentPk
import uk.ac.reigate.dto.exams.basedata.OptionComponentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.exams.basedata.OptionComponentRepository

@RunWith(MockitoJUnitRunner.class)
class OptionComponentServiceTest {
    
    @Mock
    private OptionComponentRepository optionComponentRepository
    
    @Mock
    private ExamOptionService examOptionService
    
    @Mock
    private ExamComponentService examComponentService
    
    @InjectMocks
    private OptionComponentService optionComponentService
    
    private OptionComponent optionComponent
    
    private OptionComponentPk optionComponentPk
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    OptionComponent createOptionComponent() {
        return new OptionComponent(
                examOption: new ExamOption(id: 1),
                examComponent: new ExamComponent(id: 1)
                )
    }
    
    OptionComponentDto createDto() {
        OptionComponent sampleOptionComponent = createOptionComponent()
        return new OptionComponentDto(
                examOptionId : sampleOptionComponent.examOption.id,
                examComponentId: sampleOptionComponent.examComponent.id
                )
    }
    
    @Before
    public void setup() {
        optionComponentRepository = mock(OptionComponentRepository.class);
        examOptionService = mock(ExamOptionService.class);
        examComponentService = mock(ExamComponentService.class);
        optionComponentService = new OptionComponentService(optionComponentRepository, examOptionService, examComponentService)
        optionComponent = createOptionComponent()
        //	when(optionComponentService.findOptionComponent(optionComponent.examOption.id, optionComponent.examComponent.id)).thenReturn(new Optional(new OptionComponent()));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        OptionComponentService service = new OptionComponentService()
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<OptionComponent> result = optionComponentService.findAll()
        verify(optionComponentRepository, times(1)).findAll()
        verifyNoMoreInteractions(optionComponentRepository)
    }
    
    @Test
    public void testFindById() {
        OptionComponent result = optionComponentService.findById(optionComponentPk)
        verify(optionComponentRepository, times(1)).findById(optionComponentPk)
        verifyNoMoreInteractions(optionComponentRepository)
    }
    
    @Test
    public void testFindOptionComponent() {
        OptionComponent result = optionComponentService.findOptionComponent(1, 2)
        OptionComponentPk optionComponentPk = new OptionComponentPk(1, 2)
        verify(optionComponentRepository, times(1)).findById(optionComponentPk)
        verifyNoMoreInteractions(optionComponentRepository)
    }
    
    @Test
    public void testSave() {
        OptionComponent result = optionComponentService.save(optionComponent)
        verify(optionComponentRepository, times(1)).save(optionComponent)
        verifyNoMoreInteractions(optionComponentRepository)
    }
    
    //	@Test
    //    public void testCreateFromDto() {
    //		OptionComponentDto dto = createDto()
    //		optionComponentService.createFromDto(dto)
    //		when(examOptionService.findById(dto.examOptionId)).thenReturn(null);
    //		when(examComponentService.findById(dto.examComponentId)).thenReturn(null);
    //		verify(optionComponentRepository, times(1)).save(any(OptionComponent.class))
    //		verifyNoMoreInteractions(optionComponentRepository)
    //	}
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create optionComponentDto from null object.")
        OptionComponentDto dto = null
        optionComponentService.createFromDto(dto)
        verifyNoMoreInteractions(optionComponentService)
    }
    
    @Test
    public void testDeleteByIds() {
        Boolean result = optionComponentService.deleteByIds(1, 2)
        OptionComponent optionComponent = optionComponentService.findOptionComponent(1, 2)
        optionComponent != null
        optionComponentService.delete(optionComponent)
    }
    
    @Test
    public void testDeleteByIdsNotNull() {
        Boolean result = optionComponentService.deleteByIds(1, 2)
        OptionComponent optionComponent = optionComponentService.findOptionComponent(1, 2)
        optionComponent = new OptionComponent(
                examOption: new ExamOption(id: 1),
                examComponent: new ExamComponent(id: 1)
                )
        optionComponentService.delete(optionComponent)
    }
    
    @Test
    public void testDeleteByCourseAndExamOption() {
        ExamOption examOption = new ExamOption(id: 1)
        ExamComponent examComponent = new ExamComponent(id: 1)
        Boolean result = optionComponentService.deleteByCourseAndExamOption(examOption, examComponent)
        optionComponentService.deleteByIds(examOption.id, examComponent.id)
    }
    
    @Test
    public void testDelete(){
        optionComponentService.delete(optionComponent)
        verify(optionComponentRepository, times(1)).delete(optionComponent)
        verifyNoMoreInteractions(optionComponentRepository)
    }
    
    @Test
    public void testCreateFromDto() {
        OptionComponentDto dto = createDto()
        optionComponentService.createFromDto(dto)
        verify(optionComponentRepository, times(1)).save(any(OptionComponent.class))
        verifyNoMoreInteractions(optionComponentRepository)
    }
}
