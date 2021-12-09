package uk.ac.reigate.dto;


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.admissions.CollegeFundPayment
import uk.ac.reigate.exceptions.InvalidDataException

/**
 *
 * JSON serializable DTO containing CollegeFundPayment data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class CollegeFundPaymentDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer studentId;
    
    @JsonProperty
    private Date paymentDate;
    
    @JsonProperty
    private float amount;
    
    @JsonProperty
    private String payee;
    
    @JsonProperty
    private boolean giftAid;
    
    @JsonProperty
    private boolean cash
    
    @JsonProperty
    private Date chequeDate
    
    /**
     * Default No Args constructor
     */
    public CollegeFundPaymentDto() {
    }
    
    /**
     * Constructor to create a CollegeFundPaymentDto object from an CollegeFundPayment object
     *
     * @param collegeFundPayment the CollegeFundPayment object to use for construction
     */
    CollegeFundPaymentDto(CollegeFundPayment collegeFundPayment) {
        if(collegeFundPayment != null) {
            this.id= collegeFundPayment.id;
            this.studentId = collegeFundPayment.student != null ? collegeFundPayment.student.id : null;
            this.paymentDate = collegeFundPayment.paymentDate;
            this.amount = collegeFundPayment.amount;
            this.payee = collegeFundPayment.payee;
            this.giftAid = collegeFundPayment.giftAid;
            this.cash = collegeFundPayment.cash;
            this.chequeDate = collegeFundPayment.chequeDate;
        } else {
            return null
        }
    }
    
    /**
     * This static method is used to create a CollegeFundPaymentDto from a CollegeFundPayment data object.
     *
     * @param collegeFundPayment the CollegeFundPayment data object to use for the creation.
     * @return a CollegeFundPaymentDto object based on the CollegeFundPayment data object supplied.
     */
    public static CollegeFundPaymentDto mapFromEntity(CollegeFundPayment collegeFundPayment) {
        return new CollegeFundPaymentDto(collegeFundPayment)
    }
    
    /**
     * This static method is used to create a List of CollegeFundPaymentDto from a List of CollegeFundPayment data object.
     *
     * @param collegeFundPayments the List of StudentInterimReport data object to use for the creation.
     * @return a List of CollegeFundPaymentDto object based on the List of CollegeFundPayment data object supplied.
     */
    public static List<CollegeFundPaymentDto> mapFromList(List<CollegeFundPayment> collegeFundPayments) {
        return collegeFundPayments.collect { collegeFundPayment ->  new CollegeFundPaymentDto(collegeFundPayment) };
    }
}
