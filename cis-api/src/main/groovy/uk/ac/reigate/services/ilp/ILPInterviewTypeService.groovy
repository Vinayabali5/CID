package uk.ac.reigate.services.ilp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilp.ILPInterviewType
import uk.ac.reigate.dto.ilp.ILPInterviewTypeDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.ilp.ILPInterviewTypeRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class ILPInterviewTypeService implements ICoreDataService<ILPInterviewType, Integer>, IDtoCreateUpdateService<ILPInterviewTypeDto, ILPInterviewType>{
    
    @Autowired
    ILPInterviewTypeRepository iLPInterviewTypeRepository
    
    /**
     * Default NoArgs constructor    
     */
    ILPInterviewTypeService() {}
    
    /**
     * Autowired constructor
     * 
     * @param iLPInterviewTypeRepository
     */
    ILPInterviewTypeService(ILPInterviewTypeRepository iLPInterviewTypeRepository) {
        this.iLPInterviewTypeRepository = iLPInterviewTypeRepository
    }
    
    /**
     * Find an individual iLPInterviewType using the iLPInterviewTypes ID fields
     *
     * @param id the ID fields to search for
     * @return the ILPInterviewType object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    ILPInterviewType findById(Integer id) {
        return iLPInterviewTypeRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all iLPInterviewTypes
     *
     * @return a SearchResult set with the list of ILPInterviewTypes
     */
    @Override
    @Transactional(readOnly = true)
    List<ILPInterviewType> findAll() {
        return iLPInterviewTypeRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete ILPInterviewType object in the database
     *
     * @param iLPInterviewType the new ILPInterviewType object to be saved
     * @return the saved version of the ILPInterviewType object
     */
    @Override
    @Transactional
    public ILPInterviewType save(ILPInterviewType iLPInterviewType) {
        return iLPInterviewTypeRepository.save(iLPInterviewType)
    }
    
    /**
     * This service method is used to create an ILPInterviewType object in the database from a partial or complete ILPInterviewType object.
     *
     * @param iLPInterviewType the partial or complete ILPInterviewType object to be saved
     * @return the saved version of the ILPInterviewType object
     */
    @Transactional
    public ILPInterviewType createFromDto(ILPInterviewTypeDto iLPInterviewType) {
        if(iLPInterviewType == null) {
            throw new InvalidDataException("Cannot create ILPInterviewType from null object.")
        }
        ILPInterviewType iLPInterviewTypeToSave = new ILPInterviewType()
        iLPInterviewTypeToSave.type = iLPInterviewType.type
        iLPInterviewTypeToSave.requireCourseGroupId = iLPInterviewType.requireCourseGroupId
        iLPInterviewTypeToSave.allowLipReferral = iLPInterviewType.allowLipReferral
        iLPInterviewTypeToSave.allowEmailRelatedStaff = iLPInterviewType.allowEmailRelatedStaff
        iLPInterviewTypeToSave.defaultToPrivate = iLPInterviewType.defaultToPrivate
        iLPInterviewTypeToSave.requireTarget = iLPInterviewType.requireTarget
        return save(iLPInterviewTypeToSave)
    }
    
    /**
     * This service method is used to update an ILPInterviewType object in the database from a partial or complete ILPInterviewType object.
     *
     * @param iLPInterviewType the partial or complete ILPInterviewType object to be saved
     * @return the saved version of the ILPInterviewType object
     */
    @Transactional
    public ILPInterviewType updateFromDto(ILPInterviewTypeDto iLPInterviewType) {
        if(iLPInterviewType == null) {
            throw new InvalidDataException("Cannot update ILPInterviewType from null object.")
        }
        ILPInterviewType iLPInterviewTypeToSave = findById(iLPInterviewType.id)
        iLPInterviewTypeToSave.type = iLPInterviewType.type
        iLPInterviewTypeToSave.requireCourseGroupId = iLPInterviewType.requireCourseGroupId
        iLPInterviewTypeToSave.allowLipReferral = iLPInterviewType.allowLipReferral
        iLPInterviewTypeToSave.allowEmailRelatedStaff = iLPInterviewType.allowEmailRelatedStaff
        iLPInterviewTypeToSave.defaultToPrivate = iLPInterviewType.defaultToPrivate
        iLPInterviewTypeToSave.requireTarget = iLPInterviewType.requireTarget
        return save(iLPInterviewTypeToSave)
    }
    
    /**
     * Saves a list of ILPInterviewType objects to the database
     *
     * @param iLPInterviewTypes a list of ILPInterviewTypes to be saved to the database
     * @return the list of save ILPInterviewType objects
     */
    @Transactional
    public List<ILPInterviewType> saveILPInterviewTypes(List<ILPInterviewType> iLPInterviewTypes) {
        return iLPInterviewTypes.collect { iLPInterviewType -> save(iLPInterviewType) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Block should not be deleted.
     */
    @Override
    public void delete(ILPInterviewType obj) {
        throw new InvalidDataException("ILPInterviewType should not be deleted")
    }
}
