package uk.ac.reigate.services.ilr

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.ilr.PriorAttainment
import uk.ac.reigate.dto.ilr.PriorAttainmentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.PriorAttainmentRepository


class PriorAttainmentServiceTest {
    
    @Mock
    private PriorAttainmentRepository priorAttainmentRepository;
    
    @InjectMocks
    private PriorAttainmentService priorAttainmentService;
    
    private PriorAttainment priorAttainment
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample PriorAttainment data object to use for the testing
     * 
     * @return a sample PriorAttainment data object
     */
    PriorAttainment createPriorAttainment() {
        return new PriorAttainment(
                id: 1,
                code: 'N',
                description: 'Aim Type',
                shortDescription: 'Test',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo : new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/19  '),
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample PriorAttainment created at setup
     * 
     * @return a PriorAttainmentDto object based on the sample PriorAttainment
     */
    PriorAttainmentDto createDto() {
        return new PriorAttainmentDto(
                id: priorAttainment.id,
                code: priorAttainment.code,
                description: priorAttainment.description,
                shortDescription: priorAttainment.shortDescription,
                validFrom: priorAttainment.validFrom,
                validTo: priorAttainment.validTo
                )
    }
    
    /**
     * This method is used to set up the tests for the PriorAttainmentService
     */
    @Before
    public void setup() {
        this.priorAttainmentRepository = Mockito.mock(PriorAttainmentRepository.class);
        this.priorAttainmentService = new PriorAttainmentService(priorAttainmentRepository);
        
        priorAttainment = createPriorAttainment()
        
        when(priorAttainmentRepository.save(any(PriorAttainment.class))).thenReturn(priorAttainment);
        when(priorAttainmentRepository.findById(1)).thenReturn(new Optional(priorAttainment));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        PriorAttainmentService service = new PriorAttainmentService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<PriorAttainment> result = priorAttainmentService.findAll();
        verify(priorAttainmentRepository, times(1)).findAll()
        verifyNoMoreInteractions(priorAttainmentRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        PriorAttainment result = priorAttainmentService.findById(1);
        verify(priorAttainmentRepository, times(1)).findById(1)
        verifyNoMoreInteractions(priorAttainmentRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        PriorAttainment savedPriorAttainment = priorAttainmentService.save(priorAttainment);
        verify(priorAttainmentRepository, times(1)).save(any())
        verifyNoMoreInteractions(priorAttainmentRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<PriorAttainment> savedPriorAttainments = priorAttainmentService.savePriorAttainments([
            priorAttainment,
            priorAttainment
        ]);
        verify(priorAttainmentRepository, times(2)).save(priorAttainment)
        verifyNoMoreInteractions(priorAttainmentRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        PriorAttainmentDto dto = createDto()
        PriorAttainment priorAttainmentSaved = priorAttainmentService.createFromDto(dto)
        verify(priorAttainmentRepository, times(1)).save(any(PriorAttainment.class))
        verifyNoMoreInteractions(priorAttainmentRepository)
        assertEquals(dto.id, priorAttainment.id)
        assertEquals(dto.code, priorAttainment.code)
        assertEquals(dto.description, priorAttainment.description)
        assertEquals(dto.shortDescription, priorAttainment.shortDescription)
        assertEquals(dto.validFrom, priorAttainment.validFrom)
        assertEquals(dto.validTo, priorAttainment.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithNullValues() {
        PriorAttainmentDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        PriorAttainment priorAttainmentSaved = priorAttainmentService.createFromDto(dto)
        verify(priorAttainmentRepository, times(1)).save(any(PriorAttainment.class))
        verifyNoMoreInteractions(priorAttainmentRepository)
        assertEquals(priorAttainment.id, priorAttainmentSaved.id)
        assertEquals(priorAttainment.code, priorAttainmentSaved.code)
        assertEquals(priorAttainment.description, priorAttainmentSaved.description)
        assertEquals(priorAttainment.shortDescription, priorAttainmentSaved.shortDescription)
        assertEquals(priorAttainment.validFrom, priorAttainmentSaved.validFrom)
        assertEquals(priorAttainment.validTo, priorAttainmentSaved.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create priorAttainment from null object.")
        PriorAttainmentDto dto = null
        priorAttainmentService.createFromDto(dto)
        verifyNoMoreInteractions(priorAttainmentRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        PriorAttainmentDto dto = createDto()
        PriorAttainment priorAttainmentSaved = priorAttainmentService.updateFromDto(dto)
        verify(priorAttainmentRepository, times(1)).findById(priorAttainment.id)
        verify(priorAttainmentRepository, times(1)).save(priorAttainment)
        verifyNoMoreInteractions(priorAttainmentRepository)
        assertEquals(priorAttainment.id, priorAttainmentSaved.id)
        assertEquals(priorAttainment.code, priorAttainmentSaved.code)
        assertEquals(priorAttainment.description, priorAttainmentSaved.description)
        assertEquals(priorAttainment.shortDescription, priorAttainmentSaved.shortDescription)
        assertEquals(priorAttainment.validFrom, priorAttainmentSaved.validFrom)
        assertEquals(priorAttainment.validTo, priorAttainmentSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        PriorAttainmentDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        PriorAttainment priorAttainmentSaved = priorAttainmentService.updateFromDto(dto)
        verify(priorAttainmentRepository, times(1)).findById(priorAttainment.id)
        verify(priorAttainmentRepository, times(1)).save(priorAttainment)
        verifyNoMoreInteractions(priorAttainmentRepository)
        assertEquals(priorAttainment.id, priorAttainmentSaved.id)
        assertEquals(priorAttainment.code, priorAttainmentSaved.code)
        assertEquals(priorAttainment.description, priorAttainmentSaved.description)
        assertEquals(priorAttainment.shortDescription, priorAttainmentSaved.shortDescription)
        assertEquals(priorAttainment.validFrom, priorAttainmentSaved.validFrom)
        assertEquals(priorAttainment.validTo, priorAttainmentSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update priorAttainment from null object.")
        PriorAttainmentDto dto = null
        priorAttainmentService.updateFromDto(dto)
        verifyNoMoreInteractions(priorAttainmentRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        priorAttainmentService.delete(priorAttainment)
        verifyNoMoreInteractions(priorAttainmentRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}