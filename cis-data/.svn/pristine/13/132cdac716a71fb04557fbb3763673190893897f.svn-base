package uk.ac.reigate.domain.academic;

import org.junit.Test

import uk.ac.reigate.domain.Room;
import uk.ac.reigate.domain.Staff;

import static org.junit.Assert.*


public class TimetableTest {
    
    CourseGroup createCourseGroup() {
        CourseGroup courseGroup = new CourseGroup()
    }
    
    Period createPeriod() {
        Period period = new Period()
    }
    
    Room createRoom() {
        Room room = new Room()
    }
    
    Staff createStaff() {
        Staff teacher = new Staff()
    }
    
    @Test
    void testMethod_ToString() {
        Timetable timetable = new Timetable()
        CourseGroup courseGroup = createCourseGroup()
        timetable.courseGroup = courseGroup
        assertEquals(courseGroup.id, timetable.toString())
    }
}
