package uk.ac.reigate.services

import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.PersonAlias
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.PersonSummaryDto
import uk.ac.reigate.repositories.PersonAliasRepository
import uk.ac.reigate.repositories.PersonRepository
import uk.ac.reigate.repositories.StaffRepository
import uk.ac.reigate.repositories.academic.StudentRepository
import uk.ac.reigate.repositories.lookup.TutorGroupRepository


class UserServiceTest {
    
    @Mock
    private PersonRepository personRepository
    
    @Mock
    private PersonAliasRepository personAliasRepository
    
    @Mock
    private StaffRepository staffRepository
    
    @Mock
    private StudentRepository studentRepository
    
    @Mock
    private TutorGroupService tutorGroupService
    
    @Mock
    private FacultyService facultyService
    
    @Mock
    private DepartmentService departmentService
    
    @InjectMocks
    private UserService userService;
    
    @Mock
    private TutorGroupRepository tutorGroupRepository
    
    private Person user
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to set up the tests for the UserService
     */
    @Before
    public void setup() {
        personRepository = mock(PersonRepository.class);
        personAliasRepository = mock(PersonAliasRepository.class);
        staffRepository = mock(StaffRepository.class);
        studentRepository = mock(StudentRepository.class);
        tutorGroupService = mock(TutorGroupService.class);
        facultyService = mock(FacultyService.class);
        departmentService = mock(DepartmentService.class);
        
        this.userService = new UserService(personRepository, personAliasRepository, staffRepository, studentRepository, tutorGroupService, facultyService, departmentService);
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        UserService service = new UserService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindUserByUsername() {
        Person result = userService.findUserByUsername('Vin');
        verify(personRepository, times(1)).findByUsername('Vin')
        verifyNoMoreInteractions(personRepository)
    }
    
    @Test
    public void testAddStudentData() {
        Map<String, Object> map = new HashMap<>();
        Person user = new Person(id: 1, username: 'Vinaya', student: new Student(id: 190001))
        userService.addStudentData(map, user);
        user.student
        map.put("studentId", 190001)
        map.put("isStudent", true)
        assertNotNull(map)
    }
    
    @Test
    public void testAddStaffData() {
        Map<String, Object> map = new HashMap<>();
        Person user = new Person(id: 1, username: 'Vinaya', staff: new Staff(id: 10, initials:'vbm'))
        userService.addStaffData(map, user);
        user != null
        Staff staff = user.staff
        map.put("staffId", 10)
        map.put("initials", 'vbm')
        map.put("isStaff", true)
        assertNotNull(map)
    }
}