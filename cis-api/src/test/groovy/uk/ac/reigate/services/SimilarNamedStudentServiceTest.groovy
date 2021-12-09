package uk.ac.reigate.services

import static org.mockito.Mockito.*

import static org.mockito.Mockito.*

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

import uk.ac.reigate.domain.academic.SimilarNamedStudent
import uk.ac.reigate.repositories.academic.SimilarNamedStudentRepository

class SimilarNamedStudentServiceTest {
    
    @Mock
    private SimilarNamedStudentRepository similarNamedStudentRepository
    
    @InjectMocks
    private SimilarNamedStudentService similarNamedStudentService
    
    private SimilarNamedStudent similarNamedStudent
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        this.similarNamedStudentRepository = mock(SimilarNamedStudentRepository.class)
        this.similarNamedStudentService = new SimilarNamedStudentService(similarNamedStudentRepository)
    }
    
    @Test
    public void testFindByStudentId() {
        SimilarNamedStudent result = similarNamedStudentService.findByStudentId(190001);
        verify(similarNamedStudentRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(similarNamedStudentRepository)
    }
}
