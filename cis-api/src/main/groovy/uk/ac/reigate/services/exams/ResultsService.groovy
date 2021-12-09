package uk.ac.reigate.services.exams

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service

import uk.ac.reigate.domain.exams.Results
import uk.ac.reigate.dto.exams.ResultsDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.exams.ResultsRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.student.StudentService
@Service
class ResultsService implements ICoreDataService<Results, Integer> {
    
    @Autowired
    ResultsRepository resultsRepository
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    StudentService studentService
    
    @Autowired
    ExamBoardService examBoardService
    
    ResultsService() {}
    
    ResultsService(ResultsRepository resultsRepository, AcademicYearService academicYearService, StudentService studentService, ExamBoardService examBoardService) {
        this.resultsRepository = resultsRepository
        this.academicYearService = academicYearService
        this.studentService = studentService
        this.examBoardService = examBoardService
    }
    /**
     * @param studentId - student id
     * @return List of Results of a given studentId
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    List <Results> getByStudentId(Integer studentId){
        List <Results> results = resultsRepository.findByStudent_Id(studentId)
        results.removeIf { Results it ->
            it.importDate == null
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        results.removeAll { Results it ->
            it.importDate.compareTo(calendar.getTime()) >= 0
        }
        return results
    }
    
    /**
     * This method is used to find the Results by Id
     */
    @Override
    public Results findById(Integer id) {
        return resultsRepository.findById(id).orElse(null)
    }
    
    /**
     * This method is used to retrieve all the results List.
     */
    @Override
    public List<Results> findAll() {
        return resultsRepository.findAll()
    }
    
    /**
     * This method is used to save the results object.
     */
    @Override
    public Results save(Results result) {
        return resultsRepository.save(result)
    }
    
    /**
     * This method is used to delete the results object.
     */
    @Override
    public void delete(Results result) {
        throw new InvalidOperationException("Result should not be deleted")
    }
    
    /**
     * This method is used to update the Results object to the database.
     * @param result
     * @param resultDto
     * @return
     */
    public Results updateFromDto(ResultsDto resultsDto){
        if(resultsDto == null) {
            throw new InvalidDataException("Cannot update resultsDto from null objects")
        }
        Results results = findById(resultsDto.id)
        if(resultsDto.studentId != null) {
            results.student = studentService.findById(resultsDto.studentId)
        }
        if(resultsDto.examBoardId) {
            results.examBoard = examBoardService.findById(resultsDto.examBoardId)
        }
        if(resultsDto.academicYearId != null) {
            results.academicYear = academicYearService.findById(resultsDto.academicYearId)
        }
        results.examSeries = resultsDto.examSeries
        results.examYear = resultsDto.examYear
        results.resultsCode = resultsDto.resultCode
        results.score = resultsDto.score
        results.grade = resultsDto.grade
        results.examDate = resultsDto.examDate
        results.importDate = resultsDto.importDate
        return save(results)
    }
}
