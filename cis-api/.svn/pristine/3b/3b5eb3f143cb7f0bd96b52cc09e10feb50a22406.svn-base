package uk.ac.reigate.services

import static org.assertj.core.api.Assertions.assertThatExceptionOfType
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

import uk.ac.reigate.domain.academic.Block
import uk.ac.reigate.dto.lookup.BlockDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.exceptions.InvalidOperationException
import uk.ac.reigate.repositories.academic.BlockRepository


class BlockServiceTest {
    
    @Mock
    private BlockRepository blockRepository;
    
    @InjectMocks
    private BlockService blockService;
    
    private Block block
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    /**
     * This method is used to create a sample Block data object to use for the testing
     * 
     * @return a sample Block data object
     */
    Block createBlock() {
        return new Block(
                id: 1,
                code: '1',
                description: 'Block 1',
                htmlColour: 'FF',
                accessColour: 'FFF'
                )
    }
    
    /**
     * This method is used to create a DTO object based on the sample Block created at setup
     * 
     * @return a BlockDto object based on the sample Block
     */
    BlockDto createDto() {
        return new BlockDto(
                id: block.id,
                code: block.code,
                description: block.description,
                htmlColour: block.htmlColour,
                accessColour: block.accessColour
                )
    }
    
    /**
     * This method is used to set up the tests for the BlockService
     */
    @Before
    public void setup() {
        this.blockRepository = Mockito.mock(BlockRepository.class);
        this.blockService = new BlockService(blockRepository);
        
        block = createBlock()
        
        when(blockRepository.save(any(Block.class))).thenReturn(block);
        when(blockRepository.findById(1)).thenReturn(new Optional(block));
    }
    
    /**
     * This method is used to test the Default NoArgs constructor service method
     */
    @Test
    public void testServiceNoArgsConstructor() {
        BlockService service = new BlockService();
        assertNotNull(service)
    }
    
    /**
     * This method is used to test the findAll service method
     */
    @Test
    public void testFindAll() {
        List<Block> result = blockService.findAll();
        verify(blockRepository, times(1)).findAll()
        verifyNoMoreInteractions(blockRepository)
    }
    
    /**
     * This method is used to test the findById service method
     */
    @Test
    public void testFindById() {
        Block result = blockService.findById(1);
        verify(blockRepository, times(1)).findById(1)
        verifyNoMoreInteractions(blockRepository)
    }
    
    /**
     * This method is used to test the save service method
     */
    @Test
    public void testSave() {
        Block savedBlock = blockService.save(block);
        verify(blockRepository, times(1)).save(any())
        verifyNoMoreInteractions(blockRepository)
    }
    
    /**
     * This method is used to test the saveList service method
     */
    @Test
    public void testSaveList() {
        List<Block> savedBlocks = blockService.saveBlocks([block, block]);
        verify(blockRepository, times(2)).save(block)
        verifyNoMoreInteractions(blockRepository)
    }
    
    /**
     * This method is used to test the createFromDto service method
     */
    @Test
    public void testCreateFromDto_dto() {
        BlockDto dto = createDto()
        Block blockSaved = blockService.createFromDto(dto)
        verify(blockRepository, times(1)).save(any(Block.class))
        verifyNoMoreInteractions(blockRepository)
        assertEquals(dto.id, block.id)
        assertEquals(dto.code, block.code)
        assertEquals(dto.description, block.description)
    }
    
    /**
     * This method is used to test the createFromDto service method, when passing in a null dto object
     */
    @Test
    public void testCreateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot create Block from null object.")
        BlockDto dto = null
        blockService.createFromDto(dto)
        verifyNoMoreInteractions(blockRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the updateFromDto service method
     */
    @Test
    public void testUpdateFromDto_dto() {
        BlockDto dto = createDto()
        Block blockSaved = blockService.updateFromDto(dto)
        verify(blockRepository, times(1)).findById(block.id)
        verify(blockRepository, times(1)).save(block)
        verifyNoMoreInteractions(blockRepository)
        assertEquals(block.id, blockSaved.id)
        assertEquals(block.code, blockSaved.code)
        assertEquals(block.description, blockSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a dto object with null values in 
     * certain fields. 
     */
    @Test
    public void testUpdateFromDto_dtoWithNullValues() {
        BlockDto dto = createDto()
        Block blockSaved = blockService.updateFromDto(dto)
        verify(blockRepository, times(1)).findById(block.id)
        verify(blockRepository, times(1)).save(block)
        verifyNoMoreInteractions(blockRepository)
        assertEquals(block.id, blockSaved.id)
        assertEquals(block.code, blockSaved.code)
        assertEquals(block.description, blockSaved.description)
    }
    
    /**
     * This method is used to test the updateFromDto service method, when passing in a null dto object
     */
    @Test
    public void testUpdateFromDto_withNullDto() {
        thrown.expect(InvalidDataException.class)
        thrown.expectMessage("Cannot update Block from null object.")
        BlockDto dto = null
        blockService.updateFromDto(dto)
        verifyNoMoreInteractions(blockRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
    
    /**
     * This method is used to test the delete service method
     */
    @Test
    public void testDelete() {
        thrown.expect(InvalidOperationException.class)
        blockService.delete(block)
        verifyNoMoreInteractions(blockRepository)
        assertThatExceptionOfType(InvalidDataException.class)
    }
}