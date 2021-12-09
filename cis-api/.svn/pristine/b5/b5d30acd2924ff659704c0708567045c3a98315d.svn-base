package uk.ac.reigate.services

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.admissions.Request
import uk.ac.reigate.dto.RequestDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.predicates.CoursePredicates
import uk.ac.reigate.repositories.academic.CourseRepository
import uk.ac.reigate.repositories.admissions.RequestRepository
import uk.ac.reigate.repositories.lookup.LevelRepository
import uk.ac.reigate.repositories.lookup.SubjectRepository
import uk.ac.reigate.services.student.StudentService

@Service
class RequestService implements ICoreDataService<Request, Integer>{
    
    @Autowired
    RequestRepository requestRepository
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    StudentService studentService
    
    @Autowired
    SubjectRepository subjectRepository
    
    @Autowired
    LevelRepository levelRepository
    
    @Autowired
    CourseRepository courseRepository
    /**
     * Default NoArgs constructor
     */
    RequestService() {}
    
    /**
     * Autowired Constructor
     *
     * @param requestRepository
     */
    RequestService(RequestRepository requestRepository, AcademicYearService academicYearService, StudentService studentService, SubjectRepository subjectRepository, LevelRepository levelRepository, CourseRepository courseRepository) {
        super();
        this.requestRepository = requestRepository;
        this.academicYearService= academicYearService;
        this.studentService = studentService;
        this.subjectRepository = subjectRepository
        this.levelRepository = levelRepository
        this.courseRepository = courseRepository
    }
    
    /**
     * Find an individual request using the requests ID fields
     *
     * @param id the ID fields to search for
     * @return the Request object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Request findById(Integer id) {
        return requestRepository.findById(id).orElse(null)
    }
    
    @Transactional(readOnly = true)
    Request findByStudent_IdAndRequestAndAcademicYear(Integer id, String request, AcademicYear academicYear) {
        return requestRepository.findByStudent_IdAndRequestAndAcademicYear(id, request, academicYear)
    }
    /**
     * Find all requests
     *
     * @return a SearchResult set with the list of Requests
     */
    @Override
    @Transactional(readOnly = true)
    List<Request> findAll() {
        return requestRepository.findAll();
    }
    
    String getCourseDescription(Integer academicYearId, String requestCode) {
        String description = ""
        if (requestCode.size() == 5) {
            List<Course> courses = courseRepository.findAll(CoursePredicates.courseValidInYear(academicYearId).and(CoursePredicates.courseSpecIs(requestCode.substring(2,5))))
            if (courses.size() == 0) {
                description = "Invalid course"
            } else {
                description = courses[0].getDescription()
            }
        } else {
            description += 'Request Invalid Format'
        }
        return description
    }
    
    /**
     * This service method is used to save a complete Request object in the database
     *
     * @param request the new Request object to be saved
     * @return the saved version of the Request object
     */
    @PreAuthorize("@securityChecker.checkWriter(authentication) or hasRole('Service User')")
    @Override
    @Transactional
    public Request save(Request request) {
        return requestRepository.save(request)
    }
    
    /**
     * This service method is used to create a Request object in the database from a partial or complete Request object.
     *
     * @param request the partial or complete Request object to be saved
     * @return the saved version of the Request object
     */
    @Transactional
    public Request createFromDto(RequestDto requestDto) {
        if (requestDto == null) {
            throw new InvalidDataException("Cannot create requestDto from null object.")
        }
        Request request = new Request()
        if (requestDto.studentId != null) {
            request.student = studentService.findById(requestDto.studentId)
        }
        if (requestDto.academicYearId != null) {
            request.academicYear = academicYearService.findById(requestDto.academicYearId)
        }
        request.request = requestDto.request;
        request.coreAim = requestDto.coreAim;
        request.broadeningSubject = requestDto.broadeningSubject;
        request.chosenAgainstAdvice = requestDto.chosenAgainstAdvice;
        request.allocated = requestDto.allocated;
        return save(request)
    }
    
    /**
     * This service method is used to update a Request object in the database from a partial or complete Request object.
     *
     * @param request the partial or complete Request object to be saved
     * @return the saved version of the Request object
     */
    @Transactional
    public Request updateFromDto(RequestDto requestDto) {
        if (requestDto == null) {
            throw new InvalidDataException("Cannot update requestDto from null object.")
        }
        Request request = findById(requestDto.id)
        if (requestDto.studentId != null) {
            request.student = studentService.findById(requestDto.studentId)
        }
        if (requestDto.academicYearId != null) {
            request.academicYear = academicYearService.findById(requestDto.academicYearId)
        }
        request.request = requestDto.request;
        request.coreAim = requestDto.coreAim;
        request.broadeningSubject = requestDto.broadeningSubject;
        request.chosenAgainstAdvice = requestDto.chosenAgainstAdvice;
        request.allocated = requestDto.allocated;
        return save(request)
    }
    
    /**
     * This service method is used to retrieve a list of requests for a specified student based on the provided studentId
     * 
     * @param studentId the studentId to use as a filter
     * @return a filtered list of request for the specified student
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    @Transactional(readOnly = true)
    List<Request> findRequestsByStudentId(Integer studentId) {
        List<Request> requests = requestRepository.findByStudent_Id(studentId);
        return requests
    }
    
    /**
     * @param year
     * @return List of Request by Year
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Request> searchByYear(AcademicYear year) {
        List<Request> requests = requestRepository.findByAcademicYear(year)
        return requests
    }
    
    /**
     * @param academicYearId
     * @param studentId
     * @return  List of Request by Year and Student
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Request> searchByYearAndStudentId(Integer academicYearId, Integer studentId){
        List<Request> requests = requestRepository.findByAcademicYear_IdAndStudent_Id(academicYearId, studentId)
    }
    
    /**
     * @param studentId
     * @param yearId
     * @return List of Request by YearId and StudentId
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Request> findByStudentIdYearId(Integer studentId, Integer yearId){
        return  requestRepository.findByStudent_IdAndAcademicYear_Id(studentId, yearId)
    }
    
    /**
     * @param studentId
     * @return List of Request
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Request> findByStudentId(Integer studentId){
        List<Request> requests = requestRepository.findByStudent_Id(studentId)
    }
    
    /**
     * This service method is used to delete a complete Request object in the database
     *
     * @param requestId the object to be deleted
     */
    @Transactional
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    public void delete(Integer requestId){
        requestRepository.deleteById(requestId)
    }
    /**
     * This methods throws an InvalidOperationException when called. Request should not be deleted.
     */
    @Override
    public void delete(Request obj) {
        throw new InvalidOperationException("Request should not be deleted")
    }
    
}
