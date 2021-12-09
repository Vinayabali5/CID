package uk.ac.reigate.services.integration

import java.time.ZoneId

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.Contact
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.admissions.Request
import uk.ac.reigate.domain.lookup.Nationality
import uk.ac.reigate.dto.IAddressDTO
import uk.ac.reigate.dto.integration.ApplicationImportDTO
import uk.ac.reigate.dto.integration.ContactImportDTO
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.LLDDHealthProblemCategoryService
import uk.ac.reigate.services.LLDDHealthProblemService
import uk.ac.reigate.services.NationalityService
import uk.ac.reigate.services.RequestService
import uk.ac.reigate.services.SchoolService
import uk.ac.reigate.services.SettingService
import uk.ac.reigate.services.admissions.ApplicationStatusService
import uk.ac.reigate.services.admissions.OfferTypeService
import uk.ac.reigate.services.ilr.EthnicityService
import uk.ac.reigate.services.lookup.ContactTypeService
import uk.ac.reigate.services.lookup.GenderService
import uk.ac.reigate.services.lookup.LegalSexService
import uk.ac.reigate.services.lookup.TitleService
import uk.ac.reigate.services.student.StudentService

@Service
class ApplicationImportService {
    
    private final static Logger LOGGER = LoggerFactory.getLogger("Application Import Service");
    
    private final String DEFAULT_COUNTRY_OF_RESIDENCE = 'UK'
    
    @Autowired
    SettingService settingService
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    ContactTypeService contactTypeService
    
    @Autowired
    TitleService titleService
    
    @Autowired
    LegalSexService legalSexService
    
    @Autowired
    GenderService genderService
    
    @Autowired
    SchoolService schoolService
    
    @Autowired
    EthnicityService ethnicityService
    
    @Autowired
    NationalityService nationalityService
    
    @Autowired
    RequestService requestService
    
    @Autowired
    StudentService studentService
    
    @Autowired
    ApplicationStatusService applicationStatusService
    
    @Autowired
    OfferTypeService offerTypeService
    
    @Autowired
    LLDDHealthProblemService llddHealthProblemService
    
    @Autowired
    LLDDHealthProblemCategoryService llddHealthProblemCategoryService
    
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasRole('Service User')")
    public Student processImport(ApplicationImportDTO app) {
        Student student = createStudent(app)
        Student savedStudent = studentService.save(student)
        
        LOGGER.info("Create new student with ID: $student.id")
        return savedStudent
    }
    
    private createStudent(ApplicationImportDTO app) {
        String defaultOfferType = settingService.getSetting('DefaultOfferType').value
        
        Student student = new Student()
        student.status = applicationStatusService.findByDescription("Imported")
        student.offerType = offerTypeService.findByDescription(defaultOfferType)
        student.academicYear = academicYearService.getNextAcademicYear()
        student.received = new Date()
        student.submitted = new Date()
        
        student.person = createPerson(app)
        
        Nationality nationality = nationalityService.findByDescription(app.nationality)
        if (nationality != null) {
            student.nationality = nationality
        } else {
            String nat = app.nationality.toLowerCase()
            if (nat.matches("british") || nat.matches("english") || nat.matches("england") || nat.matches("uk")) {
                student.nationality = nationalityService.findByDescription("UK")
            }
        }
        
        student.resident = app.resident
        student.countryOfResidence = app.countryOfResidence != null ? app.countryOfResidence : DEFAULT_COUNTRY_OF_RESIDENCE
        
        if (app.schoolUrn != null) {
            student.school = schoolService.findByUrn(app.schoolUrn)
        }
        
        student.ehcp = app.ehcp
        
        student.ethnicity = app.ethnicityCode != null ? ethnicityService.findByCode(app.ethnicityCode) : null
        
        student.requests = app.requestCodes.collect {
            Request request = new Request()
            request.academicYear = academicYearService.getNextAcademicYear()
            request.student = student
            request.request = 'F-' + it
            return requestService.save(request)
        }
        
        if (app.hasLLDD != null) {
            student.llddHealthProblem = llddHealthProblemService.findByShortDescription(app.hasLLDD)
            if (student.llddHealthProblem == null) {
                student.llddHealthProblem = llddHealthProblemService.findByShortDescription("Unknown")
            }
        }
        
        student.llddHealthProblemCategory = app.lldds.collect {
            llddHealthProblemCategoryService.findByCode(it.code)
        }
        
        return student
    }
    
    private Person createPerson(ApplicationImportDTO app) {
        Person person = new Person()
        person.firstName = app.firstName
        person.surname = app.surname
        person.legalSurname = app.surname
        person.middleNames = app.middleNames
        person.dob = Date.from(app.dob.atStartOfDay(ZoneId.systemDefault()).toInstant())
        person.legalSex = app.genderCode != null ? legalSexService.findByCode(app.genderCode) : null
        person.contacts = app.contacts.collect { it ->
            if (it != null) {
                createContact(it, person)
            }
        }
        person.home = app.home
        person.mobile = app.mobile
        person.email = app.email
        person.address = createAddress(app)
        return person
    }
    
    private Address createAddress(IAddressDTO source) {
        if (source == null) {
            return null
        }
        Address address = new Address()
        address.line1 = source.line1 != null ? source.line1 : null
        address.line2 = source.line2 != null ? source.line2 : null
        address.line3 = source.line3 != null ? source.line3 : null
        address.line4 = source.line4 != null ? source.line4 : null
        address.line5 = source.line5 != null ? source.line5 : null
        address.postcode = source.postcode != null ? source.postcode : null
        address.town = source.town != null ? source.town : null
        address.county = source.county != null ? source.county : null
        return address
    }
    
    private Contact createContact(ContactImportDTO source, Person person) {
        if (source == null) {
            return null
        }
        Contact contact = new Contact()
        contact.person = person
        contact.contactType = source.contactType != null ? contactTypeService.findByDescription(source.contactType) : null
        contact.contact = createContactPerson(source)
        contact.contactable = source.contactable
        contact.preferred = source.preferred
        return contact
    }
    
    private createContactPerson(ContactImportDTO source) {
        Person person = new Person()
        person.title = source.title != null ? titleService.findByDescription(source.title) : null
        person.firstName = source.firstName
        person.surname = source.surname
        person.home = source.home
        person.mobile = source.mobile
        person.email = source.email
        if (source._alternativeAddress && source.address != null) {
            person.address = createAddress(source.address)
        }
        return person
    }
}
