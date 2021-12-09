package uk.ac.reigate.api

import org.springframework.http.ResponseEntity

/**
 * This interface is used to ensure that an API definition has the required methods defined: 
 * <ul>
 * <li>getById</li>
 * <li>create</li>
 * <li>update</li>
 * </ul>
 *  
 * @author Michael Horgan
 *
 * @param <DTO> the DTO object used for the create and update methods.
 * @param <ID> the data type for the ID for the given API.
 */
public interface ICoreDataBaseApi<DTO, ID> {
    
    /**
     * This method is used to retrieve an instance of the DTO based on the supplied ID field. 
     * 
     * @param id the ID for the data object to retrieve
     * @return an instance of the DTO wrapped in a ResponseEntity 
     */
    ResponseEntity<DTO> getById(ID id)
    
    /**
     * This method is used to create an instance of the data object from the supplied DTO.
     * 
     * @param dto the DTO object to use to create the data object. 
     * @return an instance of the DTO wrapped in a ResponseEntity
     */
    ResponseEntity<DTO> create(DTO dto)
    
    /**
     * This method is used to update an instance of the data object from the supplied DTO.
     * 
     * @param dto the DTO object to use to update the data object. 
     * @return an instance of the DTO wrapped in a ResponseEntity
     */
    ResponseEntity<DTO> update(ID id, DTO dto)
}
