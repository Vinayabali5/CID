package uk.ac.reigate.services.careers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.academic.Student
import uk.ac.reigate.domain.academic.StudentCareersRecord
import uk.ac.reigate.dto.careers.BulkCareersRecordDto
import uk.ac.reigate.services.CareersRecordTypeService
import uk.ac.reigate.services.StudentCareersRecordService
import uk.ac.reigate.services.student.StudentService

@Service
class BulkCareersRecordService {
    
    @Autowired
    private final StudentService studentService
    
    @Autowired
    private final StudentCareersRecordService studentCareersRecordService
    
    @Autowired
    private final CareersRecordTypeService careersRecordTypeService
    
    
    /**
     * Default NoArgs constructor
     */
    BulkCareersRecordService() {}
    
    
    /**
     * This service method is used to create a StudentCareersRecord data object in the database from a partial or 
     * complete BulkCareersRecordDto object.
     *
     * @param studentCareersRecord the BulkCareersRecordDto object to use for the creation of the StudentCareersRecord data object.
     * @return the saved version of the Letter data object
     */
    @Transactional
    public void createMassILPEntries(BulkCareersRecordDto bulkCareersRecordDto) {
        if(bulkCareersRecordDto.studentList != null) {
            bulkCareersRecordDto.studentList.each { it ->
                Student student = studentService.findById(it)
                if (student != null) {
                    // Create StudentCareersRecord Bulk Entry
                    StudentCareersRecord studentCareersRecord = new StudentCareersRecord()
                    studentCareersRecord.student = student
                    
                    if(bulkCareersRecordDto.careersRecordTypeId != null) {
                        studentCareersRecord.careersRecordType = careersRecordTypeService.findById(bulkCareersRecordDto.careersRecordTypeId)
                    }
                    studentCareersRecord.startDate = bulkCareersRecordDto.startDate
                    studentCareersRecord.endDate = bulkCareersRecordDto.endDate
                    studentCareersRecord.employerInstitution = bulkCareersRecordDto.employerInstitution
                    studentCareersRecord.organiser = bulkCareersRecordDto.organiser
                    studentCareersRecord.note = bulkCareersRecordDto.note
                    studentCareersRecordService.save(studentCareersRecord)
                }
            }
        }
    }
    
}
