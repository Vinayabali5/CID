package uk.ac.reigate.domain.cristal

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.Table

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name = '[attRooms]', schema = "Cristal")
class CristalRoom implements Serializable  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "room_id")
    @JoinColumn(name='room_id')
    Integer roomId
    
    @Column(name='Room_Name', columnDefinition = 'nvarchar')
    String roomName
    
    @Column(name = 'Computer_Name', columnDefinition = 'nvarchar')
    String computerName
    
    @Column(name = 'May_Print', columnDefinition = 'bit')
    Boolean mayPrint
    
    @Column(name = 'Auto_Start', columnDefinition = 'bit')
    Boolean autoStart
    
    @Column(name = 'Security_Code_Not_Required', columnDefinition = 'bit')
    Boolean securityCodeNotRequired
    
    @Column(name = 'Confirm_Room_Change', columnDefinition = 'bit')
    Boolean confirmRoomChange
    
    @Column(name = 'Confirm_Staff_Change', columnDefinition = 'bit')
    Boolean confirmStaffChange
    
    @Column(name = 'Confirm_Time_Change', columnDefinition = 'bit')
    Boolean confirmTimeChange
    
    @Column(name = 'Tutor_Office', columnDefinition = 'bit')
    Boolean tutorOffice
    
    CristalRoom() {}
    
    String toString(){
        return roomName
    }
}
