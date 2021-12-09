package uk.ac.reigate.dto.ilp;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.ilp.OfficeAction
import uk.ac.reigate.dto.ilp.OfficeActionDto

public class OfficeActionDtoTest {
    
    private OfficeAction officeAction1
    
    private OfficeAction officeAction2
    
    private List<OfficeAction> officeActions
    
    @Before
    public void setup() {
        this.officeAction1 = new OfficeAction(
                id: 1,
                action: 'A'
                );
        this.officeAction2 = new OfficeAction(
                id: 2,
                action: 'B'
                );
        this.officeActions = Arrays.asList(this.officeAction1, this.officeAction2);
    }
    
    @Test
    public void testMapFromOfficeActionEntity(){
        OfficeActionDto officeActionTest = OfficeActionDto.mapFromEntity( officeAction1 )
        assertEquals( officeActionTest.id, officeAction1.id );
        assertEquals( officeActionTest.action, officeAction1.action);
    }
    
    @Test
    public void testMapFromOfficeActionsEntities(){
        List<OfficeActionDto> officeActionsTest = OfficeActionDto.mapFromList( this.officeActions )
        assertEquals( officeActionsTest[0].id, officeAction1.id );
        assertEquals( officeActionsTest[0].action, officeAction1.action );
        assertEquals( officeActionsTest[1].id, officeAction2.id );
        assertEquals( officeActionsTest[1].action, officeAction2.action );
    }
    
    @Test
    public void testEquals_Same() {
        OfficeActionDto officeActionDto1 = new OfficeActionDto(officeAction1)
        OfficeActionDto officeActionDto2 = new OfficeActionDto(officeAction1)
        assertEquals(officeActionDto1, officeActionDto2)
    }
    
    @Test
    public void testEquals_Different() {
        OfficeActionDto officeActionDto1 = new OfficeActionDto(officeAction1)
        OfficeActionDto officeActionDto2 = new OfficeActionDto(officeAction2)
        assertNotEquals(officeActionDto1, officeActionDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        OfficeActionDto officeActionDto1 = new OfficeActionDto(officeAction1)
        OfficeActionDto officeActionDto2 = new OfficeActionDto(officeAction1)
        assertEquals(officeActionDto1.hashCode(), officeActionDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        OfficeActionDto officeActionDto1 = new OfficeActionDto(officeAction1)
        OfficeActionDto officeActionDto2 = new OfficeActionDto(officeAction2)
        assertNotEquals(officeActionDto1.hashCode(), officeActionDto2.hashCode())
    }
    
    @Test
    public void testConstructor_OfficeAction() {
        OfficeActionDto officeActionDto = new OfficeActionDto(officeAction1)
        assertEquals( officeActionDto.action, officeAction1.action )
    }
}
