package uk.ac.reigate.domain.academic;

import org.junit.Test

import uk.ac.reigate.domain.Staff;
import uk.ac.reigate.domain.lookup.YearGroup;

import static org.junit.Assert.*


public class CourseGroupGroupTest {
    
    YearGroup createYearGroup() {
        YearGroup yearGroup = new YearGroup()
    }
    
    Course createCourse() {
        Course course = new Course()
    }
    
    AcademicYear createAcademicYear() {
        AcademicYear year = new AcademicYear()
    }
    
    Department createDepartment() {
        Department department = new Department()
    }
    
    Staff createStaff() {
        Staff courseLeader = new Staff()
    }
    
    @Test
    void testMethod_ToString() {
        CourseGroup courseGroup = new CourseGroup()
        YearGroup yearGroup = createYearGroup()
        Course course = createCourse()
        courseGroup.spec = 'TEST'
        
        assertEquals(courseGroup.spec, courseGroup.toString())
    }
}
