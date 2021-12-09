package uk.ac.reigate.services

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.domain.academic.EntryQualification
import uk.ac.reigate.dto.EntryQualificationDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.EntryQualificationRepository

@RunWith(MockitoJUnitRunner.class)
class EntryQualificationServiceTest {
    
    @Mock
    private EntryQualificationRepository entryQualificationRepository
    
    @Mock
    private EntryQualificationTypeService entryQualificationTypeService
    
    @InjectMocks
    private EntryQualificationService entryQualificationService;
    
    private EntryQualification entryQualification
    
    EntryQualification createEntryQualification() {
        return new EntryQualification(
                id: 1,
                title: 'Maths',
                basicList: true,
                shortCourse: true,
                dataMatchCode: "MA",
                webLinkCode: 1
                )
    }
    
    EntryQualificationDto createDto() {
        EntryQualification sampleData = createEntryQualification()
        return new EntryQualificationDto(
                id: sampleData.id,
                title: sampleData.title,
                basicList: sampleData.basicList,
                shortCourse: sampleData.shortCourse,
                dataMatchCode: sampleData.dataMatchCode,
                webLinkCode: sampleData.webLinkCode
                )
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        entryQualificationRepository = mock(EntryQualificationRepository.class);
        entryQualificationTypeService = mock(EntryQualificationTypeService.class)
        
        entryQualificationService = new EntryQualificationService(entryQualificationRepository, entryQualificationTypeService);
        
        entryQualification = createEntryQualification()
        when(entryQualificationRepository.findById(entryQualification.id)).thenReturn(new Optional(new EntryQualification()));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        EntryQualificationService service = new EntryQualificationService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<EntryQualification> result = entryQualificationService.findAll();
        verify(entryQualificationRepository, times(1)).findAll()
        verifyNoMoreInteractions(entryQualificationRepository)
    }
    
    @Test
    public void testFindById() {
        EntryQualification result = entryQualificationService.findById(1);
        verify(entryQualificationRepository, times(1)).findById(1)
        verifyNoMoreInteractions(entryQualificationRepository)
    }
    
    @Test
    public void testSaveNewEntryQualification() {
        EntryQualification savedEntryQualification = entryQualificationService.save(entryQualification);
        verify(entryQualificationRepository, times(1)).save(any())
        verifyNoMoreInteractions(entryQualificationRepository)
    }
    
    @Test
    public void testSaveEntryQualifications() {
        List<EntryQualification> savedEntryQualifications = entryQualificationService.saveEntryQualifications([
            new EntryQualification(id: 1),
            new EntryQualification(id: 2)
        ]);
        verify(entryQualificationRepository, times(2)).save(any(EntryQualification.class))
        verifyNoMoreInteractions(entryQualificationRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create entryQualificationDto from null object.")
        EntryQualificationDto dto = null
        entryQualificationService.createFromDto(dto)
        verifyNoMoreInteractions(entryQualificationRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithNullValues() {
        EntryQualificationDto dto = createDto()
        dto.entryQualificationTypeId = null
        EntryQualification entryQualificationSaved = entryQualificationService.createFromDto(dto)
        verify(entryQualificationRepository, times(1)).save(any(EntryQualification.class))
        verifyNoMoreInteractions(entryQualificationRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithEntryQualificationTypeId() {
        EntryQualificationDto dto = createDto()
        dto.entryQualificationTypeId = 1
        when(entryQualificationTypeService.findById(dto.entryQualificationTypeId)).thenReturn(null);
        EntryQualification entryQualificationSaved = entryQualificationService.createFromDto(dto)
        verify(entryQualificationRepository, times(1)).save(any(EntryQualification.class))
        verifyNoMoreInteractions(entryQualificationRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithValues() {
        EntryQualificationDto dto = createDto()
        EntryQualification entryQualificationSaved = entryQualificationService.createFromDto(dto)
        verify(entryQualificationRepository, times(1)).save(any(EntryQualification.class))
        verifyNoMoreInteractions(entryQualificationRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithValues() {
        EntryQualificationDto dto = createDto()
        EntryQualification entryQualificationSaved = entryQualificationService.updateFromDto(dto)
        verify(entryQualificationRepository, times(1)).findById(entryQualification.id)
        verify(entryQualificationRepository, times(1)).save(any(EntryQualification.class))
        verifyNoMoreInteractions(entryQualificationRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update entryQualificationDto from null object.")
        EntryQualificationDto dto = new EntryQualificationDto(basicList: true)
        entryQualificationService.updateFromDto(dto)
        verifyNoMoreInteractions(entryQualificationRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithEntryQualificationTypeId() {
        EntryQualificationDto dto = createDto()
        dto.entryQualificationTypeId = 1
        when(entryQualificationTypeService.findById(dto.entryQualificationTypeId)).thenReturn(null);
        EntryQualification entryQualificationSaved = entryQualificationService.updateFromDto(dto)
        verify(entryQualificationTypeService, times(1)).findById(dto.entryQualificationTypeId)
        verifyNoMoreInteractions(entryQualificationTypeService)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("EntryQualification should not be deleted");
        entryQualificationService.delete(new EntryQualification(id: 1))
    }
}

