package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.SpecialCategory
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.learning_support.StudentSpecialCategory

public class StudentSpecialCategoryPublicDtoTest {
    
    private StudentSpecialCategory studentSpecialCategory1
    
    private StudentSpecialCategory studentSpecialCategory2
    
    private StudentSpecialCategory studentSpecialCategory3
    
    private List<StudentSpecialCategory> studentSpecialCategories
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    SpecialCategory createSpecialCategory() {
        SpecialCategory specialCategory = new SpecialCategory()
    }
    
    Staff createStaffRequesting() {
        Staff staffRequesting = new Staff()
    }
    
    Staff createRiskAssessmentToBeCompletedBy() {
        Staff riskAssessmentToBeCompletedBy = new Staff()
    }
    
    Staff createStaffConcerned() {
        Staff staffConcerned = new Staff()
    }
    
    Staff createRiskAssessmentRaisedBy() {
        Staff riskAssessmentRaisedBy = new Staff()
    }
    
    Staff createRiskAssessmentCarriedOutBy() {
        Staff riskAssessmentCarriedOutBy = new Staff()
    }
    
    @Before
    public void setup() {
        studentSpecialCategory1 = new StudentSpecialCategory(
                id: 1,
                student: createStudent(),
                requestDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                specialCategory : createSpecialCategory(),
                specialConfirmed : true,
                classificationDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                closedDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                monitoringNotes : 'n',
                staffRequesting : createStaffRequesting(),
                riskAssessmentRequired : true,
                riskAssessmentToBeCompletedBy : createRiskAssessmentToBeCompletedBy(),
                informationConfidential : true,
                writtenEvidence : true,
                passToStaffConcerned : true,
                staffConcerned : createStaffConcerned(),
                riskToStudentOrOthers : 't',
                emergencyContactNos : '34324',
                outsideAgenciesInvolved : 'df',
                toBeInformedPotentialRisks :'test',
                riskAssessmentRaisedBy : createRiskAssessmentRaisedBy(),
                riskAssessmentRaisedDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                riskAssessmentCarriedOutBy : createRiskAssessmentCarriedOutBy(),
                riskAssessmentCarriedOutDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                inEventEmergency : 'T'
                );
        studentSpecialCategory2 = new StudentSpecialCategory(
                id: 2,
                student: createStudent(),
                requestDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                specialCategory : createSpecialCategory(),
                specialConfirmed : true,
                classificationDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                closedDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                monitoringNotes : 'n',
                staffRequesting : createStaffRequesting(),
                riskAssessmentRequired : true,
                riskAssessmentToBeCompletedBy : createRiskAssessmentToBeCompletedBy(),
                informationConfidential : true,
                writtenEvidence : true,
                passToStaffConcerned : true,
                staffConcerned : createStaffConcerned(),
                riskToStudentOrOthers : 't',
                emergencyContactNos : '34324',
                outsideAgenciesInvolved : 'df',
                toBeInformedPotentialRisks :'test',
                riskAssessmentRaisedBy : createRiskAssessmentRaisedBy(),
                riskAssessmentRaisedDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                riskAssessmentCarriedOutBy : createRiskAssessmentCarriedOutBy(),
                riskAssessmentCarriedOutDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                inEventEmergency : 'T'
                );
        studentSpecialCategory3 = new StudentSpecialCategory(
                id: 2,
                student: createStudent(),
                requestDate: new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                specialCategory : null,
                specialConfirmed : true,
                classificationDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                closedDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                monitoringNotes : 'n',
                staffRequesting : createStaffRequesting(),
                riskAssessmentRequired : true,
                riskAssessmentToBeCompletedBy : createRiskAssessmentToBeCompletedBy(),
                informationConfidential : true,
                writtenEvidence : true,
                passToStaffConcerned : true,
                staffConcerned : createStaffConcerned(),
                riskToStudentOrOthers : 't',
                emergencyContactNos : '34324',
                outsideAgenciesInvolved : 'df',
                toBeInformedPotentialRisks :'test',
                riskAssessmentRaisedBy : createRiskAssessmentRaisedBy(),
                riskAssessmentRaisedDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                riskAssessmentCarriedOutBy : createRiskAssessmentCarriedOutBy(),
                riskAssessmentCarriedOutDate : new SimpleDateFormat("yyyy/MM/dd").parse('2015/09/01'),
                inEventEmergency : 'T'
                );
        studentSpecialCategories = Arrays.asList(studentSpecialCategory1, studentSpecialCategory2);
    }
    
    @Test
    public void testMapFromStudentSpecialCategoryEntity(){
        StudentSpecialCategoryPublicDto studentSpecialCategoryTest = StudentSpecialCategoryPublicDto.mapFromEntity( studentSpecialCategory1 )
        assertEquals( studentSpecialCategoryTest.id, studentSpecialCategory1.id );
        assertEquals( studentSpecialCategoryTest.specialCategoryId, studentSpecialCategory1.specialCategory.id);
        assertEquals( studentSpecialCategoryTest.specialConfirmed, studentSpecialCategory1.specialConfirmed)
        assertEquals( studentSpecialCategoryTest.classificationDate, studentSpecialCategory1.classificationDate)
        assertEquals( studentSpecialCategoryTest.closedDate , studentSpecialCategory1.closedDate )
        assertEquals( studentSpecialCategoryTest.monitoringNotes, studentSpecialCategory1.monitoringNotes)
    }
    
    @Test
    public void testMapFromStudentSpecialCategorysEntities(){
        List<StudentSpecialCategoryPublicDto> studentSpecialCategorysDtoTest = StudentSpecialCategoryPublicDto.mapFromList( studentSpecialCategories )
        assertEquals( studentSpecialCategorysDtoTest[0].id, studentSpecialCategory1.id );
        assertEquals( studentSpecialCategorysDtoTest[0].specialCategoryId, studentSpecialCategory1.specialCategory.id);
        assertEquals( studentSpecialCategorysDtoTest[0].specialConfirmed, studentSpecialCategory1.specialConfirmed)
        assertEquals( studentSpecialCategorysDtoTest[0].classificationDate, studentSpecialCategory1.classificationDate)
        assertEquals( studentSpecialCategorysDtoTest[0].closedDate , studentSpecialCategory1.closedDate )
        assertEquals( studentSpecialCategorysDtoTest[0].monitoringNotes, studentSpecialCategory1.monitoringNotes)
        assertEquals( studentSpecialCategorysDtoTest[1].id, studentSpecialCategory2.id );
        assertEquals( studentSpecialCategorysDtoTest[1].specialCategoryId, studentSpecialCategory2.specialCategory.id);
        assertEquals( studentSpecialCategorysDtoTest[1].specialConfirmed, studentSpecialCategory2.specialConfirmed)
        assertEquals( studentSpecialCategorysDtoTest[1].classificationDate, studentSpecialCategory2.classificationDate)
        assertEquals( studentSpecialCategorysDtoTest[1].closedDate , studentSpecialCategory2.closedDate )
        assertEquals( studentSpecialCategorysDtoTest[1].monitoringNotes, studentSpecialCategory2.monitoringNotes)
    }
    
    @Test
    public void testEquals_Same() {
        StudentSpecialCategoryPublicDto studentSpecialCategoryDto1 = new StudentSpecialCategoryPublicDto(studentSpecialCategory1)
        StudentSpecialCategoryPublicDto studentSpecialCategoryDto2 = new StudentSpecialCategoryPublicDto(studentSpecialCategory1)
        assertEquals(studentSpecialCategoryDto1, studentSpecialCategoryDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentSpecialCategoryPublicDto studentSpecialCategoryDto1 = new StudentSpecialCategoryPublicDto(studentSpecialCategory1)
        StudentSpecialCategoryPublicDto studentSpecialCategoryDto2 = new StudentSpecialCategoryPublicDto(studentSpecialCategory2)
        assertNotEquals(studentSpecialCategoryDto1, studentSpecialCategoryDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentSpecialCategoryPublicDto studentSpecialCategoryDto1 = new StudentSpecialCategoryPublicDto(studentSpecialCategory1)
        StudentSpecialCategoryPublicDto studentSpecialCategoryDto2 = new StudentSpecialCategoryPublicDto(studentSpecialCategory1)
        assertEquals(studentSpecialCategoryDto1.hashCode(), studentSpecialCategoryDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentSpecialCategoryPublicDto studentSpecialCategoryDto1 = new StudentSpecialCategoryPublicDto(studentSpecialCategory1)
        StudentSpecialCategoryPublicDto studentSpecialCategoryDto2 = new StudentSpecialCategoryPublicDto(studentSpecialCategory2)
        assertNotEquals(studentSpecialCategoryDto1.hashCode(), studentSpecialCategoryDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentSpecialCategory() {
        StudentSpecialCategoryPublicDto studentSpecialCategoryTest= new StudentSpecialCategoryPublicDto(studentSpecialCategory1)
        assertEquals( studentSpecialCategoryTest.specialCategoryId, studentSpecialCategory1.specialCategory.id);
        assertEquals( studentSpecialCategoryTest.specialConfirmed, studentSpecialCategory1.specialConfirmed)
        assertEquals( studentSpecialCategoryTest.classificationDate, studentSpecialCategory1.classificationDate)
        assertEquals( studentSpecialCategoryTest.closedDate , studentSpecialCategory1.closedDate )
        assertEquals( studentSpecialCategoryTest.monitoringNotes, studentSpecialCategory1.monitoringNotes)
    }
    
    @Test
    public void testConstructor_NullStudentSpecialCategory() {
        StudentSpecialCategory studentSpecialCategory = null
        StudentSpecialCategoryPublicDto studentSpecialCategoryTest= new StudentSpecialCategoryPublicDto(studentSpecialCategory)
        assertEquals( studentSpecialCategory, null)
    }
    
    @Test
    public void testConstructor_NullSpecialCategory() {
        StudentSpecialCategoryPublicDto studentSpecialCategoryTest= new StudentSpecialCategoryPublicDto(studentSpecialCategory3)
        assertEquals( studentSpecialCategoryTest.specialCategoryId, studentSpecialCategory3.specialCategory);
        assertEquals( studentSpecialCategoryTest.specialConfirmed, studentSpecialCategory3.specialConfirmed)
        assertEquals( studentSpecialCategoryTest.classificationDate, studentSpecialCategory3.classificationDate)
        assertEquals( studentSpecialCategoryTest.closedDate , studentSpecialCategory3.closedDate )
        assertEquals( studentSpecialCategoryTest.monitoringNotes, studentSpecialCategory3.monitoringNotes)
    }
    
    @Test
    public void testMethod_Get_NullSpecialCategoryCode() {
        StudentSpecialCategoryPublicDto studentSpecialCategoryDto1 = new StudentSpecialCategoryPublicDto(studentSpecialCategory3)
        assertEquals(studentSpecialCategoryDto1.specialCategory, studentSpecialCategoryDto1.get_SpecialCategoryCode())
    }
    
    @Test
    public void testMethod_Get_SpecialCategoryCode() {
        StudentSpecialCategoryPublicDto studentSpecialCategoryDto1 = new StudentSpecialCategoryPublicDto(studentSpecialCategory1)
        assertEquals(studentSpecialCategoryDto1.specialCategory.code, studentSpecialCategoryDto1.get_SpecialCategoryCode())
    }
}