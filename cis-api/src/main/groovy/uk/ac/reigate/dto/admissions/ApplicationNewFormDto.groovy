package uk.ac.reigate.dto.admissions

import groovy.transform.EqualsAndHashCode

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Past
import javax.validation.constraints.Size

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import org.springframework.format.annotation.DateTimeFormat

import uk.ac.reigate.domain.Contact
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.AddressDto
import uk.ac.reigate.dto.RequestDto

/**
 * The ApplicationForm object is a form backing object that is used to create new applications only.
 *
 * @author Michael Horgan, Vinaya Bali
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
class ApplicationNewFormDto implements Serializable{
    
    /*
     * Phase 1 Fields
     */
    
    @JsonProperty
    Integer id
    
    /**
     * This fields represents the year the student initially applied to the College.
     */
    @JsonProperty
    Integer academicYearId
    
    @JsonProperty
    String referenceNo
    
    @JsonProperty
    @NotNull
    Date received
    
    /**
     * This field represents the year of the current application.
     */
    @JsonProperty
    Integer yearId
    
    @JsonProperty
    Integer personId
    
    @JsonProperty
    @NotEmpty
    @Size(min=2, max=50)
    String firstName
    
    @JsonProperty
    @NotEmpty
    @Size(min=2, max=50)
    String surname
    
    @JsonProperty
    String middleNames
    
    @JsonProperty
    String preferredName
    
    @JsonProperty
    String previousSurname
    
    @JsonProperty
    String legalSurname
    
    @JsonProperty
    @NotNull
    @Past
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date dob
    
    @JsonProperty
    @NotNull
    Integer legalSexId
    
    @JsonProperty
    Integer genderId
    
    @JsonProperty
    Integer titleId
    
    @JsonProperty
    String home
    
    @JsonProperty
    String mobile
    
    @JsonProperty
    String email
    
    @JsonProperty
    String countryOfResidence
    
    @JsonProperty
    Boolean resident
    
    @JsonProperty
    AddressDto address
    
    @JsonProperty
    String line1
    
    @JsonProperty
    String line2
    
    @JsonProperty
    String line3
    
    @JsonProperty
    String line4
    
    @JsonProperty
    String line5
    
    @JsonProperty
    String buildingName
    
    @JsonProperty
    String subBuilding
    
    @JsonProperty
    String udprn
    
    @JsonProperty
    String street
    
    @JsonProperty
    String town
    
    @JsonProperty
    String county
    
    @JsonProperty
    String postcode
    
    @JsonProperty
    Boolean sibling
    
    @JsonProperty
    String siblingName
    
    @JsonProperty
    Integer siblingYear
    
    @JsonProperty
    String siblingAdmNo
    
    @JsonProperty
    @NotNull
    Integer schoolId
    
    @JsonProperty
    List<Contact> contacts
    
    @JsonProperty
    List<RequestDto> requests
    
    @JsonProperty
    String uln
    
    @JsonProperty
    String uci
    
    @JsonProperty
    String admissionsNotes
    
    /**
     * Default noargs constructor for new blank ApplicationForm
     */
    ApplicationNewFormDto() {
    }
    
    /**
     * A constructor that uses an Application object to populate the required fields.
     *
     * @param app an Application object, typically retrieved from the database
     */
    ApplicationNewFormDto(Student student) {
        this.id = student.id
        this.referenceNo = student.referenceNo
        this.received = student.received
        this.academicYearId = student.academicYear != null ? student.academicYear.id : null
        
        // Load Person fields
        this.personId = student.person.id
        this.firstName = student.person.firstName
        this.surname = student.person.surname
        this.middleNames = student.person.middleNames
        this.preferredName = student.person.preferredName
        this.previousSurname = student.person.previousSurname
        this.legalSurname = student.person.legalSurname
        this.dob = student.person.dob
        this.legalSexId = student.person.legalSex != null ? student.person.legalSex.id : null
        this.genderId = student.person.gender != null ? student.person.gender.id : null
        this.titleId = student.person.title != null ? student.person.title.id : null
        this.home = student.person.home
        this.mobile = student.person.mobile
        this.email = student.person.email
        this.countryOfResidence = student.countryOfResidence
        this.resident = student.resident
        
        // Load Person.Address fields
        this.address = AddressDto.mapFromEntity(student.person.address)
        this.line1 = student.person.address.line1
        this.line2 = student.person.address.line2
        this.line3 = student.person.address.line3
        this.line4 = student.person.address.line4
        this.line5 = student.person.address.line5
        this.buildingName = student.person.address.buildingName
        this.subBuilding = student.person.address.subBuilding
        this.postcode = student.person.address.postcode
        this.town = student.person.address.town
        this.county = student.person.address.county
        this.postcode = student.person.address.postcode
        
        // Load Contacts
        this.contacts = ContactDto.mapFromList(student.person.contacts)
        
        // Load sibling fields
        this.sibling = student.sibling
        this.siblingName = student.siblingName
        this.siblingYear = student.siblingYear
        this.siblingAdmNo = student.siblingAdmNo
        
        //load school field
        this.schoolId = student.school != null ? student.school.id : null
        this.uln = student.uln
        this.uci = student.uci
        this.admissionsNotes = student.admissionsNotes
        
        this.requests = RequestDto.mapFromList(student.requests)
        
    }
    
    /**
     * This static method is used to create a ApplicationNewFormDto from a Student data object.
     *
     * @param student the Student data object to use for the creation.
     * @return a ApplicationNewFormDto object based on the Student data object supplied.
     */
    public static ApplicationNewFormDto mapFromEntity(Student student) {
        return new ApplicationNewFormDto(student)
    }
    
    /**
     * This static method is used to create a List of ApplicationNewFormDto from a List of Student data object.
     *
     * @param students the List of Student data object to use for the creation.
     * @return a List of ApplicationNewFormDto object based on the List of Student data object supplied.
     */
    public static List<ApplicationNewFormDto> mapFromList(List<Student> students) {
        return students.collect { student ->  mapFromEntity(student) };
    }
}
