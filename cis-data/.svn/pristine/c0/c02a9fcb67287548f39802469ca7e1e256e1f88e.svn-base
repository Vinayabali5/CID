package uk.ac.reigate.repositories.learning_support

import java.util.List;

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.StudentEntryQualification;
import uk.ac.reigate.domain.learning_support.StudentSpecialCategory

interface StudentSpecialCategoryRepository extends CrudRepository<StudentSpecialCategory, Integer> {
    
    List<StudentSpecialCategory> findByStudent_Id(Integer studentId)
}
