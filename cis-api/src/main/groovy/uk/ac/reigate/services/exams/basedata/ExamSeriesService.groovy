package uk.ac.reigate.services.exams.basedata

import com.querydsl.core.types.dsl.BooleanExpression

import lombok.RequiredArgsConstructor

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.dto.exams.ExamBoardDto
import uk.ac.reigate.dto.exams.basedata.ExamSeriesDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.AcademicYearRepository
import uk.ac.reigate.repositories.exams.ExamBoardRepository
import uk.ac.reigate.repositories.exams.basedata.ExamSeriesRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService
import uk.ac.reigate.services.IDtoToEntityConvertor
import uk.ac.reigate.services.exams.ExamBoardService
import uk.ac.reigate.util.exception.BadRequestException

@Service
@RequiredArgsConstructor
class ExamSeriesService implements ICoreDataService<ExamSeries, Integer>, IDtoCreateUpdateService<ExamSeriesDto, ExamSeries> {
    
    @Autowired
    ExamSeriesRepository examSeriesRepository
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    ExamBoardService examBoardService
    
    /**
     * Default NoArgs constructor
     */
    ExamSeriesService() {}
    
    /**
     * Autowired Constructor
     *
     * @param examBoardRepository
     */
    ExamSeriesService(ExamSeriesRepository examSeriesRepository, AcademicYearService academicYearService, ExamBoardService examBoardService){
        super();
        this.examSeriesRepository = examSeriesRepository;
        this.academicYearService = academicYearService;
        this.examBoardService = examBoardService;
    }
    
    /**
     * findExamSeries
     * 
     * @param examSeriesId - the ID to search for
     * @return ExamSeries - the ExamSeries object that matches the ID, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    ExamSeries findById(Integer id) {
        return examSeriesRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all Exam Series
     *
     * @return a List of exam series
     */
    @Override
    @Transactional(readOnly = true)
    List<ExamSeries> findAll() {
        return examSeriesRepository.findAll()
    }
    
    /**
     * This service method is used to save a complete ExamSeries object in the database
     *
     * @param examSeries the new ExamSeries object to be saved
     * @return the saved version of the ExamSeries object
     */
    @Override
    @Transactional
    public ExamSeries save(ExamSeries examSeries) {
        return examSeriesRepository.save(examSeries);
    }
    
    /**
     * Find all ExamSeries
     *
     * @return a SearchResult set with the list of ExamSeries
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    @Transactional(readOnly = true)
    public List<ExamSeries> findExamSeriesList(Integer examBoardId, Integer yearId) {
        List<ExamSeries> examSeriesList;
        if (examBoardId != null && yearId != null) {
            examSeriesList = examSeriesRepository.findByExamBoard_IdAndAcademicYear_Id(examBoardId, yearId);
        } else if (examBoardId != null) {
            examSeriesList = examSeriesRepository.findByExamBoard_Id(examBoardId);
        } else if(yearId != null) {
            examSeriesList = examSeriesRepository.findByAcademicYear_Id(yearId);
        } else {
            examSeriesList = findAll();
        }
        return examSeriesList
    }
    
    /**
     * This methods throws an InvalidOperationException when called. ExamSeries should not be deleted.
     */
    @Override
    public void delete(ExamSeries obj) {
        throw new InvalidOperationException("ExamSeries should not be deleted")
    }
    
    /**
     * This method is used to find the list of exam series by booleanExpression.
     *
     */
    public List<ExamSeries> findAll(BooleanExpression booleanExpression) {
        return examSeriesRepository.findAll(booleanExpression)
    }
    
    /**
     * This method is used to find the list of exam series that has specified examSeries, exam year.
     *
     */
    public List<ExamSeries> findByExamYearAndExamSeries(String examYear, String examSeries) {
        return examSeriesRepository.findByExamYearAndExamSeries(examYear, examSeries)
    }
    
    /**
     * This method is used to search for a single exam series that has the specified exam board, exam year and
     * exam series code. 
     * 
     * @param examBoard The ExamBoard object to use for the search
     * @param examYear The exam year code to use for the search
     * @param examSeries The exam series code to use for the search
     * @return an ExamSeries object that matches the criteria (or null if not found)
     */
    public ExamSeries findByExamBoardYearAndSeries(ExamBoard examBoard, String examYear, String examSeries) {
        return examSeriesRepository.findByExamBoardAndExamYearAndExamSeries(examBoard, examYear, examSeries)
    }
    
    /**
     * This method is used to create a new ExamSeries and save it to the database.
     * 
     * @param dto The ExamSeriesDto object to use to create the new ExamSeries object.
     * @return The saved ExamSeries object
     */
    @Transactional
    public ExamSeries createFromDto(ExamSeriesDto dto) {
        if (dto == null) {
            throw new InvalidDataException("Cannot create Exam Series from null object.")
        }
        ExamSeries examSeries = new ExamSeries()
        if (dto.examBoardId != null) {
            examSeries.examBoard = examBoardService.findById(dto.examBoardId)
        }
        if (dto.academicYearId != null) {
            examSeries.academicYear = academicYearService.findById(dto.academicYearId)
        }
        examSeries.examYear = dto.examYear
        examSeries.examSeries = dto.examSeries
        examSeries.entrySubmitted = dto.entrySubmitted
        examSeries.nextSequenceNo = dto.nextSequenceNo
        return save(examSeries);
    }
    
    /**
     * This method is used to update the existing ExamSeries and save it to the database.
     * 
     * @param dto The ExamSeriesDto object to use to update the existing ExamSeries object.
     * @return The saved ExamSeries object
     */
    @Transactional
    public ExamSeries updateFromDto(ExamSeriesDto dto) {
        if (dto.id == null) {
            throw new InvalidDataException("Cannot update Exam Series from null ID.")
        }
        ExamSeries examSeries = findById(dto.id)
        if (dto.examBoardId != null) {
            examSeries.examBoard = examBoardService.findById(dto.examBoardId)
        }
        if (dto.academicYearId != null) {
            examSeries.academicYear = academicYearService.findById(dto.academicYearId)
        }
        examSeries.examYear = dto.examYear
        examSeries.examSeries = dto.examSeries
        examSeries.entrySubmitted = dto.entrySubmitted
        examSeries.nextSequenceNo = dto.nextSequenceNo
        return save(examSeries);
    }
    
    /**
     * Delete an ExamSeries from the database
     *
     * @param examSeriesId
     */
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    @Transactional
    public void delete(Integer id) {
        ExamSeries deleteExamSeries = examSeriesRepository.findById(id).orElse(null)
        if (deleteExamSeries == null) {
            throw new BadRequestException("exam series ID does not exist.");
        }
        examSeriesRepository.delete(deleteExamSeries)
    }
}
