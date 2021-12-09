package uk.ac.reigate.domain

import groovy.transform.EqualsAndHashCode

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import uk.ac.reigate.domain.security.Role

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
@IdClass(PersonRolePk.class)
class PersonRole implements Serializable {
    
    @Id
    @OneToOne
    @JoinColumn(name = 'person_id')
    Person person
    
    @Id
    @OneToOne
    @JoinColumn(name = 'role_id')
    Role role
    
    /**
     * Default noArgs constructor
     */
    PersonRole() {}
    
    PersonRole(Person person, Role role){
        this.role = role;
        this.person = person;
    }
    
    String toString() {
        return person
    }
}
