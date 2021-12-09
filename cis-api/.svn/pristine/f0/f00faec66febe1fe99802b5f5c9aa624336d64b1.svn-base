package uk.ac.reigate.services.email;

import java.text.SimpleDateFormat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.AcademicYear
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.ilp.ILPInterview
import uk.ac.reigate.dto.PastoralMonitorDto
import uk.ac.reigate.dto.email.EmailStaffListDto
import uk.ac.reigate.dto.email.StaffILPNotificationEmailDto
import uk.ac.reigate.model.email.EmailMessage
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.ilp.ILPInterviewService
import uk.ac.reigate.services.integration.email.EmailService
import uk.ac.reigate.services.student.StudentYearService

@Service
class StaffEmailingService {
    
    @Autowired
    StaffService staffService
    
    @Autowired
    ILPInterviewService iLPInterviewService
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    StudentYearService studentYearService
    
    @Autowired(required = false)
    EmailService emailService
    
    /**
     * This method is used to send Staff ILP Interview Emailing
     * 
     * @param emailStaffListDto
     */
    public void sendStaffEmailing(EmailStaffListDto emailStaffListDto) {
        // Prepare Email to be Sent
        EmailMessage email = new EmailMessage()
        
        emailStaffListDto.staffList.each { it ->
            Staff staff = staffService.findById(it)
            if (staff != null && staff.staffEmail != null) {
                email.to.add(staff.staffEmail)
            }
        }
        Staff staffFrom
        if (emailStaffListDto.staffId != null ) {
            staffFrom = staffService.findById(emailStaffListDto.staffId)
            
        }
        // email.subject = emailStaffListDto.subject
        String message = emailStaffListDto.message
        
        if(emailStaffListDto.ilpInterviewId != null) {
            ILPInterview ilpInterview = iLPInterviewService.findById(emailStaffListDto.ilpInterviewId)
            email.subject = "ILP Entry made for " + ilpInterview.student.person.surname + ', ' + ilpInterview.student.person.firstName
            AcademicYear current = academicYearService.getCurrentAcademicYear()
            StudentYear studentYear = studentYearService.findByStudentAndYear(ilpInterview.student, current)
            if (studentYear != null && studentYear.tutorGroup != null && studentYear.tutorGroup.code != null) {
                email.subject += '-' + "Tutor Group" + '-' + studentYear.tutorGroup.code
            }
        }
        if (staffFrom != null) {
            message = "<p><strong>Email Sent By: </strong>" + staffFrom.knownAs + "</p>" + message
        }
        email.message = message
        emailService.sendEmail(email)
    }
    
    /**
     * This method is used to send ilp interviews email notifications to the staff.
     * 
     * @param emailDto
     */
    public void sendStaffILPNotificationEmail(StaffILPNotificationEmailDto emailDto) {
        EmailMessage email = new EmailMessage()
        emailDto.staffList.each { it ->
            Staff staff = staffService.findById(it)
            if(staff != null && staff.staffEmail != null) {
                email.to.add(staff.staffEmail)
            }
        }
        if(emailDto.ilpInterviewId != null) {
            ILPInterview ilpInterview = iLPInterviewService.findById(emailDto.ilpInterviewId)
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = simpleDateFormat.format(ilpInterview.interviewDate);
            Staff sentBy = staffService.findById(ilpInterview.staff.id)
            email.subject = "ILP Entry made for " + ilpInterview.student.person.surname + ', ' + ilpInterview.student.person.firstName + ' - ' + ilpInterview.student.studentYears[0].tutorGroup.description
            email.message = "<p><strong>Email Sent By: </strong>" + sentBy.knownAs + "</p>" +
                    "<p>The following was added onto the ILP on " + date + "</p>" +
                    "<p><strong>Discussion: </strong></p>" + ilpInterview.discussion +
                    "<p><strong>Target: </strong></p>" + ilpInterview.target +
                    "<p><strong>Regards</strong></p>" +
                    "<p>" + ilpInterview.staff.knownAs + "</p>" +
                    "<p>" + ilpInterview.staff.signature + "</p>"
        }
        emailService.sendEmail(email)
    }
    
    /**
     * This method is used to send Pastoral Monitor update email notifications to the ST, Student Services and Pastoral Monitor.
     *
     * @param emailDto
     */
    public void sendPastoralMonitoringUpdate(PastoralMonitorDto pastoralMonitor) {
        EmailMessage email = new EmailMessage()
        if(pastoralMonitor.pastoralMonitorId != null) {
            Staff staff = staffService.findById(pastoralMonitor.pastoralMonitorId)
            Staff seniorTutor = staffService.findById(pastoralMonitor.seniorTutorId)
            List<String> staffEmailList = [
                staff.staffEmail,
                seniorTutor.staffEmail,
                'StudentServices@reigate.ac.uk'
            ]
            staffEmailList.each { it ->
                email.to.add(it)
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = simpleDateFormat.format(new Date());
            if(pastoralMonitor.studentId != null) {
                email.subject = "Pastoral Monitor has been changed for " + pastoralMonitor.student.person.surname + ', ' + pastoralMonitor.student.person.firstName
                email.message =
                        "<p>Pastoral Monitor has been changed for " + pastoralMonitor.student.person.surname + ', ' + pastoralMonitor.student.person.firstName + " on " + date +  "</p>" +
                        "<p><strong>Check CID for more Information</strong></p>"
            }
            emailService.sendEmail(email)
        }
    }
}
