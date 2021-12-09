package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.dto.AcademicYearDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.repositories.academic.AcademicYearRepository
import uk.ac.reigate.util.exception.IdMissingException

class AcademicYearServiceTest {
    
    @Mock
    private AcademicYearRepository academicYearRepository
    
    @InjectMocks
    private AcademicYearService academicYearService
    
    private AcademicYear academicYear
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample Address data object to use for the testing
     *
     * @return a sample Address data object
     */
    AcademicYear createAcademicYear() {
        return new AcademicYear(
                id: 99,
                code: '99/00',
                description: 'Test Data',
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                startYear: 2017,
                enumerationDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                teachingStartDate:new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                teachingEndDate:new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09')
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample Address created at setup
     *
     * @return a AddressDto object based on the sample Address
     */
    AcademicYearDto createDto() {
        return new AcademicYearDto(
                id: academicYear.id,
                code: academicYear.code,
                description: academicYear.description,
                startDate: academicYear.startDate,
                endDate: academicYear.endDate,
                startYear: academicYear.startYear,
                enumerationDate: academicYear.enumerationDate,
                teachingStartDate: academicYear.teachingStartDate,
                teachingEndDate: academicYear.teachingEndDate
                )
    }
    
    /**
     * This method is used to set up the tests for the AddressService
     */
    @Before
    public void setup() {
        this.academicYearRepository = mock(AcademicYearRepository.class)
        this.academicYearService = new AcademicYearService(academicYearRepository)
        
        academicYear = createAcademicYear()
        
        when(academicYearRepository.save(any(AcademicYear.class))).thenReturn(academicYear);
        when(academicYearRepository.findById(academicYear.id)).thenReturn(new Optional(academicYear))
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<AcademicYear> result = academicYearService.findAll()
        verify(academicYearRepository, times(1)).findAll()
        verifyNoMoreInteractions(academicYearRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        AcademicYear result = academicYearService.findById(1)
        verify(academicYearRepository, times(1)).findById(1)
        verifyNoMoreInteractions(academicYearRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        AcademicYear savedAcademicYear = academicYearService.save(new AcademicYear(id: 1));
        verify(academicYearRepository, times(1)).save(any())
        verifyNoMoreInteractions(academicYearRepository)
    }
    
    /**
     * This method is used to test the save service method with null
     */
    @Test
    public void testSave_withNull() {
        AcademicYear savedAcademicYear = academicYearService.save(null);
        verify(academicYearRepository, times(1)).save(any())
        verifyNoMoreInteractions(academicYearRepository)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("AcademicYears should not be deleted.")
        academicYearService.delete(new AcademicYear(id: 1))
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create AcademicYear from null object.")
        AcademicYearDto dto = null
        academicYearService.createFromDto(dto)
        verifyNoMoreInteractions(academicYearRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        AcademicYearDto dto = new AcademicYearDto(id: 1, code: '123', description: 'Year 123')
        AcademicYear academicYearSaved = academicYearService.createFromDto(dto)
        verify(academicYearRepository, times(1)).findById(1)
        verify(academicYearRepository, times(1)).save(any(AcademicYear.class))
        verifyNoMoreInteractions(academicYearRepository)
        assertEquals(dto.id, dto.id)
        assertEquals(dto.code, dto.code)
        assertEquals(dto.description, dto.description)
        assertEquals(dto.startDate, dto.startDate)
        assertEquals(dto.endDate, dto.endDate)
        assertEquals(dto.startYear, dto.startYear)
        assertEquals(dto.enumerationDate, dto.enumerationDate)
        assertEquals(dto.teachingStartDate, dto.teachingStartDate)
        assertEquals(dto.teachingEndDate, dto.teachingEndDate)
    }
    
    /**
     * This method is used to test the updateFromDto service method for existing dto
     */
    @Test
    public void testCreateFromDto_dtoForExisting() {
        thrown.expect(IdMissingException.class)
        thrown.expectMessage("An academic year already exist with this ID.")
        AcademicYearDto dto = new AcademicYearDto(id: 99, code: '99', description: 'Year 99')
        academicYearService.createFromDto(dto)
        verifyNoMoreInteractions(academicYearRepository)
    }
    
    /**
     * This method is used to test the updateFromDto service method with null dto
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update AcademicYear from null object.")
        AcademicYearDto dto = null
        academicYearService.updateFromDto(dto)
        verifyNoMoreInteractions(academicYearRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method with null ID
     */
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update AcademicYear when the ID is null.")
        AcademicYearDto dto = new AcademicYearDto(code: '123', description: 'Year 123')
        academicYearService.updateFromDto(dto)
        verifyNoMoreInteractions(academicYearRepository)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        AcademicYearDto dto = createDto()
        academicYearService.updateFromDto(dto)
        verify(academicYearRepository, times(1)).findById(academicYear.id)
        verify(academicYearRepository, times(1)).save(any(AcademicYear.class))
        verifyNoMoreInteractions(academicYearRepository)
        assertEquals(dto.id, academicYear.id)
        assertEquals(dto.code, academicYear.code)
        assertEquals(dto.description, academicYear.description)
        assertEquals(dto.startDate, academicYear.startDate)
        assertEquals(dto.endDate, academicYear.endDate)
        assertEquals(dto.startYear, academicYear.startYear)
        assertEquals(dto.enumerationDate, academicYear.enumerationDate)
        assertEquals(dto.teachingStartDate, academicYear.teachingStartDate)
        assertEquals(dto.teachingEndDate, academicYear.teachingEndDate)
    }
    
    /**
     * This method is used to test the updateFromDto service method for existing dto
     */
    @Test
    public void testUpdateFromDto_dtoForExisting() {
        thrown.expect(IdMissingException.class)
        thrown.expectMessage("An academic year already exist with this ID.")
        AcademicYearDto dto = new AcademicYearDto(id: 99, code: '99', description: 'Year 99')
        academicYearService.createFromDto(dto)
        verifyNoMoreInteractions(academicYearRepository)
    }
    
    @Test
    public void testSaveAcademicYears() {
        List<AcademicYear> savedAcademicYears = academicYearService.saveAcademicYears([
            new AcademicYear(id: 1),
            new AcademicYear(id: 2)
        ]);
        verify(academicYearRepository, times(2)).save(any(AcademicYear.class))
        verifyNoMoreInteractions(academicYearRepository)
    }
    
    /**
     * This method is used to test the findByCode service method
     */
    @Test
    public void testFindByCode() {
        AcademicYear result = academicYearService.findByCode("18")
        verify(academicYearRepository, times(1)).findByCode("18")
        verifyNoMoreInteractions(academicYearRepository)
    }
    
    /**
     * This method is used to test the findCurrent service method
     */
    @Test
    public void testGetCurrentAcademicYear() {
        AcademicYear result = academicYearService.getCurrentAcademicYear()
        verify(academicYearRepository, times(1)).findCurrent()
        verifyNoMoreInteractions(academicYearRepository)
    }
    
    /**
     * This method is used to test the findNext service method
     */
    @Test
    public void testGetNextAcademicYear() {
        AcademicYear result = academicYearService.getNextAcademicYear()
        verify(academicYearRepository, times(1)).findNext()
        verifyNoMoreInteractions(academicYearRepository)
    }
    
    /**
     * This method is used to test the findPrevious service method
     */
    @Test
    public void testGetPreviousAcademicYear() {
        AcademicYear result = academicYearService.getPreviousAcademicYear()
        verify(academicYearRepository, times(1)).findPrevious()
        verifyNoMoreInteractions(academicYearRepository)
    }
    
    /**
     * This method is used to test the findByDate service method
     */
    @Test
    public void testFindByDate() {
        AcademicYear result = academicYearService.findByDate(new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'))
        verify(academicYearRepository, times(1)).findByDate(new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'))
        verifyNoMoreInteractions(academicYearRepository)
    }
}

