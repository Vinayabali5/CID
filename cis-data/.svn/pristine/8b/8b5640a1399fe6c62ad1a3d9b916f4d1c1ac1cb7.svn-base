package uk.ac.reigate.repositories.staff

import org.springframework.data.repository.CrudRepository

import uk.ac.reigate.domain.staff.StaffAbsence
import uk.ac.reigate.domain.staff.StaffInsetCourse

interface StaffInsetCourseRepository extends CrudRepository<StaffInsetCourse, Integer> {
    
    List<StaffInsetCourse> findByStaff_Id(Integer staffId)
}
