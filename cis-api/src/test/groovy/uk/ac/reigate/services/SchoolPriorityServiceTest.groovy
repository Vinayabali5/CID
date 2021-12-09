package uk.ac.reigate.services

import static org.junit.Assert.assertEquals
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

import uk.ac.reigate.domain.lookup.SchoolPriority
import uk.ac.reigate.dto.SchoolPriorityDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.SchoolPriorityRepository
import uk.ac.reigate.util.exception.IdMissingException


class SchoolPriorityServiceTest {
    
    @Mock
    private SchoolPriorityRepository schoolPriorityRepository;
    
    @InjectMocks
    private SchoolPriorityService schoolPriorityService;
    
    private SchoolPriority schoolPriority
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    /**
     * This method is used to create a sample SchoolPriority data object to use for the testing
     *
     * @return a sample SchoolPriority data object
     */
    SchoolPriority createSchoolPriority() {
        return new SchoolPriority(
                id: 99,
                code: 'G',
                description: 'Good'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample schoolPriority created at setup
     *
     * @return a schoolPriorityDto object based on the sample schoolPriority
     */
    SchoolPriorityDto createDto() {
        return new SchoolPriorityDto(
                id: schoolPriority.id,
                code: schoolPriority.code,
                description: schoolPriority.description
                )
    }
    
    /**
     * This method is used to set up the tests for the SchoolPriorityService
     */
    @Before
    public void setup() {
        this.schoolPriorityRepository = Mockito.mock(SchoolPriorityRepository.class);
        this.schoolPriorityService = new SchoolPriorityService(schoolPriorityRepository);
        
        schoolPriority = createSchoolPriority()
        
        when(schoolPriorityRepository.save(any(SchoolPriority.class))).thenReturn(schoolPriority);
        when(schoolPriorityRepository.findById(schoolPriority.id)).thenReturn(new Optional(schoolPriority));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        SchoolPriorityService service = new SchoolPriorityService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<SchoolPriority> result = schoolPriorityService.findAll();
        verify(schoolPriorityRepository, times(1)).findAll()
        verifyNoMoreInteractions(schoolPriorityRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        SchoolPriority result = schoolPriorityService.findById(1);
        verify(schoolPriorityRepository, times(1)).findById(1)
        verifyNoMoreInteractions(schoolPriorityRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        SchoolPriority savedSchoolPriority = schoolPriorityService.save(new SchoolPriority());
        verify(schoolPriorityRepository, times(1)).save(any())
        verifyNoMoreInteractions(schoolPriorityRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveSchoolPrioritys() {
        List<SchoolPriority> savedSchoolPrioritys = schoolPriorityService.saveSchoolPriorities([
            new SchoolPriority(id: 1),
            new SchoolPriority(id: 2)
        ]);
        verify(schoolPriorityRepository, times(2)).save(any(SchoolPriority.class))
        verifyNoMoreInteractions(schoolPriorityRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create schoolPriorityDto from null object.")
        SchoolPriorityDto dto = null
        schoolPriorityService.createFromDto(dto)
        verifyNoMoreInteractions(schoolPriorityRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        SchoolPriorityDto dto = new SchoolPriorityDto(id: 1, code: '123', description: 'Year 123')
        schoolPriorityService.createFromDto(dto)
        verify(schoolPriorityRepository, times(1)).save(any(SchoolPriority.class))
        verifyNoMoreInteractions(schoolPriorityRepository)
    }
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        SchoolPriorityDto dto = createDto()
        schoolPriorityService.updateFromDto(dto)
        verify(schoolPriorityRepository, times(1)).findById(schoolPriority.id)
        verify(schoolPriorityRepository, times(1)).save(any(SchoolPriority.class))
        verifyNoMoreInteractions(schoolPriorityRepository)
        assertEquals(dto.id, schoolPriority.id)
    }
    
    /**
     * This method is used to test the createFromDto service method with null dto
     */
    @Test
    public void testupdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update schoolPriorityDto from null object.")
        SchoolPriorityDto dto = null
        schoolPriorityService.updateFromDto(dto)
        verifyNoMoreInteractions(schoolPriorityRepository)
    }
    
    /**
     * This method is used to test the delete service method.
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        schoolPriorityService.delete(schoolPriority)
        verifyNoMoreInteractions(schoolPriorityRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

