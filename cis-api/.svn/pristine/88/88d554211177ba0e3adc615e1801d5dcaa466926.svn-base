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

import uk.ac.reigate.domain.ilr.FundingModel
import uk.ac.reigate.dto.FundingModelDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.FundingModelRepository


class FundingModelServiceTest {
    
    @Mock
    private FundingModelRepository fundingModelRepository;
    
    @InjectMocks
    private FundingModelService fundingModelService;
    
    private FundingModel fundingModel
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample FundingModel data object to use for the testing
     * 
     * @return a sample FundingModel data object
     */
    FundingModel createFundingModel() {
        return new FundingModel(
                id: 1,
                code: 'N',
                description: 'Test',
                shortDescription: 'Test',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo : new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/19  '),
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample FundingModel created at setup
     * 
     * @return a FundingModelDto object based on the sample FundingModel
     */
    FundingModelDto createDto() {
        return new FundingModelDto(
                id: fundingModel.id,
                code: fundingModel.code,
                description: fundingModel.description,
                shortDescription: fundingModel.shortDescription,
                validFrom: fundingModel.validFrom,
                validTo: fundingModel.validTo
                )
    }
    
    /**
     * This method is used to set up the tests for the FundingModelService
     */
    @Before
    public void setup() {
        this.fundingModelRepository = Mockito.mock(FundingModelRepository.class);
        this.fundingModelService = new FundingModelService(fundingModelRepository);
        
        fundingModel = createFundingModel()
        
        when(fundingModelRepository.save(any(FundingModel.class))).thenReturn(fundingModel);
        when(fundingModelRepository.findById(1)).thenReturn(new Optional(fundingModel));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        FundingModelService service = new FundingModelService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<FundingModel> result = fundingModelService.findAll();
        verify(fundingModelRepository, times(1)).findAll()
        verifyNoMoreInteractions(fundingModelRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        FundingModel result = fundingModelService.findById(1);
        verify(fundingModelRepository, times(1)).findById(1)
        verifyNoMoreInteractions(fundingModelRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        FundingModel savedFundingModel = fundingModelService.save(fundingModel);
        verify(fundingModelRepository, times(1)).save(any())
        verifyNoMoreInteractions(fundingModelRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<FundingModel> savedFundingModels = fundingModelService.saveFundingModels([fundingModel, fundingModel]);
        verify(fundingModelRepository, times(2)).save(fundingModel)
        verifyNoMoreInteractions(fundingModelRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        FundingModelDto dto = createDto()
        FundingModel fundingModelSaved = fundingModelService.createFromDto(dto)
        verify(fundingModelRepository, times(1)).save(any(FundingModel.class))
        verifyNoMoreInteractions(fundingModelRepository)
        assertEquals(dto.id, fundingModel.id)
        assertEquals(dto.code, fundingModel.code)
        assertEquals(dto.description, fundingModel.description)
        assertEquals(dto.shortDescription, fundingModel.shortDescription)
        assertEquals(dto.validFrom, fundingModel.validFrom)
        assertEquals(dto.validTo, fundingModel.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dtoWithNullValues() {
        FundingModelDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        FundingModel fundingModelSaved = fundingModelService.createFromDto(dto)
        verify(fundingModelRepository, times(1)).save(any(FundingModel.class))
        verifyNoMoreInteractions(fundingModelRepository)
        assertEquals(fundingModel.id, fundingModelSaved.id)
        assertEquals(fundingModel.code, fundingModelSaved.code)
        assertEquals(fundingModel.description, fundingModelSaved.description)
        assertEquals(fundingModel.shortDescription, fundingModelSaved.shortDescription)
        assertEquals(fundingModel.validFrom, fundingModelSaved.validFrom)
        assertEquals(fundingModel.validTo, fundingModelSaved.validTo)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create fundingModel from null object.")
        FundingModelDto dto = null
        fundingModelService.createFromDto(dto)
        verifyNoMoreInteractions(fundingModelRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        FundingModelDto dto = createDto()
        FundingModel fundingModelSaved = fundingModelService.updateFromDto(dto)
        verify(fundingModelRepository, times(1)).findById(fundingModel.id)
        verify(fundingModelRepository, times(1)).save(fundingModel)
        verifyNoMoreInteractions(fundingModelRepository)
        assertEquals(fundingModel.id, fundingModelSaved.id)
        assertEquals(fundingModel.code, fundingModelSaved.code)
        assertEquals(fundingModel.description, fundingModelSaved.description)
        assertEquals(fundingModel.shortDescription, fundingModelSaved.shortDescription)
        assertEquals(fundingModel.validFrom, fundingModelSaved.validFrom)
        assertEquals(fundingModel.validTo, fundingModelSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        FundingModelDto dto = createDto()
        dto.code = null
        dto.description = null
        dto.shortDescription = null
        dto.validFrom = null
        dto.validTo = null
        FundingModel fundingModelSaved = fundingModelService.updateFromDto(dto)
        verify(fundingModelRepository, times(1)).findById(fundingModel.id)
        verify(fundingModelRepository, times(1)).save(fundingModel)
        verifyNoMoreInteractions(fundingModelRepository)
        assertEquals(fundingModel.id, fundingModelSaved.id)
        assertEquals(fundingModel.code, fundingModelSaved.code)
        assertEquals(fundingModel.description, fundingModelSaved.description)
        assertEquals(fundingModel.shortDescription, fundingModelSaved.shortDescription)
        assertEquals(fundingModel.validFrom, fundingModelSaved.validFrom)
        assertEquals(fundingModel.validTo, fundingModelSaved.validTo)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update fundingModel from null object.")
        FundingModelDto dto = null
        fundingModelService.updateFromDto(dto)
        verifyNoMoreInteractions(fundingModelRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        fundingModelService.delete(fundingModel)
        verifyNoMoreInteractions(fundingModelRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}