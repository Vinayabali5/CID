package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.SimilarNamedStudent
import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.lookup.PossibleGrade


public class SimilarNamedStudentDtoTest {
    
    private SimilarNamedStudent studentYear1
    
    private SimilarNamedStudent studentYear2
    
    private SimilarNamedStudent studentYear3
    
    private List<SimilarNamedStudent> studentYears
    
    Student createStudent() {
        Student student = new Student()
        student.id = 1
        return student
    }
    
    Student createStudent2() {
        Student student = new Student()
        student.id = 2
        return student
    }
    
    @Before
    public void setup() {
        studentYear1 = new SimilarNamedStudent(
                student: createStudent(),
                academicYear: new AcademicYear(id: 20),
                numberSimilarNames: 2
                );
        studentYear2 = new SimilarNamedStudent(
                student: createStudent2(),
                academicYear: new AcademicYear(id: 20),
                numberSimilarNames: 3
                );
        studentYear3 = new SimilarNamedStudent(
                student: null,
                academicYear: null,
                numberSimilarNames: null
                );
        studentYears = Arrays.asList(studentYear1, studentYear2);
    }
    
    @Test
    void testConstructor_similarNamedStudent() {
        SimilarNamedStudentDto similarNamedStudentTest = new SimilarNamedStudentDto( studentYear1 )
        assertEquals( similarNamedStudentTest.studentId, studentYear1.student.id);
        assertEquals( similarNamedStudentTest.academicYearId, studentYear1.academicYear.id);
    }
    
    @Test
    void testConstructor_NullStudent() {
        SimilarNamedStudentDto similarNamedStudentTest = new SimilarNamedStudentDto( studentYear3 )
        assertEquals( similarNamedStudentTest.studentId, studentYear3.student);
        assertEquals( similarNamedStudentTest.academicYearId, studentYear3.academicYear);
    }
    
    @Test
    void testConstructor() {
        Student student = new Student(id: 200004)
        AcademicYear academicYear = new AcademicYear(id: 1)
        PossibleGrade predictedGrade = new PossibleGrade(id: 1)
        SimilarNamedStudentDto similarNamedStudentTest = new SimilarNamedStudentDto( student, academicYear, predictedGrade )
        assertEquals( similarNamedStudentTest.studentId, student.id);
        assertEquals( similarNamedStudentTest.academicYearId, academicYear.id);
    }
    
    @Test
    public void testMapFromSimilarNamedStudentEntity(){
        SimilarNamedStudentDto similarNamedStudentTest = SimilarNamedStudentDto.mapFromEntity( studentYear1 )
        assertEquals( similarNamedStudentTest.studentId, studentYear1.student.id);
        assertEquals( similarNamedStudentTest.academicYearId, studentYear1.academicYear.id);
    }
    
    @Test
    public void testMapFromList(){
        List<SimilarNamedStudentDto> similarNamedStudentTest = SimilarNamedStudentDto.mapFromList( studentYears )
        assertEquals( similarNamedStudentTest[0].studentId, studentYear1.student.id);
        assertEquals( similarNamedStudentTest[0].academicYearId, studentYear1.academicYear.id);
    }
    
    
    @Test
    public void testEquals_Same() {
        SimilarNamedStudentDto similarNamedStudentDto1 = new SimilarNamedStudentDto(studentYear1)
        SimilarNamedStudentDto similarNamedStudentDto2 = new SimilarNamedStudentDto(studentYear1)
        assertEquals(similarNamedStudentDto1, similarNamedStudentDto2)
    }
    
    @Test
    public void testEquals_Different() {
        SimilarNamedStudentDto similarNamedStudentDto1 = new SimilarNamedStudentDto(studentYear1)
        SimilarNamedStudentDto similarNamedStudentDto2 = new SimilarNamedStudentDto(studentYear2)
        assertNotEquals(similarNamedStudentDto1, similarNamedStudentDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        SimilarNamedStudentDto similarNamedStudentDto1 = new SimilarNamedStudentDto(studentYear1)
        SimilarNamedStudentDto similarNamedStudentDto2 = new SimilarNamedStudentDto(studentYear1)
        assertEquals(similarNamedStudentDto1.hashCode(), similarNamedStudentDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        SimilarNamedStudentDto similarNamedStudentDto1 = new SimilarNamedStudentDto(studentYear1)
        SimilarNamedStudentDto similarNamedStudentDto2 = new SimilarNamedStudentDto(studentYear2)
        assertNotEquals(similarNamedStudentDto1.hashCode(), similarNamedStudentDto2.hashCode())
    }
}
