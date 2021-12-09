package uk.ac.reigate.services.exams.basedata.fileprocessor

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.domain.exams.basedata.Syllabus
import uk.ac.reigate.services.exams.ExamBoardService
import uk.ac.reigate.services.exams.basedata.ExamOptionService
import uk.ac.reigate.services.exams.basedata.ExamSeriesService
import uk.ac.reigate.services.exams.basedata.SyllabusService

@Component
class OptionFileProcessor extends BasicFileProcessor implements IEdiFileProcessor {
    
    private static Logger LOGGER = LoggerFactory.getLogger("OptionFileProcessor");
    
    @Autowired
    ExamBoardService examBoardService
    
    @Autowired
    ExamSeriesService examSeriesService
    
    @Autowired
    SyllabusService syllabusService
    
    @Autowired
    ExamOptionService examOptionService
    
    @Override
    public void process() {
        FileReader fileReader
        BufferedReader bufferedReader
        try {
            Boolean examSeriesExists
            
            fileReader = new FileReader(file)
            bufferedReader = new BufferedReader(fileReader);
            String filename = file.getName()
            
            String examYearCode = '20' + filename[3..4]
            String examSeriesCode = filename[1..2]
            
            String boardIdentifier = filename[6..7]
            ExamBoard examBoard = examBoardService.findByBoardIdentifier(boardIdentifier)
            
            ExamSeries examSeries = examSeriesService.findByExamBoardYearAndSeries(examBoard, examYearCode, examSeriesCode)
            if (examSeries == null) {
                // TODO: Add proper error handling when the exam series cannot be found.
            }
            
            List<String> lines = bufferedReader.readLines()
            lines.each { line ->
                switch (line[1]) {
                    case '1': // File Header
                        break;
                    case '3': // Institution Header
                        break;
                    case '5': // Syllabus Lines
                        String dataType = line[0]
                        String recordType = line[1]
                        String optionCode = line[2..7].trim()
                        String syllabusCode = line[8..13].trim()
                        String examTypeQual = line[14..17].trim()
                        String examTypeLevel = line[18..20].trim()
                        String examTypeItem = line[21].trim()
                        String examTypeQualUnit = line[22..25].trim()
                        String examTypeLevelUnit = line[26..28].trim()
                        String examTypeProgress = line[29]
                        String qcaClassificationCode = line[30..33].trim()
                        String qcaAccreditationNo = line[34..41].trim()
                        String optionTitle = line[42..77].trim()
                        String feeDefined = line[78]
                        String examFee = line[79..83].trim()
                        String firstForecastGradeGradeset = line[84..87].trim()
                        String secondForecastGradeGradeset = line[88..91].trim()
                        String resultType = line[92].trim()
                        String firstGradeResultGradeset = line[93..96].trim()
                        String secondGradeResultGradeset = line[97..100].trim()
                        String endorsementToFirstGradeResultGradeset = line[101..104].trim()
                        String endorsementToSecondGradeResultGradeset = line[105..108].trim()
                        String maxMarkUms = line[109..112].trim()
                        String noOfComponents = line[113..114].trim()
                    
                        LOGGER.debug("Line: $line")
                    
                        Syllabus syllabus = syllabusService.findByExamSeriesAndSyllabusCode(examSeries, syllabusCode)
                        ExamOption option
                    
                        if (syllabus == null) {
                            LOGGER.info("Cannot find the syllabus: $s for the exam series: $s", syllabusCode, examSeries.toString())
                            syllabus = new Syllabus()
                        } else {
                            option = examOptionService.findByExamSeriesAndSyllabusAndCode(examSeries, syllabus, optionCode)
                            if (option == null) {
                                LOGGER.info("Creating Exam Option: $optionCode, $optionTitle")
                                option = new ExamOption()
                            } else {
                                LOGGER.info("Updating Exam Option: $optionCode, $optionTitle")
                            }
                            option.optionEntryCode = optionCode
                            option.syllabus = syllabus
                            
                            option.examTypeQualificationCert = examTypeQual != '' ? examTypeQual : null
                            option.examTypeLevelCert = examTypeLevel  != '' ? examTypeLevel : null
                            option.examTypeItem = examTypeItem != '' ? examTypeItem : null
                            option.examTypeQualificationUnit = examTypeQualUnit != '' ? examTypeQualUnit : null
                            option.examTypeLevelUnit = examTypeLevelUnit != '' ? examTypeLevelUnit : null
                            
                            option.process = examTypeProgress
                            
                            option.qcaClassificationCode = qcaClassificationCode != '' ? qcaClassificationCode : null
                            option.qcaAccreditationNo = qcaAccreditationNo != '' ? qcaAccreditationNo : null
                            
                            option.optionTitle = optionTitle
                            option.feeDefined = feeDefined
                            option.examinationFee = examFee != '' ? examFee.toInteger() : null
                            
                            option.firstForecastGradeGradeset = firstForecastGradeGradeset != '' ? firstForecastGradeGradeset : null
                            option.secondForecastGradeGradeset = secondForecastGradeGradeset != '' ? secondForecastGradeGradeset : null
                            option.resultType = resultType
                            option.firstGradeResultGradeset = firstGradeResultGradeset != '' ? firstGradeResultGradeset : null
                            option.secondGradeResultGradeset = secondGradeResultGradeset != '' ? secondGradeResultGradeset : null
                            option.endorsementToFirstGradeResultGradeset = endorsementToFirstGradeResultGradeset != '' ? endorsementToFirstGradeResultGradeset : null
                            option.endorsementToSecondGradeResultGradeset = endorsementToSecondGradeResultGradeset != '' ? endorsementToSecondGradeResultGradeset : null
                            option.maxMarkUms = maxMarkUms != '' ? maxMarkUms.toInteger() : null
                            option.noOfComponents = noOfComponents != '' ? noOfComponents.toInteger() : null
                            
                            examOptionService.save(option)
                        }
                    
                    
                        break;
                    case '7': // Institution Footer
                        break;
                    case '9': // File Footer
                        break;
                    default:
                        break;
                }
            }
            setSuccess(true)
        } catch (Exception e) {
            setSuccess(false)
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close()
            }
            if (fileReader != null) {
                fileReader.close()
            }
        }
    }
    
}
