package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.academic.EntryQualification
import uk.ac.reigate.domain.academic.EntryQualificationType
import uk.ac.reigate.exceptions.InvalidDataException

public class EntryQualificationDtoTest {
    
    private EntryQualification entryQualification1
    
    private EntryQualification entryQualification2
    
    private EntryQualification entryQualification3
    
    private List<EntryQualification> entryQualifications
    
    EntryQualificationType createEntryQualificationType() {
        EntryQualificationType type = new EntryQualificationType()
        type.id = 1
        return type
    }
    
    @Before
    public void setup() {
        this.entryQualification1 = new EntryQualification(
                id: 1,
                title: 'MM',
                type: createEntryQualificationType(),
                basicList: true,
                shortCourse: true,
                dataMatchCode: 'M',
                webLinkCode:2
                );
        this.entryQualification2 = new EntryQualification(
                id: 2,
                title: 'SS',
                type: createEntryQualificationType(),
                basicList: true,
                shortCourse: true,
                dataMatchCode: 'S',
                webLinkCode:1
                );
        this.entryQualification3 = new EntryQualification(
                id: 2,
                title: 'SS',
                type: null,
                basicList: true,
                shortCourse: true,
                dataMatchCode: 'S',
                webLinkCode:1
                );
        this.entryQualifications = Arrays.asList(this.entryQualification1, this.entryQualification2);
    }
    
    @Test
    public void testConstructor_NullCollegeFundPaid() {
        EntryQualification entryQualification = null
        EntryQualificationDto entryQualificationDto = new EntryQualificationDto(entryQualification)
        assertEquals( entryQualification, null);
    }
    
    @Test
    public void testMapFromEntryQualificationEntity() {
        EntryQualificationDto entryQualificationTest = EntryQualificationDto.mapFromEntity( entryQualification1 );
        assertEquals( entryQualificationTest.id, entryQualification1.id);
        assertEquals( entryQualificationTest.title, entryQualification1.title);
        assertEquals( entryQualificationTest.basicList, entryQualification1.basicList);
        assertEquals( entryQualificationTest.shortCourse, entryQualification1.shortCourse);
        assertEquals( entryQualificationTest.dataMatchCode, entryQualification1.dataMatchCode);
    }
    
    @Test
    public void testMapFromEntryQualificationsEntities(){
        List<EntryQualificationDto> entryQualificationTest = EntryQualificationDto.mapFromList( this.entryQualifications )
        assertEquals( entryQualificationTest [0].id, entryQualification1.id);
        assertEquals( entryQualificationTest [0].title, entryQualification1.title);
        assertEquals( entryQualificationTest [0].basicList, entryQualification1.basicList);
        assertEquals( entryQualificationTest [0].shortCourse, entryQualification1.shortCourse);
        assertEquals( entryQualificationTest [0].dataMatchCode, entryQualification1.dataMatchCode);
        assertEquals( entryQualificationTest [1].id, entryQualification2.id );
        assertEquals( entryQualificationTest [1].title, entryQualification2.title );
        assertEquals( entryQualificationTest [1].basicList, entryQualification2.basicList );
        assertEquals( entryQualificationTest [1].shortCourse, entryQualification2.shortCourse);
        assertEquals( entryQualificationTest [1].dataMatchCode, entryQualification2.dataMatchCode);
    }
    
    @Test
    public void testEquals_Same() {
        EntryQualificationDto entryQualificationDto1 = new EntryQualificationDto( entryQualification1)
        EntryQualificationDto entryQualificationDto2 = new EntryQualificationDto( entryQualification1)
        assertEquals( entryQualificationDto1, entryQualificationDto2)
    }
    
    @Test
    public void testEquals_Different() {
        EntryQualificationDto entryQualificationDto1 = new EntryQualificationDto( entryQualification1)
        EntryQualificationDto entryQualificationDto2 = new EntryQualificationDto( entryQualification2)
        assertNotEquals( entryQualificationDto1, entryQualificationDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        EntryQualificationDto entryQualificationDto1 = new EntryQualificationDto( entryQualification1)
        EntryQualificationDto entryQualificationDto2 = new EntryQualificationDto( entryQualification1)
        assertEquals( entryQualificationDto1.hashCode(), entryQualificationDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        EntryQualificationDto entryQualificationDto1 = new EntryQualificationDto( entryQualification1)
        EntryQualificationDto entryQualificationDto2 = new EntryQualificationDto( entryQualification2)
        assertNotEquals( entryQualificationDto1.hashCode(), entryQualificationDto2.hashCode())
    }
    
    @Test
    public void testConstructor_EntryQualification() {
        EntryQualificationDto entryQualification = new EntryQualificationDto( entryQualification1)
        assertEquals( entryQualification.id, entryQualification1.id );
        assertEquals( entryQualification.title, entryQualification1.title );
        assertEquals( entryQualification.basicList, entryQualification1.basicList );
        assertEquals( entryQualification.shortCourse, entryQualification1.shortCourse );
        assertEquals( entryQualification.dataMatchCode, entryQualification1.dataMatchCode );
    }
    
    @Test
    public void testConstructor_NullEntryQualificationType() {
        EntryQualificationDto entryQualification = new EntryQualificationDto( entryQualification3)
        assertEquals( entryQualification.id, entryQualification3.id );
        assertEquals( entryQualification.entryQualificationTypeId, entryQualification3.type );
        assertEquals( entryQualification.title, entryQualification3.title );
        assertEquals( entryQualification.basicList, entryQualification3.basicList );
        assertEquals( entryQualification.shortCourse, entryQualification3.shortCourse );
        assertEquals( entryQualification.dataMatchCode, entryQualification3.dataMatchCode );
    }
    
    @Test
    public void testMethod_Get_NullEntryQualification() {
        EntryQualificationDto entryQualificationDto = new EntryQualificationDto(entryQualification3)
        assertEquals(entryQualificationDto.entryQualificationType, entryQualificationDto.get_EntryQualificationTypeDescription(), 'Not Set')
    }
    
    @Test
    public void testMethod_Get_EntryQualification() {
        EntryQualificationDto entryQualificationDto = new EntryQualificationDto(entryQualification1)
        assertEquals(entryQualificationDto.entryQualificationType.description, entryQualificationDto.get_EntryQualificationTypeDescription())
    }
}
