package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Test
import org.junit.Before

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.lookup.Level
import uk.ac.reigate.domain.lookup.PossibleGradeSet
import uk.ac.reigate.domain.lookup.Subject

public class CourseSummaryDtoTest {
    
    private Level level
    
    private Subject maths
    
    private ExamBoard examBoard1
    
    private AcademicYear academicYear1
    
    private Course  course1
    
    private Course course2
    
    private PossibleGradeSet possibleGradeSet
    
    private List<Course> courses
    
    @Before
    public void setupTests(){
        this.level = new Level(id: 1, code: 'L', description: 'Lower');
        this.maths = new Subject(id: 1, code: 'MA', description: 'Maths');
        this.examBoard1 = new ExamBoard();
        this.academicYear1 = new AcademicYear()
        this.course1 = new Course(
                id: 1,
                level: level,
                subject: maths,
                glh: 11,
                learningAimReference: 'learn',
                examBoard: examBoard1,
                syllabusCode: '1',
                validFrom: academicYear1,
                validTo: academicYear1,
                locationPostcode: 'E161FF',
                subjectSectorArea: 'London',
                notes: 'working',
                spec:'L-MAH'
                );
        this.course2 = new Course(
                id: 2,
                level: level,
                subject: maths,
                glh: 11,
                learningAimReference: 'learn',
                examBoard: examBoard1,
                syllabusCode: '1',
                validFrom: academicYear1,
                validTo: academicYear1,
                locationPostcode: 'E161FF',
                subjectSectorArea: 'London',
                notes: 'working',
                spec: 'L-MAH'
                );
        this.courses = Arrays.asList(course1, course2);
    }
    
    CourseSummaryDto generateCourseDto() {
        return generateCourse1Dto()
    }
    
    CourseSummaryDto generateCourse1Dto() {
        return new CourseSummaryDto(course1.id, course1.level.id, course1.subject.id, course1.glh, course1.learningAimReference, course1.examBoard.id, course1.syllabusCode, course1.validFrom.id, course1.validTo.id, course1.locationPostcode, course1.subjectSectorArea, course1.notes, course1.spec)
    }
    
    CourseSummaryDto generateCourse2Dto() {
        return new CourseSummaryDto(course2.id, course2.level.id, course2.subject.id, course2.glh, course2.learningAimReference, course2.examBoard.id, course2.syllabusCode, course2.validFrom.id, course2.validTo.id, course2.locationPostcode, course2.subjectSectorArea, course2.notes, course2.spec)
    }
    
    @Test
    public void testMapFromCourseEntityTest(){
        CourseSummaryDto courseTest = CourseSummaryDto.mapFromEntity( course1 )
        assertEquals("failed: ids not equal", courseTest.id, course1.id );
        assertEquals("failed: levels not equal",  courseTest.levelId, course1.level.id);
        assertEquals("failed: subject not equal",  courseTest.subjectId, course1.subject.id);
    }
    
    @Test
    public void testMapFromCoursesEntitiesTest(){
        List<CourseSummaryDto> courseTest = CourseSummaryDto.mapFromList( courses )
        assertEquals( courseTest[0].id, course1.id );
        assertEquals( courseTest[0].levelId, course1.level.id);
        assertEquals( courseTest[0].subjectId, course1.subject.id);
        assertEquals( courseTest[1].id, course2.id );
        assertEquals( courseTest[1].levelId, course2.level.id);
        assertEquals( courseTest[1].subjectId, course2.subject.id);
    }
    
    @Test
    public void testEquals_Same() {
        CourseSummaryDto courseDto1 = new CourseSummaryDto(course1)
        CourseSummaryDto courseDto2 = new CourseSummaryDto(course1)
        assertEquals(courseDto1, courseDto2)
    }
    
    @Test
    public void testEquals_Different() {
        CourseSummaryDto courseDto1 = new CourseSummaryDto(course1)
        CourseSummaryDto courseDto2 = new CourseSummaryDto(course2)
        assertNotEquals(courseDto1, courseDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        CourseSummaryDto courseDto1 = new CourseSummaryDto(course1)
        CourseSummaryDto courseDto2 = new CourseSummaryDto(course1)
        assertEquals(courseDto1.hashCode(), courseDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        CourseSummaryDto courseDto1 = new CourseSummaryDto(course1)
        CourseSummaryDto courseDto2 = new CourseSummaryDto(course2)
        assertNotEquals(courseDto1.hashCode(), courseDto2.hashCode())
    }
    
    @Test
    public void testConstructor_Course() {
        CourseSummaryDto courseTest = new CourseSummaryDto(course1)
        assertEquals( "failed: level not equal", courseTest.levelId, course1.level.id);
        assertEquals( "failed: subject not equal", courseTest.subjectId, course1.subject.id)
    }
    
    @Test
    public void testMethod_Get_NullLevelDescription() {
        Course course = new Course(id: 1, level: null)
        CourseSummaryDto courseDto1 = new CourseSummaryDto(course)
        assertEquals(courseDto1.level, courseDto1.get_LevelDescription())
    }
    
    @Test
    public void testMethod_Get_LevelDescription() {
        CourseSummaryDto courseDto1 = new CourseSummaryDto(course1)
        assertEquals(courseDto1.level.description, courseDto1.get_LevelDescription())
    }
    
    @Test
    public void testMethod_Get_NullSubjectDescription() {
        Course course = new Course(id: 1, subject: null)
        CourseSummaryDto courseDto1 = new CourseSummaryDto(course)
        assertEquals(courseDto1.subject, courseDto1.get_SubjectDescription())
    }
    
    @Test
    public void testMethod_Get_SubjectDescription() {
        CourseSummaryDto courseDto1 = new CourseSummaryDto(course1)
        assertEquals(courseDto1.subject.description, courseDto1.get_SubjectDescription())
    }
    
    @Test
    public void testMethod_Get_NullDescription() {
        Course course = new Course(id:1, level: null, subject: null)
        CourseSummaryDto courseDto1 = new CourseSummaryDto(course)
        assertEquals(courseDto1.level, courseDto1.subject, courseDto1.get_Description())
    }
    
    @Test
    public void testMethod_Get_Description() {
        CourseSummaryDto courseDto1 = new CourseSummaryDto(course1)
        assertEquals(courseDto1.level.description + ' - ' + courseDto1.subject.description, courseDto1.get_Description())
    }
}
