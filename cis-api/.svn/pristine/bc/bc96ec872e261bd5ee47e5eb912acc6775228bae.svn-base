package uk.ac.reigate.services

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.transaction.annotation.Transactional

/**
 * This interface is used to ensure that services used for updating data have a standard set of methods, 
 * it is also used to ensure that basic security is applied to those methods. To change the security settings
 * on any of the methods you need to override the @PreAuthorize annotation.
 * 
 * @author Michael Horgan
 *
 * @param <T> the data object to be retrieved by the service
 * @param <ID> the ID type of the data object
 */
public interface IUpdatingCoreDataService<T, ID> extends ICoreDataService<T, ID> {
    
    @PreAuthorize("@securityChecker.checkWriter(authentication)")
    @Transactional(readOnly = true)
    T update(T obj)
}
