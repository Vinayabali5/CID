package uk.ac.reigate.api

import org.springframework.http.ResponseEntity

public interface IStudentDataApi<DTO, ID> extends IStudentDataRetrievalApi {
    
    ResponseEntity<DTO> createForStudent(Integer studentId, DTO dto)
    
    ResponseEntity<DTO> updateForStudent(Integer studentId, ID id, DTO dto)
}
