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

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentCareersRecord
import uk.ac.reigate.dto.careers.StudentCareersRecordDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.StudentCareersRecordRepository
import uk.ac.reigate.services.student.StudentService


class StudentCareersRecordServiceTest {
    
    @Mock
    private StudentCareersRecordRepository studentCareersRecordRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private CareersRecordTypeService careersRecordTypeService;
    
    @InjectMocks
    private StudentCareersRecordService studentCareersRecordService;
    
    private StudentCareersRecord studentCareersRecord
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample StudentCareersRecord data object to use for the testing
     * 
     * @return a sample StudentCareersRecord data object
     */
    StudentCareersRecord createStudentCareersRecord() {
        return new StudentCareersRecord(
                id: 1,
                note: 'Testing',
                organiser: 'Reigate'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample StudentCareersRecord created at setup
     * 
     * @return a StudentCareersRecordDto object based on the sample StudentCareersRecord
     */
    StudentCareersRecordDto createDto() {
        return new StudentCareersRecordDto(
                id: studentCareersRecord.id,
                note: studentCareersRecord.note,
                organiser: studentCareersRecord.organiser
                )
    }
    
    /**
     * This method is used to set up the tests for the StudentCareersRecordService
     */
    @Before
    public void setup() {
        studentCareersRecordRepository = mock(StudentCareersRecordRepository.class);
        studentService = mock(StudentService.class);
        careersRecordTypeService = mock(CareersRecordTypeService.class);
        
        this.studentCareersRecordService = new StudentCareersRecordService(studentCareersRecordRepository, studentService, careersRecordTypeService);
        
        studentCareersRecord = createStudentCareersRecord()
        
        when(studentCareersRecordRepository.save(any(StudentCareersRecord.class))).thenReturn(studentCareersRecord);
        when(studentCareersRecordRepository.findById(1)).thenReturn(new Optional(studentCareersRecord));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        StudentCareersRecordService service = new StudentCareersRecordService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<StudentCareersRecord> result = studentCareersRecordService.findAll();
        verify(studentCareersRecordRepository, times(1)).findAll()
        verifyNoMoreInteractions(studentCareersRecordRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        StudentCareersRecord result = studentCareersRecordService.findById(1);
        verify(studentCareersRecordRepository, times(1)).findById(1)
        verifyNoMoreInteractions(studentCareersRecordRepository)
    }
    
    @Test
    public void testFindByStudentId() {
        StudentCareersRecord result = studentCareersRecordService.findByStudentId(190001);
        verify(studentCareersRecordRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(studentCareersRecordRepository)
    }
    
    @Test
    public void testFindByCareersRecordTypeId() {
        List<StudentCareersRecord> result = studentCareersRecordService.findByCareersRecordTypeId(19);
        verify(studentCareersRecordRepository, times(1)).findByCareersRecordType_Id(19)
        verifyNoMoreInteractions(studentCareersRecordRepository)
    }
    
    @Test
    public void testFindByStudent() {
        Student student = new Student(id: 200004)
        List<StudentCareersRecord> result = studentCareersRecordService.findByStudent(student)
        verify(studentCareersRecordRepository, times(1)).findByStudent_Id(student.id)
        verifyNoMoreInteractions(studentCareersRecordRepository)
    }
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        StudentCareersRecord savedStudentCareersRecord = studentCareersRecordService.save(studentCareersRecord);
        verify(studentCareersRecordRepository, times(1)).save(any())
        verifyNoMoreInteractions(studentCareersRecordRepository)
    }
    
    @Test
    public void testDeleteById() {
        studentCareersRecordService.deleteById(studentCareersRecord.id)
        verify(studentCareersRecordRepository, times(1)).deleteById(studentCareersRecord.id)
        verifyNoMoreInteractions(studentCareersRecordRepository)
    }
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        StudentCareersRecordDto dto = createDto()
        StudentCareersRecord studentCareersRecordSaved = studentCareersRecordService.createFromDto(dto)
        verify(studentCareersRecordRepository, times(1)).save(any(StudentCareersRecord.class))
        verifyNoMoreInteractions(studentCareersRecordRepository)
        assertEquals(dto.id, studentCareersRecord.id)
        assertEquals(dto.note, studentCareersRecord.note)
        assertEquals(dto.organiser, studentCareersRecord.organiser)
    }
    
    @Test
    public void testCreateFromDto_withStudentId() {
        StudentCareersRecordDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        StudentCareersRecord studentCareersRecordSaved = studentCareersRecordService.createFromDto(dto)
        verify(studentCareersRecordRepository, times(1)).save(any(StudentCareersRecord.class))
        verifyNoMoreInteractions(studentCareersRecordRepository)
    }
    
    @Test
    public void testCreateFromDto_withCareersRecordTypeId() {
        StudentCareersRecordDto dto = createDto()
        dto.careersRecordTypeId = 1
        when(studentService.findById(dto.careersRecordTypeId)).thenReturn(null);
        StudentCareersRecord studentCareersRecordSaved = studentCareersRecordService.createFromDto(dto)
        verify(studentCareersRecordRepository, times(1)).save(any(StudentCareersRecord.class))
        verifyNoMoreInteractions(studentCareersRecordRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create studentCareersRecordDto from null object.")
        StudentCareersRecordDto dto = null
        studentCareersRecordService.createFromDto(dto)
        verifyNoMoreInteractions(studentCareersRecordRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        StudentCareersRecordDto dto = createDto()
        StudentCareersRecord studentCareersRecordSaved = studentCareersRecordService.updateFromDto(dto)
        verify(studentCareersRecordRepository, times(1)).findById(studentCareersRecord.id)
        verify(studentCareersRecordRepository, times(1)).save(studentCareersRecord)
        verifyNoMoreInteractions(studentCareersRecordRepository)
        assertEquals(studentCareersRecord.id, studentCareersRecordSaved.id)
        assertEquals(studentCareersRecord.note, studentCareersRecordSaved.note)
        assertEquals(studentCareersRecord.organiser, studentCareersRecordSaved.organiser)
    }
    
    @Test
    public void testUpdateFromDto_withStudentId() {
        StudentCareersRecordDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        StudentCareersRecord studentCareersRecordSaved = studentCareersRecordService.updateFromDto(dto)
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_withCareersRecordTypeId() {
        StudentCareersRecordDto dto = createDto()
        dto.careersRecordTypeId = 1
        when(careersRecordTypeService.findById(dto.careersRecordTypeId)).thenReturn(null);
        StudentCareersRecord studentCareersRecordSaved = studentCareersRecordService.updateFromDto(dto)
        verify(careersRecordTypeService, times(1)).findById(dto.careersRecordTypeId)
        verifyNoMoreInteractions(careersRecordTypeService)
    }
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        StudentCareersRecordDto dto = createDto()
        StudentCareersRecord studentCareersRecordSaved = studentCareersRecordService.updateFromDto(dto)
        verify(studentCareersRecordRepository, times(1)).findById(studentCareersRecord.id)
        verify(studentCareersRecordRepository, times(1)).save(studentCareersRecord)
        verifyNoMoreInteractions(studentCareersRecordRepository)
        assertEquals(studentCareersRecord.id, studentCareersRecordSaved.id)
        assertEquals(studentCareersRecord.note, studentCareersRecordSaved.note)
        assertEquals(studentCareersRecord.organiser, studentCareersRecordSaved.organiser)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update studentCareersRecordDto from null object.")
        StudentCareersRecordDto dto = null
        studentCareersRecordService.updateFromDto(dto)
        verifyNoMoreInteractions(studentCareersRecordRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        studentCareersRecordService.delete(studentCareersRecord)
        verifyNoMoreInteractions(studentCareersRecordRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}