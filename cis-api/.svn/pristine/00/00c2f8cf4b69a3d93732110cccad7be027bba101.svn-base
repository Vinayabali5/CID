package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.AttendanceMonitoring
import uk.ac.reigate.domain.lookup.PunctualityMonitoring
import uk.ac.reigate.domain.lookup.WarningCodeChange
import uk.ac.reigate.exceptions.InvalidDataException

public class WarningCodeChangeDtoTest {
    
    private WarningCodeChange warningCodeChange1
    
    private WarningCodeChange warningCodeChange2
    
    private WarningCodeChange warningCodeChange3
    
    private List<WarningCodeChange> warningCodeChanges
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    @Before
    public void setup() {
        warningCodeChange1 = new WarningCodeChange(
                id: 1,
                student: createStudent(),
                year : new AcademicYear(id: 1),
                previousAm : new AttendanceMonitoring(id:1, description: 'AM'),
                currentAm : new AttendanceMonitoring(id:2, description: 'AM'),
                previousPm : new PunctualityMonitoring(id:3, description: 'AM'),
                currentPm : new PunctualityMonitoring(id:4, description: 'AM'),
                changeDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01')
                );
        warningCodeChange2 = new WarningCodeChange(
                id: 2,
                student: createStudent(),
                year : new AcademicYear(id: 2),
                previousAm : new AttendanceMonitoring(id:1 ),
                currentAm : new AttendanceMonitoring(id:2 ),
                previousPm : new PunctualityMonitoring(id:3 ),
                currentPm : new PunctualityMonitoring(id:4 ),
                changeDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01')
                );
        warningCodeChange3 = new WarningCodeChange(
                id: 3,
                student: null,
                year : null,
                previousAm : null,
                currentAm : null,
                previousPm : null,
                currentPm : null,
                changeDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01')
                );
        warningCodeChanges = Arrays.asList(warningCodeChange1, warningCodeChange2);
    }
    
    @Test
    public void testConstructor_NullWarningCodeChange() {
        WarningCodeChange warningCodeChange = null
        WarningCodeChangeDto warningCodeChangeDto = new WarningCodeChangeDto(warningCodeChange)
        assertEquals( warningCodeChange, null)
    }
    
    @Test
    public void testMapFromWarningCodeChangeEntity(){
        WarningCodeChangeDto warningCodeChangeTest = WarningCodeChangeDto.mapFromEntity( warningCodeChange1 )
        assertEquals( warningCodeChangeTest.id, warningCodeChange1.id );
        assertEquals( warningCodeChangeTest.yearId, warningCodeChange1.year.id);
        assertEquals( warningCodeChangeTest.previousAmId, warningCodeChange1.previousAm.id);
        assertEquals( warningCodeChangeTest.currentAmId, warningCodeChange1.currentAm.id)
        assertEquals( warningCodeChangeTest.previousPmId, warningCodeChange1.previousPm.id)
        assertEquals( warningCodeChangeTest.currentPmId, warningCodeChange1.currentPm.id)
    }
    
    @Test
    public void testMapFromWarningCodeChangesEntities(){
        List<WarningCodeChangeDto> warningCodeChangesDtoTest = WarningCodeChangeDto.mapFromList( warningCodeChanges )
        assertEquals( warningCodeChangesDtoTest[0].id, warningCodeChange1.id );
        assertEquals( warningCodeChangesDtoTest[0].yearId, warningCodeChange1.year.id);
        assertEquals( warningCodeChangesDtoTest[0].previousAmId, warningCodeChange1.previousAm.id);
        assertEquals( warningCodeChangesDtoTest[0].currentAmId, warningCodeChange1.currentAm.id);
        assertEquals( warningCodeChangesDtoTest[0].previousPmId, warningCodeChange1.previousPm.id);
        assertEquals( warningCodeChangesDtoTest[0].currentPmId, warningCodeChange1.currentPm.id);
        assertEquals( warningCodeChangesDtoTest[1].id, warningCodeChange2.id );
        assertEquals( warningCodeChangesDtoTest[1].yearId, warningCodeChange2.year.id);
        assertEquals( warningCodeChangesDtoTest[1].previousAmId, warningCodeChange2.previousAm.id);
        assertEquals( warningCodeChangesDtoTest[1].currentAmId, warningCodeChange2.currentAm.id);
        assertEquals( warningCodeChangesDtoTest[1].previousPmId, warningCodeChange2.previousPm.id);
        assertEquals( warningCodeChangesDtoTest[1].currentPmId, warningCodeChange2.currentPm.id);
    }
    
    @Test
    public void testEquals_Same() {
        WarningCodeChangeDto warningCodeChangeDto1 = new WarningCodeChangeDto(warningCodeChange1)
        WarningCodeChangeDto warningCodeChangeDto2 = new WarningCodeChangeDto(warningCodeChange1)
        assertEquals(warningCodeChangeDto1, warningCodeChangeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        WarningCodeChangeDto warningCodeChangeDto1 = new WarningCodeChangeDto(warningCodeChange1)
        WarningCodeChangeDto warningCodeChangeDto2 = new WarningCodeChangeDto(warningCodeChange2)
        assertNotEquals(warningCodeChangeDto1, warningCodeChangeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        WarningCodeChangeDto warningCodeChangeDto1 = new WarningCodeChangeDto(warningCodeChange1)
        WarningCodeChangeDto warningCodeChangeDto2 = new WarningCodeChangeDto(warningCodeChange1)
        assertEquals(warningCodeChangeDto1.hashCode(), warningCodeChangeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        WarningCodeChangeDto warningCodeChangeDto1 = new WarningCodeChangeDto(warningCodeChange1)
        WarningCodeChangeDto warningCodeChangeDto2 = new WarningCodeChangeDto(warningCodeChange2)
        assertNotEquals(warningCodeChangeDto1.hashCode(), warningCodeChangeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_WarningCodeChange() {
        WarningCodeChangeDto warningCodeChangeTest= new WarningCodeChangeDto(warningCodeChange1)
        assertEquals( warningCodeChangeTest.id, warningCodeChange1.id );
        assertEquals( warningCodeChangeTest.yearId, warningCodeChange1.year.id);
        assertEquals( warningCodeChangeTest.previousAmId, warningCodeChange1.previousAm.id);
        assertEquals( warningCodeChangeTest.currentAmId, warningCodeChange1.currentAm.id)
        assertEquals( warningCodeChangeTest.previousPmId, warningCodeChange1.previousPm.id)
        assertEquals( warningCodeChangeTest.currentPmId, warningCodeChange1.currentPm.id)
    }
    
    @Test
    public void testConstructor_NullYear() {
        WarningCodeChangeDto warningCodeChangeTest= new WarningCodeChangeDto(warningCodeChange3)
        assertEquals( warningCodeChangeTest.id, warningCodeChange3.id );
        assertEquals( warningCodeChangeTest.yearId, null);
        assertEquals( warningCodeChangeTest.previousAmId, warningCodeChange3.previousAm);
        assertEquals( warningCodeChangeTest.currentAmId, warningCodeChange3.currentAm)
        assertEquals( warningCodeChangeTest.previousPmId, warningCodeChange3.previousPm)
        assertEquals( warningCodeChangeTest.currentPmId, warningCodeChange3.currentPm)
    }
    
    @Test
    public void testMethod_Get_NullPreviousAmDescription() {
        WarningCodeChangeDto warningCodeChangeDto1 = new WarningCodeChangeDto(warningCodeChange3)
        assertEquals(warningCodeChangeDto1.previousAm, warningCodeChangeDto1.get_PreviousAmDescription())
    }
    
    @Test
    public void testMethod_Get_PreviousAmDescription() {
        WarningCodeChangeDto warningCodeChangeDto1 = new WarningCodeChangeDto(warningCodeChange1)
        assertEquals(warningCodeChangeDto1.previousAm.description, warningCodeChangeDto1.get_PreviousAmDescription())
    }
    
    @Test
    public void testMethod_Get_NullCurrentAmDescription() {
        WarningCodeChangeDto warningCodeChangeDto1 = new WarningCodeChangeDto(warningCodeChange3)
        assertEquals(warningCodeChangeDto1.currentAm, warningCodeChangeDto1.get_CurrentAmDescription())
    }
    
    @Test
    public void testMethod_Get_CurrentAmDescription() {
        WarningCodeChangeDto warningCodeChangeDto1 = new WarningCodeChangeDto(warningCodeChange1)
        assertEquals(warningCodeChangeDto1.currentAm.description, warningCodeChangeDto1.get_CurrentAmDescription())
    }
    
    @Test
    public void testMethod_Get_NullPreviousPmDescription() {
        WarningCodeChangeDto warningCodeChangeDto1 = new WarningCodeChangeDto(warningCodeChange3)
        assertEquals(warningCodeChangeDto1.previousPm, warningCodeChangeDto1.get_PreviousPmDescription())
    }
    
    @Test
    public void testMethod_Get_PreviousPmDescription() {
        WarningCodeChangeDto warningCodeChangeDto1 = new WarningCodeChangeDto(warningCodeChange1)
        assertEquals(warningCodeChangeDto1.previousPm.description, warningCodeChangeDto1.get_PreviousPmDescription())
    }
    
    @Test
    public void testMethod_Get_NullCurrentPmDescription() {
        WarningCodeChangeDto warningCodeChangeDto1 = new WarningCodeChangeDto(warningCodeChange3)
        assertEquals(warningCodeChangeDto1.currentPm, warningCodeChangeDto1.get_CurrentPmDescription())
    }
    
    @Test
    public void testMethod_Get_CurrentPmDescription() {
        WarningCodeChangeDto warningCodeChangeDto1 = new WarningCodeChangeDto(warningCodeChange1)
        assertEquals(warningCodeChangeDto1.currentPm.description, warningCodeChangeDto1.get_CurrentPmDescription())
    }
}
