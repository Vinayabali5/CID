package uk.ac.reigate.domain

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass


/**
 * <p>BaseEntityNoIdentity is the basic structure for all entities within the data model. Provided within this basic structure is 
 * the ID field that all entities should have also ensuring all objects are serializable. The ID field for this class is not set 
 * so it will default to assigned as the generator.</p>
 * 
 * <p>
 * Fields included by default are: 
 * <ul>
 * <li>id</li>
 * </ul>
 * </p>
 * 
 * @author Michael Horgan
 *
 */

@MappedSuperclass
abstract class BaseEntityNoIdentity implements Serializable {
    
    @Id
    Integer id
    
    /**
     * No Args constructor for all BaseEntity classes
     */
    BaseEntityNoIdentity() { }
}
