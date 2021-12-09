package uk.ac.reigate.dto.careers;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.CareersRecordType
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentCareersRecord



public class StudentCareersRecordDtoTest {
    
    private StudentCareersRecord studentCareersRecord1
    
    private StudentCareersRecord studentCareersRecord2
    
    private StudentCareersRecord studentCareersRecord3
    
    private List<StudentCareersRecord> studentCareersRecords
    
    @Before
    public void setup() {
        studentCareersRecord1 = new StudentCareersRecord(
                id: 1,
                student: new Student(id:1 ),
                startDate:new SimpleDateFormat("yyyy/MM/dd").parse('2014/09/01'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2014/09/02'),
                note: 'Test',
                employerInstitution: 'Reigate',
                organiser: 'College',
                careersRecordType : new CareersRecordType(id: 1, description: 'Internal')
                );
        studentCareersRecord2 = new StudentCareersRecord(
                id: 2,
                student: new Student(id:2 ),
                startDate:new SimpleDateFormat("yyyy/MM/dd").parse('2014/09/02'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2014/09/03'),
                note: 'Test',
                employerInstitution: 'Reigate College',
                organiser: 'Reigate College',
                careersRecordType : new CareersRecordType()
                );
        studentCareersRecord3 = new StudentCareersRecord(
                id: 3,
                student: null,
                startDate:new SimpleDateFormat("yyyy/MM/dd").parse('2014/09/02'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2014/09/03'),
                note: 'Test',
                employerInstitution: 'Reigate College',
                organiser: 'Reigate College',
                careersRecordType : null
                );
        studentCareersRecords = Arrays.asList(studentCareersRecord1, studentCareersRecord2);
    }
    
    @Test
    public void testMapFromStudentCareersRecordEntity(){
        StudentCareersRecordDto studentCareersRecordTest = StudentCareersRecordDto.mapFromEntity( studentCareersRecord1 )
        assertEquals( studentCareersRecordTest.id, studentCareersRecord1.id );
        assertEquals( studentCareersRecordTest.endDate, studentCareersRecord1.endDate);
        assertEquals( studentCareersRecordTest.note, studentCareersRecord1.note);
    }
    
    @Test
    public void testMapFromStudentCareersRecordsEntities(){
        List<StudentCareersRecordDto> studentCareersRecordsDtoTest = StudentCareersRecordDto.mapFromList( studentCareersRecords )
        assertEquals( studentCareersRecordsDtoTest[0].id, studentCareersRecord1.id );
        assertEquals( studentCareersRecordsDtoTest[0].startDate, studentCareersRecord1.startDate);
        assertEquals( studentCareersRecordsDtoTest[0].endDate, studentCareersRecord1.endDate);
        assertEquals( studentCareersRecordsDtoTest[1].id, studentCareersRecord2.id );
        assertEquals( studentCareersRecordsDtoTest[1].startDate, studentCareersRecord2.startDate);
        assertEquals( studentCareersRecordsDtoTest[1].endDate, studentCareersRecord2.endDate);
    }
    
    
    @Test
    public void testEquals_Same() {
        StudentCareersRecordDto studentCareersRecordDto1 = new StudentCareersRecordDto(studentCareersRecord1)
        StudentCareersRecordDto studentCareersRecordDto2 = new StudentCareersRecordDto(studentCareersRecord1)
        assertEquals(studentCareersRecordDto1, studentCareersRecordDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentCareersRecordDto studentCareersRecordDto1 = new StudentCareersRecordDto(studentCareersRecord1)
        StudentCareersRecordDto studentCareersRecordDto2 = new StudentCareersRecordDto(studentCareersRecord2)
        assertNotEquals(studentCareersRecordDto1, studentCareersRecordDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentCareersRecordDto studentCareersRecordDto1 = new StudentCareersRecordDto(studentCareersRecord1)
        StudentCareersRecordDto studentCareersRecordDto2 = new StudentCareersRecordDto(studentCareersRecord1)
        assertEquals(studentCareersRecordDto1.hashCode(), studentCareersRecordDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentCareersRecordDto studentCareersRecordDto1 = new StudentCareersRecordDto(studentCareersRecord1)
        StudentCareersRecordDto studentCareersRecordDto2 = new StudentCareersRecordDto(studentCareersRecord2)
        assertNotEquals(studentCareersRecordDto1.hashCode(), studentCareersRecordDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentCareersRecord() {
        StudentCareersRecordDto studentCareersRecordDto = new StudentCareersRecordDto(studentCareersRecord1)
        assertEquals( studentCareersRecordDto.startDate, studentCareersRecord1.startDate )
        assertEquals( studentCareersRecordDto.endDate, studentCareersRecord1.endDate )
    }
    
    @Test
    public void testConstructor_NullStudentCareersRecord() {
        StudentCareersRecord studentCareersRecord = null
        StudentCareersRecordDto studentCareersRecordDto = new StudentCareersRecordDto(studentCareersRecord)
        assertEquals( studentCareersRecord, null )
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentCareersRecordDto studentCareersRecordDto = new StudentCareersRecordDto(studentCareersRecord3)
        assertEquals( studentCareersRecordDto.studentId, studentCareersRecord3.student )
        assertEquals( studentCareersRecordDto.startDate, studentCareersRecord3.startDate )
        assertEquals( studentCareersRecordDto.endDate, studentCareersRecord3.endDate )
    }
    
    @Test
    public void testMethod_Get_CareersRecordTypeDescription() {
        StudentCareersRecordDto studentCareersRecordDto = new StudentCareersRecordDto(studentCareersRecord1)
        assertEquals(studentCareersRecordDto.careersRecordType.description,  studentCareersRecordDto.get_CareersRecordTypeDescription())
    }
    
    @Test
    public void testMethod_Get_NullCareersRecordTypeDescription() {
        StudentCareersRecordDto studentCareersRecordDto = new StudentCareersRecordDto(studentCareersRecord3)
        assertEquals(studentCareersRecordDto.careersRecordType,  studentCareersRecordDto.get_CareersRecordTypeDescription())
    }
}
