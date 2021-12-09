package uk.ac.reigate.services.ilr

//import static org.springframework.util.Assert

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.ilr.FundingModel
import uk.ac.reigate.dto.FundingModelDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.ilr.FundingModelRepository
import uk.ac.reigate.services.ICoreDataService
import uk.ac.reigate.services.IDtoCreateUpdateService

@Service
class FundingModelService implements ICoreDataService<FundingModel, Integer>, IDtoCreateUpdateService<FundingModelDto, FundingModel>{
    
    @Autowired
    FundingModelRepository fundingModelRepository
    
    /**
     * Default NoArgs constructor
     */
    FundingModelService() {}
    
    /**
     * Autowired Constructor
     *
     * @param fundingModelRepository
     */
    FundingModelService(FundingModelRepository fundingModelRepository) {
        this.fundingModelRepository = fundingModelRepository;
    }
    
    /**
     * Find an individual fundingModel using the fundingModels ID fields
     *
     * @param id the ID fields to search for
     * @return the FundingModel object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    FundingModel findById(Integer id) {
        return fundingModelRepository.findById(id).orElse(null)
    }
    
    /**
     * Find all fundingModels
     *
     * @return a SearchResult set with the list of FundingModels
     */
    @Override
    @Transactional(readOnly = true)
    List<FundingModel> findAll() {
        return fundingModelRepository.findAll()
    }
    
    /**
     * This service method is used to save a complete FundingModel object in the database
     *
     * @param fundingModel the new FundingModel object to be saved
     * @return the saved version of the FundingModel object
     */
    @Override
    @Transactional
    public FundingModel save(FundingModel fundingModel) {
        return fundingModelRepository.save(fundingModel)
    }
    
    /**
     * This service method is used to update an FundingModel object in the database from a partial or complete FundingModel object.
     *
     * @param fundingModel the partial or complete FundingModel object to be saved
     * @return the saved version of the FundingModel object
     */
    @Transactional
    public FundingModel createFromDto(FundingModelDto fundingModel) {
        if(fundingModel == null) {
            throw new InvalidDataException("Cannot create fundingModel from null object.")
        }
        FundingModel fundingModelToSave = new FundingModel()
        fundingModelToSave.code = fundingModel.code != null ? fundingModel.code : fundingModelToSave.code
        fundingModelToSave.description = fundingModel.description != null ? fundingModel.description : fundingModelToSave.description
        fundingModelToSave.shortDescription = fundingModel.shortDescription != null ? fundingModel.shortDescription : fundingModelToSave.shortDescription
        fundingModelToSave.validFrom = fundingModel.validFrom != null ? fundingModel.validFrom : fundingModelToSave.validFrom
        fundingModelToSave.validTo = fundingModel.validTo != null ? fundingModel.validTo : fundingModelToSave.validTo
        
        return save(fundingModelToSave)
    }
    
    /**
     * This service method is used to update an FundingModel object in the database from a partial or complete FundingModel object.
     *
     * @param fundingModel the partial or complete FundingModel object to be saved
     * @return the saved version of the FundingModel object
     */
    @Transactional
    public FundingModel updateFromDto(FundingModelDto fundingModel) {
        if(fundingModel == null) {
            throw new InvalidDataException("Cannot update fundingModel from null object.")
        }
        FundingModel fundingModelToSave = findById(fundingModel.id)
        fundingModelToSave.code = fundingModel.code != null ? fundingModel.code : fundingModelToSave.code
        fundingModelToSave.description = fundingModel.description != null ? fundingModel.description : fundingModelToSave.description
        fundingModelToSave.shortDescription = fundingModel.shortDescription != null ? fundingModel.shortDescription : fundingModelToSave.shortDescription
        fundingModelToSave.validFrom = fundingModel.validFrom != null ? fundingModel.validFrom : fundingModelToSave.validFrom
        fundingModelToSave.validTo = fundingModel.validTo != null ? fundingModel.validTo : fundingModelToSave.validTo
        
        return save(fundingModelToSave)
    }
    
    /**
     * Saves a list of FundingModel objects to the database
     *
     * @param fundingModels a list of FundingModels to be saved to the database
     * @return the list of save FundingModel objects
     */
    @Transactional
    public List<FundingModel> saveFundingModels(List<FundingModel> fundingModels) {
        return fundingModels.collect { fundingModel -> save(fundingModel) }
    }
    
    /**
     * This methods throws an InvalidOperationException when called. FundingModel should not be deleted.
     */
    @Override
    public void delete(FundingModel obj) {
        throw new InvalidOperationException("FundingModel should not be deleted")
    }
}