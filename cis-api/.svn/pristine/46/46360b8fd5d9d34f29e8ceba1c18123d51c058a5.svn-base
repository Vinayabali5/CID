package uk.ac.reigate.services

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

import uk.ac.reigate.domain.exams.edi.EdiStatusType
import uk.ac.reigate.dto.exams.edi.EdiStatusTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.exams.edi.EdiStatusTypeRepository


class EdiStatusTypeServiceTest {
    
    @Mock
    private EdiStatusTypeRepository ediStatusTypeRepository;
    
    @InjectMocks
    private EdiStatusTypeService ediStatusTypeService;
    
    private EdiStatusType ediStatusType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    /**
     * This method is used to create a sample EdiStatusType data object to use for the testing
     *
     * @return a sample EdiStatusType data object
     */
    EdiStatusType createEdiStatusType() {
        return new EdiStatusType(
                id: 99,
                code: 'G',
                description: 'Good'
                )
    }
    
    /**
     * This method is used to set up the tests for the EdiStatusTypeService
     */
    @Before
    public void setup() {
        this.ediStatusTypeRepository = Mockito.mock(EdiStatusTypeRepository.class);
        this.ediStatusTypeService = new EdiStatusTypeService(ediStatusTypeRepository);
        
        ediStatusType = createEdiStatusType()
        
        when(ediStatusTypeRepository.save(any(EdiStatusType.class))).thenReturn(ediStatusType);
        when(ediStatusTypeRepository.findById(ediStatusType.id)).thenReturn(new Optional(ediStatusType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        EdiStatusTypeService service = new EdiStatusTypeService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<EdiStatusType> result = ediStatusTypeService.findAll();
        verify(ediStatusTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(ediStatusTypeRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        EdiStatusType result = ediStatusTypeService.findById(1);
        verify(ediStatusTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(ediStatusTypeRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        EdiStatusType savedEdiStatusType = ediStatusTypeService.save(new EdiStatusType());
        verify(ediStatusTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(ediStatusTypeRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<EdiStatusType> savedEdiStatusTypes = ediStatusTypeService.saveEdiStatusTypes([ediStatusType, ediStatusType]);
        verify(ediStatusTypeRepository, times(2)).save(ediStatusType)
        verifyNoMoreInteractions(ediStatusTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create ediStatusType from null object.")
        EdiStatusTypeDto dto = null
        ediStatusTypeService.createFromDto(dto)
        verifyNoMoreInteractions(ediStatusTypeRepository)
    }
    
    @Test
    public void testCreteFromDto_dto() {
        EdiStatusTypeDto dto = new EdiStatusTypeDto(id: 1, code: 'test', description:'Testing')
        ediStatusTypeService.createFromDto(dto)
        verify(ediStatusTypeRepository, times(1)).save(any(EdiStatusType.class))
        verifyNoMoreInteractions(ediStatusTypeRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create ediStatusType from null object.")
        EdiStatusTypeDto dto = null
        ediStatusTypeService.updateFromDto(dto)
        verify(ediStatusTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(ediStatusTypeRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method with null dto
     */
    @Test
    public void testupdateFromDto_withDto() {
        EdiStatusTypeDto dto = new EdiStatusTypeDto()
        when(ediStatusTypeRepository.findById(dto.id)).thenReturn(new Optional(new EdiStatusType(id: 1, code: 'Test', description:'Testing')));
        ediStatusTypeService.updateFromDto(dto)
        verify(ediStatusTypeRepository, times(1)).save(any())
    }
    
    /**
     * This method is used to test the delete service method.
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("EdiStatusType cannot be deleted")
        ediStatusTypeService.delete(new EdiStatusType(id: 1))
    }
}

