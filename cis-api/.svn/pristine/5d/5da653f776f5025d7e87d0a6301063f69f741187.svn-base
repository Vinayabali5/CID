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

import uk.ac.reigate.domain.academic.EntryQualificationType
import uk.ac.reigate.dto.EntryQualificationTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.EntryQualificationTypeRepository
import uk.ac.reigate.services.lookup.PossibleGradeSetService

class EntryQualificationTypeServiceTest {
    
    @Mock
    private EntryQualificationTypeRepository entryQualificationTypeRepository;
    
    @Mock
    private PossibleGradeSetService possibleGradeSetService;
    
    @InjectMocks
    private EntryQualificationTypeService entryQualificationTypeService;
    
    private EntryQualificationType entryQualificationType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample EntryQualificationType data object to use for the testing
     * 
     * @return a sample EntryQualificationType data object
     */
    EntryQualificationType createEntryQualificationType() {
        return new EntryQualificationType(
                id: 1,
                code: 'N',
                description: 'EntryQualification Type'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample EntryQualificationType created at setup
     * 
     * @return a EntryQualificationTypeDto object based on the sample EntryQualificationType
     */
    EntryQualificationTypeDto createDto() {
        return new EntryQualificationTypeDto(
                id: entryQualificationType.id,
                code: entryQualificationType.code,
                description: entryQualificationType.description
                )
    }
    
    /**
     * This method is used to set up the tests for the EntryQualificationTypeService
     */
    @Before
    public void setup() {
        this.entryQualificationTypeRepository = Mockito.mock(EntryQualificationTypeRepository.class);
        this.possibleGradeSetService = mock(PossibleGradeSetService.class)
        this.entryQualificationTypeService = new EntryQualificationTypeService(entryQualificationTypeRepository, possibleGradeSetService);
        
        entryQualificationType = createEntryQualificationType()
        
        when(entryQualificationTypeRepository.save(any(EntryQualificationType.class))).thenReturn(entryQualificationType);
        when(entryQualificationTypeRepository.findById(1)).thenReturn(new Optional(entryQualificationType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        EntryQualificationTypeService service = new EntryQualificationTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<EntryQualificationType> result = entryQualificationTypeService.findAll();
        verify(entryQualificationTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(entryQualificationTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        EntryQualificationType result = entryQualificationTypeService.findById(1);
        verify(entryQualificationTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(entryQualificationTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        EntryQualificationType savedEntryQualificationType = entryQualificationTypeService.save(entryQualificationType);
        verify(entryQualificationTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(entryQualificationTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<EntryQualificationType> savedEntryQualificationTypes = entryQualificationTypeService.saveEntryQualificationTypes([
            entryQualificationType,
            entryQualificationType
        ]);
        verify(entryQualificationTypeRepository, times(2)).save(entryQualificationType)
        verifyNoMoreInteractions(entryQualificationTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        EntryQualificationTypeDto dto = createDto()
        EntryQualificationType entryQualificationTypeSaved = entryQualificationTypeService.createFromDto(dto)
        verify(entryQualificationTypeRepository, times(1)).save(any(EntryQualificationType.class))
        verifyNoMoreInteractions(entryQualificationTypeRepository)
        assertEquals(dto.id, entryQualificationType.id)
        assertEquals(dto.code, entryQualificationType.code)
        assertEquals(dto.description, entryQualificationType.description)
    }
    
    @Test
    public void testCreateFromDto_withPossibleGradeSet() {
        EntryQualificationTypeDto dto = createDto()
        dto.possibleGradeSetId = 1
        when(possibleGradeSetService.findById(dto.possibleGradeSetId)).thenReturn(null)
        EntryQualificationType entryQualificationSaved = entryQualificationTypeService.createFromDto(dto)
        verify(entryQualificationTypeRepository, times(1)).save(any(EntryQualificationType))
        verifyNoMoreInteractions(entryQualificationTypeRepository)
    }
    
    @Test
    public void testUpdateFromDto_possibleGradeSet() {
        EntryQualificationTypeDto dto = createDto()
        dto.possibleGradeSetId = 1
        when(possibleGradeSetService.findById(dto.possibleGradeSetId)).thenReturn(null);
        EntryQualificationType entryQualificationTypeSaved = entryQualificationTypeService.updateFromDto(dto)
        verify(possibleGradeSetService, times(1)).findById(dto.possibleGradeSetId)
        verifyNoMoreInteractions(possibleGradeSetService)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create entryQualificationTypeDto from null object.")
        EntryQualificationTypeDto dto = null
        entryQualificationTypeService.createFromDto(dto)
        verifyNoMoreInteractions(entryQualificationTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        EntryQualificationTypeDto dto = createDto()
        EntryQualificationType entryQualificationTypeSaved = entryQualificationTypeService.updateFromDto(dto)
        verify(entryQualificationTypeRepository, times(1)).findById(entryQualificationType.id)
        verify(entryQualificationTypeRepository, times(1)).save(entryQualificationType)
        verifyNoMoreInteractions(entryQualificationTypeRepository)
        assertEquals(entryQualificationType.id, entryQualificationTypeSaved.id)
        assertEquals(entryQualificationType.code, entryQualificationTypeSaved.code)
        assertEquals(entryQualificationType.description, entryQualificationTypeSaved.description)
    }
    
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update entryQualificationTypeDto from null object.")
        EntryQualificationTypeDto dto = null
        entryQualificationTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(entryQualificationTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        entryQualificationTypeService.delete(entryQualificationType)
        verifyNoMoreInteractions(entryQualificationTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}