package uk.ac.reigate.services.schoolimport

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.lookup.TutorGroup
import uk.ac.reigate.domain.Room;
import uk.ac.reigate.domain.Staff;
import uk.ac.reigate.domain.academic.Faculty
import uk.ac.reigate.model.PageInfo
import uk.ac.reigate.model.SearchResult
import uk.ac.reigate.repositories.lookup.TutorGroupRepository
import uk.ac.reigate.utils.ValidationUtils;
import uk.ac.reigate.repositories.academic.FacultyRepository

@Service
class TutorGroupService {
    
    @Autowired
    TutorGroupRepository tutorGroupRepository
    
    @Autowired
    FacultyRepository facultyRepository
    
    /**
     * Default NoArgs constructor
     */
    TutorGroupService() {}
    
    /**
     * Autowired Constructor
     *
     * @param tutorGroupRepository
     */
    TutorGroupService(TutorGroupRepository tutorGroupRepository) {
        this.tutorGroupRepository = tutorGroupRepository;
    }
    
    /**
     * Find an individual tutorGroup using the tutorGroups ID fields
     *
     * @param id the ID fields to search for
     * @return the TutorGroup object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    TutorGroup findTutorGroup(Integer id) {
        return tutorGroupRepository.findOne(id);
    }
    
    /**
     * Find all tutorGroups
     *
     * @return a SearchResult set with the list of TutorGroups
     */
    @Transactional(readOnly = true)
    SearchResult<TutorGroup> findTutorGroup() {
        List<TutorGroup> tutorGroups = tutorGroupRepository.findAll();
        int resultsCount = tutorGroups.size()
        return new SearchResult<>(resultsCount, tutorGroups);
    }
    
    @Transactional
    public TutorGroup saveTutorGroup(Integer id, String code, String description, Faculty faculty, Staff tutor, Staff seniorTutor, Room room) {
        ValidationUtils.assertNotBlank(code, "code cannot be blank");
        ValidationUtils.assertNotNull(description, "description is mandatory");
        ValidationUtils.assertNotNull(faculty, "faculty is mandatory");
        TutorGroup tutorGroup = null;
        if (id != null) {
            tutorGroup = tutorGroupRepository.findOne(id);
            tutorGroup.setCode(code);
            tutorGroup.setDescription(description);
            tutorGroup.setFaculty(faculty);
			tutorGroup.setTutor(tutor);
			tutorGroup.setSeniorTutor(seniorTutor);
			tutorGroup.setRoom(room);
            tutorGroupRepository.save(tutorGroup);
        } else {
            tutorGroup = tutorGroupRepository.save(new TutorGroup(code, description, faculty, tutor, seniorTutor, room));
        }
        return tutorGroup;
    }
    
    /**
     * This service method is used to save a complete TutorGroup object in the database
     *
     * @param tutorGroup the new TutorGroup object to be saved
     * @return the saved version of the TutorGroup object
     */
    @Transactional
    public TutorGroup saveTutorGroup(TutorGroup tutorGroup) {
        return tutorGroupRepository.save(tutorGroup)
    }
    
    /**
     * Saves a list of TutorGroup objects to the database
     *
     * @param tutorGroups a list of TutorGroups to be saved to the database
     * @return the list of save TutorGroup objects
     */
    @Transactional
    public List<TutorGroup> saveTutorGroups(List<TutorGroup> tutorGroups) {
        return tutorGroups.collect { tutorGroup -> saveTutorGroup( tutorGroup ) };
    }
    
}
