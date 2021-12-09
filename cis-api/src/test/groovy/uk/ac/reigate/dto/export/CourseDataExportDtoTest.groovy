package uk.ac.reigate.dto.export;

import static org.junit.Assert.*

import org.junit.Test
import org.junit.Before

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.lookup.Level
import uk.ac.reigate.domain.lookup.PossibleGradeSet
import uk.ac.reigate.domain.lookup.Subject

public class CourseDataExportDtoTest {
    
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
        this.level = new Level();
        this.maths = new Subject();
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
                spec:'L-MAH',
                publishedTitle : 'math'
                );
        this.course2 = new Course(
                id: 2,
                level: new Level(id: 1, description: 'Test'),
                subject: new Subject(id:1, description: 'maths'),
                glh: 11,
                learningAimReference: 'learn',
                examBoard: examBoard1,
                syllabusCode: '1',
                validFrom: academicYear1,
                validTo: academicYear1,
                locationPostcode: 'E161FF',
                subjectSectorArea: 'London',
                notes: 'working',
                spec: 'L-MAH',
                publishedTitle : null
                );
        this.courses = Arrays.asList(course1, course2);
    }
    
    @Test
    public void testEquals_Different() {
        CourseDataExportDto courseDto1 = new CourseDataExportDto(course1)
        CourseDataExportDto courseDto2 = new CourseDataExportDto(course2)
        assertNotEquals(courseDto1, courseDto2)
    }
    
    @Test
    public void testHashCode_Different() {
        CourseDataExportDto courseDto1 = new CourseDataExportDto(course1)
        CourseDataExportDto courseDto2 = new CourseDataExportDto(course2)
        assertNotEquals(courseDto1.hashCode(), courseDto2.hashCode())
    }
    
    @Test
    public void testConstructor_Course() {
        CourseDataExportDto courseTest = new CourseDataExportDto(course1)
        assertEquals(courseTest.code, course1.spec);
        assertEquals(courseTest.title, course1.publishedTitle);
    }
    
    @Test
    public void testConstructor_NullTitle() {
        CourseDataExportDto courseTest = new CourseDataExportDto(course2)
        assertEquals(courseTest.code, course2.spec);
        assertEquals(courseTest.title, course2.level.description + ' ' + course2.subject.description);
    }
}
