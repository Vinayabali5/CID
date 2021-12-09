package uk.ac.reigate.domain

import org.junit.Test

import static org.junit.Assert.*


public class AddressTest {
    
    
    @Test
    void testConstructor_AllFieldsWithoutId() {
        String line1 = 'T'
        String line2 = 'TEST'
        String line3 = 'yellow'
        String line4 = 'red'
        String line5 = 'London'
        String town = 'canning town'
        String county = 'surrey'
        String postcode = 'e131dd'
        String buildingName ='jupiter house'
        String subBuilding = 'mercury'
        Address address = new Address(line1, line2, line3, line4, line5, town, county, postcode, buildingName, subBuilding)
        
        assertNotNull(address)
        assertEquals(address.line1, line1)
        assertEquals(address.line2, line2)
        assertEquals(address.line3, line3)
        assertEquals(address.line4, line4)
        assertEquals(address.line5, line5)
        assertEquals(address.town, town)
        assertEquals(address.county, county)
        assertEquals(address.postcode, postcode)
        assertEquals(address.buildingName, buildingName)
        assertEquals(address.subBuilding, subBuilding)
    }
    
    @Test
    void testConstructor_AllFieldsWithId() {
        Integer id = 1
        String line1 = 'T'
        String line2 = 'TEST'
        String line3 = 'yellow'
        String line4 = 'red'
        String line5 = 'London'
        String town = 'canning town'
        String county = 'surrey'
        String postcode = 'e131dd'
        String buildingName ='jupiter house'
        String subBuilding = 'mercury'
        
        Address address = new Address(id, line1, line2, line3, line4, line5, town, county, postcode, buildingName, subBuilding)
        
        assertNotNull(address)
        assertEquals(address.id, id)
        assertEquals(address.line1, line1)
        assertEquals(address.line2, line2)
        assertEquals(address.line3, line3)
        assertEquals(address.line4, line4)
        assertEquals(address.line5, line5)
        assertEquals(address.town, town)
        assertEquals(address.county, county)
        assertEquals(address.postcode, postcode)
        assertEquals(address.buildingName, buildingName)
        assertEquals(address.subBuilding, subBuilding)
    }
}
