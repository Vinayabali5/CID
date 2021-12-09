package uk.ac.reigate.api.student

import java.nio.file.Files
import java.nio.file.Path

import javax.servlet.http.HttpServletResponse

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

import io.swagger.annotations.Api
import uk.ac.reigate.dto.student.StudentFileDto
import uk.ac.reigate.services.student.StudentFilesService

@Controller
@RequestMapping(value = "/student-files", produces = [ MediaType.APPLICATION_JSON_VALUE ])
@Api(value = "StudentFilesApi", description = "This is the Student Files API")
class StudentFilesApi {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentFilesApi.class);
    
    @Autowired
    StudentFilesService studentFilesService
    
    /**
     * This method is used to retrieve details about the student files.
     * 
     * @param studentId The StudentID to use for finding the files.
     * @return A list of StudentFileDto object for the files found in the folder.
     */
    @GetMapping('/{studentId}')
    ResponseEntity<List<StudentFileDto>> getStudentFileList(@PathVariable Integer studentId) {
        List<StudentFileDto> studentFiles = studentFilesService.getStudentFileList(studentId)
        return new ResponseEntity<StudentFileDto>(studentFiles, HttpStatus.OK)
    }
    
    /**
     * This method is used to retrieve the specified student file from the file system and return it to the user for viewing.
     *
     * @param response This object is used to construct the HTTP Response for the request.
     * @param studentId This is the student ID for the file to retrieve.
     * @param filename This is the filename for the file to retrieve.
     * @throws IOException If there are any issues when retrieving the file an IOException will be thrown.
     */
    @PostMapping('/retrieve')
    void retrieveStudentFile(
            HttpServletResponse response,
            @RequestBody StudentFileDto fileInfo
    ) {
        Path file = studentFilesService.getStudentFile(fileInfo)
        if (file != null) {
            String mimeType = Files.probeContentType(file);
            response.setContentType(mimeType);
            response.addHeader("Content-Disposition", "attachment; filename=" + fileInfo.filename);
            try {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * This method is used to upload files for a specific student in the supplied folder.
     *
     * @param studentId The studentId to use for the storage path.
     * @param fileCategoryId The FileCategory to use for the storage path.
     * @param file The MultipartFile to store.
     */
    @PostMapping(value = "/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam("studentId") Integer studentId,
            @RequestParam("fileCategoryId") Integer fileCategoryId,
            @RequestPart("file") MultipartFile file) {
        try {
            studentFilesService.storeFile(studentId, fileCategoryId, file)
            return new ResponseEntity<?>(HttpStatus.OK)
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
