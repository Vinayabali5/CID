package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.academic.WorkPlacementMode
import uk.ac.reigate.dto.WorkPlacementModeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.WorkPlacementModeRepository


class WorkPlacementModeServiceTest {
    
    @Mock
    private WorkPlacementModeRepository workPlacementModeRepository;
    
    @InjectMocks
    private WorkPlacementModeService workPlacementModeService;
    
    private WorkPlacementMode workPlacementMode
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample WorkPlacementMode data object to use for the testing
     * 
     * @return a sample WorkPlacementMode data object
     */
    WorkPlacementMode createWorkPlacementMode() {
        return new WorkPlacementMode(
                id: 1,
                code: '1',
                description: 'WorkPlacementMode 1'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample WorkPlacementMode created at setup
     * 
     * @return a WorkPlacementModeDto object based on the sample WorkPlacementMode
     */
    WorkPlacementModeDto createDto() {
        return new WorkPlacementModeDto(
                id: workPlacementMode.id,
                code: workPlacementMode.code,
                description: workPlacementMode.description
                )
    }
    
    /**
     * This method is used to set up the tests for the WorkPlacementModeService
     */
    @Before
    public void setup() {
        this.workPlacementModeRepository = Mockito.mock(WorkPlacementModeRepository.class);
        this.workPlacementModeService = new WorkPlacementModeService(workPlacementModeRepository);
        
        workPlacementMode = createWorkPlacementMode()
        
        when(workPlacementModeRepository.save(any(WorkPlacementMode.class))).thenReturn(workPlacementMode);
        when(workPlacementModeRepository.findById(1)).thenReturn(new Optional(workPlacementMode));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        WorkPlacementModeService service = new WorkPlacementModeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<WorkPlacementMode> result = workPlacementModeService.findAll();
        verify(workPlacementModeRepository, times(1)).findAll()
        verifyNoMoreInteractions(workPlacementModeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        WorkPlacementMode result = workPlacementModeService.findById(1);
        verify(workPlacementModeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(workPlacementModeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        WorkPlacementMode savedWorkPlacementMode = workPlacementModeService.save(workPlacementMode);
        verify(workPlacementModeRepository, times(1)).save(any())
        verifyNoMoreInteractions(workPlacementModeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<WorkPlacementMode> savedWorkPlacementModes = workPlacementModeService.saveWorkPlacementModes([
            workPlacementMode,
            workPlacementMode
        ]);
        verify(workPlacementModeRepository, times(2)).save(workPlacementMode)
        verifyNoMoreInteractions(workPlacementModeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        WorkPlacementModeDto dto = createDto()
        WorkPlacementMode workPlacementModeSaved = workPlacementModeService.createFromDto(dto)
        verify(workPlacementModeRepository, times(1)).save(any(WorkPlacementMode.class))
        verifyNoMoreInteractions(workPlacementModeRepository)
        assertEquals(dto.id, workPlacementMode.id)
        assertEquals(dto.code, workPlacementMode.code)
        assertEquals(dto.description, workPlacementMode.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create workPlacementModeDto from null object.")
        WorkPlacementModeDto dto = null
        workPlacementModeService.createFromDto(dto)
        verifyNoMoreInteractions(workPlacementModeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        WorkPlacementModeDto dto = createDto()
        WorkPlacementMode workPlacementModeSaved = workPlacementModeService.updateFromDto(dto)
        verify(workPlacementModeRepository, times(1)).findById(workPlacementMode.id)
        verify(workPlacementModeRepository, times(1)).save(workPlacementMode)
        verifyNoMoreInteractions(workPlacementModeRepository)
        assertEquals(workPlacementMode.id, workPlacementModeSaved.id)
        assertEquals(workPlacementMode.code, workPlacementModeSaved.code)
        assertEquals(workPlacementMode.description, workPlacementModeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        WorkPlacementModeDto dto = createDto()
        WorkPlacementMode workPlacementModeSaved = workPlacementModeService.updateFromDto(dto)
        verify(workPlacementModeRepository, times(1)).findById(workPlacementMode.id)
        verify(workPlacementModeRepository, times(1)).save(workPlacementMode)
        verifyNoMoreInteractions(workPlacementModeRepository)
        assertEquals(workPlacementMode.id, workPlacementModeSaved.id)
        assertEquals(workPlacementMode.code, workPlacementModeSaved.code)
        assertEquals(workPlacementMode.description, workPlacementModeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update workPlacementModeDto from null object.")
        WorkPlacementModeDto dto = null
        workPlacementModeService.updateFromDto(dto)
        verifyNoMoreInteractions(workPlacementModeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        workPlacementModeService.delete(workPlacementMode)
        verifyNoMoreInteractions(workPlacementModeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}