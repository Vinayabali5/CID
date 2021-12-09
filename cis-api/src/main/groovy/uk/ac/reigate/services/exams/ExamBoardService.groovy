package uk.ac.reigate.services.exams

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.dto.exams.ExamBoardDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.model.PageInfo
import uk.ac.reigate.model.SearchResult
import uk.ac.reigate.repositories.exams.ExamBoardRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService
import uk.ac.reigate.utils.ValidationUtils

@Service
class ExamBoardService implements ICoreDataService<ExamBoard, Integer>, IDtoCreateUpdateService<ExamBoardDto, ExamBoard>{
    
    @Autowired
    ExamBoardRepository examBoardRepository
    
    /**
     * Default NoArgs constructor
     */
    ExamBoardService() {}
    
    /**
     * Autowired Constructor
     *
     * @param examBoardRepository
     */
    ExamBoardService(ExamBoardRepository examBoardRepository) {
        this.examBoardRepository = examBoardRepository;
    }
    
    /**
     * Find an individual examBoard using the examBoards ID fields
     *
     * @param id the ID fields to search for
     * @return the ExamBoard object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    ExamBoard findById(Integer id) {
        return examBoardRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all examBoards
     *
     * @return a SearchResult set with the list of examBoards
     */
    @Override
    @Transactional(readOnly = true)
    List<ExamBoard> findAll() {
        return examBoardRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete ExamBoard object in the database
     *
     * @param examBoard the new ExamBoard object to be saved
     * @return the saved version of the ExamBoard object
     */
    @Override
    @Transactional
    public ExamBoard save(ExamBoard examBoard) {
        return examBoardRepository.save(examBoard)
    }
    
    /**
     * This service method is used to create an ExamBoard object in the database from a partial or complete ExamBoard object.
     *
     * @param examBoard the partial or complete ExamBoard object to be saved
     * @return the saved version of the ExamBoard object
     */
    @Transactional
    public ExamBoard createFromDto(ExamBoardDto examBoardDto) {
        if(examBoardDto == null) {
            throw new InvalidDataException("Cannot create examBoardDto from null object.")
        }
        ExamBoard examBoardToSave = new ExamBoard()
        examBoardToSave.id = examBoardDto.id
        examBoardToSave.name = examBoardDto.name
        examBoardToSave.description = examBoardDto.description
        examBoardToSave.boardCode = examBoardDto.boardCode
        examBoardToSave.boardCentreNumber = examBoardDto.boardCentreNumber
        examBoardToSave.boardIdentifier = examBoardDto.boardIdentifier
        examBoardToSave.telephoneNo = examBoardDto.telephoneNo
        return save(examBoardToSave)
    }
    
    /**
     * This service method is used to update an ExamBoard object in the database from a partial or complete ExamBoard object.
     *
     * @param examBoard the partial or complete ExamBoard object to be saved
     * @return the saved version of the ExamBoard object
     */
    @Transactional
    public ExamBoard updateFromDto(ExamBoardDto examBoardDto) {
        if(examBoardDto == null) {
            throw new InvalidDataException("Cannot update examBoardDto from null object.")
        }
        ExamBoard examBoardToSave = findById(examBoardDto.id)
        examBoardToSave.name = examBoardDto.name
        examBoardToSave.description = examBoardDto.description
        examBoardToSave.boardCode = examBoardDto.boardCode
        examBoardToSave.boardCentreNumber = examBoardDto.boardCentreNumber
        examBoardToSave.boardIdentifier = examBoardDto.boardIdentifier
        examBoardToSave.telephoneNo = examBoardDto.telephoneNo
        return save(examBoardToSave)
    }
    
    /**
     * Saves a list of ExamBoard objects to the database
     *
     * @param examBoards a list of ExamBoards to be saved to the database
     * @return the list of save ExamBoard objects
     */
    @Transactional
    public List<ExamBoard> saveExamBoards(List<ExamBoard> examBoards) {
        return examBoards.collect { examBoard -> save(examBoard) };
    }
    
    /* (non-Javadoc)
     * @see uk.ac.reigate.services.ICoreDataService#delete(java.lang.Object)
     */
    @Override
    public void delete(ExamBoard obj) {
        throw new InvalidOperationException("ExamBoard should not be deleted")
    }
    
    /**
     * This method is used to find a single ExamBoard from the supplied board identifier.
     * 
     * @param boardIdentifier The board identifier to search for
     * @return the matching ExamBoard object
     */
    public ExamBoard findByBoardIdentifier(String boardIdentifier) {
        return examBoardRepository.findByBoardIdentifier(boardIdentifier)
    }
}
