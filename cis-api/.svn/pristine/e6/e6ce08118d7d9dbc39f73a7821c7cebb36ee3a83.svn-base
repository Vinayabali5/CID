package uk.ac.reigate.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.PersonRole
import uk.ac.reigate.domain.PersonRolePk
import uk.ac.reigate.dto.PersonDto
import uk.ac.reigate.dto.PersonRoleDto
import uk.ac.reigate.dto.PersonSummaryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.model.SearchResult
import uk.ac.reigate.repositories.PersonRepository
import uk.ac.reigate.repositories.PersonRoleRepository
import uk.ac.reigate.services.lookup.GenderService
import uk.ac.reigate.services.lookup.LegalSexService
import uk.ac.reigate.services.lookup.TitleService

@Service
class PersonService implements ICoreDataService<Person, Integer>, IDtoCreateUpdateService<PersonDto, Person> {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(PersonService.class.getName());
    
    @Autowired
    PersonRepository personRepository
    
    @Autowired
    PersonRoleRepository personRoleRepository
    
    @Autowired
    TitleService titleService
    
    @Autowired
    GenderService genderService
    
    @Autowired
    LegalSexService legalSexService
    
    @Autowired
    AddressService addressService
    
    @Autowired
    ContactService contactService;
    
    @Autowired
    RoleService roleService;
    
    
    /**
     * Default NoArgs constructor
     */
    PersonService() {}
    
    /**
     * Default autowired constructor
     * 
     * @param personRepository 
     */
    PersonService(PersonRepository personRepository, TitleService titleService, GenderService genderService, LegalSexService legalSexService, AddressService addressService, ContactService contactService, RoleService roleService) {
        super();
        this.personRepository = personRepository
        this.titleService = titleService;
        this.genderService = genderService;
        this.legalSexService = legalSexService;
        this.addressService = addressService;
        this.contactService = contactService;
        this.roleService = roleService;
    }
    
    /**
     * Find an individual person using the people ID fields
     *
     * @param id the ID fields to search for
     * @return the Person object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Person findById(Integer id) {
        return personRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all people
     *
     * @return a SearchResult set with the list of People
     */
    @Override
    @Transactional(readOnly = true)
    List<Person> findAll() {
        return personRepository.findAll();
    }
    
    List<Person> findByPerson(Integer id) {
        List<Person> people = personRepository.findByPerson(id)
        return people
    }
    
    /**
     * This service method is used to retrieve a page of Person from the database.
     *
     * @param page The page information to be used for retrieval
     * @return A SearchResult object with the desired Person objects.
     */
    @Transactional(readOnly = true)
    SearchResult<Person> findPersonByPage(Pageable page) {
        Page<Person> results = personRepository.findAll(page);
        return results
    }
    
    /**
     * This service method is used to save a complete Person object in the database
     *
     * @param person the new Person object to be saved
     * @return the saved version of the Person object
     */
    @Override
    @Transactional
    public Person save(Person person) {
        return personRepository.save(person)
    }
    
    /**
     * @param username
     * @return Person by username
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    Person findByUsername(String username) {
        return personRepository.findByUsername(username)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Person should not be deleted.
     */
    @Override
    @Transactional
    public void delete(Person obj) {
        throw new InvalidOperationException("Person should not be deleted")
    }
    
    
    public void deleteById(Integer personId, Integer roleId){
        personRoleRepository.deleteById(new PersonRolePk(personId, roleId));
    }
    
    List<PersonRole> findByPersonId(Integer personId){
        return personRoleRepository.findByPerson_Id(personId)
    }
    
    /**
     * The findByNamePart method is used to find a list of Person objects with part of their name containing the search parameter.
     *
     * @param name the search parameter to look for
     * @return a List<Person> or null if no records found
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    List<Person> findByNamePart(String name) {
        LOGGER.info("*** PersonService.findByNamePart")
        List<Person> people = new ArrayList<Person>()
        
        people.addAll(personRepository.findBySurnameContainingIgnoreCase(name))
        people.addAll(personRepository.findByFirstNameContainingIgnoreCase(name))
        people.addAll(personRepository.findByPreferredNameContainingIgnoreCase(name))
        people.addAll(personRepository.findByMiddleNamesContainingIgnoreCase(name))
        people.addAll(personRepository.findByPreviousSurnameContainingIgnoreCase(name))
        
        if (people.size() != 0) {
            LOGGER.info("* " + people.size() + " records found")
            LOGGER.info("** Return: List<Person>")
        } else {
            LOGGER.info("* No records found")
            LOGGER.info("** Return: null")
        }
        return people
    }
    
    @Override
    public Person createFromDto(PersonDto personDto) {
        if(personDto ==  null) {
            throw new InvalidDataException("Cannot create Person from null object.")
        }
        Person person = new Person()
        person.firstName = personDto.firstName
        person.preferredName = personDto.preferredName
        person.surname = personDto.surname
        person.legalSurname = personDto.legalSurname
        person.preferredName = personDto.preferredName
        person.middleNames = personDto.middleNames
        person.previousSurname = personDto.previousSurname
        person.dob = personDto.dob
        person.home = personDto.home
        person.mobile = personDto.mobile
        person.work = personDto.work
        person.email = personDto.email
        person.title = personDto.titleId != null ? titleService.findById(personDto.titleId) : null
        person.gender = personDto.genderId != null ? genderService.findById(personDto.genderId) : null
        person.legalSex = personDto.legalSexId != null ? legalSexService.findById(personDto.legalSexId) : null
        if(personDto.addressId != null){
            person.address = addressService.findById(personDto.addressId)
        }
        return save(person)
    }
    
    /**
     * This method is to update the personDto
     *
     */
    @Override
    public Person updateFromDto(PersonDto personDto) {
        if(personDto == null) {
            throw new InvalidDataException("Cannot update Person from null object.")
        }
        Person person = findById(personDto.id)
        person.firstName = personDto.firstName
        person.preferredName = personDto.preferredName
        person.surname = personDto.surname
        person.legalSurname = personDto.legalSurname
        person.preferredName = personDto.preferredName
        person.middleNames = personDto.middleNames
        person.previousSurname = personDto.previousSurname
        person.dob = personDto.dob
        person.home = personDto.home
        person.mobile = personDto.mobile
        person.work = personDto.work
        person.email = personDto.email
        person.rfidCardId = personDto.rfidCardId;
        person.title = personDto.titleId != null ? titleService.findById(personDto.titleId) : null
        person.gender = personDto.genderId != null ? genderService.findById(personDto.genderId) : null
        person.legalSex = personDto.legalSexId != null ? legalSexService.findById(personDto.legalSexId) : null
        if(personDto.addressId != null){
            person.address = addressService.findById(personDto.addressId)
        } else {
            person.address = addressService.createFromDto(personDto.address)
        }
        return save(person)
    }
    
    public Person updateRfidCard(PersonSummaryDto personDto) {
        if(personDto == null) {
            throw new InvalidDataException("Cannot update Id from null object.")
        }
        Person person = findById(personDto.id)
        person.rfidCardId = personDto.rfidCardId;
        return save(person)
    }
    
    /**
     * This method is to create the personRole by PersonDto.
     * 
     * @return saved person
     *
     */
    public PersonRole createPersonRole(PersonRoleDto dto) {
        if (dto == null) {
            throw new InvalidDataException("Cannot create Person Role from null object.")
        }
        PersonRole person = new PersonRole();
        person.person = dto.personId != null ? findById(dto.personId) : null
        person.role = dto.roleId != null ? roleService.findById(dto.roleId) : null
        return save(person)
    }
    
    public PersonRole save(PersonRole person) {
        return personRoleRepository.save(person)
    }
}
