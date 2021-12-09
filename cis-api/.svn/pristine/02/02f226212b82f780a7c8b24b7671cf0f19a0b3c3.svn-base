package uk.ac.reigate.services.exams.basedata.fileprocessor

import java.text.SimpleDateFormat

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.exams.ExamBoardService
import uk.ac.reigate.services.exams.basedata.ExamComponentService
import uk.ac.reigate.services.exams.basedata.ExamSeriesService
import uk.ac.reigate.services.exams.basedata.SyllabusService

@Component
class ComponentFileProcessor extends BasicFileProcessor implements IEdiFileProcessor {
    
    private static Logger LOGGER = LoggerFactory.getLogger("ComponentFileProcessor");
    
    @Autowired
    ExamBoardService examBoardService
    
    @Autowired
    ExamSeriesService examSeriesService
    
    @Autowired
    SyllabusService syllabusService
    
    @Autowired
    ExamComponentService examComponentService
    
    @Autowired
    AcademicYearService academicYearService
    
    @Override
    public void process() {
        FileReader fileReader
        BufferedReader bufferedReader
        SimpleDateFormat dateformat = new SimpleDateFormat("ddMMyy");
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
                        String componentCode = line[2..13].trim()
                        String componentTitle = line[14..49].trim()
                        String teacherMarks = line[50]
                        String maxMark = line[51..53].trim()
                        String componentGradeset = line[54..57].trim()
                        String dueDate = line[58..63].trim()
                        String timetabled = line[64].trim()
                        String timetableDate = line[65..70].trim()
                        String timetableSession = line[71]
                        String timeAllowed = line[72..74].trim()
                    
                        LOGGER.debug("Line: $line")
                    
                        ExamComponent component
                    
                        component = examComponentService.findByExamSeriesAndCode(examSeries, componentCode)
                    
                        if (component == null) {
                            LOGGER.info("Creating Exam Component: $componentCode, $componentTitle")
                            component = new ExamComponent()
                        } else {
                            LOGGER.info("Updating Exam Component: $componentCode, $componentTitle")
                        }
                        component.examSeries = examSeries
                        component.code = componentCode
                        component.title = componentTitle
                        component.teacherMarks = teacherMarks
                        component.maximumMark = maxMark != null && maxMark != "" ? maxMark.toInteger() : null
                        component.gradeset = componentGradeset
                        component.dueDate = dueDate != null && dueDate != "" ? dateformat.parse(dueDate) : null
                        component.timetabled = timetabled
                        if (timetabled != "N") {
                            component.timetableDate = timetableDate != null && timetableDate != '' ? dateformat.parse(timetableDate) : null
                            component.timetableSession = timetableSession
                            component.timeAllowed = timeAllowed.toInteger()
                        }
                    
                        examComponentService.save(component)
                    
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
