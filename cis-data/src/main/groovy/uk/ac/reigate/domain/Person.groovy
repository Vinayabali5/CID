package uk.ac.reigate.domain

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.lookup.Gender
import uk.ac.reigate.domain.lookup.LegalSex
import uk.ac.reigate.domain.lookup.Title
import uk.ac.reigate.domain.security.Role

@Entity
@AttributeOverrides([
    @AttributeOverride(name = 'id', column = @Column(name = 'person_id'))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includes = ['firstName', 'surname', 'middleNames', 'preferredName', 'previousSurname', 'dob'])
class Person extends BaseEntity implements UserDetails {
    
    /**
     * The title of the person.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'title_id')
    Title title
    
    /**
     * The first name of the person.
     */
    @Column(name = 'first_name')
    String firstName
    
    /**
     * The Preferred name of the person.
     */
    @Column(name = 'preferred_name')
    String preferredName
    
    /**
     * The middle names of the person.
     */
    @Column(name = 'middle_names')
    String middleNames
    
    /**
     * The surname of the person.
     */
    @NotNull
    @Column(name = 'surname')
    String surname
    
    /**
     * The legal surname of the person.
     */
    @Column(name = 'legal_surname')
    String legalSurname
    
    /**
     * The previous surname of the person.
     */
    @Column(name = 'previous_surname')
    String previousSurname
    
    /**
     * The date of Birth of the person.
     */
    @Column(name = 'dob')
    Date dob
    
    /**
     * The gender of the person.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'gender_id')
    Gender gender
    
    /**
     * The legal sex of the person.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = 'legal_sex_id')
    LegalSex legalSex
    
    /**
     * The address of the person.
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinColumn(name = 'address_id')
    Address address
    
    /**
     * The home number of the person.
     */
    @Column(name = 'home')
    String home
    
    /**
     * The mobile number of the person.
     */
    @Column(name = 'mobile')
    String mobile
    
    /**
     * The work number of the person.
     */
    @Column(name = 'work')
    String work
    
    /**
     * The email address of the person.
     */
    @Column(name = 'email')
    String email
    
    /**
     * The username of the person.
     */
    @Column(name = 'username', columnDefinition = 'nvarchar', unique = true)
    String username
    
    /**
     * The password of the person.
     */
    @Column(name = 'password', columnDefinition = 'nvarchar')
    String password
    
    /**
     * This field determines enabled or not.
     */
    @Column(name = 'enabled')
    Boolean enabled
    
    @OneToMany(mappedBy = 'person', fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    List<Contact> contacts
    
    @OneToMany(mappedBy = 'person', fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    Set<Note> notes
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = 'person_role',
    joinColumns = @JoinColumn(name = 'person_id', referencedColumnName = 'person_id'),
    inverseJoinColumns = @JoinColumn(name = 'role_id', referencedColumnName = 'role_id')
    )
    Set<Role> roles
    
    @OneToOne(mappedBy = 'person', fetch = FetchType.LAZY)
    Staff staff
    
    @OneToOne(mappedBy = 'person', fetch = FetchType.LAZY)
    Student student
    
    @Column(name = 'rfid_card_id')
    String rfidCardId
    
    /**
     * No Args Constructor    
     */
    Person() {}
    
    /**
     * The default toString method
     */
    String toString() {
        String personName = ''
        personName += this.surname + ', '
        personName += this.preferredName != null ? this.preferredName : this.firstName
        personName += this.middleNames != null ? ' ' + this.middleNames : ''
        return personName
    }
    
    /**
     * The default toString method
     */
    String toStringWithoutMiddleName() {
        String personName = ''
        personName += this.surname + ', '
        personName += firstOrPreferred()
        return personName
    }
    
    /**
     * This method is used to return the person first name or preferred name. If a preferred name is 
     * supplied then that will be used otherwise the first name is used. 
     * 
     * @return the name to use for the person
     */
    String firstOrPreferred() {
        return this.preferredName != null ? this.preferredName : this.firstName
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return !enabled;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return !enabled;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return !enabled;
    }
    
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
