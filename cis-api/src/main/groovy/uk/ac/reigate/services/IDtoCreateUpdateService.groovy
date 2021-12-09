package uk.ac.reigate.services

/**
 * This interface is used to define a service that is used to create and update data objects 
 * based on a DTO object that is supplied to it. 
 * 
 * @author Michael Horgan
 *
 * @param <DTO> the DTO object that can be used to create/update the data object
 * @param <OBJ> the data object that can be create/updated from the supplied DTO
 */
interface IDtoCreateUpdateService<DTO, OBJ> {
    
    /**
     * This methods is used to create a data object of type <OBJ> from the supplied <DTO> object.
     * 
     * @param dto the <DTO> object to use to create the <OBJ> data object.
     * @return the <OBJ> data object created from the supplied <DTO> 
     */
    OBJ createFromDto(DTO dto)
    
    /**
     * This methods is used to update a data object of type <OBJ> from the supplied <DTO> object.
     * 
     * @param dto the <DTO> object to use to update the <OBJ> data object.
     * @return the <OBJ> data object updated from the supplied <DTO> 
     */
    OBJ updateFromDto(DTO dto)
}
