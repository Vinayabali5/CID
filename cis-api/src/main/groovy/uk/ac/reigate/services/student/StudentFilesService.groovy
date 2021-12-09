package uk.ac.reigate.services.student

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.attribute.BasicFileAttributeView
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.attribute.FileTime

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

import uk.ac.reigate.domain.lookup.FileCategory
import uk.ac.reigate.dto.student.StudentFileDto
import uk.ac.reigate.services.lookup.FileCategoryService

/**
 * <p>This service is use for retrieving file lists and files for students. These will be stored in the following 
 * folder format:</p> 
 * 
 * <pre>{file-store.student-files}/{Student ID}/{Category Name}/{File}</pre>
 * 
 * <p>The {file-store.student-files} parameter is set in the application-{profile}.yml file.</p>
 * 
 * @author Michael Horgan
 *
 */
@Service
class StudentFilesService {
    
    @Autowired
    FileCategoryService fileCategoryService
    
    @Value(value = '${file-store.student-files}')
    private String path
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentFilesService.class);
    /**
     * This method is used to retrieve a list of file that are located in the student specific folder and 
     * the specified category folder. 
     * 
     * @param studentId The student ID for the specific folder. 
     * @param category The category folder to retrieve file from.
     * @return A List of StudentFieDto object detailing the file details. 
     */
    List<StudentFileDto> getStudentFileListByCategory(Integer studentId, String category) {
        String folderName
        if (category != null) {
            folderName = path + '/' + studentId.toString() + '/' + category
        } else {
            folderName = path + '/' + studentId.toString()
        }
        File folder = new File(folderName)
        if (folder.exists()) {
            File[] files = folder.listFiles()
            
            List<StudentFileDto> studentFiles =	files.collect { File it ->
                Path file = it.toPath();
                BasicFileAttributes view = Files.getFileAttributeView(file, BasicFileAttributeView.class).readAttributes();
                Long mDate = view.lastModifiedTime().toMillis()
                Long cDate = view.creationTime().toMillis()
                Date modifiedDate = new Date(mDate);
                Date createdDate = new Date(cDate);
                String mimeType = Files.probeContentType(file);
                if (Files.isDirectory(file)) {
                    if (category == null) {
                        getStudentFileListByCategory(studentId, it.name)
                    } else {
                        getStudentFileListByCategory(studentId, category + '/' +it.name)
                    }
                } else {
                    new StudentFileDto(studentId: studentId, filename: it.name, mimeType: mimeType, category: category, modifiedDate: modifiedDate, createdDate: createdDate)
                }
            }
            return studentFiles.flatten()
        } else {
            // TODO: add new exception to thrown and handle
        }
    }
    
    /**
     * This method is used to retrieve a list of file that are located in the student specific folder.
     *  
     * @param studentId The student ID for the specific folder. 
     * @return A List of StudentFieDto object detailing the file details. 
     */
    List<StudentFileDto> getStudentFileList(Integer studentId) {
        List<StudentFileDto> studentFiles = getStudentFileListByCategory(studentId, null)
        return studentFiles
    }
    
    /**
     * This method is used to retrieve a student file based on the StudentFileDto information supplied. 
     * 
     * @param fileInfo The StudentFileDto object the represents a specific student file.
     * @return The Path object for the specified file. 
     */
    Path getStudentFile(StudentFileDto fileInfo) {
        String folder = path + '/' + fileInfo.studentId.toString()
        if (fileInfo.category != null) {
            folder += '/' + fileInfo.category
        }
        Path file = new File(folder + '/' + fileInfo.filename).toPath();
        String mimeType = Files.probeContentType(file);
        if (Files.exists(file)) {
            return file
        } else {
            return null
        }
    }
    
    /**
     * This method is used to store the Student uploaded files to the file system 
     * 
     * @param studentId The studentId to use for the storage path.
     * @param fileCategoryId The FileCategory to use for the storage path.
     * @param file The MultipartFile to store.
     */
    void storeFile(Integer studentId, Integer fileCategoryId, MultipartFile file) {
        if(fileCategoryId != null) {
            FileCategory fileCategory = fileCategoryService.findById(fileCategoryId)
            
            String path = "$path/$studentId/$fileCategory.description"
            File uploadFolder = new File(path);
            //TODO: add exception handling
            if (!uploadFolder.exists()) {
                uploadFolder.mkdirs()
            }
            String actualFilename = Paths.get(file.getOriginalFilename()).getFileName()
            if (actualFilename.contains("/") || actualFilename.contains("\\") || actualFilename.contains(":")) {
                LOGGER.info("Actual Filename '$actualFilename' not in correct format")
                actualFilename = actualFilename.replace("\\", "/")
                actualFilename = actualFilename.substring(actualFilename.lastIndexOf("/"))
                LOGGER.info("Actual Filename - post parse: '$actualFilename'")
            }
            String filename = path + "/" + actualFilename
            LOGGER.info("Upload for student ID: $studentId, original file: $file.originalFilename, destination: $filename")
            File uploadFile = new File(filename)
            uploadFile.createNewFile()
            FileOutputStream fileOutput = new FileOutputStream(uploadFile)
            fileOutput.write(file.getBytes())
            fileOutput.close()
            LOGGER.info("File successfully stored: $filename")
        }
        
    }
}
