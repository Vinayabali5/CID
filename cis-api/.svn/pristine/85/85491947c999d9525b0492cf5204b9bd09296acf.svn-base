package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import lombok.RequiredArgsConstructor
import uk.ac.reigate.domain.academic.Block
import uk.ac.reigate.domain.academic.Period
import uk.ac.reigate.dto.PeriodDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.PeriodRepository

@Service
@RequiredArgsConstructor
class PeriodService implements ICoreDataService<Period, Integer>, IDtoCreateUpdateService<PeriodDto, Period>{
    
    @Autowired
    PeriodRepository periodRepository
    
    @Autowired
    private final BlockService blockService
    /**
     * Default NoArgs constructor
     */
    PeriodService() {}
    
    /**
     * Autowired Constructor
     *
     * @param periodRepository
     */
    PeriodService(PeriodRepository periodRepository, BlockService blockService){
        super();
        this.periodRepository = periodRepository;
        this.blockService = blockService;
    }
    
    /**
     * Find an individual period using the periods ID fields
     *
     * @param id the ID fields to search for
     * @return the Period object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Period findById(Integer id) {
        return periodRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all periods
     *
     * @return a SearchResult set with the list of Periods
     */
    @Override
    @Transactional(readOnly = true)
    List<Period> findAll() {
        return periodRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Period object in the database
     *
     * @param period the new Period object to be saved
     * @return the saved version of the Period object
     */
    @Override
    @Transactional
    public Period save(Period period) {
        return periodRepository.save(period)
    }
    
    /**
     * Saves a list of Period objects to the database
     *
     * @param periods a list of Periods to be saved to the database
     * @return the list of save Period objects
     */
    @Transactional
    public List<Period> savePeriods(List<Period> periods) {
        return periods.collect { period -> save(period) };
    }
    
    /**
     * This service method is used to create a period object in the database from a partial or complete Period object.
     * 
     * @param period the partial or complete Period object to be saved
     * @return the saved version of the Period object
     */
    @Transactional
    public Period createFromDto(PeriodDto periodDto) {
        if (periodDto == null) {
            throw new InvalidDataException("Cannot create periodDto from null object.")
        }
        Period period = new Period()
        period.code = periodDto.code
        period.description = periodDto.description
        if(periodDto.blockId != null) {
            period.block = blockService.findById(periodDto.blockId)
        }
        period.startTime = periodDto.startTime
        period.endTime = periodDto.endTime
        period.day = periodDto.day
        period.dayPeriod = periodDto.dayPeriod
        period.boxNo = periodDto.boxNo
        period.cristalPeriod = periodDto.cristalPeriod
        period.length = periodDto.length
        period.defaultPeriodText = periodDto.defaultPeriodText
        return save(period)
    }
    
    /**
     * This service method is used to update a period object in the database from a partial or complete Period object.
     *
     * @param period the partial or complete Period object to be saved
     * @return the saved version of the Period object
     */
    @Transactional
    public Period updateFromDto(PeriodDto periodDto) {
        if (periodDto == null) {
            throw new InvalidDataException("Cannot update periodDto from null object.")
        }
        if(periodDto.id == null) {
            throw new InvalidDataException("Cannot update periodDto from null Id.")
        }
        Period period = findById(periodDto.id)
        if(periodDto.blockId != null) {
            period.block = blockService.findById(periodDto.blockId)
        }
        period.code = periodDto.code
        period.description = periodDto.description
        period.startTime = periodDto.startTime
        period.endTime = periodDto.endTime
        period.day = periodDto.day
        period.dayPeriod = periodDto.dayPeriod
        period.boxNo = periodDto.boxNo
        period.cristalPeriod = periodDto.cristalPeriod
        period.length = periodDto.length
        period.defaultPeriodText = periodDto.defaultPeriodText
        return save(period)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Period should not be deleted.
     */
    @Override
    public void delete(Period obj) {
        throw new InvalidOperationException("Period should not be deleted")
    }
}
