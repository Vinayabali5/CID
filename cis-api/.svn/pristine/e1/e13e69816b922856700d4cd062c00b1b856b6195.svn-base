package uk.ac.reigate.dto.search

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.lookup.Level
import uk.ac.reigate.domain.lookup.Subject

class CourseSearchDtoTest {
    
    private Course course1
    
    private Course course2
    
    @Before
    public void setup() {
        this.course1 = new Course(
                id:  1,
                spec: 'ALA',
                level : new Level(id: 1, description: 'ALevel'),
                subject: new Subject(id: 1, description: 'Mat'),
                validFrom: new AcademicYear(id: 1, description: '2020'),
                validTo : new AcademicYear(id: 2, description: '2020'),
                notes: 'Test'
                )
        this.course2 = new Course(
                id:  2,
                spec: 'ALA',
                level : null,
                subject: null,
                validFrom: null,
                validTo : null,
                notes: 'Test'
                )
    }
    
    @Test
    public void testConstructor() {
        CourseSearchDto dto = new CourseSearchDto(course1)
        assertEquals( dto.courseId, course1.id);
        assertEquals( dto.spec, course1.spec);
        assertEquals( dto.notes, course1.notes);
        assertEquals( dto._validFromDescription, course1.validFrom.description);
        assertEquals( dto._validToDescription, course1.validTo.description);
    }
    
    @Test
    public void testConstructorNullCourse() {
        CourseSearchDto dto = new CourseSearchDto(course2)
        assertEquals( dto.courseId, course2.id)
        assertEquals( dto.spec, course2.spec);
        assertEquals( dto.notes, course2.notes);
        assertEquals( dto._validFromDescription, '');
        assertEquals( dto._validToDescription, '');
    }
    
    @Test
    public void testDefaultConstructor() {
        CourseSearchDto dto = new CourseSearchDto()
        assertEquals( dto.courseId, null)
        assertEquals( dto.spec, '');
        assertEquals( dto.notes, '');
        assertEquals( dto._validFromDescription, '');
        assertEquals( dto._validToDescription, '');
        assertEquals( dto.description, '');
    }
}
