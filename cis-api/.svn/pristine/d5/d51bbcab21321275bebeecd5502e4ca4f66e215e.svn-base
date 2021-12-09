package uk.ac.reigate.services.ilp

import static org.mockito.Mockito.*
import static org.junit.Assert.assertNotNull
import static org.assertj.core.api.Assertions.assertThatExceptionOfType

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito

import uk.ac.reigate.domain.ilp.ILPInterviewType;
import uk.ac.reigate.dto.ilp.ILPInterviewTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.ilp.ILPInterviewTypeRepository


class ILPInterviewTypeServiceTest {
    
    private ILPInterviewTypeRepository iLPInterviewTypeRepository
    
    private ILPInterviewTypeService iLPInterviewTypeService;
    
    private ILPInterviewType iLPInterviewType
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    @Before
    public void setup() {
        this.iLPInterviewTypeRepository = Mockito.mock(ILPInterviewTypeRepository.class);
        this.iLPInterviewTypeService = new ILPInterviewTypeService(iLPInterviewTypeRepository);
        
        iLPInterviewType = new ILPInterviewType(
                id: 1,
                type: 'A'
                )
        
        when(iLPInterviewTypeRepository.findById(1)).thenReturn(new Optional(iLPInterviewType));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        ILPInterviewTypeService service = new ILPInterviewTypeService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<ILPInterviewType> result = iLPInterviewTypeService.findAll();
        verify(iLPInterviewTypeRepository, times(1)).findAll()
        verifyNoMoreInteractions(iLPInterviewTypeRepository)
    }
    
    @Test
    public void testFindById() {
        ILPInterviewType result = iLPInterviewTypeService.findById(1);
        verify(iLPInterviewTypeRepository, times(1)).findById(1)
        verifyNoMoreInteractions(iLPInterviewTypeRepository)
    }
    
    @Test
    public void testSave() {
        ILPInterviewType savedILPInterviewType = iLPInterviewTypeService.save(iLPInterviewType);
        verify(iLPInterviewTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(iLPInterviewTypeRepository)
    }
    
    @Test
    public void testSaveILPInterviewType() {
        ILPInterviewType savedILPInterviewType = iLPInterviewTypeService.save(iLPInterviewType);
        verify(iLPInterviewTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(iLPInterviewTypeRepository)
    }
    
    @Test
    public void testSaveILPInterviewTypes() {
        List<ILPInterviewType> savedILPInterviewTypes = iLPInterviewTypeService.saveILPInterviewTypes([
            new ILPInterviewType(id : 1),
            new ILPInterviewType(id: 2)
        ]);
        verify(iLPInterviewTypeRepository, times(2)).save(any(ILPInterviewType.class))
        verifyNoMoreInteractions(iLPInterviewTypeRepository)
    }
    
    @Test
    public void testSaveILPInterviewTypeByFields() {
        ILPInterviewType savedILPInterviewType = iLPInterviewTypeService.save(iLPInterviewType);
        verify(iLPInterviewTypeRepository, times(1)).save(any())
        verifyNoMoreInteractions(iLPInterviewTypeRepository)
    }
    
    @Test
    public void testCreateFromDto_Dto() {
        ILPInterviewTypeDto dto = new ILPInterviewTypeDto(id: 1, type:'Test')
        iLPInterviewTypeService.createFromDto(dto)
        verify(iLPInterviewTypeRepository, times(1)).save(any(ILPInterviewType.class))
        verifyNoMoreInteractions(iLPInterviewTypeRepository)
    }
    
    @Test
    public void testUpdateFromDto_Dto() {
        ILPInterviewTypeDto dto = new ILPInterviewTypeDto(id: 1, type:'Test')
        iLPInterviewTypeService.updateFromDto(dto)
        verify(iLPInterviewTypeRepository, times(1)).findById(dto.id)
        verify(iLPInterviewTypeRepository, times(1)).save(any(ILPInterviewType.class))
        verifyNoMoreInteractions(iLPInterviewTypeRepository)
    }
    
    @Test
    public void testCreateFromDto_WithNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create ILPInterviewType from null object.")
        ILPInterviewTypeDto dto = null
        iLPInterviewTypeService.createFromDto(dto)
        verifyNoMoreInteractions(iLPInterviewTypeRepository)
    }
    
    @Test
    public void testupdateFromDto_WithNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update ILPInterviewType from null object.")
        ILPInterviewTypeDto dto = null
        iLPInterviewTypeService.updateFromDto(dto)
        verifyNoMoreInteractions(iLPInterviewTypeRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidDataException.class)
        iLPInterviewTypeService.delete(iLPInterviewType)
        verifyNoMoreInteractions(iLPInterviewTypeRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

