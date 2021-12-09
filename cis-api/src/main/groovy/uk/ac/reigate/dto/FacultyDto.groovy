package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.Faculty

/**
 *
 * JSON serializable DTO containing Faculty data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class FacultyDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String code;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Integer hofId;
    
    @JsonProperty
    private StaffDto hof;
    
    @JsonProperty
    private Integer dolId;
    
    @JsonProperty
    private StaffDto dol;
    
    @JsonProperty
    private Integer adolId;
    
    @JsonProperty
    private StaffDto adol;
    
    @JsonProperty
    private Integer pdId;
    
    @JsonProperty
    private StaffDto pd;
    
    @JsonProperty
    private Integer apdId;
    
    @JsonProperty
    private StaffDto apd;
    
    @JsonProperty
    private Date validFrom;
    
    @JsonProperty
    private Date validTo;
    
    /**
     * Default No Args constructor
     */
    public FacultyDto() {
    }
    
    /**
     * Constructor to create an FacultyDto object from a Faculty object
     *
     * @param faculty the Faculty object to use for construction
     */
    FacultyDto(Faculty faculty) {
        if(faculty != null) {
            this.id = faculty.id;
            this.code = faculty.code;
            this.description = faculty.description;
            this.hofId = faculty.hof != null ? faculty.hof.id : null;
            this.hof = faculty.hof != null ? StaffDto.mapFromEntity(faculty.hof) : null
            this.dolId = faculty.dol !=  null ? faculty.dol.id : null
            this.dol = faculty.dol !=  null ? StaffDto.mapFromEntity(faculty.dol) : null
            this.adolId = faculty.adol != null ? faculty.adol.id : null;
            this.adol = faculty.adol != null ? StaffDto.mapFromEntity(faculty.adol) : null
            this.pdId = faculty.pd != null ? faculty.pd.id : null;
            this.pd = faculty.pd != null ? StaffDto.mapFromEntity(faculty.pd) : null
            this.apdId = faculty.apd != null ? faculty.apd.id : null
            this.apd = faculty.apd != null ? StaffDto.mapFromEntity(faculty.apd) : null
            this.validFrom = faculty.validFrom
            this.validTo = faculty.validTo
        }
    }
    
    /**
     * This static method is used to create a FacultyDto from a Faculty data object.
     *
     * @param faculty the Faculty data object to use for the creation.
     * @return a FacultyDto object based on the Faculty data object supplied.
     */
    public static FacultyDto mapFromEntity(Faculty faculty) {
        return new FacultyDto(faculty)
    }
    
    /**
     * This static method is used to create a List of FacultyDto from a List of Faculty data object.
     *
     * @param faculties the List of Faculty data object to use for the creation.
     * @return a List of FacultyDto object based on the List of Faculty data object supplied.
     */
    public static List<FacultyDto> mapFromList(List<Faculty> faculties) {
        return faculties.collect { faculty ->  new FacultyDto(faculty) };
    }
    
    /**
     * This method is used to return the Staff Hof name  for the Faculty object
     *
     * @return the Staff Hof name  for the Faculty object
     */
    @JsonProperty(value = "_hofName")
    public String get_HofName() {
        return this.hof != null ? this.hof.knownAs : null
    }
    
    /**
     * This method is used to return the Staff Hof initials for the Faculty object
     *
     * @return the Staff Hof initials  for the Faculty object
     */
    @JsonProperty(value = "_hofInitials")
    public String get_HofInitials() {
        return this.hof != null ? this.hof.initials : null
    }
    
    /**
     * This method is used to return the Staff pd name  for the Faculty object
     *
     * @return the Staff pd name  for the Faculty object
     */
    @JsonProperty(value = "_pdName")
    public String get_pdName() {
        return this.pd != null ? this.pd.knownAs : null
    }
    
    /**
     * This method is used to return the Staff pd initials for the Faculty object
     *
     * @return the Staff pd initials  for the Faculty object
     */
    @JsonProperty(value = "_pdInitials")
    public String get_pdInitials() {
        return this.pd != null ? this.pd.initials : null
    }
    
    /**
     * This method is used to return the Staff apd name  for the Faculty object
     *
     * @return the Staff apd name  for the Faculty object
     */
    @JsonProperty(value = "_apdName")
    public String get_apdName() {
        return this.apd != null ? this.apd.knownAs : null
    }
    
    /**
     * This method is used to return the Staff apd initials for the Faculty object
     *
     * @return the Staff apd initials  for the Faculty object
     */
    @JsonProperty(value = "_apdInitials")
    public String get_apdInitials() {
        return this.apd != null ? this.apd.initials : null
    }
    
    /**
     * This method is used to return the Staff dol name  for the Faculty object
     *
     * @return the Staff dol name  for the Faculty object
     */
    @JsonProperty(value = "_dolName")
    public String get_dolName() {
        return this.dol != null ? this.dol.knownAs : null
    }
    
    /**
     * This method is used to return the Staff dol initials for the Faculty object
     *
     * @return the Staff dol initials  for the Faculty object
     */
    @JsonProperty(value = "_dolInitials")
    public String get_dolInitials() {
        return this.dol != null ? this.dol.initials : null
    }
    
    /**
     * This method is used to return the Staff adol name  for the Faculty object
     *
     * @return the Staff adol name  for the Faculty object
     */
    @JsonProperty(value = "_adolName")
    public String get_adolName() {
        return this.adol != null ? this.adol.knownAs : null
    }
    
    /**
     * This method is used to return the Staff adol initials for the Faculty object
     *
     * @return the Staff adol initials  for the Faculty object
     */
    @JsonProperty(value = "_adolInitials")
    public String get_adolInitials() {
        return this.adol != null ? this.adol.initials : null
    }
}
