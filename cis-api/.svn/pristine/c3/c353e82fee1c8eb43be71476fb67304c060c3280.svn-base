package uk.ac.reigate.dto.lookup;

import groovy.transform.EqualsAndHashCode;
import javax.validation.constraints.NotNull
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.academic.Block

/**
 *
 * JSON serializable DTO containing Block data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class BlockDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @NotNull
    @JsonProperty
    private String code;
    
    @NotNull
    @JsonProperty
    private String description;
    
    @JsonProperty
    private String htmlColour
    
    @JsonProperty
    private String accessColour
    
    /**
     * Default No Args constructor
     */
    public BlockDto() {
    }
    
    /**
     * Constructor to create a BlockDto object from a Block object
     *
     * @param block the Block object to use for construction
     */
    BlockDto(Block block) {
        if(block != null) {
            this.id = block.id;
            this.code = block.code;
            this.description = block.description;
            this.htmlColour = block.htmlColour;
            this.accessColour = block.accessColour
        }
    }
    
    /**
     * This static method is used to create a BlockDto from a Block data object.
     *
     * @param block the Block data object to use for the creation.
     * @return a BlockDto object based on the Block data object supplied.
     */
    public static BlockDto mapFromEntity(Block block) {
        return new BlockDto(block);
    }
    
    /**
     * This static method is used to create a List of BlockDto from a List of Block data object.
     *
     * @param blocks the List of Block data object to use for the creation.
     * @return a List of BlockDto object based on the List of Block data object supplied.
     */
    public static List<BlockDto> mapFromList(List<Block> blocks) {
        return blocks.collect { block ->  new BlockDto(block) };
    }
}