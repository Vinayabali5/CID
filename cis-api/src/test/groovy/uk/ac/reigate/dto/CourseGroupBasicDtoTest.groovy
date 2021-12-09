package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Department
import uk.ac.reigate.domain.academic.Faculty
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.lookup.Gender
import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.domain.lookup.Level
import uk.ac.reigate.domain.lookup.PossibleGradeSet
import uk.ac.reigate.domain.lookup.StaffType
import uk.ac.reigate.domain.lookup.Subject
import uk.ac.reigate.domain.lookup.Title
import uk.ac.reigate.domain.lookup.YearGroup

public class CourseGroupBasicDtoTest {
    
    private YearGroup yearGroup
    
    private AcademicYear year
    
    private Course course
    
    private CourseGroup courseGroup1
    
    private CourseGroup courseGroup2
    
    private List<CourseGroup> courseGroups
    
    @Before
    public void setupTests() {
        this.yearGroup = new YearGroup(id:1, code:'test', description:'test1', excludeTTCheck:true)
        this.year = new AcademicYear()
        this.course = new Course()
        this.courseGroup1 = new CourseGroup(
                id: 1,
                yearGroup: yearGroup,
                course: course,
                year: year,
                code: 'A',
                spec: 'L-MAH'
                );
        this.courseGroup2 = new CourseGroup(
                id: 2,
                yearGroup: yearGroup,
                course: course,
                year: year,
                code: 'A',
                spec: 'L-MAH'
                );
        this.courseGroups = Arrays.asList(courseGroup1, courseGroup2);
    }
    
    @Test
    public void testMapFromCourseGroupEntity() {
        CourseGroupBasicDto courseGroup = CourseGroupBasicDto.mapFromEntity( courseGroup1 )
        assertEquals( courseGroup.id, courseGroup1.id);
        assertEquals( courseGroup.yearGroupId,  courseGroup1.yearGroup.id);
        assertEquals( courseGroup.courseId, courseGroup1.course.id);
        assertEquals( courseGroup.yearId, courseGroup1.year.id);
    }
    
    @Test
    public void testMapFromCourseGroupsEntities(){
        List<CourseGroupBasicDto> courseGroup = CourseGroupBasicDto.mapFromList( courseGroups )
        assertEquals( courseGroup[0].id, courseGroup1.id);
        assertEquals( courseGroup[0].yearGroupId, courseGroup1.yearGroup.id);
        assertEquals( courseGroup[0].courseId, courseGroup1.course.id);
        assertEquals( courseGroup[0].yearId, courseGroup1.year.id);
        assertEquals( courseGroup[1].id, courseGroup2.id);
        assertEquals( courseGroup[1].yearGroupId, courseGroup2.yearGroup.id);
        assertEquals( courseGroup[1].courseId, courseGroup2.course.id);
        assertEquals( courseGroup[1].yearId, courseGroup2.year.id);
    }
}
