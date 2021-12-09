package uk.ac.reigate.services.exams.seatingplan

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.exams.StudentOptionEntry
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.seatingplan.ExamSeat
import uk.ac.reigate.domain.exams.seatingplan.ExamSeatPk
import uk.ac.reigate.dto.exams.seatingplan.ExamSeatsDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.exams.basedata.ExamComponentRepository
import uk.ac.reigate.repositories.exams.seatingplan.ExamSeatRepository
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.exams.basedata.ExamComponentService
import uk.ac.reigate.services.student.StudentService


@Service
class ExamSeatService implements ICoreDataService<ExamSeat, ExamSeatPk>{
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    StudentService studentService
    
    @Autowired
    ExamComponentService examComponentService
    
    @Autowired
    ExamSeatRepository examSeatRepository
    
    @Autowired
    ExamComponentRepository examComponentRepository
    
    @Autowired
    ExamSeatingPlanService examSeatingPlanService;
    
    /**
     * Default No Args constructor
     */
    ExamSeatService() {}
    
    /**
     * This service method is used to retrieve the ExamSeat by Id.
     */
    @Override
    public ExamSeat findById(ExamSeatPk id) {
        return examSeatRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all seatingPlans
     * @return a SearchResult set with the list of OptionEntries
     */
    @Override
    @Transactional(readOnly = true)
    List<ExamSeat> findAll() {
        return examSeatRepository.findAll();
    }
    
    /**
     * This service method is used to save the ExamSeat to the database.
     * @param seatingPlan
     * @return
     */
    @Override
    @Transactional
    public ExamSeat save(ExamSeat seatingPlan) {
        return examSeatRepository.save(seatingPlan)
    }
    
    /**
     * This service method is used to delete the ExamSeat from the database.
     */
    @Override
    @PreAuthorize("@securityChecker.checkReader(authentication) or hasRole('Exams Officer')")
    @Transactional
    public void delete(ExamSeat examSeat) {
        examSeatRepository.delete(examSeat)
    }
    
    /**
     * This method is used to retrieve all the ExamSeat objects for a given ExamComponent from the ExamComponent object ID field.
     *  
     * @param examComponentId the ExamComponent ID.
     * @return a List of ExamSeat object for the given ExamComponent ID.
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    @Transactional(readOnly = true)
    List<ExamSeat> findByExamComponent(Integer examComponentId) {
        List<ExamSeat> seatingPlans = examSeatRepository.findByExamComponentId(examComponentId);
        return seatingPlans;
    }
    
    /**
     * This service method is used to update the ExamSeat data object from ExamSeatsDto
     */
    @Transactional
    public ExamSeat updateFromDto(ExamSeatsDto examSeatsDto) {
        if(examSeatsDto == null) {
            throw new InvalidDataException("Cannot create a examSeat with a null ExamSeatsDto.")
        }
        ExamSeat seatingPlan = findExamSeatByStudentIdAndExamComponentId(examSeatsDto.studentId, examSeatsDto.examComponentId)
        if(seatingPlan == null){
            throw new InvalidDataException("Cannot update a examSeat with a null object.")
        }
        seatingPlan.examSeatingPlan = examSeatsDto.examSeatingPlanId != null ? examSeatingPlanService.findById(examSeatsDto.examSeatingPlanId) : seatingPlan.examSeatingPlan
        seatingPlan.row = examSeatsDto.row
        seatingPlan.col = examSeatsDto.col
        return save(seatingPlan)
    }
    /**
     * Find an individual seatingPlan using the seatingPlan ID fields
     *
     * @param id the ID fields to search for
     * @return the OptionEntry object that matches the ID supplied, or null if not found
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    @Transactional(readOnly = true)
    ExamSeat findExamSeat(Student student, ExamComponent examComponent){
        return examSeatRepository.findByStudent_IdAndExamComponent_Id(student.id, examComponent.id)
    }
    
    /**
     * Find an individual seatingPlan using the seatingPlan ID fields
     *
     * @param id the ID fields to search for
     * @return the OptionEntry object that matches the ID supplied, or null if not found
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    @Transactional(readOnly = true)
    ExamSeat findExamSeatByStudentIdAndExamComponentId(Integer studentId, Integer examComponentId){
        return examSeatRepository.findByStudent_IdAndExamComponent_Id(studentId, examComponentId)
    }
    
    /**
     * Find an individual seatingPlan using the seatingPlan ID fields
     *
     * @param id the ID fields to search for
     * @return the OptionEntry object that matches the ID supplied, or null if not found
     */
    @Transactional(readOnly = true)
    ExamSeat findSeatingPlan(Integer examSeatingPlanId, Integer row, Integer col) {
        return findById(new ExamSeatPk(examSeatingPlanId, row, col));
    }
    
    /**
     * This service method is used to delete the ExamSeat by seatingPlanId, row, col
     * @param seatingPlanId
     * @param row
     * @param col
     * @return
     */
    @Transactional
    public Boolean deleteByRowAndCol(Integer seatingPlanId, Integer row, Integer col){
        delete(findSeatingPlan(seatingPlanId, row, col))
    }
    
    /**
     * This service method is used to delete the ExamSeat by studentId, examComponentId.
     * @param studentId
     * @param examComponentId
     * @return
     */
    @Transactional
    public Boolean deleteByStudentAndExamComponent(Integer studentId, Integer examComponentId){
        Student student = studentService.findById(studentId)
        ExamComponent examComponent = examComponentRepository.findById(examComponentId).orElse(null)
        ExamSeat examSeat = findExamSeat(student, examComponent)
        if (examSeat != null) {
            delete(examSeat)
        }
    }
}
