package uk.ac.reigate.repositories.staff

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.staff.StaffAbsence
import uk.ac.reigate.domain.staffsignin.StaffSignin

interface StaffAbsenceRepository extends CrudRepository<StaffAbsence, Integer> {
    
    List<StaffAbsence> findByStaff_Id(Integer staffId)
}
