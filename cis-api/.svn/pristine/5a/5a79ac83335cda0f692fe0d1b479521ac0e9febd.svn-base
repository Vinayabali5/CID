package uk.ac.reigate.dto.admissions;

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.School
import uk.ac.reigate.domain.academic.SpecialCategory
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.admissions.ApplicationStatus
import uk.ac.reigate.domain.admissions.CollegeFundPaid
import uk.ac.reigate.domain.admissions.InterviewCategory
import uk.ac.reigate.domain.admissions.OfferType
import uk.ac.reigate.domain.ilr.LLDDHealthProblem
import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory
import uk.ac.reigate.domain.ilr.RestrictedUseIndicator
import uk.ac.reigate.domain.lookup.Ethnicity
import uk.ac.reigate.domain.lookup.Gender
import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.domain.lookup.SchoolReportStatus
import uk.ac.reigate.domain.lookup.StudentType
import uk.ac.reigate.domain.lookup.Title
import uk.ac.reigate.domain.lookup.TutorGroup

import static org.junit.Assert.*

public class ApplicationFormDtoTest {
    
    private Student student1
    
    private StudentYear studentYear1
    
    private Student student2
    
    private Student student3
    
    private StudentYear studentYear2
    
    private List<Student> students
    
    private Address address
    
    private Person person1
    
    private Person person2
    
    @Before
    public void setup() {
        this.address = new Address(1, 'Flat D', 'Stag', 'Stanley', 'west', 'park', 'Wallington', '', 'E161FF', '', '')
        this.person1 = new Person(
                id: 1,
                title: new Title(id:1),
                firstName: 'John',
                preferredName: 'Jon',
                surname: 'Smith',
                legalSurname: 'Smiths',
                middleNames: 'Anon',
                previousSurname: 'Jones',
                dob: new SimpleDateFormat("yyyy/MM/dd").parse('1991/01/31'),
                gender: new Gender(id:1),
                legalSex: new LegalSex(id:1),
                address : address,
                home: '0123456789',
                mobile: '0123456789',
                work: '0123456789',
                email: 'john.smith@gmail.com',
                enabled: true,
                roles: null,
                username: 'vbm')
        this.person2 = new Person(
                id: 1,
                title: null,
                firstName: 'John',
                preferredName: 'Jon',
                surname: 'Smith',
                legalSurname: 'Smiths',
                middleNames: 'Anon',
                previousSurname: 'Jones',
                dob: null,
                gender: null,
                legalSex: null,
                address : address,
                home: '0123456789',
                mobile: '0123456789',
                work: '0123456789',
                email: 'john.smith@gmail.com',
                enabled: true,
                roles: null,
                username: 'vbm')
        student1 = new Student(
                id: 1,
                person: person1,
                admissionsNotes: 'test',
                sibling : 'shirisha',
                siblingYear : 2020,
                siblingAdmNo : '22292',
                received : new SimpleDateFormat("yyyy/MM/dd").parse('1991/01/31'),
                school : new School(id:1),
                schoolReportStatus : new SchoolReportStatus(id:1),
                collegeFundPaid : new CollegeFundPaid(id:1 ),
                specialCategory : new SpecialCategory(id:1 ),
                restrictedUseIndicator : new RestrictedUseIndicator(id:1),
                llddHealthProblem : new LLDDHealthProblem(id:1),
                llddHealthProblemCategory : new LLDDHealthProblemCategory[1],
                ethnicity : new Ethnicity(id:1),
                interviewer : new Staff(id:1),
                offerType : new OfferType(id:1),
                status : new ApplicationStatus(id: 1),
                academicYear : new AcademicYear(id:1),
                interviewCategory: new InterviewCategory(id: 1)
                );
        studentYear1 = new StudentYear(
                student: new Student(id:1 ),
                year: new AcademicYear(id:1),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('1991/01/31'),
                studentType : new StudentType(id:1),
                tutorGroup : new TutorGroup(id:1 )
                );
        student2 = new Student(
                id: 1,
                person: person2,
                admissionsNotes: 'test',
                sibling : 'shirisha',
                siblingYear : 2020,
                siblingAdmNo : '22292',
                status : null,
                academicYear : null,
                school : null,
                schoolReportStatus : null,
                offerType : null,
                interviewer : null,
                ethnicity : null,
                llddHealthProblem: null,
                specialCategory : null,
                restrictedUseIndicator : null,
                collegeFundPaid: null
                );
        studentYear2 = new StudentYear(
                student: new Student(id:1 ),
                year : null,
                tutorGroup: null
                );
    }
    
    @Test
    void testConstructor_applicationForm() {
        ApplicationFormDto applicationFormDto = new ApplicationFormDto( student1, studentYear1 )
        assertEquals( applicationFormDto.id, student1.id);
        assertEquals( applicationFormDto.admissionsNotes, student1.admissionsNotes);
        assertEquals( applicationFormDto.referenceNo, student1.referenceNo);
        assertEquals( applicationFormDto.endDate, studentYear1.endDate);
        assertEquals( applicationFormDto.academicYearId, student1.academicYear.id);
        assertEquals( applicationFormDto.yearId, studentYear1.year.id);
        assertEquals( applicationFormDto.dob, student1.person.dob);
        assertEquals( applicationFormDto.legalSexId, student1.person.legalSex.id);
        assertEquals( applicationFormDto.genderId, student1.person.gender.id);
        assertEquals( applicationFormDto.titleId, student1.person.title.id);
        assertEquals( applicationFormDto.schoolId, student1.school.id);
        assertEquals( applicationFormDto.schoolReportStatusId, student1.schoolReportStatus.id);
        assertEquals( applicationFormDto.interviewCategoryId, student1.interviewCategory.id);
    }
    
    @Test
    void testConstructor_NullApplicationForm() {
        ApplicationFormDto applicationFormDto = new ApplicationFormDto( student2, studentYear2 )
        assertEquals( applicationFormDto.id, student2.id);
        assertEquals( applicationFormDto.statusId, null);
        assertEquals( applicationFormDto.academicYearId, null);
        assertEquals( applicationFormDto.yearId, null);
        assertEquals( applicationFormDto.dob, null);
        assertEquals( applicationFormDto.legalSexId, null);
        assertEquals( applicationFormDto.genderId, null);
        assertEquals( applicationFormDto.titleId, null);
        assertEquals( applicationFormDto.schoolId, null);
        assertEquals( applicationFormDto.schoolReportStatusId, null);
    }
}
