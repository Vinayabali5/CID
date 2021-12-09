package uk.ac.reigate.services.exams.basedata.fileprocessor

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import uk.ac.reigate.domain.exams.ExamBoard
import uk.ac.reigate.domain.exams.basedata.ExamComponent
import uk.ac.reigate.domain.exams.basedata.ExamOption
import uk.ac.reigate.domain.exams.basedata.ExamSeries
import uk.ac.reigate.domain.exams.basedata.OptionComponent
import uk.ac.reigate.domain.exams.basedata.OptionComponentPk
import uk.ac.reigate.services.exams.ExamBoardService
import uk.ac.reigate.services.exams.basedata.ExamComponentService
import uk.ac.reigate.services.exams.basedata.ExamOptionService
import uk.ac.reigate.services.exams.basedata.ExamSeriesService
import uk.ac.reigate.services.exams.basedata.OptionComponentService

@Component
class OptionComponentLinkFileProcessor extends BasicFileProcessor implements IEdiFileProcessor {
    
    private static Logger LOGGER = LoggerFactory.getLogger("OptionComponentLinkFileProcessor");
    
    @Autowired
    ExamBoardService examBoardService
    
    @Autowired
    ExamSeriesService examSeriesService
    
    @Autowired
    ExamOptionService examOptionService
    
    @Autowired
    ExamComponentService examComponentService
    
    @Autowired
    OptionComponentService optionComponentService
    
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
                        String componentCode = line[8..19].trim()
                        LOGGER.debug("Line: $line")
                    
                        ExamOption option = examOptionService.findByExamSeriesAndCode(examSeries, optionCode)
                        ExamComponent component = examComponentService.findByExamSeriesAndCode(examSeries, componentCode)
                    
                        if (option != null && component != null) {
                            OptionComponent optionComponent = optionComponentService.findById(new OptionComponentPk(option, component))
                            
                            if (optionComponent == null) {
                                LOGGER.info("Creating Option Component Link: $optionCode, $componentCode")
                                optionComponent = new OptionComponent()
                            } else {
                                LOGGER.info("Updating Option Component Link: $optionCode, $componentCode")
                            }
                            optionComponent.examOption = option
                            optionComponent.examComponent = component
                            optionComponentService.save(optionComponent)
                            
                        } else {
                            
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
