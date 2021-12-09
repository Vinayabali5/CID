package uk.ac.reigate.repositories.staff

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.staff.StaffPayment

interface StaffPaymentRepository extends CrudRepository<StaffPayment, Integer> {
    
    List<StaffPayment> findByStaff_Id(Integer staffId)
}
