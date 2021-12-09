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

public class CourseGroupSummaryDtoTest {
    
    private YearGroup yearGroup
    
    private Level level1
    
    private Subject maths
    
    private ExamBoard examBoard1
    
    private AcademicYear academicYear1
    
    private AcademicYear year
    
    private Gender female
    
    private LegalSex Female
    
    private Title mrs
    
    private Address address1
    
    private Person person1
    
    private Course course
    
    private Department department
    
    private StaffType staffType1
    
    private Staff staff
    
    private Faculty faculty
    
    private PossibleGradeSet possibleGradeSet
    
    private CourseGroup courseGroup1
    
    private CourseGroup courseGroup2
    
    private List<CourseGroup> courseGroups
    
    @Before
    public void setupTests() {
        this.yearGroup = new YearGroup(id:1, code:'test', description:'test1', excludeTTCheck:true)
        this.level1 = new Level()
        this.maths = new Subject()
        this.examBoard1 = new ExamBoard()
        this.academicYear1 = new AcademicYear()
        this.year = new AcademicYear(id: 1, code: '18/19', description: '2018/2019')
        this.female= new Gender()
        this.mrs = new Title()
        this.address1 = new Address(1, 'Flat D', 'Stag', 'Stanley', 'west', 'park', 'Wallington', '', 'E161FF', '', '')
        this.person1 = new Person(id:1)
        this.course = new Course()
        this.staffType1 = new StaffType()
        this.staff = new Staff();
        this.faculty = new Faculty()
        this.department = new Department()
        this.courseGroup1 = new CourseGroup(
                id: 1,
                yearGroup: yearGroup,
                course: course,
                year: year,
                code: 'A',
                department: department,
                displayOnTimetable: true,
                hasRegister: true,
                notes: 'Nothing',
                spec: 'L-MAH',
                plh: 1,
                peeph: 2
                );
        this.courseGroup2 = new CourseGroup(
                id: 2,
                yearGroup: yearGroup,
                course: course,
                year: year,
                code: 'A',
                department: department,
                displayOnTimetable: true,
                hasRegister: true,
                notes: 'Nothing',
                spec: 'L-MAH',
                plh: 1,
                peeph: 2
                );
        this.courseGroups = Arrays.asList(courseGroup1, courseGroup2);
    }
    
    CourseGroupSummaryDto generateCourseGroupDto() {
        return generateCourseGroup1Dto()
    }
    
    CourseGroupDto generateCourseGroup1Dto() {
        return new CourseGroupSummaryDto(courseGroup1.id, courseGroup1.yearGroup.id, courseGroup1.course.id, courseGroup1.year.id, courseGroup1.code, courseGroup1.department.id, courseGroup1.displayOnTimetable, courseGroup1.hasRegister, courseGroup1.notes, courseGroup1.spec, courseGroup1.plh, courseGroup1.peeph)
    }
    
    CourseGroupDto generateCourseGroup2Dto() {
        return new CourseGroupSummaryDto(courseGroup2.id, courseGroup2.yearGroup.id, courseGroup2.course.id, courseGroup2.year.id, courseGroup2.code, courseGroup2.department.id, courseGroup2.displayOnTimetable, courseGroup2.hasRegister, courseGroup2.notes, courseGroup2.spec, courseGroup2.plh, courseGroup2.peeph)
    }
    
    @Test
    public void testMapFromCourseGroupEntity() {
        CourseGroupSummaryDto courseGroup = CourseGroupSummaryDto.mapFromEntity( courseGroup1 )
        assertEquals( courseGroup.id, courseGroup1.id);
        assertEquals( courseGroup.yearGroupId,  courseGroup1.yearGroup.id);
        assertEquals( courseGroup.courseId, courseGroup1.course.id);
        assertEquals( courseGroup.yearId, courseGroup1.year.id);
        assertEquals( courseGroup.departmentId, courseGroup1.department.id);
        assertEquals( courseGroup.notes, courseGroup1.notes);
    }
    
    @Test
    public void testMapFromCourseGroupsEntities(){
        List<CourseGroupSummaryDto> courseGroup = CourseGroupSummaryDto.mapFromList( courseGroups )
        assertEquals( courseGroup[0].id, courseGroup1.id);
        assertEquals( courseGroup[0].yearGroupId, courseGroup1.yearGroup.id);
        assertEquals( courseGroup[0].courseId, courseGroup1.course.id);
        assertEquals( courseGroup[0].yearId, courseGroup1.year.id);
        assertEquals( courseGroup[0].departmentId, courseGroup1.department.id);
        assertEquals( courseGroup[0].notes, courseGroup1.notes);
        assertEquals( courseGroup[1].id, courseGroup2.id);
        assertEquals( courseGroup[1].yearGroupId, courseGroup2.yearGroup.id);
        assertEquals( courseGroup[1].courseId, courseGroup2.course.id);
        assertEquals( courseGroup[1].yearId, courseGroup2.year.id);
        assertEquals( courseGroup[1].departmentId, courseGroup2.department.id);
        assertEquals( courseGroup[1].notes, courseGroup2.notes);
    }
    
    @Test
    public void testEquals_Same() {
        CourseGroupSummaryDto courseGroupDto1 = new CourseGroupSummaryDto(courseGroup1)
        CourseGroupSummaryDto courseGroupDto2 = new CourseGroupSummaryDto(courseGroup1)
        assertEquals( courseGroupDto1, courseGroupDto2)
    }
    
    @Test
    public void testEquals_Different() {
        CourseGroupSummaryDto courseGroupDto1 = new CourseGroupSummaryDto(courseGroup1)
        CourseGroupSummaryDto courseGroupDto2 = new CourseGroupSummaryDto(courseGroup2)
        assertNotEquals( courseGroupDto1, courseGroupDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        CourseGroupSummaryDto courseGroupDto1 = new CourseGroupSummaryDto(courseGroup1)
        CourseGroupSummaryDto courseGroupDto2 = new CourseGroupSummaryDto(courseGroup1)
        assertEquals( courseGroupDto1.hashCode(), courseGroupDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        CourseGroupSummaryDto courseGroupDto1 = new CourseGroupSummaryDto(courseGroup1)
        CourseGroupSummaryDto courseGroupDto2 = new CourseGroupSummaryDto(courseGroup2)
        assertNotEquals( courseGroupDto1.hashCode(), courseGroupDto2.hashCode())
    }
    
    @Test
    public void testConstructor_CourseGroup() {
        CourseGroupSummaryDto courseGroup = new CourseGroupSummaryDto(courseGroup1)
        assertEquals( courseGroup.id, courseGroup1.id);
        assertEquals( courseGroup.yearGroupId, courseGroup1.yearGroup.id);
        assertEquals( courseGroup.courseId, courseGroup1.course.id);
        assertEquals( courseGroup.yearId, courseGroup1.year.id);
        assertEquals( courseGroup.departmentId, courseGroup1.department.id);
        assertEquals( courseGroup.notes, courseGroup1.notes);
    }
    
    @Test
    public void testMethod_Get_NullYearGroupDescription() {
        CourseGroup courseGroup = new CourseGroup(id: 1, yearGroup : null)
        CourseGroupSummaryDto courseDto1 = new CourseGroupSummaryDto(courseGroup)
        assertEquals(courseDto1.yearGroup, courseDto1.get_YearGroupDescription())
    }
    
    @Test
    public void testMethod_Get_YearGroupDescription() {
        CourseGroupSummaryDto courseDto1 = new CourseGroupSummaryDto(courseGroup1)
        assertEquals(courseDto1.yearGroup.description, courseDto1.get_YearGroupDescription())
    }
    
    @Test
    public void testMethod_Get_NullYearDescription() {
        CourseGroup courseGroup = new CourseGroup(id: 1, year : null)
        CourseGroupSummaryDto courseDto1 = new CourseGroupSummaryDto(courseGroup)
        assertEquals(courseDto1.year, courseDto1.get_YearDescription())
    }
    
    @Test
    public void testMethod_Get_YearDescription() {
        CourseGroupSummaryDto courseDto1 = new CourseGroupSummaryDto(courseGroup1)
        assertEquals(courseDto1.year.description, courseDto1.get_YearDescription())
    }
}
