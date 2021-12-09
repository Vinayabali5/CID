package uk.ac.reigate.services.exams.basedata

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.domain.exams.basedata.Syllabus
import uk.ac.reigate.dto.exams.basedata.ExamOptionDto
import uk.ac.reigate.repositories.exams.basedata.ExamOptionRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService
import uk.ac.reigate.services.exams.edi.ExamTypeService

@Service
public class ExamOptionService implements ICoreDataService<ExamOption, Integer>, IDtoCreateUpdateService<ExamOptionDto, ExamOption> {
    
    @Autowired
    ExamOptionRepository examOptionRepository
    
    @Autowired
    ExamTypeService examTypeService
    
    @Autowired
    SyllabusService syllabusService
    
    @Autowired
    ExamSeriesService examSeriesService
    
    /**
     * Default NoArgs constructor
     */
    ExamOptionService() {}
    
    /**
     * Autowired constructor
     * 
     * @param optionService
     */
    ExamOptionService(ExamOptionRepository examOptionRepository, ExamTypeService examTypeService, SyllabusService syllabusService, ExamSeriesService examSeriesService) {
        super()
        this.examOptionRepository = examOptionRepository;
        this.examTypeService = examTypeService;
        this.syllabusService = syllabusService;
        this.examSeriesService = examSeriesService;
    }
    
    /**
     * This service method is used retrieve the list of examOptions based on the optionEntryCode.
     * @param optionEntryCode
     * @return
     */
    public List<ExamOption> searchByOptionEntryCode(String optionEntryCode) {
        return examOptionRepository.findByOptionEntryCodeContaining(optionEntryCode)
    }
    
    /**
     * Find an individual exam basedata Exam Option by examOptionId
     *
     *     @param optionId - the ID to search for
     *     @return Option - the Option object that matches the ID, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    public ExamOption findById(Integer examOptionId) {
        return examOptionRepository.findById(examOptionId).orElse(null)
    }
    
    /**
     * Find all Exam Options
     *
     * @return a SearchResult set with the list of Exam Options
     */
    @Override
    @Transactional(readOnly = true)
    public List<ExamOption> findAll() {
        return examOptionRepository.findAll();
    }
    
    /**
     * Find all Exam Options for a specified syllabusId
     *
     * @param syllabusId - the specified syllabusId to retrieve exam option data for
     * @return a SearchResult set with the list of Exam Options
     */
    @Transactional(readOnly = true)
    public List<ExamOption> findExamOptions(Integer syllabusId) {
        Syllabus syllabus = new Syllabus();
        syllabus.id = syllabusId;
        List<ExamOption> examOptions = examOptionRepository.findBySyllabus(syllabus);
        return examOptions
    }
    
    /**
     * This service method is used to save the examOption to the database.
     */
    @Override
    public ExamOption save(ExamOption examOption){
        return examOptionRepository.save(examOption);
    }
    /**
     * Delete an Exam Option from the database
     * 
     * @param Integer examOptionId
     */
    public deleteExamOption(Integer id) {
        ExamOption deleteExamOption = findById(id)
        delete(deleteExamOption)
    }
    
    /**
     * This service method is used to delete the examOption data from the database.
     */
    @Override
    public void delete(ExamOption obj) {
        examOptionRepository.delete(obj)
    }
    
    /**
     * This service method is used to retrieve the list of examOptions based on the optionEntryCode.
     * 
     */
    public List<ExamOption> findByOptionEntryCode(String optionEntryCode) {
        return examOptionRepository.findByOptionEntryCode(optionEntryCode)
    }
    
    /**
     * This service method is used to retrieve the list of examOptions based on the optionEntryCode and year.
     *
     */
    public List<ExamOption> findByOptionEntryCodeAndYear(AcademicYear year, String optionEntryCode) {
        return examOptionRepository.findByOptionEntryCodeAndYear(year.id, optionEntryCode)
    }
    
    /**
     * This service method is used to retrieve the list of examOptions based on the optionEntryCode and examSeries.
     * 
     */
    public List<ExamOption> findByOptionEntryCodeAndExamSeries(String optionEntryCode, ExamSeries examSeries) {
        return examOptionRepository.findByOptionEntryCode(optionEntryCode).find {
            it.syllabus.examSeries = examSeries
        }
    }
    
    /**
     * This service method is used to retrieve the examOption based on examSeries, syllabus and entryCode.
     * 
     */
    public ExamOption findByExamSeriesAndSyllabusAndCode(ExamSeries  examSeries, Syllabus syllabus, String entryCode) {
        return examOptionRepository.findBySyllabus_ExamSeriesAndSyllabusAndOptionEntryCode(examSeries, syllabus, entryCode)
    }
    /**
     * This Service method is used to retrieve the examOption based on examSeries and entryCode
     */
    public ExamOption findByExamSeriesAndCode(ExamSeries  examSeries, String entryCode) {
        return examOptionRepository.findBySyllabus_ExamSeriesAndOptionEntryCode(examSeries, entryCode)
    }
    
    /**
     * This service method is used to create a ExamOption object in the database from a partial or complete ExamOption object.
     *
     * @param examOption the partial or complete ExamOption object to be saved
     * @return the saved version of the ExamOption object
     */
    public ExamOption createFromDto(ExamOptionDto examOptionDto) {
        ExamOption examOption = new ExamOption()
        if (examOptionDto.syllabus != null) {
            if (examOptionDto.syllabus.id != null) {
                examOption.syllabus = syllabusService.findById(examOptionDto.syllabus.id)
            } else if (examOptionDto.syllabus.code != null) {
                examOption.syllabus = syllabusService.findByEntryCodeAndExamSeries(examOptionDto.syllabus.code, examSeriesService.findById(examOptionDto.syllabus.examSeries.id))
            }
        } else {
            examOption.syllabus = null
        }
        examOption.optionEntryCode = examOptionDto.optionEntryCode
        examOption.process = examOptionDto.process
        examOption.qcaClassificationCode = examOptionDto.qcaClassificationCode
        examOption.qcaAccreditationNo = examOptionDto.qcaAccreditationNo
        examOption.optionTitle = examOptionDto.optionTitle
        examOption.feeDefined = examOptionDto.feeDefined
        examOption.examinationFee = examOptionDto.examinationFee
        examOption.firstForecastGradeGradeset = examOptionDto.firstForecastGradeGradeset
        examOption.secondForecastGradeGradeset = examOptionDto.secondForecastGradeGradeset
        examOption.resultType = examOptionDto.resultType
        examOption.firstGradeResultGradeset = examOptionDto.firstGradeResultGradeset
        examOption.secondGradeResultGradeset = examOptionDto.secondGradeResultGradeset
        examOption.endorsementToFirstGradeResultGradeset = examOptionDto.endorsementToFirstGradeResultGradeset
        examOption.endorsementToSecondGradeResultGradeset = examOptionDto.endorsementToSecondGradeResultGradeset
        examOption.maxMarkUms = examOptionDto.maxMarkUms
        examOption.noOfComponents = examOptionDto.noOfComponents
        if(examOptionDto.examTypeCertId != null) {
            examOption.examTypeCert = examTypeService.findById(examOptionDto.examTypeCertId)
        }
        if(examOptionDto.examTypeUnitId != null) {
            examOption.examTypeUnit = examTypeService.findById(examOptionDto.examTypeUnitId)
        }
        return save(examOption);
    }
    
    /**
     * This service method is used to update a ExamOption object in the database from a partial or complete ExamOption object.
     *
     * @param examOption the partial or complete ExamOption object to be saved
     * @return the saved version of the ExamOption object
     */
    public ExamOption updateFromDto(ExamOptionDto examOptionDto) {
        ExamOption examOption = findById(examOptionDto.id)
        if (examOptionDto.syllabus != null) {
            if (examOptionDto.syllabus.id != null) {
                examOption.syllabus = syllabusService.findById(examOptionDto.syllabus.id)
            } else if (examOptionDto.syllabus.code != null) {
                examOption.syllabus = syllabusService.findByEntryCodeAndExamSeries(examOptionDto.syllabus.code, examSeriesService.findById(examOptionDto.syllabus.examSeries.id))
            }
        } else {
            examOption.syllabus = null
        }
        examOption.optionEntryCode = examOptionDto.optionEntryCode
        examOption.process = examOptionDto.process
        examOption.qcaClassificationCode = examOptionDto.qcaClassificationCode
        examOption.qcaAccreditationNo = examOptionDto.qcaAccreditationNo
        examOption.optionTitle = examOptionDto.optionTitle
        examOption.feeDefined = examOptionDto.feeDefined
        examOption.examinationFee = examOptionDto.examinationFee
        examOption.firstForecastGradeGradeset = examOptionDto.firstForecastGradeGradeset
        examOption.secondForecastGradeGradeset = examOptionDto.secondForecastGradeGradeset
        examOption.resultType = examOptionDto.resultType
        examOption.firstGradeResultGradeset = examOptionDto.firstGradeResultGradeset
        examOption.secondGradeResultGradeset = examOptionDto.secondGradeResultGradeset
        examOption.endorsementToFirstGradeResultGradeset = examOptionDto.endorsementToFirstGradeResultGradeset
        examOption.endorsementToSecondGradeResultGradeset = examOptionDto.endorsementToSecondGradeResultGradeset
        examOption.maxMarkUms = examOptionDto.maxMarkUms
        examOption.noOfComponents = examOptionDto.noOfComponents
        if(examOptionDto.examTypeCertId != null) {
            examOption.examTypeCert = examTypeService.findById(examOptionDto.examTypeCertId)
        }
        if(examOptionDto.examTypeUnitId != null) {
            examOption.examTypeUnit = examTypeService.findById(examOptionDto.examTypeUnitId)
        }
        return save(examOption);
    }
}
