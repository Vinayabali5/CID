package uk.ac.reigate.services

import static org.mockito.Mockito.*

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.Address
import uk.ac.reigate.dto.AddressDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.AddressRepository

class AddressServiceTest {
    
    @Mock
    private AddressRepository addressRepository
    
    @InjectMocks
    private AddressService addressService
    
    private Address address
    
    @Rule
    public ExpectedException thrown = ExpectedException.none()
    
    /**
     * This method is used to create a sample Address data object to use for the testing
     *
     * @return a sample Address data object
     */
    Address createAddress() {
        return new Address(
                id: 99,
                line1: '99',
                line2: 'Some Street',
                line3: null,
                line4: null,
                line5: null,
                town: 'Some Town',
                county: null,
                postcode: 'RH20SD'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample Address created at setup
     *
     * @return a AddressDto object based on the sample Address
     */
    AddressDto createDto() {
        return new AddressDto(
                id: address.id,
                line1: address.line1,
                line2: address.line2,
                line3: address.line3,
                line4: address.line4,
                line5: address.line5,
                town: address.town,
                county: address.county,
                postcode: address.postcode
                )
    }
    
    /**
     * This method is used to set up the tests for the AddressService
     */
    @Before
    public void setup() {
        this.addressRepository = Mockito.mock(AddressRepository.class)
        this.addressService = new AddressService(addressRepository)
        
        address = createAddress()
        
        when(addressRepository.save(any(Address.class))).thenReturn(address);
        when(addressRepository.findById(address.id)).thenReturn(new Optional(address))
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        AddressService service = new AddressService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Address result = addressService.findById(1)
        verify(addressRepository, times(1)).findById(1)
        verifyNoMoreInteractions(addressRepository)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Address> result = addressService.findAll()
        verify(addressRepository, times(1)).findAll()
        verifyNoMoreInteractions(addressRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Address savedAddress = addressService.save(new Address())
        verify(addressRepository, times(1)).save(any())
        verifyNoMoreInteractions(addressRepository)
    }
    
    /**
     * This method is used to test the saveAll service method
     */
    @Test
    public void testSaveAddresses() {
        List<Address> savedAddresses = addressService.saveAddresses([
            new Address(id: 1),
            new Address(id: 2)
        ])
        verify(addressRepository, times(2)).save(any(Address.class))
        verifyNoMoreInteractions(addressRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        AddressDto dto = createDto()
        Address addressSaved = addressService.createFromDto(dto)
        verify(addressRepository, times(1)).save(any(Address.class))
        verifyNoMoreInteractions(addressRepository)
        assertEquals(dto.id, address.id)
        assertEquals(dto.line1, address.line1)
        assertEquals(dto.line2, address.line2)
        assertEquals(dto.line3, address.line3)
        assertEquals(dto.line4, address.line4)
        assertEquals(dto.line5, address.line5)
        assertEquals(dto.town, address.town)
        assertEquals(dto.county, address.county)
        assertEquals(dto.postcode, address.postcode)
        assertEquals(dto.buildingName, address.buildingName)
        assertEquals(dto.subBuilding, address.subBuilding)
    }
    
    /**
     * This method is used to test the createFromDto service method with null dto
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create address from null object")
        AddressDto dto = null
        addressService.createFromDto(dto)
        verifyNoMoreInteractions(addressRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        AddressDto dto = createDto()
        addressService.updateFromDto(dto)
        verify(addressRepository, times(1)).save(any(Address.class))
        assertEquals(dto.id, address.id)
        assertEquals(dto.line1, address.line1)
        assertEquals(dto.line2, address.line2)
        assertEquals(dto.line3, address.line3)
        assertEquals(dto.line4, address.line4)
        assertEquals(dto.line5, address.line5)
        assertEquals(dto.town, address.town)
        assertEquals(dto.county, address.county)
        assertEquals(dto.postcode, address.postcode)
        assertEquals(dto.buildingName, address.buildingName)
        assertEquals(dto.subBuilding, address.subBuilding)
    }
    
    /**
     * This method is used to test the updateFromDto service method with null dto
     */
    @Test
    public void testupdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update address from null object")
        AddressDto dto = null
        addressService.updateFromDto(dto)
        verifyNoMoreInteractions(addressRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method with null Id
     */
    @Test
    public void testUpdateFromDto_withNullId() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update address when the id is null")
        AddressDto dto = new AddressDto(line1: '123', line2: 'cane hill')
        addressService.updateFromDto(dto)
        verifyNoMoreInteractions(addressRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method.
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        thrown.expectMessage("Addresses should not be deleted.")
        addressService.delete(new Address(id: 1))
    }
}