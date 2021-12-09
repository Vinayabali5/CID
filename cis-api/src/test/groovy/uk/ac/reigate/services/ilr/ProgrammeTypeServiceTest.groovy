package uk.ac.reigate.services.ilr

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.ilr.ProgrammeType
import uk.ac.reigate.dto.ilr.ProgrammeTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.ProgrammeTypeRepository


class ProgrammeTypeServiceTest {
    
    @Mock
    private ProgrammeTypeRepository programmeTypeRepository;
    
    @InjectMocks
    private ProgrammeTypeService programmeTypeService;
    
    private ProgrammeType programmeType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample ProgrammeType data object to use for the testing
     * 
     * @return a sample ProgrammeType data object
     */
    ProgrammeType createProgrammeType() {
        return new ProgrammeType(
                id: 1,
                code: 'N',
                description: 'Aim Type',
                shortDescription: 'Test',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo : new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/19  '),
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample ProgrammeType created at setup
     * 
     * @return a ProgrammeTypeDto object based on the sample ProgrammeType
     */
    ProgrammeTypeDto createDto() {
        return new ProgrammeTypeDto(
                id: programmeType.id,
                code: programmeType.code,
                description: programmeType.description,
                shortDescription: programmeType.shortDescription,
                validFrom: programmeType.validFrom,
                validTo: programmeType.validTo
                )
    }
    
    /**
     * This method is used to set up the tests for the ProgrammeTypeService
     */
    @Before
    public void setup() {
        this.programmeTypeRepository = Mockito.mock(ProgrammeTypeRepository.class);
        this.programmeTypeService = new ProgrammeTypeService(programmeTypeRepository);
        
        programmeType = createProgrammeType()
        
        when(programmeTypeRepository.save(any(ProgrammeType.class))).thenReturn(programmeType);
        when(programmeTypeRepository.findById(1)).thenReturn(new Optional(programmeType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        ProgrammeTypeService service = new ProgrammeTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<ProgrammeType> result = programmeTypeService.findAll();
        verify(programmeTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(programmeTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        ProgrammeType result = programmeTypeService.findById(1);
        verify(programmeTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(programmeTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        ProgrammeType savedProgrammeType = programmeTypeService.save(programmeType);
        verify(programmeTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(programmeTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<ProgrammeType> savedProgrammeTypes = programmeTypeService.saveProgrammeTypes([programmeType, programmeType]);
        verify(programmeTypeRepository, times(2)).save(programmeType)
        verifyNoMoreInteractions(programmeTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        ProgrammeTypeDto dto = createDto()
        ProgrammeType programmeTypeSaved = programmeTypeService.createFromDto(dto)
        verify(programmeTypeRepository, times(1)).save(any(ProgrammeType.class))
        verifyNoMoreInteractions(programmeTypeRepository)
        assertEquals(dto.id, programmeType.id)
        assertEquals(dto.code, programmeType.code)
        assertEquals(dto.description, programmeType.description)
        assertEquals(dto.shortDescription, programmeType.shortDescription)
        assertEquals(dto.validFrom, programmeType.validFrom)
        assertEquals(dto.validTo, programmeType.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithNullValues() {
        ProgrammeTypeDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        ProgrammeType programmeTypeSaved = programmeTypeService.createFromDto(dto)
        verify(programmeTypeRepository, times(1)).save(any(ProgrammeType.class))
        verifyNoMoreInteractions(programmeTypeRepository)
        assertEquals(programmeType.id, programmeTypeSaved.id)
        assertEquals(programmeType.code, programmeTypeSaved.code)
        assertEquals(programmeType.description, programmeTypeSaved.description)
        assertEquals(programmeType.shortDescription, programmeTypeSaved.shortDescription)
        assertEquals(programmeType.validFrom, programmeTypeSaved.validFrom)
        assertEquals(programmeType.validTo, programmeTypeSaved.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create programmeType from null object.")
        ProgrammeTypeDto dto = null
        programmeTypeService.createFromDto(dto)
        verifyNoMoreInteractions(programmeTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        ProgrammeTypeDto dto = createDto()
        ProgrammeType programmeTypeSaved = programmeTypeService.updateFromDto(dto)
        verify(programmeTypeRepository, times(1)).findById(programmeType.id)
        verify(programmeTypeRepository, times(1)).save(programmeType)
        verifyNoMoreInteractions(programmeTypeRepository)
        assertEquals(programmeType.id, programmeTypeSaved.id)
        assertEquals(programmeType.code, programmeTypeSaved.code)
        assertEquals(programmeType.description, programmeTypeSaved.description)
        assertEquals(programmeType.shortDescription, programmeTypeSaved.shortDescription)
        assertEquals(programmeType.validFrom, programmeTypeSaved.validFrom)
        assertEquals(programmeType.validTo, programmeTypeSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        ProgrammeTypeDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        ProgrammeType programmeTypeSaved = programmeTypeService.updateFromDto(dto)
        verify(programmeTypeRepository, times(1)).findById(programmeType.id)
        verify(programmeTypeRepository, times(1)).save(programmeType)
        verifyNoMoreInteractions(programmeTypeRepository)
        assertEquals(programmeType.id, programmeTypeSaved.id)
        assertEquals(programmeType.code, programmeTypeSaved.code)
        assertEquals(programmeType.description, programmeTypeSaved.description)
        assertEquals(programmeType.shortDescription, programmeTypeSaved.shortDescription)
        assertEquals(programmeType.validFrom, programmeTypeSaved.validFrom)
        assertEquals(programmeType.validTo, programmeTypeSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update programmeType from null object.")
        ProgrammeTypeDto dto = null
        programmeTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(programmeTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        programmeTypeService.delete(programmeType)
        verifyNoMoreInteractions(programmeTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}