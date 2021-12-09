package uk.ac.reigate.dto.ilp;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.ilp.ILPInterview
import uk.ac.reigate.domain.ilp.ILPInterviewType
import uk.ac.reigate.domain.ilp.Letter
import uk.ac.reigate.domain.ilp.LetterType
import uk.ac.reigate.domain.ilp.OfficeAction



public class ILPInterviewDtoTest {
    
    private ILPInterview iLPInterview1
    
    private ILPInterview iLPInterview2
    
    private ILPInterview iLPInterview3
    
    private ILPInterview iLPInterview4
    
    private List<ILPInterview> iLPInterviews
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    ILPInterviewType createType() {
        ILPInterviewType type = new ILPInterviewType()
        type.id = 1
        return type
    }
    
    CourseGroup createCourseGroup() {
        CourseGroup courseGroup = new CourseGroup()
        courseGroup.id = 1
        return courseGroup
    }
    
    AcademicYear getAcademicYear(){
        AcademicYear academicYear = new AcademicYear()
    }
    
    @Before
    public void setup() {
        iLPInterview1 = new ILPInterview(
                id: 1,
                student: createStudent(),
                type: createType(),
                staff:new Staff(id: 1, person: new Person(id: 1, firstName: 'Vinaya', surname: 'Bali'), signature: 'vinaya'),
                discussion:'M',
                interviewDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                interviewTime: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                referLip: false,
                lipReferDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                privateEntry: false,
                officeActionString : null,
                officeNotes : 'Some note here',
                toFile : true,
                target: 'Test',
                targetByWhen: 'OnGoing',
                academicYear: getAcademicYear(),
                officeAction: new OfficeAction(),
                courseGroup : new CourseGroup(),
                letter: new Letter(id: 1, letterType: new LetterType(id: 1, type: 'test') )
                );
        iLPInterview2 = new ILPInterview(
                id: 2,
                student: createStudent(),
                type: createType(),
                staff:new Staff(id: 1, person: null),
                discussion:'M',
                interviewDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                interviewTime: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                referLip: true,
                lipReferDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                privateEntry: true,
                officeActionString : '100',
                officeNotes : 'nothing',
                toFile : true,
                target: 'Test',
                targetByWhen: 'OnGoing',
                academicYear: getAcademicYear(),
                officeAction: new OfficeAction(),
                courseGroup : new CourseGroup(),
                letter: null
                );
        iLPInterview3 = new ILPInterview(
                id: 2,
                student: null,
                type: null,
                staff:new Staff(id: 1, person : null),
                discussion:'M',
                interviewDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                interviewTime: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                referLip: true,
                lipReferDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                privateEntry: true,
                officeActionString : '100',
                officeNotes : 'nothing',
                toFile : true,
                target: 'Test',
                targetByWhen: 'OnGoing',
                academicYear: null,
                officeAction: null,
                courseGroup : null,
                letter : null
                );
        iLPInterviews = Arrays.asList(iLPInterview1, iLPInterview2);
    }
    
    @Test
    public void testConstructor_NullStudent() {
        ILPInterviewDto iLPInterviewTest= new ILPInterviewDto(iLPInterview3)
        assertEquals( iLPInterviewTest.discussion, iLPInterview3.discussion);
        assertEquals( iLPInterviewTest.interviewDate, iLPInterview3.interviewDate);
        assertEquals( iLPInterviewTest.interviewTime, iLPInterview3.interviewTime)
        assertEquals( iLPInterviewTest.referLip, iLPInterview3.referLip)
        assertEquals( iLPInterviewTest.lipReferDate, iLPInterview3.lipReferDate)
        assertEquals( iLPInterviewTest.privateEntry, iLPInterview3.privateEntry)
        assertEquals( iLPInterviewTest.officeActionString, iLPInterview3.officeActionString)
        assertEquals( iLPInterviewTest.officeNotes, iLPInterview3.officeNotes)
        assertEquals( iLPInterviewTest.toFile, iLPInterview3.toFile)
        assertEquals( iLPInterviewTest.target, iLPInterview3.target)
        assertEquals( iLPInterviewTest.targetByWhen, iLPInterview3.targetByWhen)
        assertEquals( iLPInterviewTest.academicYearId, iLPInterview3.academicYear)
        assertEquals( iLPInterviewTest._staffName, null)
        assertEquals( iLPInterviewTest._staffSignature, null)
    }
    
    @Test
    public void testConstructor_NullStafff() {
        ILPInterview iLPInterview = new ILPInterview(id: 1, student : new Student(id: 1), staff: null)
        ILPInterviewDto iLPInterviewTest= new ILPInterviewDto(iLPInterview)
        assertEquals( iLPInterviewTest._staffSignature, null)
    }
    
    @Test
    public void testConstructor_Student() {
        ILPInterviewDto iLPInterviewTest= new ILPInterviewDto(iLPInterview3)
        assertEquals( iLPInterviewTest._student, iLPInterview3.student);
        assertEquals( iLPInterviewTest.interviewType, iLPInterview3.type);
        assertEquals( iLPInterviewTest._ilpInterviewTypeDescription, iLPInterview3.type, null)
        assertEquals( iLPInterviewTest._courseGroup, iLPInterview3.courseGroup)
        assertEquals( iLPInterviewTest.letter, iLPInterview3.letter)
    }
    
    @Test
    public void testMapFromILPInterviewEntity(){
        ILPInterviewDto iLPInterviewTest = ILPInterviewDto.mapFromEntity( iLPInterview1 )
        assertEquals( iLPInterviewTest.id, iLPInterview1.id );
        assertEquals( iLPInterviewTest.discussion, iLPInterview1.discussion);
        assertEquals( iLPInterviewTest.interviewDate, iLPInterview1.interviewDate);
        assertEquals( iLPInterviewTest.interviewTime, iLPInterview1.interviewTime)
        assertEquals( iLPInterviewTest.referLip, iLPInterview1.referLip)
        assertEquals( iLPInterviewTest.lipReferDate, iLPInterview1.lipReferDate)
        assertEquals( iLPInterviewTest.privateEntry, iLPInterview1.privateEntry)
        assertEquals( iLPInterviewTest.officeActionString, iLPInterview1.officeActionString)
        assertEquals( iLPInterviewTest.officeNotes, iLPInterview1.officeNotes)
        assertEquals( iLPInterviewTest.toFile, iLPInterview1.toFile)
        assertEquals( iLPInterviewTest.target, iLPInterview1.target)
        assertEquals( iLPInterviewTest._staffSignature, iLPInterview1.staff.signature)
        assertEquals( iLPInterviewTest.academicYearId, iLPInterview1.academicYear.id)
        assertEquals( iLPInterviewTest._staffName, iLPInterview1.staff.person.firstName + ' ' + iLPInterview1.staff.person.surname)
    }
    
    @Test
    public void testMapFromILPInterviewsEntities(){
        List<ILPInterviewDto> iLPInterviewsDtoTest = ILPInterviewDto.mapFromList( iLPInterviews )
        assertEquals( iLPInterviewsDtoTest[0].id, iLPInterview1.id );
        assertEquals( iLPInterviewsDtoTest[0].discussion, iLPInterview1.discussion);
        assertEquals( iLPInterviewsDtoTest[0].interviewDate, iLPInterview1.interviewDate);
        assertEquals( iLPInterviewsDtoTest[0].interviewTime, iLPInterview1.interviewTime);
        assertEquals( iLPInterviewsDtoTest[0].referLip, iLPInterview1.referLip);
        assertEquals( iLPInterviewsDtoTest[0].lipReferDate, iLPInterview1.lipReferDate);
        assertEquals( iLPInterviewsDtoTest[0].privateEntry, iLPInterview1.privateEntry);
        assertEquals( iLPInterviewsDtoTest[0].officeActionString, iLPInterview1.officeActionString);
        assertEquals( iLPInterviewsDtoTest[0].officeNotes, iLPInterview1.officeNotes);
        assertEquals( iLPInterviewsDtoTest[0].toFile, iLPInterview1.toFile);
        assertEquals( iLPInterviewsDtoTest[1].id, iLPInterview2.id );
        assertEquals( iLPInterviewsDtoTest[1].discussion, iLPInterview2.discussion);
        assertEquals( iLPInterviewsDtoTest[1].interviewDate, iLPInterview2.interviewDate);
        assertEquals( iLPInterviewsDtoTest[1].interviewTime, iLPInterview1.interviewTime);
        assertEquals( iLPInterviewsDtoTest[1].referLip, iLPInterview2.referLip);
        assertEquals( iLPInterviewsDtoTest[1].lipReferDate, iLPInterview2.lipReferDate);
        assertEquals( iLPInterviewsDtoTest[1].privateEntry, iLPInterview2.privateEntry);
        assertEquals( iLPInterviewsDtoTest[1].officeActionString, iLPInterview2.officeActionString);
        assertEquals( iLPInterviewsDtoTest[1].officeNotes, iLPInterview2.officeNotes);
        assertEquals( iLPInterviewsDtoTest[1].toFile, iLPInterview2.toFile);
        assertEquals( iLPInterviewsDtoTest[1].target, iLPInterview2.target);
        assertEquals( iLPInterviewsDtoTest[1].targetByWhen, iLPInterview2.targetByWhen);
        assertEquals( iLPInterviewsDtoTest[1].academicYearId, iLPInterview2.academicYear.id);
    }
    
    @Test
    public void testEquals_Same() {
        ILPInterviewDto iLPInterviewDto1 = new ILPInterviewDto(iLPInterview1)
        ILPInterviewDto iLPInterviewDto2 = new ILPInterviewDto(iLPInterview1)
        assertEquals(iLPInterviewDto1, iLPInterviewDto2)
    }
    
    @Test
    public void testEquals_Different() {
        ILPInterviewDto iLPInterviewDto1 = new ILPInterviewDto(iLPInterview1)
        ILPInterviewDto iLPInterviewDto2 = new ILPInterviewDto(iLPInterview2)
        assertNotEquals(iLPInterviewDto1, iLPInterviewDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        ILPInterviewDto iLPInterviewDto1 = new ILPInterviewDto(iLPInterview1)
        ILPInterviewDto iLPInterviewDto2 = new ILPInterviewDto(iLPInterview1)
        assertEquals(iLPInterviewDto1.hashCode(), iLPInterviewDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        ILPInterviewDto iLPInterviewDto1 = new ILPInterviewDto(iLPInterview1)
        ILPInterviewDto iLPInterviewDto2 = new ILPInterviewDto(iLPInterview2)
        int hashCode1 = iLPInterviewDto1.hashCode()
        int hashCode2 = iLPInterviewDto2.hashCode()
        assertNotEquals(hashCode1, hashCode2)
    }
    
    @Test
    public void testConstructor_ILPInterview() {
        ILPInterviewDto iLPInterviewTest= new ILPInterviewDto(iLPInterview1)
        assertEquals( iLPInterviewTest.discussion, iLPInterview1.discussion);
        assertEquals( iLPInterviewTest.interviewDate, iLPInterview1.interviewDate);
        assertEquals( iLPInterviewTest.interviewTime, iLPInterview1.interviewTime)
        assertEquals( iLPInterviewTest.referLip, iLPInterview1.referLip)
        assertEquals( iLPInterviewTest.lipReferDate, iLPInterview1.lipReferDate)
        assertEquals( iLPInterviewTest.privateEntry, iLPInterview1.privateEntry)
        assertEquals( iLPInterviewTest.officeActionString, iLPInterview1.officeActionString)
        assertEquals( iLPInterviewTest.officeNotes, iLPInterview1.officeNotes)
        assertEquals( iLPInterviewTest.toFile, iLPInterview1.toFile)
        assertEquals( iLPInterviewTest.target, iLPInterview1.target)
        assertEquals( iLPInterviewTest.targetByWhen, iLPInterview1.targetByWhen)
        assertEquals( iLPInterviewTest.academicYearId, iLPInterview1.academicYear.id)
    }
}
