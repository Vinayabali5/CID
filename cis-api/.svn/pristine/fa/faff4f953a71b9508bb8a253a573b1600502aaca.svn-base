package uk.ac.reigate.services

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.ilp.Correspondence
import uk.ac.reigate.dto.CorrespondenceDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilp.CorrespondenceRepository
import uk.ac.reigate.services.ilp.LetterService
import uk.ac.reigate.services.student.StudentService

class CorrespondenceServiceTest {
    
    @Mock
    private CorrespondenceRepository correspondenceRepository;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private CourseGroupService courseGroupService;
    
    @Mock
    private LetterService letterService;
    
    @Mock
    private CorrespondenceTypeService correspondenceTypeService
    
    @InjectMocks
    private CorrespondenceService correspondenceService;
    
    private Correspondence correspondence
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample Correspondence data object to use for the testing
     * 
     * @return a sample Correspondence data object
     */
    Correspondence createCorrespondence() {
        return new Correspondence(
                id: 1,
                date: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                from: "May",
                to: "June",
                staffAdvised: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                producedBy : 'Vinaya',
                privateEntry : true,
                processStage: 11,
                attachmentsSent : 'Yes',
                title : 'Test'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample Correspondence created at setup
     * 
     * @return a CorrespondenceDto object based on the sample Correspondence
     */
    CorrespondenceDto createDto() {
        Correspondence sampleCorrespondence = createCorrespondence();
        return new CorrespondenceDto(
                id: sampleCorrespondence.id,
                date: sampleCorrespondence.date,
                from: sampleCorrespondence.from,
                to: sampleCorrespondence.to,
                staffAdvised: sampleCorrespondence.staffAdvised,
                producedBy : sampleCorrespondence.producedBy,
                privateEntry : sampleCorrespondence.privateEntry,
                processStage: sampleCorrespondence.processStage,
                attachmentsSent : sampleCorrespondence.attachmentsSent,
                title : sampleCorrespondence.title
                )
    }
    
    /**
     * This method is used to set up the tests for the CorrespondenceService
     */
    @Before
    public void setup() {
        correspondenceRepository = mock(CorrespondenceRepository.class);
        studentService = mock(StudentService.class);
        courseGroupService = mock(CourseGroupService.class);
        letterService = mock(LetterService.class);
        correspondenceTypeService = mock(CorrespondenceTypeService.class);
        
        this.correspondenceService = new CorrespondenceService(correspondenceRepository, studentService, courseGroupService, letterService, correspondenceTypeService);
        
        correspondence = createCorrespondence()
        
        when(correspondenceRepository.findById(1)).thenReturn(new Optional(new Correspondence()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        CorrespondenceService service = new CorrespondenceService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Correspondence> result = correspondenceService.findAll();
        verify(correspondenceRepository, times(1)).findAll()
        verifyNoMoreInteractions(correspondenceRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Correspondence result = correspondenceService.findById(1);
        verify(correspondenceRepository, times(1)).findById(1)
        verifyNoMoreInteractions(correspondenceRepository)
    }
    
    @Test
    public void testGetByStudent() {
        Student student = new Student(id:190001)
        List<Correspondence> result = correspondenceService.getByStudent(190001);
        verify(correspondenceRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(correspondenceRepository)
    }
    
    @Test
    public void testGetByStudentAndCorrespondence() {
        Correspondence result = correspondenceService.getByStudentAndCorrespondence(19001, 2);
        verify(correspondenceRepository, times(1)).findByStudent_IdAndId(19001, 2)
        verifyNoMoreInteractions(correspondenceRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Correspondence savedCorrespondence = correspondenceService.save(correspondence);
        verify(correspondenceRepository, times(1)).save(any())
        verifyNoMoreInteractions(correspondenceRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Correspondence> savedCorrespondences = correspondenceService.saveCorrespondences([
            correspondence,
            correspondence
        ]);
        verify(correspondenceRepository, times(2)).save(correspondence)
        verifyNoMoreInteractions(correspondenceRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        CorrespondenceDto dto = createDto()
        Correspondence correspondenceSaved = correspondenceService.createFromDto(dto)
        verify(correspondenceRepository, times(1)).save(any(Correspondence.class))
        verifyNoMoreInteractions(correspondenceRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create Correspondence from null object.")
        CorrespondenceDto dto = null
        correspondenceService.createFromDto(dto)
        verifyNoMoreInteractions(correspondenceRepository)
    }
    
    @Test
    public void testCreateFromDto_withStudentId() {
        CorrespondenceDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        correspondenceService.createFromDto(dto)
        verify(correspondenceRepository, times(1)).save(any(Correspondence.class))
        verifyNoMoreInteractions(correspondenceRepository)
    }
    
    @Test
    public void testCreateFromDto_withCourseId() {
        CorrespondenceDto dto = createDto()
        dto.courseId = 1
        when(courseGroupService.findById(dto.courseId)).thenReturn(null);
        correspondenceService.createFromDto(dto)
        verify(correspondenceRepository, times(1)).save(any(Correspondence.class))
        verifyNoMoreInteractions(correspondenceRepository)
    }
    
    @Test
    public void testCreateFromDto_withLetterId() {
        CorrespondenceDto dto = createDto()
        dto.letterId = 1
        when(letterService.findById(dto.letterId)).thenReturn(null);
        correspondenceService.createFromDto(dto)
        verify(correspondenceRepository, times(1)).save(any(Correspondence.class))
        verifyNoMoreInteractions(correspondenceRepository)
    }
    
    @Test
    public void testCreateFromDto_withTypeId() {
        CorrespondenceDto dto = createDto()
        dto.typeId = 11
        when(correspondenceTypeService.findById(dto.typeId)).thenReturn(null);
        correspondenceService.createFromDto(dto)
        verify(correspondenceRepository, times(1)).save(any(Correspondence.class))
        verifyNoMoreInteractions(correspondenceRepository)
    }
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        CorrespondenceDto dto = createDto()
        Correspondence correspondenceSaved = correspondenceService.updateFromDto(dto)
        verify(correspondenceRepository, times(1)).findById(correspondence.id)
        verify(correspondenceRepository, times(1)).save(any(Correspondence.class))
        verifyNoMoreInteractions(correspondenceRepository)
    }
    
    @Test
    public void testUpdateFromDto_withStudentId() {
        CorrespondenceDto dto = createDto()
        dto.studentId = 19001
        when(studentService.findById(dto.studentId)).thenReturn(null);
        correspondenceService.updateFromDto(dto)
        verify(studentService, times(1)).findById(dto.studentId)
        verifyNoMoreInteractions(studentService)
    }
    
    @Test
    public void testUpdateFromDto_withCourseId() {
        CorrespondenceDto dto = createDto()
        dto.courseId = 1
        when(courseGroupService.findById(dto.courseId)).thenReturn(null);
        correspondenceService.updateFromDto(dto)
        verify(courseGroupService, times(1)).findById(dto.courseId)
        verifyNoMoreInteractions(courseGroupService)
    }
    
    @Test
    public void testUpdateFromDto_withLetterId() {
        CorrespondenceDto dto = createDto()
        dto.letterId = 1
        when(letterService.findById(dto.letterId)).thenReturn(null);
        correspondenceService.updateFromDto(dto)
        verify(letterService, times(1)).findById(dto.letterId)
        verifyNoMoreInteractions(letterService)
    }
    
    @Test
    public void testUpdateFromDto_withTypeId() {
        CorrespondenceDto dto = createDto()
        dto.typeId = 11
        when(correspondenceTypeService.findById(dto.typeId)).thenReturn(null);
        correspondenceService.updateFromDto(dto)
        verify(correspondenceTypeService, times(1)).findById(dto.typeId)
        verifyNoMoreInteractions(correspondenceTypeService)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create Correspondence from null object.")
        CorrespondenceDto dto = null
        correspondenceService.updateFromDto(dto)
        verifyNoMoreInteractions(correspondenceRepository)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        correspondenceService.delete(correspondence)
        verifyNoMoreInteractions(correspondenceRepository)
    }
}