package uk.ac.reigate.domain

import groovy.transform.EqualsAndHashCode

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

/**
 * The Address object is used to store postal addresses in the database
 */
@Entity
@Table(name="address")
@AttributeOverrides([
    @AttributeOverride(name = "id", column = @Column(name = "address_id"))
])
@DynamicInsert(true)
@DynamicUpdate(true)
@EqualsAndHashCode(includeFields=true)
class Address extends BaseEntity {
    
    /** 
     * The first address line for the address.  
     */
    @Column(name="line1")
    String line1
    
    /**
     * The second address line for the address. 
     */
    @Column(name="line2")
    String line2
    
    /**
     * The third address line for the address (rarely used).  
     */
    @Column(name="line3")
    String line3
    
    /**
     * The fourth address line for the address (rarely used). 
     */
    @Column(name="line4")
    String line4
    
    /**
     * The fifth address line for the address (rarely used).  
     */
    @Column(name="line5")
    String line5
    
    /**
     * The town for the address. This is the post town for the address.
     */
    @Column(name="town")
    String town
    
    /**
     * The county for the address.
     */
    @Column(name="county")
    String county
    
    /**
     * The postcode for the address. 
     */
    // @NotNull
    @Column(name="postcode")
    String postcode
    
    /**
     * The building name for the address.
     */
    @Column(name="building_name")
    String buildingName
    
    /**
     * The sub building for the address.
     */
    @Column(name="sub_building")
    String subBuilding
    
    /**
     * The unique delivery point reference number (udprn) for the address.
     */
    @Column(name="udprn")
    String udprn
    
    /**
     * The a pre-formatted Full Address block that can be used in letters and exports. <br/>
     * * Calculated field 
     */
    @Column(name='FULLADDRESS', updatable=false, insertable=false)
    String fullAddress
    
    /**
     * Default No Args constructor
     */
    Address() {}
    
    /**
     * Constructor to create a prepopulated address with all requried fields
     * 
     * @param id
     * @param line1
     * @param line2
     * @param line3
     * @param line4
     * @param line5
     * @param town
     * @param county
     * @param postcode
     * @param buildingName
     * @param subBuilding
     * @param paon
     * @param saon
     */
    Address (Integer id, String line1, String line2, String line3, String line4, String line5, String town, String county, String postcode, String buildingName, String subBuilding) {
        this.id = id;
        this.line1 = line1
        this.line2 = line2
        this.line3 = line3
        this.line4 = line4
        this.line5 = line5
        this.town = town
        this.buildingName = buildingName
        this.subBuilding = subBuilding
        this.county = county
        this.postcode = postcode
    }
    
    Address (String line1, String line2, String line3, String line4,  String line5, String town, String county, String postcode, String buildingName, String subBuilding) {
        this(null, line1, line2, line3, line4, line5, town, county, postcode, buildingName, subBuilding)
    }
    /**
     * toString method that is used to display the address as a comma separated address block.
     */
    String toString() {
        String out
        out += line1 != null ? ', ' + line1 : ''
        out += line2 != null ? ', ' + line2 : ''
        out += line3 != null ? ', ' + line3 : ''
        out += line4 != null ? ', ' + line4 : ''
        out += line5 != null ? ', ' + line5 : ''
        out += town != null ? ', ' + town : ''
        out += buildingName != null ? ', ' + buildingName : ''
        out += subBuilding != null ? ', ' + subBuilding : ''
        if (county != null) {
            out += ', ' + county
        }
        out += ', ' + postcode
    }
    
    
    /**
     * This method is used to update an existing or new address object from another address where the fields are different
     * 
     * @param update The Address object to use for the update 
     */
    void updateAddress(Address update) {
        this.line1 = this.line1 != update.line1 ? update.line1 : this.line1
        this.line2 = this.line2 != update.line2 ? update.line2 : this.line2
        this.line3 = this.line3 != update.line3 ? update.line3 : this.line3
        this.line4 = this.line4 != update.line4 ? update.line4 : this.line4
        this.line5 = this.line5 != update.line5 ? update.line5 : this.line5
        this.town = this.town != update.town ? update.town : this.town
        this.county = this.county != update.county ? update.county : this.county
        this.postcode = this.postcode != update.postcode ? update.postcode : this.postcode
        this.buildingName = this.buildingName != update.buildingName ? update.buildingName : this.buildingName
        this.subBuilding = this.subBuilding != update.subBuilding ? update.subBuilding : this.subBuilding
    }
    
}
