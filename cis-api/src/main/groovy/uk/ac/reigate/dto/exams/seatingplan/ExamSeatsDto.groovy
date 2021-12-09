package uk.ac.reigate.dto.exams.seatingplan;


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

import groovy.transform.EqualsAndHashCode
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.seatingplan.ExamSeat
import uk.ac.reigate.domain.exams.seatingplan.ExamSeatingPlan
import uk.ac.reigate.domain.learning_support.StudentCourseConcession
import uk.ac.reigate.dto.StudentConcessionTypeDto;
import uk.ac.reigate.dto.StudentSummaryDto
import uk.ac.reigate.dto.exams.basedata.ExamComponentDto
import uk.ac.reigate.dto.learningsupport.StudentCourseConcessionDto

/**
 *
 * JSON serializable DTO containing ReferralReason data
 *
 */
@JsonSerialize
@EqualsAndHashCode(includeFields=true)
public class ExamSeatsDto implements Serializable {
    
    @JsonProperty
    private Integer studentId
    
    @JsonProperty
    private StudentSummaryDto student
    
    @JsonProperty
    private Integer examComponentId
    
    @JsonProperty
    private ExamComponentDto examComponent
    
    @JsonProperty
    private Integer examSeatingPlanId
    
    @JsonProperty
    private ExamSeatingPlanDto examSeatingPlan
    
    @JsonProperty
    private Integer row;
    
    @JsonProperty
    private Integer col;
    
    @JsonProperty
    private Integer _candidateNo;
    
    @JsonProperty
    private List<StudentConcessionTypeDto> _concessions;
    
    @JsonProperty
    private List<StudentCourseConcessionDto> _courseConcessions;
    
    
    /**
     * Default No Args constructor
     */
    public ExamSeatsDto() {}
    
    /**
     * Constructor to create a SeatingPlanDto object
     *
     * @param studentId the Id for the ExamSeat
     * @param examComponentId the Id for the ExamSeat
     * @param examRoomId the Id for the ExamSeat room
     * @param row the row for the student in the seating plan
     * @param column the column for the student in the seating plan
     */
    public ExamSeatsDto(Student student, ExamComponent examComponent, ExamSeatingPlan examSeatingPlan, Integer row, Integer col) {
        this.studentId = student.id ;
        this.student = StudentSummaryDto.mapFromEntity(student)
        this.examComponentId = examComponent.id
        this.examComponent = ExamComponentDto.mapFromEntity(examComponent)
        this.examSeatingPlanId = examSeatingPlan != null ? examSeatingPlan.id : null
        this.examSeatingPlan = examSeatingPlan != null ? ExamSeatingPlanDto.mapFromEntity(examSeatingPlan) : null
        this.row = row != null ? row  : null
        this.col = col != null ? col : null
    }
    
    /**
     * Constructor to create a ExamSeatDto object from a ExamSeat object
     *
     * @param ExamSeat object to use for construction
     */
    public ExamSeatsDto(ExamSeat examSeat) {
        this.examSeatingPlanId = examSeat.examSeatingPlan.id
        this.examSeatingPlan = ExamSeatingPlanDto.mapFromEntity(examSeat.examSeatingPlan)
        this.row = examSeat.row
        this.col = examSeat.col
        this.studentId = examSeat.student.id
        this.student = StudentSummaryDto.mapFromEntity(examSeat.student)
        this.examComponentId = examSeat.examComponent != null ? examSeat.examComponent.id : null
        this.examComponent = examSeat.examComponent != null ? ExamComponentDto.mapFromEntity(examSeat.examComponent) : null
    }
    
    /**
     * Constructor to create a SeatingPlanDto object
     *
     * @param studentId the Id for the ExamSeat
     * @param examComponentId the Id for the ExamSeat
     * @param examRoomId the Id for the ExamSeat room
     * @param row the row for the student in the seating plan
     * @param column the column for the student in the seating plan
     * @param studentYear the student year information to use to populate the seating plan
     * @param concessions the List of StudentCourseConcessions to load with the seating plan
     */
    public ExamSeatsDto(Student student, ExamComponent examComponent, ExamSeatingPlan examSeatingPlan, Integer row, Integer col, StudentYear studentYear, List<StudentCourseConcession> concessions) {
        this(student, examComponent, examSeatingPlan, row, col)
        this._candidateNo = studentYear.candidateNo
        this._courseConcessions = StudentCourseConcessionDto.mapFromList(concessions);
    }
    
    public ExamSeatsDto(ExamSeat examSeat, StudentYear studentYear) {
        this(examSeat);
        this._candidateNo = studentYear.candidateNo
    }
    /**
     * This static method is used to create a ExamSeatsDto from a ExamSeats data object.
     *
     * @param ExamSeat the ExamSeat data object to use for the creation.
     * @return a ExamSeatsDto object based on the ExamSeat data object supplied.
     */
    public static ExamSeatsDto mapFromEntity(ExamSeat examSeat) {
        return new ExamSeatsDto(examSeat);
    }
    
    /**
     * This static method is used to create a List of ExamSeatsDto from a List of ExamSeat data object.
     *
     * @param examSeat the List of ExamSeats data object to use for the creation.
     * @return a List of ExamSeatsDto object based on the List of ExamSeats data object supplied.
     */
    public static List<ExamSeatsDto> mapFromList(List<ExamSeat> examSeats) {
        return examSeats.collect { examSeat -> new ExamSeatsDto((examSeat))};
    }
    
    /**
     * This method is used to return the ExamComponent Code for the ExamSeat object
     *
     * @return the ExamComponent Code for the ExamSeat object
     */
    @JsonProperty(value = "_examComponentCode")
    public String get_ExamComponentCode() {
        return this.examComponent != null ? this.examComponent.code : null
    }
    
    /**
     * This method is used to return the ExamComponent Title for the ExamSeat object
     *
     * @return the ExamComponent Title for the ExamSeat object
     */
    @JsonProperty(value = "_examComponentTitle")
    public String get_ExamComponentTitle() {
        return this.examComponent != null ? this.examComponent.title : null
    }
    
    /**
     * This method is used to return the student firstName for the ExamSeat object
     *
     * @return the student firstName for the ExamSeat object
     */
    @JsonProperty(value = "_firstName")
    public String get_FirstName() {
        return this.student.person != null ? this.student.person.firstName : null
    }
    
    /**
     * This method is used to return the student surname for the ExamSeat object
     *
     * @return the student surname for the ExamSeat object
     */
    @JsonProperty(value = "_surname")
    public String get_Surname() {
        return this.student.person != null ? this.student.person.surname : null
    }
    
    /**
     * This method is used to return the ExamRoom Room Code for the ExamSeat object
     *
     * @return the ExamRoom Room Code for the ExamSeat object
     */
    @JsonProperty(value = "_examRoomRoomCode")
    public String get_ExamRoomRoomCode() {
        return this.examSeatingPlan != null && this.examSeatingPlan.room != null ? this.examSeatingPlan.room.code : null
    }
    
    /**
     * This method is used to return the ExamRoom Room Description for the ExamSeat object
     *
     * @return the ExamRoom Room Description for the ExamSeat object
     */
    @JsonProperty(value = "_examRoomRoomDescription")
    public String get_ExamRoomRoomDescription() {
        return this.examSeatingPlan != null &&  this.examSeatingPlan.room != null ? this.examSeatingPlan.room.description : null
    }
}
