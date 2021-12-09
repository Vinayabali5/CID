package uk.ac.reigate.domain

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass


/**
 * <p>BaseEntity is the basic structure for all entities within the data model. Provided within this basic structure is the ID field that all 
 * entities should have also ensuring all objects are serializable. </p>
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
abstract class BaseEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id
    
    /**
     * No Args constructor for all BaseEntity classes
     */
    BaseEntity() { }
}
