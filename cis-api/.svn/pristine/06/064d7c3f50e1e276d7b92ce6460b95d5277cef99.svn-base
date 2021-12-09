package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import lombok.RequiredArgsConstructor
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.Faculty
import uk.ac.reigate.dto.FacultyDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.FacultyRepository

@Service
@RequiredArgsConstructor
class FacultyService implements ICoreDataService<Faculty, Integer>, IDtoCreateUpdateService<FacultyDto, Faculty> {
    
    @Autowired
    FacultyRepository facultyRepository
    
    @Autowired
    private final StaffService staffService;
    
    @Autowired
    private final DepartmentService departmentService;
    
    /**
     * Default NoArgs constructor
     */
    FacultyService() {}
    
    /**
     * Autowired Constructor
     *
     * @param facultyRepository
     */
    FacultyService(FacultyRepository facultyRepository, StaffService staffService, DepartmentService departmentService) {
        super();
        this.facultyRepository = facultyRepository;
        this.staffService = staffService;
        this.departmentService = departmentService;
    }
    
    /**
     * Find an individual faculty using the faculties ID fields
     *
     * @param id the ID fields to search for
     * @return the Faculty object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Faculty findById(Integer id) {
        return facultyRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all faculties
     *
     * @return a SearchResult set with the list of Faculties
     */
    @Override
    @Transactional(readOnly = true)
    List<Faculty> findAll() {
        return facultyRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Faculty object in the database
     *
     * @param faculty the new Faculty object to be saved
     * @return the saved version of the Faculty object
     */
    @Override
    @Transactional
    public Faculty save(Faculty faculty) {
        return facultyRepository.save(faculty)
    }
    
    /**
     * Saves a list of Faculty objects to the database
     *
     * @param faculties a list of Faculties to be saved to the database
     * @return the list of save Faculty objects
     */
    @Transactional
    public List<Faculty> saveFaculties(List<Faculty> faculties) {
        return faculties.collect { faculty -> save(faculty) };
    }
    
    /**
     * This service method is used to create an Faculty object in the database from a partial or complete Faculty object.
     *
     * @param faculty the partial or complete Faculty object to be saved
     * @return the saved version of the Faculty object
     */
    @Transactional
    public Faculty createFromDto(FacultyDto facultyDto) {
        if (facultyDto == null) {
            throw new InvalidDataException("Cannot create facultyDto from null object.")
        }
        Staff hof
        if(facultyDto.hofId != null) {
            hof = staffService.findById(facultyDto.hofId)
        }
        Staff dol
        if(facultyDto.dolId != null) {
            dol = staffService.findById(facultyDto.dolId)
        }
        Staff adol
        if(facultyDto.adolId != null) {
            adol = staffService.findById(facultyDto.adolId)
        }
        Staff pd
        if(facultyDto.pdId != null) {
            pd = staffService.findById(facultyDto.pdId)
        }
        Staff apd
        if(facultyDto.apdId != null) {
            apd = staffService.findById(facultyDto.apdId)
        }
        Faculty faculty = new Faculty()
        faculty.code = facultyDto.code;
        faculty.description = facultyDto.description;
        faculty.hof = hof
        faculty.dol = dol
        faculty.adol = adol
        faculty.pd = pd
        faculty.apd = apd
        faculty.validFrom = facultyDto.validFrom
        faculty.validTo = facultyDto.validTo
        return save(faculty)
    }
    
    /**
     * This service method is used to create an Faculty object in the database from a partial or complete Faculty object.
     *
     * @param faculty the partial or complete Faculty object to be saved
     * @return the saved version of the Faculty object
     */
    @Transactional
    public Faculty updateFromDto(FacultyDto facultyDto) {
        if (facultyDto == null) {
            throw new InvalidDataException("Cannot update facultyDto from null object.")
        }
        Faculty faculty = findById(facultyDto.id)
        Staff hof
        if(facultyDto.hofId != null) {
            faculty.hof = staffService.findById(facultyDto.hofId)
        }
        Staff dol
        if(facultyDto.dolId != null) {
            faculty.dol = staffService.findById(facultyDto.dolId)
        }
        Staff adol
        if(facultyDto.adolId != null) {
            faculty.adol = staffService.findById(facultyDto.adolId)
        }
        Staff pd
        if(facultyDto.pdId != null) {
            faculty.pd = staffService.findById(facultyDto.pdId)
        }
        Staff apd
        if(facultyDto.apdId != null) {
            faculty.apd = staffService.findById(facultyDto.apdId)
        }
        faculty.code = facultyDto.code;
        faculty.description = facultyDto.description;
        faculty.validFrom = facultyDto.validFrom
        faculty.validTo = facultyDto.validTo
        return save(faculty)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Faculty should not be deleted.
     */
    @Override
    public void delete(Faculty obj) {
        throw new InvalidOperationException("Faculty should not be deleted")
    }
    
    /**
     * This method is used to retrieve a List of Faculty data objects where the supplied member of Staff is the Head of 
     * Faculty (hof)
     *     
     * @param hof the member of Staff to use for the search
     * @return a List of Faculty data objects
     */
    List<Faculty> findByHeadOfFaculty(Staff hof) {
        return facultyRepository.findByHof(hof)
    }
    
    /**
     * Alias method for findByHeadOfFaculty
     * @see {@link #findByHeadOfFaculty}
     */
    List<Faculty> findByHof(Staff hof) {
        return findByHeadOfFaculty(hof)
    }
    
    /**
     * This method is used to retrieve a List of Faculty data objects where the supplied member of Staff is the Director of 
     * Learning (dol)
     *
     * @param dol the member of Staff to use for the search
     * @return a List of Faculty data objects
     */
    List<Faculty> findByDirectorOfLearning(Staff dol) {
        return facultyRepository.findByDol(dol)
    }
    
    /**
     * Alias method for findByDirectorOfLearning
     * @see {@link #findByDirectorOfLearning}
     */
    List<Faculty> findByDol(Staff dol) {
        return findByDirectorOfLearning(dol)
    }
    
    /**
     * This method is used to retrieve a List of Faculty data objects where the supplied member of Staff is the Associate Director 
     * Of Learning (adol)
     *
     * @param adol the member of Staff to use for the search
     * @return a List of Faculty data objects
     */
    List<Faculty> findByAssociateDirectorOfLearning(Staff adol) {
        return facultyRepository.findByAdol(adol)
    }
    
    /**
     * Alias method for findByAssociateDirectorOfLearning
     * @see {@link #findByAssociateDirectorOfLearning}
     */
    List<Faculty> findByAdol(Staff adol) {
        return findByAssociateDirectorOfLearning(adol)
    }
    
    /**
     * This method is used to retrieve a List of Faculty data objects where the supplied member of Staff is the Pastoral Director (pd)
     *
     * @param pd the member of Staff to use for the search
     * @return a List of Faculty data objects
     */
    List<Faculty> findByPastoralDirector(Staff pd) {
        return facultyRepository.findByPd(pd)
    }
    
    /**
     * Alias method for findByPastoralDirector
     * @see {@link #findByPastoralDirector}
     */
    List<Faculty> findByPd(Staff pd) {
        return findByPastoralDirector(pd)
    }
    
    /**
     * This method is used to retrieve a List of Faculty data objects where the supplied member of Staff is the Associate 
     * Pastoral Director (apd)
     * 
     * @param apd the member of Staff to use for the search
     * @return a List of Faculty data objects
     */
    List<Faculty> findByAssociatePastroalDirector(Staff apd) {
        return facultyRepository.findByApd(apd)
    }
    
    /**
     * Alias method for findByAssociatePastroalDirector
     * @see {@link #findByAssociatePastroalDirector}
     */
    List<Faculty> findByApd(Staff apd) {
        return findByAssociatePastroalDirector(apd)
    }
}