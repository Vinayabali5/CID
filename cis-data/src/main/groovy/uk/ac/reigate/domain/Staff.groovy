package uk.ac.reigate.domain

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.lookup.Ethnicity
import uk.ac.reigate.domain.lookup.StaffType
import uk.ac.reigate.domain.staff.Disability
import uk.ac.reigate.domain.staff.MaritalStatus
import uk.ac.reigate.domain.staff.Religion
import uk.ac.reigate.domain.staff.SexualOrientation

@Entity
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "staff_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields = true, includes = ['person', 'onTimetable', 'initials', 'knownAs', 'networkLogin'])
class Staff extends BaseEntity {
    
    /**
     * The Person object associated with the Staff
     */
    @NotNull
    @OneToOne(fetch = FetchType.EAGER, cascade=[CascadeType.ALL])
    @JoinColumn(name='person_id')
    Person person
    
    /**
     * The staff type of the staff
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name='staff_type_id')
    StaffType type
    
    /**
     * This field determines the onTimetable or not.
     */
    @Column(name="on_timetable")
    Boolean onTimetable
    
    /**
     * The initials of the staff.
     */
    @Column(name="initials")
    String initials
    
    /**
     * The knownAs of the staff.
     */
    @Column(name="known_as")
    String knownAs
    
    /**
     * The network login of the staff.
     */
    @Column(name="network_login")
    String networkLogin
    
    /**
     * The start date of the staff
     */
    @Column(name="start_date")
    Date startDate
    
    @Column(name="continual_service_start_date")
    Date continualServiceStartDate
    
    /**
     * The end date of the staff.
     */
    @Column(name="end_date")
    Date endDate
    
    /**
     * Staff_Ref from cristal
     */
    @Column(name="staff_ref")
    Integer staffRef
    
    /**
     * StaffDetailsID from buildings
     */
    @Column(name="staff_details_id")
    Integer staffDetailsId
    
    @Column(name="STAFFEMAIL")
    String staffEmail
    
    @Column(name="signature")
    String signature
    
    // Emergency contact information
    @Column(name="emergency_contact_name")
    String emergencyContactName
    
    @Column(name="emergency_contact_relationship")
    String emergencyContactRelationship
    
    @Column(name="emergency_contact_number")
    String emergencyContactNumber
    
    //References
    
    @Column(name="ni_number")
    String niNumber
    
    @Column(name="dfe_number")
    String dfeNumber
    
    @JoinColumn(name = 'nationality')
    String nationality
    
    @OneToOne
    @JoinColumn(name = 'ethnicity_id')
    Ethnicity ethnicity
    
    @OneToOne
    @JoinColumn(name = 'disability_id')
    Disability disability
    
    @OneToOne
    @JoinColumn(name = 'sexual_orientation_id')
    SexualOrientation sexualOrientation
    
    @OneToOne
    @JoinColumn(name = 'marital_status_id')
    MaritalStatus maritalStatus
    
    @OneToOne
    @JoinColumn(name = 'religion_id')
    Religion religion
    
    
    
    /**
     * Default No Args constructor
     */
    Staff(){}
    
    /**
     * The default toString method
     */
    String toString() {
        return initials + ' - ' + person.toStringWithoutMiddleName()
    }
}
