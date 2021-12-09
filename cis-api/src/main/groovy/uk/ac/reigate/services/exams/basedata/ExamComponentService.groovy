package uk.ac.reigate.services.exams.basedata

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.dto.exams.basedata.ExamComponentDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.model.PageInfo
import uk.ac.reigate.model.SearchResult
import uk.ac.reigate.repositories.exams.basedata.ExamComponentRepository
import uk.ac.reigate.repositories.exams.basedata.ExamSeriesRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.util.exception.BadRequestException
import uk.ac.reigate.utils.ValidationUtils;;

@Service
public class ExamComponentService implements ICoreDataService<ExamComponent, Integer>{
    
    @Autowired
    ExamComponentRepository examComponentRepository
    
    @Autowired
    ExamSeriesService examSeriesService
    
    /**
     * Default NoArgs constructor
     */
    ExamComponentService() {}
    
    /**
     * Autowired constructor
     * 
     * @param examComponentRepository
     */
    ExamComponentService(ExamComponentRepository examComponentRepository, ExamSeriesService examSeriesService) {
        this.examComponentRepository = examComponentRepository;
        this.examSeriesService = examSeriesService;
    }
    
    /**
     * Find an individual exam basedata ExamComponent by examComponentId
     * 
     * @param examComponentId - the ID to search for
     * @return ExamComponent - the ExamComponent object that matches the ID, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    public ExamComponent findById(Integer examComponentId) {
        return examComponentRepository.findById(examComponentId).orElse(null)
    }
    
    /**
     * Find all ExamComponent objects
     *         
     * @return a SearchResult set with the list of ExamComponents
     */
    @Override
    @Transactional(readOnly = true)
    public List<ExamComponent> findAll() {
        return examComponentRepository.findAll();
    }
    
    /**
     * This method is used to retrieve the ExamComponent by ExamSeries object and code.
     *
     * @return the examComponent object that matches the object and code supplied.
     */
    public ExamComponent findByExamSeriesAndCode(ExamSeries examSeries, String code) {
        return examComponentRepository.findByExamSeriesAndCode(examSeries, code)
    }
    
    /**
     * Find ExamComponents by a specific timetabledDate and timetabledSession
     * 
     * @param timetableDate
     * @param timetableSession
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<ExamComponent> findExamComponentsByDateAndSession(Date timetableDate, String timetableSession) {
        return examComponentRepository.findByTimetableDateAndTimetableSession(timetableDate, timetableSession)
    }
    
    /**
     * Save an ExamComponent object to the database
     *     
     * @param examComponent - the ExamComponent object to save
     * @return the saved ExamComponent object
     */
    @Override
    public ExamComponent save(ExamComponent examComponent) {
        return examComponentRepository.save(examComponent)
    }
    
    
    
    /**
     * This service method is used to update the ExamComponent object in the database from a partial or complete ExamComponent object.
     * 
     * @param examComponent
     * @return the saved version of the ExamComponent
     */
    public ExamComponent createFromDto(ExamComponentDto examComponentDto) {
        if(examComponentDto == null) {
            throw new InvalidDataException("Cannot create ExamComponent from null object.")
        }
        ExamComponent examComponent = new ExamComponent()
        if(examComponentDto.examSeriesId != null) {
            examComponent.examSeries = examSeriesService.findById(examComponentDto.examSeriesId)
        }
        examComponent.code = examComponentDto.code
        examComponent.title = examComponentDto.title
        examComponent.teacherMarks = examComponentDto.teacherMarks
        examComponent.maximumMark = examComponentDto.maximumMark
        examComponent.gradeset = examComponentDto.gradeset
        examComponent.dueDate = examComponentDto.dueDate
        examComponent.timetabled = examComponentDto.timetabled
        examComponent.timetableDate = examComponentDto.timetableDate
        examComponent.timetableSession = examComponentDto.timetableSession
        examComponent.timeAllowed = examComponentDto.timeAllowed
        return save(examComponent);
    }
    
    /**
     * This service method is used to update the ExamComponent object in the database from a partial or complete ExamComponent object.
     * 
     * @param examComponent
     * @return the saved version of the ExamComponent
     */
    public ExamComponent updateFromDto(ExamComponentDto examComponentDto) {
        if(examComponentDto.id == null) {
            throw new InvalidDataException("Cannot update ExamComponent from null object.")
        }
        ExamComponent examComponent = findById(examComponentDto.id)
        if(examComponentDto.examSeriesId != null) {
            examComponent.examSeries = examSeriesService.findById(examComponentDto.examSeriesId)
        }
        examComponent.code = examComponentDto.code
        examComponent.title = examComponentDto.title
        examComponent.teacherMarks = examComponentDto.teacherMarks
        examComponent.maximumMark = examComponentDto.maximumMark
        examComponent.gradeset = examComponentDto.gradeset
        examComponent.dueDate = examComponentDto.dueDate
        examComponent.timetabled = examComponentDto.timetabled
        examComponent.timetableDate = examComponentDto.timetableDate
        examComponent.timetableSession = examComponentDto.timetableSession
        examComponent.timeAllowed = examComponentDto.timeAllowed
        return save(examComponent);
    }
    
    /** 
     * This method is used to delete the ExamComponent object
     */
    @Override
    public void delete(ExamComponent obj) {
        examComponentRepository.delete(obj)
    }
    
    /**
     * Delete an ExamComponent object from the database
     *
     * @param examComponentId - the ID of the ExamComponent object to delete
     */
    public delete(Integer examComponentId) {
        delete(findById(examComponentId))
    }
}