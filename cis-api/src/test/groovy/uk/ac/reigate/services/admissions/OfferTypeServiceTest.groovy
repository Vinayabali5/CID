package uk.ac.reigate.services.admissions

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import static org.junit.Assert.assertEquals

import uk.ac.reigate.domain.admissions.OfferType
import uk.ac.reigate.dto.admissions.OfferTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.admissions.OfferTypeRepository
import uk.ac.reigate.services.admissions.OfferTypeService

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*


class OfferTypeServiceTest {
    
    @Mock
    private OfferTypeRepository offerTypeRepository;
    
    @InjectMocks
    private OfferTypeService offerTypeService;
    
    private OfferType offerType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample OfferType data object to use for the testing
     * 
     * @return a sample OfferType data object
     */
    OfferType createOfferType() {
        return new OfferType(
                id: 1,
                code: 'N',
                description: 'Normal Offer Type',
                considerAsEnrolling: true,
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample OfferType created at setup
     * 
     * @return a OfferTypeDto object based on the sample OfferType
     */
    OfferTypeDto createDto() {
        return new OfferTypeDto(
                id: offerType.id,
                code: offerType.code,
                description: offerType.description,
                considerAsEnrolling: offerType.considerAsEnrolling
                )
    }
    
    /**
     * This method is used to set up the tests for the OfferTypeService
     */
    @Before
    public void setup() {
        this.offerTypeRepository = Mockito.mock(OfferTypeRepository.class);
        this.offerTypeService = new OfferTypeService(offerTypeRepository);
        
        offerType = createOfferType()
        
        when(offerTypeRepository.save(any(OfferType.class))).thenReturn(offerType);
        when(offerTypeRepository.findById(1)).thenReturn(new Optional(offerType));
        when(offerTypeRepository.findByDescription(offerType.description)).thenReturn(offerType);
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        OfferTypeService service = new OfferTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<OfferType> result = offerTypeService.findAll();
        verify(offerTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(offerTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        OfferType result = offerTypeService.findById(1);
        verify(offerTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(offerTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        OfferType savedOfferType = offerTypeService.save(offerType);
        verify(offerTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(offerTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<OfferType> savedOfferTypes = offerTypeService.saveList([offerType, offerType]);
        verify(offerTypeRepository, times(2)).save(offerType)
        verifyNoMoreInteractions(offerTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        OfferTypeDto dto = createDto()
        OfferType offerTypeSaved = offerTypeService.createFromDto(dto)
        verify(offerTypeRepository, times(1)).save(any(OfferType.class))
        verifyNoMoreInteractions(offerTypeRepository)
        assertEquals(dto.id, offerType.id)
        assertEquals(dto.code, offerType.code)
        assertEquals(dto.description, offerType.description)
        assertEquals(dto.considerAsEnrolling, offerType.considerAsEnrolling)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create offerTypeDto from null object.")
        OfferTypeDto dto = null
        offerTypeService.createFromDto(dto)
        verifyNoMoreInteractions(offerTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        OfferTypeDto dto = createDto()
        OfferType offerTypeSaved = offerTypeService.updateFromDto(dto)
        verify(offerTypeRepository, times(1)).findById(offerType.id)
        verify(offerTypeRepository, times(1)).save(offerType)
        verifyNoMoreInteractions(offerTypeRepository)
        assertEquals(offerType.id, offerTypeSaved.id)
        assertEquals(offerType.code, offerTypeSaved.code)
        assertEquals(offerType.description, offerTypeSaved.description)
        assertEquals(offerType.considerAsEnrolling, offerTypeSaved.considerAsEnrolling)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        OfferTypeDto dto = createDto()
        dto.code = null
        dto.description = null
        OfferType offerTypeSaved = offerTypeService.updateFromDto(dto)
        verify(offerTypeRepository, times(1)).findById(offerType.id)
        verify(offerTypeRepository, times(1)).save(offerType)
        verifyNoMoreInteractions(offerTypeRepository)
        assertEquals(offerType.id, offerTypeSaved.id)
        assertEquals(offerType.code, offerTypeSaved.code)
        assertEquals(offerType.description, offerTypeSaved.description)
        assertEquals(offerType.considerAsEnrolling, offerTypeSaved.considerAsEnrolling)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update offerTypeDto from null object.")
        OfferTypeDto dto = null
        offerTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(offerTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        offerTypeService.delete(offerType)
        verifyNoMoreInteractions(offerTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the findByDescription service method
     */
    @Test
    public void testFindByDescription() {
        OfferType result = offerTypeService.findByDescription(offerType.description)
        verify(offerTypeRepository, times(1)).findByDescription(offerType.description)
        verifyNoMoreInteractions(offerTypeRepository)
    }
}

