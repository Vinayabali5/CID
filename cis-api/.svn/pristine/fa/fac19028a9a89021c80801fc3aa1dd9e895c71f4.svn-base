package uk.ac.reigate.services.ilp

import java.text.SimpleDateFormat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.academic.CourseGroup
import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentYear
import uk.ac.reigate.domain.ilp.ILPInterview
import uk.ac.reigate.domain.ilp.Letter
import uk.ac.reigate.domain.ilp.LetterType
import uk.ac.reigate.domain.ilp.LetterWarningParagraph
import uk.ac.reigate.domain.ilp.StatementBank
import uk.ac.reigate.dto.ilp.MassILPLetterDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.services.CourseGroupService
import uk.ac.reigate.services.LetterTypeService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.TimetableService
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentYearService
import uk.ac.reigate.utils.StringReplacer

@Service
class MassILPLetterService {
    
    @Autowired
    private final LetterService letterService
    
    @Autowired
    private final StudentService studentService
    
    @Autowired
    private final TimetableService timetableService
    
    @Autowired
    private final StatementBankService statementBankService
    
    @Autowired
    private final CourseGroupService courseGroupService
    
    @Autowired
    private final ILPInterviewService ilpInterviewService
    
    @Autowired
    private final LetterWarningParagraphService letterWarningParagraphService
    
    @Autowired
    private final ILPInterviewTypeService ilpInterviewTypeService
    
    @Autowired
    private final LetterTypeService letterTypeService
    
    @Autowired
    private final StaffService staffService
    
    @Autowired
    private final StudentYearService studentYearService
    
    /**
     * Default NoArgs constructor
     */
    MassILPLetterService() {}
    
    
    /**
     * This service method is used to create a Letter data object in the database from a partial or 
     * complete LetterDto object.
     *
     * @param letter the LetterDto object to use for the creation of the Letter data object.
     * @return the saved version of the Letter data object
     */
    @Transactional
    public void createMassLetter(MassILPLetterDto massLetterDto) {
        //load the statement bank object from the database and for each student in the studentList create an ILP Interview
        StatementBank statementBank
        if(massLetterDto.statementId != null) {
            statementBank = statementBankService.findById(massLetterDto.statementId)
        }
        if(massLetterDto.studentList != null) {
            massLetterDto.studentList.each { it ->
                Student student = studentService.findById(it)
                if (student != null) {
                    Staff staffRequesting = staffService.findById(massLetterDto.staffId)
                    LetterType letterType = letterTypeService.findById(massLetterDto.letterTypeId)
                    LetterWarningParagraph warningParagraph = massLetterDto.warningParagraph != null ? letterWarningParagraphService.findById(massLetterDto.warningParagraph) : null
                    
                    // Load related data
                    //                    Student currentStudent = students.get(i)
                    CourseGroup courseGroup = courseGroupService.findById(massLetterDto.courseGroupId)
                    StudentYear studentYear = studentYearService.findByStudentAndYear(student, courseGroup.year)
                    
                    // Create ILP Entry
                    ILPInterview ilpInterview = new ILPInterview()
                    ilpInterview.student = student
                    if (massLetterDto.courseGroupId != null && courseGroup != null) {
                        ilpInterview.courseGroup = courseGroup
                    }
                    ilpInterview.interviewDate = massLetterDto.interviewDate
                    ilpInterview.type = ilpInterviewTypeService.findById(massLetterDto.interviewTypeId)
                    ilpInterview.targetByDate = massLetterDto.dueDate
                    ilpInterview.staff = staffRequesting
                    ilpInterview.discussion = replaceForMassLetter(statementBank.discussion, massLetterDto.pieceOfWork, ilpInterview.staff, massLetterDto.originalDueDate, massLetterDto.dueDate, ilpInterview.student, courseGroup)
                    ilpInterview.target = replaceForMassLetter(statementBank.target, massLetterDto.pieceOfWork, ilpInterview.staff, massLetterDto.originalDueDate, massLetterDto.dueDate, ilpInterview.student, courseGroup)
                    ilpInterviewService.save(ilpInterview)
                    // Create ILP Letter
                    Letter letter = new Letter()
                    letter.student = student
                    letter.requestedDate = massLetterDto.interviewDate
                    letter.letterType = letterType
                    letter.studentCopiedIn = massLetterDto.studentCopiedIn
                    letter.reviewMeeting = massLetterDto.reviewMeeting
                    letter.attendance = massLetterDto.attendance
                    letter.behaviour = massLetterDto.behaviour
                    letter.homework = massLetterDto.homework
                    letter.punctuality = massLetterDto.punctuality
                    letter.focus = massLetterDto.focus
                    letter.deadlines = massLetterDto.deadlines
                    letter.incompleteCoursework = massLetterDto.incompleteCoursework
                    letter.insufficientProgress = massLetterDto.progress
                    letter.nonEntryWarning = warningParagraph
                    letter.processingFlag = 1
                    letter.authorisedDate = null
                    letter.interview = ilpInterview
                    
                    // Set the subject fields where it is not set by data input
                    if (courseGroup != null) {
                        letter.subject = courseGroup.course.subject.description
                        letter.writtenBy = courseGroup.courseLeader
                        letter.requestedBy = staffRequesting
                    }
                    letter.regarding = student.id + " " + student.person.surname + ": " + student.person.firstOrPreferred()
                    if (studentYear != null && studentYear.tutorGroup != null) {
                        letter.regarding += ' ' + studentYear.tutorGroup.code
                    }
                    if (massLetterDto.letterTypeId != null) {
                        ilpInterview.letterSent = true
                    }
                    letterService.save(letter)
                }
            }
        }
    }
    
    /**
     * This method is used to replace various place holder text with data from the mass letter.
     * @param text the text to scan for replacements
     * @param pieceOfWork the title of the piece of work to scan for replacements
     * @param student the student record to use for replacement text
     * @param staff the staff record to use for replacement text
     * @return the string with replacements made
     * @see #replaceForPerson
     *
     */
    public static String replaceForMassLetter(String text, String pieceOfWork, Staff staff, Date originalDueDate, Date dueDate, Student student, CourseGroup courseGroup) {
        if (text == null) {
            throw new InvalidDataException("String must not be null.")
        } else {
            String output = text
            
            output = StringReplacer.replaceForStudent(text, student)
            output = StringReplacer.replace(output, "[Teacher]", staff.knownAs)
            output = StringReplacer.replace(output, "<Teacher>", staff.knownAs)
            
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy");
            if (originalDueDate != null) {
                String originalDueDateString = dateTimeFormat.format(originalDueDate)
                output = StringReplacer.replace(output, "[Ddate]", originalDueDateString)
            }
            if (dueDate != null) {
                String dueDateString = dateTimeFormat.format(dueDate)
                output = StringReplacer.replace(output, "[Rdate]", dueDateString)
            }
            if(pieceOfWork != null) {
                output = StringReplacer.replace(output, "[code]", pieceOfWork)
                output = StringReplacer.replace(output, "[pieceOfWork]", pieceOfWork)
            }
            if (courseGroup != null) {
                output = StringReplacer.replace(output, "[subject]", courseGroup.getCourseDescription())
                output = StringReplacer.replace(output, "<subject>", courseGroup.getCourseDescription())
            }
            return output
        }
    }
    
    
}
