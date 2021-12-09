package uk.ac.reigate.api.security

import java.security.Principal

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import uk.ac.reigate.repositories.PersonAliasRepository
import uk.ac.reigate.repositories.PersonRepository
import uk.ac.reigate.repositories.StaffRepository
import uk.ac.reigate.repositories.academic.StudentRepository
import uk.ac.reigate.services.UserService

@RestController
class AuthenticationApi {
    
    @Autowired
    PersonRepository personRepository
    
    @Autowired
    PersonAliasRepository personAliasRepository
    
    @Autowired
    StaffRepository staffRepository
    
    @Autowired
    StudentRepository studentRepository
    
    @Autowired
    UserService userService
    
    @Autowired
    Environment env
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationApi.class);
    
    @RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getUserInfo(Principal user) {
        Map<String, Object> map = new LinkedHashMap<String, Object>()
        if (user != null) {
            LOGGER.info('II User: ' + user.getName())
            String username = user.getName()
            map = userService.buildUserInfo(username)
        }
        return new ResponseEntity<?>(map, HttpStatus.OK);
    }
}
