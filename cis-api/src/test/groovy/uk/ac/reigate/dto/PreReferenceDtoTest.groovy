package uk.ac.reigate.dto

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.academic.PreReference
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.PossibleGrade

class PreReferenceDtoTest {
    
    private PreReference preReference1
    
    private PreReference preReference2
    
    private List<PreReference> preReferences
    
    @Before
    public void setup() {
        this.preReference1 = new PreReference(
                student : new Student(id: 190001),
                course : new Course( id: 1),
                predictedGrade : new PossibleGrade(id: 1, grade: 'A')
                )
        this.preReference2 = new PreReference(
                student : new Student(),
                course : new Course(),
                predictedGrade : null
                )
        this.preReferences = Arrays.asList(preReference1, preReference2)
    }
    
    @Test
    public void testConstructor() {
        PreReferenceDto dto = new PreReferenceDto(preReference1)
        assertEquals( dto.studentId, preReference1.student.id);
        assertEquals( dto.courseId, preReference1.course.id);
        assertEquals( dto.predictedGradeId, preReference1.predictedGrade.id);
    }
    
    @Test
    public void testConstructorWithStudent() {
        Student student = new Student(id: 200001)
        Course course = new Course(id: 1)
        PossibleGrade predicatedGrade = new PossibleGrade(id: 1)
        PreReferenceDto dto = new PreReferenceDto(student, course, predicatedGrade)
        assertEquals( dto.studentId, student.id);
        assertEquals( dto.courseId, course.id);
        assertEquals( dto.predictedGradeId, predicatedGrade.id);
    }
    
    @Test
    public void testConstructorNullObject() {
        PreReference preReference = new PreReference(student: null, course: null, predictedGrade: null)
        PreReferenceDto dto = new PreReferenceDto(preReference)
        assertEquals( dto.studentId, null);
        assertEquals( dto.courseId, null);
        assertEquals( dto.predictedGradeId, null);
    }
    
    @Test
    public void testMapFromEntity() {
        PreReferenceDto dto = PreReferenceDto.mapFromEntity(preReference1)
        assertEquals( dto.studentId, preReference1.student.id);
        assertEquals( dto.courseId, preReference1.course.id);
        assertEquals( dto.predictedGradeId, preReference1.predictedGrade.id);
    }
    
    @Test
    public void testMapFromList() {
        List<PreReferenceDto> dto = PreReferenceDto.mapFromList(preReferences)
        assertEquals( dto[0].studentId, preReference1.student.id);
        assertEquals( dto[0].courseId, preReference1.course.id);
        assertEquals( dto[0].predictedGradeId, preReference1.predictedGrade.id);
        assertEquals( dto[1].studentId, preReference2.student.id);
        assertEquals( dto[1].courseId, preReference2.course.id);
        assertEquals( dto[1].predictedGradeId, preReference2.predictedGrade);
    }
    
    @Test
    public void test_NullGetGrade() {
        PreReferenceDto dto = PreReferenceDto.mapFromEntity(preReference2)
        assertEquals( dto.possibleGrade, dto.get_Grade())
    }
    
    @Test
    public void test_GetGrade() {
        PreReferenceDto dto = PreReferenceDto.mapFromEntity(preReference1)
        assertEquals( dto.possibleGrade.grade, dto.get_Grade())
    }
}
