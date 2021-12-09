package uk.ac.reigate.dto.attendance;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.attendance.StudentCourseGroupAttendance
import uk.ac.reigate.dto.StudentSummaryDto


public class StudentCourseGroupAttendanceDtoTest {
    
    private StudentCourseGroupAttendance studentCourseGroupAttendance1
    
    private StudentCourseGroupAttendance studentCourseGroupAttendance2
    
    private List<StudentCourseGroupAttendance> studentCourseGroupAttendances
    
    @Before
    public void setup() {
        this.studentCourseGroupAttendance1 = new StudentCourseGroupAttendance(
                student: new Student(id:190001),
                courseSpec: 'MATH',
                overallTotal: 1,
                overallIncluded: 2,
                overallPresent: 3,
                overallAbsent: 4,
                overallAuthorisedAbsent : 5,
                overallLate : 4,
                overallAuthorisedLate : 5,
                periodStartDate :new SimpleDateFormat("yyyy/MM/dd").parse('2014/09/01'),
                periodEndDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/06/30'),
                total : 3,
                included : 3,
                present : 5,
                absent: 4,
                late : 6,
                authorisedAbsent: 5,
                authorisedLate : 9
                );
        this.studentCourseGroupAttendance2 = new StudentCourseGroupAttendance(
                student: new Student(id:190001),
                courseSpec: 'MATH',
                overallTotal: 1,
                overallIncluded: 2,
                overallPresent: 3,
                overallAbsent: 4,
                overallAuthorisedAbsent : 5,
                overallLate : 4,
                overallAuthorisedLate : 5,
                periodStartDate :new SimpleDateFormat("yyyy/MM/dd").parse('2014/09/01'),
                periodEndDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/06/30'),
                total : 3,
                included : 3,
                present : 5,
                absent: 4,
                late : 6,
                authorisedAbsent: 5,
                authorisedLate : 9
                );
        this.studentCourseGroupAttendances = Arrays.asList(this.studentCourseGroupAttendance1, this.studentCourseGroupAttendance2);
    }
    
    @Test
    void testConstructor_studentCourseGroupAttendance() {
        StudentCourseGroupAttendanceDto studentCourseGroupAttendanceDto = new StudentCourseGroupAttendanceDto( studentCourseGroupAttendance1 )
        // assertEquals( studentCourseGroupAttendanceDto.student, studentCourseGroupAttendance1.student);
        assertEquals( studentCourseGroupAttendanceDto.courseSpec, studentCourseGroupAttendance1.courseSpec);
        assertEquals( studentCourseGroupAttendanceDto.overallTotal, studentCourseGroupAttendance1.overallTotal);
        assertEquals( studentCourseGroupAttendanceDto.overallIncluded, studentCourseGroupAttendance1.overallIncluded);
        assertEquals( studentCourseGroupAttendanceDto.overallPresent, studentCourseGroupAttendance1.overallPresent);
        assertEquals( studentCourseGroupAttendanceDto.overallAbsent, studentCourseGroupAttendance1.overallAbsent);
        assertEquals( studentCourseGroupAttendanceDto.overallAuthorisedAbsent, studentCourseGroupAttendance1.overallAuthorisedAbsent);
        assertEquals( studentCourseGroupAttendanceDto.overallLate, studentCourseGroupAttendance1.overallLate);
        assertEquals( studentCourseGroupAttendanceDto.overallAuthorisedLate, studentCourseGroupAttendance1.overallAuthorisedLate);
        assertEquals( studentCourseGroupAttendanceDto.periodStartDate, studentCourseGroupAttendance1.periodStartDate);
        assertEquals( studentCourseGroupAttendanceDto.periodEndDate, studentCourseGroupAttendance1.periodEndDate);
        assertEquals( studentCourseGroupAttendanceDto.total, studentCourseGroupAttendance1.total);
        assertEquals( studentCourseGroupAttendanceDto.included, studentCourseGroupAttendance1.included);
        assertEquals( studentCourseGroupAttendanceDto.present, studentCourseGroupAttendance1.present);
        assertEquals( studentCourseGroupAttendanceDto.absent, studentCourseGroupAttendance1.absent);
        assertEquals( studentCourseGroupAttendanceDto.authorisedAbsent, studentCourseGroupAttendance1.authorisedAbsent);
        assertEquals( studentCourseGroupAttendanceDto.late, studentCourseGroupAttendance1.late);
        assertEquals( studentCourseGroupAttendanceDto.authorisedLate, studentCourseGroupAttendance1.authorisedLate);
    }
    
    
    @Test
    public void testMapFromStudentCourseGroupAttendanceEntity() {
        StudentCourseGroupAttendanceDto studentCourseGroupAttendanceDto = StudentCourseGroupAttendanceDto.mapFromEntity( studentCourseGroupAttendance1 );
        //  assertEquals( studentCourseGroupAttendanceDto.student, studentCourseGroupAttendance1.student);
        assertEquals( studentCourseGroupAttendanceDto.courseSpec, studentCourseGroupAttendance1.courseSpec);
        assertEquals( studentCourseGroupAttendanceDto.overallTotal, studentCourseGroupAttendance1.overallTotal);
        assertEquals( studentCourseGroupAttendanceDto.overallIncluded, studentCourseGroupAttendance1.overallIncluded);
        assertEquals( studentCourseGroupAttendanceDto.overallPresent, studentCourseGroupAttendance1.overallPresent);
        assertEquals( studentCourseGroupAttendanceDto.overallAbsent, studentCourseGroupAttendance1.overallAbsent);
        assertEquals( studentCourseGroupAttendanceDto.overallAuthorisedAbsent, studentCourseGroupAttendance1.overallAuthorisedAbsent);
        assertEquals( studentCourseGroupAttendanceDto.overallLate, studentCourseGroupAttendance1.overallLate);
        assertEquals( studentCourseGroupAttendanceDto.overallAuthorisedLate, studentCourseGroupAttendance1.overallAuthorisedLate);
        assertEquals( studentCourseGroupAttendanceDto.periodStartDate, studentCourseGroupAttendance1.periodStartDate);
        assertEquals( studentCourseGroupAttendanceDto.periodEndDate, studentCourseGroupAttendance1.periodEndDate);
        assertEquals( studentCourseGroupAttendanceDto.total, studentCourseGroupAttendance1.total);
        assertEquals( studentCourseGroupAttendanceDto.included, studentCourseGroupAttendance1.included);
        assertEquals( studentCourseGroupAttendanceDto.present, studentCourseGroupAttendance1.present);
        assertEquals( studentCourseGroupAttendanceDto.absent, studentCourseGroupAttendance1.absent);
        assertEquals( studentCourseGroupAttendanceDto.authorisedAbsent, studentCourseGroupAttendance1.authorisedAbsent);
        assertEquals( studentCourseGroupAttendanceDto.late, studentCourseGroupAttendance1.late);
        assertEquals( studentCourseGroupAttendanceDto.authorisedLate, studentCourseGroupAttendance1.authorisedLate);
    }
    
    @Test
    public void testMapFromStudentCourseGroupAttendancesEntities(){
        List<StudentCourseGroupAttendanceDto> studentCourseGroupAttendanceDto = StudentCourseGroupAttendanceDto.mapFromList( this.studentCourseGroupAttendances )
        assertEquals( studentCourseGroupAttendanceDto[0].courseSpec, studentCourseGroupAttendance1.courseSpec);
        assertEquals( studentCourseGroupAttendanceDto[0].overallTotal, studentCourseGroupAttendance1.overallTotal);
        assertEquals( studentCourseGroupAttendanceDto[0].overallIncluded, studentCourseGroupAttendance1.overallIncluded);
        assertEquals( studentCourseGroupAttendanceDto[0].overallPresent, studentCourseGroupAttendance1.overallPresent);
        assertEquals( studentCourseGroupAttendanceDto[0].overallAbsent, studentCourseGroupAttendance1.overallAbsent);
        assertEquals( studentCourseGroupAttendanceDto[0].overallAuthorisedAbsent, studentCourseGroupAttendance1.overallAuthorisedAbsent);
        assertEquals( studentCourseGroupAttendanceDto[0].overallLate, studentCourseGroupAttendance1.overallLate);
        assertEquals( studentCourseGroupAttendanceDto[0].overallAuthorisedLate, studentCourseGroupAttendance1.overallAuthorisedLate);
        assertEquals( studentCourseGroupAttendanceDto[0].periodStartDate, studentCourseGroupAttendance1.periodStartDate);
        assertEquals( studentCourseGroupAttendanceDto[0].periodEndDate, studentCourseGroupAttendance1.periodEndDate);
        assertEquals( studentCourseGroupAttendanceDto[0].total, studentCourseGroupAttendance1.total);
        assertEquals( studentCourseGroupAttendanceDto[0].included, studentCourseGroupAttendance1.included);
        assertEquals( studentCourseGroupAttendanceDto[0].present, studentCourseGroupAttendance1.present);
        assertEquals( studentCourseGroupAttendanceDto[0].absent, studentCourseGroupAttendance1.absent);
        assertEquals( studentCourseGroupAttendanceDto[0].authorisedAbsent, studentCourseGroupAttendance1.authorisedAbsent);
        assertEquals( studentCourseGroupAttendanceDto[0].late, studentCourseGroupAttendance1.late);
        assertEquals( studentCourseGroupAttendanceDto[0].authorisedLate, studentCourseGroupAttendance1.authorisedLate);
        assertEquals( studentCourseGroupAttendanceDto[1].courseSpec, studentCourseGroupAttendance1.courseSpec);
        assertEquals( studentCourseGroupAttendanceDto[1].overallTotal, studentCourseGroupAttendance1.overallTotal);
        assertEquals( studentCourseGroupAttendanceDto[1].overallIncluded, studentCourseGroupAttendance1.overallIncluded);
        assertEquals( studentCourseGroupAttendanceDto[1].overallPresent, studentCourseGroupAttendance1.overallPresent);
        assertEquals( studentCourseGroupAttendanceDto[1].overallAbsent, studentCourseGroupAttendance1.overallAbsent);
        assertEquals( studentCourseGroupAttendanceDto[1].overallAuthorisedAbsent, studentCourseGroupAttendance1.overallAuthorisedAbsent);
        assertEquals( studentCourseGroupAttendanceDto[1].overallLate, studentCourseGroupAttendance1.overallLate);
        assertEquals( studentCourseGroupAttendanceDto[1].overallAuthorisedLate, studentCourseGroupAttendance1.overallAuthorisedLate);
        assertEquals( studentCourseGroupAttendanceDto[1].periodStartDate, studentCourseGroupAttendance1.periodStartDate);
        assertEquals( studentCourseGroupAttendanceDto[1].periodEndDate, studentCourseGroupAttendance1.periodEndDate);
        assertEquals( studentCourseGroupAttendanceDto[1].total, studentCourseGroupAttendance1.total);
        assertEquals( studentCourseGroupAttendanceDto[1].included, studentCourseGroupAttendance1.included);
        assertEquals( studentCourseGroupAttendanceDto[1].present, studentCourseGroupAttendance1.present);
        assertEquals( studentCourseGroupAttendanceDto[1].absent, studentCourseGroupAttendance1.absent);
        assertEquals( studentCourseGroupAttendanceDto[1].authorisedAbsent, studentCourseGroupAttendance1.authorisedAbsent);
        assertEquals( studentCourseGroupAttendanceDto[1].late, studentCourseGroupAttendance1.late);
        assertEquals( studentCourseGroupAttendanceDto[1].authorisedLate, studentCourseGroupAttendance1.authorisedLate);
    }
    
    @Test
    public void testHashCode_Different() {
        StudentCourseGroupAttendanceDto studentCourseGroupAttendanceDto1 = new StudentCourseGroupAttendanceDto(studentCourseGroupAttendance1)
        StudentCourseGroupAttendanceDto studentCourseGroupAttendanceDto2 = new StudentCourseGroupAttendanceDto(studentCourseGroupAttendance2)
        assertNotEquals( studentCourseGroupAttendanceDto1.hashCode(), studentCourseGroupAttendanceDto2.hashCode() );
    }
}
