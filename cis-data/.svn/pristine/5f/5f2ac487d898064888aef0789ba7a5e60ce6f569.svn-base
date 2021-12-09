package uk.ac.reigate.domain

import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode
class PersonAlias {
    
    @Id
    @Column(name = "person_username")
    String personUsername
    
    @Column(name = "alias_username")
    String aliasUsername
    
    @Column(name = "in_use", columnDefinition = "bit default 1")
    Boolean inUse
}
