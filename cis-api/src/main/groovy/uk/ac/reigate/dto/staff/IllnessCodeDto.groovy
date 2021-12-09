package uk.ac.reigate.dto.staff;
//
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//
//import groovy.transform.EqualsAndHashCode;
//import uk.ac.reigate.domain.staff.IllnessCode
//
//
///**
// *
// * JSON serializable DTO containing IllnessCode data
// *
// */
//@JsonSerialize
//@EqualsAndHashCode(includeFields=true)
//public class IllnessCodeDto implements Serializable {
//
//    @JsonProperty
//    private String illnessCode;
//
//    @JsonProperty
//    private String illness;
//
//	@JsonProperty
//	private String details;
//
//    /**
//     * Default No Args constructor
//     */
//    public IllnessCodeDto() {
//    }
//
//    /**
//     * Constructor to create a IllnessCodeDto object from a IllnessCode object
//     *
//     * @param illnessCode the IllnessCode object to use for construction
//     */
//    IllnessCodeDto(IllnessCode illnessCode) {
//        if(illnessCode != null) {
//            this.illnessCode = illnessCode.illnessCode;
//			this.illness = illnessCode.illness;
//			this.details = illnessCode.details;
//        }
//    }
//
//    /**
//     * This static method is used to create a IllnessCodeDto from a IllnessCode data object.
//     *
//     * @param illnessCode the IllnessCode data object to use for the creation.
//     * @return a IllnessCodeDto object based on the IllnessCode data object supplied.
//     */
//    public static IllnessCodeDto mapFromEntity(IllnessCode illnessCode) {
//        return new IllnessCodeDto(illnessCode);
//    }
//
//    /**
//     * This static method is used to create a List of IllnessCodeDto from a List of IllnessCode data object.
//     *
//     * @param illnessCodes the List of IllnessCode data object to use for the creation.
//     * @return a List of LetterDto object based on the List of IllnessCode data object supplied.
//     */
//    public static List<IllnessCodeDto> mapFromList(List<IllnessCode> illnessCodes) {
//        return illnessCodes.collect { illnessCode ->  new IllnessCodeDto(illnessCode) };
//    }
//}
