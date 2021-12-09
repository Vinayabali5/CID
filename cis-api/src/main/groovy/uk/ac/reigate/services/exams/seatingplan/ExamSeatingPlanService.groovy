package uk.ac.reigate.services.exams.seatingplan

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Room
import uk.ac.reigate.domain.exams.seatingplan.ExamSeatingPlan
import uk.ac.reigate.domain.exams.seatingplan.ExamSession
import uk.ac.reigate.dto.exams.seatingplan.ExamSeatingPlanDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.exams.seatingplan.ExamSeatingPlanRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.RoomService

@Service
class ExamSeatingPlanService implements ICoreDataService<ExamSeatingPlan, Integer>{
    
    private final static Logger log = LoggerFactory.getLogger(ExamSeatingPlanService.class.getName())
    
    @Autowired
    ExamSeatingPlanRepository examSeatingPlanRepository
    
    @Autowired
    ExamSessionService examSessionService
    
    @Autowired
    RoomService roomService
    
    /**
     * Default NoArgs constructor
     */
    ExamSeatingPlanService() {}
    
    /**
     * Autowired Constructor
     * 
     */
    ExamSeatingPlanService(ExamSeatingPlanRepository examSeatingPlanRepository, ExamSessionService examSessionService, RoomService roomService){
        super();
        this.examSeatingPlanRepository = examSeatingPlanRepository
        this.examSessionService = examSessionService
        this.roomService = roomService
    }
    
    /**
     * This method is used to retrieve an individual ExamSeatingPlan.
     */
    @Override
    @Transactional(readOnly = true)
    ExamSeatingPlan findById(Integer id) {
        return examSeatingPlanRepository.findById(id).orElse(null)
    }
    
    /**
     * This service method is used to retrieve the list of examSeatingPlan.
     */
    @Override
    @Transactional(readOnly = true)
    List<ExamSeatingPlan> findAll() {
        return examSeatingPlanRepository.findAll();
    }
    
    /**
     * This service method is used to save an ExamSeatingPlan object in the database from an ExamSeatingPlan object
     * 
     * @param examRoom
     * @return
     */
    @Override
    @Transactional
    public ExamSeatingPlan save(ExamSeatingPlan examRoom) {
        return examSeatingPlanRepository.save(examRoom);
    }
    
    /**
     * This method is used to delete the ExamSeatingPlan.
     */
    @Override
    @Transactional
    public void delete(ExamSeatingPlan examSeatingPlan){
        examSeatingPlanRepository.delete(examSeatingPlan)
    }
    
    /**
     * Find all ExamSeatingPlan objects where timetableDate and timetableSession match 
     * 
     * @param timetableDate
     * @param timetableSession
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    @Transactional(readOnly = true)
    public List<ExamSeatingPlan> findExamRoomsByDateAndSession(Date timetableDate, String timetableSession) {
        return examSeatingPlanRepository.findByExamSession_DateAndExamSession_Session(timetableDate, timetableSession);
    }
    
    /**
     * Find an ExamSeatingPlan object where examSessionId and RoomId match
     * 
     * @param examSessionId
     * @param roomId
     * @return
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    @Transactional(readOnly = true)
    public ExamSeatingPlan findExamRoomsByExamSessionIdAndRoomId(Integer examSessionId, Integer roomId) {
        return examSeatingPlanRepository.findByExamSession_IdAndRoom_Id(examSessionId, roomId);
    }
    
    /**
     * This service method is used to create an Room object in the database from a partial or complete Room object.
     *
     * @param room the partial or complete Room object to be saved
     * @return the saved version of the Room object
     */
    @Transactional
    public ExamSeatingPlan createFromDto(ExamSeatingPlanDto examRoom) {
        if(examRoom == null) {
            throw new InvalidDataException("Cannot create ExamSeatingPlanDto from null object.")
        }
        ExamSeatingPlan examRoomToSave = new ExamSeatingPlan()
        examRoomToSave.examSession = examRoom.examSession.id != null ? examSessionService.findById(examRoom.examSession.id) : null
        examRoomToSave.room = examRoom.room.id != null ? roomService.findById(examRoom.room.id) : null
        examRoomToSave.rows = examRoom.rows != null ? examRoom.rows : examRoom.rows
        examRoomToSave.cols = examRoom.cols != null ? examRoom.cols : examRoom.cols
        return save(examRoomToSave)
    }
    
    /**
     * This service method is used to update an Room object in the database from a partial or complete Room object.
     *
     * @param room the partial or complete Room object to be saved
     * @return the saved version of the Room object
     */
    @Transactional
    public ExamSeatingPlan updateFromDto(ExamSeatingPlanDto examRoom) {
        if(examRoom == null) {
            throw new InvalidDataException("Cannot create ExamSeatingPlanDto from null object.")
        }
        ExamSeatingPlan examRoomToSave = findById(examRoom.id)
        examRoomToSave.examSession = examRoom.examSessionId != null ? examSessionService.findById(examRoom.examSessionId) : null
        examRoomToSave.room = examRoom.roomId != null ? roomService.findById(examRoom.roomId) : null
        examRoomToSave.rows = examRoom.rows != null ? examRoom.rows : examRoom.rows
        examRoomToSave.cols = examRoom.cols != null ? examRoom.cols : examRoom.cols
        return save(examRoomToSave)
    }
    
    /**
     * Saves a list of Room objects to the database
     *
     * @param rooms a list of Rooms to be saved to the database
     * @return the list of save Room objects
     */
    @Transactional
    public List<ExamSeatingPlan> saveExamRooms(List<ExamSeatingPlan> examRooms) {
        return examRooms.collect { examRoom -> save(examRoom) };
    }
    
    /**
     * This method is used to delete an ExamSeatingPlan object by the ID supplied.
     * 
     * @param examRoomId the ID of the ExamSeatingPlan to delete.
     */
    @Transactional
    public void deleteById(Integer examRoomId){
        examSeatingPlanRepository.deleteById(examRoomId)
    }
}
