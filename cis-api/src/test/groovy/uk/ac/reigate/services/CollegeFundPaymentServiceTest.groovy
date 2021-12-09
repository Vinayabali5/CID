package uk.ac.reigate.services

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import uk.ac.reigate.domain.admissions.CollegeFundPayment
import uk.ac.reigate.dto.CollegeFundPaymentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.StudentRepository
import uk.ac.reigate.repositories.admissions.CollegeFundPaymentRepository
import uk.ac.reigate.services.student.StudentService

@RunWith(MockitoJUnitRunner.class)
class CollegeFundPaymentServiceTest {
    
    @Mock
    private CollegeFundPaymentRepository collegeFundPaymentRepository
    
    @InjectMocks
    private CollegeFundPaymentService collegeFundPaymentService;
    
    private CollegeFundPayment collegeFundPayment
    
    private StudentRepository studentRepository
    
    @Mock
    private StudentService studentService
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    CollegeFundPayment createCollegeFundPayment() {
        return new CollegeFundPayment(
                id: 99,
                paymentDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                payee: 'Vinaya',
                giftAid: false,
                cash: true,
                chequeDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09')
                )
    }
    
    CollegeFundPaymentDto createDto() {
        CollegeFundPayment sampleCollegeFundPayment = createCollegeFundPayment();
        return new CollegeFundPaymentDto(
                id: sampleCollegeFundPayment.id,
                paymentDate: sampleCollegeFundPayment.paymentDate,
                payee: sampleCollegeFundPayment.payee,
                giftAid: sampleCollegeFundPayment.giftAid,
                cash: sampleCollegeFundPayment.cash,
                chequeDate: sampleCollegeFundPayment.chequeDate
                )
    }
    
    @Before
    public void setup() {
        collegeFundPaymentRepository = mock(CollegeFundPaymentRepository.class);
        studentService = mock(StudentService.class);
        collegeFundPaymentService = new CollegeFundPaymentService(collegeFundPaymentRepository, studentService);
        
        collegeFundPayment = createCollegeFundPayment()
        when(collegeFundPaymentRepository.findById(collegeFundPayment.id)).thenReturn(new Optional(new CollegeFundPayment()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        CollegeFundPaymentService service = new CollegeFundPaymentService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<CollegeFundPayment> result = collegeFundPaymentService.findAll();
        verify(collegeFundPaymentRepository, times(1)).findAll()
        verifyNoMoreInteractions(collegeFundPaymentRepository)
    }
    
    @Test
    public void testFindById() {
        CollegeFundPayment result = collegeFundPaymentService.findById(1);
        verify(collegeFundPaymentRepository, times(1)).findById(1)
        verifyNoMoreInteractions(collegeFundPaymentRepository)
    }
    
    @Test
    public void testSave() {
        collegeFundPayment.id = null
        CollegeFundPayment savedCollegeFundPayment = collegeFundPaymentService.save(new CollegeFundPayment());
        verify(collegeFundPaymentRepository, times(1)).save(any(CollegeFundPayment.class))
        verifyNoMoreInteractions(collegeFundPaymentRepository)
    }
    
    @Test
    public void testSaveCollegeFundPaymentes() {
        List<CollegeFundPayment> savedCollegeFundPaymentes = collegeFundPaymentService.saveCollegeFundPayments([
            new CollegeFundPayment(id: 1),
            new CollegeFundPayment(id: 2)
        ])
        verify(collegeFundPaymentRepository, times(2)).save(any(CollegeFundPayment.class))
        verifyNoMoreInteractions(collegeFundPaymentRepository)
    }
    
    @Test
    public void testCreateFromDto_dto() {
        CollegeFundPaymentDto dto = createDto()
        collegeFundPaymentService.createFromDto(dto)
        verify(collegeFundPaymentRepository, times(1)).save(any(CollegeFundPayment.class))
        verifyNoMoreInteractions(collegeFundPaymentRepository)
    }
    
    @Test
    public void testCreateFromDto_dtoWithStudentId() {
        CollegeFundPaymentDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        collegeFundPaymentService.createFromDto(dto)
        verify(collegeFundPaymentRepository, times(1)).save(any(CollegeFundPayment.class))
        verifyNoMoreInteractions(collegeFundPaymentRepository)
    }
    
    @Test
    public void testUpdateFromDto_withDtoWithNoId() {
        // Stub Data and Method Returns
        CollegeFundPaymentDto dto = createDto()
        dto.id = null
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("CollegeFundPayment ID should not be null when updating");
        // Initialise Test
        collegeFundPaymentService.updateFromDto(dto)
        // Verify Results
        verifyNoMoreInteractions(collegeFundPaymentRepository)
    }
    
    @Test
    public void testUpdateFromDto_dto() {
        CollegeFundPaymentDto dto = createDto()
        dto.studentId = null
        collegeFundPaymentService.updateFromDto(dto)
        verify(collegeFundPaymentRepository, times(1)).findById(collegeFundPayment.id)
        verify(collegeFundPaymentRepository, times(1)).save(any(CollegeFundPayment.class))
        verifyNoMoreInteractions(collegeFundPaymentRepository)
    }
    
    @Test
    public void testUpdateFromDto_withStudentId() {
        // Stub Data and Method Returns
        CollegeFundPaymentDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        // Initialise Test
        collegeFundPaymentService.updateFromDto(dto)
        // Verify Results
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        CollegeFundPaymentDto dto = new CollegeFundPaymentDto(payee: '123')
        collegeFundPaymentService.updateFromDto(dto)
        verifyNoMoreInteractions(collegeFundPaymentRepository)
    }
    
    @Test
    public void testFindCollegeFundPaymentsByStudentId() {
        List<CollegeFundPayment> result = collegeFundPaymentService.findCollegeFundPaymentsByStudentId(190001);
        verify(collegeFundPaymentRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(collegeFundPaymentRepository)
    }
    
    @Test
    public void testGetByStudent() {
        List<CollegeFundPayment> result = collegeFundPaymentService.getByStudent(190001);
        verify(collegeFundPaymentRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(collegeFundPaymentRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("CollegeFundPayment should not be deleted");
        collegeFundPaymentService.delete(new CollegeFundPayment(id: 1))
        verifyNoMoreInteractions(collegeFundPaymentRepository)
    }
}