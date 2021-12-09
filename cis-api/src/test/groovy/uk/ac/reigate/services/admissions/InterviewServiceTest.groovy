package uk.ac.reigate.services.admissions

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

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.School
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.admissions.OfferType
import uk.ac.reigate.domain.lookup.StudentType
import uk.ac.reigate.dto.admissions.InterviewDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.admissions.InterviewRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.lookup.StudentTypeService
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentYearService

@RunWith(MockitoJUnitRunner.class)
class InterviewServiceTest {
    
    @Mock
    private InterviewRepository interviewRepository;
    
    @Mock
    private StaffService staffService;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private OfferTypeService offerTypeService;
    
    @Mock
    private StudentTypeService studentTypeService;
    
    @Mock
    private StudentYearService studentYearService;
    
    @Mock
    private AcademicYearService academicYearService;
    
    @InjectMocks
    private InterviewService interviewService;
    
    private Student student
    
    private StudentYear studentYear
    
    private Person person
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    Student createStudent() {
        return new Student(
                id: 190001,
                referenceNo : 190001,
                interviewer : new Staff(id: 1465),
                interviewDate: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                offerType : new OfferType(id:1 ),
                possibleAspire : true,
                schoolReportNotSeen : true
                )
    }
    
    StudentYear createStudentYear() {
        return new StudentYear(
                student  : createStudent(),
                studentType : new StudentType(id:1)
                )
    }
    
    Person createPerson() {
        return new Person(
                id: 1,
                firstName: 'Michael',
                surname: 'Horgan',
                middleNames: 'Mich',
                home: '01737221118',
                dob:new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09')
                )
    }
    
    InterviewDto createDto() {
        return new InterviewDto(
                studentRef: 190001,
                studentId: 19001,
                surname : 'Bali',
                middleNames: 'Vinaya',
                dob:new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                )
    }
    @Before
    public void setup() {
        interviewRepository = mock(InterviewRepository.class);
        staffService = mock(StaffService.class);
        studentService= mock(StudentService.class)
        offerTypeService= mock(OfferTypeService.class)
        studentTypeService = mock(StudentTypeService.class);
        studentYearService = mock(StudentYearService.class)
        academicYearService = mock(AcademicYearService.class);
        
        interviewService = new InterviewService(interviewRepository, studentService, staffService, offerTypeService, studentTypeService, studentYearService, academicYearService);
        when(studentYearService.findByStudentAndYear(190001, 20)).thenReturn(
                new StudentYear())
    }
    
    @Test
    public void testServiceNoArgsConstructor() {
        InterviewService service = new InterviewService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<Student> result = interviewService.findAll();
        verify(studentService, times(1)).findAll()
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testFindById() {
        Student result = interviewService.findById(1);
        verify(studentService, times(1)).findById(1)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testSave() {
        Student student = new Student(id:19001)
        Student savedStudent = interviewService.save(student);
        verify(studentService, times(1)).save(any())
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_withDtoWithNoId() {
        // Stub Data and Method Returns
        InterviewDto dto = new InterviewDto()
        dto.studentId = null
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Student ID should not be null when updating");
        // Initialise Test
        interviewService.updateFromDto(dto)
        // Verify Results
    }
    
    @Test
    public void testUpdateDto_withDtoWithNoId() {
        // Stub Data and Method Returns
        InterviewDto dto = new InterviewDto()
        dto.studentId = null
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Student ID should not be null when updating");
        // Initialise Test
        interviewService.updateDto(dto)
        // Verify Results
    }
    
    @Test
    public void testUpdateDto_withDto() {
        // Stub Data and Method Returns
        InterviewDto dto = createDto()
        Student student = new Student(id: 190001, possibleAspire : true, schoolReportNotSeen : true)
        dto.studentId = 190001
        when(interviewService.findById(dto.studentId)).thenReturn(new Student(id: 190001))
        AcademicYear year = new AcademicYear(id: 20, code: '20')
        when(academicYearService.getNextAcademicYear()).thenReturn(new AcademicYear(id: 20))
        dto.studentTypeId = 19
        when(studentTypeService.findById(dto.studentTypeId)).thenReturn(null)
        // Initialise Test
        interviewService.updateDto(dto)
        verify(studentYearService, times(1)).save(any(StudentYear.class))
    }
    
    @Test
    public void testUpdateDto_withDtoNullStudentTypeId() {
        // Stub Data and Method Returns
        InterviewDto dto = createDto()
        Student student = new Student(id: 190001, possibleAspire : true, schoolReportNotSeen : true)
        dto.studentId = 190001
        when(interviewService.findById(dto.studentId)).thenReturn(new Student(id: 190001))
        AcademicYear year = new AcademicYear(id: 20, code: '20')
        when(academicYearService.getNextAcademicYear()).thenReturn(new AcademicYear(id: 20))
        dto.studentTypeId = null
        // Initialise Test
        interviewService.updateDto(dto)
        verify(studentYearService, times(1)).save(any(StudentYear.class))
    }
    
    @Test
    public void testUpdateDto_UpdateFromDto() {
        // Stub Data and Method Returns
        InterviewDto dto = createDto()
        Student student = new Student(id: 190001, possibleAspire : true, schoolReportNotSeen : true)
        dto.studentId = 190001
        when(interviewService.findById(dto.studentId)).thenReturn(new Student(id: 190001))
        AcademicYear year = new AcademicYear(id: 20, code: '20')
        when(academicYearService.getNextAcademicYear()).thenReturn(new AcademicYear(id: 20))
        dto.interviewerId = 11
        when(staffService.findById(dto.interviewerId)).thenReturn(null);
        dto.offerTypeId = 1
        when(offerTypeService.findById(dto.offerTypeId)).thenReturn(null);
        dto.studentTypeId = 19
        when(studentTypeService.findById(dto.studentTypeId)).thenReturn(null)
        // Initialise Test
        interviewService.updateFromDto(dto)
        verify(studentService, times(1)).save(any(Student.class))
        verify(studentYearService, times(1)).save(any(StudentYear.class))
    }
    
    @Test
    public void testUpdateDto_UpdateFromDtoWithNullIds() {
        // Stub Data and Method Returns
        InterviewDto dto = createDto()
        Student student = new Student(id: 190001, possibleAspire : true, schoolReportNotSeen : true)
        dto.studentId = 190001
        when(interviewService.findById(dto.studentId)).thenReturn(new Student(id: 190001))
        AcademicYear year = new AcademicYear(id: 20, code: '20')
        when(academicYearService.getNextAcademicYear()).thenReturn(new AcademicYear(id: 20))
        dto.interviewerId = null
        dto.offerTypeId = null
        dto.studentTypeId = null
        // Initialise Test
        interviewService.updateFromDto(dto)
        verify(studentService, times(1)).save(any(Student.class))
        verify(studentYearService, times(1)).save(any(StudentYear.class))
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("Student should not be deleted");
        interviewService.delete(new Student(id: 1))
    }
}

