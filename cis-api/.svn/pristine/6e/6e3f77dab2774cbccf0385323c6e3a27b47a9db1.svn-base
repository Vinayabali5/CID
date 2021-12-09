package uk.ac.reigate.dto;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.lookup.StudentRemarkPermission


public class StudentRemarkPermissionDtoTest {
    
    private StudentRemarkPermission studentRemarkPermission1
    
    private StudentRemarkPermission studentRemarkPermission2
    
    private List<StudentRemarkPermission> studentRemarkPermissions
    
    @Before
    public void setup() {
        studentRemarkPermission1 = new StudentRemarkPermission(
                id: 1,
                code:'GEN',
                description:'General StudentRemarkPermission'
                );
        studentRemarkPermission2 = new StudentRemarkPermission(
                id: 2,
                code:'PER',
                description:'Permanent StudentRemarkPermission'
                );
        studentRemarkPermissions = Arrays.asList(studentRemarkPermission1, studentRemarkPermission2);
    }
    
    @Test
    public void testConstructor_NullObject() {
        StudentRemarkPermission studentRemarkPermission = null
        StudentRemarkPermissionDto studentRemarkPermissionDto1 = new StudentRemarkPermissionDto(studentRemarkPermission)
        assertEquals(studentRemarkPermission, null)
    }
    
    @Test
    public void testMapFromStudentRemarkPermissionEntity(){
        StudentRemarkPermissionDto studentRemarkPermissionTest = StudentRemarkPermissionDto.mapFromEntity( studentRemarkPermission1 )
        assertEquals( studentRemarkPermissionTest.id, studentRemarkPermission1.id );
        assertEquals( studentRemarkPermissionTest.code, studentRemarkPermission1.code);
        assertEquals( studentRemarkPermissionTest.description, studentRemarkPermission1.description);
    }
    
    @Test
    public void testMapFromStudentRemarkPermissionsEntities(){
        List<StudentRemarkPermissionDto> studentRemarkPermissionDtoTest = StudentRemarkPermissionDto.mapFromList( studentRemarkPermissions )
        assertEquals( studentRemarkPermissionDtoTest[0].id, studentRemarkPermission1.id );
        assertEquals( studentRemarkPermissionDtoTest[0].code, studentRemarkPermission1.code);
        assertEquals( studentRemarkPermissionDtoTest[0].description, studentRemarkPermission1.description);
        assertEquals( studentRemarkPermissionDtoTest[1].id, studentRemarkPermission2.id );
        assertEquals( studentRemarkPermissionDtoTest[1].code, studentRemarkPermission2.code);
        assertEquals( studentRemarkPermissionDtoTest[1].description, studentRemarkPermission2.description);
    }
    
    @Test
    public void testEquals_Same() {
        StudentRemarkPermissionDto studentRemarkPermissionDto1 = new StudentRemarkPermissionDto(studentRemarkPermission1)
        StudentRemarkPermissionDto studentRemarkPermissionDto2 = new StudentRemarkPermissionDto(studentRemarkPermission1)
        assertEquals(studentRemarkPermissionDto1, studentRemarkPermissionDto2)
    }
    
    @Test
    public void testEquals_Different() {
        StudentRemarkPermissionDto studentRemarkPermissionDto1 = new StudentRemarkPermissionDto(studentRemarkPermission1)
        StudentRemarkPermissionDto studentRemarkPermissionDto2 = new StudentRemarkPermissionDto(studentRemarkPermission2)
        assertNotEquals(studentRemarkPermissionDto1, studentRemarkPermissionDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        StudentRemarkPermissionDto studentRemarkPermissionDto1 = new StudentRemarkPermissionDto(studentRemarkPermission1)
        StudentRemarkPermissionDto studentRemarkPermissionDto2 = new StudentRemarkPermissionDto(studentRemarkPermission1)
        assertEquals(studentRemarkPermissionDto1.hashCode(), studentRemarkPermissionDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        StudentRemarkPermissionDto studentRemarkPermissionDto1 = new StudentRemarkPermissionDto(studentRemarkPermission1)
        StudentRemarkPermissionDto studentRemarkPermissionDto2 = new StudentRemarkPermissionDto(studentRemarkPermission2)
        assertNotEquals(studentRemarkPermissionDto1.hashCode(), studentRemarkPermissionDto2.hashCode())
    }
    
    @Test
    public void testConstructor_StudentRemarkPermission() {
        StudentRemarkPermissionDto studentRemarkPermissionDto = new StudentRemarkPermissionDto(studentRemarkPermission1)
        assertEquals( studentRemarkPermissionDto.code, studentRemarkPermission1.code )
        assertEquals( studentRemarkPermissionDto.description, studentRemarkPermission1.description )
    }
}