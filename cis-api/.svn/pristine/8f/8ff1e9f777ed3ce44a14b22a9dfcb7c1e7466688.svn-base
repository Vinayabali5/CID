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

import uk.ac.reigate.domain.lookup.StaffType
import uk.ac.reigate.dto.lookup.StaffTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.lookup.StaffTypeRepository


class StaffTypeServiceTest {
    
    @Mock
    private StaffTypeRepository staffTypeRepository;
    
    @InjectMocks
    private StaffTypeService staffTypeService;
    
    private StaffType staffType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample StaffType data object to use for the testing
     * 
     * @return a sample StaffType data object
     */
    StaffType createStaffType() {
        return new StaffType(
                id: 1,
                code: 'L1004',
                description: 'MIS',
                needInitials: true
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample StaffType created at setup
     * 
     * @return a StaffTypeDto object based on the sample StaffType
     */
    StaffTypeDto createDto() {
        return new StaffTypeDto(
                id: staffType.id,
                code: staffType.code,
                description: staffType.description,
                needInitials: staffType.needInitials
                )
    }
    
    /**
     * This method is used to set up the tests for the StaffTypeService
     */
    @Before
    public void setup() {
        this.staffTypeRepository = Mockito.mock(StaffTypeRepository.class);
        this.staffTypeService = new StaffTypeService(staffTypeRepository);
        
        staffType = createStaffType()
        
        when(staffTypeRepository.save(any(StaffType.class))).thenReturn(staffType);
        when(staffTypeRepository.findById(1)).thenReturn(new Optional(staffType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StaffTypeService service = new StaffTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<StaffType> result = staffTypeService.findAll();
        verify(staffTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(staffTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        StaffType result = staffTypeService.findById(1);
        verify(staffTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(staffTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        StaffType savedStaffType = staffTypeService.save(staffType);
        verify(staffTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(staffTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<StaffType> savedStaffTypes = staffTypeService.saveStaffTypes([staffType, staffType]);
        verify(staffTypeRepository, times(2)).save(staffType)
        verifyNoMoreInteractions(staffTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        StaffTypeDto dto = createDto()
        StaffType staffTypeSaved = staffTypeService.createFromDto(dto)
        verify(staffTypeRepository, times(1)).save(any(StaffType.class))
        verifyNoMoreInteractions(staffTypeRepository)
        assertEquals(dto.id, staffType.id)
        assertEquals(dto.code, staffType.code)
        assertEquals(dto.description, staffType.description)
        assertEquals(dto.needInitials, staffType.needInitials)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create staffType from null object.")
        StaffTypeDto dto = null
        staffTypeService.createFromDto(dto)
        verifyNoMoreInteractions(staffTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        StaffTypeDto dto = createDto()
        StaffType staffTypeSaved = staffTypeService.updateFromDto(dto)
        verify(staffTypeRepository, times(1)).findById(staffType.id)
        verify(staffTypeRepository, times(1)).save(staffType)
        verifyNoMoreInteractions(staffTypeRepository)
        assertEquals(staffType.id, staffTypeSaved.id)
        assertEquals(staffType.code, staffTypeSaved.code)
        assertEquals(staffType.description, staffTypeSaved.description)
        assertEquals(staffType.needInitials, staffTypeSaved.needInitials)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        StaffTypeDto dto = createDto()
        dto.code = null
        dto.description = null
        StaffType staffTypeSaved = staffTypeService.updateFromDto(dto)
        verify(staffTypeRepository, times(1)).findById(staffType.id)
        verify(staffTypeRepository, times(1)).save(staffType)
        verifyNoMoreInteractions(staffTypeRepository)
        assertEquals(staffType.id, staffTypeSaved.id)
        assertEquals(staffType.code, staffTypeSaved.code)
        assertEquals(staffType.description, staffTypeSaved.description)
        assertEquals(staffType.needInitials, staffTypeSaved.needInitials)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update staffType from null object.")
        StaffTypeDto dto = null
        staffTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(staffTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        staffTypeService.delete(staffType)
        verifyNoMoreInteractions(staffTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}