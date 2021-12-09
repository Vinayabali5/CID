package uk.ac.reigate.dto

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Address;
import uk.ac.reigate.domain.Person;
import uk.ac.reigate.domain.Staff;
import uk.ac.reigate.domain.academic.AcademicYear;
import uk.ac.reigate.domain.academic.Block
import uk.ac.reigate.domain.academic.Course;
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Department;
import uk.ac.reigate.domain.academic.Faculty;
import uk.ac.reigate.domain.academic.Period
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.lookup.Gender;
import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.domain.lookup.Level;
import uk.ac.reigate.domain.lookup.PossibleGradeSet
import uk.ac.reigate.domain.lookup.StaffType;
import uk.ac.reigate.domain.lookup.Subject;
import uk.ac.reigate.domain.lookup.Title;
import uk.ac.reigate.domain.lookup.YearGroup;
import uk.ac.reigate.domain.register.Register
import uk.ac.reigate.domain.register.RegisteredSession;

public class RegisterDtoTest {
    
    private RegisteredSession session;
    
    private Block block;
    
    private Period period;
    
    private CourseGroup courseGroup;
    
    private YearGroup yearGroup;
    
    private Level level1;
    
    private Subject maths;
    
    private ExamBoard examBoard1;
    
    private AcademicYear academicYear1;
    
    private AcademicYear year;
    
    private Gender female;
    
    private LegalSex Female
    
    private Title mrs;
    
    private Address address1;
    
    private Person person1;
    
    private Course course;
    
    private Department department;
    
    private StaffType staffType1;
    
    private Staff staff;
    
    private PossibleGradeSet possibleGradeSet
    
    private Faculty faculty;
    
    private Register register1;
    
    private Register register2;
    
    private Register register3;
    
    private List<Register> registers
    
    @Before
    public void setup() {
        this.register1 = new Register(
                id: 1,
                session: new RegisteredSession(),
                courseGroup: new CourseGroup(),
                completed: true,
                staffCompleted: new Staff(),
                dateCompleted: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        this.register2 = new Register(
                id: 2,
                session: new RegisteredSession(),
                courseGroup: new CourseGroup(),
                completed: true,
                staffCompleted: new Staff(),
                dateCompleted: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        this.register3 = new Register(
                id: 3,
                session: null,
                courseGroup: null,
                completed: true,
                staffCompleted: null,
                dateCompleted: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        this.registers = Arrays.asList(this.register1, this.register2);
    }
    
    RegisterDto generateRegisterDto() {
        return generateRegister1Dto()
    }
    
    RegisterDto generateRegister1Dto() {
        return new RegisterDto(register1.id, register1.session.id, register1.courseGroup.id, register1.completed, register1.staffCompleted.id, register1.dateCompleted)
    }
    
    RegisterDto generateRegister2Dto() {
        return new RegisterDto(register2.id, register2.session.id, register2.courseGroup.id, register2.completed, register2.staffCompleted.id, register2.dateCompleted)
    }
    
    @Test
    public void testConstructorNullObject() {
        Register register = null
        RegisterDto registerTest = new RegisterDto( register );
        assertEquals( register, null);
    }
    
    @Test
    public void testConstructorNullSession() {
        RegisterDto registerTest = new RegisterDto( register3 );
        assertEquals( registerTest.id, register3.id);
        assertEquals( registerTest.sessionId, register3.session);
        assertEquals( registerTest.courseGroupId, register3.courseGroup);
        assertEquals( registerTest.completed, register3.completed);
        assertEquals( registerTest.staffCompletedId, register3.staffCompleted);
        assertEquals( registerTest.dateCompleted, register3.dateCompleted);
    }
    
    @Test
    public void testMapFromRegisterEntity() {
        RegisterDto registerTest = RegisterDto.mapFromEntity( register1 );
        assertEquals( registerTest.id, register1.id);
        assertEquals( registerTest.sessionId, register1.session.id);
        assertEquals( registerTest.courseGroupId, register1.courseGroup.id);
        assertEquals( registerTest.completed, register1.completed);
        assertEquals( registerTest.staffCompletedId, register1.staffCompleted.id);
        assertEquals( registerTest.dateCompleted, register1.dateCompleted);
    }
    
    @Test
    public void testMapFromRegistersEntities(){
        List<RegisterDto> registerTest = RegisterDto.mapFromList( registers )
        assertEquals( registerTest [0].id, register1.id);
        assertEquals( registerTest [0].sessionId, register1.session.id);
        assertEquals( registerTest [0].courseGroupId, register2.courseGroup.id);
        assertEquals( registerTest [0].completed, register1.completed);
        assertEquals( registerTest [0].staffCompletedId, register1.staffCompleted.id);
        assertEquals( registerTest [0].dateCompleted, register1.dateCompleted);
        assertEquals( registerTest [1].id, register2.id );
        assertEquals( registerTest [1].sessionId, register2.session.id);
        assertEquals( registerTest [1].courseGroupId, register2.courseGroup.id);
        assertEquals( registerTest [1].completed, register2.completed);
        assertEquals( registerTest [1].staffCompletedId, register2.staffCompleted.id);
        assertEquals( registerTest [1].dateCompleted, register2.dateCompleted);
    }
    
    @Test
    public void testEquals_Same() {
        RegisterDto registerDto1 = new RegisterDto(register1)
        RegisterDto registerDto2 = new RegisterDto(register1)
        assertEquals( registerDto1, registerDto2 );
    }
    
    @Test
    public void testEquals_Different() {
        RegisterDto registerDto1 = new RegisterDto(register1)
        RegisterDto registerDto2 = new RegisterDto(register2)
        assertNotEquals( registerDto1, registerDto2 );
    }
    
    @Test
    public void testHashCode_Same() {
        RegisterDto registerDto1 = new RegisterDto(register1)
        RegisterDto registerDto2 = new RegisterDto(register1)
        assertEquals( registerDto1.hashCode(), registerDto2.hashCode() );
    }
    
    @Test
    public void testHashCode_Different() {
        RegisterDto registerDto1 = new RegisterDto(register1)
        RegisterDto registerDto2 = new RegisterDto(register2)
        assertNotEquals( registerDto1.hashCode(), registerDto2.hashCode() );
    }
}