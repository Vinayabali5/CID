package uk.ac.reigate.services.lookup

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

import uk.ac.reigate.domain.lookup.SchoolType
import uk.ac.reigate.dto.lookup.SchoolTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.SchoolTypeRepository


class SchoolTypeServiceTest {
    
    @Mock
    private SchoolTypeRepository schoolTypeRepository;
    
    @InjectMocks
    private SchoolTypeService schoolTypeService;
    
    private SchoolType schoolType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample SchoolType data object to use for the testing
     * 
     * @return a sample SchoolType data object
     */
    SchoolType createSchoolType() {
        return new SchoolType(
                id: 1,
                code: 'G',
                description: 'General Schools'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample SchoolType created at setup
     * 
     * @return a SchoolTypeDto object based on the sample SchoolType
     */
    SchoolTypeDto createDto() {
        return new SchoolTypeDto(
                id: schoolType.id,
                code: schoolType.code,
                description: schoolType.description
                )
    }
    
    /**
     * This method is used to set up the tests for the SchoolTypeService
     */
    @Before
    public void setup() {
        this.schoolTypeRepository = Mockito.mock(SchoolTypeRepository.class);
        this.schoolTypeService = new SchoolTypeService(schoolTypeRepository);
        
        schoolType = createSchoolType()
        
        when(schoolTypeRepository.save(any(SchoolType.class))).thenReturn(schoolType);
        when(schoolTypeRepository.findById(1)).thenReturn(new Optional(schoolType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        SchoolTypeService service = new SchoolTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<SchoolType> result = schoolTypeService.findAll();
        verify(schoolTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(schoolTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        SchoolType result = schoolTypeService.findById(1);
        verify(schoolTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(schoolTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        SchoolType savedSchoolType = schoolTypeService.save(schoolType);
        verify(schoolTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(schoolTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<SchoolType> savedSchoolTypes = schoolTypeService.saveSchoolTypes([schoolType, schoolType]);
        verify(schoolTypeRepository, times(2)).save(schoolType)
        verifyNoMoreInteractions(schoolTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        SchoolTypeDto dto = createDto()
        SchoolType schoolTypeSaved = schoolTypeService.createFromDto(dto)
        verify(schoolTypeRepository, times(1)).save(any(SchoolType.class))
        verifyNoMoreInteractions(schoolTypeRepository)
        assertEquals(dto.id, schoolType.id)
        assertEquals(dto.code, schoolType.code)
        assertEquals(dto.description, schoolType.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create schoolType from null object.")
        SchoolTypeDto dto = null
        schoolTypeService.createFromDto(dto)
        verifyNoMoreInteractions(schoolTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        SchoolTypeDto dto = createDto()
        SchoolType schoolTypeSaved = schoolTypeService.updateFromDto(dto)
        verify(schoolTypeRepository, times(1)).findById(schoolType.id)
        verify(schoolTypeRepository, times(1)).save(schoolType)
        verifyNoMoreInteractions(schoolTypeRepository)
        assertEquals(schoolType.id, schoolTypeSaved.id)
        assertEquals(schoolType.code, schoolTypeSaved.code)
        assertEquals(schoolType.description, schoolTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        SchoolTypeDto dto = createDto()
        dto.code = null
        dto.description = null
        SchoolType schoolTypeSaved = schoolTypeService.updateFromDto(dto)
        verify(schoolTypeRepository, times(1)).findById(schoolType.id)
        verify(schoolTypeRepository, times(1)).save(schoolType)
        verifyNoMoreInteractions(schoolTypeRepository)
        assertEquals(schoolType.id, schoolTypeSaved.id)
        assertEquals(schoolType.code, schoolTypeSaved.code)
        assertEquals(schoolType.description, schoolTypeSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update schoolType from null object.")
        SchoolTypeDto dto = null
        schoolTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(schoolTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        schoolTypeService.delete(schoolType)
        verifyNoMoreInteractions(schoolTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}