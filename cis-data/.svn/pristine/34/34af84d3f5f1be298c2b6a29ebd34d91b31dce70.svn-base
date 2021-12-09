package uk.ac.reigate.domain

import javax.persistence.Column
import javax.persistence.MappedSuperclass

/**
 * <p>NamedEntity is the basic structure for all entities that have some form of name within the data model. </p> 
 * 
 * <p>
 * Fields included by default are:
 * <ul>
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
class NamedEntity extends BaseEntity {
    
    @Column(name="name")
    String name
    
    @Column(name="description")
    String description
    
    /**
     * Default No Args constructor
     */
    public NamedEntity() {}
    
    /**
     * The default toString method
     */
    String toString() {
        return name
    }
}
