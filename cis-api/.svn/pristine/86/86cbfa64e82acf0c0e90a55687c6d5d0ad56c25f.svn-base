package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.ilr.LLDDHealthProblemCategory
import uk.ac.reigate.domain.learning_support.StudentLLDDHealthProblemCategory


public class StudentLLDDHealthProblemCategoryDtoTest {
    
    private StudentLLDDHealthProblemCategory studentLLDDHealthProblemCategory1
    
    private StudentLLDDHealthProblemCategory studentLLDDHealthProblemCategory2
    
    private StudentLLDDHealthProblemCategory studentLLDDHealthProblemCategory3
    
    private List<StudentLLDDHealthProblemCategory> studentLLDDHealthProblemCategories
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    LLDDHealthProblemCategory createLLDDHealthProblemCategory() {
        LLDDHealthProblemCategory lLDDHealthProblemCategory = new LLDDHealthProblemCategory()
    }
    
    @Before
    public void setup() {
        studentLLDDHealthProblemCategory1 = new StudentLLDDHealthProblemCategory(
                id: 1,
                student: createStudent(),
                lLDDHealthProblemCategory:createLLDDHealthProblemCategory(),
                primarylldd : true
                );
        studentLLDDHealthProblemCategory2 = new StudentLLDDHealthProblemCategory(
                id: 2,
                student: createStudent(),
                lLDDHealthProblemCategory:createLLDDHealthProblemCategory(),
                primarylldd : true
                );
        studentLLDDHealthProblemCategory3 = new StudentLLDDHealthProblemCategory(
                id: 2,
                student: null,
                lLDDHealthProblemCategory:null,
                primarylldd : true
                );
        studentLLDDHealthProblemCategories = Arrays.asList(studentLLDDHealthProblemCategory1, studentLLDDHealthProblemCategory2);
    }
    
    @Test
    public void testMapFromStudentLLDDHealthProblemCategoryEntity(){
        StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryTest = StudentLLDDHealthProblemCategoryDto.mapFromEntity( studentLLDDHealthProblemCategory1 )
        assertEquals( studentLLDDHealthProblemCategoryTest.studentId, studentLLDDHealthProblemCategory1.student.id );
        assertEquals( studentLLDDHealthProblemCategoryTest.lLDDHealthProblemCategoryId, studentLLDDHealthProblemCategory1.lLDDHealthProblemCategory.id);
        assertEquals( studentLLDDHealthProblemCategoryTest.primarylldd, studentLLDDHealthProblemCategory1.primarylldd)
    }
    
    @Test
    public void testMapFromStudentLLDDHealthProblemCategorysEntities(){
        List<StudentLLDDHealthProblemCategoryDto> studentLLDDHealthProblemCategorysDtoTest = StudentLLDDHealthProblemCategoryDto.mapFromList( studentLLDDHealthProblemCategories )
        assertEquals( studentLLDDHealthProblemCategorysDtoTest[0].studentId, studentLLDDHealthProblemCategory1.student.id );
        assertEquals( studentLLDDHealthProblemCategorysDtoTest[0].lLDDHealthProblemCategoryId, studentLLDDHealthProblemCategory1.lLDDHealthProblemCategory.id);
        assertEquals( studentLLDDHealthProblemCategorysDtoTest[1].studentId, studentLLDDHealthProblemCategory2.student.id );
        assertEquals( studentLLDDHealthProblemCategorysDtoTest[1].lLDDHealthProblemCategoryId, studentLLDDHealthProblemCategory2.lLDDHealthProblemCategory.id);
    }
    
    
    @Test
    public void testEquals_Same() {
        StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto1 = new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory1)
        StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto2 = new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory1)
        assertEquals(studentLLDDHealthProblemCategoryDto1, studentLLDDHealthProblemCategoryDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto1 = new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory1)
        StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto2 = new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory2)
        assertNotEquals(studentLLDDHealthProblemCategoryDto1, studentLLDDHealthProblemCategoryDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto1 = new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory1)
        StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto2 = new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory1)
        assertEquals(studentLLDDHealthProblemCategoryDto1.hashCode(), studentLLDDHealthProblemCategoryDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto1 = new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory1)
        StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto2 = new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory2)
        assertNotEquals(studentLLDDHealthProblemCategoryDto1.hashCode(), studentLLDDHealthProblemCategoryDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentLLDDHealthProblemCategory() {
        StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto = new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory1)
        assertEquals( studentLLDDHealthProblemCategoryDto.lLDDHealthProblemCategoryId, studentLLDDHealthProblemCategory1.lLDDHealthProblemCategory.id )
        assertEquals( studentLLDDHealthProblemCategoryDto.primarylldd, studentLLDDHealthProblemCategory1.primarylldd)
    }
    
    @Test
    public void testConstructor_NullStudentLLDDHealthProblemCategory() {
        StudentLLDDHealthProblemCategory studentLLDDHealthProblemCategory = null
        StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto = new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory)
        assertEquals( studentLLDDHealthProblemCategory, null)
    }
    
    @Test
    public void testConstructor_NullStudent() {
        StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto = new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory3)
        assertEquals( studentLLDDHealthProblemCategoryDto.lLDDHealthProblemCategoryId, studentLLDDHealthProblemCategory3.lLDDHealthProblemCategory )
        assertEquals( studentLLDDHealthProblemCategoryDto.primarylldd, studentLLDDHealthProblemCategory3.primarylldd)
    }
    
    @Test
    public void testMethod_Get_NullLLDDHealthProblemCategoryDescription() {
        StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto1 = new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory3)
        assertEquals(studentLLDDHealthProblemCategoryDto1.lLDDHealthProblemCategory, studentLLDDHealthProblemCategoryDto1.get_LLDDHealthProblemCategoryDescription())
    }
    
    @Test
    public void testMethod_Get_LLDDHealthProblemCategoryDescription() {
        StudentLLDDHealthProblemCategoryDto studentLLDDHealthProblemCategoryDto1 = new StudentLLDDHealthProblemCategoryDto(studentLLDDHealthProblemCategory1)
        assertEquals(studentLLDDHealthProblemCategoryDto1.lLDDHealthProblemCategory.description, studentLLDDHealthProblemCategoryDto1.get_LLDDHealthProblemCategoryDescription())
    }
}
