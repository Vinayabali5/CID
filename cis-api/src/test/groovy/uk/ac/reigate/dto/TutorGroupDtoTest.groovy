package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Room
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Faculty
import uk.ac.reigate.domain.lookup.TutorGroup


public class TutorGroupDtoTest {
    
    private TutorGroup tutorGroup1
    
    private TutorGroup tutorGroup2
    
    private TutorGroup tutorGroup3
    
    private List<TutorGroup> tutorGroups
    
    @Before
    public void setupTests() {
        this.tutorGroup1 = new TutorGroup(
                id: 1,
                code: 'M',
                description: 'Male',
                faculty: new Faculty(id: 1, code: 'test', description: 'testing'),
                tutor: new Staff(id: 1, initials: 'vbm', knownAs: 'vinaya'),
                seniorTutor: new Staff(id: 1, initials: 'vbm', knownAs: 'vinaya'),
                room: new Room(id: 1, code: 'Office')
                );
        this.tutorGroup2 = new TutorGroup(
                id: 2,
                code: 'F',
                description: 'Female',
                faculty:new Faculty(),
                tutor: new Staff(),
                seniorTutor: new Staff(),
                room: new Room()
                );
        this.tutorGroup3 = new TutorGroup(
                id: 2,
                code: 'F',
                description: 'Female',
                faculty: null,
                tutor : null,
                seniorTutor: null,
                room : null
                );
        this.tutorGroups = Arrays.asList(tutorGroup1, tutorGroup2);
    }
    
    TutorGroupDto generateTutorGroupDto() {
        return generateTutorGroup1Dto()
    }
    
    TutorGroupDto generateTutorGroup1Dto() {
        return new TutorGroupDto(tutorGroup1.id, tutorGroup1.code, tutorGroup1.description, tutorGroup1.faculty.id)
    }
    
    TutorGroupDto generateTutorGroup2Dto() {
        return new TutorGroupDto(tutorGroup2.id, tutorGroup2.code, tutorGroup2.description, tutorGroup2.faculty.id)
    }
    
    @Test
    public void testConstructor_NullObject() {
        TutorGroup tutorGroup = null
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup)
        assertEquals(tutorGroup, null)
    }
    
    @Test
    public void testMapFromTutorGroupEntityTest(){
        TutorGroupDto tutorGroup = TutorGroupDto.mapFromEntity( tutorGroup1 )
        assertEquals( tutorGroup.id, tutorGroup1.id );
        assertEquals( tutorGroup.code, tutorGroup1.code);
        assertEquals( tutorGroup.description, tutorGroup1.description);
        assertEquals( tutorGroup.facultyId, tutorGroup1.faculty.id);
    }
    
    @Test
    public void testConstructor_NullFaculty() {
        TutorGroupDto tutorGroup = new TutorGroupDto(tutorGroup3)
        assertEquals( tutorGroup.id, tutorGroup3.id );
        assertEquals( tutorGroup.code, tutorGroup3.code);
        assertEquals( tutorGroup.description, tutorGroup3.description);
        assertEquals( tutorGroup.facultyId, null);
        assertEquals( tutorGroup.tutorId, null);
        assertEquals( tutorGroup.seniorTutorId, null);
        assertEquals( tutorGroup.roomId, null);
    }
    
    @Test
    public void testMapFromTutorGroupsEntitiesTest(){
        List<TutorGroupDto> tutorGroup = TutorGroupDto.mapFromList( tutorGroups )
        assertEquals( tutorGroup[0].id, tutorGroup1.id );
        assertEquals( tutorGroup[0].code, tutorGroup1.code);
        assertEquals( tutorGroup[0].description, tutorGroup1.description);
        assertEquals( tutorGroup[0].facultyId, tutorGroup1.faculty.id);
        assertEquals( tutorGroup[1].id, tutorGroup2.id );
        assertEquals( tutorGroup[1].code, tutorGroup2.code);
        assertEquals( tutorGroup[1].description, tutorGroup2.description);
        assertEquals( tutorGroup[1].facultyId, tutorGroup2.faculty.id);
    }
    
    @Test
    public void testEquals_Same() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup1)
        TutorGroupDto tutorGroupDto2 = new TutorGroupDto(tutorGroup1)
        assertEquals(tutorGroupDto1, tutorGroupDto2)
    }
    
    @Test
    public void testEquals_Different() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup1)
        TutorGroupDto tutorGroupDto2 = new TutorGroupDto(tutorGroup2)
        assertNotEquals(tutorGroupDto1, tutorGroupDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup1)
        TutorGroupDto tutorGroupDto2 = new TutorGroupDto(tutorGroup1)
        assertEquals(tutorGroupDto1.hashCode(), tutorGroupDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup1)
        TutorGroupDto tutorGroupDto2 = new TutorGroupDto(tutorGroup2)
        assertNotEquals(tutorGroupDto1.hashCode(), tutorGroupDto2.hashCode())
    }
    
    @Test
    public void testConstructor_TutorGroup() {
        TutorGroupDto tutorGroup = new TutorGroupDto(tutorGroup1)
        assertEquals( tutorGroup.id, tutorGroup1.id );
        assertEquals( tutorGroup.code, tutorGroup1.code);
        assertEquals( tutorGroup.description, tutorGroup1.description);
        assertEquals( tutorGroup.facultyId, tutorGroup1.faculty.id);
    }
    
    @Test
    public void testMethod_Get_NullFacultyCode() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup3)
        assertEquals(tutorGroupDto1.faculty, tutorGroupDto1.get_FacultyCode())
    }
    
    @Test
    public void testMethod_Get_FacultyCode() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup1)
        assertEquals(tutorGroupDto1.faculty.code, tutorGroupDto1.get_FacultyCode())
    }
    
    @Test
    public void testMethod_Get_NullFacultyDesc() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup3)
        assertEquals(tutorGroupDto1.faculty, tutorGroupDto1.get_FacultyDesc())
    }
    
    @Test
    public void testMethod_Get_FacultyDesc() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup1)
        assertEquals(tutorGroupDto1.faculty.description, tutorGroupDto1.get_FacultyDesc())
    }
    
    @Test
    public void testMethod_Get_NullRoomCode() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup3)
        assertEquals(tutorGroupDto1.room, tutorGroupDto1.get_RoomCode())
    }
    
    @Test
    public void testMethod_Get_RoomCode() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup1)
        assertEquals(tutorGroupDto1.room.code, tutorGroupDto1.get_RoomCode())
    }
    
    @Test
    public void testMethod_Get_NullTutorInitials() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup3)
        assertEquals(tutorGroupDto1.tutor, tutorGroupDto1.get_TutorInitials())
    }
    
    @Test
    public void testMethod_Get_TutorInitials() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup1)
        assertEquals(tutorGroupDto1.tutor.initials, tutorGroupDto1.get_TutorInitials())
    }
    
    @Test
    public void testMethod_Get_NullTutorName() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup3)
        assertEquals(tutorGroupDto1.tutor, tutorGroupDto1.get_TutorName())
    }
    
    @Test
    public void testMethod_Get_TutorName() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup1)
        assertEquals(tutorGroupDto1.tutor.knownAs, tutorGroupDto1.get_TutorName())
    }
    
    @Test
    public void testMethod_Get_NullSeniorTutorInitials() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup3)
        assertEquals(tutorGroupDto1.seniorTutor, tutorGroupDto1.get_seniorTutorInitials())
    }
    
    @Test
    public void testMethod_Get_SeniorTutorInitials() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup1)
        assertEquals(tutorGroupDto1.seniorTutor.initials, tutorGroupDto1.get_seniorTutorInitials())
    }
    
    @Test
    public void testMethod_Get_NullSeniorTutorName() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup3)
        assertEquals(tutorGroupDto1.seniorTutor, tutorGroupDto1.get_seniorTutorName())
    }
    
    @Test
    public void testMethod_Get_SeniorTutorName() {
        TutorGroupDto tutorGroupDto1 = new TutorGroupDto(tutorGroup1)
        assertEquals(tutorGroupDto1.seniorTutor.knownAs, tutorGroupDto1.get_seniorTutorName())
    }
}
