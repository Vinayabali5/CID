package uk.ac.reigate.dto;
import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.register.AttendanceCode

import static org.junit.Assert.*

public class AttendanceCodeDtoTest {
    
    private AttendanceCode attendanceCode1
    
    private AttendanceCode attendanceCode2
    
    private List<AttendanceCode> attendanceCodes
    
    @Before
    public void setup() {
        this.attendanceCode1 = new AttendanceCode(
                id: 1,
                code: 'Abs',
                description: 'Absent',
                registerMark: 'X',
                absence: true,
                authorisedAbsence: false,
                late: false,
                included: true,
                authorisedLate: false,
                lastDateOfAttendance: false,
                htmlColour: "#F00",
                accessColour: "Red"
                )
        this.attendanceCode2 = new AttendanceCode(
                id: 2,
                code: 'AuthAbs',
                description: 'Authorised Absence',
                registerMark: 'A',
                absence: true,
                authorisedAbsence: true,
                late: false,
                included: true,
                authorisedLate: false,
                lastDateOfAttendance: false,
                htmlColour: "#ABC",
                accessColour: "Amber"
                )
        this.attendanceCodes = Arrays.asList(this.attendanceCode1, this.attendanceCode2)
    }
    
    @Test
    void testConstructor_attendanceCode() {
        AttendanceCodeDto attendanceCodeTest = new AttendanceCodeDto(attendanceCode1)
        assertEquals(attendanceCodeTest.id, attendanceCode1.id)
        assertEquals(attendanceCodeTest.code, attendanceCode1.code)
        assertEquals(attendanceCodeTest.description, attendanceCode1.description)
        assertEquals(attendanceCodeTest.absence, attendanceCode1.absence)
        assertEquals(attendanceCodeTest.authorisedAbsence, attendanceCode1.authorisedAbsence)
        assertEquals(attendanceCodeTest.late, attendanceCode1.late)
        assertEquals(attendanceCodeTest.authorisedLate, attendanceCode1.authorisedLate)
    }
    
    @Test
    public void testConstructor_NullAttendanceCode() {
        AttendanceCode attendanceCode = null
        AttendanceCodeDto attendanceCodeDto = new AttendanceCodeDto(attendanceCode)
        assertEquals( attendanceCode, null )
    }
    
    @Test
    public void testMapFromAttendanceCodeEntity(){
        AttendanceCodeDto attendanceCodeTest = AttendanceCodeDto.mapFromEntity(attendanceCode1)
        assertEquals(attendanceCodeTest.id, attendanceCode1.id)
        assertEquals(attendanceCodeTest.code, attendanceCode1.code)
        assertEquals(attendanceCodeTest.description, attendanceCode1.description)
        assertEquals(attendanceCodeTest.absence, attendanceCode1.absence)
        assertEquals(attendanceCodeTest.authorisedAbsence, attendanceCode1.authorisedAbsence)
        assertEquals(attendanceCodeTest.late, attendanceCode1.late)
        assertEquals(attendanceCodeTest.authorisedLate, attendanceCode1.authorisedLate)
    }
    
    @Test
    public void testMapFromAttendanceCodesEntities(){
        List<AttendanceCodeDto> attendanceCodesTest = AttendanceCodeDto.mapFromList(this.attendanceCodes)
        assertEquals(attendanceCodesTest[0].id, attendanceCode1.id)
        assertEquals(attendanceCodesTest[0].code, attendanceCode1.code)
        assertEquals(attendanceCodesTest[0].description, attendanceCode1.description)
        assertEquals(attendanceCodesTest[0].absence, attendanceCode1.absence)
        assertEquals(attendanceCodesTest[0].authorisedAbsence, attendanceCode1.authorisedAbsence)
        assertEquals(attendanceCodesTest[0].late, attendanceCode1.late)
        assertEquals(attendanceCodesTest[0].authorisedLate,attendanceCode1.authorisedLate)
        assertEquals(attendanceCodesTest[1].id, attendanceCode2.id)
        assertEquals(attendanceCodesTest[1].code, attendanceCode2.code)
        assertEquals(attendanceCodesTest[1].description, attendanceCode2.description)
        assertEquals(attendanceCodesTest[1].absence, attendanceCode2.absence)
        assertEquals(attendanceCodesTest[1].authorisedAbsence, attendanceCode2.authorisedAbsence)
        assertEquals(attendanceCodesTest[1].late, attendanceCode2.late)
        assertEquals(attendanceCodesTest[1].authorisedLate, attendanceCode2.authorisedLate)
    }
    
    @Test
    public void testEquals_Same() {
        AttendanceCodeDto attendanceCodeDto1 = new AttendanceCodeDto(attendanceCode1)
        AttendanceCodeDto attendanceCodeDto2 = new AttendanceCodeDto(attendanceCode1)
        assertEquals(attendanceCodeDto1, attendanceCodeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        AttendanceCodeDto attendanceCodeDto1 = new AttendanceCodeDto(attendanceCode1)
        AttendanceCodeDto attendanceCodeDto2 = new AttendanceCodeDto(attendanceCode2)
        assertNotEquals(attendanceCodeDto1, attendanceCodeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        AttendanceCodeDto attendanceCodeDto1 = new AttendanceCodeDto(attendanceCode1)
        AttendanceCodeDto attendanceCodeDto2 = new AttendanceCodeDto(attendanceCode1)
        assertEquals(attendanceCodeDto1.hashCode(), attendanceCodeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        AttendanceCodeDto attendanceCodeDto1 = new AttendanceCodeDto(attendanceCode1)
        AttendanceCodeDto attendanceCodeDto2 = new AttendanceCodeDto(attendanceCode2)
        assertNotEquals(attendanceCodeDto1.hashCode(), attendanceCodeDto2.hashCode())
    }
}
