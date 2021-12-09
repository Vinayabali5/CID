package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.EntryQualificationType
import uk.ac.reigate.domain.lookup.PossibleGradeSet



public class EntryQualificationTypeDtoTest {
    
    private EntryQualificationType entryQualificationType1
    
    private EntryQualificationType entryQualificationType2
    
    private List<EntryQualificationType> entryQualificationTypes
    
    @Before
    public void setup() {
        this.entryQualificationType1 = new EntryQualificationType(
                id: 1,
                code:'M',
                description:'M',
                possibleGradeSet: new PossibleGradeSet(id: 1),
                size: 199.33F
                );
        this.entryQualificationType2 = new EntryQualificationType(
                id: 2,
                code:'F',
                description:'F',
                size: 198.33F
                );
        this.entryQualificationTypes = Arrays.asList(this.entryQualificationType1, this.entryQualificationType2);
    }
    
    @Test
    public void testMapFromEntryQualificationTypeEntity(){
        EntryQualificationTypeDto entryQualificationTypeTest = EntryQualificationTypeDto.mapFromEntity( entryQualificationType1 )
        assertEquals( entryQualificationTypeTest.id, entryQualificationType1.id );
        assertEquals( entryQualificationTypeTest.code, entryQualificationType1.code);
        assertEquals( entryQualificationTypeTest.description, entryQualificationType1.description);
    }
    
    @Test
    public void testMapFromEntryQualificationTypesEntities(){
        List<EntryQualificationTypeDto> entryQualificationTypesDtoTest = EntryQualificationTypeDto.mapFromList( this.entryQualificationTypes )
        assertEquals( entryQualificationTypesDtoTest[0].id, entryQualificationType1.id );
        assertEquals( entryQualificationTypesDtoTest[0].code, entryQualificationType1.code);
        assertEquals( entryQualificationTypesDtoTest[0].description, entryQualificationType1.description);
        assertEquals( entryQualificationTypesDtoTest[1].id, entryQualificationType2.id );
        assertEquals( entryQualificationTypesDtoTest[1].code, entryQualificationType2.code);
        assertEquals( entryQualificationTypesDtoTest[1].description, entryQualificationType2.description);
    }
    
    @Test
    public void testEquals_Same() {
        EntryQualificationTypeDto entryQualificationTypeDto1 = new EntryQualificationTypeDto(entryQualificationType1)
        EntryQualificationTypeDto entryQualificationTypeDto2 = new EntryQualificationTypeDto(entryQualificationType1)
        assertEquals(entryQualificationTypeDto1, entryQualificationTypeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        EntryQualificationTypeDto entryQualificationTypeDto1 = new EntryQualificationTypeDto(entryQualificationType1)
        EntryQualificationTypeDto entryQualificationTypeDto2 = new EntryQualificationTypeDto(entryQualificationType2)
        assertNotEquals(entryQualificationTypeDto1, entryQualificationTypeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        EntryQualificationTypeDto entryQualificationTypeDto1 = new EntryQualificationTypeDto(entryQualificationType1)
        EntryQualificationTypeDto entryQualificationTypeDto2 = new EntryQualificationTypeDto(entryQualificationType1)
        assertEquals(entryQualificationTypeDto1.hashCode(), entryQualificationTypeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        EntryQualificationTypeDto entryQualificationTypeDto1 = new EntryQualificationTypeDto(entryQualificationType1)
        EntryQualificationTypeDto entryQualificationTypeDto2 = new EntryQualificationTypeDto(entryQualificationType2)
        assertNotEquals(entryQualificationTypeDto1.hashCode(), entryQualificationTypeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_EntryQualificationType() {
        EntryQualificationTypeDto entryQualificationTypeDto = new EntryQualificationTypeDto(entryQualificationType1)
        assertEquals( entryQualificationTypeDto.code, entryQualificationType1.code )
        assertEquals( entryQualificationTypeDto.description, entryQualificationType1.description )
        assertEquals( entryQualificationTypeDto.possibleGradeSetId, entryQualificationType1.possibleGradeSet.id )
    }
    
    @Test
    public void testMethod_Get_EntryQualification() {
        EntryQualificationTypeDto entryQualificationTypeDto = new EntryQualificationTypeDto(entryQualificationType1)
        assertEquals(entryQualificationTypeDto.possibleGradeSet.description, entryQualificationTypeDto.get_EntryQualificationTypeDescription())
    }
    
    @Test
    public void testMethod_Get_EntryQualification_Null() {
        EntryQualificationType entryQualificationType = new EntryQualificationType(
                id: 2,
                code:'F',
                possibleGradeSet : null,
                description:'F',
                size: 198.33F
                );
        EntryQualificationTypeDto entryQualificationTypeDto = new EntryQualificationTypeDto(entryQualificationType)
        assertEquals(entryQualificationTypeDto.possibleGradeSet, entryQualificationTypeDto.get_EntryQualificationTypeDescription(), 'Not Set')
    }
}
