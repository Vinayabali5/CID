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

import uk.ac.reigate.domain.lookup.Subject
import uk.ac.reigate.dto.lookup.SubjectDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.SubjectRepository

class SubjectServiceTest {
    
    @Mock
    private SubjectRepository subjectRepository;
    
    @InjectMocks
    private SubjectService subjectService;
    
    private Subject subject
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample Subject data object to use for the testing
     * 
     * @return a sample Subject data object
     */
    Subject createSubject() {
        return new Subject(
                id: 1,
                code: '1',
                description: 'Maths'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample Subject created at setup
     * 
     * @return a SubjectDto object based on the sample Subject
     */
    SubjectDto createDto() {
        return new SubjectDto(
                id: subject.id,
                code: subject.code,
                description: subject.description
                )
    }
    
    /**
     * This method is used to set up the tests for the SubjectService
     */
    @Before
    public void setup() {
        this.subjectRepository = Mockito.mock(SubjectRepository.class);
        this.subjectService = new SubjectService(subjectRepository);
        
        subject = createSubject()
        
        when(subjectRepository.save(any(Subject.class))).thenReturn(subject);
        when(subjectRepository.findById(1)).thenReturn(new Optional(subject));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        SubjectService service = new SubjectService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Subject> result = subjectService.findAll();
        verify(subjectRepository, times(1)).findAll()
        verifyNoMoreInteractions(subjectRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Subject result = subjectService.findById(1);
        verify(subjectRepository, times(1)).findById(1)
        verifyNoMoreInteractions(subjectRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Subject savedSubject = subjectService.save(subject);
        verify(subjectRepository, times(1)).save(any())
        verifyNoMoreInteractions(subjectRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Subject> savedSubjects = subjectService.saveSubjects([subject, subject]);
        verify(subjectRepository, times(2)).save(subject)
        verifyNoMoreInteractions(subjectRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        SubjectDto dto = createDto()
        Subject subjectSaved = subjectService.createFromDto(dto)
        verify(subjectRepository, times(1)).save(any(Subject.class))
        verifyNoMoreInteractions(subjectRepository)
        assertEquals(dto.id, subject.id)
        assertEquals(dto.code, subject.code)
        assertEquals(dto.description, subject.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create subjectDto from null object.")
        SubjectDto dto = null
        subjectService.createFromDto(dto)
        verifyNoMoreInteractions(subjectRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        SubjectDto dto = createDto()
        Subject subjectSaved = subjectService.updateFromDto(dto)
        verify(subjectRepository, times(1)).findById(subject.id)
        verify(subjectRepository, times(1)).save(subject)
        verifyNoMoreInteractions(subjectRepository)
        assertEquals(subject.id, subjectSaved.id)
        assertEquals(subject.code, subjectSaved.code)
        assertEquals(subject.description, subjectSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        SubjectDto dto = createDto()
        Subject subjectSaved = subjectService.updateFromDto(dto)
        verify(subjectRepository, times(1)).findById(subject.id)
        verify(subjectRepository, times(1)).save(subject)
        verifyNoMoreInteractions(subjectRepository)
        assertEquals(subject.id, subjectSaved.id)
        assertEquals(subject.code, subjectSaved.code)
        assertEquals(subject.description, subjectSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update subjectDto from null object.")
        SubjectDto dto = null
        subjectService.updateFromDto(dto)
        verifyNoMoreInteractions(subjectRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        subjectService.delete(subject)
        verifyNoMoreInteractions(subjectRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}