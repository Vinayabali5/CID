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

import uk.ac.reigate.domain.academic.GCSEScore
import uk.ac.reigate.dto.GCSEScoreDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.GCSEScoreRepository


class GCSEScoreServiceTest {
    
    @Mock
    private GCSEScoreRepository gCSEScoreRepository;
    
    @InjectMocks
    private GCSEScoreService gCSEScoreService;
    
    private GCSEScore gCSEScore
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to set up the tests for the GCSEScoreService
     */
    @Before
    public void setup() {
        this.gCSEScoreRepository = Mockito.mock(GCSEScoreRepository.class);
        this.gCSEScoreService = new GCSEScoreService(gCSEScoreRepository);
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        GCSEScoreService service = new GCSEScoreService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<GCSEScore> result = gCSEScoreService.findAll();
        verify(gCSEScoreRepository, times(1)).findAll()
        verifyNoMoreInteractions(gCSEScoreRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        GCSEScore result = gCSEScoreService.findById(1);
        verify(gCSEScoreRepository, times(1)).findById(1)
        verifyNoMoreInteractions(gCSEScoreRepository)
    }
    
    @Test
    public void testFindByStudentId() {
        GCSEScore result = gCSEScoreService.findGCSEScore(19001);
        verify(gCSEScoreRepository, times(1)).findByStudentId(19001)
        verifyNoMoreInteractions(gCSEScoreRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        GCSEScore savedGCSEScore = gCSEScoreService.save(gCSEScore);
        verify(gCSEScoreRepository, times(1)).save(any())
        verifyNoMoreInteractions(gCSEScoreRepository)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        gCSEScoreService.delete(gCSEScore)
        verifyNoMoreInteractions(gCSEScoreRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}