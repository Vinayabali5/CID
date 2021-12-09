package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Department
import uk.ac.reigate.domain.academic.Faculty
import uk.ac.reigate.dto.DepartmentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.StaffRepository
import uk.ac.reigate.repositories.academic.DepartmentRepository
import uk.ac.reigate.repositories.academic.FacultyRepository

@Service
class DepartmentService implements ICoreDataService<Department, Integer>, IDtoCreateUpdateService<DepartmentDto, Department> {
    
    @Autowired
    DepartmentRepository departmentRepository
    
    @Autowired
    private final FacultyService facultyService;
    
    @Autowired
    private final StaffService staffService;
    
    /**
     * Default NoArgs constructor
     */
    DepartmentService() {}
    
    /**
     * Autowired Constructor
     *
     * @param departmentRepository
     */
    DepartmentService(DepartmentRepository departmentRepository, FacultyService facultyService, StaffService staffService) {
        super();
        this.departmentRepository = departmentRepository;
        this.facultyService = facultyService;
        this.staffService = staffService;
    }
    
    /**
     * Find an individual department using the departments ID fields
     *
     * @param id the ID fields to search for
     * @return the Department object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Department findById(Integer id) {
        return departmentRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all departments
     *
     * @return a SearchResult set with the list of Departments
     */
    @Override
    @Transactional(readOnly = true)
    List<Department> findAll() {
        return departmentRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Department object in the database
     *
     * @param department the new Department object to be saved
     * @return the saved version of the Department object
     */
    @Override
    @Transactional
    public Department save(Department department) {
        return departmentRepository.save(department)
    }
    
    /**
     * Saves a list of Department objects to the database
     *
     * @param departments a list of Departments to be saved to the database
     * @return the list of save Department objects
     */
    @Transactional
    public List<Department> saveDepartments(List<Department> departments) {
        return departments.collect { department -> save(department) };
    }
    
    /**
     * This service method is used to create a Department object in the database from a partial or complete Department object.
     *
     * @param department the partial or complete Department object to be saved
     * @return the saved version of the Department object
     */
    @Transactional
    public Department createFromDto(DepartmentDto departmentDto) {
        if (departmentDto == null) {
            throw new InvalidDataException("Cannot create departmentDto from null object.")
        }
        Department department = new Department()
        department.name = departmentDto.name
        department.description = departmentDto.description
        if(departmentDto.facultyId != null) {
            department.faculty = facultyService.findById(departmentDto.facultyId)
        }
        if(departmentDto.hodId != null){
            department.hod = staffService.findById(departmentDto.hodId)
        }
        if(departmentDto.hod2Id != null){
            department.hod2 = staffService.findById(departmentDto.hod2Id)
        }
        department.academic = departmentDto.academic;
        return save(department)
    }
    
    /**
     * This service method is used to update a Department object in the database from a partial or complete Department object.
     *
     * @param department the partial or complete Department object to be saved
     * @return the saved version of the Department object
     */
    @Transactional
    public Department updateFromDto(DepartmentDto departmentDto) {
        if(departmentDto.id == null) {
            throw new InvalidDataException("Cannot update Department from null object.")
        }
        Department department = findById(departmentDto.id)
        if(departmentDto.facultyId != null) {
            department.faculty = facultyService.findById(departmentDto.facultyId)
        }
        if(departmentDto.hodId != null){
            department.hod = staffService.findById(departmentDto.hodId)
        }
        if(departmentDto.hod2Id != null){
            department.hod2 = staffService.findById(departmentDto.hod2Id)
        }
        department.name = departmentDto.name
        department.description = departmentDto.description
        department.academic = departmentDto.academic;
        return save(department)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Department should not be deleted.
     */
    @Override
    public void delete(Department obj) {
        throw new InvalidOperationException("Department should not be deleted")
    }
    
    /**
     * This method is used to retrieve a List of Department data objects for the supplied Faculty id.
     * 
     * @param facultyId the Faculty id to use for the search
     * @return a List of Department data objects
     */
    List<Department> findByfacultyId(Integer facultyId){
        return departmentRepository.findByFaculty_Id(facultyId)
    }
    
    /**
     * This method is used to retrieve a List of Department data objects where the supplied member of Staff is either the
     * Head of Department (hod) or the Head of Department 2 (hod2).
     *  
     * @param hod the Staff data object ot use for the search
     * @return a List of Department data objects 
     */
    List<Department> findByHeadOfDepartment(Staff hod) {
        return departmentRepository.findByHodOrHod2(hod, hod)
    }
}
