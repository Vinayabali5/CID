package uk.ac.reigate.services.exams.basedata

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.domain.exams.basedata.Syllabus
import uk.ac.reigate.dto.exams.basedata.SyllabusDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.exams.basedata.SyllabusRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService
import uk.ac.reigate.util.exception.BadRequestException

@Service
public class SyllabusService implements ICoreDataService<Syllabus, Integer>, IDtoCreateUpdateService<SyllabusDto, Syllabus> {
    
    @Autowired
    SyllabusRepository syllabusRepository
    
    @Autowired
    ExamSeriesService examSeriesService
    
    @Autowired
    ExamOptionService examOptionService
    
    /**
     * Default NoArgs constructor
     */
    SyllabusService() {}
    
    /**
     * Autowired constructor
     * 
     * @param syllabusRepository
     */
    SyllabusService(SyllabusRepository syllabusRepository, ExamSeriesService examSeriesService, ExamOptionService examOptionService) {
        super();
        this.syllabusRepository = syllabusRepository;
        this.examSeriesService = examSeriesService;
        this.examOptionService = examOptionService;
    }
    
    /**
     * This service method Find an individual exam basedata Syllabus by syllabusId
     * 
     * @param syllabusId - the ID to search for
     * @return Syllabus - the Syllabus object that matches the ID, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    public Syllabus findById(Integer id) {
        return syllabusRepository.findById(id).orElse(null)
    }
    
    /**
     * This method is used to find all the Syllabus objects from the repository    
     */
    @Transactional(readOnly = true)
    public List<Syllabus> findAll() {
        return syllabusRepository.findAll();
    }
    
    /**
     * This service method is used to Find the List off syllabus by yearId. 
     * 
     * @param yearId
     * @return
     */
    public List<Syllabus> findByYearId(Integer yearId){
        return syllabusRepository.findByYearId(yearId);
    }
    
    /**
     * Save a Syllabus object to the database
     * 
     * @param syllabus - the Syllabus object to save
     * @return the saved Syllabus object
     */
    @Override
    public Syllabus save(Syllabus syllabus) {
        return syllabusRepository.save(syllabus);
    }
    
    /**
     * Delete a Syllabus object from the database
     * 
     * @param syllabusId - the ID to be deleted.
     */
    public deleteSyllabus(Integer id) {
        Syllabus deleteSyllabus = syllabusRepository.findById(id).orElse(null)
        delete(deleteSyllabus)
    }
    
    /**
     * This service is used to delete the syllabus object from the database.
     */
    @Override
    public void delete(Syllabus syllabus){
        if (syllabus == null) {
            throw new BadRequestException("Specified syllabus is not found.");
        }
        syllabusRepository.delete(syllabus)
    }
    
    /**
     * This service method is used to find the Syllabus object by optionEntryCode
     * @param entryCode
     * @return List of Syllabus
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Syllabus> findByEntryCode(List<String> entryCode) {
        List<Syllabus> syllabi = [];
        entryCode.each { it ->
            List<ExamOption> examOptions = examOptionService.findByOptionEntryCode(it);
            for (ExamOption examOption : examOptions) {
                syllabi.push(syllabusRepository.findById(examOption.syllabus.id).orElse(null));
            }
        }
        return syllabi;
    }
    
    /** 
     * This service method is used to find the syllabus object by code.
     * @param entryCode
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Syllabus> findByCode(List<String> entryCode) {
        List<Syllabus> syllabi = [];
        entryCode.each { it ->
            List<Syllabus> syllabusList = syllabusRepository.findByCode(it)
            for (Syllabus syllabus : syllabusList) {
                syllabi.push(syllabus);
            }
        }
        return syllabi;
    }
    
    /**
     * This service method is used to find the syllabus object by code and year.
     * @param entryCode
     * @param year
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Syllabus> findByCodeAndYear(AcademicYear year, List<String> entryCode) {
        List<Syllabus> syllabi = [];
        entryCode.each { it ->
            List<Syllabus> syllabusList = syllabusRepository.findByYearAndCode(year.id, it)
            for (Syllabus syllabus : syllabusList) {
                syllabi.push(syllabus);
            }
        }
        return syllabi;
    }
    
    
    /**
     * This service method is used to find the Syllabus object by optionEntryCode and year
     * @param entryCode
     * @param year
     * @return List of Syllabus
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public List<Syllabus> findByEntryCodeAndYear(AcademicYear year, List<String> entryCode) {
        List<Syllabus> syllabi = [];
        entryCode.each { it ->
            List<ExamOption> examOptions = examOptionService.findByOptionEntryCodeAndYear(year, it);
            for (ExamOption examOption : examOptions) {
                syllabi.push(syllabusRepository.findById(examOption.syllabus.id).orElse(null));
            }
        }
        return syllabi;
    }
    
    
    /**
     * This service method is used to find the syllabus by entryCode and examSeries.
     * @param entryCode
     * @param examSeries
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    public Syllabus findByEntryCodeAndExamSeries(String entryCode, ExamSeries examSeries) {
        Syllabus syllabus
        List<ExamOption> examOptions = examOptionService.findByOptionEntryCode(entryCode);
        for (ExamOption examOption : examOptions) {
            if (examOption.syllabus.examSeries.equals(examSeries)) {
                syllabus = examOption.syllabus
            }
        }
        return syllabus;
    }
    
    /**
     * This service method is used to create the Syllabus object in the database. 
     */
    @Transactional
    public Syllabus createFromDto(SyllabusDto syllabusDto) {
        if(syllabusDto == null) {
            throw new InvalidDataException("Cannot create syllabusDto from null object.")
        }
        Syllabus syllabus = new Syllabus()
        if(syllabusDto.examSeriesId != null) {
            syllabus.examSeries = examSeriesService.findById(syllabusDto.examSeriesId)
        }
        syllabus.code = syllabusDto.code
        syllabus.title = syllabusDto.title
        return save(syllabus);
    }
    
    /**
     * This service method is used to update the Syllabus object in the database.
     */
    @Transactional
    public Syllabus updateFromDto(SyllabusDto syllabusDto) {
        if(syllabusDto == null) {
            throw new InvalidDataException("Cannot create syllabusDto from null object.")
        }
        Syllabus syllabus = findById(syllabusDto.id)
        if(syllabusDto.examSeriesId != null) {
            syllabus.examSeries = examSeriesService.findById(syllabusDto.examSeriesId)
        }
        syllabus.code = syllabusDto.code
        syllabus.title = syllabusDto.title
        return save(syllabus);
    }
    
    /**
     * This service method is used to find the syllabus by examSeries and syllabusCode.
     * @param examSeries
     * @param syllabusCode
     * @return
     */
    Syllabus findByExamSeriesAndSyllabusCode(ExamSeries examSeries, String syllabusCode) {
        return syllabusRepository.findByExamSeriesAndCode(examSeries, syllabusCode)
    }
}
