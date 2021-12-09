package uk.ac.reigate.services.ilp

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.ilp.Letter;
import uk.ac.reigate.dto.LetterDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.repositories.ilp.LetterRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.CorrespondenceTypeService
import uk.ac.reigate.services.LetterTypeService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentYearService


class LetterServiceTest {
    
    @Mock
    private LetterRepository letterRepository
    
    @InjectMocks
    private LetterService letterService;
    
    @Mock
    private StudentService studentService;
    
    @Mock
    private StudentYearService studentYearService;
    
    @Mock
    private LetterTypeService letterTypeService;
    
    @Mock
    private AcademicYearService academicYearService;
    
    @Mock
    private ILPInterviewService ilpInterviewService
    
    @Mock
    private CorrespondenceTypeService correspondenceTypeService
    
    @Mock
    private StaffService staffService
    
    @Mock
    private LetterWarningParagraphService letterWarningParagraphService
    
    private Letter letter
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    Letter createLetter() {
        return new Letter(
                id: 1,
                subject: 'Testing'
                )
    }
    
    LetterDto createDto() {
        return new LetterDto(
                id: letter.id,
                subject: letter.subject
                )
    }
    
    @Before
    public void setup() {
        letterRepository = mock(LetterRepository.class);
        this.studentService = mock(StudentService.class);
        this.studentYearService = mock(StudentYearService.class);
        this.letterTypeService = mock(LetterTypeService.class);
        this.academicYearService = mock(AcademicYearService.class);
        this.ilpInterviewService = mock(ILPInterviewService.class);
        this.correspondenceTypeService = mock(CorrespondenceTypeService.class);
        this.staffService = mock(StaffService.class);
        this.letterWarningParagraphService = mock(LetterWarningParagraphService.class);
        
        letterService = new LetterService(letterRepository, studentService, StudentYearService studentYearService, LetterTypeService letterTypeService, AcademicYearService academicYearService, ILPInterviewService ilpInterviewService, CorrespondenceTypeService correspondenceTypeService, StaffService staffService, LetterWarningParagraphService letterWarningParagraphService);
        
        letter = createLetter()
        
        when(letterRepository.findById(letter.id)).thenReturn(new Optional(new Letter()));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        LetterService service = new LetterService();
        assertNotNull(service)
    }
    
    @Test
    public void testFindAll() {
        List<Letter> result = letterService.findAll();
        verify(letterRepository, times(1)).findAll()
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testGetByStudent() {
        Student student = new Student(id:190001)
        List<Letter> result = letterService.getByStudent(student);
        verify(letterRepository, times(1)).findByStudent(student)
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testFindAllByYear(){
        AcademicYear year = new AcademicYear(id:18, code:'18')
        List<Letter> result = letterService.findAllByYear(year);
        verify(letterRepository, times(1)).findByYear(year)
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testFindByAcdemicYearAndProcessingFlag(){
        AcademicYear year = new AcademicYear(id:18, code:'18')
        List<Letter> result = letterService.findByAcdemicYearAndProcessingFlag(year, 1);
        verify(letterRepository, times(1)).findByYearAndProcessingFlag(year, 1)
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testFindAuthorisedByAcdemicYear(){
        AcademicYear year = new AcademicYear(id:18, code:'18')
        List<Letter> result = letterService.findAuthorisedByAcdemicYear(year);
        verify(letterRepository, times(1)).findByYearAndRequestedDateIsNotNullAndAuthorisedDateIsNotNullAndProcessingFlagIs(year, 0)
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testFindGoingTonightByAcdemicYear(){
        AcademicYear year = new AcademicYear(id:18, code:'18')
        List<Letter> result = letterService.findGoingTonightByAcdemicYear(year);
        verify(letterRepository, times(1)).findByYearAndRequestedDateIsNotNullAndAuthorisedDateIsNotNullAndProcessingFlagIs(year, 1)
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testFindAuthorisedByAcdemicYearAndProcessingFlag(){
        AcademicYear year = new AcademicYear(id:18, code:'18')
        List<Letter> result = letterService.findAuthorisedByAcdemicYearAndProcessingFlag(year, 10);
        verify(letterRepository, times(1)).findByYearAndRequestedDateIsNotNullAndAuthorisedDateIsNotNullAndLetterDateIsNullAndPrintedDateIsNullAndProcessingFlagIs(year, 10)
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("Letters with a letter date should not be deleted.")
        letter.letterDate = new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09')
        letterService.delete(letter)
    }
    
    @Test
    public void testDeleteById() {
        letterService.delete(letter.id)
        verify(letterRepository, times(1)).deleteById(letter.id)
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testDeleteNullLetter() {
        letterService.delete(letter)
        verify(letterRepository, times(1)).delete(letter)
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testGetByStudentId() {
        List<Letter> result = letterService.getByStudentId(190001);
        verify(letterRepository, times(1)).findByStudent_Id(190001)
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testFindById() {
        Letter result = letterService.findById(1);
        verify(letterRepository, times(1)).findById(1)
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testSave() {
        Letter savedLetter = letterService.save(letter);
        verify(letterRepository, times(1)).save(any())
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testSaveLetter() {
        Letter savedLetter = letterService.save(letter);
        verify(letterRepository, times(1)).save(any())
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testSaveLetters() {
        List<Letter> savedLetters = letterService.saveLetters([
            new Letter(id : 1),
            new Letter(id: 2)
        ]);
        verify(letterRepository, times(2)).save(any(Letter.class))
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testSaveLetterByFields() {
        Letter savedLetter = letterService.save(letter);
        verify(letterRepository, times(1)).save(any())
        verifyNoMoreInteractions(letterRepository)
    }
    
    
    @Test
    public void testUpdateFromDto_NullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update a letter when no ID field is supplied.")
        LetterDto dto = new LetterDto(subject:'Test')
        dto.id = null
        letterService.updateFromDto(dto)
        verifyNoMoreInteractions(letterRepository)
    }
    
    @Test
    public void testUpdateFromDto_Dto() {
        LetterDto dto = createDto()
        letterService.updateFromDto(dto)
        verify(letterRepository, times(1)).findById(dto.id)
    }
    
    @Test
    public void testCreateFromDto_NullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create letter from null object.")
        LetterDto dto = null
        letterService.createFromDto(dto)
        verifyNoMoreInteractions(letterRepository)
    }
}

