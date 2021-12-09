package uk.ac.reigate.services

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import lombok.RequiredArgsConstructor
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.Holiday
import uk.ac.reigate.domain.lookup.BursaryType
import uk.ac.reigate.dto.HolidayDto
import uk.ac.reigate.dto.lookup.BursaryTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.HolidayRepository

@Service
@RequiredArgsConstructor
class HolidayService implements ICoreDataService<Holiday, Integer>, IDtoCreateUpdateService<HolidayDto, Holiday>{
    
    @Autowired
    HolidayRepository holidayRepository
    
    @Autowired
    private final AcademicYearService academicYearService;
    
    /**
     * Default NoArgs constructor
     */
    HolidayService() {}
    
    /**
     * Autowired Constructor
     *
     * @param holidayRepository
     */
    HolidayService(HolidayRepository holidayRepository, AcademicYearService academicYearService) {
        super()
        this.holidayRepository = holidayRepository;
        this.academicYearService = academicYearService;
    }
    
    /**
     * Find an individual holiday using the holidays ID fields
     *
     * @param id the ID fields to search for
     * @return the Holiday object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Holiday findById(Integer id) {
        return holidayRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all holidays
     *
     * @return a List of Holidays
     */
    @Override
    @Transactional(readOnly = true)
    List<Holiday> findAll() {
        return holidayRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Holiday object in the database
     *
     * @param holiday the new Holiday object to be saved
     * @return the saved version of the Holiday object
     */
    @Override
    @Transactional
    public Holiday save(Holiday holiday) {
        return holidayRepository.save(holiday)
    }
    
    /**
     * Saves a list of Holiday objects to the database
     *
     * @param holidays a list of Holidays to be saved to the database
     * @return the list of save Holiday objects
     */
    @Transactional
    public List<Holiday> saveHolidays(List<Holiday> holidays) {
        return holidays.collect { holiday -> save(holiday) };
    }
    
    /**
     * This service method is used to create an BursaryType object in the database from a partial or complete BursaryType object.
     *
     * @param bursaryType the partial or complete BursaryType object to be saved
     * @return the saved version of the BursaryType object
     */
    @Transactional
    public Holiday createFromDto(HolidayDto holidayDto) {
        if (holidayDto == null) {
            throw new InvalidDataException("Cannot create holidayDto from null object.")
        }
        Holiday holiday = new Holiday()
        if (holidayDto.yearId != null) {
            holiday.year = academicYearService.findById(holidayDto.yearId)
        }
        holiday.description = holidayDto.description;
        holiday.startDate = holidayDto.startDate;
        holiday.endDate = holidayDto.endDate;
        holiday.halfTerm = holidayDto.halfTerm;
        return save(holiday)
    }
    
    /**
     * This service method is used to create an BursaryType object in the database from a partial or complete BursaryType object.
     *
     * @param bursaryType the partial or complete BursaryType object to be saved
     * @return the saved version of the BursaryType object
     */
    @Transactional
    public Holiday updateFromDto(HolidayDto holidayDto) {
        if(holidayDto.id == null) {
            throw new InvalidDataException("Cannot update holidayDto from null object.")
        }
        Holiday holiday = findById(holidayDto.id)
        if (holidayDto.yearId != null) {
            holiday.year = academicYearService.findById(holidayDto.yearId)
        }
        holiday.description = holidayDto.description;
        holiday.startDate = holidayDto.startDate;
        holiday.endDate = holidayDto.endDate;
        holiday.halfTerm = holidayDto.halfTerm;
        return save(holiday)
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Holiday should not be deleted.
     */
    @Override
    public void delete(Holiday obj) {
        throw new InvalidOperationException("Holiday should not be deleted")
    }
    
}
