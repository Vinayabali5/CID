package uk.ac.reigate.domain

import javax.persistence.Column
import javax.persistence.MappedSuperclass

/**
 * <p>CodedEntityNoIdentity is the basic structure for all entities that have some form of code within the data model.</p> 
 * 
 * <p>Fields included by default are: <ul>
 * <li>id</li>
 * <li>code</li>
 * <li>description</li>
 * </ul>
 * </p>
 *  
 * @author Michael Horgan
 *
 */
@MappedSuperclass
abstract class CodedEntityNoIdentity extends BaseEntityNoIdentity {
    
    @Column(name="code")
    String code
    
    @Column(name="description")
    String description
    
    /**
     * ToString function that returns the code for a CodedEntity
     */
    String toString() {
        return code
    }
}
