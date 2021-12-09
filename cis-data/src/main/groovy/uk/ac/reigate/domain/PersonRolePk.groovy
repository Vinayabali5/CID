package uk.ac.reigate.domain

import groovy.transform.EqualsAndHashCode;

import javax.persistence.Embeddable

import uk.ac.reigate.domain.security.Role

@Embeddable
@EqualsAndHashCode(includeFields=true)
class PersonRolePk implements Serializable {
    
    Integer person
    
    Integer role
    
    PersonRolePk() {}
    
    PersonRolePk(Integer personId, Integer roleId) {
        super();
        this.person = personId;
        this.role = roleId;
    }
    
    PersonRolePk(Person person, Role role) {
        super();
        this.person = person.id;
        this.role = role.id;
    }
}
