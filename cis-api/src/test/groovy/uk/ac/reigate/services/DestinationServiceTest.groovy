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

import uk.ac.reigate.domain.ilr.Destination
import uk.ac.reigate.dto.DestinationDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.DestinationRepository
import uk.ac.reigate.util.exception.IdMissingException


class DestinationServiceTest {
    
    @Mock
    private DestinationRepository destinationRepository;
    
    @InjectMocks
    private DestinationService destinationService;
    
    private Destination destination
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    /**
     * This method is used to create a sample Destination data object to use for the testing
     *
     * @return a sample Destination data object
     */
    Destination createDestination() {
        return new Destination(
                id: 99,
                code: 'G',
                description: 'Good'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample destination created at setup
     *
     * @return a destinationDto object based on the sample destination
     */
    DestinationDto createDto() {
        return new DestinationDto(
                id: destination.id,
                code: destination.code,
                description: destination.description
                )
    }
    
    /**
     * This method is used to set up the tests for the DestinationService
     */
    @Before
    public void setup() {
        this.destinationRepository = Mockito.mock(DestinationRepository.class);
        this.destinationService = new DestinationService(destinationRepository);
        
        destination = createDestination()
        
        when(destinationRepository.save(any(Destination.class))).thenReturn(destination);
        when(destinationRepository.findById(destination.id)).thenReturn(new Optional(destination));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        DestinationService service = new DestinationService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Destination> result = destinationService.findAll();
        verify(destinationRepository, times(1)).findAll()
        verifyNoMoreInteractions(destinationRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Destination result = destinationService.findById(1);
        verify(destinationRepository, times(1)).findById(1)
        verifyNoMoreInteractions(destinationRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Destination savedDestination = destinationService.save(new Destination());
        verify(destinationRepository, times(1)).save(any())
        verifyNoMoreInteractions(destinationRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create destination from null object.")
        DestinationDto dto = null
        destinationService.createFromDto(dto)
        verifyNoMoreInteractions(destinationRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        DestinationDto dto = new DestinationDto(id: 1, code: '123', description: '123')
        destinationService.createFromDto(dto)
        verify(destinationRepository, times(1)).save(any(Destination.class))
        verifyNoMoreInteractions(destinationRepository)
    }
    
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        DestinationDto dto = createDto()
        destinationService.updateFromDto(dto)
        verify(destinationRepository, times(1)).findById(destination.id)
        verify(destinationRepository, times(1)).save(any(Destination.class))
        verifyNoMoreInteractions(destinationRepository)
        assertEquals(dto.id, destination.id)
    }
    
    /**
     * This method is used to test the createFromDto service method with null dto
     */
    @Test
    public void testupdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update destination from null object.")
        DestinationDto dto = null
        destinationService.updateFromDto(dto)
        verifyNoMoreInteractions(destinationRepository)
    }
    
    /**
     * This method is used to test the delete service method.
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("Destination should not be deleted")
        destinationService.delete(new Destination(id: 1))
    }
}

