package uk.ac.reigate.services

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.PersonAlias
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Department
import uk.ac.reigate.domain.academic.Faculty
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.TutorGroup
import uk.ac.reigate.dto.PersonSummaryDto
import uk.ac.reigate.repositories.PersonAliasRepository
import uk.ac.reigate.repositories.PersonRepository
import uk.ac.reigate.repositories.StaffRepository
import uk.ac.reigate.repositories.academic.StudentRepository

@Service
class UserService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    
    @Autowired
    PersonRepository personRepository
    
    @Autowired
    PersonAliasRepository personAliasRepository
    
    @Autowired
    StaffRepository staffRepository
    
    @Autowired
    StudentRepository studentRepository
    
    @Autowired
    TutorGroupService tutorGroupService
    
    @Autowired
    FacultyService facultyService
    
    @Autowired
    DepartmentService departmentService
    
    /**
     * Default NoArgs constructor
     */
    UserService() {}
    
    /**
     * Autowired Constructor
     *
     * @param personRepository
     */
    UserService(PersonRepository personRepository, PersonAliasRepository personAliasRepository, StaffRepository staffRepository, StudentRepository studentRepository, TutorGroupService tutorGroupService, FacultyService facultyService, DepartmentService departmentService) {
        super();
        this.personRepository = personRepository;
        this.personAliasRepository = personAliasRepository;
        this.staffRepository = staffRepository;
        this.studentRepository = studentRepository;
        this.tutorGroupService = tutorGroupService;
        this.facultyService = facultyService;
        this.departmentService = departmentService;
    }
    
    /**
     * Find an individual user using the username
     *
     * @param string the String fields to search for
     * @return the User object that matches the String supplied, or null if not found
     */
    @Transactional(readOnly = true)
    Person findUserByUsername(String username) {
        return personRepository.findByUsername(username);
    }
    
    /**
     * This method is used to build a user info map which contains the basic information about the user specified by the
     * username parameter. 
     * 
     * @param username the username to use to build the user info for.
     * @return a Map<String, Object> which contain the users info.
     */
    Map<String, Object> buildUserInfo(String username) {
        Map<String, Object> map = new LinkedHashMap<String, Object>()
        map.put("username", username);
        PersonAlias alias = personAliasRepository.findByPersonUsername(username)
        if (alias != null && alias.inUse) {
            LOGGER.info('II User: ' + username + ' - Using Alias: ' + alias.aliasUsername)
            map.put("originalUsername", username)
            map.put("aliasUsername", alias.aliasUsername)
            username = alias.aliasUsername
        }
        Person activeUser = personRepository.findByUsername(username)
        Set<String> roles = new ArrayList<String>()
        
        /* TODO: The roles are currently populated from the data base at this point but this is not the right way to get the user permissions. This 
         * will need to load the user security context and then the authorities granted to the user. This should then be using the AuthoritiesPopulator
         * rather than the database relationship to roles. The AuthoritiesPopulator also uses this relationship but also the authorities granted by the
         * authentication manager.
         */
        if (activeUser != null) {
            Staff staff = staffRepository.findByPerson(activeUser)
            Student student = studentRepository.findByPerson(activeUser)
            roles = activeUser != null && activeUser.roles != null ? activeUser.roles.collect { return 'ROLE_' + it.roleName } : null
            map.put("personId", activeUser.id)
            map.put("person", new PersonSummaryDto(activeUser))
            map.put("name", activeUser.surname + ', ' + activeUser.firstName);
            
            if (staff != null) {
                addStaffData(map, activeUser)
            }
            if (student != null) {
                addStudentData(map, activeUser)
                roles.add("ROLE_Student")
            }
            if (roles.contains("ROLE_System Admin")) {
                map.put("isAdmin", true)
            }
        } else {
            LOGGER.error("Cannot find a valid person with the username: " + username)
        }
        map.put("roles", roles);
        return map
    }
    
    void addStaffData(Map<String, Object> map, Person user) {
        if (user != null && user.staff != null) {
            Staff staff = user.staff
            map.put("staffId", staff.id)
            map.put("initials", staff.initials)
            map.put("isStaff", true)
            List<TutorGroup> tutorGroups = tutorGroupService.findByTutor(staff)
            if (tutorGroups != null && !tutorGroups.empty) {
                map.put("isTutor", true)
                //map.put("tutorGroups", TutorGroupDto.mapFromList(tutorGroups))
            }
            List<TutorGroup> seniorTutorGroups = tutorGroupService.findBySeniorTutor(staff)
            if (seniorTutorGroups != null && !seniorTutorGroups.empty) {
                map.put("isST", true)
                //map.put("seniorTutor", TutorGroupDto.mapFromList(seniorTutorGroups))
            }
            List<TutorGroup> pdTutorGroups = tutorGroupService.findByPastoralDirector(staff)
            if (pdTutorGroups != null && !pdTutorGroups.empty) {
                map.put("isPD", true)
                //map.put("pdTutorGroups", TutorGroupDto.mapFromList(pdTutorGroups))
            }
            List<Department> headOfDepartments = departmentService.findByHeadOfDepartment(staff)
            if (headOfDepartments != null && !headOfDepartments.empty) {
                map.put("isHOD", true)
                //map.put("hod", DepartmentDto.mapFromList(headOfDepartments))
            }
            List<Faculty> directorOfLearning = facultyService.findByDirectorOfLearning(staff)
            if (directorOfLearning != null && !directorOfLearning.empty) {
                map.put("isDOL", true)
                //map.put("hod", DepartmentDto.mapFromList(headOfDepartments))
            }
        }
    }
    
    void addStudentData(Map<String, Object> map, Person user) {
        if (user.student != null) {
            map.put("studentId", user.student.id)
            map.put("isStudent", true)
        }
    }
}
