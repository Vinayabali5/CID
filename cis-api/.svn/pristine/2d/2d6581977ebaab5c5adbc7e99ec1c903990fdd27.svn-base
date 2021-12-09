package uk.ac.reigate.dto.exams.basedata;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import uk.ac.reigate.domain.academic.Course
import uk.ac.reigate.domain.exams.CourseOption
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.ExamType
import uk.ac.reigate.domain.exams.basedata.OptionComponent
import uk.ac.reigate.domain.exams.basedata.Syllabus

public class ExamOptionDtoTest {
    
    private ExamOption examOption1
    
    private ExamOption examOption2
    
    private ExamOption examOption3
    
    private List<ExamOption> examOptions
    
    @Before
    public void setupTests() {
        this.examOption1 = new ExamOption(
                id: 1,
                optionEntryCode: 'AQA',
                syllabus : new Syllabus(id: 1),
                process: 'E',
                qcaClassificationCode: 'DD1',
                qcaAccreditationNo: '5005050',
                optionTitle: 'GCE RELIGIOUS STUDIES AS',
                feeDefined: 'Y',
                examinationFee: 5,
                firstForecastGradeGradeset: 'Aa',
                secondForecastGradeGradeset: 'bb',
                resultType: 'B',
                firstGradeResultGradeset: 'A',
                secondGradeResultGradeset: 'B',
                endorsementToFirstGradeResultGradeset: 'A',
                endorsementToSecondGradeResultGradeset: 'A',
                maxMarkUms: 12,
                noOfComponents: 13,
                examTypeCert: new ExamType(examTypeId: 1),
                examTypeUnit: new ExamType(examTypeId: 1),
                courseOptions : [
                    new CourseOption(course: new Course(id: 1), examOption: new ExamOption(id: 1), lowerEntry: true, upperEntry: true, intermediateEntry: true)
                ],
                optionComponents: [
                    new OptionComponent(examOption: new ExamOption(id: 1), examComponent: new ExamComponent(id: 1))]
                );
        this.examOption2 = new ExamOption(
                id: 2,
                optionEntryCode: 'AQA',
                syllabus : new Syllabus(id: 1),
                examTypeQualificationCert: 'GCE',
                examTypeLevelCert: 'ASB',
                examTypeItem: 'test',
                examTypeQualificationUnit: 'GCSE',
                examTypeLevelUnit: 'ALevel',
                process: 'E',
                qcaClassificationCode: 'DD1',
                qcaAccreditationNo: '5005050',
                optionTitle: 'GCE RELIGIOUS STUDIES AS',
                feeDefined: 'Y',
                examinationFee: 5,
                firstForecastGradeGradeset: 'Aa',
                secondForecastGradeGradeset: 'bb',
                resultType: 'B',
                firstGradeResultGradeset: 'A',
                secondGradeResultGradeset: 'B',
                endorsementToFirstGradeResultGradeset: 'A',
                endorsementToSecondGradeResultGradeset: 'A',
                maxMarkUms: 12,
                noOfComponents: 13,
                examTypeCert: new ExamType(examTypeId: 1),
                examTypeUnit: new ExamType(examTypeId: 1)
                );
        this.examOption3 = new ExamOption(
                id: 2,
                optionEntryCode: 'AQA',
                syllabus : null,
                examTypeQualificationCert: 'GCE',
                examTypeLevelCert: 'ASB',
                examTypeItem: 'test',
                examTypeQualificationUnit: 'GCSE',
                examTypeLevelUnit: 'ALevel',
                process: 'E',
                qcaClassificationCode: 'DD1',
                qcaAccreditationNo: '5005050',
                optionTitle: 'GCE RELIGIOUS STUDIES AS',
                feeDefined: 'Y',
                examinationFee: 5,
                firstForecastGradeGradeset: 'Aa',
                secondForecastGradeGradeset: 'bb',
                resultType: 'B',
                firstGradeResultGradeset: 'A',
                secondGradeResultGradeset: 'B',
                endorsementToFirstGradeResultGradeset: 'A',
                endorsementToSecondGradeResultGradeset: 'A',
                maxMarkUms: 12,
                noOfComponents: 13,
                examTypeCert: null,
                examTypeUnit: null,
                optionComponents: null,
                courseOptions: null
                );
        this.examOptions = Arrays.asList(examOption1, examOption2);
    }
    
    ExamOptionDto generateExamOptionDto() {
        return generateExamOption1Dto()
    }
    
    ExamOptionDto generateExamOption1Dto(){
        return new ExamOptionDto(examOption1)
    }
    
    ExamOptionDto generateExamOption2Dto(){
        return new ExamOptionDto(examOption2)
    }
    
    @Test
    public void testMapFromExamOptionEntityTest(){
        ExamOptionDto examOptionTest = ExamOptionDto.mapFromEntity( examOption1 )
        assertEquals( examOptionTest.id, examOption1.id );
        assertEquals( examOptionTest.optionEntryCode, examOption1.optionEntryCode)
        assertEquals( examOptionTest.syllabusId, examOption1.syllabus.id)
        assertEquals( examOptionTest.examTypeLevelCert, examOption1.examTypeLevelCert)
        assertEquals( examOptionTest.process, examOption1.process)
        assertEquals( examOptionTest.qcaClassificationCode, examOption1.qcaClassificationCode)
        assertEquals( examOptionTest.qcaAccreditationNo, examOption1.qcaAccreditationNo)
        assertEquals( examOptionTest.optionTitle, examOption1.optionTitle )
        assertEquals( examOptionTest.feeDefined, examOption1.feeDefined)
        assertEquals( examOptionTest.examinationFee, examOption1.examinationFee)
        assertEquals( examOptionTest.firstForecastGradeGradeset, examOption1.firstForecastGradeGradeset)
        assertEquals( examOptionTest.secondForecastGradeGradeset, examOption1.secondForecastGradeGradeset)
        assertEquals( examOptionTest.resultType, examOption1.resultType)
        assertEquals( examOptionTest.firstGradeResultGradeset, examOption1.firstGradeResultGradeset)
        assertEquals( examOptionTest.secondGradeResultGradeset, examOption1.secondGradeResultGradeset)
        assertEquals( examOptionTest.endorsementToFirstGradeResultGradeset, examOption1.endorsementToFirstGradeResultGradeset)
        assertEquals( examOptionTest.endorsementToSecondGradeResultGradeset, examOption1.endorsementToSecondGradeResultGradeset)
        assertEquals( examOptionTest.maxMarkUms, examOption1.maxMarkUms)
        assertEquals( examOptionTest.noOfComponents, examOption1.noOfComponents)
        assertEquals( examOptionTest.examTypeCertId, examOption1.examTypeCert.examTypeId)
    }
    
    @Test
    public void testMapFromExamOptionEntitiesTest(){
        List<ExamOptionDto> examOptionTest = ExamOptionDto.mapFromList(examOptions)
        assertEquals( examOptionTest[0].id, examOption1.id );
        assertEquals( examOptionTest[0].optionEntryCode, examOption1.optionEntryCode)
        assertEquals( examOptionTest[0].syllabusId, examOption1.syllabus.id)
        assertEquals( examOptionTest[0].process, examOption1.process)
        assertEquals( examOptionTest[0].qcaClassificationCode, examOption1.qcaClassificationCode)
        assertEquals( examOptionTest[0].qcaAccreditationNo, examOption1.qcaAccreditationNo)
        assertEquals( examOptionTest[0].optionTitle, examOption1.optionTitle )
        assertEquals( examOptionTest[0].feeDefined, examOption1.feeDefined)
        assertEquals( examOptionTest[0].examinationFee, examOption1.examinationFee)
        assertEquals( examOptionTest[0].firstForecastGradeGradeset, examOption1.firstForecastGradeGradeset)
        assertEquals( examOptionTest[0].secondForecastGradeGradeset, examOption1.secondForecastGradeGradeset)
        assertEquals( examOptionTest[0].resultType, examOption1.resultType)
        assertEquals( examOptionTest[0].firstGradeResultGradeset, examOption1.firstGradeResultGradeset)
        assertEquals( examOptionTest[0].secondGradeResultGradeset, examOption1.secondGradeResultGradeset)
        assertEquals( examOptionTest[0].endorsementToFirstGradeResultGradeset, examOption1.endorsementToFirstGradeResultGradeset)
        assertEquals( examOptionTest[0].endorsementToSecondGradeResultGradeset, examOption1.endorsementToSecondGradeResultGradeset)
        assertEquals( examOptionTest[0].maxMarkUms, examOption1.maxMarkUms)
        assertEquals( examOptionTest[0].noOfComponents, examOption1.noOfComponents)
        assertEquals( examOptionTest[0].examTypeCertId, examOption1.examTypeCert.examTypeId)
        assertEquals( examOptionTest[1].id, examOption2.id );
        assertEquals( examOptionTest[1].optionEntryCode, examOption2.optionEntryCode)
        assertEquals( examOptionTest[1].syllabusId, examOption2.syllabus.id)
        assertEquals( examOptionTest[1].process, examOption2.process)
        assertEquals( examOptionTest[1].qcaClassificationCode, examOption2.qcaClassificationCode)
        assertEquals( examOptionTest[1].qcaAccreditationNo, examOption2.qcaAccreditationNo)
        assertEquals( examOptionTest[1].optionTitle, examOption2.optionTitle )
        assertEquals( examOptionTest[1].feeDefined, examOption2.feeDefined)
        assertEquals( examOptionTest[1].examinationFee, examOption2.examinationFee)
        assertEquals( examOptionTest[1].firstForecastGradeGradeset, examOption2.firstForecastGradeGradeset)
        assertEquals( examOptionTest[1].secondForecastGradeGradeset, examOption2.secondForecastGradeGradeset)
        assertEquals( examOptionTest[1].resultType, examOption2.resultType)
        assertEquals( examOptionTest[1].firstGradeResultGradeset, examOption2.firstGradeResultGradeset)
        assertEquals( examOptionTest[1].secondGradeResultGradeset, examOption2.secondGradeResultGradeset)
        assertEquals( examOptionTest[1].endorsementToFirstGradeResultGradeset, examOption2.endorsementToFirstGradeResultGradeset)
        assertEquals( examOptionTest[1].endorsementToSecondGradeResultGradeset, examOption2.endorsementToSecondGradeResultGradeset)
        assertEquals( examOptionTest[1].maxMarkUms, examOption2.maxMarkUms)
        assertEquals( examOptionTest[1].noOfComponents, examOption2.noOfComponents)
        assertEquals( examOptionTest[1].examTypeCertId, examOption2.examTypeCert.examTypeId)
    }
    
    @Test
    public void testEquals_Same() {
        ExamOptionDto examOptionDto1 = new ExamOptionDto(examOption1)
        ExamOptionDto examOptionDto2 = new ExamOptionDto(examOption1)
        assertEquals( examOptionDto1, examOptionDto2)
    }
    
    @Test
    public void testEquals_Different() {
        ExamOptionDto examOptionDto1 = new ExamOptionDto(examOption1)
        ExamOptionDto examOptionDto2 = new ExamOptionDto(examOption2)
        assertNotEquals( examOptionDto1, examOptionDto2)
    }
    
    @Test
    public void testHashCode_Same() {
        ExamOptionDto examOptionDto1 = new ExamOptionDto(examOption1)
        ExamOptionDto examOptionDto2 = new ExamOptionDto(examOption1)
        assertEquals( examOptionDto1.hashCode(), examOptionDto2.hashCode())
    }
    
    @Test
    public void testHashCode_Different() {
        ExamOptionDto examOptionDto1 = new ExamOptionDto(examOption1)
        ExamOptionDto examOptionDto2 = new ExamOptionDto(examOption2)
        assertNotEquals( examOptionDto1.hashCode(), examOptionDto2.hashCode())
    }
    
    @Test
    public void testConstructor_ExamOption() {
        ExamOptionDto examOptionTest = new ExamOptionDto(examOption1)
        assertEquals( examOptionTest.id, examOption1.id );
        assertEquals( examOptionTest.optionEntryCode, examOption1.optionEntryCode)
        assertEquals( examOptionTest.syllabusId, examOption1.syllabus.id)
        assertEquals( examOptionTest.examTypeQualificationCert, examOption1.examTypeQualificationCert)
        assertEquals( examOptionTest.examTypeLevelCert, examOption1.examTypeLevelCert)
        assertEquals( examOptionTest.process, examOption1.process)
        assertEquals( examOptionTest.qcaClassificationCode, examOption1.qcaClassificationCode)
        assertEquals( examOptionTest.optionTitle, examOption1.optionTitle )
        assertEquals( examOptionTest.feeDefined, examOption1.feeDefined)
        assertEquals( examOptionTest.examinationFee, examOption1.examinationFee)
        assertEquals( examOptionTest.firstForecastGradeGradeset, examOption1.firstForecastGradeGradeset)
        assertEquals( examOptionTest.secondForecastGradeGradeset, examOption1.secondForecastGradeGradeset)
        assertEquals( examOptionTest.resultType, examOption1.resultType)
        assertEquals( examOptionTest.firstGradeResultGradeset, examOption1.firstGradeResultGradeset)
        assertEquals( examOptionTest.secondGradeResultGradeset, examOption1.secondGradeResultGradeset)
        assertEquals( examOptionTest.endorsementToFirstGradeResultGradeset, examOption1.endorsementToFirstGradeResultGradeset)
        assertEquals( examOptionTest.endorsementToSecondGradeResultGradeset, examOption1.endorsementToSecondGradeResultGradeset)
        assertEquals( examOptionTest.maxMarkUms, examOption1.maxMarkUms)
        assertEquals( examOptionTest.noOfComponents, examOption1.noOfComponents)
        assertEquals( examOptionTest.examTypeCertId, examOption1.examTypeCert.examTypeId)
    }
    
    @Test
    public void testConstructor_NullAcademicYear() {
        ExamOptionDto examOptionTest = new ExamOptionDto(examOption3)
        assertEquals( examOptionTest.id, examOption3.id );
        assertEquals( examOptionTest.optionEntryCode, examOption3.optionEntryCode)
        assertEquals( examOptionTest.syllabusId, examOption3.syllabus)
        assertEquals( examOptionTest.process, examOption3.process)
        assertEquals( examOptionTest.qcaClassificationCode, examOption3.qcaClassificationCode)
        assertEquals( examOptionTest.qcaAccreditationNo, examOption3.qcaAccreditationNo)
        assertEquals( examOptionTest.optionTitle, examOption3.optionTitle )
        assertEquals( examOptionTest.feeDefined, examOption3.feeDefined)
        assertEquals( examOptionTest.examinationFee, examOption3.examinationFee)
        assertEquals( examOptionTest.firstForecastGradeGradeset, examOption3.firstForecastGradeGradeset)
        assertEquals( examOptionTest.secondForecastGradeGradeset, examOption3.secondForecastGradeGradeset)
        assertEquals( examOptionTest.resultType, examOption3.resultType)
        assertEquals( examOptionTest.firstGradeResultGradeset, examOption3.firstGradeResultGradeset)
        assertEquals( examOptionTest.secondGradeResultGradeset, examOption3.secondGradeResultGradeset)
        assertEquals( examOptionTest.endorsementToFirstGradeResultGradeset, examOption3.endorsementToFirstGradeResultGradeset)
        assertEquals( examOptionTest.endorsementToSecondGradeResultGradeset, examOption3.endorsementToSecondGradeResultGradeset)
        assertEquals( examOptionTest.maxMarkUms, examOption3.maxMarkUms)
        assertEquals( examOptionTest.noOfComponents, examOption3.noOfComponents)
    }
}
