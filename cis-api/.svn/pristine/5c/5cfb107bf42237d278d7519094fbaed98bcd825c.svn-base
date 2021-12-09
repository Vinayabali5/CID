package uk.ac.reigate.dto

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Department
import uk.ac.reigate.domain.lookup.YearGroup

import static org.junit.Assert.*

public class CourseGroupDtoTest {
    
    private CourseGroup courseGroup1
    
    private CourseGroup courseGroup2
    
    private CourseGroup courseGroup3
    
    private List<CourseGroup> courseGroups
    
    @Before
    public void setupTests() {
        this.courseGroup1 = new CourseGroup(
                id: 1,
                yearGroup: new YearGroup(id: 1, description: 'Test'),
                course: new Course(id: 1),
                year: new AcademicYear(id: 1),
                code: 'A',
                department: new Department(id: 1, description: 'Test Department 1'),
                courseLeader: new Staff(id: 1, initials: 'TE1'),
                displayOnTimetable: true,
                hasRegister: true,
                notes: 'Test Course Group 1',
                spec: 'L-MAH',
                plh: 100,
                peeph: 10
                )
        this.courseGroup2 = new CourseGroup(
                id: 2,
                yearGroup: new YearGroup(id: 2, description: 'Test 2'),
                course: new Course(id: 2),
                year: new AcademicYear(id: 2),
                code: 'B',
                department: new Department(id: 2, description: 'Test Department 2'),
                courseLeader:  new Staff(id: 1, initials: 'TE2'),
                displayOnTimetable: true,
                hasRegister: true,
                notes: 'Test Course Group 2',
                spec: 'U-BSC',
                plh: 200,
                peeph: 20
                )
        this.courseGroup3 = new CourseGroup(
                id: 2,
                yearGroup: new YearGroup(id: 2, description: 'Test 2'),
                course: new Course(id: 2),
                year: null,
                code: 'B',
                department: null,
                courseLeader:  null,
                displayOnTimetable: true,
                hasRegister: true,
                notes: 'Test Course Group 2',
                spec: 'U-BSC',
                plh: 200,
                peeph: 20
                )
        this.courseGroups = Arrays.asList(courseGroup1, courseGroup2)
    }
    
    CourseGroupDto generateCourseGroupDto() {
        return generateCourseGroup1Dto()
    }
    
    CourseGroupDto generateCourseGroup1Dto() {
        return new CourseGroupDto(courseGroup1.id, courseGroup1.yearGroup.id, courseGroup1.course.id, courseGroup1.year.id, courseGroup1.code, courseGroup1.department.id, courseGroup1.courseLeader.id, courseGroup1.displayOnTimetable, courseGroup1.hasRegister, courseGroup1.notes, courseGroup1.spec, courseGroup1.plh, courseGroup1.peeph)
    }
    
    CourseGroupDto generateCourseGroup2Dto() {
        return new CourseGroupDto(courseGroup2.id, courseGroup2.yearGroup.id, courseGroup2.course.id, courseGroup2.year.id, courseGroup2.code, courseGroup2.department.id, courseGroup2.courseLeader.id, courseGroup2.displayOnTimetable, courseGroup2.hasRegister, courseGroup2.notes, courseGroup2.spec, courseGroup2.plh, courseGroup2.peeph)
    }
    
    @Test
    public void testConstructor_NullCourseGroup() {
        CourseGroup courseGroup = null
        CourseGroupDto courseGroupDto = new CourseGroupDto(courseGroup)
        assertEquals( courseGroup, null )
    }
    @Test
    public void testMapFromCourseGroupEntity() {
        CourseGroupDto courseGroup = CourseGroupDto.mapFromEntity( courseGroup1 )
        assertEquals( courseGroup.id, courseGroup1.id)
        assertEquals( courseGroup.yearGroupId,  courseGroup1.yearGroup.id)
        assertEquals( courseGroup.courseId, courseGroup1.course.id)
        assertEquals( courseGroup.yearId, courseGroup1.year.id)
        assertEquals( courseGroup.departmentId, courseGroup1.department.id)
        assertEquals( courseGroup.courseLeaderId, courseGroup1.courseLeader.id)
        assertEquals( courseGroup.displayOnTimetable, courseGroup1.displayOnTimetable)
        assertEquals( courseGroup.hasRegister, courseGroup1.hasRegister)
        assertEquals( courseGroup.notes, courseGroup1.notes)
    }
    
    @Test
    public void testMapFromCourseGroupsEntities(){
        List<CourseGroupDto> courseGroup = CourseGroupDto.mapFromList( courseGroups )
        assertEquals( courseGroup[0].id, courseGroup1.id)
        assertEquals( courseGroup[0].yearGroupId, courseGroup1.yearGroup.id)
        assertEquals( courseGroup[0].courseId, courseGroup1.course.id)
        assertEquals( courseGroup[0].yearId, courseGroup1.year.id)
        assertEquals( courseGroup[0].departmentId, courseGroup1.department.id)
        assertEquals( courseGroup[0].courseLeaderId, courseGroup1.courseLeader.id)
        assertEquals( courseGroup[0].displayOnTimetable, courseGroup1.displayOnTimetable)
        assertEquals( courseGroup[0].hasRegister, courseGroup1.hasRegister)
        assertEquals( courseGroup[0].notes, courseGroup1.notes)
        assertEquals( courseGroup[1].id, courseGroup2.id)
        assertEquals( courseGroup[1].yearGroupId, courseGroup2.yearGroup.id)
        assertEquals( courseGroup[1].courseId, courseGroup2.course.id)
        assertEquals( courseGroup[1].yearId, courseGroup2.year.id)
        assertEquals( courseGroup[1].departmentId, courseGroup2.department.id)
        assertEquals( courseGroup[1].courseLeaderId, courseGroup2.courseLeader.id)
        assertEquals( courseGroup[1].displayOnTimetable, courseGroup2.displayOnTimetable)
        assertEquals( courseGroup[1].hasRegister, courseGroup2.hasRegister)
        assertEquals( courseGroup[1].notes, courseGroup2.notes)
    }
    
    @Test
    public void testEquals_Different() {
        CourseGroupDto courseGroupDto1 = new CourseGroupDto(courseGroup1)
        CourseGroupDto courseGroupDto2 = new CourseGroupDto(courseGroup2)
        assertNotEquals( courseGroupDto1, courseGroupDto2 )
    }
    
    @Test
    public void testHashCode_Same() {
        CourseGroupDto courseGroupDto1 = new CourseGroupDto(courseGroup1)
        CourseGroupDto courseGroupDto2 = new CourseGroupDto(courseGroup1)
        assertEquals( courseGroupDto1.hashCode(), courseGroupDto2.hashCode() )
    }
    
    @Test
    public void testHashCode_Different() {
        CourseGroupDto courseGroupDto1 = new CourseGroupDto(courseGroup1)
        CourseGroupDto courseGroupDto2 = new CourseGroupDto(courseGroup2)
        assertNotEquals( courseGroupDto1.hashCode(), courseGroupDto2.hashCode() )
    }
    
    @Test
    public void testConstructor_CourseGroup() {
        CourseGroupDto courseGroup = new CourseGroupDto(courseGroup1)
        assertEquals( courseGroup.id, courseGroup1.id )
        assertEquals( courseGroup.yearGroupId, courseGroup1.yearGroup.id )
        assertEquals( courseGroup.courseId, courseGroup1.course.id )
        assertEquals( courseGroup.yearId, courseGroup1.year.id )
        assertEquals( courseGroup.departmentId, courseGroup1.department.id )
        assertEquals( courseGroup.courseLeaderId, courseGroup1.courseLeader.id )
        assertEquals( courseGroup.displayOnTimetable, courseGroup1.displayOnTimetable )
        assertEquals( courseGroup.hasRegister, courseGroup1.hasRegister )
        assertEquals( courseGroup.notes, courseGroup1.notes )
    }
    
    @Test
    public void testConstructor_NullObjects() {
        CourseGroupDto courseGroup = new CourseGroupDto(courseGroup3)
        assertEquals( courseGroup.id, courseGroup3.id )
        assertEquals( courseGroup.yearGroupId, courseGroup3.yearGroup.id )
        assertEquals( courseGroup.courseId, courseGroup3.course.id )
        assertEquals( courseGroup.yearId, courseGroup3.year )
        assertEquals( courseGroup.departmentId, courseGroup3.department)
        assertEquals( courseGroup.courseLeaderId, courseGroup3.courseLeader )
        assertEquals( courseGroup.displayOnTimetable, courseGroup3.displayOnTimetable )
        assertEquals( courseGroup.hasRegister, courseGroup3.hasRegister )
        assertEquals( courseGroup.notes, courseGroup3.notes )
    }
    
    @Test
    public void testMethod_Get_NullYearGroupDescription() {
        CourseGroup courseGroup = new CourseGroup(id: 1, yearGroup : null)
        CourseGroupDto courseDto1 = new CourseGroupDto(courseGroup)
        assertEquals( courseDto1.yearGroup, courseDto1.get_YearGroupDescription() )
    }
    
    @Test
    public void testMethod_Get_YearGroupDescription() {
        CourseGroupDto courseDto1 = new CourseGroupDto(courseGroup1)
        assertEquals( courseDto1.yearGroup.description, courseDto1.get_YearGroupDescription() )
    }
    
    @Test
    public void testMethod_Get_NullYearDescription() {
        CourseGroup courseGroup = new CourseGroup(id: 1, year : null)
        CourseGroupDto courseDto1 = new CourseGroupDto(courseGroup)
        assertEquals( courseDto1.year, courseDto1.get_YearDescription() )
    }
    
    @Test
    public void testMethod_Get_YearDescription() {
        CourseGroupDto courseDto1 = new CourseGroupDto(courseGroup1)
        assertEquals( courseDto1.year.description, courseDto1.get_YearDescription() )
    }
    
    @Test
    public void testMethod_Get_NullDepartmentDescription() {
        CourseGroup courseGroup = new CourseGroup(id: 1, department : null)
        CourseGroupDto courseDto1 = new CourseGroupDto(courseGroup)
        assertEquals( courseDto1.department, courseDto1.get_DepartmentDescription() )
    }
    
    @Test
    public void testMethod_Get_DepartmentDescription() {
        CourseGroupDto courseDto1 = new CourseGroupDto(courseGroup1)
        assertEquals( courseDto1.department.description, courseDto1.get_DepartmentDescription() )
    }
    
    @Test
    public void testMethod_Get_NullCourseLeaderInitials() {
        CourseGroup courseGroup = new CourseGroup(id: 1, courseLeader : null)
        CourseGroupDto courseDto1 = new CourseGroupDto(courseGroup)
        assertEquals( courseDto1.courseLeader, courseDto1.get_CourseLeaderInitials() )
    }
    
    @Test
    public void testMethod_Get_CourseLeaderInitials() {
        CourseGroupDto courseDto1 = new CourseGroupDto(courseGroup1)
        assertEquals( courseDto1.courseLeader.initials, courseDto1.get_CourseLeaderInitials() )
    }
}
