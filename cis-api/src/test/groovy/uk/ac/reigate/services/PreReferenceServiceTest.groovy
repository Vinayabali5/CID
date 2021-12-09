package uk.ac.reigate.services

import static org.mockito.Mockito.*

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.PreReference
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.repositories.academic.PreReferenceRepository

class PreReferenceServiceTest {
    
    @Mock
    PreReferenceRepository preReferenceRepository
    
    @InjectMocks
    PreReferenceService preReferenceService
    
    private PreReference preReference
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    /**
     * This method is used to create a sample PreReference data object to use for the testing
     *
     * @return a sample PreReference data object
     */
    PreReference createPreReference() {
        return new PreReference(
                student : new Student(id: 20002),
                course : new Course(id: 2)
                )
    }
    
    /**
     * This method is used to set up the tests for the PreReferenceService
     */
    @Before
    public void setup() {
        this.preReferenceRepository = mock(PreReferenceRepository.class)
        this.preReferenceService = new PreReferenceService(preReferenceRepository);
        
        preReference = createPreReference()
        
        when(preReferenceRepository.findByStudentIdAndCourseId(preReference.student.id, preReference.course.id)).thenReturn(preReference)
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        PreReferenceService service = new PreReferenceService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findByStudentIdAndCourseId service method
     */
    @Test
    public void testFindByStudentIdAndCourseId() {
        PreReference result = preReferenceService.findByStudentIdAndCourseId(200001, 1);
        verify(preReferenceRepository, times(1)).findByStudentIdAndCourseId(200001, 1)
        verifyNoMoreInteractions(preReferenceRepository)
    }
}
