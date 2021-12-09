package uk.ac.reigate.services.lip

import java.text.SimpleDateFormat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.ilp.ILPInterview
import uk.ac.reigate.domain.system.Setting
import uk.ac.reigate.model.email.EmailMessage
import uk.ac.reigate.services.SettingService
import uk.ac.reigate.services.integration.email.EmailService
import uk.ac.reigate.services.student.StudentYearService

/**
 * This service is used to perform various operations associated with the LIP programme. 
 * 
 * @author Michael Horgan
 *
 */
@Service
class LIPService {
    
    /**
     * This value is used to lookup up the LIP Email Recipient from the settings table.  
     */
    final static String lipEmailSetting = 'LIPMailRecipient'
    
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    
    @Autowired(required = false)
    EmailService emailService
    
    @Autowired
    SettingService settingService
    
    @Autowired
    StudentYearService studentYearService
    
    /**
     * This method is used to send the LIP Email Recipient an email regarding a new LIP Referral based on a specified ILP Interview entry.
     * 
     * @param interview The specific ILP Interview to use for the LIP referral email. 
     */
    public void sendLIPReferralEmail(ILPInterview interview) {
        if (emailService != null) {
            Setting lipEmail = settingService.findSettingBySetting(lipEmailSetting)
            if (lipEmail != null) {
                StudentYear studentYear = studentYearService.findByStudentAndYear(interview.student, interview.academicYear)
                
                String subject = 'LIP Referral: ' + interview.student.person + ' (' + interview.student.id + ')'
                String message = ''
                message += '<b>Message sent by:</b> ' + interview.staff + '<br><br>'
                message += '<b>Tutor Group:</b> ' + studentYear.tutorGroup + '<br>'
                message += '<b>Tutor:</b> ' + studentYear.tutorGroup.tutor + '<br>'
                message += '<b>Interview Date:</b> ' + (interview.interviewDate != null ? dateFormatter.format(interview.interviewDate) : 'No Interview Date') + '<br>'
                message += '<b>Course:</b> ' + interview.courseGroup.course + '<br>'
                message += '<b>Summary of Progress:</b> <br>' + interview.discussion + '<br><br>'
                message += '<b>Targets:</b> <br>' + interview.target + '<br><br>'
                message += '<b>Completed By:</b> ' + (interview.targetByDate != null ? dateFormatter.format(interview.targetByDate) : 'No Target Date') + '<br>'
                
                //�Prepare Email to be Sent
                EmailMessage email = new EmailMessage()
                email.to.add(lipEmail.value)
                email.subject = subject
                email.message = message
                emailService.sendEmail(email)
            }
        }
    }
}
