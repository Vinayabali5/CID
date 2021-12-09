package uk.ac.reigate.domain

import javax.persistence.Column
import javax.persistence.MappedSuperclass

/**
 * <p>CodedEntityNoIdentity is the basic structure for all entities that have some form of name within the data model.</p> 
 * 
 * <p>Fields included by default are: <ul>
 * <li>id</li>
 * <li>name</li>
 * <li>description</li>
 * </ul>
 * </p>
 *  
 * @author Michael Horgan
 *
 */
@MappedSuperclass
abstract class NamedEntityNoIdentity extends BaseEntityNoIdentity {
    
    @Column(name="name")
    String name
    
    @Column(name="description")
    String description
    
    /**
     * ToString function that returns the name for a CodedEntity
     */
    String toString() {
        return name
    }
}
