package uk.ac.reigate.services

import org.springframework.security.access.annotation.Secured
import org.springframework.security.access.prepost.PreAuthorize

import uk.ac.reigate.domain.academic.Student

/**
 * This interface is used to ensure that services used for retrieving student related data have a standard set 
 * of methods, it is also used to ensure that basic security is applied to those methods. To change the security 
 * settings on any of the methods you need to override the @PreAuthorize annotation.
 * 
 * @author Michael Horgan
 *
 * @param <T> the data object to be retrieved by the service
 */
@Secured("IS_AUTHENTICATED_FULLY")
public interface IStudentDataService<T> {
    
    /**
     * This method is used to retrieve the supplied <T> for the given Student data object.
     *  
     * @param student a Student data object to used for the data retrieval.
     * @return 
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    T getByStudent(Student student)
    
    /**
     * This method is used to retrieve the supplied <T> for the given studentId.
     *  
     * @param studentId a studentId to used for the data retrieval.
     * @return 
     */
    @PreAuthorize("@securityChecker.checkReader(authentication)")
    T getByStudentId(Integer studentId)
}
