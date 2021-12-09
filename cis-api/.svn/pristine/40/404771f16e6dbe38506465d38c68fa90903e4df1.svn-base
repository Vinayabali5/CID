package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.academic.WorkPlacementMode
import uk.ac.reigate.exceptions.InvalidDataException

public class WorkPlacementModeDtoTest {
    
    private WorkPlacementMode workPlacementMode1
    
    private WorkPlacementMode workPlacementMode2
    
    private List<WorkPlacementMode> workPlacementModes
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void setup() {
        workPlacementMode1 = new WorkPlacementMode(
                id: 1,
                code:'IP',
                description:'Internal Placement'
                );
        workPlacementMode2 = new WorkPlacementMode(
                id: 2,
                code:'EP',
                description:'External Placement'
                );
        workPlacementModes = Arrays.asList(workPlacementMode1, workPlacementMode2);
    }
    
    @Test
    public void testConstructor_NullWorkPlacementMode() {
        WorkPlacementMode workPlacementMode = null
        WorkPlacementModeDto workPlacementModeDto = new WorkPlacementModeDto(workPlacementMode)
        assertEquals( workPlacementMode, null)
    }
    
    @Test
    public void testMapFromWorkPlacementModeEntity(){
        WorkPlacementModeDto workPlacementModeTest = WorkPlacementModeDto.mapFromEntity( workPlacementMode1 )
        assertEquals( workPlacementModeTest.id, workPlacementMode1.id );
        assertEquals( workPlacementModeTest.code, workPlacementMode1.code);
        assertEquals( workPlacementModeTest.description, workPlacementMode1.description);
    }
    
    @Test
    public void testMapFromWorkPlacementModesEntities(){
        List<WorkPlacementModeDto> workPlacementModesDtoTest = WorkPlacementModeDto.mapFromList( workPlacementModes )
        assertEquals( workPlacementModesDtoTest[0].id, workPlacementMode1.id );
        assertEquals( workPlacementModesDtoTest[0].code, workPlacementMode1.code);
        assertEquals( workPlacementModesDtoTest[0].description, workPlacementMode1.description);
        assertEquals( workPlacementModesDtoTest[1].id, workPlacementMode2.id );
        assertEquals( workPlacementModesDtoTest[1].code, workPlacementMode2.code);
        assertEquals( workPlacementModesDtoTest[1].description, workPlacementMode2.description);
    }
    
    
    @Test
    public void testEquals_Same() {
        WorkPlacementModeDto workPlacementModeDto1 = new WorkPlacementModeDto(workPlacementMode1)
        WorkPlacementModeDto workPlacementModeDto2 = new WorkPlacementModeDto(workPlacementMode1)
        assertEquals(workPlacementModeDto1, workPlacementModeDto2)
    }
    
    @Test
    public void testEquals_Different() {
        WorkPlacementModeDto workPlacementModeDto1 = new WorkPlacementModeDto(workPlacementMode1)
        WorkPlacementModeDto workPlacementModeDto2 = new WorkPlacementModeDto(workPlacementMode2)
        assertNotEquals(workPlacementModeDto1, workPlacementModeDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        WorkPlacementModeDto workPlacementModeDto1 = new WorkPlacementModeDto(workPlacementMode1)
        WorkPlacementModeDto workPlacementModeDto2 = new WorkPlacementModeDto(workPlacementMode1)
        assertEquals(workPlacementModeDto1.hashCode(), workPlacementModeDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        WorkPlacementModeDto workPlacementModeDto1 = new WorkPlacementModeDto(workPlacementMode1)
        WorkPlacementModeDto workPlacementModeDto2 = new WorkPlacementModeDto(workPlacementMode2)
        assertNotEquals(workPlacementModeDto1.hashCode(), workPlacementModeDto2.hashCode())
    }
    
    @Test
    public void testConstructor_WorkPlacementMode() {
        WorkPlacementModeDto workPlacementModeDto = new WorkPlacementModeDto(workPlacementMode1)
        assertEquals( workPlacementModeDto.code, workPlacementMode1.code )
        assertEquals( workPlacementModeDto.description, workPlacementMode1.description )
    }
}
