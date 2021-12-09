package uk.ac.reigate.services.exams

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.Syllabus
import uk.ac.reigate.dto.exams.basedata.ExamComponentDto
import uk.ac.reigate.dto.exams.basedata.ExamOptionDto
import uk.ac.reigate.dto.exams.basedata.SyllabusDto
import uk.ac.reigate.exceptions.DataConversionException
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.exams.basedata.ExamSeriesService
import uk.ac.reigate.services.exams.basedata.SyllabusService

@Service
class ExamDtoConverterService {
    
    @Autowired
    AcademicYearService academicYearService
    
    @Autowired
    SyllabusService syllabusService
    
    @Autowired
    ExamSeriesService examSeriesService
    
    Syllabus mapToSyllabusEntity(SyllabusDto dto) {
        if (dto == null) {
            throw new DataConversionException("Cannot convert SyllabusDto to syllabus object.")
        }
        Syllabus syllabus = new Syllabus()
        syllabus.id = dto.id
        syllabus.examSeries = dto.examSeries.examSeriesId != null ? examSeriesService.findById(dto.examSeries.examSeriesId) : null
        syllabus.code = dto.code
        syllabus.title = dto.title
        return syllabus
    }
    
    ExamOption mapToExamOptionEntity(ExamOptionDto dto) {
        ExamOption examOption = new ExamOption()
        examOption.examOptionId = dto.id
        
        // TODO: finalise this routine
        
        return examOption
        /*
         return new ExamOption.Builder()
         .examOptionId(examOptionDto.examOptionId)
         .examTypeCert(new ExamType.Builder().qualification(examOptionDto.examTypeQualificationCert).level(examOptionDto.examTypeLevelCert).build())
         .examTypeUnit(new ExamType.Builder().qualification(examOptionDto.examTypeQualificationUnit).level(examOptionDto.examTypeLevelUnit).build())
         //.optionComponents(optionDto.optionComponents) ? what to do with this?
         .optionEntryCode(examOptionDto.optionEntryCode)
         .syllabus(SyllabusDto.mapToSyllabusEntity(examOptionDto.syllabus))
         .process(examOptionDto.process)
         .qcaClassificationCode(examOptionDto.qcaClassificationCode)
         .qcaAccreditationNo(examOptionDto.qcaAccreditationNo)
         .optionTitle(examOptionDto.optionTitle)
         .feeDefined(examOptionDto.feeDefined)
         .examinationFee(examOptionDto.examinationFee)
         .firstForecastGradeGradeset(examOptionDto.firstForecastGradeGradeset)
         .secondForecastGradeGradeset(examOptionDto.secondForecastGradeGradeset)
         .resultType(examOptionDto.resultType)
         .firstGradeResultGradeset(examOptionDto.firstGradeResultGradeset)
         .secondGradeResultGradeset(examOptionDto.secondGradeResultGradeset)
         .endorsementToFirstGradeResultGradeset(examOptionDto.endorsementToFirstGradeResultGradeset)
         .endorsementToSecondGradeResultGradeset(examOptionDto.endorsementToSecondGradeResultGradeset)
         .maxMarkUms(examOptionDto.maxMarkUms)
         .noOfComponents(examOptionDto.noOfComponents)
         .build()
         */
    }
    
    ExamComponent mapToExamComponentEntity(ExamComponentDto dto) {
        ExamComponent examComponent = new ExamComponent()
        examComponent.examComponentId = dto.id
        examComponent.examSeries = dto.examSeries != null && dto.examSeries.examSeriesId != null ? examSeriesService.findById(dto.examSeries.examSeriesId) : null
        examComponent.code = dto.code
        examComponent.title = dto.title
        examComponent.teacherMarks = dto.teacherMarks
        examComponent.maximumMark = dto.maximumMark
        examComponent.gradeset = dto.gradeset
        examComponent.dueDate = dto.dueDate
        examComponent.timetabled = dto.timetabled
        examComponent.timetableDate = dto.timetableDate
        examComponent.timetableSession = dto.timetableSession
        examComponent.timeAllowed = dto.timeAllowed
        return examComponent
    }
}
