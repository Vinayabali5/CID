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

import uk.ac.reigate.domain.academic.School
import uk.ac.reigate.dto.SchoolDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.SchoolRepository
import uk.ac.reigate.services.lookup.SchoolTypeService


class SchoolServiceTest {
    
    @Mock
    private SchoolRepository schoolRepository;
    
    @Mock
    private SchoolTypeService schoolTypeService
    
    @Mock
    private SchoolPriorityService schoolPriorityService
    
    @InjectMocks
    private SchoolService schoolService;
    
    private School school
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample School data object to use for the testing
     * 
     * @return a sample School data object
     */
    School createSchool() {
        return new School(
                id: 1,
                name: '1',
                urn: 'School 1'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample School created at setup
     * 
     * @return a SchoolDto object based on the sample School
     */
    SchoolDto createDto() {
        School sampleData = createSchool()
        return new SchoolDto(
                id: sampleData.id,
                name: sampleData.name,
                urn: sampleData.urn
                )
    }
    
    /**
     * This method is used to set up the tests for the SchoolService
     */
    @Before
    public void setup() {
        schoolRepository = mock(SchoolRepository.class);
        schoolTypeService = mock(SchoolTypeService.class);
        schoolPriorityService = mock(SchoolPriorityService.class);
        
        this.schoolService = new SchoolService(schoolRepository, schoolTypeService, schoolPriorityService);
        
        school = createSchool()
        
        when(schoolRepository.save(any(School.class))).thenReturn(school);
        when(schoolRepository.findById(1)).thenReturn(new Optional(school));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        SchoolService service = new SchoolService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<School> result = schoolService.findAll();
        verify(schoolRepository, times(1)).findAll()
        verifyNoMoreInteractions(schoolRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        School result = schoolService.findById(1);
        verify(schoolRepository, times(1)).findById(1)
        verifyNoMoreInteractions(schoolRepository)
    }
    
    @Test
    public void testFindByName() {
        School result = schoolService.findByName('Test');
        verify(schoolRepository, times(1)).findByName('Test')
        verifyNoMoreInteractions(schoolRepository)
    }
    
    @Test
    public void testFindByUrn() {
        School result = schoolService.findByUrn('T');
        verify(schoolRepository, times(1)).findByUrn('T')
        verifyNoMoreInteractions(schoolRepository)
    }
    
    @Test
    public void testFindByUkprn() {
        School result = schoolService.findByUkprn('Test');
        verify(schoolRepository, times(1)).findByUkprn('Test')
        verifyNoMoreInteractions(schoolRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        School savedSchool = schoolService.save(school);
        verify(schoolRepository, times(1)).save(any())
        verifyNoMoreInteractions(schoolRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<School> savedSchools = schoolService.saveSchools([school, school]);
        verify(schoolRepository, times(2)).save(school)
        verifyNoMoreInteractions(schoolRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        SchoolDto dto = createDto()
        School schoolSaved = schoolService.createFromDto(dto)
        verify(schoolRepository, times(1)).save(any(School.class))
        verifyNoMoreInteractions(schoolRepository)
        assertEquals(dto.id, school.id)
        assertEquals(dto.name, school.name)
        assertEquals(dto.urn, school.urn)
    }
    
    @Test
    public void testCreateFromDto_typeId() {
        SchoolDto dto = createDto()
        dto.typeId= 1
        when(schoolTypeService.findById(dto.typeId)).thenReturn(null)
        School schoolSaved = schoolService.createFromDto(dto)
        verify(schoolRepository, times(1)).save(any(School.class))
        verifyNoMoreInteractions(schoolRepository)
    }
    
    @Test
    public void testCreateFromDto_priorityId() {
        SchoolDto dto = createDto()
        dto.priorityId= 1
        when(schoolPriorityService.findById(dto.priorityId)).thenReturn(null)
        School schoolSaved = schoolService.createFromDto(dto)
        verify(schoolRepository, times(1)).save(any(School.class))
        verifyNoMoreInteractions(schoolRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create schoolDto from null object.")
        SchoolDto dto = null
        schoolService.createFromDto(dto)
        verifyNoMoreInteractions(schoolRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        SchoolDto dto = createDto()
        School schoolSaved = schoolService.updateFromDto(dto)
        verify(schoolRepository, times(1)).findById(school.id)
        verify(schoolRepository, times(1)).save(school)
        verifyNoMoreInteractions(schoolRepository)
        assertEquals(school.id, schoolSaved.id)
        assertEquals(school.name, schoolSaved.name)
        assertEquals(school.urn, schoolSaved.urn)
    }
    
    @Test
    public void testUpdateFromDto_typeId() {
        SchoolDto dto = createDto()
        dto.typeId= 1
        when(schoolTypeService.findById(dto.typeId)).thenReturn(null)
        School schoolSaved = schoolService.updateFromDto(dto)
        verify(schoolTypeService, times(1)).findById(dto.typeId)
        verifyNoMoreInteractions(schoolTypeService)
    }
    
    @Test
    public void testUpdateFromDto_priorityId() {
        SchoolDto dto = createDto()
        dto.priorityId= 1
        when(schoolPriorityService.findById(dto.priorityId)).thenReturn(null)
        School schoolSaved = schoolService.updateFromDto(dto)
        verify(schoolPriorityService, times(1)).findById(dto.priorityId)
        verifyNoMoreInteractions(schoolPriorityService)
    }
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        SchoolDto dto = createDto()
        School schoolSaved = schoolService.updateFromDto(dto)
        verify(schoolRepository, times(1)).findById(school.id)
        verify(schoolRepository, times(1)).save(school)
        verifyNoMoreInteractions(schoolRepository)
        assertEquals(school.id, schoolSaved.id)
        assertEquals(school.name, schoolSaved.name)
        assertEquals(school.urn, schoolSaved.urn)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update schoolDto from null object.")
        SchoolDto dto = null
        schoolService.updateFromDto(dto)
        verifyNoMoreInteractions(schoolRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        schoolService.delete(school)
        verifyNoMoreInteractions(schoolRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}