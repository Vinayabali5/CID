package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.cristal.MasterRegister
import uk.ac.reigate.domain.register.AttendanceCode;;


public class MasterRegisterDtoTest {
    
    private MasterRegister masterRegister1
    
    private MasterRegister masterRegister2
    
    private MasterRegister masterRegister3
    
    private List<MasterRegister> masterRegisters
    
    Student createStudent() {
        Student student = new Student();
        student.id = 1;
        return student;
    }
    
    AttendanceCode createAttendanceCode() {
        AttendanceCode attendance = new AttendanceCode();
        attendance.id = 1;
        return attendance;
    }
    
    @Before
    public void setup() {
        masterRegister1 = new MasterRegister(
                id: 1,
                sessionRef : 1111201111,
                student: createStudent(),
                subjectCode:'M',
                group:'MAth',
                attendance : createAttendanceCode(),
                academicYear: new AcademicYear(id:1)
                );
        masterRegister2 = new MasterRegister(
                id: 2,
                sessionRef : 1111201111,
                student: createStudent(),
                subjectCode:'M',
                group:'MAth',
                attendance : createAttendanceCode(),
                academicYear: new AcademicYear(id:1)
                );
        masterRegister3 = new MasterRegister(
                id: 3,
                sessionRef : 1111201111,
                student: null,
                subjectCode:'M',
                group:'MAth',
                attendance : null,
                academicYear: null
                );
        masterRegisters = Arrays.asList(masterRegister1, masterRegister2);
    }
    
    @Test
    public void testConstructor_NullMasterRegister() {
        MasterRegister masterRegister = null
        MasterRegisterDto masterRegisterDto = new MasterRegisterDto(masterRegister)
        assertEquals( masterRegister, null );
    }
    
    @Test
    public void testMapFromMasterRegisterEntity(){
        MasterRegisterDto masterRegisterTest = MasterRegisterDto.mapFromEntity( masterRegister1 )
        assertEquals( masterRegisterTest.id, masterRegister1.id );
        assertEquals( masterRegisterTest.subjectCode, masterRegister1.subjectCode);
        assertEquals( masterRegisterTest.group, masterRegister1.group);
        assertEquals( masterRegisterTest.studentId, masterRegister1.student.id)
        assertEquals( masterRegisterTest.attendanceId, masterRegister1.attendance.id)
    }
    
    @Test
    public void testMapFromMasterRegistersEntities(){
        List<MasterRegisterDto> masterRegistersDtoTest = MasterRegisterDto.mapFromList( masterRegisters )
        assertEquals( masterRegistersDtoTest[0].id, masterRegister1.id );
        assertEquals( masterRegistersDtoTest[0].subjectCode, masterRegister1.subjectCode);
        assertEquals( masterRegistersDtoTest[0].group, masterRegister1.group);
        assertEquals( masterRegistersDtoTest[1].id, masterRegister2.id );
        assertEquals( masterRegistersDtoTest[1].subjectCode, masterRegister2.subjectCode);
        assertEquals( masterRegistersDtoTest[1].group, masterRegister2.group);
    }
    
    @Test
    public void testEquals_Same() {
        MasterRegisterDto masterRegisterDto1 = new MasterRegisterDto(masterRegister1)
        MasterRegisterDto masterRegisterDto2 = new MasterRegisterDto(masterRegister1)
        assertEquals(masterRegisterDto1, masterRegisterDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        MasterRegisterDto masterRegisterDto1 = new MasterRegisterDto(masterRegister1)
        MasterRegisterDto masterRegisterDto2 = new MasterRegisterDto(masterRegister1)
        assertEquals(masterRegisterDto1.hashCode(), masterRegisterDto2.hashCode())
    }
    
    @Test
    public void testConstructor_MasterRegister() {
        MasterRegisterDto masterRegisterTest= new MasterRegisterDto(masterRegister1)
        assertEquals( masterRegisterTest.subjectCode, masterRegister1.subjectCode);
        assertEquals( masterRegisterTest.group, masterRegister1.group);
        assertEquals( masterRegisterTest.studentId, masterRegister1.student.id)
        assertEquals( masterRegisterTest.attendanceId, masterRegister1.attendance.id)
    }
    
    @Test
    public void testConstructor_NullStudent() {
        MasterRegisterDto masterRegisterTest= new MasterRegisterDto(masterRegister3)
        assertEquals( masterRegisterTest.subjectCode, masterRegister3.subjectCode);
        assertEquals( masterRegisterTest.group, masterRegister3.group);
        assertEquals( masterRegisterTest.studentId, null)
        assertEquals( masterRegisterTest.attendanceId, masterRegister3.attendance)
        assertEquals( masterRegisterTest.academicYearId, null)
    }
}
