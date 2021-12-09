package uk.ac.reigate.services.exams.basedata.fileprocessor

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import uk.ac.reigate.services.exams.basedata.BaseDataFileTypes

@Component
class BaseDataFileProcessor implements IEdiFileProcessor {
    
    private static Logger LOGGER = LoggerFactory.getLogger("BaseDataFileProcessor");
    
    @Autowired
    SyllabusFileProcessor syllabusFileProcessor
    
    @Autowired
    OptionFileProcessor optionFileProcessor
    
    @Autowired
    ComponentFileProcessor componentFileProcessor
    
    @Autowired
    OptionComponentLinkFileProcessor optionComponentLinkFileProcessor
    
    private Boolean success
    
    private Map<BaseDataFileTypes, File> baseDataFiles
    
    /**
     * Default NoArgs constructor
     */
    BaseDataFileProcessor() {
        reset()
    }
    
    /**
     * This method is used to add a file to the BaseDataFileProcessor file collection. To add a file you 
     * need to specify the type of file. Options available for the type are Syllabus, Options, Components, 
     * or Links.
     * 
     * @param type a String describing the type of file to add to the BaseDataFileProcessor collection.
     * @param file the File object to add
     */
    void addFile(BaseDataFileTypes type, File file) {
        if (type != null) {
            if (baseDataFiles[type] != null) {
                LOGGER.warn("Replacing the current $type file with " + file.getName())
            }
            if (file.name.startsWith(type.startingCharacter)) {
                baseDataFiles[type] = file
            } else {
                throw new Exception("The file supplied $file.name is not valid for the file type " + type.type)
            }
        } else {
            String message = "Invalid File Type specified. Available options are: Syllabus, Options, Components, or Links."
            LOGGER.error(message)
            throw new Exception(message)
        }
    }
    
    /**
     * This method is used to reset the Base Data File Processor.
     */
    void reset() {
        setSuccess(false)
        baseDataFiles = new HashMap<BaseDataFileTypes, File>()
        for (BaseDataFileTypes baseDataFileType : BaseDataFileTypes.values()) {
            baseDataFiles[baseDataFileType] = null
        }
    }
    
    /**
     * This method is used to check that all the require files have been added to the base data files collection.
     * 
     * @return true if all files are present, false if any of the files are missing. 
     */
    Boolean checkFiles() {
        Boolean allPresentAndCorrect = true
        for (BaseDataFileTypes baseDataFileType : BaseDataFileTypes.values()) {
            if (baseDataFiles[baseDataFileType] == null || !baseDataFiles[baseDataFileType] instanceof File) {
                allPresentAndCorrect = false
            }
        }
        return allPresentAndCorrect
    }
    
    /**
     * This method is used to set the success of the file processor.
     *
     * @param success a Boolean value for the new value of success.
     */
    void setSuccess(Boolean success) {
        this.success = success
    }
    
    /**
     * This method is used to retrieve the success property.
     *
     * @return the value of the success property.
     */
    boolean getSuccess() {
        return this.success
    }
    
    /**
     * This method is used to process the base data file collection and import all data into the database.
     */
    void process() {
        setSuccess(false)
        if (checkFiles()) {
            // Process Syllabus
            syllabusFileProcessor.setFile(baseDataFiles[BaseDataFileTypes.SYLLABUS])
            syllabusFileProcessor.process()
            if (!syllabusFileProcessor.success) {
                throw new Exception("Failed to process Syllabus")
            }
            
            // Process Options
            optionFileProcessor.setFile(baseDataFiles[BaseDataFileTypes.OPTION])
            optionFileProcessor.process()
            if (!optionFileProcessor.success) {
                throw new Exception("Failed to process Options")
            }
            
            // Process Components
            componentFileProcessor.setFile(baseDataFiles[BaseDataFileTypes.COMPONENT])
            componentFileProcessor.process()
            if (!componentFileProcessor.success) {
                throw new Exception("Failed to process Components")
            }
            
            // Process Option Component Links
            optionComponentLinkFileProcessor.setFile(baseDataFiles[BaseDataFileTypes.LINK])
            optionComponentLinkFileProcessor.process()
            if (!optionComponentLinkFileProcessor.success) {
                throw new Exception("Failed to process Links")
            }
            setSuccess(true)
        } else {
            setSuccess(false)
            throw new Exception("Cannot process as not all files have been supplied.")
        }
    }
}
