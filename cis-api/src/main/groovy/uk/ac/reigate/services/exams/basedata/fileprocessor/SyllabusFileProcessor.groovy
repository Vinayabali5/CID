package uk.ac.reigate.services.exams.basedata.fileprocessor

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.domain.exams.basedata.Syllabus
import uk.ac.reigate.services.AcademicYearService
import uk.ac.reigate.services.exams.ExamBoardService
import uk.ac.reigate.services.exams.basedata.ExamSeriesService
import uk.ac.reigate.services.exams.basedata.SyllabusService

@Component
class SyllabusFileProcessor extends BasicFileProcessor implements IEdiFileProcessor {
    
    private static Logger LOGGER = LoggerFactory.getLogger("SyllabusFileProcessor");
    
    @Autowired
    ExamBoardService examBoardService
    
    @Autowired
    ExamSeriesService examSeriesService
    
    @Autowired
    SyllabusService syllabusService
    
    @Autowired
    AcademicYearService academicYearService
    
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
                examSeriesExists = false
                examSeries = new ExamSeries()
                examSeries.academicYear = academicYearService.getCurrentAcademicYear()
                examSeries.examBoard = examBoard
                examSeries.examSeries = examSeriesCode
                examSeries.examYear = examYearCode
                examSeries = examSeriesService.save(examSeries)
            } else {
                examSeriesExists = true
            }
            
            List<String> lines = bufferedReader.readLines()
            lines.each { line ->
                switch (line[1]) {
                    case '1': // File Header
                        break;
                    case '3': // Institution Header
                        break;
                    case '5': // Syllabus Lines
                        String dataType = line[0]                       //.substring(0, 1)
                        String recordType = line[1]                     //.substring(1, 2)
                        String syllabusCode = line[2..7].trim()     //.substring(2, 7).trim()
                        String syllabusTitle = line[9..43].trim()   //.substring(9, 44).trim()
                        LOGGER.debug("Line: $line")
                        Syllabus syllabus
                        if (examSeriesExists) {
                            syllabus = syllabusService.findByExamSeriesAndSyllabusCode(examSeries, syllabusCode)
                        }
                        if (syllabus == null) {
                            LOGGER.info("Creating Syllabus: $syllabusCode, $syllabusTitle")
                            syllabus = new Syllabus()
                        } else {
                            LOGGER.info("Updating Syllabus: $syllabusCode, $syllabusTitle")
                        }
                        syllabus.examSeries = examSeries
                        syllabus.code = syllabusCode
                        syllabus.title = syllabusTitle
                        syllabusService.save(syllabus)
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
