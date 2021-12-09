package uk.ac.reigate.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import uk.ac.reigate.domain.PersonAlias
import uk.ac.reigate.repositories.PersonAliasRepository

@Service
class PersonAliasService {
    
    @Autowired
    PersonAliasRepository personAliasRepository
    
    PersonAliasService() {}
    
    PersonAliasService(PersonAliasRepository personAliasRepository){
        this.personAliasRepository = personAliasRepository;
    }
    
    PersonAlias findByPersonUsername(String username) {
        return personAliasRepository.findByPersonUsername(username)
    }
}
