package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.ilr.Destination

public class DestinationDtoTest {
    
    private Destination destination1
    
    private Destination destination2
    
    private List<Destination> destinations
    
    @Before
    public void setup() {
        this.destination1 = new Destination(
                id: 1,
                type:'t',
                code: 'UK',
                description: 'United Kingdom',
                shortDescription:'United Kingdom',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        this.destination2 = new Destination(
                id: 2,
                type:'t',
                code: 'EU',
                description: 'European Ecconomical Union',
                shortDescription:'European Union',
                validFrom: new SimpleDateFormat("yyyy/MM/dd").parse('2011/07/09'),
                validTo: new SimpleDateFormat("yyyy/MM/dd").parse('2013/07/09')
                );
        this.destinations = Arrays.asList(destination1, destination2);
    }
    
    @Test
    public void test_ConstructorNullObject() {
        Destination destination = null
        DestinationDto destinationDto1 = new DestinationDto(destination)
        assertEquals( destination, null)
    }
    
    @Test
    public void testMapFromList(){
        List<DestinationDto> DestinationTest = DestinationDto.mapFromList( destinations )
        assertEquals( DestinationTest[0].id, destination1.id );
    }
    
    @Test
    public void testEquals_Same() {
        DestinationDto destinationDto1 = new DestinationDto(destination1)
        DestinationDto destinationDto2 = new DestinationDto(destination1)
        assertEquals( destinationDto1, destinationDto2)
    }
    
    @Test
    public void testEquals_Different() {
        DestinationDto destinationDto1 = new DestinationDto(destination1)
        DestinationDto destinationDto2 = new DestinationDto(destination2)
        assertNotEquals( destinationDto1, destinationDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        DestinationDto destinationDto1 = new DestinationDto(destination1)
        DestinationDto destinationDto2 = new DestinationDto(destination1)
        assertEquals( destinationDto1.hashCode(), destinationDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        DestinationDto destinationDto1 = new DestinationDto(destination1)
        DestinationDto destinationDto2 = new DestinationDto(destination2)
        assertNotEquals( destinationDto1.hashCode(), destinationDto2.hashCode())
    }
}
