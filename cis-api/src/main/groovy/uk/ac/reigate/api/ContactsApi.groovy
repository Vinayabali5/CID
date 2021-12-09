package uk.ac.reigate.api;

import javax.validation.Valid

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import uk.ac.reigate.domain.Contact
import uk.ac.reigate.dto.ContactDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.ContactService
import uk.ac.reigate.services.PersonService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE


@Controller
@RequestMapping(value = "/contacts", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/contacts", description = "the contacts API")
public class ContactsApi implements ICoreDataApi<ContactDto, Integer> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactsApi.class);
    
    @Autowired
    private final ContactService contactService;
    
    @Autowired
    private final PersonService personService;
    
    /**
     * Default NoArgs constructor
     */
    ContactsApi() {}
    
    /**
     * Autowired constructor
     */
    ContactsApi(ContactService contactService) {
        this.contactService = contactService;
    }
    
    /**
     * The contactsGet method is used to retrieve a full list of all the ContactDto objects
     *
     * @return A ResponseEntity with the corresponding list of ContactDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Contact entities", notes = "A GET request to the Contacts endpoint returns an array of all the contacts in the system.", response = ContactDto.class, responseContainer = "List")
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of contacts")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ContactDto>> getAll() throws NotFoundException {
        LOGGER.info("** ContactsApi - contactsGet");
        List<Contact> contacts = contactService.findAll();
        return new ResponseEntity<List<ContactDto>>(ContactDto.mapFromList(contacts), HttpStatus.OK);
    }
    
    /**
     * The contactsGet method is used to retrieve a the list of  ContactDto objects by personId
     *
     * @return A ResponseEntity with the corresponding list of ContactDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Contact entities by PersonId", notes = "A GET request to the Contacts endpoint returns an array of all the contacts in the system.", response = ContactDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of contacts")
    ])
    @RequestMapping(value = "/search", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ContactDto>> contactsGetByPersonId(
            @RequestParam(value = "personId", required = false) Integer personId
    ) throws NotFoundException {
        LOGGER.info("** ContactsApi - contactsGetByPersonId()");
        List<Contact> contactList = contactService.searchByPersonId(personId)
        
        if(contactList.size() != 0) {
            LOGGER.info("** ContactsApi - contactsGetByPersonId:-" + contactList.size());
            List<ContactDto> contactSearchResults = new ArrayList<ContactDto>()
            return new ResponseEntity<List<ContactDto>>(ContactDto.mapFromList(contactService.searchByPersonId(personId)), HttpStatus.OK)
        }
    }
    
    /**
     * The contactsPost method is used to create a new instance of a Contact from the supplied ContactDto
     *
     * @param contact the ContactDto to use to create the new Contact object
     * @return A ResponseEntity with the newly created Contact object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Creates a new Contact entity", notes = "A POST request to the Contacts endpoint with a Contact object in the request body will create a new Contact entity in the database.", response = ContactDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "Returns a copy of the created Contact entity including the contactId that has just been created."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<ContactDto> create(
            @ApiParam(value = "The Contact object to be created, without the contactId fields", required = true)
            @RequestBody @Valid ContactDto contactDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** ContactsApi - contactsPOST");
        if (contactDto.id != null) {
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        Contact contactSaved = contactService.createFromDto(contactDto)
        return new ResponseEntity<ContactDto>(ContactDto.mapFromEntity(contactSaved), HttpStatus.CREATED);
    }
    
    /**
     * The contactsContactIdGet method is used to retrieve an instance of a ContactDto object as identified by the contactId provided
     *
     * @param contactId the contact ID for the Contact object retrieve
     * @return A ResponseEntity with the corresponding ContactDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an indivdual instance of a Contact identified by the contactId", notes = "A getGET request to the Contact instance endpoint will retrieve an instance of a Contact entity as identified by the contactId provided in the URI.", response = ContactDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Contact as identified by the contactId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{contactId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<ContactDto> getById(
            @ApiParam(value = "The unique ID of the Contact to retrieve", required = true)
            @PathVariable("contactId") Integer contactId
    ) throws NotFoundException {
        LOGGER.info("** ContactsApi - contactsContactIdGet");
        Contact contact = contactService.findById(contactId);
        if (contact == null) {
            throw new NotFoundException();
        }
        return new ResponseEntity<ContactDto>(ContactDto.mapFromEntity(contact), HttpStatus.OK);
    }
    
    /**
     * The contactsGetPersonById method is used to retrieve a the list of  ContactDto objects by personId
     *
     * @param personId the person ID for the Contact object retrieve
     * @return A ResponseEntity with the corresponding list of ContactDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Contact entities by PersonId", notes = "A GET request to the Contacts endpoint returns an array of all the contacts in the system.", response = ContactDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of contacts")
    ])
    @RequestMapping(value = "/{personId}/contacts", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ContactDto>> getByPersonId(
            @ApiParam(value = "If supplied the Person with the given PersonId will be retrieved", required = true)
            @PathVariable("personId") Integer personId
    ) throws NotFoundException {
        LOGGER.info("** ContactsApi - contactsGetByPersonId()");
        List<Contact> contactList = contactService.searchByPersonId(personId)
        if(contactList.size() != 0) {
            LOGGER.info("** ContactsApi - contactsGetByPersonId:-" + contactList.size());
            List<ContactDto> contactSearchResults = new ArrayList<ContactDto>()
            return new ResponseEntity<List<ContactDto>>(ContactDto.mapFromList(contactService.searchByPersonId(personId)), HttpStatus.OK)
        }
    }
    
    /**
     * The contactsContactIdPut is used to update
     *
     * @param contactId the contact ID for the Contact object to update
     * @param contact the new data for the Contact object
     * @return the newly updated ContactDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Used to update a Contact entity", notes = "A PUT request to the Contact instance endpoint with a Contact object in the request body will update an existing Contact entity in the database.", response = ContactDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the newly updated Contact object."),
        @ApiResponse(code = 400, message = "Returns an Error object stating the request body does not match the expected input."),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the specified id cannot be found in the database.")
    ])
    @RequestMapping(value = "/{contactId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<ContactDto> update(
            @ApiParam(value = "The unique ID of the Contact to retrieve", required = true)
            @PathVariable("contactId") Integer contactId,
            @ApiParam(value = "The Contact object to be created, without the contactId fields", required = true)
            @RequestBody ContactDto contactDto
    ) throws NotFoundException, InvalidDataException {
        LOGGER.info("** ContactsApi - contactPUT");
        if (contactId != contactDto.id) {
            throw new InvalidDataException()
        }
        Contact contactSaved = contactService.updateFromDto(contactDto)
        return new ResponseEntity<ContactDto>(ContactDto.mapFromEntity(contactSaved), HttpStatus.OK);
    }
    
    /**
     * The delete is used to delete the ContactById
     *
     */
    @RequestMapping(value = "/{contactId}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (
            @ApiParam(value = "The unique ID of the Contact personID to retrieve", required = true)
            @PathVariable("contactId") Integer contactId
    ) throws NotFoundException {
        LOGGER.info("** ContactsApi - delete ID: " + contactId);
        contactService.delete(contactId)
        return new ResponseEntity<?>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * The deleteAddress is used to set the addressId field to null
     * 
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @RequestMapping(value = "/{contactId}/address", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<?> deleteAddress (
            @ApiParam(value = "The unique ID of the Contact personID to retrieve", required = true)
            @PathVariable("contactId") Integer contactId,
            @ApiParam(value = "The Contact object to be created, without the contactId fields", required = false)
            @RequestBody ContactDto contactDto
    ) throws NotFoundException {
        LOGGER.info("** ContactsApi - delete ID: " + contactId);
        Contact contact = contactService.findById(contactDto.id);
        if (contact != null) {
            contact.contact.address =  null
            Contact contactSaved = contactService.save(contact)
            return new ResponseEntity<ContactDto>(ContactDto.mapFromEntity(contactSaved), HttpStatus.OK);
        }else {
            throw new NotFoundException();
        }
    }
}