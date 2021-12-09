package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import lombok.RequiredArgsConstructor
import uk.ac.reigate.domain.academic.AlternativePeriod
import uk.ac.reigate.dto.AlternativePeriodDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.AlternativePeriodRepository

@Service
@RequiredArgsConstructor
class AlternativePeriodService implements ICoreDataService<AlternativePeriod, Integer>, IDtoCreateUpdateService<AlternativePeriodDto, AlternativePeriod>{
    
    @Autowired
    AlternativePeriodRepository alternativePeriodRepository
    
    @Autowired
    private final BlockService blockService
    /**
     * Default NoArgs constructor
     */
    AlternativePeriodService() {}
    
    /**
     * Autowired Constructor
     *
     * @param periodRepository
     */
    AlternativePeriodService(AlternativePeriodRepository alternativePeriodRepository, BlockService blockService){
        super();
        this.alternativePeriodRepository = alternativePeriodRepository;
        this.blockService = blockService;
    }
    
    /**
     * Find an individual AlternativePeriod using the AlternativePeriods ID fields
     *
     * @param id the ID fields to search for
     * @return the AlternativePeriod object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    AlternativePeriod findById(Integer id) {
        return alternativePeriodRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all alternativePeriods
     *
     * @return a SearchResult set with the list of Periods
     */
    @Override
    @Transactional(readOnly = true)
    List<AlternativePeriod> findAll() {
        return alternativePeriodRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete AlternativePeriod object in the database
     *
     * @param alternativePeriod the new AlternativePeriod object to be saved
     * @return the saved version of the AlternativePeriod object
     */
    @Override
    @Transactional
    public AlternativePeriod save(AlternativePeriod alternativePeriod) {
        return alternativePeriodRepository.save(alternativePeriod)
    }
    
    /**
     * Saves a list of AlternativePeriod objects to the database
     *
     * @param alternativePeriods a list of AlternativePeriods to be saved to the database
     * @return the list of save AlternativePeriod objects
     */
    @Transactional
    public List<AlternativePeriod> saveAlternativePeriods(List<AlternativePeriod> alternativePeriods) {
        return alternativePeriods.collect { alternativePeriod -> save(alternativePeriod) };
    }
    
    /**
     * This service method is used to create a alternativePeriod object in the database from a partial or complete AlternativePeriod object.
     * 
     * @param alternativePeriod the partial or complete AlternativePeriod object to be saved
     * @return the saved version of the AlternativePeriod object
     */
    @Transactional
    public AlternativePeriod createFromDto(AlternativePeriodDto alternativePeriodDto) {
        if (alternativePeriodDto == null) {
            throw new InvalidDataException("Cannot create alternativePeriodDto from null object.")
        }
        AlternativePeriod alternativePeriod = new AlternativePeriod()
        alternativePeriod.code = alternativePeriodDto.code
        alternativePeriod.description = alternativePeriodDto.description
        if(alternativePeriodDto.blockId != null) {
            alternativePeriod.block = blockService.findById(alternativePeriodDto.blockId)
        }
        alternativePeriod.day = alternativePeriodDto.day
        alternativePeriod.dayPeriod = alternativePeriodDto.dayPeriod
        alternativePeriod.LviStartTime = alternativePeriodDto.LviStartTime
        alternativePeriod.LviEndTime = alternativePeriodDto.LviEndTime
        alternativePeriod.UviStartTime = alternativePeriodDto.UviStartTime
        alternativePeriod.UviEndTime = alternativePeriodDto.UviEndTime
        alternativePeriod.boxNo = alternativePeriodDto.boxNo
        alternativePeriod.cristalPeriod = alternativePeriodDto.cristalPeriod
        alternativePeriod.length = alternativePeriodDto.length
        alternativePeriod.defaultPeriodText = alternativePeriodDto.defaultPeriodText
        return save(alternativePeriod)
    }
    
    /**
     * This service method is used to update a period object in the database from a partial or complete Period object.
     *
     * @param period the partial or complete Period object to be saved
     * @return the saved version of the Period object
     */
    @Transactional
    public AlternativePeriod updateFromDto(AlternativePeriodDto alternativePeriodDto) {
        if (alternativePeriodDto == null) {
            throw new InvalidDataException("Cannot update AlternativePeriodDto from null object.")
        }
        if(alternativePeriodDto.id == null) {
            throw new InvalidDataException("Cannot update AlternativePeriodDto from null Id.")
        }
        AlternativePeriod alternativePeriod = findById(alternativePeriodDto.id)
        alternativePeriod.code = alternativePeriodDto.code
        alternativePeriod.description = alternativePeriodDto.description
        if(alternativePeriodDto.blockId != null) {
            alternativePeriod.block = blockService.findById(alternativePeriodDto.blockId)
        }
        alternativePeriod.day = alternativePeriodDto.day
        alternativePeriod.dayPeriod = alternativePeriodDto.dayPeriod
        alternativePeriod.LviStartTime = alternativePeriodDto.LviStartTime
        alternativePeriod.LviEndTime = alternativePeriodDto.LviEndTime
        alternativePeriod.UviStartTime = alternativePeriodDto.UviStartTime
        alternativePeriod.UviEndTime = alternativePeriodDto.UviEndTime
        alternativePeriod.boxNo = alternativePeriodDto.boxNo
        alternativePeriod.cristalPeriod = alternativePeriodDto.cristalPeriod
        alternativePeriod.length = alternativePeriodDto.length
        alternativePeriod.defaultPeriodText = alternativePeriodDto.defaultPeriodText
        return save(alternativePeriod)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. AlternativePeriod should not be deleted.
     */
    @Override
    public void delete(AlternativePeriod obj) {
        throw new InvalidOperationException("AlternativePeriod should not be deleted")
    }
}
