package uk.ac.reigate.services.lookup

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

import uk.ac.reigate.domain.learning_support.ConcessionType
import uk.ac.reigate.dto.lookup.ConcessionTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.ConcessionTypeRepository


class ConcessionTypeServiceTest {
    
    @Mock
    private ConcessionTypeRepository concessionTypeRepository;
    
    @InjectMocks
    private ConcessionTypeService concessionTypeService;
    
    private ConcessionType concessionType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample ConcessionType data object to use for the testing
     * 
     * @return a sample ConcessionType data object
     */
    ConcessionType createConcessionType() {
        return new ConcessionType(
                id: 1,
                code: 'SmRm',
                description: 'Small Room',
                inUse: true,
                onExamTimetable : true
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample ConcessionType created at setup
     * 
     * @return a ConcessionTypeDto object based on the sample ConcessionType
     */
    ConcessionTypeDto createDto() {
        return new ConcessionTypeDto(
                id: concessionType.id,
                code: concessionType.code,
                description: concessionType.description,
                inUse: concessionType.inUse,
                onExamTimetable: concessionType.onExamTimetable
                )
    }
    
    /**
     * This method is used to set up the tests for the ConcessionTypeService
     */
    @Before
    public void setup() {
        this.concessionTypeRepository = Mockito.mock(ConcessionTypeRepository.class);
        this.concessionTypeService = new ConcessionTypeService(concessionTypeRepository);
        
        concessionType = createConcessionType()
        
        when(concessionTypeRepository.save(any(ConcessionType.class))).thenReturn(concessionType);
        when(concessionTypeRepository.findById(1)).thenReturn(new Optional(concessionType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        ConcessionTypeService service = new ConcessionTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<ConcessionType> result = concessionTypeService.findAll();
        verify(concessionTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(concessionTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        ConcessionType result = concessionTypeService.findById(1);
        verify(concessionTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(concessionTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        ConcessionType savedConcessionType = concessionTypeService.save(concessionType);
        verify(concessionTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(concessionTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<ConcessionType> savedConcessionTypes = concessionTypeService.saveConcessionTypes([
            concessionType,
            concessionType
        ]);
        verify(concessionTypeRepository, times(2)).save(concessionType)
        verifyNoMoreInteractions(concessionTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        ConcessionTypeDto dto = createDto()
        ConcessionType concessionTypeSaved = concessionTypeService.createFromDto(dto)
        verify(concessionTypeRepository, times(1)).save(any(ConcessionType.class))
        verifyNoMoreInteractions(concessionTypeRepository)
        assertEquals(dto.id, concessionType.id)
        assertEquals(dto.code, concessionType.code)
        assertEquals(dto.description, concessionType.description)
        assertEquals(dto.inUse, concessionType.inUse)
        assertEquals(dto.onExamTimetable, concessionType.onExamTimetable)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create concessionType from null object.")
        ConcessionTypeDto dto = null
        concessionTypeService.createFromDto(dto)
        verifyNoMoreInteractions(concessionTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        ConcessionTypeDto dto = createDto()
        ConcessionType concessionTypeSaved = concessionTypeService.updateFromDto(dto)
        verify(concessionTypeRepository, times(1)).findById(concessionType.id)
        verify(concessionTypeRepository, times(1)).save(concessionType)
        verifyNoMoreInteractions(concessionTypeRepository)
        assertEquals(concessionType.id, concessionTypeSaved.id)
        assertEquals(concessionType.code, concessionTypeSaved.code)
        assertEquals(concessionType.description, concessionTypeSaved.description)
        assertEquals(concessionType.inUse, concessionTypeSaved.inUse)
        assertEquals(concessionType.onExamTimetable, concessionTypeSaved.onExamTimetable)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        ConcessionTypeDto dto = createDto()
        ConcessionType concessionTypeSaved = concessionTypeService.updateFromDto(dto)
        verify(concessionTypeRepository, times(1)).findById(concessionType.id)
        verify(concessionTypeRepository, times(1)).save(concessionType)
        verifyNoMoreInteractions(concessionTypeRepository)
        assertEquals(concessionType.id, concessionTypeSaved.id)
        assertEquals(concessionType.code, concessionTypeSaved.code)
        assertEquals(concessionType.description, concessionTypeSaved.description)
        assertEquals(concessionType.inUse, concessionTypeSaved.inUse)
        assertEquals(concessionType.onExamTimetable, concessionTypeSaved.onExamTimetable)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update concessionType from null object.")
        ConcessionTypeDto dto = null
        concessionTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(concessionTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        concessionTypeService.delete(concessionType)
        verifyNoMoreInteractions(concessionTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}