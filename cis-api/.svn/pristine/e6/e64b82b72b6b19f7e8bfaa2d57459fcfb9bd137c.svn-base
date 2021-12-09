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

import uk.ac.reigate.domain.ilp.CorrespondenceType
import uk.ac.reigate.dto.lookup.CorrespondenceTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilp.CorrespondenceTypeRepository


class CorrespondenceTypeServiceTest {
    
    @Mock
    private CorrespondenceTypeRepository correspondenceTypeRepository;
    
    @InjectMocks
    private CorrespondenceTypeService correspondenceTypeService;
    
    private CorrespondenceType correspondenceType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample CorrespondenceType data object to use for the testing
     * 
     * @return a sample CorrespondenceType data object
     */
    CorrespondenceType createCorrespondenceType() {
        return new CorrespondenceType(
                id: 1,
                type: 't'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample CorrespondenceType created at setup
     * 
     * @return a CorrespondenceTypeDto object based on the sample CorrespondenceType
     */
    CorrespondenceTypeDto createDto() {
        return new CorrespondenceTypeDto(
                id: correspondenceType.id,
                type: correspondenceType.type
                )
    }
    
    /**
     * This method is used to set up the tests for the CorrespondenceTypeService
     */
    @Before
    public void setup() {
        this.correspondenceTypeRepository = Mockito.mock(CorrespondenceTypeRepository.class);
        this.correspondenceTypeService = new CorrespondenceTypeService(correspondenceTypeRepository);
        
        correspondenceType = createCorrespondenceType()
        
        when(correspondenceTypeRepository.save(any(CorrespondenceType.class))).thenReturn(correspondenceType);
        when(correspondenceTypeRepository.findById(1)).thenReturn(new Optional(correspondenceType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        CorrespondenceTypeService service = new CorrespondenceTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<CorrespondenceType> result = correspondenceTypeService.findAll();
        verify(correspondenceTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(correspondenceTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        CorrespondenceType result = correspondenceTypeService.findById(1);
        verify(correspondenceTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(correspondenceTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        CorrespondenceType savedCorrespondenceType = correspondenceTypeService.save(correspondenceType);
        verify(correspondenceTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(correspondenceTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<CorrespondenceType> savedCorrespondenceTypes = correspondenceTypeService.saveCorrespondenceTypes([
            correspondenceType,
            correspondenceType
        ]);
        verify(correspondenceTypeRepository, times(2)).save(correspondenceType)
        verifyNoMoreInteractions(correspondenceTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        CorrespondenceTypeDto dto = createDto()
        CorrespondenceType correspondenceTypeSaved = correspondenceTypeService.createFromDto(dto)
        verify(correspondenceTypeRepository, times(1)).save(any(CorrespondenceType.class))
        verifyNoMoreInteractions(correspondenceTypeRepository)
        assertEquals(dto.id, correspondenceType.id)
        assertEquals(dto.type, correspondenceType.type)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create CorrespondenceType from null object.")
        CorrespondenceTypeDto dto = null
        correspondenceTypeService.createFromDto(dto)
        verifyNoMoreInteractions(correspondenceTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        CorrespondenceTypeDto dto = createDto()
        CorrespondenceType correspondenceTypeSaved = correspondenceTypeService.updateFromDto(dto)
        verify(correspondenceTypeRepository, times(1)).findById(correspondenceType.id)
        verify(correspondenceTypeRepository, times(1)).save(correspondenceType)
        verifyNoMoreInteractions(correspondenceTypeRepository)
        assertEquals(correspondenceType.id, correspondenceTypeSaved.id)
        assertEquals(correspondenceType.type, correspondenceTypeSaved.type)
    }
    
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update CorrespondenceType from null object.")
        CorrespondenceTypeDto dto = null
        correspondenceTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(correspondenceTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        correspondenceTypeService.delete(correspondenceType)
        verifyNoMoreInteractions(correspondenceTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}