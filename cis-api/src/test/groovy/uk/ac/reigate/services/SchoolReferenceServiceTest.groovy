package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.academic.SchoolReference
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.SchoolReferenceDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.SchoolReferenceRepository
import uk.ac.reigate.services.lookup.PossibleGradeSetService

class SchoolReferenceServiceTest {
    
    @Mock
    private SchoolReferenceRepository schoolReferenceRepository;
    
    @InjectMocks
    private SchoolReferenceService schoolReferenceService;
    
    private SchoolReference schoolReference
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample SchoolReference data object to use for the testing
     * 
     * @return a sample SchoolReference data object
     */
    SchoolReference createSchoolReference() {
        return new SchoolReference(
                student: new Student(id: 190001),
                meetingTargets: 1,
                effort: 1
                )
    }
    
    /**
     * This method is used to set up the tests for the SchoolReferenceService
     */
    @Before
    public void setup() {
        this.schoolReferenceRepository = Mockito.mock(SchoolReferenceRepository.class);
        this.schoolReferenceService = new SchoolReferenceService(schoolReferenceRepository);
        
        schoolReference = createSchoolReference()
        
        when(schoolReferenceRepository.save(any(SchoolReference.class))).thenReturn(schoolReference);
        when(schoolReferenceRepository.findById(1)).thenReturn(new Optional(schoolReference));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        SchoolReferenceService service = new SchoolReferenceService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindSchoolReference() {
        SchoolReference result = schoolReferenceService.findSchoolReference(190001)
        verify(schoolReferenceRepository, times(1)).findByStudentId(190001)
        verifyNoMoreInteractions(schoolReferenceRepository)
    }
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<SchoolReference> result = schoolReferenceService.findAll();
        verify(schoolReferenceRepository, times(1)).findAll()
        verifyNoMoreInteractions(schoolReferenceRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        SchoolReference result = schoolReferenceService.findById(1);
        verify(schoolReferenceRepository, times(1)).findById(1)
        verifyNoMoreInteractions(schoolReferenceRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        SchoolReference savedSchoolReference = schoolReferenceService.save(schoolReference);
        verify(schoolReferenceRepository, times(1)).save(any())
        verifyNoMoreInteractions(schoolReferenceRepository)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        schoolReferenceService.delete(schoolReference)
        verifyNoMoreInteractions(schoolReferenceRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}