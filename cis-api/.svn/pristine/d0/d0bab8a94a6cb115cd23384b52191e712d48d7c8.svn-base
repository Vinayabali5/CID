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

public class CourseDtoTest {
    
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
        this.examBoard1 = new ExamBoard(id: 1, description: 'GCSE');
        this.academicYear1 = new AcademicYear(id: 1, code: '18/19', description: '2018/2019')
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
    
    CourseDto generateCourseDto() {
        return generateCourse1Dto()
    }
    
    CourseDto generateCourse1Dto() {
        return new CourseDto(course1.id, course1.level.id, course1.subject.id, course1.glh, course1.learningAimReference, course1.examBoard.id, course1.syllabusCode, course1.validFrom.id, course1.validTo.id, course1.locationPostcode, course1.subjectSectorArea, course1.notes, course1.spec)
    }
    
    CourseDto generateCourse2Dto() {
        return new CourseDto(course2.id, course2.level.id, course2.subject.id, course2.glh, course2.learningAimReference, course2.examBoard.id, course2.syllabusCode, course2.validFrom.id, course2.validTo.id, course2.locationPostcode, course2.subjectSectorArea, course2.notes, course2.spec)
    }
    
    @Test
    void testConstructor_NullCourse() {
        Course course = null
        CourseDto courseDto = new CourseDto( course )
        assertEquals( course, null);
    }
    
    @Test
    public void testMapFromCourseEntityTest(){
        CourseDto courseTest = CourseDto.mapFromEntity( course1 )
        assertEquals("failed: ids not equal", courseTest.id, course1.id );
        assertEquals("failed: levels not equal",  courseTest.levelId, course1.level.id);
        assertEquals("failed: subject not equal",  courseTest.subjectId, course1.subject.id);
        assertEquals("failed: glh not equal",  courseTest.glh, course1.glh);
        assertEquals("failed: learningAimReference not equal",  courseTest.learningAimReference, course1.learningAimReference);
        assertEquals("failed: examBoard not equal",  courseTest.examBoardId, course1.examBoard.id);
        assertEquals("failed: syllabusCode not equal",  courseTest.syllabusCode, course1.syllabusCode);
        assertEquals("failed: validFrom not equal",  courseTest.validFromId, course1.validFrom.id);
        assertEquals("failed: validTo not equal",  courseTest.validToId, course1.validTo.id);
        assertEquals("failed: locationPostcode not equal",  courseTest.locationPostcode, course1.locationPostcode);
        assertEquals("failed: subjectSectorArea not equal",  courseTest.subjectSectorArea, course1.subjectSectorArea);
        assertEquals("failed: notes not equal",  courseTest.notes, course1.notes);
    }
    
    @Test
    public void testMapFromCoursesEntitiesTest(){
        List<CourseDto> courseTest = CourseDto.mapFromList( courses )
        assertEquals( courseTest[0].id, course1.id );
        assertEquals( courseTest[0].levelId, course1.level.id);
        assertEquals( courseTest[0].subjectId, course1.subject.id);
        assertEquals( courseTest[0].glh, course1.glh);
        assertEquals( courseTest[0].learningAimReference, course1.learningAimReference);
        assertEquals( courseTest[0].examBoardId, course1.examBoard.id);
        assertEquals( courseTest[0].syllabusCode, course1.syllabusCode);
        assertEquals( courseTest[0].validFromId, course1.validFrom.id);
        assertEquals( courseTest[0].validToId, course1.validTo.id);
        assertEquals( courseTest[0].locationPostcode, course1.locationPostcode);
        assertEquals( courseTest[0].subjectSectorArea, course1.subjectSectorArea);
        assertEquals( courseTest[0].notes, course1.notes);
        assertEquals( courseTest[1].id, course2.id );
        assertEquals( courseTest[1].levelId, course2.level.id);
        assertEquals( courseTest[1].subjectId, course2.subject.id);
        assertEquals( courseTest[1].glh, course2.glh);
        assertEquals( courseTest[1].learningAimReference, course2.learningAimReference);
        assertEquals( courseTest[1].examBoardId, course2.examBoard.id);
        assertEquals( courseTest[1].syllabusCode, course2.syllabusCode);
        assertEquals( courseTest[1].validFromId, course2.validFrom.id);
        assertEquals( courseTest[1].validToId, course2.validTo.id);
        assertEquals( courseTest[1].locationPostcode, course2.locationPostcode);
        assertEquals( courseTest[1].subjectSectorArea, course2.subjectSectorArea);
        assertEquals( courseTest[1].notes, course1.notes);
    }
    
    @Test
    public void testEquals_Same() {
        CourseDto courseDto1 = new CourseDto(course1)
        CourseDto courseDto2 = new CourseDto(course1)
        assertEquals(courseDto1, courseDto2)
    }
    
    @Test
    public void testEquals_Different() {
        CourseDto courseDto1 = new CourseDto(course1)
        CourseDto courseDto2 = new CourseDto(course2)
        assertNotEquals(courseDto1, courseDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        CourseDto courseDto1 = new CourseDto(course1)
        CourseDto courseDto2 = new CourseDto(course1)
        assertEquals(courseDto1.hashCode(), courseDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        CourseDto courseDto1 = new CourseDto(course1)
        CourseDto courseDto2 = new CourseDto(course2)
        assertNotEquals(courseDto1.hashCode(), courseDto2.hashCode())
    }
    
    @Test
    public void testMethod_Get_NullDescription() {
        Course course = new Course(id:1, level: null, subject: null)
        CourseDto courseDto1 = new CourseDto(course)
        assertEquals(courseDto1.level, courseDto1.subject, courseDto1.get_Description())
    }
    
    @Test
    public void testMethod_Get_Description() {
        CourseDto courseDto1 = new CourseDto(course1)
        assertEquals(courseDto1.level.description + ' - ' + courseDto1.subject.description, courseDto1.get_Description())
    }
    
    @Test
    public void testMethod_Get_NullExamBoardDescription() {
        Course course = new Course(id:1, examBoard: null)
        CourseDto courseDto1 = new CourseDto(course)
        assertEquals(courseDto1.examBoard, courseDto1.get_ExamBoardDescription())
    }
    
    @Test
    public void testMethod_Get_ExamBoardDescription() {
        CourseDto courseDto1 = new CourseDto(course1)
        assertEquals(courseDto1.examBoard.description, courseDto1.get_ExamBoardDescription())
    }
    
    @Test
    public void testMethod_Get_NullLevelDescription() {
        Course course = new Course(id:1, level: null)
        CourseDto courseDto1 = new CourseDto(course)
        assertEquals(courseDto1.level, courseDto1.get_LevelDescription())
    }
    
    @Test
    public void testMethod_Get_LevelDescription() {
        CourseDto courseDto1 = new CourseDto(course1)
        assertEquals(courseDto1.level.description, courseDto1.get_LevelDescription())
    }
    
    @Test
    public void testMethod_Get_NullSubjectDescription() {
        Course course = new Course(id:1, subject: null)
        CourseDto courseDto1 = new CourseDto(course)
        assertEquals(courseDto1.subject, courseDto1.get_SubjectDescription())
    }
    
    @Test
    public void testMethod_Get_SubjectDescription() {
        CourseDto courseDto1 = new CourseDto(course1)
        assertEquals(courseDto1.subject.description, courseDto1.get_SubjectDescription())
    }
    
    @Test
    public void testMethod_Get_NullValidFromCode() {
        Course course = new Course(id:1, validFrom: null)
        CourseDto courseDto1 = new CourseDto(course)
        assertEquals(courseDto1.validFrom, courseDto1.get_ValidFromCode())
    }
    
    @Test
    public void testMethod_Get_ValidFromCode() {
        CourseDto courseDto1 = new CourseDto(course1)
        assertEquals(courseDto1.validFrom.code, courseDto1.get_ValidFromCode())
    }
    
    @Test
    public void testMethod_Get_NullValidFromDescription() {
        Course course = new Course(id:1, validFrom: null)
        CourseDto courseDto1 = new CourseDto(course)
        assertEquals(courseDto1.validFrom, courseDto1.get_ValidFromDescription())
    }
    
    @Test
    public void testMethod_Get_ValidFromDescription() {
        CourseDto courseDto1 = new CourseDto(course1)
        assertEquals(courseDto1.validFrom.description, courseDto1.get_ValidFromDescription())
    }
    
    @Test
    public void testMethod_Get_NullValidToCode() {
        Course course = new Course(id:1, validTo: null)
        CourseDto courseDto1 = new CourseDto(course)
        assertEquals(courseDto1.validTo, courseDto1.get_ValidToCode())
    }
    
    @Test
    public void testMethod_Get_ValidToCode() {
        CourseDto courseDto1 = new CourseDto(course1)
        assertEquals(courseDto1.validTo.code, courseDto1.get_ValidToCode())
    }
    
    @Test
    public void testMethod_Get_NullValidToDescription() {
        Course course = new Course(id:1, validTo: null)
        CourseDto courseDto1 = new CourseDto(course)
        assertEquals(courseDto1.validTo, courseDto1.get_ValidToDescription())
    }
    
    @Test
    public void testMethod_Get_ValidToDescription() {
        CourseDto courseDto1 = new CourseDto(course1)
        assertEquals(courseDto1.validTo.description, courseDto1.get_ValidToDescription())
    }
}
