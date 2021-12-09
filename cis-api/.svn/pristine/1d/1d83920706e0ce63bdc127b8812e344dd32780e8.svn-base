package uk.ac.reigate.services

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

import uk.ac.reigate.domain.admissions.CollegeFundPaid
import uk.ac.reigate.dto.CollegeFundPaidDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.admissions.CollegeFundPaidRepository


class CollegeFundPaidServiceTest {
    
    @Mock
    private CollegeFundPaidRepository collegeFundPaidRepository;
    
    @InjectMocks
    private CollegeFundPaidService collegeFundPaidService;
    
    private CollegeFundPaid collegeFundPaid
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    /**
     * This method is used to create a sample CollegeFundPaid data object to use for the testing
     *
     * @return a sample CollegeFundPaid data object
     */
    CollegeFundPaid createCollegeFundPaid() {
        return new CollegeFundPaid(
                id: 99,
                collegeFundPaid: 'G'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample collegeFundPaid created at setup
     *
     * @return a collegeFundPaidDto object based on the sample collegeFundPaid
     */
    CollegeFundPaidDto createDto() {
        return new CollegeFundPaidDto(
                id: collegeFundPaid.id,
                collegeFundPaid: collegeFundPaid.collegeFundPaid
                )
    }
    
    /**
     * This method is used to set up the tests for the CollegeFundPaidService
     */
    @Before
    public void setup() {
        this.collegeFundPaidRepository = Mockito.mock(CollegeFundPaidRepository.class);
        this.collegeFundPaidService = new CollegeFundPaidService(collegeFundPaidRepository);
        
        collegeFundPaid = createCollegeFundPaid()
        
        when(collegeFundPaidRepository.save(any(CollegeFundPaid.class))).thenReturn(collegeFundPaid);
        when(collegeFundPaidRepository.findById(collegeFundPaid.id)).thenReturn(new Optional(collegeFundPaid));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        CollegeFundPaidService service = new CollegeFundPaidService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<CollegeFundPaid> result = collegeFundPaidService.findAll();
        verify(collegeFundPaidRepository, times(1)).findAll()
        verifyNoMoreInteractions(collegeFundPaidRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        CollegeFundPaid result = collegeFundPaidService.findById(1);
        verify(collegeFundPaidRepository, times(1)).findById(1)
        verifyNoMoreInteractions(collegeFundPaidRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        CollegeFundPaid savedCollegeFundPaid = collegeFundPaidService.save(new CollegeFundPaid());
        verify(collegeFundPaidRepository, times(1)).save(any())
        verifyNoMoreInteractions(collegeFundPaidRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveCollegeFundPaids() {
        List<CollegeFundPaid> savedCollegeFundPaids = collegeFundPaidService.saveCollegeFundPaids([
            new CollegeFundPaid(id: 1),
            new CollegeFundPaid(id: 2)
        ]);
        verify(collegeFundPaidRepository, times(2)).save(any(CollegeFundPaid.class))
        verifyNoMoreInteractions(collegeFundPaidRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create collegeFundPaid from null object.")
        CollegeFundPaidDto dto = null
        collegeFundPaidService.createFromDto(dto)
        verifyNoMoreInteractions(collegeFundPaidRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        CollegeFundPaidDto dto = new CollegeFundPaidDto(id: 1, collegeFundPaid: '123')
        collegeFundPaidService.createFromDto(dto)
        verify(collegeFundPaidRepository, times(1)).save(any(CollegeFundPaid.class))
        verifyNoMoreInteractions(collegeFundPaidRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        CollegeFundPaidDto dto = createDto()
        collegeFundPaidService.updateFromDto(dto)
        verify(collegeFundPaidRepository, times(1)).findById(collegeFundPaid.id)
        verify(collegeFundPaidRepository, times(1)).save(any(CollegeFundPaid.class))
        verifyNoMoreInteractions(collegeFundPaidRepository)
        assertEquals(dto.id, collegeFundPaid.id)
    }
    
    /**
     * This method is used to test the createFromDto service method with null dto
     */
    @Test
    public void testupdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update CollegeFundPaid from null object.")
        CollegeFundPaidDto dto = null
        collegeFundPaidService.updateFromDto(dto)
        verifyNoMoreInteractions(collegeFundPaidRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method with null Id
     */
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update CollegeFundPaid when the ID is null.")
        CollegeFundPaidDto dto = new CollegeFundPaidDto(collegeFundPaid: '123')
        collegeFundPaidService.updateFromDto(dto)
        verifyNoMoreInteractions(collegeFundPaidRepository)
    }
    
    /**
     * This method is used to test the delete service method.
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("CollegeFundPaid should not be deleted.")
        collegeFundPaidService.delete(new CollegeFundPaid(id: 1))
    }
}

