package uk.ac.reigate.dto;

import static org.junit.Assert.*

import java.text.SimpleDateFormat

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.Address
import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Department
import uk.ac.reigate.domain.academic.Faculty
import uk.ac.reigate.domain.lookup.Gender
import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.domain.lookup.StaffType
import uk.ac.reigate.domain.lookup.Title

public class DepartmentDtoTest {
    
    private Title mrs
    
    private Gender female
    
    private LegalSex Female
    
    private Address address1
    
    private Person person1
    
    private StaffType staffType1
    
    private Staff staff
    
    private Faculty faculty
    
    private Department department1
    
    private Department department2
    
    private List<Department> departments
    
    @Before
    public void setupTests() {
        this.female = new Gender()
        this.mrs = new Title()
        this.address1 = new Address(1, 'Flat D', 'Stag', 'Stanley', 'west', 'park', 'Wallington', '', 'E161FF', '', '')
        this.person1 = new Person(id:1)
        this.staffType1 = new StaffType()
        this.staff = new Staff(id: 1, knownAs: 'vbm');
        this.faculty = new Faculty(id: 1, description: 'Faculty')
        this.department1 = new Department(
                id: 1,
                name: 'A',
                description: 'A Department',
                faculty: faculty,
                hod: staff,
                hod2:staff,
                academic: true
                );
        this.department2 = new Department(
                id: 2,
                name: 'B',
                description: 'B Department',
                faculty: faculty,
                hod: staff,
                hod2:staff,
                academic: true
                );
        this.departments = Arrays.asList(department1, department2);
    }
    
    DepartmentDto generateDepartmentDto() {
        return generateDepartment1Dto()
    }
    
    DepartmentDto generateDepartment1Dto(){
        return new DepartmentDto(department1)
    }
    
    DepartmentDto generateDepartment2Dto(){
        return new DepartmentDto(department2)
    }
    
    @Test
    public void testMapFromDepartmentEntityTest(){
        DepartmentDto departmentTest = DepartmentDto.mapFromEntity( department1 )
        assertEquals( departmentTest.id, department1.id );
        assertEquals( departmentTest.name, department1.name);
        assertEquals( departmentTest.description, department1.description);
        assertEquals( departmentTest.facultyId, department1.faculty.id);
        assertEquals( departmentTest.hodId, department1.hod.id);
        assertEquals( departmentTest.academic, department1.academic);
    }
    
    @Test
    public void testMapFromDepartmentsEntitiesTest(){
        List<DepartmentDto> departmentTest = DepartmentDto.mapFromList(departments)
        assertEquals( departmentTest[0].id, department1.id );
        assertEquals( departmentTest[0].name, department1.name);
        assertEquals( departmentTest[0].description, department1.description);
        assertEquals( departmentTest[0].facultyId, department1.faculty.id);
        assertEquals( departmentTest[0].hodId, department1.hod.id);
        assertEquals( departmentTest[1].id, department2.id );
        assertEquals( departmentTest[1].name, department2.name);
        assertEquals( departmentTest[1].description, department2.description);
        assertEquals( departmentTest[1].facultyId, department2.faculty.id);
        assertEquals( departmentTest[1].hodId, department2.hod.id);
    }
    
    @Test
    public void testEquals_Same() {
        DepartmentDto departmentDto1 = new DepartmentDto(department1)
        DepartmentDto departmentDto2 = new DepartmentDto(department1)
        assertEquals( departmentDto1, departmentDto2)
    }
    
    @Test
    public void testEquals_Different() {
        DepartmentDto departmentDto1 = new DepartmentDto(department1)
        DepartmentDto departmentDto2 = new DepartmentDto(department2)
        assertNotEquals( departmentDto1, departmentDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        DepartmentDto departmentDto1 = new DepartmentDto(department1)
        DepartmentDto departmentDto2 = new DepartmentDto(department1)
        assertEquals( departmentDto1.hashCode(), departmentDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        DepartmentDto departmentDto1 = new DepartmentDto(department1)
        DepartmentDto departmentDto2 = new DepartmentDto(department2)
        assertNotEquals( departmentDto1.hashCode(), departmentDto2.hashCode())
    }
    
    @Test
    public void testConstructor_Department() {
        DepartmentDto departmentDto = new DepartmentDto(department1)
        assertEquals( departmentDto.name, department1.name )
        assertEquals( departmentDto.description, department1.description )
        assertEquals( departmentDto.facultyId, department1.faculty.id )
        assertEquals( departmentDto.hodId, department1.hod.id )
        assertEquals( departmentDto.academic, department1.academic )
    }
    
    @Test
    public void testMethod_Get_NullFacultyDescription() {
        Department department = new Department(id: 1, faculty: null)
        DepartmentDto departmentDto1 = new DepartmentDto(department)
        assertEquals(departmentDto1.faculty, departmentDto1.get_FacultyDescription())
    }
    
    @Test
    public void testMethod_Get_FacultyDescription() {
        DepartmentDto departmentDto1 = new DepartmentDto(department1)
        assertEquals(departmentDto1.faculty.description, departmentDto1.get_FacultyDescription())
    }
    
    @Test
    public void testMethod_Get_NullHodName() {
        Department department = new Department(id: 1, hod: null)
        DepartmentDto departmentDto1 = new DepartmentDto(department)
        assertEquals(departmentDto1.hod, departmentDto1.get_HodName())
    }
    
    @Test
    public void testMethod_Get_HodName() {
        DepartmentDto departmentDto1 = new DepartmentDto(department1)
        assertEquals(departmentDto1.hod.knownAs, departmentDto1.get_HodName())
    }
    
    @Test
    public void testMethod_Get_NullHod2Name() {
        Department department = new Department(id: 1, hod2: null)
        DepartmentDto departmentDto1 = new DepartmentDto(department)
        assertEquals(departmentDto1.hod2, departmentDto1.get_Hod2Name())
    }
    
    @Test
    public void testMethod_Get_Hod2Name() {
        DepartmentDto departmentDto1 = new DepartmentDto(department1)
        assertEquals(departmentDto1.hod2.knownAs, departmentDto1.get_Hod2Name())
    }
}
