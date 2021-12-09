package uk.ac.reigate.dto;

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Room
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Period
import uk.ac.reigate.domain.academic.Timetable

import static org.junit.Assert.*

public class TimetableDtoTest {
    
    private Timetable timetable1
    
    private Timetable timetable2
    
    private Timetable timetable3
    
    private List<Timetable> timetables
    
    @Before
    public void setup() {
        timetable1 = new Timetable(
                id: 1,
                courseGroup: new CourseGroup(id: 1, spec: 'L-MAL'),
                period: new Period(id: 1),
                room: new Room(id:1),
                teacher: new Staff(id:1),
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2015/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2015/07/09')
                );
        timetable2 = new Timetable(
                id: 2,
                courseGroup: new CourseGroup(id: 1, spec: null),
                period: new Period(id: 1),
                room: null,
                teacher: null,
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2014/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2014/07/09')
                );
        timetable3 = new Timetable(
                id: 1,
                courseGroup: null,
                period: null,
                room: null,
                teacher: null,
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2015/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2015/07/09')
                );
        
        timetables = Arrays.asList(timetable1, timetable2);
    }
    
    @Test
    public void testConstructor_Timetable() {
        TimetableDto timetableTest = new TimetableDto(timetable1)
        assertEquals( timetableTest.id, timetable1.id );
        assertEquals( timetableTest.courseGroupId, timetable1.courseGroup.id);
        assertEquals( timetableTest.periodId, timetable1.period.id);
        assertEquals( timetableTest.roomId, timetable1.room.id);
        assertEquals( timetableTest.teacherId, timetable1.teacher.id);
        assertEquals( timetableTest.validFrom, timetable1.validFrom);
        assertEquals( timetableTest.validTo, timetable1.validTo);
    }
    
    @Test
    public void testConstructor_SpecNull() {
        TimetableDto timetableTest = new TimetableDto(timetable2)
        assertEquals( timetableTest.id, timetable2.id );
        assertEquals( timetableTest.courseGroupId, timetable2.courseGroup.id);
        assertEquals( timetableTest.periodId, timetable2.period.id);
    }
    
    @Test
    public void testConstructor_TimetableCourseGroupEndsWithL() {
        TimetableDto timetableTest = new TimetableDto(timetable1)
        assertEquals( timetableTest.id, timetable1.id );
        assertEquals( timetableTest.courseGroupId, timetable1.courseGroup.id);
        assertEquals( timetableTest.courseGroupId, timetable1.courseGroup.id);
    }
    
    @Test
    public void testConstructor_TimetableCourseGroupStartsWithL() {
        TimetableDto timetableTest = new TimetableDto(timetable1)
        assertEquals( timetableTest.id, timetable1.id );
        assertEquals( timetableTest.courseGroupId, timetable1.courseGroup.id);
    }
    
    @Test
    public void testConstructor_TimetableCourseGroupStartsWithU() {
        Timetable timetable = new Timetable(id: 1,
        courseGroup: new CourseGroup(id: 1, spec: 'U-MAH'),
        period: new Period(
        id: 1))
        TimetableDto timetableTest = new TimetableDto(timetable)
        assertEquals( timetableTest.id, timetable.id );
        assertEquals( timetableTest.courseGroupId, timetable.courseGroup.id);
    }
    
    
    @Test
    public void testConstructor_TimetableCourseGroupStartsWithP() {
        Timetable timetable = new Timetable(id: 1,
        courseGroup: new CourseGroup(id: 1, spec: 'P-MAH'),
        period: new Period(
        id: 1))
        TimetableDto timetableTest = new TimetableDto(timetable)
        assertEquals( timetableTest.id, timetable.id );
        assertEquals( timetableTest.courseGroupId, timetable.courseGroup.id);
    }
    
    @Test
    public void testConstructor_TimetableCourseGroupEndsWithP() {
        Timetable timetable = new Timetable(id: 1,
        courseGroup: new CourseGroup(id: 1, spec: 'U-MAP'),
        period: new Period(
        id: 1))
        TimetableDto timetableTest = new TimetableDto(timetable)
        assertEquals( timetableTest.id, timetable.id );
        assertEquals( timetableTest.courseGroupId, timetable.courseGroup.id);
    }
    
    @Test
    public void testMapFromTimetableEntity(){
        TimetableDto timetableTest = TimetableDto.mapFromEntity( timetable1 )
        assertEquals( timetableTest.id, timetable1.id );
        assertEquals( timetableTest.courseGroupId, timetable1.courseGroup.id);
        assertEquals( timetableTest.periodId, timetable1.period.id);
        assertEquals( timetableTest.roomId, timetable1.room.id);
        assertEquals( timetableTest.teacherId, timetable1.teacher.id);
        assertEquals( timetableTest.validFrom, timetable1.validFrom);
        assertEquals( timetableTest.validTo, timetable1.validTo);
    }
    
    @Test
    public void testMapFromTimetablesEntities(){
        List<TimetableDto> timetablesDtoTest = TimetableDto.mapFromList( timetables )
        assertEquals( timetablesDtoTest[0].id, timetable1.id );
        assertEquals( timetablesDtoTest[0].courseGroupId, timetable1.courseGroup.id);
        assertEquals( timetablesDtoTest[0].periodId, timetable1.period.id);
        assertEquals( timetablesDtoTest[0].roomId, timetable1.room.id);
        assertEquals( timetablesDtoTest[0].teacherId, timetable1.teacher.id);
        assertEquals( timetablesDtoTest[0].validFrom, timetable1.validFrom);
        assertEquals( timetablesDtoTest[0].validTo, timetable1.validTo);
        assertEquals( timetablesDtoTest[1].id, timetable2.id );
        assertEquals( timetablesDtoTest[1].courseGroupId, timetable2.courseGroup.id);
        assertEquals( timetablesDtoTest[1].periodId, timetable2.period.id);
        assertEquals( timetablesDtoTest[1].roomId, timetable2.room);
        assertEquals( timetablesDtoTest[1].teacherId, timetable2.teacher);
        assertEquals( timetablesDtoTest[1].validFrom, timetable2.validFrom);
        assertEquals( timetablesDtoTest[1].validTo, timetable2.validTo);
    }
    
    @Test
    public void testEquals_Same() {
        TimetableDto timetableDto1 = new TimetableDto(timetable1);
        TimetableDto timetableDto2 = new TimetableDto(timetable1);
        assertEquals(timetableDto1, timetableDto2)
    }
    
    @Test
    public void testEquals_Different() {
        TimetableDto timetableDto1 = new TimetableDto(timetable1);
        TimetableDto timetableDto2 = new TimetableDto(timetable2);
        assertNotEquals(timetableDto1, timetableDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        TimetableDto timetableDto1 = new TimetableDto(timetable1);
        TimetableDto timetableDto2 = new TimetableDto(timetable1);
        assertEquals(timetableDto1.hashCode(), timetableDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        TimetableDto timetableDto1 = new TimetableDto(timetable1);
        TimetableDto timetableDto2 = new TimetableDto(timetable2);
        assertNotEquals(timetableDto1.hashCode(), timetableDto2.hashCode())
    }
    
    @Test
    public void testConstructor_NullObjectTimetable() {
        TimetableDto timetableTest = new TimetableDto(timetable3)
        assertEquals( timetableTest.id, timetable3.id );
        assertEquals( timetableTest.courseGroupId, timetable3.courseGroup);
        assertEquals( timetableTest.periodId, timetable3.period);
        assertEquals( timetableTest.roomId, timetable3.room);
        assertEquals( timetableTest.teacherId, timetable3.teacher);
        assertEquals( timetableTest.validFrom, timetable3.validFrom);
        assertEquals( timetableTest.validTo, timetable3.validTo);
    }
    
    @Test
    public void testConstructor_NullTimetable() {
        Timetable timetable = null
        TimetableDto timetableTest = new TimetableDto(timetable)
        assertEquals( timetable, null)
    }
}
