package uk.ac.reigate.services.exams.basedata.fileprocessor

abstract class BasicFileProcessor implements IEdiFileProcessor {
    
    /**
     * This is the file to process.
     */
    protected File file
    
    /**
     * This is used to determine if the file was processed successfully.
     */
    protected Boolean success
    
    /**
     * This method is used to set the File to be use for processing.
     *
     * @param file A File to be processed.
     */
    void setFile(File file) {
        this.success = null
        this.file = file
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
}
