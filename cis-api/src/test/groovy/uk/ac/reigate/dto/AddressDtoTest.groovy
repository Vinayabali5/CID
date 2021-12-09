package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.Address
import uk.ac.reigate.exceptions.InvalidDataException

public class AddressDtoTest {
    
    private Address address1
    
    private Address address2
    
    private List<Address> addresses
    
    @Before
    public void setup() {
        this.address1 = new Address(
                id: 1,
                line1: '309',
                line2: 'Mercury House',
                line3: 'jude street',
                line4: null,
                line5: null,
                town: 'canning',
                county: null,
                postcode: 'E161FF',
                buildingName: null,
                subBuilding: null
                );
        this.address2 = new Address(
                id: 2,
                line1: '87 Hevers Avenue',
                line2: 'Horley',
                line3: null,
                line4: null,
                line5: null,
                town: 'Horley',
                county: 'Surrey',
                postcode: 'RH6 8BZ',
                buildingName: null,
                subBuilding: null
                );
        this.addresses = Arrays.asList(this.address1, this.address2);
    }
    
    @Test
    void testConstructor_address() {
        AddressDto addressDto = new AddressDto( address1 )
        assertEquals( addressDto.id, address1.id );
        assertEquals( addressDto.line1, address1.line1);
        assertEquals( addressDto.line2, address1.line2);
        assertEquals( addressDto.line3, address1.line3);
        assertEquals( addressDto.line4, address1.line4);
        assertEquals( addressDto.line5, address1.line5);
        assertEquals( addressDto.town, address1.town);
        assertEquals( addressDto.county, address1.county);
        assertEquals( addressDto.postcode, address1.postcode);
        assertEquals( addressDto.buildingName, address1.buildingName);
        assertEquals( addressDto.subBuilding, address1.subBuilding);
    }
    
    @Test
    public void testConstructor_NullAddress() {
        Address address = null
        AddressDto addressDto = new AddressDto(address)
        assertEquals(address, null)
    }
    
    @Test
    public void testMapFromAddressEntity(){
        AddressDto addressDto = AddressDto.mapFromEntity( address1 )
        assertEquals( addressDto.id, address1.id );
        assertEquals( addressDto.line1, address1.line1);
        assertEquals( addressDto.line2, address1.line2);
        assertEquals( addressDto.line3, address1.line3);
        assertEquals( addressDto.line4, address1.line4);
        assertEquals( addressDto.line5, address1.line5);
        assertEquals( addressDto.town, address1.town);
        assertEquals( addressDto.county, address1.county);
        assertEquals( addressDto.postcode, address1.postcode);
        assertEquals( addressDto.buildingName, address1.buildingName);
        assertEquals( addressDto.subBuilding, address1.subBuilding);
    }
    
    @Test
    public void testMapFromAddressesEntities(){
        List<AddressDto> addressesDtoList = AddressDto.mapFromList( this.addresses )
        assertEquals( addressesDtoList[0].id, address1.id );
        assertEquals( addressesDtoList[0].line1, address1.line1 );
        assertEquals( addressesDtoList[0].line2, address1.line2);
        assertEquals( addressesDtoList[0].line3, address1.line3);
        assertEquals( addressesDtoList[0].line4, address1.line4);
        assertEquals( addressesDtoList[0].line5, address1.line5);
        assertEquals( addressesDtoList[0].town, address1.town);
        assertEquals( addressesDtoList[0].county, address1.county);
        assertEquals( addressesDtoList[0].postcode, address1.postcode);
        assertEquals( addressesDtoList[0].buildingName, address1.buildingName);
        assertEquals( addressesDtoList[0].subBuilding, address1.subBuilding);
        assertEquals( addressesDtoList[1].id, address2.id );
        assertEquals( addressesDtoList[1].line1, address2.line1 );
        assertEquals( addressesDtoList[1].line2, address2.line2);
        assertEquals( addressesDtoList[1].line3, address2.line3);
        assertEquals( addressesDtoList[1].line4, address2.line4);
        assertEquals( addressesDtoList[1].line5, address2.line5);
        assertEquals( addressesDtoList[1].town, address2.town);
        assertEquals( addressesDtoList[1].county, address2.county);
        assertEquals( addressesDtoList[1].postcode, address2.postcode);
        assertEquals( addressesDtoList[1].buildingName, address2.buildingName);
        assertEquals( addressesDtoList[1].subBuilding, address2.subBuilding);
    }
    
    @Test
    public void testEquals_Same() {
        AddressDto addressDto1 = new AddressDto(address1)
        AddressDto addressDto2 = new AddressDto(address1)
        assertEquals( addressDto1, addressDto2)
    }
    
    @Test
    public void testEquals_Different() {
        AddressDto addressDto1 = new AddressDto(address1)
        AddressDto addressDto2 = new AddressDto(address2)
        assertNotEquals( addressDto1, addressDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        AddressDto addressDto1 = new AddressDto(address1)
        AddressDto addressDto2 = new AddressDto(address1)
        assertEquals( addressDto1.hashCode(), addressDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        AddressDto addressDto1 = new AddressDto(address1)
        AddressDto addressDto2 = new AddressDto(address2)
        assertNotEquals( addressDto1.hashCode(), addressDto2.hashCode())
    }
    
    @Test
    public void testConstructor_Address() {
        AddressDto addressDto = new AddressDto(address1)
        assertEquals( addressDto.line1, address1.line1 )
        assertEquals( addressDto.line2, address1.line2 )
        assertEquals( addressDto.line3, address1.line3 )
        assertEquals( addressDto.line4, address1.line4 )
        assertEquals( addressDto.line5, address1.line5 )
        assertEquals( addressDto.town, address1.town )
        assertEquals( addressDto.county, address1.county )
        assertEquals( addressDto.postcode, address1.postcode )
    }
}
