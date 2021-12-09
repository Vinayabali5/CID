package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Block
import uk.ac.reigate.dto.lookup.BlockDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.exceptions.NotFoundException
import uk.ac.reigate.repositories.academic.BlockRepository

@Service
class BlockService implements ICoreDataService<Block, Integer>, IDtoCreateUpdateService<BlockDto, Block> {
    
    @Autowired
    BlockRepository blockRepository
    
    /**
     * Default NoArgs constructor
     */
    BlockService() {}
    
    /**
     * Autowired Constructor
     *
     * @param blockRepository
     */
    BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository
    }
    
    /**
     * Find an individual block using the blocks ID fields
     *
     * @param id the ID fields to search for
     * @return the Block object that matches the ID supplied, or null if not found
     */
    @Override
    @Transactional(readOnly = true)
    Block findById(Integer id) {
        return blockRepository.findById(id).orElse(null)
    }
    
    /**
     * Find a single page of Block objects
     * @return a SearchResult set with the list of Blocks
     */
    @Override
    @Transactional(readOnly = true)
    List<Block> findAll() {
        return blockRepository.findAll();
    }
    
    /**
     * This service method is used to save a complete Block object in the database
     *
     * @param block the new Block object to be saved
     * @return the saved version of the Block object
     */
    @Override
    @Transactional
    public Block save(Block block) {
        return blockRepository.save(block)
    }
    
    /**
     * This service method is used to create a Block object in the database from a partial or complete Block object.
     *
     * @param block the partial or complete Block object to be saved
     * @return the saved version of the Block object
     */
    @Transactional
    public Block createFromDto(BlockDto block) {
        if(block == null) {
            throw new InvalidDataException("Cannot create Block from null object.")
        }
        Block blockToSave = new Block()
        blockToSave.code = block.code
        blockToSave.description = block.description
        blockToSave.htmlColour = block.htmlColour
        blockToSave.accessColour = block.accessColour
        return save(blockToSave)
    }
    
    /**
     * This service method is used to update a Block object in the database from a partial or complete Block object.
     *
     * @param block the partial or complete Block object to be saved
     * @return the saved version of the Block object
     */
    @Transactional
    public Block updateFromDto(BlockDto block) {
        if(block == null) {
            throw new InvalidDataException("Cannot update Block from null object.")
        }
        Block blockToSave = findById(block.id)
        blockToSave.code = block.code
        blockToSave.description = block.description
        blockToSave.htmlColour = block.htmlColour
        blockToSave.accessColour = block.accessColour
        return save(blockToSave)
    }
    
    /**
     * Saves a list of Block objects to the database
     *
     * @param blocks a list of Blocks to be saved to the database
     * @return the list of save Block objects
     */
    @Transactional
    public List<Block> saveBlocks(List<Block> blocks) {
        return blocks.collect { block -> save(block) };
    }
    
    /**
     * This methods throws an InvalidOperationException when called. Block should not be deleted.
     */
    @Override
    public void delete(Block obj) {
        throw new InvalidOperationException("Block should not be deleted.")
    }
}
