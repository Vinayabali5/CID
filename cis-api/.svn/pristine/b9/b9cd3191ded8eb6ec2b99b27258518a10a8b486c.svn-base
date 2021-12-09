package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Faculty
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.ilr.Destination
import uk.ac.reigate.domain.ilr.EnglishConditionOfFunding
import uk.ac.reigate.domain.ilr.MathsConditionOfFunding
import uk.ac.reigate.domain.lookup.BursaryType
import uk.ac.reigate.domain.lookup.StudentType
import uk.ac.reigate.domain.lookup.TutorGroup

public class StudentYearDtoTest {
    
    private StudentYear studentYear1
    
    private StudentYear studentYear2
    
    private StudentYear studentYear3
    
    private StudentYear studentYear4
    
    private List<StudentYear> studentYears
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    TutorGroup createTutorGroup() {
        TutorGroup tutorGroup = new TutorGroup()
        tutorGroup.id = 1
        tutorGroup.code = 'MAT'
        tutorGroup.description = 'Maths'
        tutorGroup.tutor = new Staff(id: 1, knownAs: 'Vinaya', initials: 'VBM')
        tutorGroup.seniorTutor = new Staff(id: 1, knownAs: 'Vinaya', initials: 'VBM')
        tutorGroup.faculty = new Faculty(id: 1, pd: new Staff(id: 1, knownAs: 'vinaya', initials: 'VBM'), apd: new Staff(id: 1, knownAs: 'vinaya', initials: 'VBM'))
        return tutorGroup
    }
    
    TutorGroup createTutorGroup2() {
        TutorGroup tutorGroup = new TutorGroup()
        tutorGroup.id = 1
        tutorGroup.code = null
        tutorGroup.description = null
        tutorGroup.tutor = null
        tutorGroup.seniorTutor = null
        tutorGroup.faculty = new Faculty(id: 1, pd: null, apd: null)
        return tutorGroup
    }
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        student.academicYear = new AcademicYear(id: 1, code: '18', description: '2018')
        return student
    }
    
    Student createStudent2() {
        Student student = new Student()
        student.id = 1
        student.academicYear = null
        return student
    }
    
    AcademicYear createAcademicYear() {
        AcademicYear academicYear = new AcademicYear()
        academicYear.id = 1
        academicYear.code = '12/13'
        return academicYear
    }
    
    @Before
    public void setup() {
        this.studentYear1 = new StudentYear(
                student: createStudent(),
                year: createAcademicYear(),
                studentType : new StudentType(id: 1, code: 'test', description: 'testing'),
                tutorGroup : createTutorGroup(),
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2016/06/30'),
                ilr : true,
                plh : 1,
                peeph: 2,
                gcseMathsGrade : 'A',
                gcseEnglishGrade : 'B',
                candidateNo : 1,
                lda: true,
                hns: true,
                sen : false,
                ehc: true,
                mathsConditionOfFunding : new MathsConditionOfFunding(),
                englishConditionOfFunding : new EnglishConditionOfFunding(),
                learningSupportCost : 1,
                onContract: true,
                initialPostcode: 'cr5',
                externalCandidate : true,
                destination: new Destination(),
                destinationCollegeEmployer: 'Jss',
                destinationCourseCareer: 'College',
                breakInLearning: false,
                bursaryType : new BursaryType(),
                removedFromFreeMeals : true,
                pastoralMonitor : new Staff(id: 1, knownAs: 'Sam')
                );
        this.studentYear2 = new StudentYear(
                student: createStudent2(),
                year: createAcademicYear(),
                tutorGroup : null,
                startDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                endDate: new SimpleDateFormat("yyyy/MM/dd").parse('2016/06/30'),
                ilr : true,
                plh : 1,
                peeph: 2,
                gcseMathsGrade : 'A',
                gcseEnglishGrade : 'B',
                candidateNo : 1,
                lda: true,
                hns: true,
                sen : false,
                ehc: true,
                mathsConditionOfFunding : new MathsConditionOfFunding(),
                englishConditionOfFunding : new EnglishConditionOfFunding(),
                learningSupportCost : 1,
                onContract: true,
                initialPostcode: 'cr5',
                externalCandidate : true,
                destination: new Destination(),
                destinationCollegeEmployer: 'Jss',
                destinationCourseCareer: 'College',
                breakInLearning: false,
                bursaryType : new BursaryType(),
                removedFromFreeMeals : true,
                pastoralMonitor : null
                );
        this.studentYear3 = new StudentYear(
                student: new Student(id:190003, academicYear: null),
                year: null,
                tutorGroup : createTutorGroup2(),
                startDate: null,
                endDate: null,
                ilr : null,
                plh : null,
                peeph: null,
                gcseMathsGrade : null,
                gcseEnglishGrade : null,
                candidateNo : null,
                lda: null,
                hns: null,
                sen : null,
                ehc: null,
                mathsConditionOfFunding : null,
                englishConditionOfFunding : null,
                learningSupportCost : null,
                onContract: null,
                initialPostcode: null,
                externalCandidate : null,
                destination: null,
                destinationCollegeEmployer: 'Jss',
                destinationCourseCareer: 'College',
                breakInLearning: false,
                bursaryType : null,
                removedFromFreeMeals : true,
                studentType: null,
                pastoralMonitor : new Staff(id: 1)
                );
        this.studentYear4 = new StudentYear(
                student: new Student(id:190003, academicYear: null),
                year: null,
                tutorGroup : null
                );
        this.studentYears = Arrays.asList(studentYear1, studentYear2);
    }
    
    @Test
    void testConstructor_NullObject() {
        StudentYearDto studentYearDto = new StudentYearDto( studentYear3 )
        assertEquals( studentYearDto.studentId, studentYear3.student.id);
        assertEquals( studentYearDto.yearId, null);
    }
    
    @Test
    void testConstructor_student() {
        StudentYearDto studentYearDto = new StudentYearDto( studentYear1 )
        assertEquals( studentYearDto.studentId, studentYear1.student.id);
    }
    
    @Test
    public void testConstructor_NullStudentYear() {
        StudentYear studentYear = null
        StudentYearDto studentYearDto = new StudentYearDto(studentYear)
        assertEquals( studentYear, null);
    }
    
    @Test
    public void testMapFromStudentEntity(){
        StudentYearDto studentTest = StudentYearDto.mapFromStudentYearEntity( studentYear1 )
        assertEquals( studentTest.studentId, studentYear1.student.id );
    }
    
    @Test
    public void testMapFromList(){
        List<StudentYearDto> studentTest = StudentYearDto.mapFromStudentYearEntities( studentYears )
        assertEquals( studentTest[0].studentId, studentYear1.student.id );
    }
    
    @Test
    public void testEquals_Same() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        StudentYearDto studentYearDto2 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1, studentYearDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        StudentYearDto studentYearDto2 = new StudentYearDto(studentYear2)
        assertNotEquals(studentYearDto1, studentYearDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        StudentYearDto studentYearDto2 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.hashCode(), studentYearDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        StudentYearDto studentYearDto2 = new StudentYearDto(studentYear2)
        assertNotEquals(studentYearDto1.hashCode(), studentYearDto2.hashCode())
    }
    
    @Test
    public void testMethod_Get_NullYearCode() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear3)
        assertEquals(studentYearDto1.year, studentYearDto1.get_YearCode())
    }
    
    @Test
    public void testMethod_Get_YearCode() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.year.code, studentYearDto1.get_YearCode())
    }
    
    @Test
    public void testMethod_Get_NullYearApplied() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear2)
        assertEquals(studentYearDto1.student.yearApplied, studentYearDto1.get_YearApplied())
    }
    
    @Test
    public void testMethod_Get_YearApplied() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.student.yearApplied.code, studentYearDto1.get_YearApplied())
    }
    
    @Test
    public void testMethod_Get_NullStudentTypeCode() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear3)
        assertEquals(studentYearDto1.studentType, studentYearDto1.get_StudentTypeCode())
    }
    
    @Test
    public void testMethod_Get_StudentTypeCode() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.studentType.code, studentYearDto1.get_StudentTypeCode())
    }
    
    @Test
    public void testMethod_Get_NullStudentTypeDescription() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear4)
        assertEquals(studentYearDto1.studentType, studentYearDto1.get_StudentTypeDescription())
    }
    
    @Test
    public void testMethod_Get_StudentTypeDescription() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.studentType.description, studentYearDto1.get_StudentTypeDescription())
    }
    
    @Test
    public void testMethod_Get_NullTutorGroupCode() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear4)
        assertEquals(studentYearDto1.tutorGroup, studentYearDto1.get_TutorGroupCode())
    }
    
    @Test
    public void testMethod_Get_TutorGroupCode() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.tutorGroup.code, studentYearDto1.get_TutorGroupCode())
    }
    
    @Test
    public void testMethod_Get_NullTutorGroupDescription() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear4)
        assertEquals(studentYearDto1.tutorGroup, studentYearDto1.get_TutorGroupDescription())
    }
    
    @Test
    public void testMethod_Get_TutorGroupDescription() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.tutorGroup.description, studentYearDto1.get_TutorGroupDescription())
    }
    
    
    @Test
    public void testMethod_Get_NullTutorName() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear3)
        assertEquals(studentYearDto1.tutorGroup.tutor, studentYearDto1.get_TutorName())
    }
    
    @Test
    public void testMethod_Get_TutorName() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.tutorGroup.tutor.knownAs, studentYearDto1.get_TutorName())
    }
    
    @Test
    public void testMethod_Get_NullSeniorTutorName() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear3)
        assertEquals(studentYearDto1.tutorGroup.seniorTutor, studentYearDto1.get_SeniorTutorName())
    }
    
    @Test
    public void testMethod_Get_SeniorTutorName() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.tutorGroup.seniorTutor.knownAs, studentYearDto1.get_SeniorTutorName())
    }
    
    @Test
    public void testMethod_Get_NullSeniorTutorInitials() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear3)
        assertEquals(studentYearDto1.tutorGroup.seniorTutor, studentYearDto1.get_SeniorTutorInitials())
    }
    
    @Test
    public void testMethod_Get_SeniorTutorInitials() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.tutorGroup.seniorTutor.initials, studentYearDto1.get_SeniorTutorInitials())
    }
    
    @Test
    public void testMethod_Get_NullPastoralDirectorInitials() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear3)
        assertEquals(studentYearDto1.tutorGroup.faculty.pd, studentYearDto1.get_PastoralDirectorInitials())
    }
    
    @Test
    public void testMethod_Get_PastoralDirectorInitials() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.tutorGroup.faculty.pd.initials, studentYearDto1.get_PastoralDirectorInitials())
    }
    
    @Test
    public void testMethod_Get_NullPastoralDirectorName() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear3)
        assertEquals(studentYearDto1.tutorGroup.faculty.pd, studentYearDto1.get_PastoralDirectorName())
    }
    
    @Test
    public void testMethod_Get_PastoralDirectorName() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.tutorGroup.faculty.pd.knownAs, studentYearDto1.get_PastoralDirectorName())
    }
    
    @Test
    public void testMethod_Get_NullAssociatePastoralDirectorInitials() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear3)
        assertEquals(studentYearDto1.tutorGroup.faculty.apd, studentYearDto1.get_AssociatePastoralDirectorInitials())
    }
    
    @Test
    public void testMethod_Get_AssociatePastoralDirectorInitials() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.tutorGroup.faculty.apd.initials, studentYearDto1.get_AssociatePastoralDirectorInitials())
    }
    
    @Test
    public void testMethod_Get_NullAssociatePastoralDirectorName() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear3)
        assertEquals(studentYearDto1.tutorGroup.faculty.apd, studentYearDto1.get_AssociatePastoralDirectorName())
    }
    
    @Test
    public void testMethod_Get_AssociatePastoralDirectorName() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.tutorGroup.faculty.apd.knownAs, studentYearDto1.get_AssociatePastoralDirectorName())
    }
    
    @Test
    public void testMethod_Get_NullTutorInitials() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear3)
        assertEquals(studentYearDto1.tutorGroup.tutor, studentYearDto1.get_TutorInitials())
    }
    
    @Test
    public void testMethod_Get_TutorInitials() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.tutorGroup.tutor.initials, studentYearDto1.get_TutorInitials())
    }
    
    @Test
    public void testMethod_Get_NullPastoralMonitor() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear2)
        assertEquals(studentYearDto1.pastoralMonitor, studentYearDto1.get_PastoralMonitor())
    }
    
    @Test
    public void testMethod_Get_PastoralMonitor() {
        StudentYearDto studentYearDto1 = new StudentYearDto(studentYear1)
        assertEquals(studentYearDto1.pastoralMonitor.knownAs, studentYearDto1.get_PastoralMonitor())
    }
}