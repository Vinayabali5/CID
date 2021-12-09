package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.academic.Department

/**
 *
 * JSON serializable DTO containing Department data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class DepartmentDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String name;
    
    @JsonProperty
    private String description;
    
    @JsonProperty
    private Integer facultyId;
    
    @JsonProperty
    private FacultyDto faculty;
    
    @JsonProperty
    private Integer hodId;
    
    @JsonProperty
    private Integer hod2Id;
    
    @JsonProperty
    private StaffDto hod;
    
    @JsonProperty
    private StaffDto hod2;
    
    @JsonProperty
    private Boolean academic;
    
    
    /**
     * Default No Args constructor
     */
    public DepartmentDto() {
    }
    
    /**
     * Constructor to create a DepartmentDto object from a Department object
     *
     * @param department the Department object to use for construction
     */
    DepartmentDto(Department department) {
        if(department != null) {
            this.id = department.id;
            this.name = department.name;
            this.description = department.description;
            this.facultyId = department.faculty != null ? department.faculty.id : null;
            this.faculty = department.faculty != null ? FacultyDto.mapFromEntity(department.faculty) : null
            this.hodId = department.hod != null ? department.hod.id : null
            this.hod = department.hod != null ? StaffDto.mapFromEntity(department.hod) : null
            this.hod2Id = department.hod2 != null ? department.hod2.id : null;
            this.hod2 = department.hod2 != null ? StaffDto.mapFromEntity(department.hod2) : null
            this.academic = department.academic;
        }
    }
    
    /**
     * This static method is used to create a DepartmentDto from a Department data object.
     *
     * @param department the Department data object to use for the creation.
     * @return a DepartmentDto object based on the Department data object supplied.
     */
    public static DepartmentDto mapFromEntity(Department department) {
        return new DepartmentDto(department)
    }
    
    /**
     * This static method is used to create a List of DepartmentDto from a List of Department data object.
     *
     * @param departments the List of Department data object to use for the creation.
     * @return a List of DepartmentDto object based on the List of Department data object supplied.
     */
    public static List<DepartmentDto> mapFromList(List<Department> departments) {
        return departments.collect { department ->  mapFromEntity(department) };
    }
    
    /**
     * This method is used to return the Faculty description for the Department object
     *
     * @return the Faculty description for the Department object
     */
    @JsonProperty(value = "_facultyDescription")
    public String get_FacultyDescription() {
        return this.faculty != null ? this.faculty.description : null
    }
    
    /**
     * This method is used to return the Staff Hod knownAs for the Department object
     *
     * @return the Staff Hod knownAs for the Department object
     */
    @JsonProperty(value = "_hodName")
    public String get_HodName() {
        return this.hod != null ? this.hod.knownAs : null
    }
    
    /**
     * This method is used to return the Staff Hod2 knownAs for the Department object
     *
     * @return the Staff Hod2 knownAs for the Department object
     */
    @JsonProperty(value = "_hod2Name")
    public String get_Hod2Name() {
        return this.hod2 != null ? this.hod2.knownAs : null
    }
}
