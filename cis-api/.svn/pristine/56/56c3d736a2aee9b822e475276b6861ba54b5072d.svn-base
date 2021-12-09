package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.School
import uk.ac.reigate.dto.SchoolDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.SchoolRepository
import uk.ac.reigate.services.lookup.SchoolTypeService


@Service
class SchoolService implements ICoreDataService<School, Integer>, IDtoCreateUpdateService<SchoolDto, School>{
    
    @Autowired
    SchoolRepository schoolRepository
    
    @Autowired
    private final SchoolTypeService schoolTypeService
    
    @Autowired
    private final SchoolPriorityService schoolPriorityService
    
    /**
     * Default NoArgs constructor
     */
    SchoolService() {}
    
    /**
     * Autowired Constructor
     *
     * @param schoolRepository
     */
    SchoolService(SchoolRepository schoolRepository, SchoolTypeService schoolTypeService, SchoolPriorityService schoolPriorityService) {
        this.schoolRepository = schoolRepository;
        this.schoolTypeService = schoolTypeService;
        this.schoolPriorityService = schoolPriorityService;
    }
    
    /**
     * Find an individual school using the schools ID fields
     *
     * @param id the ID fields to search for
     * @return the School object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    School findById(Integer id) {
        return schoolRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all schools
     *
     * @return a List<School> set with the list of Schools
     */
    @Override
    @Transactional(readOnly = true)
    List<School> findAll() {
        return schoolRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete School object in the database
     *
     * @param school the new School object to be saved
     * @return the saved version of the School object
     */
    @Override
    @Transactional
    public School save(School school) {
        return schoolRepository.save(school)
    }
    
    /**
     * Saves a list of School objects to the database
     *
     * @param schools a list of Schools to be saved to the database
     * @return the list of save School objects
     */
    @Transactional
    public List<School> saveSchools(List<School> schools) {
        return schools.collect { school -> save( school ) };
    }
    
    /**
     * This method is used to create a School object in the database from a partial or complete School object.
     * 
     * @param School the partial or completed School object to be saved
     * @return the saved version of the School object.
     */
    @Transactional
    public School createFromDto(SchoolDto schoolDto) {
        if (schoolDto == null) {
            throw new InvalidDataException("Cannot create schoolDto from null object.")
        }
        School school = new School()
        school.name = schoolDto.name;
        if(schoolDto.typeId != null) {
            school.type = schoolTypeService.findById(schoolDto.typeId)
        }
        if(schoolDto.priorityId != null) {
            school.priority = schoolPriorityService.findById(schoolDto.priorityId)
        }
        school.urn = schoolDto.urn;
        school.line1 = schoolDto.line1;
        school.line2 = schoolDto.line2;
        school.line3 = schoolDto.line3;
        school.postcode = schoolDto.postcode;
        school.telephone = schoolDto.telephone;
        school.headTitle = schoolDto.headTitle;
        school.headFirstName = schoolDto.headFirstName;
        school.headSurname = schoolDto.headSurname;
        school.contactTitle = schoolDto.contactTitle;
        school.contactFirstName = schoolDto.contactFirstName;
        school.contactSurname = schoolDto.contactSurname;
        school.contactEmail = schoolDto.contactEmail;
        school.useInOnlineApplications = schoolDto.useInOnlineApplications;
        return save(school)
    }
    
    /**
     * This method is used to update a School object in the database from a partial or complete School object.
     *
     * @param School the partial or completed School object to be saved
     * @return the saved version of the School object.
     */
    @Transactional
    public School updateFromDto(SchoolDto schoolDto) {
        if (schoolDto == null) {
            throw new InvalidDataException("Cannot update schoolDto from null object.")
        }
        School school = findById(schoolDto.id)
        if(schoolDto.typeId != null) {
            school.type = schoolTypeService.findById(schoolDto.typeId)
        }
        if(schoolDto.priorityId != null) {
            school.priority = schoolPriorityService.findById(schoolDto.priorityId)
        } else {
            school.priority = null
        }
        school.name = schoolDto.name;
        school.urn = schoolDto.urn;
        school.line1 = schoolDto.line1;
        school.line2 = schoolDto.line2;
        school.line3 = schoolDto.line3;
        school.postcode = schoolDto.postcode;
        school.telephone = schoolDto.telephone;
        school.headTitle = schoolDto.headTitle;
        school.headFirstName = schoolDto.headFirstName;
        school.headSurname = schoolDto.headSurname;
        school.contactTitle = schoolDto.contactTitle;
        school.contactFirstName = schoolDto.contactFirstName;
        school.contactSurname = schoolDto.contactSurname;
        school.contactEmail = schoolDto.contactEmail;
        school.useInOnlineApplications = schoolDto.useInOnlineApplications;
        return save(school)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. QualificationAssessment should not be deleted.
     */
    @Override
    public void delete(School obj) {
        throw new InvalidOperationException("School should not be deleted")
    }
    
    /**
     * This method is used to retrieve a School object from the schools name.
     * 
     * @param name The name of the school to search for.
     * @return A School object matching the name supplied.
     */
    public School findByName(String name) {
        return schoolRepository.findByName(name)
    }
    
    /**
     * This method is used to retrieve a school by it URN (Unique Reference Number).
     * 
     * @param urn The URN to use to perform the search.
     * @return A School object that match the URN supplied.
     */
    public School findByUrn(String urn) {
        return schoolRepository.findByUrn(urn)
    }
    
    /**
     * This method is used to retrieve a school by its UKPRN (UK Provider Reference Number).
     * 
     * @param ukprn The URN to use to perform the search.
     * @return A School object that match the UKPRN supplied.
     */
    public School findByUkprn(String ukprn) {
        return schoolRepository.findByUkprn(ukprn)
    }
}
