package uk.ac.reigate.api.exams.basedata

import java.util.regex.Pattern

import javax.annotation.PostConstruct

import com.fasterxml.jackson.annotation.JsonProperty

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

import uk.ac.reigate.services.exams.basedata.BaseDataFileTypes
import uk.ac.reigate.services.exams.basedata.fileprocessor.BaseDataFileProcessor

import lombok.Builder
import lombok.NoArgsConstructor

@NoArgsConstructor
@Builder
class BaseDataMessage {
    @JsonProperty
    String message
}

@Controller
class BaseDataUploadController {
    
    private static Logger LOGGER = LoggerFactory.getLogger("BaseDataUploadController");
    
    public static final String uploadingdir = System.getProperty("user.dir") + "/uploads/";
    
    @Autowired
    BaseDataFileProcessor baseDataFileProcessor
    
    @PostConstruct
    void init(){
        LOGGER.info("The folder to store file in is: $uploadingdir")
    }
    
    @RequestMapping(value = "/upload/basedata", method = RequestMethod.POST)
    public ResponseEntity<String> uploadingPost(MultipartHttpServletRequest request) throws IOException {
        Map<String, MultipartFile> fileMap = request.getFileMap();
        
        String output = ""
        Boolean foundSyllabusFile = false
        Boolean foundOptionFile = false
        Boolean foundComponentFile = false
        Boolean foundLinkFile = false
        
        Pattern pattern = Pattern.compile("[SOCLsocl]{1}[0-9A-Ca-c].[0-9][0-9].[0-9][0-9]\\.[Xx][0-9][0-9]")
        baseDataFileProcessor.reset()
        
        for(MultipartFile uploadedFile : fileMap.values()) {
            String filename = uploadedFile.getOriginalFilename()
            if (filename.matches(pattern)) {
                LOGGER.info("Found a BaseData File: $filename. Saving to the upload folder.")
                String startingChar = filename[0]
                output += "Added file: $filename. \n"
                File file = new File(uploadingdir + uploadedFile.getOriginalFilename());
                uploadedFile.transferTo(file);
                switch (startingChar.toUpperCase()) {
                    case BaseDataFileTypes.SYLLABUS.startingCharacter:
                        foundSyllabusFile = true
                        baseDataFileProcessor.addFile(BaseDataFileTypes.SYLLABUS, file)
                        break;
                    case BaseDataFileTypes.OPTION.startingCharacter:
                        foundOptionFile = true
                        baseDataFileProcessor.addFile(BaseDataFileTypes.OPTION, file)
                        break;
                    case BaseDataFileTypes.COMPONENT.startingCharacter:
                        foundComponentFile= true
                        baseDataFileProcessor.addFile(BaseDataFileTypes.COMPONENT, file)
                        break;
                    case BaseDataFileTypes.LINK.startingCharacter:
                        foundLinkFile = true
                        baseDataFileProcessor.addFile(BaseDataFileTypes.LINK, file)
                        break;
                }
            } else {
                output += "File: $filename does not match the require filename pattern. \n"
            }
        }
        if (foundSyllabusFile && foundOptionFile && foundComponentFile && foundLinkFile) {
            output += 'All required files have been supplied. Begining processing.'
            baseDataFileProcessor.process()
            if (baseDataFileProcessor.success) {
                return new ResponseEntity<BaseDataMessage>(new BaseDataMessage(message: output), HttpStatus.OK)
            } else {
                return new ResponseEntity<BaseDataMessage>(new BaseDataMessage(message: output), HttpStatus.BAD_REQUEST)
            }
        } else {
            output += 'Not all required files have been supplied. Cannot process the import without all the files.'
            return new ResponseEntity<BaseDataMessage>(new BaseDataMessage(message: output), HttpStatus.BAD_REQUEST)
        }
    }
}
