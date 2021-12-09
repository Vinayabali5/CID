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
import uk.ac.reigate.dto.ilp.MassILPEntryDto
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.services.CourseGroupService
import uk.ac.reigate.services.LetterTypeService
import uk.ac.reigate.services.StaffService
import uk.ac.reigate.services.TimetableService
import uk.ac.reigate.services.student.StudentService
import uk.ac.reigate.services.student.StudentYearService
import uk.ac.reigate.utils.StringReplacer

@Service
class MassILPEntryService {
    
    @Autowired
    private final StudentService studentService
    
    @Autowired
    private final CourseGroupService courseGroupService
    
    @Autowired
    private final ILPInterviewService ilpInterviewService
    
    @Autowired
    private final ILPInterviewTypeService ilpInterviewTypeService
    
    @Autowired
    private final StaffService staffService
    
    @Autowired
    private final StudentYearService studentYearService
    
    /**
     * Default NoArgs constructor
     */
    MassILPEntryService() {}
    
    
    /**
     * This service method is used to create a ILPInterview data object in the database from a partial or 
     * complete MassILPEntryDto object.
     *
     * @param ilpInterview the MassILPEntryDto object to use for the creation of the ILPInterview data object.
     * @return the saved version of the Letter data object
     */
    @Transactional
    public void createMassILPEntries(MassILPEntryDto massEntryDto) {
        if(massEntryDto.studentList != null) {
            massEntryDto.studentList.each { it ->
                Student student = studentService.findById(it)
                if (student != null) {
                    Staff staffRequesting = staffService.findById(massEntryDto.staffId)
                    CourseGroup courseGroup = courseGroupService.findById(massEntryDto.courseGroupId)
                    StudentYear studentYear = studentYearService.findByStudentAndYear(student, courseGroup.year)
                    // Create ILP Entry
                    ILPInterview ilpInterview = new ILPInterview()
                    ilpInterview.student = student
                    if (massEntryDto.courseGroupId != null && courseGroup != null) {
                        ilpInterview.courseGroup = courseGroup
                    }
                    ilpInterview.interviewDate = massEntryDto.interviewDate
                    if(massEntryDto.interviewTypeId != null) {
                        ilpInterview.type = ilpInterviewTypeService.findById(massEntryDto.interviewTypeId)
                    }
                    ilpInterview.targetByDate = massEntryDto.targetDate
                    ilpInterview.staff = staffRequesting
                    ilpInterview.discussion = massEntryDto.discussion
                    ilpInterview.target = massEntryDto.target
                    ilpInterview.referLip = massEntryDto.referLip
                    ilpInterview.lipReferDate = massEntryDto.lipReferralDate
                    ilpInterview.privateEntry = massEntryDto.privateEntry
                    ilpInterviewService.save(ilpInterview)
                }
            }
        }
    }
    
}
