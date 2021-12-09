package uk.ac.reigate.dto;

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.register.AttendanceCode
import uk.ac.reigate.domain.register.Register
import uk.ac.reigate.domain.register.RegisterMark

public class RegisterMarkDtoTest {
    
    private RegisterMark registerMark1
    
    private RegisterMark registerMark2
    
    private RegisterMark registerMark3
    
    private List<RegisterMark> registerMarks
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    Course createCourse() {
        Course course = new Course()
    }
    
    Register createRegister() {
        Register register = new Register()
    }
    
    CourseGroup createCourseGroup() {
        CourseGroup courseGroup = new CourseGroup()
    }
    
    AttendanceCode createAttendanceCode() {
        AttendanceCode attendanceCode = new AttendanceCode()
    }
    
    @Before
    public void setup() {
        registerMark1 = new RegisterMark(
                id: 1,
                course:createCourse(),
                courseGroup: createCourseGroup(),
                register:createRegister(),
                student: createStudent(),
                attendanceCode:createAttendanceCode()
                );
        registerMark2 = new RegisterMark(
                id: 2,
                course:createCourse(),
                courseGroup: createCourseGroup(),
                register:createRegister(),
                student: createStudent(),
                attendanceCode:createAttendanceCode()
                );
        registerMark3 = new RegisterMark(
                id: 2,
                course:null,
                courseGroup: null,
                register:null,
                student: null,
                attendanceCode:null
                );
        registerMarks = Arrays.asList(registerMark1, registerMark2);
    }
    
    @Test
    public void testConstructor_NullRegisterMark() {
        RegisterMark registerMark = null
        RegisterMarkDto registerMarkTest= new RegisterMarkDto(registerMark)
        assertEquals( registerMark, null );
    }
    @Test
    public void testConstructor_NullObject() {
        RegisterMarkDto registerMarkTest= new RegisterMarkDto(registerMark3)
        assertEquals( registerMarkTest.id, registerMark3.id );
        assertEquals( registerMarkTest.courseId, registerMark3.course);
        assertEquals( registerMarkTest.courseGroupId, registerMark3.courseGroup);
        assertEquals( registerMarkTest.registerId, registerMark3.register)
        assertEquals( registerMarkTest.studentId, registerMark3.student)
        assertEquals( registerMarkTest.attendanceCodeId, registerMark3.attendanceCode)
    }
    
    @Test
    public void testMapFromRegisterMarkEntity(){
        RegisterMarkDto registerMarkTest = RegisterMarkDto.mapFromEntity( registerMark1 )
        assertEquals( registerMarkTest.id, registerMark1.id );
        assertEquals( registerMarkTest.courseId, registerMark1.course.id);
        assertEquals( registerMarkTest.courseGroupId, registerMark1.courseGroup.id);
        assertEquals( registerMarkTest.registerId, registerMark1.register.id)
        assertEquals( registerMarkTest.studentId, registerMark1.student.id)
        assertEquals( registerMarkTest.attendanceCodeId, registerMark1.attendanceCode.id)
    }
    
    @Test
    public void testMapFromRegisterMarksEntities(){
        List<RegisterMarkDto> registerMarksDtoTest = RegisterMarkDto.mapFromList( registerMarks )
        assertEquals( registerMarksDtoTest[0].id, registerMark1.id );
        assertEquals( registerMarksDtoTest[0].courseId, registerMark1.course.id);
        assertEquals( registerMarksDtoTest[0].courseGroupId, registerMark1.courseGroup.id);
        assertEquals( registerMarksDtoTest[0].registerId, registerMark1.register.id)
        assertEquals( registerMarksDtoTest[0].studentId, registerMark1.student.id)
        assertEquals( registerMarksDtoTest[0].attendanceCodeId, registerMark1.attendanceCode.id)
        assertEquals( registerMarksDtoTest[1].courseId, registerMark2.course.id);
        assertEquals( registerMarksDtoTest[1].courseGroupId, registerMark2.courseGroup.id);
        assertEquals( registerMarksDtoTest[1].registerId, registerMark2.register.id)
        assertEquals( registerMarksDtoTest[1].studentId, registerMark2.student.id)
        assertEquals( registerMarksDtoTest[1].attendanceCodeId, registerMark2.attendanceCode.id)
    }
    
    @Test
    public void testEquals_Same() {
        RegisterMarkDto registerMarkDto1 = new RegisterMarkDto(registerMark1)
        RegisterMarkDto registerMarkDto2 = new RegisterMarkDto(registerMark1)
        assertEquals(registerMarkDto1, registerMarkDto2)
    }
    
    @Test
    public void testEquals_Different() {
        RegisterMarkDto registerMarkDto1 = new RegisterMarkDto(registerMark1)
        RegisterMarkDto registerMarkDto2 = new RegisterMarkDto(registerMark2)
        assertNotEquals(registerMarkDto1, registerMarkDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        RegisterMarkDto registerMarkDto1 = new RegisterMarkDto(registerMark1)
        RegisterMarkDto registerMarkDto2 = new RegisterMarkDto(registerMark1)
        assertEquals(registerMarkDto1.hashCode(), registerMarkDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        RegisterMarkDto registerMarkDto1 = new RegisterMarkDto(registerMark1)
        RegisterMarkDto registerMarkDto2 = new RegisterMarkDto(registerMark2)
        assertNotEquals(registerMarkDto1.hashCode(), registerMarkDto2.hashCode())
    }
    
    @Test
    public void testConstructor_RegisterMark() {
        RegisterMarkDto registerMarkTest= new RegisterMarkDto(registerMark1)
        assertEquals( registerMarkTest.id, registerMark1.id );
        assertEquals( registerMarkTest.courseId, registerMark1.course.id);
        assertEquals( registerMarkTest.courseGroupId, registerMark1.courseGroup.id);
        assertEquals( registerMarkTest.registerId, registerMark1.register.id)
        assertEquals( registerMarkTest.studentId, registerMark1.student.id)
        assertEquals( registerMarkTest.attendanceCodeId, registerMark1.attendanceCode.id)
    }
}
