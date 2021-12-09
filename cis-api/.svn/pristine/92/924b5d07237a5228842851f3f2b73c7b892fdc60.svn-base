package uk.ac.reigate.services.ilp

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import uk.ac.reigate.domain.ilp.OfficeAction;
import uk.ac.reigate.dto.ilp.OfficeActionDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilp.OfficeActionRepository


class OfficeActionServiceTest {
    
    private OfficeActionRepository officeActionRepository
    
    private OfficeActionService officeActionService;
    
    private OfficeAction officeAction
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        this.officeActionRepository = Mockito.mock(OfficeActionRepository.class);
        this.officeActionService = new OfficeActionService(officeActionRepository);
        
        officeAction = new OfficeAction(
                id: 1,
                action: 'A'
                )
        
        when(officeActionRepository.findById(1)).thenReturn(new Optional(officeAction));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        OfficeActionService service = new OfficeActionService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<OfficeAction> result = officeActionService.findAll();
        verify(officeActionRepository, times(1)).findAll()
        verifyNoMoreInteractions(officeActionRepository)
    }
    
    @Test
    public void testFindById() {
        OfficeAction result = officeActionService.findById(1);
        verify(officeActionRepository, times(1)).findById(1)
        verifyNoMoreInteractions(officeActionRepository)
    }
    
    @Test
    public void testSave() {
        OfficeAction savedOfficeAction = officeActionService.save(officeAction);
        verify(officeActionRepository, times(1)).save(any())
        verifyNoMoreInteractions(officeActionRepository)
    }
    
    @Test
    public void testSaveOfficeAction() {
        OfficeAction savedOfficeAction = officeActionService.save(officeAction);
        verify(officeActionRepository, times(1)).save(any())
        verifyNoMoreInteractions(officeActionRepository)
    }
    
    @Test
    public void testSaveOfficeActions() {
        List<OfficeAction> savedOfficeActions = officeActionService.saveOfficeActions([
            new OfficeAction(id : 1),
            new OfficeAction(id: 2)
        ]);
        verify(officeActionRepository, times(2)).save(any(OfficeAction.class))
        verifyNoMoreInteractions(officeActionRepository)
    }
    
    @Test
    public void testSaveOfficeActionByFields() {
        OfficeAction savedOfficeAction = officeActionService.save(officeAction);
        verify(officeActionRepository, times(1)).save(any())
        verifyNoMoreInteractions(officeActionRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        OfficeActionDto dto = new OfficeActionDto(id: 1, action:'Test')
        officeActionService.createFromDto(dto)
        verify(officeActionRepository, times(1)).save(any(OfficeAction.class))
        verifyNoMoreInteractions(officeActionRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        OfficeActionDto dto = new OfficeActionDto(id: 1, action:'Test')
        officeActionService.updateFromDto(dto)
        verify(officeActionRepository, times(1)).findById(dto.id)
        verify(officeActionRepository, times(1)).save(any(OfficeAction.class))
        verifyNoMoreInteractions(officeActionRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create officeAction from null object.")
        OfficeActionDto dto = null
        officeActionService.createFromDto(dto)
        verifyNoMoreInteractions(officeActionRepository)
    }
    
    @Test
    public void testupdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update officeAction from null object.")
        OfficeActionDto dto = null
        officeActionService.updateFromDto(dto)
        verifyNoMoreInteractions(officeActionRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        officeActionService.delete(officeAction)
        verifyNoMoreInteractions(officeActionRepository)
        assertThatExceptionOfType(InvalidOperationException.class)
    }
}

