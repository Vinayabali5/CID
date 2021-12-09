package uk.ac.reigate.dto.integration

import java.time.LocalDate
import java.time.ZoneId

import javax.validation.constraints.NotNull
import javax.validation.constraints.Past
import javax.validation.constraints.Size

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty

import org.springframework.format.annotation.DateTimeFormat

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.dto.IAddressDTO

class ApplicationImportDTO implements IAddressDTO {
    
    @JsonProperty
    Integer id
    
    @JsonProperty
    Integer originalId
    
    @JsonProperty
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date received
    
    @JsonProperty
    @Size(min=2, max=50)
    String firstName
    
    @JsonProperty
    @Size(min=2, max=50)
    String surname
    
    @JsonProperty
    String middleNames
    
    @JsonProperty
    String preferredName
    
    @JsonProperty
    String previousSurname
    
    @JsonProperty
    @NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate dob
    
    @JsonProperty
    @NotNull
    String genderCode
    
    @JsonProperty
    String title
    
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
    String town
    
    @JsonProperty
    String county
    
    @JsonProperty
    String postcode
    
    @JsonProperty
    String schoolName
    
    @JsonProperty
    String schoolUrn
    
    @JsonProperty
    String schoolUkprn
    
    @JsonProperty
    List<ContactImportDTO> contacts
    
    @JsonProperty
    List<String> requestCodes
    
    @JsonProperty
    Boolean ehcp
    
    @JsonProperty
    String ethnicityCode
    
    @JsonProperty
    String hasLLDD
    
    @JsonProperty
    List<LLDDImportDto> lldds
    
    /**
     * Default No Args constructor
     */
    ApplicationImportDTO() {
    }
    
    
    ApplicationImportDTO(Student student) {
        this.id = student.id
        this.received = student.received
        if (student.person != null) {
            this.firstName = student.person.firstName
            this.surname = student.person.surname
            this.middleNames  = student.person.middleNames
            this.preferredName = student.person.preferredName
            this.previousSurname = student.person.previousSurname
            this.dob = student.person.dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
            this.genderCode = student.person.gender != null ? student.person.gender.code : null
            this.title = student.person.title != null ? student.person.title.code : null
            this.home = student.person.home
            this.mobile = student.person.mobile
            this.email = student.person.email
            if (student.person.address != null) {
                this.line1 = student.person.address.line1
                this.line2 = student.person.address.line2
                this.line3 = student.person.address.line3
                this.line4 = student.person.address.line4
                this.line5 = student.person.address.line5
                this.postcode = student.person.address.postcode
            }
        }
        this.countryOfResidence = student.countryOfResidence
        this.resident = student.resident
        this.schoolName = student.school != null ? student.school.name : null
        this.schoolUrn = student.school != null ? student.school.urn : null
        this.schoolUkprn = student.school != null ? student.school.ukprn : null
        this.ehcp = student.ehcp
        this.ethnicityCode = student.ethnicity != null ? student.ethnicity.code : null
        
        // TODO: sort out contacts list export
        //this.contacts = ContactImportDTO.mapFromList(student.person.contacts)
        
        // TODO: sort out request response
        //this.requestCodes = student.requests
    }
}
