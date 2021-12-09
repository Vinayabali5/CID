package uk.ac.reigate.dto.staff;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.staff.PaymentReason


/**
 *
 * JSON serializable DTO containing PaymentReason data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class PaymentReasonDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private String paymentReason;
    
    /**
     * Default No Args constructor
     */
    public PaymentReasonDto() {
    }
    
    /**
     * Constructor to create a PaymentReasonDto object from a PaymentReason object
     *
     * @param paymentReason the PaymentReason object to use for construction
     */
    PaymentReasonDto(PaymentReason paymentReason) {
        if(paymentReason != null) {
            this.id = paymentReason.id;
            this.paymentReason = paymentReason.paymentReason;
        }
    }
    
    /**
     * This static method is used to create a PaymentReasonDto from a PaymentReason data object.
     *
     * @param paymentReason the PaymentReason data object to use for the creation.
     * @return a PaymentReasonDto object based on the PaymentReason data object supplied.
     */
    public static PaymentReasonDto mapFromEntity(PaymentReason paymentReason) {
        return new PaymentReasonDto(paymentReason);
    }
    
    /**
     * This static method is used to create a List of PaymentReasonDto from a List of PaymentReason data object.
     *
     * @param paymentReasons the List of PaymentReason data object to use for the creation.
     * @return a List of LetterDto object based on the List of PaymentReason data object supplied.
     */
    public static List<PaymentReasonDto> mapFromList(List<PaymentReason> paymentReasons) {
        return paymentReasons.collect { paymentReason ->  new PaymentReasonDto(paymentReason) };
    }
}
