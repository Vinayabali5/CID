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

import uk.ac.reigate.domain.lookup.YearGroup
import uk.ac.reigate.dto.lookup.YearGroupDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.YearGroupRepository


class YearGroupServiceTest {
    
    @Mock
    private YearGroupRepository yearGroupRepository;
    
    @InjectMocks
    private YearGroupService yearGroupService;
    
    private YearGroup yearGroup
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample YearGroup data object to use for the testing
     * 
     * @return a sample YearGroup data object
     */
    YearGroup createYearGroup() {
        return new YearGroup(
                id: 1,
                code: '1',
                description: 'YearGroup 1'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample YearGroup created at setup
     * 
     * @return a YearGroupDto object based on the sample YearGroup
     */
    YearGroupDto createDto() {
        return new YearGroupDto(
                id: yearGroup.id,
                code: yearGroup.code,
                description: yearGroup.description
                )
    }
    
    /**
     * This method is used to set up the tests for the YearGroupService
     */
    @Before
    public void setup() {
        this.yearGroupRepository = Mockito.mock(YearGroupRepository.class);
        this.yearGroupService = new YearGroupService(yearGroupRepository);
        
        yearGroup = createYearGroup()
        
        when(yearGroupRepository.save(any(YearGroup.class))).thenReturn(yearGroup);
        when(yearGroupRepository.findById(1)).thenReturn(new Optional(yearGroup));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        YearGroupService service = new YearGroupService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<YearGroup> result = yearGroupService.findAll();
        verify(yearGroupRepository, times(1)).findAll()
        verifyNoMoreInteractions(yearGroupRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        YearGroup result = yearGroupService.findById(1);
        verify(yearGroupRepository, times(1)).findById(1)
        verifyNoMoreInteractions(yearGroupRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        YearGroup savedYearGroup = yearGroupService.save(yearGroup);
        verify(yearGroupRepository, times(1)).save(any())
        verifyNoMoreInteractions(yearGroupRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<YearGroup> savedYearGroups = yearGroupService.saveYearGroups([yearGroup, yearGroup]);
        verify(yearGroupRepository, times(2)).save(yearGroup)
        verifyNoMoreInteractions(yearGroupRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        YearGroupDto dto = createDto()
        YearGroup yearGroupSaved = yearGroupService.createFromDto(dto)
        verify(yearGroupRepository, times(1)).save(any(YearGroup.class))
        verifyNoMoreInteractions(yearGroupRepository)
        assertEquals(dto.id, yearGroup.id)
        assertEquals(dto.code, yearGroup.code)
        assertEquals(dto.description, yearGroup.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create yearGroup from null object.")
        YearGroupDto dto = null
        yearGroupService.createFromDto(dto)
        verifyNoMoreInteractions(yearGroupRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        YearGroupDto dto = createDto()
        YearGroup yearGroupSaved = yearGroupService.updateFromDto(dto)
        verify(yearGroupRepository, times(1)).findById(yearGroup.id)
        verify(yearGroupRepository, times(1)).save(yearGroup)
        verifyNoMoreInteractions(yearGroupRepository)
        assertEquals(yearGroup.id, yearGroupSaved.id)
        assertEquals(yearGroup.code, yearGroupSaved.code)
        assertEquals(yearGroup.description, yearGroupSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        YearGroupDto dto = createDto()
        YearGroup yearGroupSaved = yearGroupService.updateFromDto(dto)
        verify(yearGroupRepository, times(1)).findById(yearGroup.id)
        verify(yearGroupRepository, times(1)).save(yearGroup)
        verifyNoMoreInteractions(yearGroupRepository)
        assertEquals(yearGroup.id, yearGroupSaved.id)
        assertEquals(yearGroup.code, yearGroupSaved.code)
        assertEquals(yearGroup.description, yearGroupSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update yearGroup from null object.")
        YearGroupDto dto = null
        yearGroupService.updateFromDto(dto)
        verifyNoMoreInteractions(yearGroupRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        yearGroupService.delete(yearGroup)
        verifyNoMoreInteractions(yearGroupRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}