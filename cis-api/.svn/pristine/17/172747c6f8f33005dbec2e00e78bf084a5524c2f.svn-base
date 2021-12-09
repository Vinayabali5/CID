package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.ilp.CorrespondenceType
import uk.ac.reigate.domain.ilp.ILPInterview
import uk.ac.reigate.domain.ilp.Letter
import uk.ac.reigate.domain.ilp.LetterType;
import uk.ac.reigate.domain.ilp.LetterWarningParagraph
import uk.ac.reigate.exceptions.InvalidDataException

public class LetterDtoTest {
    
    private Letter letter1
    
    private Letter letter2
    
    private Letter letter3
    
    private Letter letter4
    
    private List<Letter> letters
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    LetterType createLetterType() {
        LetterType letterType = new LetterType()
        letterType.id = 1
        letterType.type = 'Test'
        return letterType
    }
    
    LetterWarningParagraph createNonEntryWarning() {
        LetterWarningParagraph nonEntryWarning = new LetterWarningParagraph()
        nonEntryWarning.id = 1
        nonEntryWarning.description = 'test'
        return nonEntryWarning
    }
    
    @Before
    public void setup() {
        letter1 = new Letter(
                id: 1,
                year : new AcademicYear(id:1, code: '18', description: '2018'),
                student: createStudent(),
                interview : new ILPInterview(id:1),
                writtenBy : new Staff(id:1),
                requestedBy : new Staff(id:1),
                requestedDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                letterDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                subject : 'maths',
                regarding : 'Mr',
                reviewMeeting : true,
                attendance : true,
                behaviour : true,
                homework : true,
                punctuality : false,
                focus : true,
                deadlines : true,
                incompleteCoursework : true,
                nonEntryWarning : createNonEntryWarning(),
                letterType : createLetterType(),
                correspondenceType: new CorrespondenceType(id:1, type: 'test'),
                pending : new Staff(id:1)
                );
        letter2 = new Letter(
                id: 2,
                year : new AcademicYear(id:1),
                student: createStudent(),
                interview : new ILPInterview(id:1),
                writtenBy : new Staff(id:1),
                requestedBy : new Staff(id:1),
                requestedDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                letterDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                subject : 'maths',
                regarding : 'Mr',
                reviewMeeting : true,
                attendance : true,
                behaviour : true,
                homework : true,
                punctuality : false,
                focus : true,
                deadlines : true,
                incompleteCoursework : true,
                nonEntryWarning : createNonEntryWarning(),
                letterType : createLetterType(),
                correspondenceType: new CorrespondenceType(id:1)
                );
        letter3 = new Letter(
                id: 3,
                year : null,
                student: new Student(id:19001),
                interview : null,
                writtenBy : null,
                requestedBy : null,
                requestedDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                letterDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                subject : 'maths',
                regarding : 'Mr',
                reviewMeeting : true,
                attendance : true,
                behaviour : true,
                homework : true,
                punctuality : false,
                focus : true,
                deadlines : true,
                incompleteCoursework : true,
                nonEntryWarning : null,
                pending : null,
                letterType : null,
                correspondenceType: null
                );
        letter4 = new Letter(
                id: 4,
                year : null,
                student: null,
                interview : null,
                writtenBy : null,
                requestedBy : null,
                requestedDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                letterDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                subject : 'maths',
                regarding : 'Mr',
                reviewMeeting : true,
                attendance : true,
                behaviour : true,
                homework : true,
                punctuality : false,
                focus : true,
                deadlines : true,
                incompleteCoursework : true,
                nonEntryWarning : null,
                pending : null,
                letterType : null,
                correspondenceType: null
                );
        letters = Arrays.asList(letter1, letter2);
    }
    
    @Test
    public void testConstructor_NullObject() {
        Letter letter = null
        LetterDto letterDto = new LetterDto(letter)
        assertEquals( letter, null )
    }
    
    @Test
    public void testConstructor_Null_Objects() {
        LetterDto letterDto = new LetterDto(letter3)
        assertEquals( letterDto.yearId, letter3.year )
        assertEquals( letterDto.interviewId, letter3.interview )
        assertEquals( letterDto.letterTypeId, letter3.letterType)
        assertEquals( letterDto.pendingId, letter3.pending )
        assertEquals( letterDto.requestedDate, letter3.requestedDate )
        assertEquals( letterDto.letterDate, letter3.letterDate )
    }
    
    @Test
    public void testConstructor_NullStudent() {
        LetterDto letterDto = new LetterDto(letter4)
        assertEquals( letterDto.studentId, letter4.student)
    }
    
    @Test
    public void testMapFromLetterEntity(){
        LetterDto letterTest = LetterDto.mapFromEntity( letter1 )
        assertEquals( letterTest.id, letter1.id );
        assertEquals( letterTest.requestedDate, letter1.requestedDate);
        assertEquals( letterTest.letterDate, letter1.letterDate);
    }
    
    @Test
    public void testMapFromLettersEntities(){
        List<LetterDto> lettersDtoTest = LetterDto.mapFromList( letters )
        assertEquals( lettersDtoTest[0].id, letter1.id );
        assertEquals( lettersDtoTest[0].requestedDate, letter1.requestedDate);
        assertEquals( lettersDtoTest[0].letterDate, letter1.letterDate);
        assertEquals( lettersDtoTest[1].id, letter2.id );
        assertEquals( lettersDtoTest[1].requestedDate, letter2.requestedDate);
        assertEquals( lettersDtoTest[1].letterDate, letter2.letterDate);
    }
    
    @Test
    public void testEquals_Same() {
        LetterDto letterDto1 = new LetterDto(letter1)
        LetterDto letterDto2 = new LetterDto(letter1)
        assertEquals(letterDto1, letterDto2)
    }
    
    @Test
    public void testEquals_Different() {
        LetterDto letterDto1 = new LetterDto(letter1)
        LetterDto letterDto2 = new LetterDto(letter2)
        assertNotEquals(letterDto1, letterDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        LetterDto letterDto1 = new LetterDto(letter1)
        LetterDto letterDto2 = new LetterDto(letter1)
        assertEquals(letterDto1.hashCode(), letterDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        LetterDto letterDto1 = new LetterDto(letter1)
        LetterDto letterDto2 = new LetterDto(letter2)
        assertNotEquals(letterDto1.hashCode(), letterDto2.hashCode())
    }
    
    @Test
    public void testConstructor_Letter() {
        LetterDto letterDto = new LetterDto(letter1)
        assertEquals( letterDto.requestedDate, letter1.requestedDate )
        assertEquals( letterDto.letterDate, letter1.letterDate )
    }
    
    @Test
    public void testMethod_Get_NullAcademicYearCode() {
        LetterDto letterDto1 = new LetterDto(letter3)
        assertEquals(letterDto1.year, letterDto1.get_AcademicYearCode())
    }
    
    @Test
    public void testMethod_Get_AcademicYearCode() {
        LetterDto letterDto1 = new LetterDto(letter1)
        assertEquals(letterDto1.year.code, letterDto1.get_AcademicYearCode())
    }
    
    @Test
    public void testMethod_Get_Null_NonEntryWarningDescription() {
        LetterDto letterDto1 = new LetterDto(letter3)
        assertEquals(letterDto1.letterWarningParagraph, letterDto1.get_NonEntryWarningDescription())
    }
    
    @Test
    public void testMethod_Get_NonEntryWarningDescription() {
        LetterDto letterDto1 = new LetterDto(letter1)
        assertEquals(letterDto1.letterWarningParagraph.description, letterDto1.get_NonEntryWarningDescription())
    }
    
    @Test
    public void testMethod_Get_Null_LetterType() {
        LetterDto letterDto1 = new LetterDto(letter3)
        assertEquals(letterDto1.letterType, letterDto1.get_LetterType())
    }
    
    @Test
    public void testMethod_Get_LetterType() {
        LetterDto letterDto1 = new LetterDto(letter1)
        assertEquals(letterDto1.letterType.type, letterDto1.get_LetterType())
    }
    
    @Test
    public void testMethod_Get_Null_CorrespondenceType() {
        LetterDto letterDto1 = new LetterDto(letter3)
        assertEquals(letterDto1.correspondenceType, letterDto1.get_CorrespondenceType())
    }
    
    @Test
    public void testMethod_Get_CorrespondenceType() {
        LetterDto letterDto1 = new LetterDto(letter1)
        assertEquals(letterDto1.correspondenceType.type, letterDto1.get_CorrespondenceType())
    }
    
    @Test
    public void testMethod_Get_Null_PendingName() {
        LetterDto letterDto1 = new LetterDto(letter3)
        assertEquals(letterDto1.pending, letterDto1.get_PendingName())
    }
    
    @Test
    public void testMethod_Get_PendingName() {
        LetterDto letterDto1 = new LetterDto(letter1)
        assertEquals(letterDto1.pending.initials, letterDto1.get_PendingName())
    }
}
