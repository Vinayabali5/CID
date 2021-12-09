package uk.ac.reigate.services.ilp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import lombok.RequiredArgsConstructor
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.ilp.ILPInterview
import uk.ac.reigate.domain.ilp.Letter
import uk.ac.reigate.dto.LetterDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.repositories.ilp.LetterRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.CorrespondenceTypeService
import uk.ac.reigate.services.IAnnualDataService
import uk.ac.reigate.services.IDtoCreateUpdateService
import uk.ac.reigate.services.IStudentDataService
import uk.ac.reigate.services.LetterTypeService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentYearService

@Service
@RequiredArgsConstructor
class LetterService implements IAnnualDataService<Letter, Integer>, IStudentDataService<List<Letter>>, IDtoCreateUpdateService<LetterDto, Letter> {
    
    @Autowired
    private final LetterRepository letterRepository
    
    @Autowired
    private final StudentService studentService
    
    @Autowired
    private final StudentYearService studentYearService
    
    @Autowired
    private final LetterTypeService letterTypeService
    
    @Autowired
    private final AcademicYearService academicYearService
    
    @Autowired
    private final ILPInterviewService ilpInterviewService
    
    @Autowired
    private final CorrespondenceTypeService correspondenceTypeService
    
    @Autowired
    private final StaffService staffService
    
    @Autowired
    private final LetterWarningParagraphService letterWarningParagraphService
    
    /**
     * Default NoArgs constructor
     */
    LetterService() {}
    
    /**
     * Autowired Constructor
     *
     * @param letterRepository
     */
    LetterService(LetterRepository letterRepository, StudentService studentService, StudentYearService studentYearService, LetterTypeService letterTypeService, AcademicYearService academicYearService, ILPInterviewService ilpInterviewService, CorrespondenceTypeService correspondenceTypeService, StaffService staffService, LetterWarningParagraphService letterWarningParagraphService) {
        super()
        this.letterRepository = letterRepository;
        this.studentService = studentService;
        this.studentYearService = studentYearService;
        this.letterTypeService = letterTypeService;
        this.academicYearService = academicYearService;
        this.ilpInterviewService = ilpInterviewService;
        this.correspondenceTypeService = correspondenceTypeService;
        this.staffService = staffService;
        this.letterWarningParagraphService = letterWarningParagraphService;
    }
    
    /**
     * This method is used to find an instance of a Letter data object from the supplied ID
     *
     * @param id the ID of the Letter data object to retrieve
     * @return the Letter object that matches the ID supplied
     */
    @Transactional(readOnly = true)
    Letter findById(Integer id) {
        return letterRepository.findById(id).orElse(null)
    }
    
    /**
     * This method is used to find all Letter data objects
     * 
     * @return a List of Letter data objects
     */
    @Override
    @Transactional(readOnly = true)
    List<Letter> findAll() {
        return letterRepository.findAll();
    }
    
    /**
     * This method is used to save a complete Letter object in the database
     *
     * @param letter the Letter data object to be saved
     * @return the saved version of the Letter object
     */
    @Transactional
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasRole('Staff')")
    public Letter save(Letter letter) {
        return letterRepository.save(letter)
    }
    
    /**
     * This methods is uesd to delete a Letter data object. The Letter is first check to see if a 
     * letterDate has been set if not then the Letter is deleted. 
     */
    public void delete(Letter letter) {
        if (letter.letterDate != null) {
            throw new InvalidOperationException("Letters with a letter date should not be deleted.")
        }
        letterRepository.delete(letter)
    }
    
    /**
     * This method is used to retrieve a List of Letter data objects for a specified year.
     * 
     * @param year the AcademicYear object to use for the filter
     * @return a List of Letter objects 
     */
    @Transactional
    public List<Letter> findAllByYear(AcademicYear year) {
        return letterRepository.findByYear(year)
    }
    
    /**
     * This method is used to retrieve a List of Letter data objects for the supplied Student. 
     * 
     * @param student the Student data object to use for the search
     * @return a List of Letter data objects that match the search criteria
     */
    public List<Letter> getByStudent(Student student){
        return letterRepository.findByStudent(student);
    }
    
    /**
     * This method is used to retrieve a List of Letter data objects for the supplied Student ID.
     *  
     * @param studentId the Student ID to use for the search
     * @return a List of Letter data objects that match the search criteria
     */
    public List<Letter> getByStudentId(Integer studentId){
        return letterRepository.findByStudent_Id(studentId);
    }
    
    /**
     * This service method is used to create a Letter data object in the database from a partial or 
     * complete LetterDto object.
     *
     * @param letter the LetterDto object to use for the creation of the Letter data object.
     * @return the saved version of the Letter data object
     */
    @Transactional
    public Letter createFromDto(LetterDto letter) {
        if (letter == null) {
            throw new InvalidDataException("Cannot create letter from null object.")
        }
        AcademicYear year
        if (letter.yearId != null) {
            year = academicYearService.findById(letter.yearId)
        } else {
            year = academicYearService.getCurrentAcademicYear()
        }
        Letter letterToSave = new Letter()
        letterToSave.year = year
        Student student
        if (letter.studentId != null) {
            student = studentService.findById(letter.studentId)
            letterToSave.student = student
        }
        ILPInterview interview
        if (letter.interviewId != null) {
            interview = ilpInterviewService.findById(letter.interviewId)
            letterToSave.interview = interview
        }
        letterToSave.requestedDate = letter.requestedDate
        if (letter.letterTypeId != null) {
            letterToSave.letterType = letterTypeService.findById(letter.letterTypeId)
        }
        if (letter.authorisedDate == null) {
            letterToSave.authorisedDate = letterToSave.letterType.requireAuthorisation == false ? new Date() : null
        } else {
            letterToSave.authorisedDate = letter.authorisedDate
        }
        letterToSave.letterDate = letter.letterDate
        letterToSave.printedDate = letter.printedDate
        if (letter.writtenById != null) {
            letterToSave.writtenBy = staffService.findById(letter.writtenById)
        } else if (interview.courseGroup != null) {
            letterToSave.writtenBy = interview.courseGroup.courseLeader
        } else if (letter.requestedById != null) {
            letterToSave.writtenBy = staffService.findById(letter.requestedById)
        } else {
            letterToSave.writtenBy = null
        }
        if (letter.requestedById != null) {
            letterToSave.requestedBy = staffService.findById(letter.requestedById)
        }
        letterToSave.studentCopiedIn = letter.studentCopiedIn
        // Set the subject fields where it is not set by data input
        if (letterToSave.subject == null && interview.courseGroup != null) {
            letterToSave.subject = interview.courseGroup.course.subject.description
        } else {
            letterToSave.subject = letter.subject != null ? letter.subject : null
        }
        // Set the regarding field where it is not set by data input
        if (letter.regarding == null && student != null) {
            StudentYear studentYear = studentYearService.findByStudentAndYear(student, year)
            letterToSave.regarding = student.id + " "
            letterToSave.regarding += student.person.surname + ": " + (student.person.preferredName != null ? student.person.preferredName : student.person.firstName)
            if (studentYear != null && studentYear.tutorGroup != null) {
                letterToSave.regarding += ' ' + studentYear.tutorGroup.code
            }
        } else {
            letterToSave.regarding = letter.regarding != null ? letter.regarding : null
        }
        letterToSave.reviewMeeting = letter.reviewMeeting
        letterToSave.attendance = letter.attendance
        letterToSave.behaviour = letter.behaviour
        letterToSave.homework = letter.homework
        letterToSave.punctuality = letter.punctuality
        letterToSave.focus = letter.focus
        letterToSave.deadlines = letter.deadlines
        letterToSave.incompleteCoursework = letter.incompleteCoursework
        letterToSave.insufficientProgress = letter.insufficientProgress
        letterToSave.nonEntryWarning = letter.nonEntryWarning != null ? letterWarningParagraphService.findById(letter.nonEntryWarning) : null
        letterToSave.irWillAddress = letter.irWillAddress
        letterToSave.irImproveAttendance = letter.irImproveAttendance
        letterToSave.irImproveEffort = letter.irImproveEffort
        
        if (letter.correspondenceTypeId != null) {
            letterToSave.correspondenceType = correspondenceTypeService.findById(letter.correspondenceTypeId)
        }
        if (letter.pendingId != null) {
            letterToSave.pending = staffService.findById(letter.pendingId)
        }
        letterToSave.sendAfter = letter.sendAfter
        letterToSave.processingFlag = letter.processingFlag
        return save(letterToSave)
    }
    
    /**
     * This service method is used to update a Letter data object in the database from a partial or 
     * complete LetterDto object.
     *
     * @param letter the LetterDto object to use for the update
     * @return the saved version of the Letter data object
     * @throws InvalidDataException thrown if the supplied LetterDto object does not have an ID field set. 
     * @throws NotFoundException throw if a letter with the supplied ID cannot be found in the database.
     */
    @Transactional
    public Letter updateFromDto(LetterDto letter) throws InvalidDataException, NotFoundException {
        if (letter != null) {
            if(letter.id == null) {
                throw new InvalidDataException("Cannot update a letter when no ID field is supplied.")
            }
            Letter letterToSave = findById(letter.id)
            AcademicYear year
            if(letter.yearId != null) {
                letterToSave.year = academicYearService.findById(letter.yearId)
            }
            Student student
            if(letter.studentId != null) {
                letterToSave.student = studentService.findById(letter.studentId)
            }
            letterToSave.interview = letter.interviewId != null ? ilpInterviewService.updateFromDto(letter.interview) : null
            letterToSave.writtenBy = letter.writtenById  != null ? staffService.findById(letter.writtenById) : null
            letterToSave.requestedBy = letter.requestedById != null ? staffService.findById(letter.requestedById) : null
            letterToSave.letterType = letter.letterTypeId != null ? letterTypeService.findById(letter.letterTypeId) : null
            letterToSave.correspondenceType = letter.correspondenceTypeId != null ? correspondenceTypeService.findById(letter.correspondenceTypeId) : null
            letterToSave.pending = letter.pendingId != null ? staffService.findById(letter.pendingId) : null
            letterToSave.requestedDate = letter.requestedDate
            letterToSave.authorisedDate = letter.authorisedDate
            letterToSave.letterDate = letter.letterDate
            letterToSave.printedDate = letter.printedDate
            letterToSave.studentCopiedIn = letter.studentCopiedIn
            letterToSave.subject = letter.subject
            letterToSave.regarding = letter.regarding
            letterToSave.reviewMeeting = letter.reviewMeeting
            letterToSave.attendance = letter.attendance
            letterToSave.behaviour = letter.behaviour
            letterToSave.homework = letter.homework
            letterToSave.punctuality = letter.punctuality
            letterToSave.focus = letter.focus
            letterToSave.deadlines = letter.deadlines
            letterToSave.incompleteCoursework = letter.incompleteCoursework
            letterToSave.insufficientProgress = letter.insufficientProgress
            letterToSave.nonEntryWarning = letter.nonEntryWarning != null ? letterWarningParagraphService.findById(letter.nonEntryWarning) : null
            letterToSave.irWillAddress = letter.irWillAddress
            letterToSave.irImproveAttendance = letter.irImproveAttendance
            letterToSave.irImproveEffort = letter.irImproveEffort
            letterToSave.sendAfter = letter.sendAfter
            letterToSave.processingFlag = letter.processingFlag
            return save(letterToSave)
        } else {
            return null
        }
    }
    
    /**
     * This method is used to retrieve a List of Letter data objects for a specified year 
     * with a specific processing flag value set.
     * 
     * @param year the AcademicYear object to use for the filter
     * @param processingFlag the processing flag to use for the filter
     * @return a List of Letter objects 
     */
    @Transactional
    public List<Letter> findByAcdemicYearAndProcessingFlag(AcademicYear year, Integer processingFlag) {
        return letterRepository.findByYearAndProcessingFlag(year, processingFlag)
    }
    
    /**
     * This method is used to retrieve a List of Letter data objects for a specific year that have been  
     * authorised by the Course Leaders. This means that the Authorised date has been set and the 
     * processing flag is marked as 0 (zero - not processed yet).
     * 
     * @param year the AcademicYear to search for letter for
     * @return a List of Letter data objects that match the search criteria
     */
    @Transactional
    public List<Letter> findAuthorisedByAcdemicYear(AcademicYear year) {
        return letterRepository.findByYearAndRequestedDateIsNotNullAndAuthorisedDateIsNotNullAndProcessingFlagIs(year, 0)
    }
    
    /**
     * This method is used to retrieve a List of Letter data objects for a specific year that have been
     * authorised by the Course Leaders. This means that the Authorised date has been set and the
     * processing flag is marked as 1 (ready to process).
     *
     * @param year the AcademicYear to search for letter for
     * @return a List of Letter data objects that match the search criteria
     */
    @Transactional
    public List<Letter> findGoingTonightByAcdemicYear(AcademicYear year) {
        return letterRepository.findByYearAndRequestedDateIsNotNullAndAuthorisedDateIsNotNullAndProcessingFlagIs(year, 1)
    }
    
    @Transactional
    public List<Letter> findAuthorisedByAcdemicYearAndProcessingFlag(AcademicYear year, Integer processingFlag) {
        return letterRepository.findByYearAndRequestedDateIsNotNullAndAuthorisedDateIsNotNullAndLetterDateIsNullAndPrintedDateIsNullAndProcessingFlagIs(year, processingFlag)
    }
    
    /**
     * Saves a list of Letter objects to the database
     *
     * @param letters a list of Letters to be saved to the database
     * @return the list of save Letter objects
     */
    @Transactional
    public List<Letter> saveLetters(List<Letter> letters) {
        return letters.collect { letter -> save(letter) };
    }
    
    public void delete(Integer id) {
        letterRepository.deleteById(id)
    }
}
