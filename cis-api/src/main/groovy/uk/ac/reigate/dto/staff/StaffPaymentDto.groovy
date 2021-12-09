package uk.ac.reigate.dto.staff;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import groovy.transform.EqualsAndHashCode;
import uk.ac.reigate.domain.staff.StaffPayment
import uk.ac.reigate.dto.StaffSummaryDto


/**
 *
 * JSON serializable DTO containing StaffPayment data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class StaffPaymentDto implements Serializable {
    
    @JsonProperty
    private Integer id;
    
    @JsonProperty
    private Integer staffId;
    
    @JsonProperty
    private StaffSummaryDto staff;
    
    @JsonProperty
    private Date startDate
    
    @JsonProperty
    private Date endDate
    
    @JsonProperty
    private Integer paymentReasonId
    
    @JsonProperty
    private PaymentReasonDto paymentReason
    
    @JsonProperty
    private Double sessions
    
    @JsonProperty
    private Double ratePerSession
    
    /**
     * Default No Args constructor
     */
    public StaffPaymentDto() {
    }
    
    /**
     * Constructor to create a StaffPaymentDto object from a StaffPayment object
     *
     * @param staffPayment the StaffPayment object to use for construction
     */
    StaffPaymentDto(StaffPayment staffPayment) {
        if(staffPayment != null) {
            this.id = staffPayment.id;
            this.staffId = staffPayment.staff != null ? staffPayment.staff.id : null;
            this.staff = staffPayment.staff != null ? StaffSummaryDto.mapFromEntity(staffPayment.staff) : null;
            this.startDate = staffPayment.startDate
            this.endDate = staffPayment.endDate
            this.paymentReasonId = staffPayment.paymentReason != null ? staffPayment.paymentReason.id : null;
            this.paymentReason = staffPayment.paymentReason != null ? PaymentReasonDto.mapFromEntity(staffPayment.paymentReason) : null;
            this.sessions = staffPayment.sessions
            this.ratePerSession = staffPayment.ratePerSession
        }
    }
    
    /**
     * This static method is used to create a StaffPaymentDto from a StaffPayment data object.
     *
     * @param staffPayment the StaffPayment data object to use for the creation.
     * @return a StaffPaymentDto object based on the StaffPayment data object supplied.
     */
    public static StaffPaymentDto mapFromEntity(StaffPayment staffPayment) {
        return new StaffPaymentDto(staffPayment);
    }
    
    /**
     * This static method is used to create a List of StaffPaymentDto from a List of StaffPayment data object.
     *
     * @param staffPayments the List of StaffPayment data object to use for the creation.
     * @return a List of LetterDto object based on the List of StaffPayment data object supplied.
     */
    public static List<StaffPaymentDto> mapFromList(List<StaffPayment> staffPayments) {
        return staffPayments.collect { staffPayment ->  new StaffPaymentDto(staffPayment) };
    }
    
    /**
     * This method is used to return the total paid for the StaffPayment object
     *
     * @return the TotalPaid for the StaffPayment object
     */
    @JsonProperty(value = "_totalPaid")
    public Float get_totalPaid() {
        if (this.sessions != null && this.ratePerSession != null) {
            return (this.sessions * this.ratePerSession)
        } else {
            return null
        }
    }
}
