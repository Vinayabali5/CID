package uk.ac.reigate.repositories.staffsignin

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.staffsignin.StaffSignin

interface StaffSigninRepository extends PagingAndSortingRepository<StaffSignin, Integer> {
    
    List<StaffSignin> findByStaff_Id(Integer staffId)
    
    @Query("select s from StaffSignin as s where s.staff = :staff and cast(cast(signinTime as date) as timestamp) = :signinDate")
    StaffSignin findByStaffAndDate(@Param(value = 'staff') Staff staff, @Param(value = 'signinDate') Date signinDate)
    
    @Query("select s from StaffSignin as s where s.staff = :staff and cast(cast(signinTime as date) as timestamp) = :signinDate and signoutTime is null")
    StaffSignin findByStaffAndDateAndSigoutTimeIsNull(@Param(value = 'staff') Staff staff, @Param(value = 'signinDate') Date signinDate)
}
