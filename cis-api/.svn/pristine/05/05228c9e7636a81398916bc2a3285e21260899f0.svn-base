package uk.ac.reigate.dto.lookup;


import groovy.transform.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import uk.ac.reigate.domain.lookup.FileCategory

/**
 *
 * JSON serializable DTO containing FileCategory data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class FileCategoryDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    /**
     * Default No Args constructor
     */
    public FileCategoryDto() {
    }
    
    /**
     * Constructor to create a FileCategoryDto object from a FileCategory object
     *
     * @param fileCategory the FileCategory object to use for construction
     */
    FileCategoryDto(FileCategory fileCategory) {
        if(fileCategory != null) {
            this.id = fileCategory.id;
            this.code = fileCategory.code;
            this.description = fileCategory.description;
        }
    }
    
    /**
     * This static method is used to create a FileCategoryDto from a FileCategory data object.
     *
     * @param fileCategory the FileCategory data object to use for the creation.
     * @return a FileCategoryDto object based on the FileCategory data object supplied.
     */
    public static FileCategoryDto mapFromEntity(FileCategory fileCategory) {
        return new FileCategoryDto(fileCategory);
    }
    
    /**
     * This static method is used to create a List of FileCategoryDto from a List of FileCategory data object.
     *
     * @param fileCategories the List of FileCategory data object to use for the creation.
     * @return a List of FileCategoryDto object based on the List of FileCategory data object supplied.
     */
    public static List<FileCategoryDto> mapFromList(List<FileCategory> fileCategories) {
        return fileCategories.collect { fileCategory ->  new FileCategoryDto(fileCategory) };
    }
}
