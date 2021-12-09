package uk.ac.reigate.api;

import org.springframework.http.ResponseEntity

/**
 * This interface is used to ensure that an API definition has the required methods defined: 
 * <ul>
 * <li>getAll</li>
 * </ul>
 * 
 * @author Michael Horgan
 * 
 * @param <DTO> the DTO object used for the create and update methods.
 * @param <ID> the data type for the ID for the given API.
 * 
 * @see ICoreDataBaseApi
 */
public interface ICoreDataApi<DTO, ID> extends ICoreDataBaseApi<DTO, ID> {
    
    /**
     * This method is used to retrieve all instances of the data object in the form of the DTO. 
     * 
     * @return a List of DTOs 
     */
    ResponseEntity<List<DTO>> getAll()
}
