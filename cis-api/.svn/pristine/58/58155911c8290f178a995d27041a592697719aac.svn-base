package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.domain.learning_support.ReferralReason
import uk.ac.reigate.dto.ReferralReasonDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.learning_support.ReferralReasonRepository

@RunWith(MockitoJUnitRunner.class)
class ReferralReasonServiceTest {
    
    @Mock
    private ReferralReasonRepository referralReasonRepository;
    
    @Mock
    LLDDHealthProblemCategoryService lLDDHealthProblemCategoryService;
    
    @InjectMocks
    private ReferralReasonService referralReasonService;
    
    private ReferralReason referralReason;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    ReferralReason createReferralReason() {
        return new ReferralReason(
                id: 1,
                reason: 'M'
                )
    }
    
    ReferralReasonDto createDto() {
        ReferralReason sampleData = createReferralReason()
        return new ReferralReason(
                id: sampleData.id,
                reason: sampleData.reason
                )
    }
    
    @Before
    public void setup() {
        referralReasonRepository = mock(ReferralReasonRepository.class);
        lLDDHealthProblemCategoryService = mock(LLDDHealthProblemCategoryService.class)
        this.referralReasonService = new ReferralReasonService(referralReasonRepository, lLDDHealthProblemCategoryService);
        
        referralReason = createReferralReason()
        
        when(referralReasonRepository.findById(1)).thenReturn(new Optional(new ReferralReason()));
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        ReferralReasonService service = new ReferralReasonService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindReferralReasons() {
        List<ReferralReason> result = referralReasonService.findAll();
        verify(referralReasonRepository, times(1)).findAll()
        verifyNoMoreInteractions(referralReasonRepository)
    }
    
    @Test
    public void testFindReferralReason() {
        ReferralReason result = referralReasonService.findById(1);
        verify(referralReasonRepository, times(1)).findById(1)
        verifyNoMoreInteractions(referralReasonRepository)
    }
    
    @Test
    public void testSaveNewReferralReason() {
        ReferralReason savedReferralReason = referralReasonService.save(referralReason);
        verify(referralReasonRepository, times(1)).save(any(ReferralReason.class))
        verifyNoMoreInteractions(referralReasonRepository)
    }
    
    @Test
    public void testSaveReferralReason() {
        ReferralReason savedReferralReason = referralReasonService.save(referralReason);
        verify(referralReasonRepository, times(1)).save(any(ReferralReason.class))
        verifyNoMoreInteractions(referralReasonRepository)
    }
    
    @Test
    public void testSaveReferralReasons() {
        List<ReferralReason> savedReferralReasons = referralReasonService.saveReferralReasons([
            new ReferralReason(id: 1),
            new ReferralReason(id: 2)
        ]);
        verify(referralReasonRepository, times(2)).save(any(ReferralReason.class))
        verifyNoMoreInteractions(referralReasonRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        ReferralReasonDto dto = new ReferralReasonDto(id: 1, reason: 'Test')
        referralReasonService.createFromDto(dto)
        verify(referralReasonRepository, times(1)).save(any(ReferralReason.class))
        verifyNoMoreInteractions(referralReasonRepository)
    }
    
    @Test
    public void testCreateFromDto_llddHealthProblemCategoryId() {
        ReferralReasonDto dto = new ReferralReasonDto(id: 1, reason: 'Test')
        dto.llddHealthProblemCategoryId= 1
        when(lLDDHealthProblemCategoryService.findById(dto.llddHealthProblemCategoryId)).thenReturn(null)
        referralReasonService.createFromDto(dto)
        verify(referralReasonRepository, times(1)).save(any(ReferralReason.class))
        verifyNoMoreInteractions(referralReasonRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        ReferralReasonDto dto = new ReferralReasonDto(id: 1, reason: 'Test')
        dto.llddHealthProblemCategoryId = null
        referralReasonService.updateFromDto(dto)
        verify(referralReasonRepository, times(1)).findById(referralReason.id)
        verify(referralReasonRepository, times(1)).save(any(ReferralReason.class))
        verifyNoMoreInteractions(referralReasonRepository)
    }
    
    @Test
    public void testUpdateFromDto_llddHealthProblemCategoryId() {
        ReferralReasonDto dto = new ReferralReasonDto(id: 1, reason: 'Test')
        dto.llddHealthProblemCategoryId = 1
        when(lLDDHealthProblemCategoryService.findById(dto.llddHealthProblemCategoryId)).thenReturn(null)
        referralReasonService.updateFromDto(dto)
        verify(referralReasonRepository, times(1)).findById(referralReason.id)
        verify(referralReasonRepository, times(1)).save(any(ReferralReason.class))
        verifyNoMoreInteractions(referralReasonRepository)
    }
    
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        ReferralReasonDto dto = new ReferralReasonDto(id: 1, reason: 'Test')
        dto.llddHealthProblemCategoryId = null
        referralReasonService.updateFromDto(dto)
        verify(referralReasonRepository, times(1)).findById(referralReason.id)
        verify(referralReasonRepository, times(1)).save(any(ReferralReason.class))
        verifyNoMoreInteractions(referralReasonRepository)
    }
    
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create referralReasonDto from null object.")
        ReferralReasonDto dto = null
        referralReasonService.createFromDto(dto)
        verifyNoMoreInteractions(referralReasonRepository)
    }
    
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update referralReasonDto from null object.")
        ReferralReasonDto dto = null
        referralReasonService.updateFromDto(dto)
        verifyNoMoreInteractions(referralReasonRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        referralReasonService.delete(referralReason)
        verifyNoMoreInteractions(referralReasonRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}

