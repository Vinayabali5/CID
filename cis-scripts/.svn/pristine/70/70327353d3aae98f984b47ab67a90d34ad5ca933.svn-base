package uk.ac.reigate.services.schoolimport

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.Contact
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.School
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.ContactType
import uk.ac.reigate.domain.lookup.Title
import uk.ac.reigate.model.Parent
import uk.ac.reigate.repositories.SchoolRepository
import uk.ac.reigate.repositories.academic.AcademicYearRepository
import uk.ac.reigate.repositories.admissions.ApplicationStatusRepository
import uk.ac.reigate.repositories.admissions.OfferTypeRepository
import uk.ac.reigate.repositories.lookup.ContactTypeRepository
import uk.ac.reigate.repositories.lookup.GenderRepository
import uk.ac.reigate.repositories.lookup.NationalityRepository
import uk.ac.reigate.repositories.lookup.TitleRepository
import uk.ac.reigate.scripts.utils.ParentUtils

@Service
class SchoolImportService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchoolImportService.class);

	@Autowired
	StudentService studentService

	@Autowired
	ApplicationStatusRepository applicationStatusRepository

	@Autowired 
	OfferTypeRepository offerTypeRepository
	
	@Autowired
	GenderRepository genderRepository

	@Autowired
	AcademicYearRepository academicYearRepository

	@Autowired
	NationalityRepository nationalityRepository

	@Autowired
	SchoolRepository schoolRepository

	@Autowired
	TitleRepository titleRepository

	@Autowired
	ContactTypeRepository contactTypeRepository

	Contact parentToContact(Parent parent, Person person) throws IllegalArgumentException {
		if (parent != null) {
			Contact c = new Contact()
			Person p = new Person()
			ContactType ct

			p.surname = parent.surname != null ? parent.surname : ''
			p.firstName = parent.firstName != null? parent.firstName : ''
			if (parent.title != null) {
				Title t = titleRepository.findByDescription(parent.title)
				if (t != null) {
					p.title = t
					switch (t.description) {
						case 'Mr':
						case 'Dr':
						case 'Rev':
						case 'Sir':
						case 'Lord':
						case 'Prof':
						case 'Capt':
							ct = contactTypeRepository.findByName('Father')
							break;
						default:
							ct = contactTypeRepository.findByName('Mother')
							break;
					}
				}
			}

			c.person = person
			c.contact = p
			c.contactType = ct

			return c
		} else {
			throw new IllegalArgumentException("Parent object supplied is null or not valid.")
		}
	}

	void addApplication(Date received, String firstName, String surname, String middleNames, String preferredName, String uln, String uci, Date dob, String gender, String parentAddressee, String home, String[] addressLines, String postcode, String schoolName) {
		School school = schoolRepository.findByName(schoolName)

		def lines = addressLines.size()
		// TODO: added town and county extraction options

		Address add = new Address()
		add.line1 = lines >= 1 ? addressLines[0] : null
		add.line2 = lines >= 2 ? addressLines[1] : null
		add.line3 = lines >= 3 ? addressLines[2] : null
		add.line4 = lines >= 4 ? addressLines[3] : null
		add.line5 = lines >= 5 ? addressLines[4] : null
		add.postcode = postcode

		if (gender.length() > 1) {
			gender = gender.charAt(0)
		}

		Person p = new Person()
		p.firstName = firstName
		p.surname = surname
		p.middleNames = middleNames
		p.preferredName = firstName != preferredName ? preferredName : null
		p.dob = dob
		p.home = home
		p.gender = genderRepository.findByCode(gender)
		p.address = add

		List<Parent> parents = ParentUtils.parentAddresseeToParentList(parentAddressee)
		if (parents.size() != 0) {
			p.contacts = new ArrayList<Contact>()
			parents.each {
				try {
					Contact con = parentToContact(it, p)
					con.contact.home = home
					p.contacts.add(con)
				} catch(IllegalArgumentException iae) {
					LOGGER.error("EE Invalid Parent - ParentAddressee:  " + parentAddressee + " results in Parent: " + it.toString() )
				}  
			}

		}

		AcademicYear year = academicYearRepository.findNext()

		Student student = new Student()
		student.academicYear = year
		student.received = received
		student.person = p
		student.uln = uln
		student.uci = uci
		student.school = school
		student.resident = true
		student.sibling = false
		student.siblingName = ''
		student.status = applicationStatusRepository.findByDescription('New')
		student.nationality = nationalityRepository.findByDescription('UK')
		student.offerType = offerTypeRepository.findByDescription('Normal')
		student.countryOfResidence = 'UK'

		// Save application
		Student savedStudent = studentService.saveStudent(student)
		
		LOGGER.info("II Student Saved: " + savedStudent.person.surname + ", " + savedStudent.person.firstName + " " + (savedStudent.person.middleNames != null ? savedStudent.person.middleNames : ''))
	}
}
