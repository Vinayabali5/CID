package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.ilp.Correspondence
import uk.ac.reigate.domain.ilp.CorrespondenceType;
import uk.ac.reigate.domain.ilp.Letter
import uk.ac.reigate.exceptions.InvalidDataException

public class CorrespondenceDtoTest {
    
    private Student student
    
    private Letter letter
    
    private Course course
    
    private CorrespondenceType correspondenceType
    
    private Correspondence correspondence1
    
    private Correspondence correspondence2
    
    private Correspondence correspondence3
    
    private List<Correspondence> correspondences
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    Student createStudent2() {
        Student student = new Student()
        student.id = 2
        return student
    }
    
    Letter createLetter() {
        Letter letter = new Letter()
        letter.id = 1
        return letter
    }
    
    CourseGroup createCourseGroup() {
        CourseGroup course = new CourseGroup()
        course.id = 1
        course.spec = 'Math'
        course.code = 'mat'
        return course
    }
    
    @Before
    public void setup() {
        this.correspondenceType = new CorrespondenceType(id: 1, type: 'A')
        this.correspondence1 = new Correspondence(
                id: 1,
                student: createStudent(),
                course: createCourseGroup(),
                correspondence: 'Hi',
                title: 'Message to Test Student 1',
                date : new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                from: 'college',
                to:'parents',
                letter: createLetter(),
                staffAdvised: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09'),
                type: correspondenceType,
                producedBy : 'VBM',
                privateEntry: false,
                processStage: 0,
                attachmentsSent : null
                );
        this.correspondence2 = new Correspondence(
                id: 2,
                student: createStudent2(),
                course: createCourseGroup(),
                correspondence: 'Hello',
                title: 'Message to Test Student 2',
                date : new SimpleDateFormat("yyyy/MM/dd").parse('2013/08/26'),
                from: 'college',
                to:'parents',
                letter: createLetter(),
                staffAdvised: null,
                type: correspondenceType,
                producedBy : 'MAH',
                privateEntry: true,
                processStage: 2,
                attachmentsSent : 'SomeFile.docx'
                );
        this.correspondence3 = new Correspondence(
                id: 2,
                student: null,
                course: null,
                correspondence: 'Hello',
                title: 'Message to Test Student 2',
                date : new SimpleDateFormat("yyyy/MM/dd").parse('2013/08/26'),
                from: 'college',
                to:'parents',
                letter: null,
                staffAdvised: null,
                type: null,
                producedBy : 'MAH',
                privateEntry: true,
                processStage: 2,
                attachmentsSent : 'SomeFile.docx'
                );
        this.correspondences = Arrays.asList(correspondence1, correspondence2);
    }
    
    CorrespondenceDto generateCorrespondenceDto() {
        return generateCorrespondence1Dto()
    }
    
    CorrespondenceDto generateCorrespondence1Dto() {
        return new CorrespondenceDto(correspondence1)
    }
    
    CorrespondenceDto generateCorrespondence2Dto() {
        return new CorrespondenceDto(correspondence2)
    }
    
    @Test
    void testConstructor_correspondence() {
        CorrespondenceDto correspondenceTest = new CorrespondenceDto( correspondence1 )
        assertEquals( correspondenceTest.id, correspondence1.id );
        assertEquals( correspondenceTest.studentId, correspondence1.student.id);
        assertEquals( correspondenceTest.correspondence, correspondence1.correspondence);
        assertEquals( correspondenceTest.title, correspondence1.title);
        assertEquals( correspondenceTest.date, correspondence1.date);
        assertEquals( correspondenceTest.from, correspondence1.from);
        assertEquals( correspondenceTest.to, correspondence1.to);
        assertEquals( correspondenceTest.letterId, correspondence1.letter.id);
    }
    
    @Test
    void testConstructor_nullStudent() {
        CorrespondenceDto correspondenceTest = new CorrespondenceDto( correspondence3 )
        assertEquals( correspondenceTest.id, correspondence3.id );
        assertEquals( correspondenceTest.studentId, correspondence3.student);
        assertEquals( correspondenceTest.correspondence, correspondence3.correspondence);
        assertEquals( correspondenceTest.title, correspondence3.title);
        assertEquals( correspondenceTest.date, correspondence3.date);
        assertEquals( correspondenceTest.from, correspondence3.from);
        assertEquals( correspondenceTest.to, correspondence3.to);
        assertEquals( correspondenceTest.letterId, correspondence3.letter);
    }
    
    @Test
    void testConstructor_NullCorrespondence() {
        Correspondence correspondence = null
        CorrespondenceDto correspondenceTest = new CorrespondenceDto( correspondence )
        assertEquals( correspondence, null);
    }
    
    @Test
    public void testMapFromCorrespondenceEntity(){
        CorrespondenceDto correspondenceTest = CorrespondenceDto.mapFromEntity( correspondence1 )
        assertEquals( correspondenceTest.id, correspondence1.id );
        assertEquals( correspondenceTest.studentId, correspondence1.student.id);
        assertEquals( correspondenceTest.correspondence, correspondence1.correspondence);
        assertEquals( correspondenceTest.title, correspondence1.title);
        assertEquals( correspondenceTest.date, correspondence1.date);
        assertEquals( correspondenceTest.from, correspondence1.from);
        assertEquals( correspondenceTest.to, correspondence1.to);
        assertEquals( correspondenceTest.letterId, correspondence1.letter.id);
    }
    
    @Test
    public void testMapFromCorrespondencesEntities(){
        List<CorrespondenceDto> correspondencesDtoTest = CorrespondenceDto.mapFromList( this.correspondences )
        assertEquals( correspondencesDtoTest[0].id, correspondence1.id );
        assertEquals( correspondencesDtoTest[0].studentId, correspondence1.student.id);
        assertEquals( correspondencesDtoTest[0].correspondence, correspondence1.correspondence);
        assertEquals( correspondencesDtoTest[0].title, correspondence1.title);
        assertEquals( correspondencesDtoTest[0].date, correspondence1.date);
        assertEquals( correspondencesDtoTest[0].from, correspondence1.from);
        assertEquals( correspondencesDtoTest[0].to, correspondence1.to);
        assertEquals( correspondencesDtoTest[0].letterId, correspondence1.letter.id);
        assertEquals( correspondencesDtoTest[1].id, correspondence2.id );
        assertEquals( correspondencesDtoTest[1].studentId, correspondence2.student.id);
        assertEquals( correspondencesDtoTest[1].correspondence, correspondence2.correspondence);
        assertEquals( correspondencesDtoTest[1].title, correspondence2.title);
        assertEquals( correspondencesDtoTest[1].date, correspondence2.date);
        assertEquals( correspondencesDtoTest[1].from, correspondence2.from);
        assertEquals( correspondencesDtoTest[1].to, correspondence2.to);
        assertEquals( correspondencesDtoTest[1].letterId, correspondence2.letter.id);
    }
    
    @Test
    public void testEquals_Same() {
        CorrespondenceDto correspondenceDto1 = new CorrespondenceDto(correspondence1)
        CorrespondenceDto correspondenceDto2 = new CorrespondenceDto(correspondence1)
        assertEquals(correspondenceDto1, correspondenceDto2)
    }
    
    @Test
    public void testEquals_Different() {
        CorrespondenceDto correspondenceDto1 = new CorrespondenceDto(correspondence1)
        CorrespondenceDto correspondenceDto2 = new CorrespondenceDto(correspondence2)
        assertNotEquals(correspondenceDto1, correspondenceDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        CorrespondenceDto correspondenceDto1 = new CorrespondenceDto(correspondence1)
        CorrespondenceDto correspondenceDto2 = new CorrespondenceDto(correspondence1)
        assertEquals(correspondenceDto1.hashCode(), correspondenceDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        CorrespondenceDto correspondenceDto1 = new CorrespondenceDto(correspondence1)
        CorrespondenceDto correspondenceDto2 = new CorrespondenceDto(correspondence2)
        assertNotEquals(correspondenceDto1.hashCode(), correspondenceDto2.hashCode())
    }
    
    @Test
    public void testMethod_Get_NullCourseGroupDescription() {
        CorrespondenceDto correspondenceDto1 = new CorrespondenceDto(correspondence3)
        assertEquals(correspondenceDto1.courseGroup, correspondenceDto1.get_CourseGroupDescription())
    }
    
    @Test
    public void testMethod_Get_CourseGroupDescription() {
        CorrespondenceDto correspondenceDto1 = new CorrespondenceDto(correspondence1)
        assertEquals(correspondenceDto1.courseGroup.code, correspondenceDto1.get_CourseGroupDescription())
    }
    
    @Test
    public void testMethod_Get_NullCourseGroupSpec() {
        CorrespondenceDto correspondenceDto1 = new CorrespondenceDto(correspondence3)
        assertEquals(correspondenceDto1.courseGroup, correspondenceDto1.get_CourseGroupSpec())
    }
    
    @Test
    public void testMethod_Get_CourseGroupSpec() {
        CorrespondenceDto correspondenceDto1 = new CorrespondenceDto(correspondence1)
        assertEquals(correspondenceDto1.courseGroup.spec, correspondenceDto1.get_CourseGroupSpec())
    }
    
    @Test
    public void testMethod_Get_NullCorrespondenceTypeDescription() {
        CorrespondenceDto correspondenceDto1 = new CorrespondenceDto(correspondence3)
        assertEquals(correspondenceDto1.correspondenceType, correspondenceDto1.get_CorrespondenceTypeDescription())
    }
    
    @Test
    public void testMethod_Get_CorrespondenceTypeDescription() {
        CorrespondenceDto correspondenceDto1 = new CorrespondenceDto(correspondence1)
        assertEquals(correspondenceDto1.correspondenceType.type, correspondenceDto1.get_CorrespondenceTypeDescription())
    }
}
