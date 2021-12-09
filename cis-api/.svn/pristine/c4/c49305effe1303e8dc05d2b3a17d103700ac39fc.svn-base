package uk.ac.reigate.api;

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

import uk.ac.reigate.domain.Contact
import uk.ac.reigate.domain.Note
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.PersonRole
import uk.ac.reigate.dto.ContactDto
import uk.ac.reigate.dto.NoteDto
import uk.ac.reigate.dto.PersonDto
import uk.ac.reigate.dto.PersonRoleDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.services.ContactService
import uk.ac.reigate.services.NoteService
import uk.ac.reigate.services.PersonService

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE

@Controller
@RequestMapping(value = "/people", produces = [ APPLICATION_JSON_VALUE ])
@Api(value = "/people", description = "the people API")
public class PeopleApi implements ICoreDataBaseApi<PersonDto, Integer>{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleApi.class);
    
    @Autowired
    PersonService personService
    
    @Autowired
    ContactService contactService;
    
    @Autowired
    NoteService noteService;
    
    PeopleApi() {}
    
    PeopleApi(PersonService personService){
        this.personService = personService;
    }
    
    /**
     * The peoplePost method is used to create a new instance of a Person from the supplied PersonDto
     * 
     * @param person the PersonDto to use to create the new Person object
     * @return A ResponseEntity with the newly created Person object
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Create a new Person entity", notes = "A POST request to the People end point is used to create a new Person entity in the system. This requires that a Person object is send as the request body.", response = PersonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "The newly created Person object will be returned.")
    ])
    @RequestMapping(value = "", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<PersonDto> create(
            @ApiParam(value = "The body of the request must contain a valid Person object.", required = true)
            @RequestBody PersonDto person) throws NotFoundException {
        LOGGER.info("** PeopleApi - peoplePost");
        if (person.id != null) {
            LOGGER.error("EE - Invalid Data");
            throw new InvalidDataException(400, "No ID field should be provided when creating")
        }
        Person personSaved = personService.createFromDto(person)
        return new ResponseEntity<PersonDto>(PersonDto.mapFromEntity(personSaved), HttpStatus.CREATED);
    }
    
    /**
     * The peoplePersonIdGet method is used to retrieve an instance of a PersonDto object as identified by the personId provided
     *
     * @param personId the person ID for the Person object retrieve
     * @return A ResponseEntity with the corresponding PersonDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Get an instance of a person with the given personId", notes = "This end point is used to retrieve an individual instance of a person as identified by theior personId.", response = PersonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Retrieves an instance of a Person object with the given personId."),
        @ApiResponse(code = 404, message = "Resource not found")
    ])
    @RequestMapping(value = "/{personId}", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<PersonDto> getById(
            @ApiParam(value = "If supplied the Person with the given PersonId will be retrieved", required = true)
            @PathVariable("personId") Integer personId
    ) throws NotFoundException {
        LOGGER.info("** PeopleApi - peoplePersonIdGet");
        Person person = personService.findById(personId);
        if (person == null) {
            LOGGER.error("EE - No data found with id: $personId")
            throw new NotFoundException();
        }
        PersonDto personDto = PersonDto.mapFromEntity(person)
        return new ResponseEntity<PersonDto>((PersonDto)personDto, HttpStatus.OK);
    }
    
    /**
     * The contactsGetByPersonId method is used to retrieve a the list of  ContactDto objects by personId
     *
     * @return A ResponseEntity with the corresponding list of ContactDto objects
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Collection of Contact entities by PersonId", notes = "A GET request to the Contacts endpoint returns an array of all the contacts in the system.", response = PersonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "An array of contacts")
    ])
    @RequestMapping(value = "/{personId}/contacts", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<ContactDto>> getContactsByPersonId(
            @ApiParam(value = "If supplied the Person with the given PersonId will be retrieved", required = true)
            @PathVariable("personId") Integer personId
    ) throws NotFoundException {
        LOGGER.info("** ContactsApi - contactsGetByPersonId()");
        List<Contact> contactList = contactService.searchByPersonId(personId)
        if(contactList.size() != 0) {
            LOGGER.info("** ContactsApi - contactsGetByPersonId:-" + contactList.size());
            List<ContactDto> contactSearchResults = new ArrayList<ContactDto>()
            return new ResponseEntity<List<ContactDto>>(ContactDto.mapFromList(contactService.searchByPersonId(personId)), HttpStatus.OK)
        } else {
            throw new NotFoundException()
        }
    }
    
    /**
     * The peoplePersonIdPut is used to update
     *
     * @param personId the person ID for the Person object to update
     * @param person the new data for the Person object
     * @return the newly updated PersonDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     * @throws InvalidDataException if there is an issue with the data provided in the RequestBody then an InvalidDataException is thrown
     */
    @ApiOperation(value = "Update a Person object with the given personId", notes = "This endpoint is used to update a person entity with the personId.", response = PersonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Successfully updated the Person with personId"),
        @ApiResponse(code = 404, message = "Resource not found")
    ])
    @RequestMapping(value = "/{personId}", produces = ["application/json"], method = RequestMethod.PUT)
    public ResponseEntity<PersonDto> update(
            @ApiParam(value = "If supplied the Person with the given PersonId will be retrieved", required = true)
            @PathVariable("personId") Integer personId,
            @ApiParam(value = "The person details as they are to be saved.", required = true)
            @RequestBody PersonDto person
    ) throws NotFoundException {
        LOGGER.info("** PeopleApi - peoplePUT");
        if (personId != person.id) {
            throw new InvalidDataException()
        }
        Person personSaved = personService.updateFromDto(person)
        return new ResponseEntity<PersonDto>(PersonDto.mapFromEntity(personSaved), HttpStatus.OK);
    }
    
    /**
     * The getNotesByPersonId method is used to retrieve an instance of a NoteDto object of particular personId
     *
     * @param personId the person ID for whom the Note object retrieve
     * @return A ResponseEntity with the corresponding NoteDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Retrieves an instance of a Note identified by the personId", notes = "A GET request to the people instance endpoint will retrieve an instance of a Note entity ", response = NoteDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Returns a copy of the Note as identified by the personId"),
        @ApiResponse(code = 404, message = "Returns an Error object stating that the resource could not be found. This happens if the note is not found in the database.")
    ])
    @RequestMapping(value = "/{personId}/notes", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<NoteDto>> getNotesByPersonId(
            @ApiParam(value = "The person Id of whom the Note to retrieve", required = true)
            @PathVariable("personId") Integer personId)
    throws NotFoundException {
        LOGGER.info("** PeopleApi - NoteIdGet");
        List<Note> notes =  noteService.getNotesByPersonId(personId)
        if(notes.size() == 0){
            throw new NotFoundException()
        }
        return new ResponseEntity<List<NoteDto>>(NoteDto.mapFromList(notes), HttpStatus.OK);
    }
    
    /* The peoplePersonIdGet method is used to retrieve an instance of a PersonDto object as identified by the personId provided
     *
     * @param personId the person ID for the Person object retrieve
     * @return A ResponseEntity with the corresponding PersonDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Get an instance of a person with the given personId", notes = "This end point is used to retrieve an individual instance of a person as identified by theior personId.", response = PersonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Retrieves an instance of a Person object with the given personId."),
        @ApiResponse(code = 404, message = "Resource not found")
    ])
    @RequestMapping(value = "/{personId}/roles", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<PersonDto>>getRolesByPersonId(
            @ApiParam(value = "If supplied the Person with the given PersonId will be retrieved", required = true)
            @PathVariable("personId") Integer personId
    ) throws NotFoundException {
        LOGGER.info("** PeopleApi - peoplePersonIdGet");
        List<Person> people = personService.findByPerson(personId);
        return new ResponseEntity<List<PersonDto>>(PersonDto.mapFromList(people), HttpStatus.OK);
    }
    
    /**
     * This Api endpoint is used to delete the person role from the person role table.
     * @param personId
     * @param roleId
     * @return
     * @throws NotFoundException
     */
    @RequestMapping(value = "/{personId}/roles/{roleId}", produces = ["application/json"], method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (
            @ApiParam(value = "The unique ID of the personId to delete", required = true)
            @PathVariable("personId") Integer personId,
            @ApiParam(value = "The unique ID of the roleId to retrieve", required = true)
            @PathVariable("roleId") Integer roleId
    ) throws NotFoundException {
        LOGGER.info("** PeopleApi- delete role");
        personService.deleteById(personId, roleId);
        LOGGER.info("***PeopleApi:- Deleted !!! ")
        return new ResponseEntity<>(HttpStatus.NO_CONTENT)
    }
    
    /* The peoplePersonIdGet method is used to retrieve an instance of a PersonDto object as identified by the personId provided
     *
     * @param personId the person ID for the Person object retrieve
     * @return A ResponseEntity with the corresponding PersonDto object
     * @throws NotFoundException if nothing is found then the the NotFoundException is thrown.
     */
    @ApiOperation(value = "Get an instance of a person with the given personId", notes = "This end point is used to retrieve an individual instance of a person as identified by theior personId.", response = PersonDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 200, message = "Retrieves an instance of a Person object with the given personId."),
        @ApiResponse(code = 404, message = "Resource not found")
    ])
    @RequestMapping(value = "/{personId}/personRoles", produces = ["application/json"], method = RequestMethod.GET)
    public ResponseEntity<List<PersonRoleDto>>getRolesByPersonRoleId(
            @ApiParam(value = "If supplied the Person with the given PersonId will be retrieved", required = true)
            @PathVariable("personId") Integer personId
    ) throws NotFoundException {
        LOGGER.info("** PeopleApi - peoplePersonIdGet");
        List<PersonRole> people = personService.findByPersonId(personId);
        return new ResponseEntity<List<PersonRoleDto>>(PersonRoleDto.mapFromList(people), HttpStatus.OK);
    }
    
    @ApiOperation(value = "Create a new Person entity", notes = "A POST request to the People end point is used to create a new Person entity in the system. This requires that a Person object is send as the request body.", response = PersonRoleDto.class)
    @ApiResponses(value = [
        @ApiResponse(code = 201, message = "The newly created Person object will be returned.")
    ])
    @RequestMapping(value = "/createRole", produces = ["application/json"], method = RequestMethod.POST)
    public ResponseEntity<PersonRoleDto> createRole(
            @ApiParam(value = "The person details as they are to be saved.", required = true)
            @RequestBody PersonRoleDto person) throws NotFoundException {
        LOGGER.info("** PeopleApi - peoplePost");
        PersonRole personSaved = personService.createPersonRole(person)
        return new ResponseEntity<PersonRoleDto>(PersonRoleDto.mapFromEntity(personSaved), HttpStatus.CREATED);
    }
}
