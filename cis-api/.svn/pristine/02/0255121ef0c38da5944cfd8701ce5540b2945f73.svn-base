package uk.ac.reigate.services.admissions

import java.text.SimpleDateFormat

import org.hibernate.exception.SQLGrammarException
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.Contact
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.admissions.Request
import uk.ac.reigate.domain.system.Setting
import uk.ac.reigate.dto.admissions.ApplicationFormDto
import uk.ac.reigate.dto.admissions.ApplicationNewFormDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.AddressService
import uk.ac.reigate.services.CollegeFundPaidService
import uk.ac.reigate.services.ContactService
import uk.ac.reigate.services.LLDDHealthProblemCategoryService
import uk.ac.reigate.services.LLDDHealthProblemService
import uk.ac.reigate.services.PersonService
import uk.ac.reigate.services.PostcodeLookupService
import uk.ac.reigate.services.SchoolReportStatusService
import uk.ac.reigate.services.SchoolService
import uk.ac.reigate.services.SpecialCategoryService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.TutorGroupService
import uk.ac.reigate.services.ilr.EthnicityService
import uk.ac.reigate.services.ilr.RestrictedUseIndicatorService
import uk.ac.reigate.services.lookup.GenderService
import uk.ac.reigate.services.lookup.LegalSexService
import uk.ac.reigate.services.lookup.StudentTypeService
import uk.ac.reigate.services.lookup.TitleService
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentYearService

/**
 * This service is used for retrieving, processing and saving ApplicationForm objects
 *
 * @author Michael Horgan, Vinaya Bali
 *
 */

@Service
class ApplicationFormService {
    
    private final static Logger log = LoggerFactory.getLogger(ApplicationFormService.class.getName());
    
    @Autowired
    SettingAdmissionsService settingService
    
    @Autowired
    PostcodeLookupService postcodeLookupService
    
    @Autowired
    SpecialCategoryService specialCategoryService
    
    @Autowired
    StudentService studentService
    
    @Autowired
    PersonService personService
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    ApplicationStatusService applicationStatusService
    
    @Autowired
    OfferTypeService offerTypeService
    
    @Autowired
    GenderService genderService
    
    @Autowired
    LegalSexService legalSexService
    
    @Autowired
    AddressService addressService
    
    @Autowired
    ContactService contactService
    
    @Autowired
    TitleService titleService
    
    @Autowired
    SchoolService schoolService
    
    @Autowired
    InterviewCategoryService interviewCategoryService
    
    @Autowired
    SchoolReportStatusService schoolReportStatusService
    
    @Autowired
    CollegeFundPaidService collegeFundPaidService
    
    @Autowired
    StudentTypeService studentTypeService
    
    @Autowired
    TutorGroupService tutorGroupService
    
    @Autowired
    LLDDHealthProblemService llddHealthProblemService
    
    @Autowired
    EthnicityService ethnicityService
    
    @Autowired
    RestrictedUseIndicatorService restrictedUseIndicatorService
    
    @Autowired
    StaffService staffService
    
    @Autowired
    LLDDHealthProblemCategoryService llddHealthProblemCategoryService
    
    @Autowired
    StudentYearService studentYearService
    
    @InitBinder
    void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        binder.registerCustomEditor(Date.class, "enrolmentInterviewDate", new CustomDateEditor(dateTimeFormat, true));
        binder.registerCustomEditor(Date.class, "interviewDate", new CustomDateEditor(dateTimeFormat, true));
    }
    
    /**
     * This method is used to find the Application by NamePart
     *
     * @return the saved Application object
     */
    public List<Student> findByNamePart(String name) {
        log.info("*** StudentService.findByNamePart")
        try {
            List<Person> people = personService.findByNamePart(name)
            if (people != null && people.isEmpty() == false) {
                log.info("** Return: studentRepository.findByPersonIn(people)")
                return studentService.findByPersonInAndStudentYears_Year(people, academicYearService.getNextAcademicYear())
            } else {
                log.info("** Return: null")
                return null
            }
        } catch (SQLGrammarException sgex) {
            log.error("SQL Grammar Exception Occurred: " + sgex.message)
        } catch (Exception ex) {
            log.error("An Exception Occurred: " + ex.message)
        }
    }
    
    /**
     * This method is used to find the Application by ReferenceNo
     *
     * @return the saved Application object
     */
    public List<Student> findByReferenceNo(String ref) {
        log.info("*** StudentService.findByReferenceNo")
        List<Student> students
        try {
            AcademicYear year = academicYearService.getNextAcademicYear()
            students = studentService.findByReferenceNoContainingIgnoreCaseAndStudentYears_Year(ref, year)
        } catch (SQLGrammarException sgex) {
            log.error("SQL Grammar Exception Occurred: " + sgex.message)
        } catch (Exception ex) {
            log.error("An Exception Occurred: " + ex.message)
        }
        return students
    }
    
    public List<Student> findByStudentId(Integer ref) {
        log.info("*** StudentService.findByReferenceNo")
        List<Student> students = new ArrayList<Student>()
        try {
            AcademicYear year = academicYearService.getNextAcademicYear()
            Student student = studentService.findByStudentIdAndYear(ref, year)
            if (student != null) {
                students.add(student)
                return students
            } else {
                return null
            }
        } catch (SQLGrammarException sgex) {
            log.error("SQL Grammar Exception Occurred: " + sgex.message)
        } catch (Exception ex) {
            log.error("An Exception Occurred: " + ex.message)
        }
        return null
    }
    
    /**
     * This method is used to save a new Application entity to the database using the provided ApplicationDto object
     *
     * @param form the ApplicationDto object to use for the new Application
     * @return the id of the saved Application entity
     */
    @Transactional
    Student create(ApplicationNewFormDto form) {
        log.info("*** ApplicationFormService.saveNew()")
        Student student = new Student()
        if (student != null) {
            log.info("* Setting Student Status.")
            student.status = applicationStatusService.findByDescription("New")
            
            log.info("* Setting Default offer Type.")
            Setting defaultOfferType = settingService.getSetting('DefaultOfferType')
            if (defaultOfferType != null) {
                student.offerType = offerTypeService.findByDescription(defaultOfferType.value)
            } else {
                log.info("WW - No DefaultOfferType in settings, using null or database default.")
            }
            
            log.info("* Setting Reference No.")
            student.referenceNo = form.referenceNo
            student.admissionsNotes = form.admissionsNotes
            //   student.academicYear = form.academicYearId != null ? academicYearService.findById(form.academicYearId) : null
            student.received = form.received
            if (student.submitted == null) {
                student.submitted =  new Date()
            }
            log.info("* Setting person fields.")
            student.person = new Person()
            student.person.title= form.titleId
            student.person.firstName = form.firstName
            student.person.surname = form.surname
            student.person.middleNames = form.middleNames
            student.person.preferredName = form.preferredName
            student.person.previousSurname = form.previousSurname
            student.person.legalSurname = form.legalSurname
            student.person.dob = form.dob
            if(form.legalSexId != null && form.genderId == null) {
                student.person.legalSex = legalSexService.findById(form.legalSexId)
                student.person.gender = genderService.findById(form.legalSexId)
            } else {
                student.person.legalSex = form.legalSexId != null ? legalSexService.findById(form.legalSexId) : null
                student.person.gender = form.genderId != null ? genderService.findById(form.genderId) : null
            }
            student.person.home = form.home
            student.person.mobile = form.mobile
            student.person.email = form.email
            student.countryOfResidence= form.countryOfResidence
            student.resident = form.resident
            
            log.info("* Setting address fields.")
            if (form.address.id != null) {
                Address address = addressService.findById(form.address.id)
                student.person.address = address
            } else {
                student.person.address = addressService.createFromDto(form.address)
            }
            log.info("* Setting other fields.")
            student.resident = form.resident
            student.sibling= form.sibling
            student.siblingName= form.siblingName
            student.siblingYear= form.siblingYear
            student.siblingAdmNo= form.siblingAdmNo
            log.info("* Student Details fields.")
            student.uci = form.uci
            student.uln = form.uln
            log.info("* Setting school.")
            student.school = form.schoolId != null ? schoolService.findById(form.schoolId) : null
            log.info("* Setting contacts.")
            if (form.contacts != null) {
                student.person.contacts = new ArrayList<Contact>()
                for (Contact c : form.contacts) {
                    if (c.id != null) {
                        Contact contact = contactService.findById(c.id)
                        student.person.contacts.add(new Contact(student.person, contact.contact, contact.contactType, contact.contactable, contact.preferred))
                    } else {
                        if (c.contact.surname.length() != 0) {
                            c.person = student.person
                            if (c.contact.title == null) {
                                c.contact.title = titleService.findByDescription('None')
                            }
                            if (c.contact.address == null) {
                                c.contact.address = null
                            }
                            student.person.contacts.add(new Contact(student.person, c.contact, c.contactType, c.contactable, c.preferred))
                        }
                    }
                }
            }
            log.info("* Adding reqests to Application.")
            if (form.requests != null) {
                student.requests = new ArrayList<Request>()
                form.requests.unique { a, b -> a.request <=> b.request }.each { req ->
                    if (req.request.length() != 0) {
                        student.requests.add(new Request(student, req.request))
                    }
                }
            }
            Student studentSaved = studentService.save(student)
            return studentSaved
        }
    }
    
    /**
     * This method is used to update an Application entity to the database using the provided ApplicationDto object
     *
     * @param form the ApplicationDto object to use for the update Application
     * @return the id of the saved Application entity
     */
    @Transactional
    ApplicationFormDto update(ApplicationFormDto applicationEditFormDto) {
        if(applicationEditFormDto.id == null) {
            throw new InvalidDataException()
        }
        Student student = studentService.findById(applicationEditFormDto.id)
        AcademicYear year
        if (applicationEditFormDto.yearId != null) {
            year = academicYearService.findById(applicationEditFormDto.yearId)
        } else {
            year = academicYearService.getCurrentAcademicYear()
        }
        StudentYear studentYear = studentYearService.findByStudent_IdAndYear(applicationEditFormDto.id, year)
        // update StudentYear objects
        studentYear.endDate = applicationEditFormDto.endDate
        if(applicationEditFormDto.studentTypeId != null) {
            studentYear.studentType = studentTypeService.findById(applicationEditFormDto.studentTypeId)
        }
        if(applicationEditFormDto.tutorGroupId != null) {
            studentYear.tutorGroup = tutorGroupService.findById(applicationEditFormDto.tutorGroupId)
        }
        
        // Update Application Details
        if(applicationEditFormDto.statusId != null) {
            student.status = applicationStatusService.findById(applicationEditFormDto.statusId)
        }
        student.received = applicationEditFormDto.received
        
        // Update Person fields
        if(applicationEditFormDto.personId !=  null) {
            student.person.firstName = applicationEditFormDto.firstName
            student.person.surname = applicationEditFormDto.surname
            student.person.middleNames = applicationEditFormDto.middleNames
            student.person.preferredName = applicationEditFormDto.preferredName
            student.person.previousSurname = applicationEditFormDto.previousSurname
            student.person.legalSurname = applicationEditFormDto.legalSurname
            student.person.dob = applicationEditFormDto.dob
            student.person.legalSex = applicationEditFormDto.legalSexId != null ? legalSexService.findById(applicationEditFormDto.legalSexId) : student.person.legalSex
            student.person.gender = applicationEditFormDto.genderId != null ? genderService.findById(applicationEditFormDto.genderId) : null
            student.person.title = applicationEditFormDto.titleId != null ? titleService.findById(applicationEditFormDto.titleId) : null
            student.person.home = applicationEditFormDto.home
            student.person.mobile = applicationEditFormDto.mobile
            student.person.email = applicationEditFormDto.email
        }
        student.countryOfResidence = applicationEditFormDto.countryOfResidence
        student.resident = applicationEditFormDto.resident
        
        // Update Person.Address fields
        student.person.address = applicationEditFormDto.addressId != null ? addressService.updateFromDto(applicationEditFormDto.address) : student.person.address
        
        // Update Sibling Details
        student.sibling = applicationEditFormDto.sibling
        student.siblingName = applicationEditFormDto.siblingName
        student.siblingYear = applicationEditFormDto.siblingYear
        student.siblingAdmNo = applicationEditFormDto.siblingAdmNo
        
        //Update student details
        student.uln = applicationEditFormDto.uln
        student.uci = applicationEditFormDto.uci
        student.offerType = applicationEditFormDto.offerTypeId != null ? offerTypeService.findById(applicationEditFormDto.offerTypeId) : null
        student.offerSent = applicationEditFormDto.offerSent
        
        // Update Previous School Information
        student.school = applicationEditFormDto.schoolId != null ? schoolService.findById(applicationEditFormDto.schoolId) : student.school
        student.schoolReportStatus = applicationEditFormDto.schoolReportStatusId != null ? schoolReportStatusService.findById(applicationEditFormDto.schoolReportStatusId) : null
        student.interviewCategory = applicationEditFormDto.interviewCategoryId != null ? interviewCategoryService.findById(applicationEditFormDto.interviewCategoryId) : null
        
        student.refRequested = applicationEditFormDto.refRequested
        student.refReceived = applicationEditFormDto.refReceived
        student.reportRequested = applicationEditFormDto.reportRequested
        student.reportReceived = applicationEditFormDto.reportReceived
        student.blueCard  = applicationEditFormDto.blueCard
        
        // Update Data sharing fields
        student.restrictedUseIndicator = applicationEditFormDto.restrictedUseIndicatorId != null ? restrictedUseIndicatorService.findById(applicationEditFormDto.restrictedUseIndicatorId) : null
        student.contactByPost = applicationEditFormDto.contactByPost
        student.contactByPhone = applicationEditFormDto.contactByPhone
        student.contactByEmail = applicationEditFormDto.contactByEmail
        student.lrsOptOut = applicationEditFormDto.lrsOptOut
        
        // Update Disability/Medical Information
        student.llddHealthProblem = applicationEditFormDto.llddHealthProblemId != null ? llddHealthProblemService.findById(applicationEditFormDto.llddHealthProblemId) : null
        
        // Update LLDD and Health Problem Category
        student.ehcp = applicationEditFormDto.ehcp
        student.lookedAfterChildOrAdopted = applicationEditFormDto.lookedAfterChildOrAdopted
        student.childrenServicesInvolvedAtSchool = applicationEditFormDto.childrenServicesInvolvedAtSchool
        student.otherSocialSupportIssues = applicationEditFormDto.otherSocialSupportIssues
        student.medicalNote = applicationEditFormDto.medicalNote
        student.specialCategory = applicationEditFormDto.specialCategoryId != null ? specialCategoryService.findById(applicationEditFormDto.specialCategoryId) : null
        
        // Update interviewer fields
        student.interviewer = applicationEditFormDto.interviewerId != null ? staffService.findById(applicationEditFormDto.interviewerId) : null
        student.interviewDate = applicationEditFormDto.interviewDate
        student.noShowAtInterview = applicationEditFormDto.noShowAtInterview
        student.interviewNeedsRescheduling = applicationEditFormDto.interviewNeedsRescheduling
        student.possibleAspire = applicationEditFormDto.possibleAspire
        student.learningSupportOnIntro = applicationEditFormDto.learningSupportOnIntro
        student.schoolReportNotSeen = applicationEditFormDto.schoolReportNotSeen
        // Update Admissions Notes
        student.admissionsNotes = applicationEditFormDto.admissionsNotes
        // Update acceptance field
        student.acceptanceReceived = applicationEditFormDto.acceptanceReceived
        student.ethnicity = applicationEditFormDto.ethnicityId != null ? ethnicityService.findById(applicationEditFormDto.ethnicityId) : null
        
        // Update Introductory Day/Choices Day/Enrolment Interview Details
        student.learningSupportOnIntro = applicationEditFormDto.learningSupportOnIntro
        student.learningSupportNeeds = applicationEditFormDto.learningSupportNeeds
        student.cannotAttendIntro = applicationEditFormDto.cannotAttendIntro
        student.cannotAttendInduction = applicationEditFormDto.cannotAttendInduction
        student.inductionDate = applicationEditFormDto.inductionDate
        student.enrolmentInterviewDate = applicationEditFormDto.enrolmentInterviewDate
        
        // Update College Fund Entry
        student.collegeFundPaid = applicationEditFormDto.collegeFundPaidId != null ? collegeFundPaidService.findById(applicationEditFormDto.collegeFundPaidId) : null
        student.collegeFundPaidYears = applicationEditFormDto.collegeFundPaidYears
        student.freeMealsWhileAtSchool = applicationEditFormDto.freeMealsWhileAtSchool
        student.parentsUniversityEducated = applicationEditFormDto.parentsUniversityEducated
        
        //update interview information
        student.careerAims = applicationEditFormDto.careerAims
        student.workVoluntaryExperience = applicationEditFormDto.workVoluntaryExperience
        student.hobbiesInterestsOtherAchievements = applicationEditFormDto.hobbiesInterestsOtherAchievements
        student.favoriteSubject = applicationEditFormDto.favoriteSubject
        student.courseworkOrExams = applicationEditFormDto.courseworkOrExams
        student.reasonsForReigateCollege = applicationEditFormDto.reasonsForReigateCollege
        student.interviewBy = applicationEditFormDto.interviewBy
        student.otherSchoolCollegeAppliedFor = applicationEditFormDto.otherSchoolCollegeAppliedFor
        student.learningSupportNeedsDetails = applicationEditFormDto.learningSupportNeedsDetails
        log.info("*** Return Student id")
        
        StudentYear studentYearSaved = studentYearService.save(studentYear)
        Student studentSaved = studentService.save(student)
        
        return new ApplicationFormDto(studentSaved, studentYearSaved)
        
    }
    
}
