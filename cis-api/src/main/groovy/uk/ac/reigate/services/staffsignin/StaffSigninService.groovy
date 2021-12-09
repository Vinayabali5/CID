package uk.ac.reigate.services.staffsignin

import java.text.SimpleDateFormat

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.Staff
import uk.ac.reigate.domain.staffsignin.StaffSignin
import uk.ac.reigate.exceptions.InvalidDataException
import uk.ac.reigate.repositories.staffsignin.StaffSigninRepository
import uk.ac.reigate.services.StaffService

@Service
class StaffSigninService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StaffSigninService.class);
    
    @Autowired
    StaffSigninRepository staffSigninRepository
    
    @Autowired
    StaffService staffService
    
    StaffSignin findById(Integer id) {
        return staffSigninRepository.findById(id).orElse(null)
    }
    
    List<StaffSignin> findByStaff(Integer staffId) {
        return staffSigninRepository.findByStaff_Id(staffId);
    }
    
    StaffSignin findByStaffAndDate(Staff staff, Date date) {
        return staffSigninRepository.findByStaffAndDate(staff, date)
    }
    
    StaffSignin findByStaffAndDateMultiple(Staff staff, Date date) {
        return staffSigninRepository.findByStaffAndDateAndSigoutTimeIsNull(staff, date)
    }
    
    StaffSignin save(StaffSignin staffSignin) {
        return staffSigninRepository.save(staffSignin)
    }
    
    
    
    boolean signInOutStaff(Person person) {
        Staff staff = staffService.findByPerson(person)
        if (staff == null) {
            throw new InvalidDataException("Cannot find a matching member of staff.")
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(sdf.format(new Date()));
        StaffSignin signin = findByStaffAndDateMultiple(staff, date)
        if (signin == null) {
            LOGGER.debug("Staff Signin Required")
            signin = new StaffSignin()
            signin.staff = staff
            signin.signinTime = new Date()
        } else {
            LOGGER.debug("Staff Signout Required")
            signin.signoutTime = new Date()
        }
        return save(signin)
    }
}
