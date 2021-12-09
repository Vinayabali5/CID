package uk.ac.reigate.repositories.admissions

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.academic.Student;
import uk.ac.reigate.domain.admissions.CollegeFundPayment


interface CollegeFundPaymentRepository extends CrudRepository<CollegeFundPayment, Integer>{
    
    List<CollegeFundPayment> findByStudent(Student student)
    
    List<CollegeFundPayment> findByStudent_Id(Integer id)
}
